package com.pensumorganizer.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CalificacionesEntity
 *
 */
@Entity
@Table(name="Calificaciones")
@IdClass(CalificacionesEntityPK.class)
public class CalificacionesEntity implements Serializable {

	   
	@Id
	private String Nivel;   
	@Id
	private String CalificacionCodigo;
	private String Descripcion;
	private double Puntos;
	private String CalificacionAprobada;
	private String CalculoIndice;
	private static final long serialVersionUID = 1L;

	public CalificacionesEntity() {
		super();
	}   
	public String getNivel() {
		return this.Nivel;
	}

	public void setNivel(String Nivel) {
		this.Nivel = Nivel;
	}   
	public String getCalificacionCodigo() {
		return this.CalificacionCodigo;
	}

	public void setCalificacionCodigo(String CalificacionCodigo) {
		this.CalificacionCodigo = CalificacionCodigo;
	}   
	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}   
	public double getPuntos() {
		return this.Puntos;
	}

	public void setPuntos(double Puntos) {
		this.Puntos = Puntos;
	}   
	public String getCalificacionAprobada() {
		return this.CalificacionAprobada;
	}

	public void setCalificacionAprobada(String CalificacionAprobada) {
		this.CalificacionAprobada = CalificacionAprobada;
	}   
	public String getCalculoIndice() {
		return this.CalculoIndice;
	}

	public void setCalculoIndice(String CalculoIndice) {
		this.CalculoIndice = CalculoIndice;
	}
   
}
