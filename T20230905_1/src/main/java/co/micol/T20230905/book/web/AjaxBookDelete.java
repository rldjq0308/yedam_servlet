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
import co.micol.T20230905.book.serviceImpl.BookServiceImpl;

@WebServlet("/AjaxBookDelete.do")
public class AjaxBookDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AjaxBookDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");

		Map<String,Object> map = new HashMap<String, Object>();
		BookService dao = new BookServiceImpl();
		
		String result = (dao.bookDelete(code)) ? "Success" : "Fail";
		map.put("retCode", result);
		
		Gson gson = new GsonBuilder().create();
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().append(gson.toJson(map));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
