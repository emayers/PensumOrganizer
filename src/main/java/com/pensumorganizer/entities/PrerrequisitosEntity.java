package com.pensumorganizer.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PrerrequisitosEntity
 *
 */
@Entity
@Table(name="Prerrequisitos")

@IdClass(PrerrequisitosEntityPK.class)
public class PrerrequisitosEntity implements Serializable {

	   
	@Id
	private int Version;   
	@Id
	private String ProgramaCodigo;   
	@Id
	private String Asignatura;
	private int SecuenciaAsignatura;
	private int SecuenciaPrerrequisito;
	private String Prerrequisito;
	private static final long serialVersionUID = 1L;

	public PrerrequisitosEntity() {
		super();
	}   
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
	public int getSecuenciaAsignatura() {
		return this.SecuenciaAsignatura;
	}

	public void setSecuenciaAsignatura(int SecuenciaAsignatura) {
		this.SecuenciaAsignatura = SecuenciaAsignatura;
	}   
	public int getSecuenciaPrerrequisito() {
		return this.SecuenciaPrerrequisito;
	}

	public void setSecuenciaPrerrequisito(int SecuenciaPrerrequisito) {
		this.SecuenciaPrerrequisito = SecuenciaPrerrequisito;
	}   
	public String getPrerrequisito() {
		return this.Prerrequisito;
	}

	public void setPrerrequisito(String Prerrequisito) {
		this.Prerrequisito = Prerrequisito;
	}
   
}
