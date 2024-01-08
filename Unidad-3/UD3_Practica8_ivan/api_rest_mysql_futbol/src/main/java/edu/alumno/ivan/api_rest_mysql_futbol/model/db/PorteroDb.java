package edu.alumno.ivan.api_rest_mysql_futbol.model.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name= "porteros")
public class PorteroDb implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Size(min=3,message="El id del equipo tiene un tamaño minimo de 3")
    private String idEquipo;
    @Id
    @Column(nullable = false)
    private Long dorsal;
    private Long partidos;
    private Long goles;
    @OneToOne
    @JoinColumn(name="idEquipo", referencedColumnName="idEquipo")
    @JoinColumn(name="dorsal",referencedColumnName="dorsal")
    private JugadorDb jugadorDb;

}
