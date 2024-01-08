package edu.alumno.ivan.api_rest_mysql_futbol.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class EquipoInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String nombreCorto;
    private String nombreLargo;
    private Long ciudad;
    private String entrenador;
    private String estadio;
    private String marca;
    private String patrocinador;
    private Long presupuesto;
}
