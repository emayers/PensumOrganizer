package com.pensumorganizer.entities;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: PrerrequisitosEntity
 *
 */ 
public class PrerrequisitosEntityPK  implements Serializable {   
   
	         
	private int Version;         
	private String ProgramaCodigo;         
	private String Asignatura;
	private static final long serialVersionUID = 1L;

	public PrerrequisitosEntityPK() {}

	

	public int getVersion() {
		return this.Version;
	}

	public void setVersion(int Version) {
		this.Version = Version;
	}
	

	public String getProgramaCodigo() {
		return this.ProgramaCodigo;
	}

	public void setProgramaCodigo(String ProgramaCodigo) {
		this.ProgramaCodigo = ProgramaCodigo;
	}
	

	public String getAsignatura() {
		return this.Asignatura;
	}

	public void setAsignatura(String Asignatura) {
		this.Asignatura = Asignatura;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof PrerrequisitosEntityPK)) {
			return false;
		}
		PrerrequisitosEntityPK other = (PrerrequisitosEntityPK) o;
		return true
			&& getVersion() == other.getVersion()
			&& (getProgramaCodigo() == null ? other.getProgramaCodigo() == null : getProgramaCodigo().equals(other.getProgramaCodigo()))
			&& (getAsignatura() == null ? other.getAsignatura() == null : getAsignatura().equals(other.getAsignatura()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getVersion();
		result = prime * result + (getProgramaCodigo() == null ? 0 : getProgramaCodigo().hashCode());
		result = prime * result + (getAsignatura() == null ? 0 : getAsignatura().hashCode());
		return result;
	}
   
   
}
