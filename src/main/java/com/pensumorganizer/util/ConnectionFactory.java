package com.pensumorganizer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	
	String connectionString =  
    		"jdbc:sqlserver://podb2.database.windows.net:1433;"
			+"database=PODB2;user=usuario@podb2;password=1234qweR;"
    		+"encrypt=true;trustServerCertificate=false;"
			+"hostNameInCertificate=*.database.windows.net;"
    		+"loginTimeout=30;"; 
	
	String driverClassName="com.sqlserver.jdbc.Driver";
	private static ConnectionFactory connectionFactory = null;
	
	/*private ConnectionFactory() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}*/


	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(connectionString);
		return conn;
	}

	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Connect to your database.  
        // Replace server name, username, and password with your credentials   
            String connectionString =  
            		"jdbc:sqlserver://pensumorganizerdb.database.windows.net:1433;"
            		+ "database=PensumOrganizerDB;"
            		+ "user=usuario@pensumorganizerdb;password=1234qweR;"
            		+ "encrypt=true;"
            		+ "trustServerCertificate=false;"
            		+ "hostNameInCertificate=*.database.windows.net;"
            		+ "loginTimeout=30;";  
            
            // Declare the JDBC objects.  
            Connection connection = null; 
            Statement statement = null;   
            ResultSet resultSet = null;  
            PreparedStatement prepsInsertProduct = null; 

            try {  
            	//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection(connectionString);
                // Create and execute an INSERT SQL prepared statement.  
                String insertSql = "INSERT INTO estudiantePrograma(IdEstudiante, Nombre, ProgramaCodigo, Version, AñoIngreso, TerminoIngreso, AñoLimitePermanencia, TerminoLimitePermanencia, TrimestresCursados, IndiceAcumulado)VALUES(1057100, 'HAYDEE KAROLINA MAYERS RUIZ', 'IDS', 2010, 2013, 3, 2018, 3, 15, 3.50);";  

                prepsInsertProduct = connection.prepareStatement(  
                    insertSql,  
                    Statement.RETURN_GENERATED_KEYS);  
                prepsInsertProduct.execute();  

                // Retrieve the generated key from the insert.  
                resultSet = prepsInsertProduct.getGeneratedKeys();  

                // Print the ID of the inserted row.  
                while (resultSet.next()) {  
                    System.out.println("Generated: " + resultSet.getString(1));  
                }  

            }  
            catch (Exception e) {  
                e.printStackTrace();  
            }  
            finally {  
            	// Close the connections after the data has been handled.  
                if (prepsInsertProduct != null) try { prepsInsertProduct.close(); } catch(Exception e) {}  
                if (resultSet != null) try { resultSet.close(); } catch(Exception e) {}  
                if (statement != null) try { statement.close(); } catch(Exception e) {}  
                if (connection != null) try { connection.close(); } catch(Exception e) {}  
            }  
        }  
	}


	
	
	


