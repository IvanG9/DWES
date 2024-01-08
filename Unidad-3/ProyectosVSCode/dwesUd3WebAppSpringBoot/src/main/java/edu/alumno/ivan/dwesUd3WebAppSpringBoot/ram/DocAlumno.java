package edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.validaciones.DocumentoAlumnoValido;

public class DocAlumno {
	
	@Pattern(regexp="[0-9]{8}[A-Za-z]{1}",message="El Dni debe de tener 8 numeros y una letra")
	private String dni;
	@NotNull(message="El id no puede estar vacio")
	private int id;
	@NotNull(message="El tipo no puede estar vacio")
	private String tipo;
	@Size(min=10, message="Los comentarios deben tener al menos 10 caracteres")
	private String comentario;
	
	@NotNull
	@DocumentoAlumnoValido
	private MultipartFile fichero;
	
	String tipoFichero="";
	String contentTypeFichero="";
	
	public DocAlumno(String dni, int id, String comentario, MultipartFile fichero, String tipo) {
		super();
		this.dni = dni;
		this.id = id;
		this.comentario = comentario;
		this.fichero = fichero;
		this.tipo = tipo;
	}
	
	public DocAlumno(int id) {
		super();
		this.id = id;
	}
	
	public DocAlumno() {
	}



	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public MultipartFile getFichero() {
		return fichero;
	}

	public void setFichero(MultipartFile fichero) {
		this.fichero = fichero;
	}

	public String getTipoFichero() {
		return tipoFichero;
	}

	public void setTipoFichero(String tipoFichero) {
		this.tipoFichero = tipoFichero;
	}

	public String getContentTypeFichero() {
		return contentTypeFichero;
	}

	public void setContentTypeFichero(String contentTypeFichero) {
		this.contentTypeFichero = contentTypeFichero;
	}
	
	
}