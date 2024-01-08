package edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv;

import org.springframework.stereotype.Service;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Pagina;
@Service
public class PaginaService {
	private static Pagina paginaActual;
	
	public void setPagina (Pagina paginaNueva) {
		paginaActual = paginaNueva;
	}
	
	public Pagina getPagina () {
		return paginaActual;
	}
}