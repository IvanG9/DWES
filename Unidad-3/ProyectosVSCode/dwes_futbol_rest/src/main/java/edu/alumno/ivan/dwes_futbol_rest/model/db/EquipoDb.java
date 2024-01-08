package edu.alumno.ivan.dwes_futbol_rest.model.db;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

