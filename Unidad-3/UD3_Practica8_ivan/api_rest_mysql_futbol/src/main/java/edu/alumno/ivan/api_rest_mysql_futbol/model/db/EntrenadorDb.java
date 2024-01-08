package edu.alumno.ivan.api_rest_mysql_futbol.model.db;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import edu.alumno.ivan.api_rest_mysql_futbol.security.entity.RolDb;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "entrenadores")
public class EntrenadorDb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Size(min=20,message= "El nombre de tener un tamaño minimo de 20 caracteres")
    private String nombre;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "entrenadores_Equipos", joinColumns = @JoinColumn(name = "nombreEntrenador"), inverseJoinColumns = @JoinColumn(name = "idEquipo"))
    private Set<EquipoDb> equipoDbs = new HashSet<>();

}