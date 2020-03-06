package hmmteresting.jiyoon.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hmmteresting.jiyoon.DAO.studentDAO;
import hmmteresting.jiyoon.model.StudentDTO;

//그냥 만든거 사용X
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String studentname = request.getParameter("name");
		String studentNo = request.getParameter("studentNo");
		String juminNo = request.getParameter("juminNo");

		// 받아온값으로 DB에 연결해서 일치하는 정보가 있으면 -> studentMain.jsp로 이동 및 섹션 생성
		studentDAO dao = new studentDAO();
		StudentDTO student = new StudentDTO();
		student = dao.login(studentname, studentNo, juminNo);

		if (student != null) {
			// 세션생성
			HttpSession session = request.getSession();
			session.setAttribute("student", student);
			session.setAttribute("studentNo", studentNo);
			session.setMaxInactiveInterval(3600);
			
			request.getRequestDispatcher("/SelectStudentGrade").forward(request, response);

		} else {
			// 로그인 오류 -> 다시 로그인페이지로
			request.setAttribute("result", "false");
			request.getRequestDispatcher("/studentLogin").forward(request, response);
		}
	}

}
