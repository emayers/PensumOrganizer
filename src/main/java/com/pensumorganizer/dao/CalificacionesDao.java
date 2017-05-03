package com.pensumorganizer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pensumorganizer.connectionfactory.ConnectionFactory;

public class CalificacionesDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	
	public double getPoints(String gradeCode){
		/*Returns the points associated with the letter, for example, A returns 4.00*/
		double points=0;
        try{
			
			String queryString = "SELECT Puntos FROM Calificaciones WHERE CalificacionCodigo=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, gradeCode);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
//				System.out.println(resultSet.getDouble("Puntos"));
				points=resultSet.getDouble("Puntos");
			  
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
        return points;
		
	}

	
	public static void main(String[] args) {
		/*For testing, to be deleted*/
		// TODO Auto-generated method stub
		CalificacionesDao cd=new CalificacionesDao();
		cd.getPoints("A");

	}

}
