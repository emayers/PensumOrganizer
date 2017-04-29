package com.pensumorganizer.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: AreasEntity
 *
 */
@Entity
@Table(name="Areas")
public class AreasEntity implements Serializable {

	   
	@Id
	private String AreaCodigo;
	private String Descripcion;
	private static final long serialVersionUID = 1L;

	public AreasEntity() {
		super();
	}   
	public String getAreaCodigo() {
		return this.AreaCodigo;
	}

	public void setAreaCodigo(String AreaCodigo) {
		this.AreaCodigo = AreaCodigo;
	}   
	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}
   
}
