package hmmteresting.kojae.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hmmteresting.kojae.DAO.AdminProcess;

/**
 * Servlet implementation class CheckModifyCount
 */
@WebServlet("/CheckModifyCount.do")
public class CheckModifyCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckModifyCount() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int countModify = new AdminProcess().getCountModify();
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(Integer.toString(countModify));
	}

}
