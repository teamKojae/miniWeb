package hmmteresting.kojae.DAO;

import java.io.UnsupportedEncodingException;
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

	public List<SchoolBean> getLocation(){
		connection = sqlUtil.getConnection();
		String getLocation = " SELECT DISTINCT locationName FROM school";
		SchoolBean schoolBean = null;
		List<SchoolBean> list = new ArrayList<SchoolBean>();
		try {
			preparedStatement = connection.prepareStatement(getLocation);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				schoolBean = new SchoolBean();
				schoolBean.setLocationName(resultSet.getString(1));
				list.add(schoolBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<SchoolBean> getSchoolName(String locationName){
		connection = sqlUtil.getConnection();
		String getLocation = " SELECT DISTINCT locationName, schoolName FROM school "
				+ "WHERE locationName = '"+locationName+"'";
		SchoolBean schoolBean = null;
		List<SchoolBean> list = new ArrayList<SchoolBean>();
		try {
			getLocation = new String(getLocation.getBytes(), "utf-8");
			preparedStatement = connection.prepareStatement(getLocation);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				schoolBean = new SchoolBean();
				schoolBean.setLocationName(resultSet.getString(1));
				schoolBean.setSchoolName(resultSet.getString(2));
				list.add(schoolBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
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
		int i = 0;
		if( ! whereQuary.get(0).equals(""))
		sql.append(" WHERE ");
		for(String where : whereQuary) {
			if( column.size() == whereQuary.size() && ! whereQuary.get(i).equals("")) {
				// 조건문 붙히기. 조건 추가되면 and붙히는 조건절이랑 조인문도 추가할예정   
					// WHERE	    ex) ↓ locationName = '강남구'  ↓
				sql.append(" "+ column.get(i)+"='"+where+"' and " );
				if( i == whereQuary.size()-1 || whereQuary.get(whereQuary.size()-1).equals("")) 
					sql.delete(sql.length()-4 , sql.length());
				
				i++;
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
				if( column.size() > 1 && ! column.get(1).equals("locationName"))
				schoolBean.setSchoolName(resultSet.getString(2));
				schoolBeansList.add(schoolBean);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return schoolBeansList;
	}

	
	
	public void insertUserUseExcel(String fileName) {

		try {
			ExcelUtil excelUtil = new ExcelUtil();
			List<List<String>> gradeList = excelUtil.excelData(fileName);

			connection = sqlUtil.getConnection();

			String sql = "INSERT INTO hmmteresting.grade "
					+ "(studentNo, examNo, koreanScore, mathScore, englishScore, scienceScore,historyScore,"
					+ "totalScore,averageScore) VALUES(?,?,?,?,?,?,?,?,?)";

			preparedStatement = connection.prepareStatement(sql);
			int index=0;
			for (List<String> excelDataList : gradeList) {
				preparedStatement.setString(1, excelDataList.get(0));
				preparedStatement.setInt(2, Integer.parseInt(excelDataList.get(3)));
				preparedStatement.setInt(3, Integer.parseInt(excelDataList.get(4)));
				preparedStatement.setInt(4, Integer.parseInt(excelDataList.get(5)));
				preparedStatement.setInt(5, Integer.parseInt(excelDataList.get(6)));
				preparedStatement.setInt(6, Integer.parseInt(excelDataList.get(7)));
				preparedStatement.setInt(7, Integer.parseInt(excelDataList.get(8)));
				preparedStatement.setInt(8, Integer.parseInt(excelDataList.get(9)));
				preparedStatement.setDouble(9, Double.parseDouble(excelDataList.get(10)));
				preparedStatement.execute();
			}
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
