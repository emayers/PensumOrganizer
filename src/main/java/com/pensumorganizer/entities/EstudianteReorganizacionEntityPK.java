package com.pensumorganizer.entities;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: EstudianteReorganizacionEntity
 *
 */ 
public class EstudianteReorganizacionEntityPK  implements Serializable {   
   
	         
	private int IdEstudiante;         
	private String AsignaturaCodigo;
	private static final long serialVersionUID = 1L;

	public EstudianteReorganizacionEntityPK() {}

	

	public int getIdEstudiante() {
		return this.IdEstudiante;
	}

	public void setIdEstudiante(int IdEstudiante) {
		this.IdEstudiante = IdEstudiante;
	}
	

	public String getAsignaturaCodigo() {
		return this.AsignaturaCodigo;
	}

	public void setAsignaturaCodigo(String AsignaturaCodigo) {
		this.AsignaturaCodigo = AsignaturaCodigo;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof EstudianteReorganizacionEntityPK)) {
			return false;
		}
		EstudianteReorganizacionEntityPK other = (EstudianteReorganizacionEntityPK) o;
		return true
			&& getIdEstudiante() == other.getIdEstudiante()
			&& (getAsignaturaCodigo() == null ? other.getAsignaturaCodigo() == null : getAsignaturaCodigo().equals(other.getAsignaturaCodigo()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getIdEstudiante();
		result = prime * result + (getAsignaturaCodigo() == null ? 0 : getAsignaturaCodigo().hashCode());
		return result;
	}
   
   
}
