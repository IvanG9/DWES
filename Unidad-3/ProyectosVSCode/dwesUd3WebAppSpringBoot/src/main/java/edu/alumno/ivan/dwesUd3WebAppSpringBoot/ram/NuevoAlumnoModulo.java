package edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram;

import javax.validation.constraints.Size;

public class NuevoAlumnoModulo {
	@Size(min=1,message="Debe de haber un dni")
	private String dni;
	private String id;
	
	
	public NuevoAlumnoModulo(String dni, String id) {
		super();
		this.dni = dni;
		this.id = id;
	}


	public NuevoAlumnoModulo() {
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	
	
}