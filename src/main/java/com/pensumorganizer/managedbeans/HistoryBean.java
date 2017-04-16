package com.pensumorganizer.managedbeans;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.dao.Course;
import com.pensumorganizer.ejb.GetHistory;

@ManagedBean
@SessionScoped
public class HistoryBean {
	Map<Integer, List<Course>> historic;
	
	@PostConstruct
	public void prepare(){
		historic = GetHistory.getHistory();
	}
	
	public Map<Integer, List<Course>> getTrimester() {
		return historic;
	}
}
