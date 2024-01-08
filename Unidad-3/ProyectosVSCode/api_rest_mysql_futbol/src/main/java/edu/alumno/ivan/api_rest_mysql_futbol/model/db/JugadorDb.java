package edu.alumno.ivan.api_rest_mysql_futbol.model.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@IdClass(JugadorId.class)
@Table(name= "jugadores")
public class JugadorDb implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Size(min=3,message="El id del equipo tiene un tamaño minimo de 3")
    private String idEquipo;
    @Id
    @Column(nullable = false)
    private Long dorsal;
    @Size(min=10,max=30,message= "El nombre de tener un tamaño entre 10 y 30 carracteres")
    private String nombre;
    @Size(max=10,message="La posicion debe tener un tamaño maximo de 30 carracteres")
    private String posicion;
    private Long sueldo;

}
