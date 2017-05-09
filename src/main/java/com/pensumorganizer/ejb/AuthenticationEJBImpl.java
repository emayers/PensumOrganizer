package com.pensumorganizer.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.pensumorganizer.dao.StudentsDAO;
import com.pensumorganizer.ejb.interfaces.AuthenticationEJBInterface;

@Stateless
public class AuthenticationEJBImpl implements AuthenticationEJBInterface {
	
	private static StudentsDAO students = new StudentsDAO();
	private static List<Integer> validUserNames = students.getAllIds();
	
	private int userName;
    private int password;
    private String outPut;
    		
    public String submit() {	
    	if(!(validUserNames.contains(userName) && 
    			students.getPassword(userName).equals(password))){
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ID o Contraseņa incorecta, intente de nuevo", ""));
    	}
    	else{
    		System.out.println("hey!");
    		outPut = "VistaDashboard";
    	}
    	
    	return outPut;
    }

	public int getUserName() {
		return userName;
	}

	public void setUserName(int userName) {
		this.userName = userName;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int passWord) {
		this.password = passWord;
	}

}
