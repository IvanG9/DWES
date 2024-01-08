package edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram;

public class Modulo implements Comparable<Modulo>{
	private int id;
	private String nombre;
	private int horas;
	private String abreviatura;
	
	
	public Modulo(int id, String nombre, int horas, String abreviatura) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
		this.abreviatura = abreviatura;
	}
	
	public int compareTo(Modulo modulo) {
		return id - modulo.getId();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getHoras() {
		return horas;
	}


	public void setHoras(int horas) {
		this.horas = horas;
	}


	public String getAbreviatura() {
		return abreviatura;
	}


	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}


	@Override
	public String toString() {
		return "Modulo [id=" + id + ", nombre=" + nombre + ", horas=" + horas + ", abreviatura=" + abreviatura + "]";
	}
	
	
}