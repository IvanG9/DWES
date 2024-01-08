package edu.alumno.ivan.api_rest_mysql_futbol.model.dto;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PorteroList {
    private static final long serialVersionUID = 1L;
    private String idEquipo;
    private Long dorsal;
    private String nombre;
}
