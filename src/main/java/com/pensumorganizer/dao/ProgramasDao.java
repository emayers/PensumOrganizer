package com.pensumorganizer.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.pensumorganizer.entities.*;

import com.pensumorganizer.connectionfactory.*;

public class ProgramasDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	/*MAYBE DON'T NEED
	public String getProgramCode(){
	
	}*/
	
	/*MAYBE DON'T NEED
	 * public String AreaCodigo(){
	 * }
	 */
	
	/*MAYBE DON'T NEED
	 * public String NivelCodigo(){
	 * }
	 */
	
	public String getDescription(String code){
		String res=null;
		try{
			String queryString = "SELECT Descripcion FROM Programas WHERE ProgramaCodigo=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, code);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
				System.out.println(resultSet.getString("Descripcion"));
				res=resultSet.getString("Descripcion");			  
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
		return res;
	}
	
	public int getTotalTrimesters(String code){
		int res=0;
		try{
			String queryString = "SELECT TotalTrimestres FROM Programas WHERE ProgramaCodigo=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, code);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
				System.out.println(resultSet.getInt("TotalTrimestres"));
				res=resultSet.getInt("TotalTrimestres");			  
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
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProgramasDao prg=new ProgramasDao();
		prg.getDescription("SIS");
		prg.getTotalTrimesters("SIS");

	}

}
