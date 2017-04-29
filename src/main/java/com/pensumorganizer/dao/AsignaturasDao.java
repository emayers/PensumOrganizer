package com.pensumorganizer.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.pensumorganizer.entities.*;

import com.pensumorganizer.connectionfactory.*;

public class AsignaturasDao {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	/*Returns the subject name*/
	public String getDescription(String code){
		String res=null;
		try{
			
			String queryString = "SELECT Descripcion FROM Asignaturas WHERE AsignaturaCodigo=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, code);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
				System.out.println(resultSet.getString("Descripcion"));
			  
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
	
	/*Returns the subject's credits*/
	public int getCredits(String code){
		int res=0;
		try{
			
			String queryString = "SELECT Creditos FROM Asignaturas WHERE AsignaturaCodigo=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, code);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
				System.out.println(resultSet.getInt("Creditos"));
			  
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
		AsignaturasDao ad=new AsignaturasDao();
		ad.getDescription("IDS316");
		ad.getCredits("IDS316");

	}

}
