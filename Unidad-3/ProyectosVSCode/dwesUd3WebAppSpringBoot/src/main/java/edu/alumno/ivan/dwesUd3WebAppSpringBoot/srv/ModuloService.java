package edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv;

import java.util.ArrayList;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.order.ComparadorModuloAbreviatura;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.order.ComparadorModuloHoras;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.order.ComparadorModuloNombre;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.FiltroModulo;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Modulo;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.excepciones.ModuloDuplicadoException;

@Service
public class ModuloService {
	private static ArrayList<Modulo> modulos = new ArrayList<Modulo>();
	private static int contadorModulosCreados = 0;
	
	static {
		modulos.add(new Modulo(2, "Desarrollo Web en Entorno Servidor", 8, "DWES"));
		modulos.add(new Modulo(1, "Programacion", 8, "PRO"));
	}
	
	public ArrayList<Modulo> listaModulos() {
		return modulos;
	}
	
	public void addModulo(Modulo modulo) throws ModuloDuplicadoException{
		try {
			existeModulo(modulo);
			modulos.add(modulo);
		}catch(ModuloDuplicadoException e) {
			throw e;
		}
	}
	
	public void delModulo(Modulo modulo) {
		modulos.remove(modulo);
	}
	
	public boolean existeModulo(Modulo modulo) throws ModuloDuplicadoException{
		Modulo moduloExistente = encontrarModuloPorId(modulo.getId());
		if(moduloExistente!=null) {
			throw new ModuloDuplicadoException(moduloExistente, modulo);
		} else {
			return false;
		}
	}
	
	public Modulo encontrarModuloPorId(int id) {
		Modulo moduloDuplicado = null;
		for(int i=0; i < modulos.size(); i++) {
			if(modulos.get(i).getId() == id) {
				moduloDuplicado = modulos.get(i);
				break;
			}
		}
		return moduloDuplicado;
	}
	
	public List<Modulo> listaModulos(String criterioOrdenacion) {
		if(criterioOrdenacion.equals("id")) {
			Collections.sort(modulos);
			return modulos;
		}
		if(criterioOrdenacion.equals("nombre")) {
			Collections.sort(modulos, new ComparadorModuloNombre());
			return modulos;
		}
		if(criterioOrdenacion.equals("horas")) {
			Collections.sort(modulos, new ComparadorModuloHoras());
			return modulos;
		}
		if(criterioOrdenacion.equals("abreviatura")) {
			Collections.sort(modulos, new ComparadorModuloAbreviatura());
			return modulos;
		}
		return modulos;
	}
	
	public int contadorModulos (){
		return contadorModulosCreados;
	}
	
	public void sumarContadorModulos() {
		contadorModulosCreados++;
	}
	
	public void restablecerContadorModulos() {
		contadorModulosCreados = 0;
	}
	
	public List<String> listaFiltro() {
		ArrayList<String> listaFiltro = new ArrayList<String>();
		listaFiltro.add("<");
		listaFiltro.add("=");
		listaFiltro.add(">");
		return listaFiltro;
	}
	
	public List<Modulo> filtroModulos(FiltroModulo filtroModulo) {
		List<Modulo> lista = modulos;
		try {
			if (filtroModulo.getCampo().equals("<")) {
				lista = lista.stream().filter(m->m.getHoras()!=0 && m.getHoras() < filtroModulo.getFiltro()).collect(Collectors.toList());
			}
			if (filtroModulo.getCampo().equals("=")) {
				lista = lista.stream().filter(m->m.getHoras()!=0 && m.getHoras() == filtroModulo.getFiltro()).collect(Collectors.toList());
			}
			if (filtroModulo.getCampo().equals(">")) {
				lista = lista.stream().filter(m->m.getHoras()!=0 && m.getHoras() > filtroModulo.getFiltro()).collect(Collectors.toList());
			}
			
		} catch (Exception e) {
			lista = new ArrayList<Modulo>();
		}
		
		if (lista == null) return new ArrayList<Modulo>();
		return lista;
	}
	
}