package com.pensumorganizer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pensumorganizer.util.ConnectionFactory;

public class ElectivesDAO {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	
	
	public ArrayList<String> getAllElectives(String programCode, String subjectCode){
		/*returns all possible electives according to general code, for example, all electives for SH1X1 (Socio-Historica)*/
		ArrayList<String> listOfAllElectives=new ArrayList<String>();
		try{
			String queryString = "SELECT Electiva FROM Electivas WHERE ProgramaCodigo=? AND AsignaturaCodigo=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, programCode);
			ptmt.setString(2, subjectCode);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){
//				System.out.println(resultSet.getString("Electiva"));
				listOfAllElectives.add(resultSet.getString("Electiva"));
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
		return listOfAllElectives;
	}
	
	
	public boolean isElective(String programCode, String generalSubjectCode, String subjectCode){
		/*Returns true if the subject is an elective, false if it isn't*/
		boolean isElective=false;
		try{
			String queryString = "SELECT Electiva FROM Electivas WHERE ProgramaCodigo=? AND AsignaturaCodigo=? AND Electiva=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, programCode);
			ptmt.setString(2, generalSubjectCode);
			ptmt.setString(3, subjectCode);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){
					isElective=true;
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
		return isElective;
		
	}

	
	public static void main(String[] args) {
		/*For testing, to be deleted*/
		// TODO Auto-generated method stub
		ElectivesDAO ed= new ElectivesDAO();
		ed.getAllElectives("IDS", "ASH1X1");
		ed.isElective("IDS","ASH1X1","SHG101");
		//ed.findElective("IDS","ASH1X1","ING210");

	}

}
