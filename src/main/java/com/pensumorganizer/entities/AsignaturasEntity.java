package com.pensumorganizer.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AsignaturasEntity
 *
 */
@Entity
@Table(name="Asignaturas")
public class AsignaturasEntity implements Serializable {

	   
	@Id
	private String AsignaturaCodigo;
	private String Descripcion;
	private String AreaCodigo;
	private String NivelCodigo;
	private int Creditos;
	private static final long serialVersionUID = 1L;

	public AsignaturasEntity() {
		super();
	}   
	public String getAsignaturaCodigo() {
		return this.AsignaturaCodigo;
	}

	public void setAsignaturaCodigo(String AsignaturaCodigo) {
		this.AsignaturaCodigo = AsignaturaCodigo;
	}   
	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}   
	public String getAreaCodigo() {
		return this.AreaCodigo;
	}

	public void setAreaCodigo(String AreaCodigo) {
		this.AreaCodigo = AreaCodigo;
	}   
	public String getNivelCodigo() {
		return this.NivelCodigo;
	}

	public void setNivelCodigo(String NivelCodigo) {
		this.NivelCodigo = NivelCodigo;
	}   
	public int getCreditos() {
		return this.Creditos;
	}

	public void setCreditos(int Creditos) {
		this.Creditos = Creditos;
	}
   
}
