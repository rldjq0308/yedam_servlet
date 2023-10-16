package co.yedam.T20230905.book.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.T20230905.book.service.BookService;
import co.yedam.T20230905.book.serviceImpl.BookServiceImpl;

@WebServlet("/BookDel")
public class BookDel extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookDel() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		BookService dao = new BookServiceImpl();
		
		if(dao.bookDel(code)) {
			
		}else {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
