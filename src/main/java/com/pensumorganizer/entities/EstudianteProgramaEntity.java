package com.pensumorganizer.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EstudianteProgramaEntity
 *
 */
@Entity
@Table(name="EstudiantePrograma")
public class EstudianteProgramaEntity implements Serializable {

	   
	@Id
	private int IdEstudiante;
	private String Nombre;
	private String ProgramaCodigo;
	private int Version;
	private int A�oIngreso;
	private int TerminoIngreso;
	private int A�oLimitePermanencia;
	private int TrimestresCursados;
	private double IndiceAcumulado;
	private int Password;
	private static final long serialVersionUID = 1L;

	public EstudianteProgramaEntity() {
		super();
	}   
	public int getIdEstudiante() {
		return this.IdEstudiante;
	}

	public void setIdEstudiante(int IdEstudiante) {
		this.IdEstudiante = IdEstudiante;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public String getProgramaCodigo() {
		return this.ProgramaCodigo;
	}

	public void setProgramaCodigo(String ProgramaCodigo) {
		this.ProgramaCodigo = ProgramaCodigo;
	}   
	public int getVersion() {
		return this.Version;
	}

	public void setVersion(int Version) {
		this.Version = Version;
	}   
	public int getA�oIngreso() {
		return this.A�oIngreso;
	}

	public void setA�oIngreso(int A�oIngreso) {
		this.A�oIngreso = A�oIngreso;
	}   
	public int getTerminoIngreso() {
		return this.TerminoIngreso;
	}

	public void setTerminoIngreso(int TerminoIngreso) {
		this.TerminoIngreso = TerminoIngreso;
	}   
	public int getA�oLimitePermanencia() {
		return this.A�oLimitePermanencia;
	}

	public void setA�oLimitePermanencia(int A�oLimitePermanencia) {
		this.A�oLimitePermanencia = A�oLimitePermanencia;
	}   
	public int getTrimestresCursados() {
		return this.TrimestresCursados;
	}

	public void setTrimestresCursados(int TrimestresCursados) {
		this.TrimestresCursados = TrimestresCursados;
	}   
	public double getIndiceAcumulado() {
		return this.IndiceAcumulado;
	}

	public void setIndiceAcumulado(double IndiceAcumulado) {
		this.IndiceAcumulado = IndiceAcumulado;
	}   
	public int getPassword() {
		return this.Password;
	}

	public void setPassword(int Password) {
		this.Password = Password;
	}
   
}
