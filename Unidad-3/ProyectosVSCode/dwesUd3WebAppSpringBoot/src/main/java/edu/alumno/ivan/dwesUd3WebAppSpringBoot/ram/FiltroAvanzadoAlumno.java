package edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram;

public class FiltroAvanzadoAlumno{
	private String dni;
	private String ciclo;
	private String horario;
	
	
	public FiltroAvanzadoAlumno(String dni, String ciclo, String horario) {
		super();
		this.dni = dni;
		this.ciclo = ciclo;
		this.horario = horario;
	}
	

	public FiltroAvanzadoAlumno() {
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getCiclo() {
		return ciclo;
	}


	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}


	public String getHorario() {
		return horario;
	}


	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
}