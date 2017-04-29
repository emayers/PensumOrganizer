package com.pensumorganizer.dao;

import java.util.ArrayList;

public class Prerrequisito {
	String subject; 
	ArrayList<String> preReq=new ArrayList<String>();

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public ArrayList<String> getPreReq() {
		return preReq;
	}

	public void setPreReq(ArrayList<String> preReq) {
		this.preReq = preReq;
	}
}
