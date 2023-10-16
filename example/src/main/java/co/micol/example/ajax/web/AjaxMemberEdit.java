package co.micol.example.ajax.web;

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

import co.micol.example.ajax.service.MembersService;
import co.micol.example.ajax.service.MembersVO;
import co.micol.example.ajax.serviceImpl.MembersServiceImpl;

@WebServlet("/AjaxMemberEdit.do")
public class AjaxMemberEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxMemberEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MembersService dao = new MembersServiceImpl();
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String age = request.getParameter("age");
		
		MembersVO vo = new MembersVO(Integer.parseInt(no),name,phone,Integer.parseInt(age));
		Map<String,String> map = new HashMap<>();
		
		if(dao.editMember(vo)) {
			map.put("retCode", "Success");
			map.put("result", "수정성공");
		}else {
			map.put("retCode", "Fail");
			map.put("result", "수정실패");
		}
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(map);
		
		response.setContentType("text/json; charset=utf-8");
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
