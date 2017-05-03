package com.pensumorganizer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pensumorganizer.connectionfactory.ConnectionFactory;

public class AsignaturasPorDarDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	
	public ArrayList<String> getCourseCode(int id){
		/*Returns all courses codes*/
		ArrayList<String> listOfAllCourseToTakeCodes = new ArrayList<String>();
		try{
			String queryString = "SELECT AsignaturaCodigo FROM AsignaturasPorDar WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
//				System.out.println(resultSet.getString("AsignaturaCodigo"));
				listOfAllCourseToTakeCodes.add(resultSet.getString("AsignaturaCodigo"));			  
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
		return listOfAllCourseToTakeCodes;
		
	}
	
	
	public ArrayList<Course> getSubjectsToTake(int id){
		/*Returns an ArrayList of Course objects*/
		ArrayList<Course> subjectsToTake = new ArrayList<Course>();
		ArrayList<String> corequisites=new ArrayList<String>();
		EstudianteProgramaDao student=new EstudianteProgramaDao();
		PensumDao pensum=new PensumDao();
		try{
			String queryString = "SELECT AsignaturaCodigo, Descripcion, Prerequisito, CoRequisito FROM AsignaturasPorDar WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){
				Course course=new Course();
//				System.out.println(resultSet.getString("AsignaturaCodigo")
//						           +" "+resultSet.getString("CoRequisito")
//						           +" "+resultSet.getString("Descripcion")
//						           +" "+resultSet.getString("Prerequisito"));//maybe use the other dao for prerequisites =3=
				course.setId(resultSet.getString("AsignaturaCodigo"));
				course.setName(resultSet.getString("Descripcion"));
				corequisites.add(resultSet.getString("CoRequisito"));
				course.setCoReqID(corequisites);
				subjectsToTake.add(course);
		}
			System.out.println("ReqCred");
			for(int i=0;i<subjectsToTake.size();i++){
				subjectsToTake.get(i).setCreditsReq(pensum.getCreditsRequirements(student.getProgramCode(id), subjectsToTake.get(i).getId()));
//				System.out.println(subjectsToTake.get(i).getCreditsReq());
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
		return subjectsToTake;
		
		
	}
	

	
	public static void main(String[] args) {
		/*For testing, to be deleted*/
		// TODO Auto-generated method stub
		AsignaturasPorDarDao apdd=new AsignaturasPorDarDao();
		//apdd.getCourseCode(1058691);
		apdd.getSubjectsToTake(1058691);

	}

}
