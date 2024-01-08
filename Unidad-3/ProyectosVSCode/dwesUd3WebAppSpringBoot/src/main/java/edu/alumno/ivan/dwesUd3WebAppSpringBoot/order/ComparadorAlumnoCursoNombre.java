package edu.alumno.ivan.dwesUd3WebAppSpringBoot.order;

import java.util.Comparator;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Alumno;

public class ComparadorAlumnoCursoNombre implements Comparator<Alumno> {
	@Override
	public int compare(Alumno a1, Alumno a2) {
		int compCurso = a1.getCurso()-a2.getCurso();
		if (compCurso!=0) {
			return compCurso;
		} else {
			return a1.getNombre().compareTo(a2.getNombre());
		}
	}
}