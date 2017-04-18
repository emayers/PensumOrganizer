package com.pensumorganizer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pensumorganizer.entities.*;

import com.pensumorganizer.connectionfactory.*;

public class CalificacionesDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public double getPoints(String grade){
		double res=0;
try{
			
			String queryString = "SELECT Puntos FROM Calificaciones WHERE CalificacionCodigo=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, grade);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
				System.out.println(resultSet.getDouble("Puntos"));
				res=resultSet.getDouble("Puntos");
			  
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
		CalificacionesDao cd=new CalificacionesDao();
		cd.getPoints("A");

	}

}