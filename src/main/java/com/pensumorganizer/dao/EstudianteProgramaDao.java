package com.pensumorganizer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pensumorganizer.connectionfactory.ConnectionFactory;

public class EstudianteProgramaDao {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	public EstudianteProgramaDao() {
		super();
	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	/*Returns student's name*/
	
	public String getName(Integer id){

		String res=null;
		 try {				    
				String queryString = "SELECT Nombre FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setInt(1, id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
					System.out.println(resultSet.getString("Nombre") );
					res=resultSet.getString("Nombre");
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

	/*Returns student's id, maybe useless*/
	
	public Integer getStudentId(Integer id){//check
		Integer res=0;
		 try {				    
				String queryString = "SELECT IdEstudiante FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setInt(1, id);
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

	/*Returns the program code, for example: IDS*/
	
	public String getProgramCode(Integer id){
		String res=null;
		 try {				    
				String queryString = "SELECT ProgramaCodigo FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setInt(1, id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
					System.out.println(resultSet.getString("ProgramaCodigo"));
					res=resultSet.getString("ProgramaCodigo");
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

	/*Returns year of approval of Pensum, for example, our pensum is the 2010 version*/
	
	public Integer getVersion(Integer id){
		Integer res=0;

		 try {				    
				String queryString = "SELECT Version FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setInt(1, id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
					System.out.println(resultSet.getInt("Version"));
					res=resultSet.getInt("Version");
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

	/*Return the year of admission of the student*/
	
	public Integer getAdmissionYear(Integer id){
		Integer res=0;
		 try {				    
				String queryString = "SELECT AñoIngreso FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setInt(1, id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
					System.out.println(resultSet.getInt("AñoIngreso"));
					res=resultSet.getInt("AñoIngreso");
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
	

	/*Returns term of admission, remembering that:
	 * 1 stands for AGOSTO-OCTUBRE
	 * 2 stands for FEBRERO-ABRIL
	 * 3 stands for MARZO-ABRIL
	 * 4 stands for MAYO-JULIO*/
	public Integer getAdmissionTerm(Integer id){
		Integer res=0;
		 try {				    
				String queryString = "SELECT TerminoIngreso FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setInt(1, id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
					System.out.println(resultSet.getInt("TerminoIngreso"));
					res=resultSet.getInt("TerminoIngreso");
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
	

	/*Returns the student's limit permanence year*/
	public Integer getLimitPermanenceYear(Integer id){
		Integer res=0;
		 try {				    
				String queryString = "SELECT AñoLimitePermanencia FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setInt(1, id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
					System.out.println(resultSet.getInt("AñoLimitePermanencia"));
					res=resultSet.getInt("AñoLimitePermanencia");
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

	/*Returns limit permanence term, remembering that:
	 * 1 stands for AGOSTO-OCTUBRE
	 * 2 stands for FEBRERO-ABRIL
	 * 3 stands for MARZO-ABRIL
	 * 4 stands for MAYO-JULIO*/	
	public Integer getLimitPermanenceTerm(Integer id){
		Integer res=0;
		 try {				    
				String queryString = "SELECT TerminoLimitePermanencia FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setInt(1, id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
					System.out.println(resultSet.getInt("TerminoLimitePermanencia"));
					res=resultSet.getInt("TerminoLimitePermanencia");
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

	/*Returns the number of trimesters the student has been active, for example, 
	 * we have 15 studied trimesters (16 counting this one)*/	
	public Integer getStudiedTrimesters(Integer id){
		Integer res=0;
		 try {				    
				String queryString = "SELECT TrimestresCursados FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setInt(1, id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
					System.out.println(resultSet.getInt("TrimestresCursados"));
					res=resultSet.getInt("TrimestresCursados");
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
	/*Returns the student's general index or whatever it's name is (índice general)*/
	
	public double getIndex(Integer id){
		double res=0;
		 try {				    
				String queryString = "SELECT IndiceAcumulado FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setInt(1,id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
					System.out.println(resultSet.getDouble("IndiceAcumulado"));
					res=resultSet.getDouble("IndiceAcumulado");
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

	/*Returns the student's password*/	
	public Integer getPassword(Integer id){
		Integer res=0;
		 try {				    
				String queryString = "SELECT Password FROM EstudiantePrograma WHERE IdEstudiante=?;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				ptmt.setInt(1, id);
				resultSet=ptmt.executeQuery();
				if(resultSet.next())
				  { 
					System.out.println(resultSet.getInt("Password"));
					res=resultSet.getInt("Password");
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

	/*Sets the student's password*/
	
	public void setPassword(Integer id, Integer psswd){

		try {				    
			String queryString = "UPDATE EstudiantePrograma SET Password=? WHERE IdEstudiante=?;";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, psswd);
			ptmt.setInt(2, id);
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

	/*Returns all the ids of all the students*/
	public ArrayList<Integer> getAllIds(){
		ArrayList<Integer> res=new ArrayList<Integer>();
		 try {				    
				String queryString = "SELECT IdEstudiante FROM EstudiantePrograma;";
				connection = getConnection();
				ptmt = connection.prepareStatement(queryString);
				resultSet=ptmt.executeQuery();
				while(resultSet.next())
				  { 
					System.out.println(resultSet.getInt("IdEstudiante"));
					res.add(resultSet.getInt("IdEstudiante"));
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

	/*Adds a new student, for connection testing purposes only*/
	public void add (){
		try {	
			String queryString = "INSERT INTO estudiantePrograma(IdEstudiante, Nombre, ProgramaCodigo, Version, AñoIngreso, TerminoIngreso, AñoLimitePermanencia, TerminoLimitePermanencia, TrimestresCursados, IndiceAcumulado)VALUES(1057512, 'NEY EMANUEL CASILLA VEGA', 'IDS', 2010, 2013, 3, 2018, 3, 15, 3.50);";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.executeUpdate();
			System.out.println("Data Added Successfully");
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
	
	/*For testing, to be deleted*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EstudianteProgramaDao Estudiante = new EstudianteProgramaDao();
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


