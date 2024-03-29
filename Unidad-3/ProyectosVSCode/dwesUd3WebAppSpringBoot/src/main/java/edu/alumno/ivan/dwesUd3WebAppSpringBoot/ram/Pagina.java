package edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram;

public class Pagina {
	private String titulo;
	private String paginaActiva;
	private String idioma;
	
	public Pagina(String titulo, String paginaActiva) {
		super();
		this.titulo = titulo;
		this.paginaActiva = paginaActiva;
		this.idioma = "es";
	}

	public Pagina(String titulo, String paginaActiva, String idioma) {
		super();
		this.titulo = titulo;
		this.paginaActiva = paginaActiva;
		this.idioma = idioma;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPaginaActiva() {
		return paginaActiva;
	}

	public void setPaginaActiva(String paginaActiva) {
		this.paginaActiva = paginaActiva;
	}
	
	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getStrBootstrapActiva(String pagina) {
		if (paginaActiva.equals(pagina)) 
			return "active";
		else 
			return "";
	}
	
}