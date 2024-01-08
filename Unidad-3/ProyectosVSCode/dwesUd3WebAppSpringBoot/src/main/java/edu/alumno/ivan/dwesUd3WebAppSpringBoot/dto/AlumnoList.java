package edu.alumno.ivan.dwesUd3WebAppSpringBoot.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlumnoList implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String dni;
	private Integer edad;
	private String ciclo;
	private Integer curso;
	private boolean erasmus=false;
	private String modificado;
	
	public AlumnoList() {
	}

	public String getErasmusChecked() {
		if (erasmus)
				return "checked";
		else
			return "";
	}

}







