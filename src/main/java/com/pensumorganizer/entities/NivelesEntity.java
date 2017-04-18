package com.pensumorganizer.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: NivelesEntity
 *
 */
@Entity
@Table(name="Niveles")
public class NivelesEntity implements Serializable {

	   
	@Id
	private String NivelCodigo;
	private String Descripcion;
	private static final long serialVersionUID = 1L;

	public NivelesEntity() {
		super();
	}   
	public String getNivelCodigo() {
		return this.NivelCodigo;
	}

	public void setNivelCodigo(String NivelCodigo) {
		this.NivelCodigo = NivelCodigo;
	}   
	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}
   
}
