package hmmteresting.yena.Controlloer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hmmteresting.yena.model.AdminBean;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/adminlogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminLogin adminLogin;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
	public AdminLoginServlet(){
		super();
		adminLogin = new AdminLogin();
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String managerId = request.getParameter("userId");
        String managerPassword = request.getParameter("userPw");
        
        AdminBean loginAdmin = new AdminBean();
        loginAdmin.setManagerId(managerId);
        loginAdmin.setManagerPassword(managerPassword);
       
        boolean isLoginSuccess = adminLogin.isAdminLogin(loginAdmin, request);

        if ( isLoginSuccess ) {
            response.sendRedirect("/AdminMain.jsp");
            return;
        }
        else {
            response.sendRedirect("/login?errorCode=1"); //?alert와 페이지에 머물기?ㄴ
            return;
        }
        
    }

	

}
