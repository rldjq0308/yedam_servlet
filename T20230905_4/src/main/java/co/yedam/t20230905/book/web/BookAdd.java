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
import co.yedam.t20230905.book.service.BookVO;
import co.yedam.t20230905.book.serviceImpl.BookServiceImpl;

@WebServlet("/BookAdd.do")
public class BookAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookAdd() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bkCode = request.getParameter("bkCode");
		String bkTitle = request.getParameter("bkTitle");
		String bkAuthor = request.getParameter("bkAuthor");
		String bkPress = request.getParameter("bkPress");
		String bkPrice = request.getParameter("bkPrice");

		BookVO vo = new BookVO();
		vo.setBkCode(bkCode);
		vo.setBkTitle(bkTitle);
		vo.setBkAuthor(bkAuthor);
		vo.setBkPress(bkPress);
		vo.setBkPrice(Integer.parseInt(bkPrice));

		BookService svc = new BookServiceImpl();

		Map<String, Object> map = new HashMap<>();

		if (svc.addBook(vo)) {
			map.put("retCode", "Success");
			map.put("data", vo);
		} else {
			map.put("retCode", "Fail");
			map.put("data", "처리중 에러발생");
		}

		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(map);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
