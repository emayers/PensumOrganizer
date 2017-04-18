package com.pensumorganizer.entities;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: HistoricoCursadasEntity
 *
 */ 
public class HistoricoCursadasEntityPK  implements Serializable {   
   
	         
	private int A�o;         
	private int Termino;         
	private int IdEstudiante;         
	private String AsignaturaCodigo;         
	private String TipoSeccion;
	private static final long serialVersionUID = 1L;

	public HistoricoCursadasEntityPK() {}

	

	public int getA�o() {
		return this.A�o;
	}

	public void setA�o(int A�o) {
		this.A�o = A�o;
	}
	

	public int getTermino() {
		return this.Termino;
	}

	public void setTermino(int Termino) {
		this.Termino = Termino;
	}
	

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
	

	public String getTipoSeccion() {
		return this.TipoSeccion;
	}

	public void setTipoSeccion(String TipoSeccion) {
		this.TipoSeccion = TipoSeccion;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof HistoricoCursadasEntityPK)) {
			return false;
		}
		HistoricoCursadasEntityPK other = (HistoricoCursadasEntityPK) o;
		return true
			&& getA�o() == other.getA�o()
			&& getTermino() == other.getTermino()
			&& getIdEstudiante() == other.getIdEstudiante()
			&& (getAsignaturaCodigo() == null ? other.getAsignaturaCodigo() == null : getAsignaturaCodigo().equals(other.getAsignaturaCodigo()))
			&& (getTipoSeccion() == null ? other.getTipoSeccion() == null : getTipoSeccion().equals(other.getTipoSeccion()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getA�o();
		result = prime * result + getTermino();
		result = prime * result + getIdEstudiante();
		result = prime * result + (getAsignaturaCodigo() == null ? 0 : getAsignaturaCodigo().hashCode());
		result = prime * result + (getTipoSeccion() == null ? 0 : getTipoSeccion().hashCode());
		return result;
	}
   
   
}
