package edu.alumno.ivan.api_rest_mysql_futbol.model.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CiudadaInfo implements Serializable {
    @Column(nullable = false)
    private Long id;
    @Size(min = 4, message = "El nombre debe tener un tamaño mínimo de 4 carácteres")
    private String nombre;
    @Column(nullable = true)
    private Long habitantes;
    private Set<EquipoInfoNombre> equiposInfoNombre = new HashSet<>();
}
