package co.micol.T20230905.book.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.micol.T20230905.book.service.BookService;
import co.micol.T20230905.book.service.BookVO;
import co.micol.T20230905.book.serviceImpl.BookServiceImpl;

@WebServlet("/AjaxBookInsert.do")
public class AjaxBookInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxBookInsert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		String price = request.getParameter("price");
		
		BookVO vo = new BookVO(code,title,author,press,Integer.parseInt(price));

		Map<String,Object> map = new HashMap<String, Object>();
		BookService dao = new BookServiceImpl();
		
		if (dao.bookInsert(vo)) {
			map.put("data", vo);
			map.put("retCode", "Success");
		} else {
			map.put("data", "데이터 추가 도중 오류발생");
			map.put("retCode", "Fail");
		}
		
		Gson gson = new GsonBuilder().create();
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().append(gson.toJson(map));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
