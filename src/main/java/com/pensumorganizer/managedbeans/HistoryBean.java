package com.pensumorganizer.managedbeans;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.dao.Course;
import com.pensumorganizer.ejb.HistoryEJBImpl;

@ManagedBean
@SessionScoped
public class HistoryBean {
	
	@EJB
	HistoryEJBImpl hEJB = new HistoryEJBImpl();
	
	public Map<Integer, List<Course>> getTrimester() {
		return hEJB.getHistory();
	}
}
