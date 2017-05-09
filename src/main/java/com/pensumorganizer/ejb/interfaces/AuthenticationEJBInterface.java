package com.pensumorganizer.ejb.interfaces;

import javax.ejb.Remote;

@Remote
public interface AuthenticationEJBInterface {

	public String submit();

	public int getUserName();

	public int getPassword();
	
	public void setUserName(int userName);

	public void setPassword(int password);
}
