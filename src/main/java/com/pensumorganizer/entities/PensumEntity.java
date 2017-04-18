package com.pensumorganizer.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PensumEntity
 *
 */
@Entity
@Table(name="Pensum")

@IdClass(PensumEntityPK.class)
public class PensumEntity implements Serializable {

	   
	@Id
	private int Version;
	private int CreditosPrograma;   
	@Id
	private String ProgramaCodigo;
	private int Trimestre;   
	@Id
	private String AsignaturaCodigo;
	private int RequisitosCreditos;
	private static final long serialVersionUID = 1L;

	public PensumEntity() {
		super();
	}   
	public int getVersion() {
		return this.Version;
	}

	public void setVersion(int Version) {
		this.Version = Version;
	}   
	public int getCreditosPrograma() {
		return this.CreditosPrograma;
	}

	public void setCreditosPrograma(int CreditosPrograma) {
		this.CreditosPrograma = CreditosPrograma;
	}   
	public String getProgramaCodigo() {
		return this.ProgramaCodigo;
	}

	public void setProgramaCodigo(String ProgramaCodigo) {
		this.ProgramaCodigo = ProgramaCodigo;
	}   
	public int getTrimestre() {
		return this.Trimestre;
	}

	public void setTrimestre(int Trimestre) {
		this.Trimestre = Trimestre;
	}   
	public String getAsignaturaCodigo() {
		return this.AsignaturaCodigo;
	}

	public void setAsignaturaCodigo(String AsignaturaCodigo) {
		this.AsignaturaCodigo = AsignaturaCodigo;
	}   
	public int getRequisitosCreditos() {
		return this.RequisitosCreditos;
	}

	public void setRequisitosCreditos(int RequisitosCreditos) {
		this.RequisitosCreditos = RequisitosCreditos;
	}
   
}
