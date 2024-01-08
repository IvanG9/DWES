package edu.alumno.ivan.api_rest_mysql_futbol.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JugadorList {
    private static final long serialVersionUID = 1L;
    private String idEquipo;
    private Long dorsal;
    private String nombre;

}
