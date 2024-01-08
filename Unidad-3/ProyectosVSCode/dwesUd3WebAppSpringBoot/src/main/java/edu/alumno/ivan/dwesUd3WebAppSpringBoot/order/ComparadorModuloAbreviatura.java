package edu.alumno.ivan.dwesUd3WebAppSpringBoot.order;

import java.util.Comparator;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Modulo;

public class ComparadorModuloAbreviatura implements Comparator<Modulo> {
	@Override
	public int compare(Modulo a1, Modulo a2) {
		return a1.getAbreviatura().compareTo(a2.getAbreviatura());
	}
}