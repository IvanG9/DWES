package edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.order.ComparadorLogErrorExplicacion;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.order.ComparadorLogErrorTipo;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.LogError;

@Service
public class LogErrorService {
	private static ArrayList<LogError> errores = new ArrayList<LogError>();
	
	public ArrayList<LogError> listaErrores(){
		return errores;
	}
	
	public void addLogError(String tipo, String explicacion){
		LogError errorNuevo = new LogError(errores.size()+1, tipo, explicacion);
		errores.add(errorNuevo);
	}
	
	public void delLogError(LogError error) {
		int pos = -1;
		for(int i = 0; i < errores.size(); i++) {
			if(errores.get(i).getId()==error.getId()) {
				pos = i;
				break;
			}
		}
		errores.remove(error);
		for(int i = pos; i < errores.size(); i++) {
			errores.get(i).setId(errores.get(i).getId()-1);
		}
	}
	
	public LogError encontrarLogErrorPorId(int id) {
		LogError error = null;
		for(int i=0; i < errores.size(); i++) {
			if(errores.get(i).getId() == id) {
				error = errores.get(i);
				break;
			}
		}
		return error;
	}
	
	public List<LogError> listaLogErrores(String orden) {
		if(orden.equals("id")) {
			Collections.sort(errores);
			return errores;
		}
		if(orden.equals("tipo")) {
			Collections.sort(errores, new ComparadorLogErrorTipo());
			return errores;
		}
		if(orden.equals("explicacion")) {
			Collections.sort(errores, new ComparadorLogErrorExplicacion());
			return errores;
		}
		return errores;
	}
	
	public List<LogError> listaFiltro(String dato, String filtrado){
		ArrayList<LogError> listaFiltro = new ArrayList<LogError>();
		if(dato.equals("Id")) {
			try {
				for(int i = 0; i < errores.size(); i++) {
					if(errores.get(i).getId() == Integer.parseInt(filtrado)) {
						listaFiltro.add(errores.get(i));
						break;
					}
				}
				return listaFiltro;
			} catch(Exception e) {
				System.out.println("No se pudo Filtrar");
				return errores;
			}
		}
		if(dato.equals("Tipo")) {
			for(int i = 0; i < errores.size(); i++) {
				if(errores.get(i).getTipo().contains(filtrado)) {
					listaFiltro.add(errores.get(i));
				}
			}
			return listaFiltro;
		}
		if(dato.equals("Explicacion")) {
			for(int i = 0; i < errores.size(); i++) {
				if(errores.get(i).getExplicacion().contains(filtrado)) {
					listaFiltro.add(errores.get(i));
				}
			}
			return listaFiltro;
		}
		return listaFiltro;
	}
}