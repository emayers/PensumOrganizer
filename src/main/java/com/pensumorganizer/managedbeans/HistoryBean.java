package com.pensumorganizer.managedbeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.ejb.HistoryEJBImpl;
import com.pensumorganizer.util.structures.Course;

@ManagedBean
@SessionScoped
public class HistoryBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	public static HistoryEJBImpl hEJB = new HistoryEJBImpl();
	
	public Map<Integer, List<Course>> getTrimester() {
		return hEJB.getHistory();
	}
}
