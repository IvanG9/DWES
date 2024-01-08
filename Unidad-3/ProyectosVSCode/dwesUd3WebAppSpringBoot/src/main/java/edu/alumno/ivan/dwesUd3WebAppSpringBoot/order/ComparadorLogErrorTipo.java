package edu.alumno.ivan.dwesUd3WebAppSpringBoot.order;

import java.util.Comparator;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.LogError;

public class ComparadorLogErrorTipo implements Comparator<LogError> {

	public int compare(LogError e1, LogError e2) {
		return e1.getTipo().compareTo(e2.getTipo());
	}
}