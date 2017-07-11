package com.pensumorganizer.ejb.interfaces;

import javax.ejb.Remote;

@Remote
public interface AuthenticationEJBInterface {

	public void submit();
	
	public void logOut();
	
	public String getStudentName();

	public int getUserName();

	public int getPassword();
	
	public void setUserName(int userName);

	public void setPassword(int password);
	
	public String getName();
	
	public String getGPA();
	
	public int getCoursedTrimesters();
		
	public void redirectDashboard();
	
	public void redirectHelp();
	
}
