package com.pensumorganizer.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EstudianteReorganizacionEntity
 *
 */
@Entity
@Table(name="EstudianteReorganizacion")
@IdClass(EstudianteReorganizacionEntityPK.class)
public class EstudianteReorganizacionEntity implements Serializable {

	   
	@Id
	private int IdEstudiante;   
	@Id
	private String AsignaturaCodigo;
	private String Descripcion;
	private int Termino;
	private String TerminoDescripcion;
	private int Creditos;
	private String Prerrequisito;
	private int RequisitoCred;
	private String Corequisito;
	private static final long serialVersionUID = 1L;

	public EstudianteReorganizacionEntity() {
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
	public int getTermino() {
		return this.Termino;
	}

	public void setTermino(int Termino) {
		this.Termino = Termino;
	}   
	public String getTerminoDescripcion() {
		return this.TerminoDescripcion;
	}

	public void setTerminoDescripcion(String TerminoDescripcion) {
		this.TerminoDescripcion = TerminoDescripcion;
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
	public int getRequisitoCred() {
		return this.RequisitoCred;
	}

	public void setRequisitoCred(int RequisitoCred) {
		this.RequisitoCred = RequisitoCred;
	}   
	public String getCorequisito() {
		return this.Corequisito;
	}

	public void setCorequisito(String Corequisito) {
		this.Corequisito = Corequisito;
	}
   
}
