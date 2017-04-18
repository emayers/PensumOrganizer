package com.pensumorganizer.entities;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: PensumEntity
 *
 */ 
public class PensumEntityPK  implements Serializable {   
   
	         
	private int Version;         
	private String ProgramaCodigo;         
	private String AsignaturaCodigo;
	private static final long serialVersionUID = 1L;

	public PensumEntityPK() {}

	

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
		if (!(o instanceof PensumEntityPK)) {
			return false;
		}
		PensumEntityPK other = (PensumEntityPK) o;
		return true
			&& getVersion() == other.getVersion()
			&& (getProgramaCodigo() == null ? other.getProgramaCodigo() == null : getProgramaCodigo().equals(other.getProgramaCodigo()))
			&& (getAsignaturaCodigo() == null ? other.getAsignaturaCodigo() == null : getAsignaturaCodigo().equals(other.getAsignaturaCodigo()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getVersion();
		result = prime * result + (getProgramaCodigo() == null ? 0 : getProgramaCodigo().hashCode());
		result = prime * result + (getAsignaturaCodigo() == null ? 0 : getAsignaturaCodigo().hashCode());
		return result;
	}
   
   
}
