package hmmteresting.yena.Controlloer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import hmmteresting.yena.model.AdminBean;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/galaxy/hosting/bitcamp/Adminlogin.do")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminLogin adminLogin;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String managerId = request.getParameter("managerId");
        String managerPassword = request.getParameter("managerPassword");
        
        AdminBean loginAdmin = new AdminBean();
        loginAdmin.setManagerId(managerId);
        loginAdmin.setManagerPassword(managerPassword);
        //System.out.println("servlet loginAdmin  :   "+loginAdmin);
        
        adminLogin = new AdminLogin();
        boolean isLoginSuccess = adminLogin.isAdminLogin(loginAdmin, request);
        //System.out.println("is login:  "+isLoginSuccess);
        
        //HttpSession session = request.getSession();
        //System.out.println("servlet session "+session.getAttribute("memberId"));
        if ( isLoginSuccess ) {
        	 response.sendRedirect("/galaxy/hosting/bitcamp");
        }
        else {
        	request.setAttribute("name", "fail");
            request.getRequestDispatcher("/galaxy/hosting/bitcamp/login").forward(request, response);
            
        }
        
    }

	

}
