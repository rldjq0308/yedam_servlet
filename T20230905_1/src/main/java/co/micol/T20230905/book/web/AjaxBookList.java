package co.micol.T20230905.book.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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


@WebServlet("/AjaxBookList.do")
public class AjaxBookList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxBookList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService dao = new BookServiceImpl();
		List<BookVO> list = new ArrayList<BookVO>();
		list = dao.bookSelectList();
		
		Gson gson = new GsonBuilder().create();
		
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().append(gson.toJson(list));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
