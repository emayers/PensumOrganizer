package com.pensumorganizer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	/**Returns the subject's credits*/
	public int getCredits(String subjectCode){
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
	
	/**Returns the corequisites of a given subject
	 * Parameters: programCode:'IDS-2010'
	 *             courseCode: 'CSG201'
	 * Returns an ArrayList of strings            */
	public List<String> getCorequisites(String programCode, String courseCode){
		List<String>coRequisites=new ArrayList<String>();
		PensumsDAO psmDao=new PensumsDAO();
		coRequisites=psmDao.getCoRequisites(programCode, courseCode);
		return coRequisites;
		
		
	}

	public static void main(String[] args) {
		/*For testing, to be deleted*/
		// TODO Auto-generated method stub
		CoursesDAO ad=new CoursesDAO();
		ad.getDescription("IDS316");
		ad.getCredits("IDS316");

	}

}
