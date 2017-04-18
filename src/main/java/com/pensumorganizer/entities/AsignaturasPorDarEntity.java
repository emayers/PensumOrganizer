package com.pensumorganizer.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AsignaturasPorDarEntity
 *
 */
@Entity
@Table(name="AsignaturasPorDar")
@IdClass(AsignaturasPorDarEntityPK.class)
public class AsignaturasPorDarEntity implements Serializable {

	   
	@Id
	private int IdEstudiante;   
	@Id
	private String AsignaturaCodigo;
	private String Descripcion;
	private int Creditos;
	private String Prerrequisito;
	private String CoRequisito;
	private int ReqCreditos;
	private static final long serialVersionUID = 1L;

	public AsignaturasPorDarEntity() {
		super();
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
	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}   
	public int getCreditos() {
		return this.Creditos;
	}

	public void setCreditos(int Creditos) {
		this.Creditos = Creditos;
	}   
	public String getPrerrequisito() {
		return this.Prerrequisito;
	}

	public void setPrerrequisito(String Prerrequisito) {
		this.Prerrequisito = Prerrequisito;
	}   
	public String getCoRequisito() {
		return this.CoRequisito;
	}

	public void setCoRequisito(String CoRequisito) {
		this.CoRequisito = CoRequisito;
	}   
	public int getReqCreditos() {
		return this.ReqCreditos;
	}

	public void setReqCreditos(int ReqCreditos) {
		this.ReqCreditos = ReqCreditos;
	}
   
}
