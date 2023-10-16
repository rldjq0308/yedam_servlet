package co.micol.second.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewsUtil { // 넘어온 View page를 서버에서 돌려준다
	public void resolve(HttpServletRequest request, HttpServletResponse response, String viewName)
			throws ServletException, IOException {
		viewName = "WEB-INF/views/" + viewName + ".jsp";
		//WEB-INF/views/home/home.jsp

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response);
	}
}
