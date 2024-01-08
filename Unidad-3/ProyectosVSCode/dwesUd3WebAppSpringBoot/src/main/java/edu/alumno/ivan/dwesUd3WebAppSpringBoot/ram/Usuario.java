package edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram;

import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Usuario {
	private String nombre;
	@Size(min=5, message="El nombre no puede tener menos de 5 caracteres")
	private String nickname;
	@Pattern(regexp="^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$",message="El password debe de tener entre 8 y 16 caracteres, y al menos un dígito, una minúscula, una mayúscula y un carácter no alfanumérico")
	private String password;
	private String nombreFicheroConImagen;
	private Date ts;
	private String user;
	
	
	public Usuario(String nombre, String nickname, String password) {
		super();
		this.nombre = nombre;
		this.nickname = nickname;
		this.password = password;
	}
	
	
	public Usuario(String nombre, String nickname, String password, String nombreFicheroConImagen) {
		super();
		this.nombre = nombre;
		this.nickname = nickname;
		this.password = password;
		this.nombreFicheroConImagen = nombreFicheroConImagen;
	}


	public Usuario() {
	}



	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNombreFicheroConImagen() {
		return nombreFicheroConImagen;
	}

	public void setNombreFicheroConImagen(String nombreFicheroConImagen) {
		this.nombreFicheroConImagen = nombreFicheroConImagen;
	}

	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nickname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nickname, other.nickname);
	}
	
	
}