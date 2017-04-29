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
import com.pensumorganizer.connectionfactory.ConnectionFactory;

public class ElectivasDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	//TODO
	
	public ArrayList<String> getAllElectives(String program, String code){
		ArrayList<String> res=new ArrayList<String>();
		try{
			String queryString = "SELECT Electiva FROM Electivas WHERE ProgramaCodigo=? AND AsignaturaCodigo=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, program);
			ptmt.setString(2, code);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){
				System.out.println(resultSet.getString("Electiva"));
				res.add(resultSet.getString("Electiva"));
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
	
	/*Returns true if the subject is an elective, false if it isn't*/
	public boolean findElective(String program, String code, String elective){
		boolean res=false;
		try{
			String queryString = "SELECT Electiva FROM Electivas WHERE ProgramaCodigo=? AND AsignaturaCodigo=? AND Electiva=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, program);
			ptmt.setString(2, code);
			ptmt.setString(3, elective);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){
					res=true;
					System.out.println("I've found it" +" "+resultSet.getString("Electiva"));
					
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
		ElectivasDao ed= new ElectivasDao();
		ed.getAllElectives("IDS", "ASH1X1");
		ed.findElective("IDS","ASH1X1","SHG101");
		//ed.findElective("IDS","ASH1X1","ING210");

	}

}
