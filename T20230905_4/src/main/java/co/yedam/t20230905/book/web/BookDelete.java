package co.yedam.t20230905.book.web;

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

import co.yedam.t20230905.book.service.BookService;
import co.yedam.t20230905.book.serviceImpl.BookServiceImpl;

@WebServlet("/BookDelete.do")
public class BookDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookDelete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bkCode = request.getParameter("bkCode");

		BookService svc = new BookServiceImpl();

		Map<String, Object> map = new HashMap<>();

		if (svc.deleteBook(bkCode)) {
			map.put("retCode", "Success");
		} else {
			map.put("retCode", "Fail");
			map.put("data", "처리중 에러발생");
		}

		Gson gson = new GsonBuilder().create();

		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(gson.toJson(map));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
