package co.micol.second.member.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.second.common.ViewsUtil;

@WebServlet("/memberlist.do")
public class MemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ViewsUtil vt = new ViewsUtil();
		String viewName = "member/memberList";
		vt.resolve(request, response, viewName);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
