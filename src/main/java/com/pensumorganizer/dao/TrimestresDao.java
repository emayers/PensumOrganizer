package com.pensumorganizer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pensumorganizer.connectionfactory.ConnectionFactory;

public class TrimestresDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	/*MAYBE DON'T NEED
	public int getYear(String code){
			
	}*/
	
	/*MAYBE DON'T NEED
	 * public int gerTerm(){
	 * }
	 */
	
	/*Returns the description of the trimester, example: AGOSTO-OCTUBRE 2013, includes the year*/
	public String getDescription(int year, int term){
		String res=null;
		try{
			String queryString = "SELECT Descripcion FROM Trimestres WHERE (Año=? AND Termino=?);";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, year);
			ptmt.setInt(2, term);
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
	
	
	/*For testing, to be deleted*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrimestresDao trm=new TrimestresDao();
		trm.getDescription(2013, 3);
	}
}