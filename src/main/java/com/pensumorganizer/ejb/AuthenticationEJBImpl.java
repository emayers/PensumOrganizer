package com.pensumorganizer.ejb;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.pensumorganizer.ejb.interfaces.AuthenticationEJBInterface;

@Stateless
public class AuthenticationEJBImpl implements AuthenticationEJBInterface {
	
//	private static EstudianteProgramaDao studentsProgram = new EstudianteProgramaDao();
//	private static List<Integer> validUserNames = studentsProgram.getAllIds();
	private static Map<Integer, Integer> validUserNames = new HashMap<Integer, Integer>();

	
	private Integer userName;
    private Integer password;
    private String outPut;

    public String submit() {
    	validUserNames.put(1057100, 111111);
    	validUserNames.put(1057512, 222222);
    	validUserNames.put(1056025, 333333);
    	validUserNames.put(1045782, 444444);
    	validUserNames.put(1058691, 555555);
    	
    	if(!(validUserNames.containsKey(userName) && 
    			validUserNames.get(userName).equals(password))){
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
