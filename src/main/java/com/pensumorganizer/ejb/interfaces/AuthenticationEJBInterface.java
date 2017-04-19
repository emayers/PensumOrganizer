package com.pensumorganizer.ejb.interfaces;

import javax.ejb.Remote;

@Remote
public interface AuthenticationEJBInterface {

	public String submit();

	public Integer getUserName();

	public Integer getPassword();
	
	public void setUserName(Integer userName);

	public void setPassword(Integer password);
}