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
	
	/*Returns the program description, example: INGENIERIA DE SOFTWARE*/
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
	
	/*Returns the total trimesters of the program, for example, IDS-2010 has 14 trimesters*/
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

	/*For testing, to be deleted*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProgramasDao prg=new ProgramasDao();
		prg.getDescription("SIS");
		prg.getTotalTrimesters("SIS");

	}

}
