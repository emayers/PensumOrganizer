package com.pensumorganizer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pensumorganizer.util.ConnectionFactory;

public class StudentsDAO {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	public StudentsDAO() {
		super();
	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	
	public String getName(Integer id){
		/*Returns student's name*/
		String name=null;
		 try {				    
				String queryString = "SELECT Nombre FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setObject(1, id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
//					System.out.println(resultSet.getString("Nombre") );
					name=resultSet.getString("Nombre");
				  }
				
			} catch (SQLException e) {
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
		return name;
		 
	}

	
	
	public Integer getStudentId(Integer id){//check
		/*Returns student's id, maybe useless*/
		Integer res=0;
		 try {				    
				String queryString = "SELECT IdEstudiante FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setObject(1, id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
					System.out.println(resultSet.getInt("IdEstudiante"));
					res=resultSet.getInt("IdEstudiante");
				  }
			} catch (SQLException e) {
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

	
	
	public String getProgramCode(Integer id){
		/*Returns the program code, for example: IDS*/
		String programCode=null;
		 try {				    
				String queryString = "SELECT ProgramaCodigo FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setObject(1, id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
//					System.out.println(resultSet.getString("ProgramaCodigo"));
					programCode=resultSet.getString("ProgramaCodigo");
				  }
			} catch (SQLException e) {
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

	
	
	public Integer getProgramVersion(Integer id){
		/*Returns year of approval of Pensum, for example, our pensum is the 2010 version*/
		Integer programVersion = 0;

		 try {				    
				String queryString = "SELECT Version FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setObject(1, id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
//					System.out.println(resultSet.getInt("Version"));
					programVersion=resultSet.getInt("Version");
				  }
			} catch (SQLException e) {
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
		return programVersion;
	}

	
	
	public Integer getAdmissionYear(Integer id){
		/*Return the year of admission of the student*/
		Integer admissionYear=0;
		 try {				    
				String queryString = "SELECT AñoIngreso FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setObject(1, id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
//					System.out.println(resultSet.getInt("AñoIngreso"));
					admissionYear=resultSet.getInt("AñoIngreso");
				  }
			} catch (SQLException e) {
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
		return admissionYear;
	}
	

	
	public Integer getAdmissionTerm(Integer id){
		/*Returns term of admission, remembering that:
		 * 1 stands for AGOSTO-OCTUBRE
		 * 2 stands for FEBRERO-ABRIL
		 * 3 stands for MARZO-ABRIL
		 * 4 stands for MAYO-JULIO*/
		Integer admissionTerm=0;
		 try {				    
				String queryString = "SELECT TerminoIngreso FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setObject(1, id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
//					System.out.println(resultSet.getInt("TerminoIngreso"));
					admissionTerm=resultSet.getInt("TerminoIngreso");
				  }
			} catch (SQLException e) {
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
		return admissionTerm;
	}
	

	
	public Integer getLimitPermanenceYear(Integer id){
		/*Returns the student's limit permanence year*/
		Integer limitPermanenceYear=0;
		 try {				    
				String queryString = "SELECT AñoLimitePermanencia FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setObject(1, id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
//					System.out.println(resultSet.getInt("AñoLimitePermanencia"));
					limitPermanenceYear=resultSet.getInt("AñoLimitePermanencia");
				  }
			} catch (SQLException e) {
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
		return limitPermanenceYear;
	}

		
	public Integer getLimitPermanenceTerm(Integer id){
		/*Returns limit permanence term, remembering that:
		 * 1 stands for AGOSTO-OCTUBRE
		 * 2 stands for FEBRERO-ABRIL
		 * 3 stands for MARZO-ABRIL
		 * 4 stands for MAYO-JULIO*/
		Integer limitPermanenceTerm=0;
		 try {				    
				String queryString = "SELECT TerminoLimitePermanencia FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setObject(1, id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
//					System.out.println(resultSet.getInt("TerminoLimitePermanencia"));
					limitPermanenceTerm=resultSet.getInt("TerminoLimitePermanencia");
				  }
			} catch (SQLException e) {
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
		return limitPermanenceTerm;
	}

		
	public Integer getStudiedTrimesters(Integer id){
		/*Returns the number of trimesters the student has been active, for example, 
		 * we have 15 studied trimesters (16 counting this one)*/
		 Integer studiedTrimesters=0;
		 try {				    
				String queryString = "SELECT TrimestresCursados FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setObject(1, id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
//					System.out.println(resultSet.getInt("TrimestresCursados"));
					studiedTrimesters=resultSet.getInt("TrimestresCursados");
				  }
			} catch (SQLException e) {
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
		return studiedTrimesters;
	}
	/*Returns the student's general index or whatever it's name is (índice general)*/
	
	public double getGPA(Integer id){
		double GPA=0;
		 try {				    
				String queryString = "SELECT IndiceAcumulado FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setObject(1,id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
//					System.out.println(resultSet.getDouble("IndiceAcumulado"));
					GPA=resultSet.getDouble("IndiceAcumulado");
				  }
			} catch (SQLException e) {
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
		return GPA;
	}

		
	public Integer getPassword(Integer id){
		/*Returns the student's password*/
		Integer password=0;
		 try {				    
				String queryString = "SELECT Password FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setObject(1, id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
//					System.out.println(resultSet.getInt("Password"));
					password=resultSet.getInt("Password");
				  }
			} catch (SQLException e) {
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
		return password;
	}

	
	
	public void setPassword(Integer id, Integer password){
		/*Sets the student's password*/

		try {				    
			String queryString = "UPDATE EstudiantePrograma SET Password=? WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setObject(1, password);
			ptmt.setObject(2, id);
			ptmt.executeUpdate();
			
		} catch (SQLException e) {
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

	
	public ArrayList<Integer> getAllIds(){
		/*Returns all the ids of all the students*/
		ArrayList<Integer> listOfAllIds=new ArrayList<Integer>();
		 try {				    
				String queryString = "SELECT IdEstudiante FROM EstudiantePrograma;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				resultSet=ptmt.executeQuery();
				while(resultSet.next())
				  { 
//					System.out.println(resultSet.getInt("IdEstudiante"));
					listOfAllIds.add(resultSet.getInt("IdEstudiante"));
				  }
			} catch (SQLException e) {
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
		return listOfAllIds;
	}

		
	

	public static void main(String[] args) {
		/*For testing, to be deleted*/
		// TODO Auto-generated method stub
		StudentsDAO Estudiante = new StudentsDAO();
		//Estudiante.add();
		 //EstudianteProgramaEntity ent = new EstudianteProgramaEntity();
		 //ent.setIdEstudiante(1056025);
		//Estudiante.getName(1056025);
//		Estudiante.getStudentId(1056025);
//		Estudiante.getProgramCode(1056025);
//		Estudiante.getVersion(1056025);
//		Estudiante.getAdmissionYear(1056025);
//		Estudiante.getAdmissionTerm(1056025);
//		Estudiante.getLimitPermanenceYear(1056025);
//		Estudiante.getLimitPermanenceTerm(1056025);
//		Estudiante.getStudiedTrimesters(1056025);
//		Estudiante.getIndex(1056025);
		// Estudiante.setPassword(1056025, 123456);
		//Estudiante.getPassword(1056025);
		 Estudiante.getAllIds();
    }  

	}


