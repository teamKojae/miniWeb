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
@WebServlet("/adminlogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminLogin adminLogin;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String managerId = request.getParameter("managerId");
        String managerPassword = request.getParameter("managerPassword");
        System.out.println(managerId+"  "+managerPassword);
        
        AdminBean loginAdmin = new AdminBean();
        loginAdmin.setManagerId(managerId);
        loginAdmin.setManagerPassword(managerPassword);
        //System.out.println("servlet loginAdmin  :   "+loginAdmin);
        
        adminLogin = new AdminLogin();
        boolean isLoginSuccess = adminLogin.isAdminLogin(loginAdmin, request);
        System.out.println("로그인 success ? "+isLoginSuccess);
        //System.out.println("is login:  "+isLoginSuccess);
        
        //HttpSession session = request.getSession();
        //System.out.println("servlet session "+session.getAttribute("memberId"));
        if ( isLoginSuccess ) {
        	 request.getRequestDispatcher("/galaxy/hosting/bitcamp").forward(request, response);;
           
        }
        else {
        	request.setAttribute("name", "fail");
            request.getRequestDispatcher("/galaxy/hosting/bitcamp/login").forward(request, response);
            
        }
        
    }

	

}
