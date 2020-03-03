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
	private String sqlSelcet = "select student.studentNo,student.studentName,exam.examDate,exam.examNo ,grade.koreanScore,grade.englishScore,"
			+ "grade.mathScore,grade.scienceScore,grade.historyScore,grade.totalScore,grade.averageScore "
			+ " from exam,grade,school,student where grade.examNo = exam.examNo "
			+ "and student.studentNo=grade.studentNo and school.schoolNo = student.schoolNo ";
	private PreparedStatement pState = null;

	SqlUtil util = new SqlUtil();

	public DAO() {
	}

	public static DAO getInstance() {

		return (instance == null) ? instance = new DAO() : instance;
	}

	public String SelectWhere(String... args) {

		String sql = sqlSelcet;
		if (args[0] != "" || args[1] != "" || args[2] != "") {
			sql += " and ";
		}
		if (args[0] != "") {
			sql += "  school.schoolName = '" + args[0] + "'  and ";
		}

		if (args[1] != "") {
			sql += " student.studentName = '" + args[1] + "' and ";
		}
		if ((args[0] != "" || args[1] != "") && args[2] == "") {
			sql = sql.substring(0, sql.length() - 4);
		}
		if (args[2] != "") {
			sql += " student.studentNo = '" + args[2] + "'";
		}
		return sql;
	}

	public List<ModelViewBean> SelcetFilter(String... args) {

		String sql = args[0];

		ModelViewBean bean;
		ResultSet rest = null;
		List<ModelViewBean> listbean = new ArrayList<ModelViewBean>();

		try {

			sql += " order by student.studentName , ";

			if (args[1] != "")
				sql += "exam.examDate , ";

			if (args[2] != "")
				sql += "exam.examCode , ";

			if (args[3] != "")
				sql += "school.locationName , ";

			sql = sql.substring(0, sql.length() - 2);

			sql = new String(sql.getBytes(), "utf-8");

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hmmteresting?", "root", "1234");
			pState = conn.prepareStatement(sql);
			rest = pState.executeQuery();
			while (rest.next()) {
				bean = new ModelViewBean();
				bean.setStudentNo(rest.getString(1));
				bean.setStudentName(rest.getString(2));
				bean.setExamDate(rest.getString(3));
				bean.setExamNo(rest.getInt(4));
				bean.setKoreanScore(rest.getInt(5));
				bean.setEnglishScore(rest.getInt(6));
				bean.setMathScore(rest.getInt(7));
				bean.setScienceScore(rest.getInt(8));
				bean.setHistoryScore(rest.getInt(9));
				bean.setTotalScore(rest.getInt(10));
				bean.setAverageScore(rest.getDouble(11));

				listbean.add(bean);
				bean = null;
			}
			pState.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
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
