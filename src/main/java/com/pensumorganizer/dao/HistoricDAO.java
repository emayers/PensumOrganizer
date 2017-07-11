package com.pensumorganizer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	
	public ArrayList<Course> getHistory(int studentId){
		System.out.println(studentId + " historyDao");
		ArrayList<Course> history= new ArrayList<Course>();
		ArrayList<String> prerequisites=new ArrayList<String>();
		ArrayList<String> corequisites=new ArrayList<String>();
		StudentsDAO student=new StudentsDAO();
		int trimester=1, admYear=student.getAdmissionYear(studentId), admTerm=student.getAdmissionTerm(studentId);
		try{
			
			String queryString = "SELECT * FROM HistoricoCursadas WHERE IdEstudiante=? ORDER BY Año, Termino;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, studentId);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				if(resultSet.getInt("Año")!=admYear || resultSet.getInt("Termino")!=admTerm){
					admYear=resultSet.getInt("Año");
					admTerm=resultSet.getInt("Termino");
					trimester++;
				}
				Course takenCourse= new Course();
				System.out.println(resultSet.getInt("Año") + " "+resultSet.getInt("Termino") + " "+resultSet.getInt("IdEstudiante") +" "+ 
						resultSet.getString("AsignaturaCodigo") +" " +resultSet.getInt("Seccion") + " " +resultSet.getString("CalificacionCodigo") +
						" "+resultSet.getString("TipoSeccion"));
				takenCourse.setHistYear(resultSet.getInt("Año"));
				takenCourse.setTerm(resultSet.getInt("Termino"));
				takenCourse.setId(resultSet.getString("AsignaturaCodigo"));
				takenCourse.setGrade(resultSet.getString("CalificacionCodigo"));
				takenCourse.setTrimesterTaken(trimester);
				takenCourse.setName(resultSet.getString("Nombre"));
				takenCourse.setCredits(resultSet.getInt("Creditos"));
				prerequisites.add(resultSet.getString("Prerrequisitos"));
				takenCourse.setPreqID(prerequisites);
				corequisites.add(resultSet.getString("Corequisitos"));
				takenCourse.setCoReqID(corequisites);
				System.out.println(trimester);
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
		if(history.size()==0){
			System.out.println("null-historyDao");
		}

		return history;
		
	}
	
	public boolean isApproved(int studentId, String courseCode){
		boolean isApproved=false;
		try{
			String queryString = "SELECT * FROM HistoricoCursadas WHERE IdEstudiante=? AND AsignaturaCodigo=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, studentId);
			ptmt.setString(2, courseCode);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
//				System.out.println(resultSet.getString("TipoSeccion"));
				if(resultSet.getString("Aprobado").equals('T')){
					isApproved= true;
				}					  
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
		return isApproved;
	}
	
	public List<Course> getApprovedCourses(int studentId){
		List<Course>approvedCourses=new ArrayList<Course>();
		ArrayList<String> prerequisites=new ArrayList<String>();
		ArrayList<String> corequisites=new ArrayList<String>();
		try{
			String queryString = "SELECT * FROM HistoricoCursadas WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, studentId);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				Course takenCourse=new Course();
//				System.out.println(resultSet.getString("TipoSeccion"));
				if(resultSet.getString("Aprobado").equals('T')){
					takenCourse.setHistYear(resultSet.getInt("Año"));
					takenCourse.setTerm(resultSet.getInt("Termino"));
					takenCourse.setId(resultSet.getString("AsignaturaCodigo"));
					takenCourse.setGrade(resultSet.getString("CalificacionCodigo"));
					takenCourse.setName(resultSet.getString("Nombre"));
					takenCourse.setCredits(resultSet.getInt("Creditos"));
					prerequisites.add(resultSet.getString("Prerrequisitos"));
					takenCourse.setPreqID(prerequisites);
					corequisites.add(resultSet.getString("Corequisitos"));
					takenCourse.setCoReqID(corequisites);
				}					  
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
		return approvedCourses;
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
