package com.pensumorganizer.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TrimestresEntity
 *
 */
@Entity
@Table(name="Trimestres")
@IdClass(TrimestresEntityPK.class)
public class TrimestresEntity implements Serializable {

	   
	@Id
	private int A�o;   
	@Id
	private int Termino;
	private String Descripcion;
	private static final long serialVersionUID = 1L;

	public TrimestresEntity() {
		super();
	}   
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
	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}
   
}
