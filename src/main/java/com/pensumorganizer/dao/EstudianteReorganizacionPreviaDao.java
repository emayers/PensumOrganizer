package com.pensumorganizer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pensumorganizer.connectionfactory.ConnectionFactory;


public class EstudianteReorganizacionPreviaDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	

	public ArrayList<String> getCoursesCodes(int id){
		/*MAYBE DON'T NEED*/
		ArrayList<String> listOfCourseCodes = new ArrayList<String>();
		try{
			String queryString = "SELECT AsignaturaCodigo FROM EstudianteReorganizacion2 WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
//				System.out.println(resultSet.getString("AsignaturaCodigo"));
				listOfCourseCodes.add(resultSet.getString("AsignaturaCodigo"));			  
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
		return listOfCourseCodes;
		
	}
	
	public Map<Integer, List<Course>> getPreviousOrganization(int id){
		/*Returns the previous reorganization*/
		Map<Integer, List<Course>> previousReorganization=new HashMap<Integer, List<Course>>();
		List<Course>dummy=new ArrayList<Course>();
		previousReorganization.put(0, dummy);
		ArrayList<String> corequisites=new ArrayList<String>();
		ArrayList<String> prerequisites=new ArrayList<String>();
		int trimesterNumber=0;
		try{
			String queryString = "SELECT AsignaturaCodigo, Descripcion, Termino, TerminoDescripcion, Creditos, Prerrequisito, RequisitoCred, Corequisito, NumTrimestre FROM EstudianteReorganizacion2 WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){
				trimesterNumber=resultSet.getInt("NumTrimestre");
				if(trimesterNumber>=previousReorganization.size()){
					List<Course>trimester=new ArrayList<Course>();
					previousReorganization.put(trimesterNumber, trimester);
				}
				Course course=new Course();
				
//				System.out.println(resultSet.getString("AsignaturaCodigo")
//				           +" "+resultSet.getString("Descripcion")
//				           +" "+resultSet.getInt("Termino")
//				           +" "+resultSet.getString("TerminoDescripcion")
//				           +" "+resultSet.getInt("Creditos")
//				           +" "+resultSet.getString("Prerrequisito")
//				           +" "+resultSet.getInt("RequisitoCred")
//				           +" "+resultSet.getString("Corequisito"));
				course.setId(resultSet.getString("AsignaturaCodigo"));
				course.setName(resultSet.getString("Descripcion"));
				course.setCreditsReq(resultSet.getInt("RequisitoCred"));
				course.setTerm(resultSet.getInt("Termino"));
				course.setTrimesterDescription(resultSet.getString("TerminoDescripcion"));
				corequisites.add(resultSet.getString("CoRequisito"));
				course.setCoReqID(corequisites);
				course.setCredits(resultSet.getInt("Creditos"));
				prerequisites.add(resultSet.getString("Prerrequisito"));
				course.setPreqID(prerequisites);
				course.setTrimNum(resultSet.getInt("NumTrimestre"));
				previousReorganization.get(trimesterNumber).add(course);
//				System.out.println("Trimestre "+ trimesterNumber);		
				
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
		return previousReorganization;
		
		
	}
	
	public void setPreviousReorganization(Map<Integer, List<Course>> reorganizedPensum, int id){
		/*inserts the previous organization in the db*/
		
		try{
			String queryString = "INSERT INTO EstudianteReorganizacion2 (AsignaturaCodigo, Descripcion, Termino, TerminoDescripcion, Creditos, Prerrequisito, RequisitoCred, Corequisito, NumTrimestre, IdEstudiante)"
		                          +"VALUES(?,?,?,?,?,?,?,?,?,?);";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			
			for(int indice = 0; indice < reorganizedPensum.size(); indice++){
				List<Course> trimester = reorganizedPensum.get(indice);
				
				for(int index = 0; index < trimester.size(); index++){
					Course course = trimester.get(index);
					
					ptmt.setString(1, course.getId());
					ptmt.setString(2, course.getName());
					ptmt.setInt(3, course.getTerm());
					ptmt.setString(4, course.getTrimesterDescription());
					ptmt.setInt(5, course.getCredits());
					ptmt.setString(6, " "/*course.getPreqID().toString()*/);
					ptmt.setInt(7, course.getCreditsReq());
					ptmt.setString(8, " "/*course.getCoReqID().toString()*/);
					ptmt.setInt(9, course.getTrimNum());
					ptmt.setInt(10, id);
					ptmt.executeUpdate();
					System.out.println("Data added ");	
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
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		}
		
		
	
	
	public void deletePreviousOrganization(int id){
		/*deletes the previous organization FOR GOOD*/
		try{
			String queryString = "DELETE FROM EstudianteReorganizacion2 WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			ptmt.executeUpdate();				
			System.out.println("Previous Organization deleted");
		    
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
	

}
