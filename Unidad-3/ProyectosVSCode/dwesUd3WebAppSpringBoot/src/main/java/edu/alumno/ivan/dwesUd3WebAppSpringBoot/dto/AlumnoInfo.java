package edu.alumno.ivan.dwesUd3WebAppSpringBoot.dto;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;

public class AlumnoInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre_alumno;
	private String dni_alumno;
	private String ciclo_alumno;
	private Integer curso_alumno;
	
	public AlumnoInfo() {
	}

	public String getDni_alumno() {
		return dni_alumno;
	}

	public void setDni_alumno(String dni_alumno) {
		this.dni_alumno = dni_alumno;
	}

	public String getNombre_alumno() {
		return nombre_alumno;
	}

	public void setNombre_alumno(String nombre_alumno) {
		this.nombre_alumno = nombre_alumno;
	}

	public String getCiclo_alumno() {
		return ciclo_alumno;
	}

	public void setCiclo_alumno(String ciclo_alumno) {
		this.ciclo_alumno = ciclo_alumno;
	}

	public Integer getCurso_alumno() {
		return curso_alumno;
	}

	public void setCurso_alumno(Integer curso_alumno) {
		this.curso_alumno = curso_alumno;
	}
	
}







