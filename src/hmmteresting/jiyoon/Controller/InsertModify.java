package hmmteresting.jiyoon.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hmmteresting.jiyoon.DAO.RequestModifyDAO;



///test/InsertModify
@WebServlet("/InsertModify")
public class InsertModify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		System.out.println(request.getParameter("studentNo"));
//		System.out.println(request.getParameter("modifyContent"));
		
		RequestModifyDAO dao = new RequestModifyDAO();
		dao.insertModify(request.getParameter("studentNo"), request.getParameter("modifyContent"));
		
		response.sendRedirect("/resource/view/studentMain.jsp");
		
		
		//request.getRequestDispatcher("/resource/view/studentMain.jsp").forward(request, response);
	}

}
