package edu.alumno.ivan.dwesUd3WebAppSpringBoot.order;

import java.util.Comparator;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Alumno;

public class ComparadorAlumnoCicloNombre implements Comparator<Alumno> {
	@Override
	public int compare(Alumno a1, Alumno a2) {
		int compCiclo = a1.getCiclo().compareTo(a2.getCiclo());
		if (compCiclo!=0) {
			return compCiclo;
		} else {
			return a1.getNombre().compareTo(a2.getNombre());
		}
	}
}