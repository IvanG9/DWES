package edu.alumno.ivan.api_rest_mysql_futbol.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EquipoList implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String nombreLargo;
    private String nombreCiudad;
    
}
