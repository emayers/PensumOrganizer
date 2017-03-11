package com.pensumorganizer.ejb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class AuthenticationBean {
	private Integer userName;
	private List<Integer> validUserNames = {1057100, 1057512, 1056025, 1045782};
    private Integer password;
    private String outPut;

    public void submit() {
    	if(validUserNames.)
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
