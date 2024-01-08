package edu.alumno.ivan.api_rest_mysql_futbol.model.db;


import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "equipos")
public class EquipoDb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id 
    private String id;
    private String nombreCorto;
    private String nombreLargo;

    @ManyToOne
    @JoinColumn(name = "ciudad")
    private CiudadDb ciudadDb;

    private String entrenador;
    private String estadio;
    private String marca;
    private String patrocinador;
    private Long presupuesto;
}

