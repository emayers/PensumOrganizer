package com.pensumorganizer.entities;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: CalificacionesEntity
 *
 */ 
public class CalificacionesEntityPK  implements Serializable {   
   
	         
	private String Nivel;         
	private String CalificacionCodigo;
	private static final long serialVersionUID = 1L;

	public CalificacionesEntityPK() {}

	

	public String getNivel() {
		return this.Nivel;
	}

	public void setNivel(String Nivel) {
		this.Nivel = Nivel;
	}
	

	public String getCalificacionCodigo() {
		return this.CalificacionCodigo;
	}

	public void setCalificacionCodigo(String CalificacionCodigo) {
		this.CalificacionCodigo = CalificacionCodigo;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof CalificacionesEntityPK)) {
			return false;
		}
		CalificacionesEntityPK other = (CalificacionesEntityPK) o;
		return true
			&& (getNivel() == null ? other.getNivel() == null : getNivel().equals(other.getNivel()))
			&& (getCalificacionCodigo() == null ? other.getCalificacionCodigo() == null : getCalificacionCodigo().equals(other.getCalificacionCodigo()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getNivel() == null ? 0 : getNivel().hashCode());
		result = prime * result + (getCalificacionCodigo() == null ? 0 : getCalificacionCodigo().hashCode());
		return result;
	}
   
   
}
