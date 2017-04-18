package com.pensumorganizer.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ElectivasEntity
 *
 */
@Entity
@Table(name="Electivas")
@IdClass(ElectivasEntityPK.class)
public class ElectivasEntity implements Serializable {

	   
	@Id
	private int Version;   
	@Id
	private String ProgramaCodigo;   
	@Id
	private String AsignaturaCodigo;
	private int SecuenciaAsignatura;
	private int SecuenciaElectiva;   
	@Id
	private String Electiva;
	private static final long serialVersionUID = 1L;

	public ElectivasEntity() {
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
	public String getAsignaturaCodigo() {
		return this.AsignaturaCodigo;
	}

	public void setAsignaturaCodigo(String AsignaturaCodigo) {
		this.AsignaturaCodigo = AsignaturaCodigo;
	}   
	public int getSecuenciaAsignatura() {
		return this.SecuenciaAsignatura;
	}

	public void setSecuenciaAsignatura(int SecuenciaAsignatura) {
		this.SecuenciaAsignatura = SecuenciaAsignatura;
	}   
	public int getSecuenciaElectiva() {
		return this.SecuenciaElectiva;
	}

	public void setSecuenciaElectiva(int SecuenciaElectiva) {
		this.SecuenciaElectiva = SecuenciaElectiva;
	}   
	public String getElectiva() {
		return this.Electiva;
	}

	public void setElectiva(String Electiva) {
		this.Electiva = Electiva;
	}
   
}
