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

public class PensumDao {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public void show(PensumEntity psm){
		try{
			
			String queryString = "SELECT * FROM Pensum WHERE ProgramaCodigo=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, psm.getProgramaCodigo());
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				System.out.println(resultSet.getInt("Version") + " "+resultSet.getInt("CreditosPrograma") + " "+resultSet.getString("ProgramaCodigo") +" "+ 
				resultSet.getInt("Trimestre") +" " +resultSet.getString("AsignaturaCodigo") + " " +resultSet.getInt("RequisitosCreditos") +" "+resultSet.getString("CoRequisito"));
			  
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
		
	}
	
	public int getVersion(String code){
		int res = 0;
		try{
			String queryString = "SELECT Version FROM Pensum WHERE ProgramaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, code);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
				System.out.println(resultSet.getInt("Version"));
				res=resultSet.getInt("Version");			  
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
	public int getProgramCredits(String code){
		int res = 0;
		try{
			String queryString = "SELECT CreditosPrograma FROM Pensum WHERE ProgramaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, code);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
				System.out.println(resultSet.getInt("CreditosPrograma"));
				res=resultSet.getInt("CreditosPrograma");			  
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
	
	public String getProgramCode(int id){
		String res = null;
		try{
			String queryString = "SELECT ProgramaCodigo FROM EstudiantePrograma WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
				System.out.println(resultSet.getString("ProgramaCodigo"));
				res=resultSet.getString("ProgramaCodigo");			  
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
	
	public ArrayList<Integer> getTrimester(String code){
		ArrayList<Integer> res = new ArrayList<Integer>();
		try{
			String queryString = "SELECT Trimestre FROM Pensum WHERE ProgramaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, code);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				System.out.println(resultSet.getInt("Trimestre"));
				res.add(resultSet.getInt("Trimestre"));			  
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
	
	public ArrayList<String> getCourseCode(String code){
		ArrayList<String> res = new ArrayList<String>();
		try{
			String queryString = "SELECT AsignaturaCodigo FROM Pensum WHERE ProgramaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, code);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				System.out.println(resultSet.getString("AsignaturaCodigo"));
				res.add(resultSet.getString("AsignaturaCodigo"));			  
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
	
	public ArrayList<Integer> getCreditsRequirements(String code){
		ArrayList<Integer> res = new ArrayList<Integer>();
		try{
			String queryString = "SELECT RequisitosCreditos FROM Pensum WHERE ProgramaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, code);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				System.out.println(resultSet.getInt("RequisitosCreditos"));
				res.add(resultSet.getInt("RequisitosCreditos"));			  
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
	
	public ArrayList<String> getCoRequisites(String code){
		ArrayList<String> res=new ArrayList<String>();
		try{
			String queryString = "SELECT CoRequisito FROM Pensum WHERE ProgramaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, code);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				System.out.println(resultSet.getString("CoRequisito"));
				res.add(resultSet.getString("CoRequisito"));			  
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
	
	public ArrayList<Course> getCourses(String code, int version){
		ArrayList<Course> res = new ArrayList<Course>();
		ArrayList<String> cor=new ArrayList<String>();
		ArrayList<String>pre=new ArrayList<String>();
		try{
			String queryString = "SELECT AsignaturaCodigo, Trimestre, RequisitosCreditos, CoRequisito, Version FROM Pensum WHERE ProgramaCodigo=? AND Version=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, code);
			ptmt.setInt(2, version);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){
				Course course=new Course();
				System.out.println(resultSet.getString("AsignaturaCodigo")
						           +" "+resultSet.getInt("Trimestre")+
						           " "+resultSet.getInt("RequisitosCreditos")
						           +" "+resultSet.getString("CoRequisito"));
				course.setId(resultSet.getString("AsignaturaCodigo"));
				course.setIdealTrimestrer(resultSet.getInt("Trimestre"));
				course.setCreditsReq(resultSet.getInt("RequisitosCreditos"));
				cor.add(resultSet.getString("CoRequisito"));
				course.setCoReqID(cor);
				PrerrequisitoDao prd=new PrerrequisitoDao();
				pre=prd.getPreRequisite(code, resultSet.getString("AsignaturaCodigo"), version);
				course.setPreqID(pre);
				res.add(course);
				
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
	
	public static void main(String [] args){
		PensumDao psm = new PensumDao();
		PensumEntity pensum=new PensumEntity();
		pensum.setProgramaCodigo("IDS");
		//psm.show(pensum);
		//psm.getVersion("IDS");
		//psm.getProgramCredits("IDS");
		//psm.getProgramCode(1056025);
		//psm.getTrimester("IDS");
		//psm.getCourseCode("IDS");
		//psm.getCreditsRequirements("IDS");
		//psm.getCoRequisites("IDS");
		psm.getCourses("IDS", 2010);
	}
	

}
