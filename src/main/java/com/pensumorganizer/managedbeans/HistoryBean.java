package com.pensumorganizer.managedbeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.dao.Course;
import com.pensumorganizer.ejb.HistoryEJBImpl;

@ManagedBean
@SessionScoped
public class HistoryBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	HistoryEJBImpl hEJB = new HistoryEJBImpl();
	
	@PostConstruct
	private void prepare(){
		hEJB.recreateHistory();
	}
	
	public Map<Integer, List<Course>> getTrimester() {
		return hEJB.getHistory();
	}
}
