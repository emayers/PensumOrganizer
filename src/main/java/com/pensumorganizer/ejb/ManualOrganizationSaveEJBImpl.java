package com.pensumorganizer.ejb;

import java.util.List;
import java.util.Map;

import javax.ejb.Singleton;

import com.pensumorganizer.dao.Course;
import com.pensumorganizer.ejb.interfaces.ManualOrganizationSaveEJBInterface;
import com.pensumorganizer.managedbeans.AutoPrioritizerBean;

@Singleton
public class ManualOrganizationSaveEJBImpl implements ManualOrganizationSaveEJBInterface {
	
	private static Map<Integer, List<Course>> reorganizedPensum 
					= AutoPrioritizerBean.apEJB.getOrganizedPensum();

	public String saveReorganization(){
		System.out.println("Hey! Saving!");
    	AutoPrioritizerBean.apEJB.setOrganizedPensum(reorganizedPensum);
    	return "VistaPOAuto";
	}
	
}
