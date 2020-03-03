package hmmteresting.kojae.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hmmteresting.kojae.DAO.Util.ExcelUtil;
import hmmteresting.kojae.DAO.Util.SqlUtil;
import hmmteresting.kojae.Model.GradeBean;
import hmmteresting.kojae.Model.SchoolBean;

public class AdminProcess {
	PreparedStatement preparedStatement;
	Connection connection;
	ResultSet resultSet;
	SqlUtil sqlUtil = new SqlUtil();

	public AdminProcess() {

	}

	public List<SchoolBean> getLoactionName(List<String> column, List<String> whereQuary) {

		connection = sqlUtil.getConnection();
		String select = "SELECT DISTINCT ";
		String from = " FROM school";
		
		StringBuffer sql = new StringBuffer();

		sql.append(select);
		for(int i = 0 ; i<column.size(); i++) {
			//칼럼 하나일땐  칼럼명만 오게  ex) SELECT DISTINCT locationName FROM school
			if(column.size() == 1) {
				sql.append(" " + column.get(i));
			}
			//칼럼 여러개일땐 , 붙게   ex) SELECT DISTINCT locationName, schoolName FROM school
			else {
				sql.append(" " + column.get(i) + ",");
				if(i == column.size()-1 ) {
				sql.delete(sql.length()-1, sql.length());
				}
			}
		}
		sql.append(from);
		
		if(! whereQuary.get(0).equals("")) {
			sql.append(" WHERE ");
			
			// 조건문 붙히기. 조건 추가되면 and붙히는 조건절이랑 조인문도 추가할예정   
			for(int i = 0 ; i< whereQuary.size()-1; i++) {
				// WHERE	    ex) ↓ locationName = '강남구'  ↓
				sql.append(" "+ column.get(i)+"='"+whereQuary.get(i)+"'" );
			}

		}
		System.out.println("query :  " + sql);
		List<SchoolBean> schoolBeansList = null;
		try {
			preparedStatement = connection.prepareStatement(sql.toString());
			resultSet = preparedStatement.executeQuery();

			schoolBeansList = new ArrayList<SchoolBean>();
			while (resultSet.next()) {
				SchoolBean schoolBean = new SchoolBean();
				schoolBean.setLocationName(resultSet.getString(1));
				if( ! whereQuary.get(0).equals(""))
				schoolBean.setSchoolName(resultSet.getString(2));
				schoolBeansList.add(schoolBean);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return schoolBeansList;
	}

	
	
	public void insertExcelData(String fileName) {

		try {
			ExcelUtil excelUtil = new ExcelUtil();
//			List<GradeBean> gradeList = excelUtil.excelData(fileName);

			connection = sqlUtil.getConnection();

			String sql = "INSERT INTO hmmteresting.grade "
					+ "(studentNo, examNo, koreanScore, mathScore, englishScore, scienceScore,historyScore,"
					+ "totalScore,averageScore) VALUES(?,?,?,?,?,?,?,?,?)";

			preparedStatement = connection.prepareStatement(sql);
			int index = 0;
//			for (GradeBean gradeBean : gradeList) {
//				pState.setString(1, gradeBean.getStudentNo());
//				pState.setInt(2, gradeBean.getExamNo());
//				pState.setInt(3, gradeBean.getKoreanScore());
//				pState.setInt(4, gradeBean.getMathScore());
//				pState.setInt(5, gradeBean.getEnglishScore());
//				pState.setInt(6, gradeBean.getScienceScore());
//				pState.setInt(7, gradeBean.getHistoryScore());
//				pState.setInt(8, gradeBean.getTotlaScore());
//				pState.setInt(9, gradeBean.getAverageScore());
//				pState.execute();
//
//			}
			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

	}

	public void close() {

		try {
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void finalize() throws Throwable {

		close();
		super.finalize();
	}

}
