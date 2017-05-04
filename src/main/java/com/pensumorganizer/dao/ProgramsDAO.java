package com.pensumorganizer.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pensumorganizer.util.ConnectionFactory;

public class ProgramsDAO {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	
	public String getProgramName(String programCode){
		/*Returns the program description, example: INGENIERIA DE SOFTWARE*/
		String description=null;
		try{
			String queryString = "SELECT Descripcion FROM Programas WHERE ProgramaCodigo=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, programCode);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
//				System.out.println(resultSet.getString("Descripcion"));
				description=resultSet.getString("Descripcion");			  
		}
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
		return description;
	}
	
	
	public int getTotalTrimesters(String programCode, int version){
		/*Returns the total trimesters of the program, for example, IDS-2010 has 14 trimesters*/
		int totalTrimesters=0;
		try{
			String queryString = "SELECT TotalTrimestres FROM Programas WHERE ProgramaCodigo=? AND Version=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, programCode);
			ptmt.setInt(2, version);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
//				System.out.println(resultSet.getInt("TotalTrimestres"));
				totalTrimesters=resultSet.getInt("TotalTrimestres");			  
		}
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
		return totalTrimesters;
	}
	
	public int getProgramCredits(String programCode, int version){
		int programCredits=0;
		try{
			String queryString = "SELECT CreditosPrograma FROM Programas WHERE ProgramaCodigo=? AND Version=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, programCode);
			ptmt.setInt(2, version);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
//				System.out.println(resultSet.getInt("TotalTrimestres"));
				programCredits=resultSet.getInt("CreditosPrograma");			  
		}
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
		return programCredits;
		
	}
	
	public int getVersion(){
		return 0;
		//check
	}
	
	public String getProgramCode(){
		return null;
		//check
	}
	

	
	public static void main(String[] args) {
		/*For testing, to be deleted*/

	}

}
