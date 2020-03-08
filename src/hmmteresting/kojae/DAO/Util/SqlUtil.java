package hmmteresting.kojae.DAO.Util;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hmmteresting.kojae.Model.SchoolBean;

public class SqlUtil {
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Connection connection;
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			 
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://54.180.142.10:3306/hmmteresting?characterEncoding=utf8", "root", "1234");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public int getCountModify(String sql) {
		int countModify=0;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				countModify = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return countModify;
	}
	
	public List<SchoolBean> getLocation(String sql){
		SchoolBean schoolBean = null;
		List<SchoolBean> list = new ArrayList<SchoolBean>();
		
		try {
			Connection connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				schoolBean = new SchoolBean();
				schoolBean.setLocationName(resultSet.getString(1));
				list.add(schoolBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	
	public List<SchoolBean> getSchoolName(String sql){
		
		List<SchoolBean> list = null;
		SchoolBean schoolBean = null;
		try {
			Connection connection = getConnection();
			list = new ArrayList<SchoolBean>();
			sql = new String(sql.getBytes(), "utf-8");
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				schoolBean = new SchoolBean();
				schoolBean.setLocationName(resultSet.getString(1));
				schoolBean.setSchoolName(resultSet.getString(2));
				System.out.println(resultSet.getString(1));
				list.add(schoolBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
		
		
	}
	
	
	
	public void close() {

		try {
			if(resultSet != null)
				resultSet.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}
