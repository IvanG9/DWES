package edu.alumno.ivan.api_rest_mysql_futbol.model.db;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JugadorId implements Serializable{
    private String idEquipo;
    private Long dorsal;
}