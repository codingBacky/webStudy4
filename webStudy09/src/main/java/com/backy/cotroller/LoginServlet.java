package com.backy.cotroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webStudy09.MemberDAO;
import webStudy09.MemberVO;

@WebServlet("/Login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("member/login.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String url = "member/login.jsp";
//		System.out.println(userid);
//		System.out.println(pwd);
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.userCheck(userid, pwd);
		
		if(result == 1) {//로그인 성공
		
			MemberVO vo = dao.getMember(userid);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", vo);
			System.out.println(vo);
			request.setAttribute("message", "회원가입에 성공했습니다");//메시지 출력안됨
			url = "main.jsp";
			
		}else if(result == 0) {//pwd X
			request.setAttribute("message", "비밀번호를 확인해주세요❗❗");
		}else if(result == -1) {//id X
			request.setAttribute("message", "존재하지 않는 회원입니다");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	

}
