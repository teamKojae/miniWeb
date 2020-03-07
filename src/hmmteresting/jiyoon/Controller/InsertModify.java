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



//수정요청정보 DB에 insert
@WebServlet("/InsertModify")
public class InsertModify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession(false);
		String studentNo = (String) httpSession.getAttribute("studentNo");
		System.out.println(request.getParameter("examNo"));
		
		studentDAO dao = new studentDAO();
		dao.insertModify(request.getParameter("examNo"),studentNo, request.getParameter("modifyContent"));
		
		response.sendRedirect("/studentMain");
		
	}

}
