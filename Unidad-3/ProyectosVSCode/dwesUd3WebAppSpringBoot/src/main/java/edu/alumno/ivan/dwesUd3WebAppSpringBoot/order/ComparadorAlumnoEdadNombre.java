package edu.alumno.ivan.dwesUd3WebAppSpringBoot.order;

import java.util.Comparator;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Alumno;

public class ComparadorAlumnoEdadNombre implements Comparator<Alumno>{
	@Override 
	public int compare(Alumno a1, Alumno a2) {
		int compEdad = a1.getEdad()-a2.getEdad();
		if (compEdad!=0) {
			return compEdad;
		} else {
			return a1.getNombre().compareTo(a2.getNombre());
		}
	}
}