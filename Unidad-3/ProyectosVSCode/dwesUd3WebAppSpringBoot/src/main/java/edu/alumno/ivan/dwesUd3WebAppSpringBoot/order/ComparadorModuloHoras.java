package edu.alumno.ivan.dwesUd3WebAppSpringBoot.order;

import java.util.Comparator;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Modulo;

public class ComparadorModuloHoras implements Comparator<Modulo> {
	@Override
	public int compare(Modulo a1, Modulo a2) {
		return a1.getHoras() - a2.getHoras();
	}
}