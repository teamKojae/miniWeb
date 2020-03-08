package hmmteresting.jiyoon.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hmmteresting.jiyoon.DAO.studentDAO;
import hmmteresting.jiyoon.model.GradeDTO;
import hmmteresting.jiyoon.model.StudentDTO;

@WebServlet("/SelectStudentGrade")
public class SelectStudentGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession(false);
		String studentNo = (String) httpSession.getAttribute("studentNo");
		StudentDTO student = (StudentDTO) httpSession.getAttribute("student");
		
		//성적불러오기
		studentDAO dao = new studentDAO();
		ArrayList<GradeDTO> list = new ArrayList<GradeDTO>();
		list = dao.selectGrade(studentNo);
		
		//성적을 studentMain페이지로 넘기기
		httpSession.setAttribute("studentGrades", list);
		request.getRequestDispatcher("/studentMain").forward(request, response);
		
		
		
		
		
		
		
		
	}

	
}
