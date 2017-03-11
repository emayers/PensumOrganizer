package com.pensumorganizer.ejb;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class AuthenticationBean {
	private Integer userName;
	private static Map<Integer, Integer> validUserNames = new HashMap<Integer, Integer>();
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
    		outPut = "Error";
    	}
    	else{
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
