package edu.alumno.ivan.api_rest_mysql_futbol.model.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CiudadInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String num;
    private Long habitantes;
    private Set<EquipoInfoNombre> equiposInfoNombres = new HashSet<>();
}
