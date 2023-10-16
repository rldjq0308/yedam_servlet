package co.test.exam.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.exam.common.ViewResolve;
import co.test.exam.member.service.MemberService;
import co.test.exam.member.service.MemberVO;
import co.test.exam.member.serviceImpl.MemberServiceImpl;

/**
 * Servlet implementation class MemberJoin
 */
@WebServlet("/memberjoin.do")
public class MemberJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		
		vo.setMemberId(request.getParameter("id"));
		vo.setMemberPassword(request.getParameter("pw"));
		vo.setMemberName(request.getParameter("name"));
		vo.setMemberTel(request.getParameter("tel"));
		
		System.out.println(vo.getMemberId() + "====-========" );
		
		int n = dao.memberInsert(vo);
		
		if(n==1) {
			request.setAttribute("message", "회원가입이 정상적으로 처리되었다");
		}else {
			request.setAttribute("message", "회원가입이 실패하였습니다");
		}
		
		String viewName = "member/message";
		ViewResolve.forward(request, response, viewName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
