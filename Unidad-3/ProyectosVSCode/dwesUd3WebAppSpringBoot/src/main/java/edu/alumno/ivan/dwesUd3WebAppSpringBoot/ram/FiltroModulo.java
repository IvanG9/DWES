package edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class FiltroModulo {
	private String campo;
	@NotNull(message="Las horas no pueden estar vacias")
	@Range(min=1, max=10, message="Las horas deber de ser igual o mayor a 1 y menor o igual a 10")
	@Digits(integer=1, fraction=0, message="Las horas no pueden tener deciamles")
	private int filtro;
	
	
	public FiltroModulo(String campo, int filtro) {
		super();
		this.campo = campo;
		this.filtro = filtro;
	}
	
	


	public FiltroModulo() {
	}




	public String getCampo() {
		return campo;
	}


	public void setCampo(String campo) {
		this.campo = campo;
	}


	public int getFiltro() {
		return filtro;
	}


	public void setFiltro(int filtro) {
		this.filtro = filtro;
	}
	
	
}