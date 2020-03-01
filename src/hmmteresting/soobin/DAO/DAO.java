package hmmteresting.soobin.DAO;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hmmteresting.kojae.DAO.Util.SqlUtil;
import hmmteresting.soobin.model.ModelViewBean;

public class DAO {

	private Connection conn = null;
	private static DAO instance;
	private String sqlSelcet = "select student.studentNo,student.studentName,grade.koreanScore,grade.englishScore,"
			+ "grade.mathScore,grade.scienceScore,grade.historyScore,exam.examDate,exam.examNo " 
			+ "from exam,grade,school,student"
			+" where grade.examNo = exam.examNo " 
			+"and student.studentNo=grade.studentNo " 
			+"and school.schoolNo = student.schoolNo and";
	private PreparedStatement pState = null;
	SqlUtil util = new SqlUtil();

	public DAO() {
		
	}
	public static DAO getInstance() {

		return (instance == null) ? instance = new DAO() : instance;
	}

	public String SelectWhere(String... args) {

		String sql = sqlSelcet;
		System.out.println(args[0]);
		if (args[0] != "" || args[1] != "" || args[2] != "")
			//sql += " where ";

		if (args[0] != "")
			sql += " school.schoolName = '" + args[0] + "' and ";

		if (args[1] != "") {
			sql += " student.studentName = '";

			if (args[0] != "") {
				sql += args[1] + "' and ";
			}else if(args[0]=="")
				sql += args[0] + "' and ";
		}
		if ((args[0]!=""||args[1]!="")&&args[2] == "")
			sql=sql.substring(0, sql.length() - 4);

		else if (args[2]!=""){
			sql += " student.studentNo = '";
			if (args[0]!=""&&args[1]!="")
				sql += args[2]+"'";
			else if (args[0]!=""||args[1]!="")
				sql += args[1]="'";
			else
				sql += args[0]="'";
		}
		return sql;
	}

	public List<ModelViewBean> SelcetFilter(String... args) {

		String sql = args[0];

		ModelViewBean bean;
		ResultSet rest = null;
		List<ModelViewBean> listbean = new ArrayList<ModelViewBean>();

		try {

			if (args[1] != "" || args[2] != "" || args[3] != "")
				sql += " order by ";

			if (args[1]!="")
				sql += " exam.examDate , ";

			if (args[2]!="")
				sql += " exam.examCode , ";

			if (args[3]!="")
				sql += " school.locationName , ";

			sql=sql.substring(0, sql.length() - 2);
			System.out.println(sql);
			sql = new String (sql.getBytes(),"utf-8");
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hmmteresting?", "root", "1234");
			pState = conn.prepareStatement(sql);
			rest = pState.executeQuery();
			while (rest.next()) {
				bean= new ModelViewBean();
				int sum = 0;
				double ave = 0;
				bean.setStudentNo(rest.getString(1));
				bean.setStudentName(rest.getString(2));
				bean.setKoreanScore(rest.getInt(3));
				bean.setEnglishScore(rest.getInt(4));
				bean.setMathScore(rest.getInt(5));
				bean.setScienceScore(rest.getInt(6));
				bean.setHistoryScore(rest.getInt(7));
				for (int i = 3; i < 8; i++) {
					sum += rest.getInt(i);
					ave = sum /= 5;
				}
				bean.setTotalScore(sum);
				bean.setAverageScore(ave);
				bean.setExamDate(rest.getString(8));
				bean.setExamNo(rest.getInt(9));
				listbean.add(bean);
				bean = null;
			}
			System.out.println("conn Close ?");
			conn.close();
			System.out.println("conn Close !");
		} catch (SQLException e) {
			e.printStackTrace();
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
		}finally {
			try {
				if(conn!=null)
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return listbean;
	}

	public void close() {

		try {
			if (pState != null)
				pState.close();
			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


}
