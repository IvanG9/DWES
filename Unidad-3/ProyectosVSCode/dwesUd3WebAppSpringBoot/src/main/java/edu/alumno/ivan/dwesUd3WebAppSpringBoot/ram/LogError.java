package edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram;

public class LogError implements Comparable<LogError>{
	private int id;
	private String tipo;
	private String explicacion;
	
	public LogError(int id, String tipo, String explicacion) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.explicacion = explicacion;
	}
	
	public int compareTo(LogError error) {
		return id-error.getId();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getExplicacion() {
		return explicacion;
	}

	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}
	
	
	
}