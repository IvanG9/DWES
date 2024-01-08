package edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.excepciones;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Modulo;

public class ModuloDuplicadoException extends Exception {
	private static final long serialVersionUID = 1L;
	private Modulo moduloExistente;
	private Modulo moduloNuevo;
	
	public ModuloDuplicadoException(Modulo moduloExistente, Modulo moduloNuevo) {
		super();
		this.moduloExistente = moduloExistente;
		this.moduloNuevo = moduloNuevo;
	}

	@Override
	public String toString() {
		return "ERROR: Se ha intentado insertar un nuevo módulo que está duplicado: <br>"
				+ "Modulo existente: [id="+moduloExistente.getId()+", nombre="+moduloExistente.getNombre()+", horas="+moduloExistente.getHoras()+", abreviatura="+moduloExistente.getAbreviatura()+"]<br>"
				+ "Modulo existente: [id="+moduloNuevo.getId()+", nombre="+moduloNuevo.getNombre()+", horas="+moduloNuevo.getHoras()+", abreviatura="+moduloNuevo.getAbreviatura()+"]";
	}
	
	
	
}