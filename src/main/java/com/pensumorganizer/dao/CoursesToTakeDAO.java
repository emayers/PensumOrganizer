package com.pensumorganizer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pensumorganizer.util.ConnectionFactory;
import com.pensumorganizer.util.structures.Course;

public class CoursesToTakeDAO {
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
	
	
	public ArrayList<Course> getSubjectsToTake(int studentId){
		/*Returns an ArrayList of Course objects*/
		//falta validar CorTaken!
		ArrayList<Course> subjectsToTake = new ArrayList<Course>();
		ArrayList<String> corequisites=new ArrayList<String>();
		StudentsDAO student=new StudentsDAO();
		PensumsDAO pensum=new PensumsDAO();
		CoursesToTakeDAO cttd=new CoursesToTakeDAO();
		try{
			String queryString = "SELECT AsignaturaCodigo, Descripcion, Prerequisito, CoRequisito FROM AsignaturasPorDar WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, studentId);
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
//			System.out.println("ReqCred");
			
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
		for(int i=0;i<subjectsToTake.size();i++){
			subjectsToTake.get(i).setCreditsReq(pensum.getCreditsRequirements(student.getProgramCode(studentId), subjectsToTake.get(i).getId()));
			subjectsToTake.get(i).setPreqID(pensum.getPrerequisites(student.getProgramCode(studentId), subjectsToTake.get(i).getId()));
			for(int j=0;j<subjectsToTake.get(i).getPreqID().size();j++){
				subjectsToTake.get(i).setTaken(cttd.find(subjectsToTake.get(i).getPreqID().get(j), studentId));
			}
			subjectsToTake.get(i).setIdealTrimestrer(pensum.getIdealTrimester(student.getProgramCode(studentId), subjectsToTake.get(i).getId()));
//			System.out.println(subjectsToTake.get(i).getCreditsReq());
		}
		return subjectsToTake;
		
		
	}
	
	public boolean find(String courseCode, int studentId){
		boolean isTaken=true;
		try{
			String queryString = "SELECT AsignaturaCodigo FROM AsignaturasPorDar WHERE IdEstudiante=? AND AsignaturaCodigo=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, studentId);
			ptmt.setString(2, courseCode);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
//				System.out.println(resultSet.getString("AsignaturaCodigo"));
				isTaken=false;			  
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
		return isTaken;
	}
	

	
	public static void main(String[] args) {
		/*For testing, to be deleted*/
		// TODO Auto-generated method stub
		CoursesToTakeDAO apdd=new CoursesToTakeDAO();
		//apdd.getCourseCode(1058691);
		apdd.getSubjectsToTake(1058691);

	}

}
