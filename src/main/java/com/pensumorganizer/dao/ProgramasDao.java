package com.pensumorganizer.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pensumorganizer.connectionfactory.ConnectionFactory;

public class ProgramasDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	
	public String getDescription(String programCode){
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
	
	
	public int getTotalTrimesters(String programCode){
		/*Returns the total trimesters of the program, for example, IDS-2010 has 14 trimesters*/
		int totalTrimesters=0;
		try{
			String queryString = "SELECT TotalTrimestres FROM Programas WHERE ProgramaCodigo=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, programCode);
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

	
	public static void main(String[] args) {
		/*For testing, to be deleted*/
		// TODO Auto-generated method stub
		ProgramasDao prg=new ProgramasDao();
		prg.getDescription("SIS");
		prg.getTotalTrimesters("SIS");

	}

}
