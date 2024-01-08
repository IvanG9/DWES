package edu.alumno.ivan.dwesUd3WebAppSpringBoot.order;

import java.util.Comparator;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Alumno;

public class ComparadorAlumnoDni implements Comparator<Alumno> {
	@Override
	public int compare(Alumno a1, Alumno a2) {
		return a1.getDni().compareTo(a2.getDni());
	}
}