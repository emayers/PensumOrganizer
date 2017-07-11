package com.pensumorganizer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pensumorganizer.util.ConnectionFactory;
import com.pensumorganizer.util.structures.Course;

public class ReorganizationsDAO {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	/*MAYBE DON'T NEED
	 * public int getStudentId(){
	 * }
	 * */
	
	
	public ArrayList<String> getCoursesCodes(int id){
		/*Maybe don´t need*/
		ArrayList<String> listOfAllCoursesCodes = new ArrayList<String>();
		try{
			String queryString = "SELECT AsignaturaCodigo FROM EstudianteReorganizacion WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				System.out.println(resultSet.getString("AsignaturaCodigo"));
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
	
	public Map<Integer, List<Course>> getOrganization(int id){
		/*Returns the last organization*/
		System.out.println(id + " ReorganizationsDAO");
		Map<Integer, List<Course>> lastOrganization=new HashMap<Integer, List<Course>>();
		List<Course>dummy=new ArrayList<Course>();
		lastOrganization.put(0, dummy);
		ArrayList<String> corequisites=new ArrayList<String>();
		ArrayList<String> prerequisites=new ArrayList<String>();
		int trimesterNumber=0;
		PensumsDAO psmDao=new PensumsDAO();
		StudentsDAO student=new StudentsDAO();
		try{
			String queryString = "SELECT AsignaturaCodigo, Descripcion, Termino, TerminoDescripcion, Creditos, Prerrequisito, RequisitoCred, Corequisito, NumTrimestre FROM EstudianteReorganizacion WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){
				trimesterNumber=resultSet.getInt("NumTrimestre");
				if(trimesterNumber>=lastOrganization.size()){
					List<Course>trimester=new ArrayList<Course>();
					lastOrganization.put(trimesterNumber, trimester);
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
				lastOrganization.get(trimesterNumber).add(course);
				System.out.println("Trimestre "+ trimesterNumber);		
				
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
		for(int indice = 0; indice < lastOrganization.size(); indice++){
			List<Course> trimester = lastOrganization.get(indice);
			
			for(int index = 0; index < trimester.size(); index++){
				Course course = trimester.get(index);
				course.setIdealTrimestrer(psmDao.getIdealTrimester(student.getProgramCode(id), course.getId()));
			}
		}
		return lastOrganization;
		
		
	}
	
	public void setReorganization(Map<Integer, List<Course>> reorganizedPensum, int id){
		/*inserts the new organization to the DB*/
		
		try{
			String queryString = "INSERT INTO EstudianteReorganizacion (AsignaturaCodigo, Descripcion, Termino, TerminoDescripcion, Creditos, Prerrequisito, RequisitoCred, Corequisito, NumTrimestre, IdEstudiante)"
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
					ptmt.setString(6, course.getPreqID().toString());
					ptmt.setInt(7, course.getCreditsReq());
					ptmt.setString(8, course.getCoReqID().toString());
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
		
		
	
	
	public void deleteOrganization(int id){
		/*DELETES THE LAST ORGANIZATION*/
		try{
			String queryString = "DELETE FROM EstudianteReorganizacion WHERE IdEstudiante=?;";
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
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReorganizationsDAO erd=new ReorganizationsDAO();
		Map<Integer, List<Course>> map=new HashMap<Integer, List<Course>>();
		map=erd.getOrganization(1058691);
		erd.setReorganization(map, 2033505);
		//erd.deleteOrganization(2033505);

	}

}
