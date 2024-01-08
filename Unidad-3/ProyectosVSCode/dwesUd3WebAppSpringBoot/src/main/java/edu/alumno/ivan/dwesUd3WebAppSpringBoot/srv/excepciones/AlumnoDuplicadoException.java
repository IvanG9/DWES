package edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.excepciones;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.dto.AlumnoEdit;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Alumno;

public class AlumnoDuplicadoException extends Exception {
	private static final long serialVersionUID = 1L;
	private Alumno alumnoExistente;
	private AlumnoEdit alumnoNuevo;
	
	public AlumnoDuplicadoException(Alumno alumnoExistente, AlumnoEdit alumnoNuevo) {
		super();
		this.alumnoExistente = alumnoExistente;
		this.alumnoNuevo = alumnoNuevo;
	}

	@Override
	public String toString() {
		return "ERROR insertando Alumno: <br>"
				+ "Alumno existente:<br>"
				+ "dni: "+alumnoExistente.getDni()+"<br>"
				+ "nombre: "+alumnoExistente.getNombre()+"<br>"
				+ "Alumno nuevo: <br>"
				+ "dni: "+alumnoNuevo.getDni()+"<br>"
				+ "nombre: "+alumnoNuevo.getNombre();
	}
	
	
	
}