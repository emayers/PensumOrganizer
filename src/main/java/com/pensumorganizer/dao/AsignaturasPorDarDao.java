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
	
	/*Returns all courses codes*/
	public ArrayList<String> getCourseCode(int id){
		ArrayList<String> res = new ArrayList<String>();
		try{
			String queryString = "SELECT AsignaturaCodigo FROM AsignaturasPorDar WHERE IdEstudiante=?;";
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
	
	/*Returns an ArrayList of Course objects*/
	public ArrayList<Course> getCourses(int id){
		ArrayList<Course> res = new ArrayList<Course>();
		ArrayList<String> cor=new ArrayList<String>();
		EstudianteProgramaDao est=new EstudianteProgramaDao();
		PensumDao psm=new PensumDao();
		try{
			String queryString = "SELECT AsignaturaCodigo, Descripcion, Prerequisito, CoRequisito FROM AsignaturasPorDar WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){
				Course course=new Course();
				System.out.println(resultSet.getString("AsignaturaCodigo")
						           +" "+resultSet.getString("CoRequisito")
						           +" "+resultSet.getString("Descripcion")
						           +" "+resultSet.getString("Prerequisito"));//maybe use the other dao for prerequisites =3=
				course.setId(resultSet.getString("AsignaturaCodigo"));
				course.setName(resultSet.getString("Descripcion"));
				cor.add(resultSet.getString("CoRequisito"));
				course.setCoReqID(cor);
				res.add(course);
		}
			System.out.println("ReqCred");
			for(int i=0;i<res.size();i++){
				res.get(i).setCreditsReq(psm.getCreditsRequirements(est.getProgramCode(id), res.get(i).getId()));
				System.out.println(res.get(i).getCreditsReq());
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
	

	/*For testing, to be deleted*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AsignaturasPorDarDao apdd=new AsignaturasPorDarDao();
		//apdd.getCourseCode(1058691);
		apdd.getCourses(1058691);

	}

}
