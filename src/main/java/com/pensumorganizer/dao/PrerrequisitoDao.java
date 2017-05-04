package com.pensumorganizer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pensumorganizer.util.ConnectionFactory;
import com.pensumorganizer.util.structures.Prerrequisito;

public class PrerrequisitoDao {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	
	
	public int getCourseSequence(String programCode, String courseCode, int version){
		/*Returns course sequence, not sure what that means, all i know is that in IDS is always 1*/
		int sequence=0;
		try{
					
					String queryString = "SELECT SecuenciaAsignatura, Asignatura FROM Prerrequisitos WHERE (ProgramaCodigo=? AND Version=? AND Asignatura=?);";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setString(1, programCode);
					ptmt.setInt(2, version);
					ptmt.setString(3, courseCode);
					resultSet=ptmt.executeQuery();
					while(resultSet.next() && resultSet.getString("Asignatura").equals(courseCode)){ 
//						System.out.println(resultSet.getInt("SecuenciaAsignatura"));
					  
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
		return sequence;
				
			}
	
	
	public int getPrerequisiteSequence(String programCode, String prerequisite, int version){
		/*Returns prerequisite sequence, if a subject has more than one prerequisite, 
		 * it will have a register for each prerequisite, with a distinct number*/
		int sequence=0;
		try{
					
					String queryString = "SELECT SecuenciaPrerrequisito FROM Prerrequisitos WHERE (ProgramaCodigo=? AND Version=? AND Prerrequisito=?);";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setString(1, programCode);
					ptmt.setInt(2, version);
					ptmt.setString(3, prerequisite);
					resultSet=ptmt.executeQuery();
//					if(resultSet.next()){ 
//						System.out.println(resultSet.getInt("SecuenciaPrerrequisito"));
//					  
//				}
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
		return sequence;
				
			}
	
	
	public ArrayList<Prerrequisito> getAllPreRequisitesByProgram(String ProgramCode, int Version){
		/*Returns the codes of the prerequisites of a subject, as a subject may have more than 
		 * one prerequisite, it returns an ArrayList*/
		ArrayList<Prerrequisito> listOfAllPrerequisites=new ArrayList<Prerrequisito>();
		try{
					
					String queryString = "SELECT Prerrequisito, Asignatura FROM Prerrequisitos WHERE (ProgramaCodigo=? AND Version=?);";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setString(1, ProgramCode);
					ptmt.setInt(2, Version);
					resultSet=ptmt.executeQuery();
					while(resultSet.next()){ 
						Prerrequisito pre=new Prerrequisito();
//						System.out.println("Pre"+" "+resultSet.getString("Prerrequisito")+" " +resultSet.getString("Asignatura"));
						if(resultSet.getString("Prerrequisito")!=null){
						    pre.preReq.add((resultSet.getString("Prerrequisito")));
						    pre.setSubject(resultSet.getString("Asignatura"));
						}
						listOfAllPrerequisites.add(pre);
						
					  
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
		return listOfAllPrerequisites;
				
			}
	
	
	public ArrayList<String> getPreRequisite(String ProgramCode, String CourseCode, int Version){
		/*Returns the codes of the prerequisites of a subject, as a subject may have more than 
		 * one prerequisite, it returns an ArrayList*/
		ArrayList<String> listOfPrerequisites=new ArrayList<String>();
		try{
					
					String queryString = "SELECT Prerrequisito, Asignatura FROM Prerrequisitos WHERE (ProgramaCodigo=? AND Version=? AND Asignatura=?);";
					connection = getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setString(1, ProgramCode);
					ptmt.setInt(2, Version);
					ptmt.setString(3, CourseCode);
					resultSet=ptmt.executeQuery();
					while(resultSet.next()){ 
//						System.out.println(resultSet.getString("Prerrequisito"));
						listOfPrerequisites.add(resultSet.getString("Prerrequisito"));
					  
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
		return listOfPrerequisites;
				
			}
	
	
	public static void main(String [] args){
		/*For testing, to be deleted*/
		PrerrequisitoDao prerre = new PrerrequisitoDao();
		
//		prerre.getAsignatura(ent);
//		prerre.getVersion(ent);
//		prerre.getSecuenciaAsignatura(ent);
//		prerre.getProgramaCodigo(ent);
//		prerre.getSecuenciaPrerrequisito(ent);
	//	prerre.getPreRequisite("IDS", "IDS316", 2010);
//		prerre.getPreRequisite("IDS", "CBF201", 2010);
//		prerre.getCourseSequence("IDS", "ING210", 2010);
		//prerre.getPrerequisiteSequence("IDS", "INS203", 2010);
		prerre.getAllPreRequisitesByProgram("IDS", 2010);
	}

}
