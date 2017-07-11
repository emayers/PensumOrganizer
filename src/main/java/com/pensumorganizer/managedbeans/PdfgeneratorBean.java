package com.pensumorganizer.managedbeans;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import com.pensumorganizer.ejb.Pdfgenerator;

@ManagedBean
@SessionScoped
public class PdfgeneratorBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	public static Pdfgenerator Pg = new Pdfgenerator();
	
	public void generator() throws ServletException, IOException {
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		Pg.generator(response);
	}
}
