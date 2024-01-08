package edu.alumno.ivan.api_rest_mysql_futbol.model.dto;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EquipoInfoNombre {
    @Size(min = 3, message = "El id tiene un tamaño minimo de 3")
    private String id;
    @Size(min = 10, max = 40,message = "El nomre largo debe de tener un tamaño entre 10 y 40 carracteres")
    private String nombreLargo;
}
