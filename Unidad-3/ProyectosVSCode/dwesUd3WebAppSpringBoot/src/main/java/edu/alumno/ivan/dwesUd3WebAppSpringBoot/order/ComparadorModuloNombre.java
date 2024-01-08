package edu.alumno.ivan.dwesUd3WebAppSpringBoot.order;

import java.util.Comparator;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Modulo;

public class ComparadorModuloNombre implements Comparator<Modulo> {
	@Override
	public int compare(Modulo a1, Modulo a2) {
		return a1.getNombre().compareTo(a2.getNombre());
	}
}