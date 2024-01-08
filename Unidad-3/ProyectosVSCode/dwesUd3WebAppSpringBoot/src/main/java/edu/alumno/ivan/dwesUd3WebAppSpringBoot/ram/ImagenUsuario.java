package edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.validaciones.ImagenValida;

public class ImagenUsuario {
	@Size(min=5, message="El usuario debe de tener un tamaño mínimo de 5 carácteres")
	private String nickname;
	@NotNull
	@ImagenValida
	private MultipartFile imagen;
	
	
	public ImagenUsuario(String nickname, MultipartFile imagen) {
		super();
		this.nickname = nickname;
		this.imagen = imagen;
	}
	
	
	public ImagenUsuario(String nickname) {
		super();
		this.nickname = nickname;
	}


	public ImagenUsuario() {
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public MultipartFile getImagen() {
		return imagen;
	}


	public void setImagen(MultipartFile imagen) {
		this.imagen = imagen;
	}
	
	
}