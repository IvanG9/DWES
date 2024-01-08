package edu.alumno.ivan.dwes_primer_rest.model.db;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "alumnos")
public class AlumnoDb implements Serializable {
	private static final long serialVersionUID = -818542778373595260L;
	@Id
	@Pattern(regexp = "[0-9]{8}[A-Za-z]{1}", message = "El dni debe tener 8 números y una letra")
	private String dni;
	@Size(min = 5, message = "El nombre debe de tener un tamaño mínimo de 5 carácteres")
	private String nombre;
	@NotNull(message = "La edad no puede estar vacia")
	@Range(min = 18, max = 99, message = "La edad debe ser igual o mayor a 18 y menor o igual a 99")
	@Digits(integer = 2, fraction = 0, message = "La edad no puede tener decimales ni más de 2 dígitos")
	private Integer edad;
	private String ciclo;
	@NotNull(message = "El curso no puede estar vacio")
	@Digits(fraction = 0, integer = 1, message = "El curso tiene un formato incorrecto")
	@Range(min = 1, max = 2, message = "El curso solo admite los valores 1 o 2")
	private Integer curso;
	private boolean erasmus = false;
	private String lenguajeFavorito = "";
	private String genero;
	private String horario;
	private String pais;
	private String hobbies;
}
