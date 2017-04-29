package com.pensumorganizer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.pensumorganizer.entities.*;

import com.pensumorganizer.connectionfactory.*;

public class PensumDao {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	/*For testing, shows pensum in console*/
	public void show(PensumEntity psm){
		try{
			
			String queryString = "SELECT * FROM Pensum WHERE ProgramaCodigo=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, psm.getProgramaCodigo());
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				System.out.println(resultSet.getInt("Version") + " "+resultSet.getInt("CreditosPrograma") + " "+resultSet.getString("ProgramaCodigo") +" "+ 
				resultSet.getInt("Trimestre") +" " +resultSet.getString("AsignaturaCodigo") + " " +resultSet.getInt("RequisitosCreditos") +" "+resultSet.getString("CoRequisito"));
			  
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
	
	/*Returns version of the pensum, for example, 2010*/
	public int getVersion(String code){
		int res = 0;
		try{
			String queryString = "SELECT Version FROM Pensum WHERE ProgramaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, code);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
				System.out.println(resultSet.getInt("Version"));
				res=resultSet.getInt("Version");			  
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
	/*Returns the total amount of credits, for example, IDS has 249 credits*/
	public int getProgramCredits(String code){
		int res = 0;
		try{
			String queryString = "SELECT CreditosPrograma FROM Pensum WHERE ProgramaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, code);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
				System.out.println(resultSet.getInt("CreditosPrograma"));
				res=resultSet.getInt("CreditosPrograma");			  
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
	
	/*Returns the program code, for example, IDS*/
	public String getProgramCode(int id){
		String res = null;
		try{
			String queryString = "SELECT ProgramaCodigo FROM EstudiantePrograma WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
				System.out.println(resultSet.getString("ProgramaCodigo"));
				res=resultSet.getString("ProgramaCodigo");			  
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
	
	/*Returns all trimesters taken (number), for example, 1, 2, 3...19, 20, 21*/
	public ArrayList<Integer> getTrimester(String code){
		ArrayList<Integer> res = new ArrayList<Integer>();
		try{
			String queryString = "SELECT Trimestre FROM Pensum WHERE ProgramaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, code);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				System.out.println(resultSet.getInt("Trimestre"));
				res.add(resultSet.getInt("Trimestre"));			  
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
	
	/*Returns all courses codes taken*/
	public ArrayList<String> getCourseCode(String code){
		ArrayList<String> res = new ArrayList<String>();
		try{
			String queryString = "SELECT AsignaturaCodigo FROM Pensum WHERE ProgramaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, code);
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
	
	/*Returns all credits requirements*/
	public ArrayList<Integer> getAllCreditsRequirements(String code){
		ArrayList<Integer> res = new ArrayList<Integer>();
		try{
			String queryString = "SELECT RequisitosCreditos FROM Pensum WHERE ProgramaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, code);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				System.out.println(resultSet.getInt("RequisitosCreditos"));
				res.add(resultSet.getInt("RequisitosCreditos"));			  
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
	
	public int getCreditsRequirements(String code, String subject){
		int res = 0;
		try{
			String queryString = "SELECT RequisitosCreditos FROM Pensum WHERE ProgramaCodigo=? AND AsignaturaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, code);
			ptmt.setString(2, subject);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
				System.out.println(resultSet.getInt("RequisitosCreditos"));
				res=resultSet.getInt("RequisitosCreditos");			  
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
	/*Returns all corequisites, according to program, like IDS*/
	public ArrayList<String> getCoRequisites(String code, String subject){
		ArrayList<String> res=new ArrayList<String>();
		try{
			String queryString = "SELECT CoRequisito FROM Pensum WHERE ProgramaCodigo=? AND AsignaturaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, code);
			ptmt.setString(2, subject);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				System.out.println(resultSet.getString("CoRequisito"));
				res.add(resultSet.getString("CoRequisito"));			  
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
	
	/*Returns all corequisites, according to program, like IDS*/
	public ArrayList<String> getAllCoRequisites(String code){
		ArrayList<String> res=new ArrayList<String>();
		try{
			String queryString = "SELECT CoRequisito FROM Pensum WHERE ProgramaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, code);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				System.out.println(resultSet.getString("CoRequisito"));
				res.add(resultSet.getString("CoRequisito"));			  
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
	
	/*Returns the Pensum in Courses objects*///TODO, fix the double db call
	public ArrayList<Course> getCourses(String code, int version){
		ArrayList<Course> res = new ArrayList<Course>();
		ArrayList<String> cor=new ArrayList<String>();
		PrerrequisitoDao pqd=new PrerrequisitoDao();
		ArrayList<Prerrequisito>pre=pqd.getPreRequisiteByProgram(code, version);
		AsignaturasDao ad=new AsignaturasDao();
		try{
			String queryString = "SELECT AsignaturaCodigo, Trimestre, RequisitosCreditos, CoRequisito, Version FROM Pensum WHERE ProgramaCodigo=? AND Version=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, code);
			ptmt.setInt(2, version);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){
				Course course=new Course();
				System.out.println(resultSet.getString("AsignaturaCodigo")
						           +" "+resultSet.getInt("Trimestre")+
						           " "+resultSet.getInt("RequisitosCreditos")
						           +" "+resultSet.getString("CoRequisito"));
				course.setId(resultSet.getString("AsignaturaCodigo"));
				course.setIdealTrimestrer(resultSet.getInt("Trimestre"));
				course.setCreditsReq(resultSet.getInt("RequisitosCreditos"));
				cor.add(resultSet.getString("CoRequisito"));
				course.setCoReqID(cor);
				String id=course.getId();
//				for(int i=0;i<pre.size();i++){
//					 String subj=pre.get(i).getSubject();
//					  //System.out.println(id +" "+subj);
//					if(id.equals(subj)){
//					   course.setPreqID(pre.get(i).getPreReq());
//					   System.out.println("added");
//					}
//				}
				res.add(course);
				
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
		System.out.println("Descripciones+creds");
		String wtv=null;
		int wtv2=0;
		for(int i=0;i<res.size();i++){
			res.get(i).setName(ad.getDescription(res.get(i).getId()));
			wtv=res.get(i).getName();
			System.out.println(wtv);
			res.get(i).setCredits(ad.getCredits(res.get(i).getId()));
			wtv2=res.get(i).getCredits();
			System.out.println(wtv2);
		}
		System.out.println("Prerrequisitos");
		for(int i=0;i<res.size();i++){
			res.get(i).setPreqID(pqd.getPreRequisite(code, res.get(i).getId(), version));
			System.out.println(res.get(i).getPreqID());
		}
		return res;
		
		
	}
	
	//For testing, to be deleted
	public static void main(String [] args){
		PensumDao psm = new PensumDao();
		PensumEntity pensum=new PensumEntity();
		pensum.setProgramaCodigo("IDS");
		//psm.show(pensum);
		//psm.getVersion("IDS");
		//psm.getProgramCredits("IDS");
		//psm.getProgramCode(1056025);
		//psm.getTrimester("IDS");
		//psm.getCourseCode("IDS");
		//psm.getCreditsRequirements("IDS");
		//psm.getCoRequisites("IDS");
		psm.getCourses("IDS", 2010);
	}
	

}
