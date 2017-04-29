package com.pensumorganizer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pensumorganizer.entities.*;

import com.pensumorganizer.connectionfactory.*;


public class HistoricoCursadasDao {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	/*For testing, shows the history of the student in console, maybe some other use might be considered*/
	public void show(int id){
		try{
			
			String queryString = "SELECT * FROM HistoricoCursadas WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				System.out.println(resultSet.getInt("Año") + " "+resultSet.getInt("Termino") + " "+resultSet.getInt("IdEstudiante") +" "+ 
						resultSet.getString("AsignaturaCodigo") +" " +resultSet.getInt("Seccion") + " " +resultSet.getString("CalificacionCodigo") +
						" "+resultSet.getString("TipoSeccion"));
			  
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
	
	/*Returns all the years for each subject taken*/
	public ArrayList<Integer> getYear(int id){
		ArrayList<Integer> res = new ArrayList<Integer>();
		try{
			String queryString = "SELECT Año FROM HistoricoCursadas WHERE IdEstudiante=? ORDER BY Año, Termino, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				System.out.println(resultSet.getInt("Año"));
				res.add(resultSet.getInt("Año"));			  
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
	/*Returns all the terms for each subject taken, remembering that:
	 * 1 stands for AGOSTO-OCTUBRE
	 * 2 stands for FEBRERO-ABRIL
	 * 3 stands for MARZO-ABRIL
	 * 4 stands for MAYO-JULIO*/
	public ArrayList<Integer> getTerm(int id){
		ArrayList<Integer> res = new ArrayList<Integer>();
		try{
			String queryString = "SELECT Termino FROM HistoricoCursadas WHERE IdEstudiante=? ORDER BY Año, Termino, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				System.out.println(resultSet.getInt("Termino"));
				res.add(resultSet.getInt("Termino"));			  
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
	
	/*Returns all codes of all subjects taken*/
	public ArrayList<String> getCourseCode(int id){
		ArrayList<String> res = new ArrayList<String>();
		try{
			String queryString = "SELECT AsignaturaCodigo FROM HistoricoCursadas WHERE IdEstudiante=? ORDER BY Año, Termino, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
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
	
	/*Returns all numbers of sections, maybe not needed now*/
	public ArrayList<Integer> getSection(int id){
		ArrayList<Integer> res = new ArrayList<Integer>();
		try{
			String queryString = "SELECT Seccion FROM HistoricoCursadas WHERE IdEstudiante=? ORDER BY Año, Termino, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				System.out.println(resultSet.getInt("Seccion"));
				res.add(resultSet.getInt("Seccion"));			  
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
	
	/*Returns all grades of all subjects (letter only)*/
	public ArrayList<String> getGrade(int id){
		ArrayList<String> res = new ArrayList<String>();
		try{
			String queryString = "SELECT CalificacionCodigo FROM HistoricoCursadas WHERE IdEstudiante=? ORDER BY Año, Termino, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				System.out.println(resultSet.getString("CalificacionCodigo"));
				res.add(resultSet.getString("CalificacionCodigo"));			  
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
	
	/*Returns if Theoretic or laboratory*/
	public ArrayList<String> getSectionType(int id){
		ArrayList<String> res = new ArrayList<String>();
		try{
			String queryString = "SELECT TipoSeccion FROM HistoricoCursadas WHERE IdEstudiante=? ORDER BY Año, Termino, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				System.out.println(resultSet.getString("TipoSeccion"));
				res.add(resultSet.getString("TipoSeccion"));			  
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
	
	/*Add method that returns an array of History objects, similar to the Courses structure*/
	public ArrayList<Course> getHistory(int id){
		ArrayList<Course> history= new ArrayList<Course>();
		EstudianteProgramaDao est=new EstudianteProgramaDao();
		String program= est.getProgramCode(id);
		int version=est.getVersion(id);
		PensumDao psm=new PensumDao();
		AsignaturasDao ad=new AsignaturasDao();
		PrerrequisitoDao pqd=new PrerrequisitoDao();
		try{
			
			String queryString = "SELECT * FROM HistoricoCursadas WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				Course hist= new Course();
				System.out.println(resultSet.getInt("Año") + " "+resultSet.getInt("Termino") + " "+resultSet.getInt("IdEstudiante") +" "+ 
						resultSet.getString("AsignaturaCodigo") +" " +resultSet.getInt("Seccion") + " " +resultSet.getString("CalificacionCodigo") +
						" "+resultSet.getString("TipoSeccion"));
				hist.setHistYear(resultSet.getInt("Año"));
				hist.setTerm(resultSet.getInt("Termino"));
				hist.setId(resultSet.getString("AsignaturaCodigo"));
				hist.setGrade(resultSet.getString("CalificacionCodigo"));
				history.add(hist);
			  
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
		System.out.println("Descripciones+creds");
		String wtv=null;
		int wtv2=0;
		for(int i=0;i<history.size();i++){
			history.get(i).setName(ad.getDescription(history.get(i).getId()));
			wtv=history.get(i).getName();
			System.out.println(wtv);
			history.get(i).setCredits(ad.getCredits(history.get(i).getId()));
			wtv2=history.get(i).getCredits();
			System.out.println(wtv2);
		}
		System.out.println("Prerrequisitos");
		for(int i=0;i<history.size();i++){
			history.get(i).setPreqID(pqd.getPreRequisite(program, history.get(i).getId(), version));
			System.out.println(history.get(i).getPreqID());
		}
		
		System.out.println("Corequisitos");
		for(int i=0;i<history.size();i++){
			history.get(i).setCoReqID(psm.getCoRequisites(program, history.get(i).getId()));
			System.out.println(history.get(i).getCoReqID());
		}
		return history;
		
	}
	
	/*For testing, to be deleted*/
	public static void main(String [] args){
		HistoricoCursadasDao hist=new HistoricoCursadasDao();
		//HistoricoCursadasEntity std= new HistoricoCursadasEntity();
		//std.setIdEstudiante(1058691);
		//hist.getYear(1058691);
		//hist.getTerm(1058691);
		//hist.getCourseCode(2019363);
		//hist.getSection(1058691);
		//hist.getGrade(1058691);
		//hist.getSectionType(1058691);
		hist.getHistory(1058691);
	}

}
