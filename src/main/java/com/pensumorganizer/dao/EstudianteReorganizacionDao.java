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

public class EstudianteReorganizacionDao {
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
	
	public ArrayList<String> getCourseCode(int id){
		ArrayList<String> res = new ArrayList<String>();
		try{
			String queryString = "SELECT AsignaturaCodigo FROM EstudianteReorganizacion WHERE IdEstudiante=?;";
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
	
	public Map<Integer, Course> getCourses(int id){
		Map<Integer, Course> mapCourses=new HashMap<Integer, Course>();
		//ArrayList<Course> res = new ArrayList<Course>();
		ArrayList<String> cor=new ArrayList<String>();
		ArrayList<String> pre=new ArrayList<String>();
		int trim=0;
		try{
			String queryString = "SELECT AsignaturaCodigo, Descripcion, Termino, TerminoDescripcion, Creditos, Prerrequisito, RequisitoCred, Corequisito, NumTrimestre FROM EstudianteReorganizacion WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){
				//String terminoActual=null;
				//terminoActual=resultSet.getString("TerminoDescripcion");
				Course course=new Course();
				
				System.out.println(resultSet.getString("AsignaturaCodigo")
				           +" "+resultSet.getString("Descripcion")
				           +" "+resultSet.getInt("Termino")
				           +" "+resultSet.getString("TerminoDescripcion")
				           +" "+resultSet.getInt("Creditos")
				           +" "+resultSet.getString("Prerrequisito")
				           +" "+resultSet.getInt("RequisitoCred")
				           +" "+resultSet.getString("Corequisito"));
				course.setId(resultSet.getString("AsignaturaCodigo"));
				course.setName(resultSet.getString("Descripcion"));
				course.setCreditsReq(resultSet.getInt("RequisitoCred"));
				course.setTerm(resultSet.getInt("Termino"));
				course.setTrimesterDescription(resultSet.getString("TerminoDescripcion"));
				cor.add(resultSet.getString("CoRequisito"));
				course.setCoReqID(cor);
				course.setCredits(resultSet.getInt("Creditos"));
				pre.add(resultSet.getString("Prerrequisito"));
				course.setPreqID(pre);
				course.setTrimNum(resultSet.getInt("NumTrimestre"));
				//trim=course.getTrimNum();
				mapCourses.put(trim, course);
				trim++;
				System.out.println("Trimestre "+ trim);		
				
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
		return mapCourses;
		
		
	}
	
	public void setReorganization(Map<Integer, Course> map, int id){
		
		try{
			String queryString = "INSERT INTO EstudianteReorganizacion (AsignaturaCodigo, Descripcion, Termino, TerminoDescripcion, Creditos, Prerrequisito, RequisitoCred, Corequisito, NumTrimestre, IdEstudiante)"
		                          +"VALUES(?,?,?,?,?,?,?,?,?,?);";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			for(Course course:map.values()){
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
		try{
			String queryString = "DELETE FROM EstudianteReorganizacion WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){
				System.out.println("Previous Organization deleted");
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
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EstudianteReorganizacionDao erd=new EstudianteReorganizacionDao();
		Map<Integer, Course> map=new HashMap<Integer, Course>();
		map=erd.getCourses(1058691);
		erd.setReorganization(map, 2033505);

	}

}
