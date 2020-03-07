package hmmteresting.hyeonjun.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hmmteresting.hyeonjun.DAO.selectModifyThisUser;
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
		String studentNo = request.getParameter("studentNo").trim();
		String modifyNo = request.getParameter("modifyNo");
		
		selectModifyUsers selectModifyUsers = new selectModifyUsers();
		UpdateCheck ThisUser = selectModifyUsers.updateThisUser(studentNo,modifyNo);
		
		request.setAttribute("ThisUser", ThisUser);		
		request.getRequestDispatcher("/adminModityThisUser").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int koreanScore = Integer.parseInt(request.getParameter("koreanScore"));
		int englishScore = Integer.parseInt(request.getParameter("englishScore"));
		int mathScore = Integer.parseInt(request.getParameter("mathScore"));
		int scienceScore = Integer.parseInt(request.getParameter("scienceScore"));
		int historyScore = Integer.parseInt(request.getParameter("historyScore"));
		String studentNo = request.getParameter("studentNo");
		int examNo = Integer.parseInt(request.getParameter("examNo"));
		selectModifyThisUser selectModifyThisUser = new selectModifyThisUser();
		
		selectModifyThisUser.update(studentNo, koreanScore, englishScore, mathScore, scienceScore, historyScore,examNo);
		
		selectModifyUsers selectModifyUsers = new selectModifyUsers();
		ArrayList<UpdateCheck> updateCheckList = selectModifyUsers.updateCheck();
		
		request.setAttribute("updateCheckList", updateCheckList);		
		request.getRequestDispatcher("/adminModify").forward(request, response);
		//response.sendRedirect("/adminModify");
		// TODO Auto-generated method stub
		
	}

}
