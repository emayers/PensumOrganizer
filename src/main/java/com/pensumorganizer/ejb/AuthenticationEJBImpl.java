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
	
	private Integer userName;
    private Integer password;
    private String outPut;
    		
    public String submit() {	
    	if(!(validUserNames.contains(userName) && 
    			students.getPassword(userName).equals(password))){
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ID o Contraseña incorecta, intente de nuevo", ""));
    	}
    	else{
    		System.out.println("hey!");
    		outPut = "VistaDashboard";
    	}
    	
    	return outPut;
    }

	public Integer getUserName() {
		return userName;
	}

	public void setUserName(Integer userName) {
		this.userName = userName;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer passWord) {
		this.password = passWord;
	}

}
