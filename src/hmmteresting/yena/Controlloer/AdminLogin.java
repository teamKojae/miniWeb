package hmmteresting.yena.Controlloer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import hmmteresting.yena.DAO.AdminDAO;
import hmmteresting.yena.model.AdminBean;

public class AdminLogin {
private AdminDAO adminDAO;
    
    public AdminLogin() {
    	adminDAO = new AdminDAO();
    }
    
    public boolean isAdminLogin(AdminBean admin, HttpServletRequest request) {
        // 관리자 정보 가져오기
    	//System.out.println("DAO loginAdmin   : "+admin);
        AdminBean loginAdmin = adminDAO.getAdminByIdAndPassword(admin);
        //System.out.println("DAO loginAdmin   : "+loginAdmin);
        System.out.println("isAdmin : "+loginAdmin);
        // 관리자 정보가 존재한다면, 세션에 집어 넣는다.
        if ( loginAdmin != null ) {    
            // 세션을 가지고 온다.
            HttpSession session = request.getSession();
            System.out.println("session New "+session.isNew());
            System.out.println("session manager   "+session.getAttribute("managerId"));
            
            // 세션에 관리자 정보 저장
            session.setAttribute("managerId", loginAdmin);
        }
        
        // 3. 널이 아니면 true 결과를 보고
        return loginAdmin != null ? true : false;
    }

}
