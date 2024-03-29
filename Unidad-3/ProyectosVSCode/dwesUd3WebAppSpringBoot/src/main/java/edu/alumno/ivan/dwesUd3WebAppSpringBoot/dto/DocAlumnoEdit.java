package edu.alumno.ivan.dwesUd3WebAppSpringBoot.dto;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.validaciones.DocumentoAlumnoValido;

public class DocAlumnoEdit implements Comparable<DocAlumnoEdit>{
	@Pattern(regexp = "[0-9]{8}[A-Za-z]{1}", message = "El dni debe tener 8 números y una letra")
	private String dni;
	@NotNull(message = "El id no puede estar vacio")
	private Integer id;
	@NotNull(message = "El tipo no puede estar vacio")
	private String tipo;
	@Size(min = 10, message = "Los comentarios debe tener almenos 10 carácteres")
	private String comentario;
	
    @NotNull
    @DocumentoAlumnoValido
    private MultipartFile fichero;
    
    String tipoFichero="";
    String contentTypeFichero="";
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocAlumnoEdit other = (DocAlumnoEdit) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public DocAlumnoEdit() {
		super();
	}
	public DocAlumnoEdit(Integer id) {
		super();
		this.id = id;
	}
	@Override
	public int compareTo(DocAlumnoEdit doc) {
		return id-doc.getId();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public MultipartFile getFichero() {
		return fichero;
	}
	public void setFichero(MultipartFile fichero) {
		this.fichero = fichero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
}

