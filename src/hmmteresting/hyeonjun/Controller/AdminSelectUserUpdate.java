package hmmteresting.hyeonjun.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hmmteresting.hyeonjun.DAO.selectModifyUsers;
import hmmteresting.hyeonjun.Model.UpdateCheck;

/**
 * Servlet implementation class AdminSelectUserUpdate
 */
@WebServlet("/AdminSelectUserUpdate.do")
public class AdminSelectUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentNo = (String) request.getParameter("studentNo");
		
		selectModifyUsers selectModifyUsers = new selectModifyUsers();
		UpdateCheck ThisUser = selectModifyUsers.updateThisUser(studentNo);
		
		request.setAttribute("ThisUser", ThisUser);		
		request.getRequestDispatcher("/resource/view/adminModityThisUser.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
