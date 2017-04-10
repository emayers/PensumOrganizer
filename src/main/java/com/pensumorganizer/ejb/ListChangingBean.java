package com.pensumorganizer.ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.dao.Course;

@ManagedBean
@SessionScoped
public class ListChangingBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Course> newTableData= new ArrayList<Course>();
	
    public Course delete(List<Course> entry ,Course list) {
    	newTableData.add(list);
    	entry.remove(list);
    	return null;
    }

	public List<Course> getNewTableData() {
		return newTableData;
	}
	
	public void setNewTableData(List<Course> newTableData) {
		this.newTableData = newTableData;
	}
}
