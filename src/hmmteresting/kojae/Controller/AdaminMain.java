package hmmteresting.kojae.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hmmteresting.kojae.DAO.AdminProcess;

/**
 * Servlet implementation class AdaminMain
 */
@WebServlet("/galaxy/hosting/bitcamp")
public class AdaminMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdaminMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("managerId") == null) {
			System.out.println("여기왔슴");
			System.out.println(session.getAttribute("managerId"));
			response.sendRedirect("/galaxy/hosting/bitcamp/loginPage");
		}
		System.out.println(session.getAttribute("managerId"));
		request.setAttribute("countModify",new AdminProcess().getCountModify());
		request.setAttribute("admin", session.getAttribute("managerId"));
		
		request.getRequestDispatcher("/galaxy/hosting/bitcamp/admin").forward(request, response);
		
	}
}
