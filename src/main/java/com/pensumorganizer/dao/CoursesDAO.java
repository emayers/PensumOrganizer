package com.pensumorganizer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pensumorganizer.util.ConnectionFactory;

public class CoursesDAO {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	
	public String getDescription(String subjectCode){
		/*Returns the subject name*/
		String subjectDescription=null;
		try{
			
			String queryString = "SELECT Descripcion FROM Asignaturas WHERE AsignaturaCodigo=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, subjectCode);
			resultSet=ptmt.executeQuery();
//			if(resultSet.next()){ 
//				System.out.println(resultSet.getString("Descripcion"));
//			  
//		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
				if (resultSet != null)
					resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return subjectDescription;
	}
	
	
	public int getCredits(String subjectCode){
		/*Returns the subject's credits*/
		int credits=0;
		try{
			
			String queryString = "SELECT Creditos FROM Asignaturas WHERE AsignaturaCodigo=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, subjectCode);
			resultSet=ptmt.executeQuery();
//			if(resultSet.next()){ 
//				System.out.println(resultSet.getInt("Creditos"));
//			  
//		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
				if (resultSet != null)
					resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return credits;
		
	}

	public static void main(String[] args) {
		/*For testing, to be deleted*/
		// TODO Auto-generated method stub
		CoursesDAO ad=new CoursesDAO();
		ad.getDescription("IDS316");
		ad.getCredits("IDS316");

	}

}
