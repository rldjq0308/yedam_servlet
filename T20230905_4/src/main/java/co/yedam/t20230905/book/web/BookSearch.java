package co.yedam.t20230905.book.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.t20230905.book.service.BookService;
import co.yedam.t20230905.book.service.BookVO;
import co.yedam.t20230905.book.serviceImpl.BookServiceImpl;

@WebServlet("/BookSearch.do")
public class BookSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookSearch() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bkCode = request.getParameter("bkCode");
		
		BookService svc= new BookServiceImpl();
		BookVO vo = svc.getBook(bkCode);
		
		Gson gson = new GsonBuilder().create();

		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(gson.toJson(vo));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
