package com.pensumorganizer.ejb;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.dao.Course;



@ManagedBean
@SessionScoped
public class DialogBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer trimesterPosition;
	
	@PostConstruct
    public void add(LinkedHashMap<Integer,List<Course>> pensumMap,List<Course> noSelectData,Course subject){
    	System.out.println(getTrimesterPosition());
    	List<Course> desiredTrimester = pensumMap.get(getTrimesterPosition()-1); 
    	desiredTrimester.add(subject);
    	noSelectData.remove(subject);
    }
	public Integer getTrimesterPosition() {
		return trimesterPosition;
	}
	public void setTrimesterPosition(Integer trimesterPosition) {
		this.trimesterPosition = trimesterPosition;
	}
	

}
