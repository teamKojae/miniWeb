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
 * Servlet implementation class AdminUserUpdate
 */
@WebServlet("/AdminUserUpdate.do")
public class AdminUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		selectModifyUsers selectModifyUsers = new selectModifyUsers();
		ArrayList<UpdateCheck> updateCheckList = selectModifyUsers.updateCheck();
		
		request.setAttribute("updateCheckList", updateCheckList);		
		request.getRequestDispatcher("/resource/view/adminModify.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
