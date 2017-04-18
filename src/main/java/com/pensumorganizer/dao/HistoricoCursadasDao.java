package com.pensumorganizer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pensumorganizer.connectionfactory.ConnectionFactory;
import com.pensumorganizer.entities.HistoricoCursadasEntity;


public class HistoricoCursadasDao {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public void show(HistoricoCursadasEntity std){
		try{
			
			String queryString = "SELECT * FROM HistoricoCursadas WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, std.getIdEstudiante());
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
	
	public static void main(String [] args){
		HistoricoCursadasDao hist=new HistoricoCursadasDao();
		HistoricoCursadasEntity std= new HistoricoCursadasEntity();
		std.setIdEstudiante(1058691);
		//hist.getYear(1058691);
		//hist.getTerm(1058691);
		//hist.getCourseCode(1058691);
		//hist.getSection(1058691);
		//hist.getGrade(1058691);
		hist.getSectionType(1058691);
	}

}
