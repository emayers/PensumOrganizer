package com.pensumorganizer.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ProgramasEntity
 *
 */
@Entity
@Table(name="Programas")

public class ProgramasEntity implements Serializable {

	   
	@Id
	private String ProgramaCodigo;
	private String Descripcion;
	private String AreaCodigo;
	private String NivelCodigo;
	private static final long serialVersionUID = 1L;

	public ProgramasEntity() {
		super();
	}   
	public String getProgramaCodigo() {
		return this.ProgramaCodigo;
	}

	public void setProgramaCodigo(String ProgramaCodigo) {
		this.ProgramaCodigo = ProgramaCodigo;
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
   
}
