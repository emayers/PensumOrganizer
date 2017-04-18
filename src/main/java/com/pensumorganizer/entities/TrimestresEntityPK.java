package com.pensumorganizer.entities;

import java.io.Serializable;

/**
 * ID class for entity: TrimestresEntity
 *
 */ 
public class TrimestresEntityPK  implements Serializable {   
   
	         
	private int Año;         
	private int Termino;
	private static final long serialVersionUID = 1L;

	public TrimestresEntityPK() {}

	

	public int getAño() {
		return this.Año;
	}

	public void setAño(int Año) {
		this.Año = Año;
	}
	

	public int getTermino() {
		return this.Termino;
	}

	public void setTermino(int Termino) {
		this.Termino = Termino;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof TrimestresEntityPK)) {
			return false;
		}
		TrimestresEntityPK other = (TrimestresEntityPK) o;
		return true
			&& getAño() == other.getAño()
			&& getTermino() == other.getTermino();
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getAño();
		result = prime * result + getTermino();
		return result;
	}
   
   
}
