package co.micol.example.notice.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.example.common.ViewResolve;
import co.micol.example.notice.service.NoticeService;
import co.micol.example.notice.service.NoticeVO;
import co.micol.example.notice.serviceImpl.NoticeServiceImpl;

@WebServlet("/noticelist.do")
public class NoticeList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NoticeList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> notices = new ArrayList<NoticeVO>();
		
		notices = dao.noticeSelectList();
		request.setAttribute("notices", notices);
		
		String viewName = "notice/noticelist";
		ViewResolve.forward(request, response, viewName);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
