package com.pensumorganizer.ejb.interfaces;

import javax.ejb.Remote;

@Remote
public interface StudentEJBInterface {

	public String getStudentName();	
}
