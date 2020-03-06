package hmmteresting.yena.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hmmteresting.yena.model.AdminBean;

public class AdminDAO { 
	private Connection conn;
	private static AdminDAO instance;
	private PreparedStatement stmt;
	private ResultSet res;
	public AdminBean getAdminByIdAndPassword(AdminBean admin) {
		String dbId="root";
		String dbPw="1234";
		AdminBean validAdmin = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn=DriverManager.getConnection("jdbc:mysql://localhost/hmmteresting?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", dbId, dbPw);
			String sql ="SELECT managerId, managerPassword FROM hmmteresting.manager WHERE managerId=? and managerPassword=?"; 
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, admin.getManagerId());
            stmt.setString(2, admin.getManagerPassword());
            res=stmt.executeQuery();
            
            
            while( res.next() ){
            	validAdmin = new AdminBean();
            	validAdmin.setManagerId(res.getString("managerId"));
            	validAdmin.setManagerPassword(res.getString("managerPassword"));
            	System.out.println("어드민 DB :  "+validAdmin);
            }
            
   
            
        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
           closeAll(conn, stmt, res);  
        }
		
        return validAdmin;
		
	}//생성자 end
	
	public void closeAll (Connection conn, PreparedStatement stmt, ResultSet res) {
        if (res != null) {
            try {
                res.close();
            } catch (SQLException e) {
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
 
    }
	
	public static AdminDAO getInstance() {
		return instance=(instance==null)? new AdminDAO():instance; 
	}
		  

}
