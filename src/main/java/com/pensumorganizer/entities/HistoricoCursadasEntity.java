package com.pensumorganizer.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: HistoricoCursadasEntity
 *
 */
@Entity
@Table(name="HistoricoCursadas")

@IdClass(HistoricoCursadasEntityPK.class)
public class HistoricoCursadasEntity implements Serializable {

	   
	@Id
	private int Año;   
	@Id
	private int Termino;   
	@Id
	private int IdEstudiante;   
	@Id
	private String AsignaturaCodigo;
	private int Seccion;
	private String CalificacionCodigo;   
	@Id
	private String TipoSeccion;
	private static final long serialVersionUID = 1L;

	public HistoricoCursadasEntity() {
		super();
	}   
	public int getAño() {
		return this.Año;
	}

	public void setAño(int Año) {
		this.Año = Año;
	}   
	public int getTermino() {
		return this.Termino;
	}

	public void setTermino(int Termino) {
		this.Termino = Termino;
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
	public int getSeccion() {
		return this.Seccion;
	}

	public void setSeccion(int Seccion) {
		this.Seccion = Seccion;
	}   
	public String getCalificacionCodigo() {
		return this.CalificacionCodigo;
	}

	public void setCalificacionCodigo(String CalificacionCodigo) {
		this.CalificacionCodigo = CalificacionCodigo;
	}   
	public String getTipoSeccion() {
		return this.TipoSeccion;
	}

	public void setTipoSeccion(String TipoSeccion) {
		this.TipoSeccion = TipoSeccion;
	}
   
}
