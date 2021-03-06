package com.pensumorganizer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pensumorganizer.util.ConnectionFactory;
import com.pensumorganizer.util.structures.Course;

public class PensumsDAO {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	
	public void show(String programCode){
		/*For testing, shows pensum in console*/
		try{
			
			String queryString = "SELECT * FROM Pensum WHERE ProgramaCodigo=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, programCode);
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
	
	
	public int getVersion(String programCode){
		/*Returns version of the pensum, for example, 2010*/
		int version = 0;
		try{
			String queryString = "SELECT Version FROM Pensum WHERE ProgramaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, programCode);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
//				System.out.println(resultSet.getInt("Version"));
				version=resultSet.getInt("Version");			  
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
		return version;
		
	}
	
	public int getProgramCredits(String programCode){
		/*Returns the total amount of credits, for example, IDS has 249 credits*/
		int programCredits = 0;
		try{
			String queryString = "SELECT CreditosPrograma FROM Pensum WHERE ProgramaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, programCode);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
//				System.out.println(resultSet.getInt("CreditosPrograma"));
				programCredits=resultSet.getInt("CreditosPrograma");			  
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
		return programCredits;
		
	}
	
	
	public String getProgramCode(int id){
		/*Returns the program code, for example, IDS*/
		String programCode = null;
		try{
			String queryString = "SELECT ProgramaCodigo FROM EstudiantePrograma WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
//				System.out.println(resultSet.getString("ProgramaCodigo"));
				programCode=resultSet.getString("ProgramaCodigo");			  
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
		return programCode;
		
	}
	
	
	public ArrayList<Integer> getAllTrimesterNumbers(String programCode){
		/*Returns all trimesters (number), for example, 1, 2, 3...12, 13, 14, maybe don't need*/
		ArrayList<Integer> listOfAllNumbersOfTrimesters = new ArrayList<Integer>();
		try{
			String queryString = "SELECT Trimestre FROM Pensum WHERE ProgramaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, programCode);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
//				System.out.println(resultSet.getInt("Trimestre"));
				listOfAllNumbersOfTrimesters.add(resultSet.getInt("Trimestre"));			  
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
		return listOfAllNumbersOfTrimesters;
		
	}
	
	
	public ArrayList<String> getCoursesCodes(String programCode){
		/*Returns all courses codes*/
		ArrayList<String> listOfAllCourseCodes = new ArrayList<String>();
		try{
			String queryString = "SELECT AsignaturaCodigo FROM Pensum WHERE ProgramaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, programCode);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
				System.out.println(resultSet.getString("AsignaturaCodigo"));
				listOfAllCourseCodes.add(resultSet.getString("AsignaturaCodigo"));			  
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
		return listOfAllCourseCodes;
		
	}
	
	
	public ArrayList<Integer> getAllCreditsRequirements(String programCode){
		/*Returns all credits requirements*/
		ArrayList<Integer> listOfAllCreditsRequirements = new ArrayList<Integer>();
		try{
			String queryString = "SELECT RequisitosCreditos FROM Pensum WHERE ProgramaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, programCode);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
//				System.out.println(resultSet.getInt("RequisitosCreditos"));
				listOfAllCreditsRequirements.add(resultSet.getInt("RequisitosCreditos"));			  
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
		return listOfAllCreditsRequirements;
		
	}
	
	/** Returns the credits requirements of a subject
	 * Parameters: programCode:'IDS-2016'
	 *              courseCode: 'IDS-306'
	 * Returns an int             */
	public int getCreditsRequirements(String programCode, String courseCode){
		int creditsRequirements = 0;
		try{
			String queryString = "SELECT RequisitosCreditos FROM Pensum WHERE ProgramaCodigo=? AND AsignaturaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, programCode);
			ptmt.setString(2, courseCode);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){ 
//				System.out.println(resultSet.getInt("RequisitosCreditos"));
				creditsRequirements=resultSet.getInt("RequisitosCreditos");			  
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
		return creditsRequirements;
		
	}
	
	public ArrayList<String> getCoRequisites(String programCode, String subject){
		/*Returns all corequisites, according to program and subject, like IDS*/
		ArrayList<String> corequisites=new ArrayList<String>();
		try{
			String queryString = "SELECT CoRequisito FROM Pensum WHERE ProgramaCodigo=? AND AsignaturaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, programCode);
			ptmt.setString(2, subject);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
//				System.out.println(resultSet.getString("CoRequisito"));
				corequisites.add(resultSet.getString("CoRequisito"));			  
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
		return corequisites;
		
	}
	
	
	public ArrayList<String> getAllCoRequisites(String programCode){
		/*Returns all corequisites, according to program, like IDS*/
		ArrayList<String> allCorequisites=new ArrayList<String>();
		try{
			String queryString = "SELECT CoRequisito FROM Pensum WHERE ProgramaCodigo=? ORDER BY Trimestre, AsignaturaCodigo;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, programCode);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){ 
//				System.out.println(resultSet.getString("CoRequisito"));
				allCorequisites.add(resultSet.getString("CoRequisito"));			  
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
		return allCorequisites;
		
	}
	
	public int getIdealTrimester(String programCode, String courseCode){
		int idealTrimester=0;
		try{
			String queryString = "SELECT Trimestre FROM Pensum WHERE (ProgramaCodigo=? AND AsignaturaCodigo=?);";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, programCode);
			ptmt.setString(2, courseCode);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){
				idealTrimester=resultSet.getInt("Trimestre");
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
		return idealTrimester;
		
	}
	
	public String getCourseName(String programCode, String courseCode){
		String courseName=null;
		try{
			String queryString = "SELECT Nombre FROM Pensum WHERE (ProgramaCodigo=? AND AsignaturaCodigo=?);";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, programCode);
			ptmt.setString(2, courseCode);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){
				courseName=resultSet.getString("Nombre");
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
		return courseName;
	}
	
	public int getCredits(String programCode, String courseCode){
		int credits=0;
		try{
			String queryString = "SELECT Creditos FROM Pensum WHERE (ProgramaCodigo=? AND AsignaturaCodigo=?);";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, programCode);
			ptmt.setString(2, courseCode);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){
				credits=resultSet.getInt("Creditos");
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
		return credits;
		
	}
	
	/**Returns the prerequisites of a given course on a given program
	 * Parameters:  programCode:'SIS-2010'
	 *              courseCode:'INS203'
	 * Returns an arraylist of strings             */
	public List<String> getPrerequisites(String programCode, String courseCode){
		ArrayList<String> prerequisites=new ArrayList<String>();
		try{
			String queryString = "SELECT Prerrequisitos FROM Pensum WHERE (ProgramaCodigo=? AND AsignaturaCodigo=?);";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, programCode);
			ptmt.setString(2, courseCode);
			resultSet=ptmt.executeQuery();
			if(resultSet.next()){
				prerequisites.add(resultSet.getString("Prerrequisitos"));
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
		return prerequisites;
		
	}
	
	/**Returns the Pensum in Courses objects*/
	public ArrayList<Course> getCourses(String programCode){
		System.out.println(programCode +" PensumsDAO");
		ArrayList<Course> pensum = new ArrayList<Course>();
		
		try{
			String queryString = "SELECT * FROM Pensum WHERE ProgramaCodigo=? ORDER BY Trimestre;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, programCode);
			resultSet=ptmt.executeQuery();
			while(resultSet.next()){
				Course course=new Course();
				ArrayList<String> corequisites=new ArrayList<String>();
				ArrayList<String> prerequisites=new ArrayList<String>();
//				System.out.println(resultSet.getString("AsignaturaCodigo")
//						           +" "+resultSet.getInt("Trimestre")+
//						           " "+resultSet.getInt("RequisitosCreditos")
//						           +" "+resultSet.getString("CoRequisito")
//						           +" "+resultSet.getString("Prerrequisitos")
//						           +" "+resultSet.getString("Nombre")
//						           +" "+resultSet.getInt("Creditos"));
				course.setId(resultSet.getString("AsignaturaCodigo"));
				course.setIdealTrimestrer(resultSet.getInt("Trimestre"));
				course.setCreditsReq(resultSet.getInt("RequisitosCreditos"));
				corequisites.add(resultSet.getString("CoRequisito"));
				course.setCoReqID(corequisites);
				prerequisites.add(resultSet.getString("Prerrequisitos"));
				course.setPreqID(prerequisites);
				course.setName(resultSet.getString("Nombre"));
				course.setCredits(resultSet.getInt("Creditos"));
				System.out.println(course.getId() +" "+ course.getName()+" HEy");
				pensum.add(course);
				
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
		if(pensum.size()==0){
			System.out.println("null-PensumsDAO");
		}

		return pensum;	
	}
	
	
	public static void main(String [] args){
		//For testing, to be deleted
		PensumsDAO psm = new PensumsDAO();
		//psm.show(pensum);
		//psm.getVersion("IDS");
		//psm.getProgramCredits("IDS");
		//psm.getProgramCode(1056025);
		//psm.getTrimester("IDS");
		//psm.getCourseCode("IDS");
		//psm.getCreditsRequirements("IDS");
		//psm.getCoRequisites("IDS");
		StudentsDAO student=new StudentsDAO();
		psm.getCourses(student.getProgramCode(1058691));
	}
	

}
