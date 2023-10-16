package co.yedam.T20230905.book.web;

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

import co.yedam.T20230905.book.service.BookService;
import co.yedam.T20230905.book.service.BookVO;
import co.yedam.T20230905.book.serviceImpl.BookServiceImpl;

@WebServlet("/BookAdd")
public class BookAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		String price = request.getParameter("price");
		
		BookVO vo = new BookVO();
		vo.setBkCode(code);
		vo.setBkTitle(title);
		vo.setBkAuthor(author);
		vo.setBkPress(press);
		vo.setBkPrice(Integer.parseInt(price));
		
		BookService dao = new BookServiceImpl();
		Map<String,Object> map = new HashMap<>();
		
		if(dao.bookAdd(vo)) {
			map.put("res", vo);
		}else {
			map.put("res", "저장실패.");
		}
		
		Gson gson = new GsonBuilder().create();
		response.setContentType("text/json; charset=utf-8");
		response.getWriter().print(gson.toJson(map));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
