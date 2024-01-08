package edu.alumno.ivan.api_rest_mysql_futbol.model.dto;

import java.io.Serializable;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class EntrenadorEdit implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Size(min=20,message= "El nombre de tener un tamaño minimo de 20 caracteres")
    private String nombre;
}