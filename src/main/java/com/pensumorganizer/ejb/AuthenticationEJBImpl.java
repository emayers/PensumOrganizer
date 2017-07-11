package com.pensumorganizer.ejb;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.ejb.Stateful;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.pensumorganizer.dao.StudentsDAO;
import com.pensumorganizer.ejb.interfaces.AuthenticationEJBInterface;
import com.pensumorganizer.managedbeans.AutoPrioritizerBean;

@Stateful
public class AuthenticationEJBImpl implements AuthenticationEJBInterface {
	
	private static StudentsDAO students;
	private static List<Integer> validUserNames;
	
	private int userName;
    private int password;
    
    public void submit() {
    	students = new StudentsDAO();
    	validUserNames = students.getAllIds();
    	
    	if(!(validUserNames.contains(userName) && 
    			students.getPassword(userName).equals(password))){
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ID o Contraseña incorecta, intente de nuevo", ""));
    	}
    	else{
			redirectDashboard();
    	}
    }

    public void logOut() {
    	try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("Login.xhtml");
		} 
    	catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public String getStudentName() {
    	return students.getName(userName);
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
    
    public String getName() {
    	return students.getName(userName);
    }

	public String getGPA() {
		DecimalFormat format = new DecimalFormat("#.##");
		double gpa = students.getGPA(userName);
		
		return format.format(gpa);
	}

	public int getCoursedTrimesters() {
		return students.getStudiedTrimesters(userName);
	}
	
	public void redirectDashboard(){
		try {
			if(AutoPrioritizerBean.apEJB.getOrganizedPensum().isEmpty()){
				FacesContext.getCurrentInstance().getExternalContext().redirect("Dashboard_Init.xhtml");
			}
			else{
				FacesContext.getCurrentInstance().getExternalContext().redirect("Dashboard.xhtml");
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void redirectHelp(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("Help.xhtml");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
