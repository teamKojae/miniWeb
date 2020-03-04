package hmmteresting.soobin.DAO;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hmmteresting.kojae.DAO.Util.SqlUtil;
import hmmteresting.soobin.model.ModelExamBean;
import hmmteresting.soobin.model.ModelViewBean;

public class ExamDAO {

	private Connection conn = null;
	private static ExamDAO instance;
	private String sqlinput = "select examDate,examCode from exam";
	private PreparedStatement pState = null;

	SqlUtil util = new SqlUtil();

	public ExamDAO() {
	}

	public static ExamDAO getInstance() {

		return (instance == null) ? instance = new ExamDAO() : instance;
	}

	public List<ModelExamBean> SelcetExamDate(String args) {

		ModelExamBean bean;
		ResultSet rest = null;
		List<ModelExamBean> listbean = new ArrayList<ModelExamBean>();
		String sql=sqlinput;
		if (args!=null) {
			sql = sqlinput + " where examDate like '%" + args+ "%' ";
			System.out.println(sql);
		}
			try {
				sql = new String(sql.getBytes(), "utf-8");
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				conn = DriverManager.getConnection("jdbc:mysql://localhost/hmmteresting?", "root", "1234");
				pState = conn.prepareStatement(sql);
				rest = pState.executeQuery();
				while (rest.next()) {
					bean = new ModelExamBean();
					bean.setExamDate(rest.getString(1));
					bean.setExamCode(rest.getString(2));
					listbean.add(bean);
					bean = null;
				}
				pState.close();
				conn.close();
			
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		return listbean;

	}
}
