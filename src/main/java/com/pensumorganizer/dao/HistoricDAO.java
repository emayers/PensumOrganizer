package com.pensumorganizer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pensumorganizer.util.ConnectionFactory;
import com.pensumorganizer.util.structures.Course;



public class HistoricDAO {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	
	public void show(int id){
		/*For testing, shows the history of the student in console, maybe some other use might be considered*/
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
	
	
	public ArrayList<Integer> getYear(int id){
		/*Returns all the years for each subject taken*/
		ArrayList<Integer> listOfAllYears = new ArrayList<Integer>();
		try{
			String queryString = "SELECT Año FROM HistoricoCursadas WHERE IdEstudiante=? ORDER BY Año, Termino, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
//				System.out.println(resultSet.getInt("Año"));
				listOfAllYears.add(resultSet.getInt("Año"));			  
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
		return listOfAllYears;
		
	}
	
	public ArrayList<Integer> getTerm(int id){
		/*Returns all the terms for each subject taken, remembering that:
		 * 1 stands for AGOSTO-OCTUBRE
		 * 2 stands for FEBRERO-ABRIL
		 * 3 stands for MARZO-ABRIL
		 * 4 stands for MAYO-JULIO*/
		ArrayList<Integer> listOfAllTerms = new ArrayList<Integer>();
		try{
			String queryString = "SELECT Termino FROM HistoricoCursadas WHERE IdEstudiante=? ORDER BY Año, Termino, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
//				System.out.println(resultSet.getInt("Termino"));
				listOfAllTerms.add(resultSet.getInt("Termino"));			  
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
		return listOfAllTerms;
		
	}
	

	public ArrayList<String> getAllCoursesCodes(int id){
		/*Returns all codes of all subjects taken*/
		ArrayList<String> listOfAllCoursesCodes = new ArrayList<String>();
		try{
			String queryString = "SELECT AsignaturaCodigo FROM HistoricoCursadas WHERE IdEstudiante=? ORDER BY Año, Termino, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
//				System.out.println(resultSet.getString("AsignaturaCodigo"));
				listOfAllCoursesCodes.add(resultSet.getString("AsignaturaCodigo"));			  
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
		return listOfAllCoursesCodes;
		
	}
	
	
	public ArrayList<Integer> getAllSections(int id){
		/*Returns all numbers of sections, maybe not needed now*/
		ArrayList<Integer> listOfAllSections = new ArrayList<Integer>();
		try{
			String queryString = "SELECT Seccion FROM HistoricoCursadas WHERE IdEstudiante=? ORDER BY Año, Termino, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
//				System.out.println(resultSet.getInt("Seccion"));
				listOfAllSections.add(resultSet.getInt("Seccion"));			  
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
		return listOfAllSections;
		
	}
	
	
	public ArrayList<String> getGrade(int id){
		/*Returns all grades of all subjects (letter only)*/
		ArrayList<String> listOfAllGrades = new ArrayList<String>();
		try{
			String queryString = "SELECT CalificacionCodigo FROM HistoricoCursadas WHERE IdEstudiante=? ORDER BY Año, Termino, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
//				System.out.println(resultSet.getString("CalificacionCodigo"));
				listOfAllGrades.add(resultSet.getString("CalificacionCodigo"));			  
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
		return listOfAllGrades;
		
	}
	
	
	public ArrayList<String> getAllSectionTypes(int id){
		/*Returns if Theoretic or laboratory, maybe not needed*/
		ArrayList<String> listOfAllSectionTypes = new ArrayList<String>();
		try{
			String queryString = "SELECT TipoSeccion FROM HistoricoCursadas WHERE IdEstudiante=? ORDER BY Año, Termino, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
//				System.out.println(resultSet.getString("TipoSeccion"));
				listOfAllSectionTypes.add(resultSet.getString("TipoSeccion"));			  
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
		return listOfAllSectionTypes;
		
	}
	
	/*Add method that returns an array of History objects, similar to the Courses structure*/
	public ArrayList<Course> getHistory(int id){
		ArrayList<Course> history= new ArrayList<Course>();
		StudentsDAO student=new StudentsDAO();
		String program= student.getProgramCode(id);
		int version=student.getProgramVersion(id);
		PensumsDAO pensum=new PensumsDAO();
		CoursesDAO asigDao=new CoursesDAO();
		PrerrequisitoDao prereqDao=new PrerrequisitoDao();
		try{
			
			String queryString = "SELECT * FROM HistoricoCursadas WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				
				Course takenCourse= new Course();
//				System.out.println(resultSet.getInt("Año") + " "+resultSet.getInt("Termino") + " "+resultSet.getInt("IdEstudiante") +" "+ 
//						resultSet.getString("AsignaturaCodigo") +" " +resultSet.getInt("Seccion") + " " +resultSet.getString("CalificacionCodigo") +
//						" "+resultSet.getString("TipoSeccion"));
				takenCourse.setHistYear(resultSet.getInt("Año"));
				takenCourse.setTerm(resultSet.getInt("Termino"));
				takenCourse.setId(resultSet.getString("AsignaturaCodigo"));
				takenCourse.setGrade(resultSet.getString("CalificacionCodigo"));
				history.add(takenCourse);
			  
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
		//System.out.println("Descripciones+creds");
		//String wtv=null;
		//int wtv2=0;
		for(int i=0;i<history.size();i++){
			history.get(i).setName(asigDao.getDescription(history.get(i).getId()));
			//wtv=history.get(i).getName();
			//System.out.println(wtv);
			history.get(i).setCredits(asigDao.getCredits(history.get(i).getId()));
			//wtv2=history.get(i).getCredits();
			//System.out.println(wtv2);
		}
		//System.out.println("Prerrequisitos");
		for(int i=0;i<history.size();i++){
			history.get(i).setPreqID(prereqDao.getPreRequisite(program, history.get(i).getId(), version));
			//System.out.println(history.get(i).getPreqID());
		}
		
		//System.out.println("Corequisitos");
		for(int i=0;i<history.size();i++){
			history.get(i).setCoReqID(pensum.getCoRequisites(program, history.get(i).getId()));
			//System.out.println(history.get(i).getCoReqID());
		}
		return history;
		
	}
	
	
	public static void main(String [] args){
		/*For testing, to be deleted*/
		HistoricDAO hist=new HistoricDAO();
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
