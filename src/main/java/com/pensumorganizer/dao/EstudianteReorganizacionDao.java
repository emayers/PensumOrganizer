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
	
	public Map<Integer, ArrayList<Course>> getCourses(int id){
		Map<Integer, ArrayList<Course>> mapCourses=new HashMap<Integer, ArrayList<Course>>();
		ArrayList<Course> res = new ArrayList<Course>();
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
				String terminoActual=null;
				terminoActual=resultSet.getString("TerminoDescripcion");
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
				course.setTrimNum(trim);
				res.add(course);
				while(resultSet.next()&&terminoActual.equals(resultSet.getString("TerminoDescripcion"))){
				//Course course=new Course();
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
				cor.add(resultSet.getString("CoRequisito"));
				course.setCoReqID(cor);
				course.setTerm(resultSet.getInt("Termino"));
				course.setTrimesterDescription(resultSet.getString("TerminoDescripcion"));
				course.setCredits(resultSet.getInt("Creditos"));
				pre.add(resultSet.getString("Prerrequisito"));
				course.setPreqID(pre);
				course.setTrimNum(trim);
				res.add(course);
		}
				trim++;
				System.out.println("Trimestre "+ trim);
				mapCourses.put(trim, res);
				
				
				
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
	
	public void setReorganization(Map<Integer, ArrayList<Course>> map, int id){
		for(int index=1;index<map.size();index++){
			List<Course> current=map.get(index);
			for(Course course : current){
		try{
			String queryString = "INSERT INTO EstudianteReorganizacion (AsignaturaCodigo, Descripcion, Termino, TerminoDescripcion, Creditos, Prerrequisito, RequisitoCred, Corequisito, NumTrimestre, IdEstudiante)"
		                          +"VALUES(?,?,?,?,?,?,?,?,?,?);";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, course.getId());
			ptmt.setString(2, course.getName());
			ptmt.setInt(3, course.getTerm());
			ptmt.setString(4, course.getTrimesterDescription());
			ptmt.setInt(5, course.getCredits());
			ptmt.setString(6, "wtv");
			ptmt.setInt(7, course.getCreditsReq());
			ptmt.setString(8, "wtv");
			ptmt.setInt(9, index);
			ptmt.setInt(10, id);
			ptmt.executeUpdate();
			System.out.println("Data added ");
			
			
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
		Map<Integer, ArrayList<Course>> map=new HashMap<Integer, ArrayList<Course>>();
		map=erd.getCourses(1056025);
		erd.setReorganization(map, 188888);

	}

}
