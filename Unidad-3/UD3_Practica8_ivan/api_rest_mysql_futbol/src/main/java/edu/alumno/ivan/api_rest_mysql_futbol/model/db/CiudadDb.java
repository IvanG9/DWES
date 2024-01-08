package edu.alumno.ivan.api_rest_mysql_futbol.model.db;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(exclude = {"equiposDb"})
@ToString(exclude = {"equiposDb"})

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ciudades")
public class CiudadDb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 4, message = "El nombre debe tener un tamaño mínimo de 4 carácteres")
    private String nombre;
    @Column(nullable = true)
    private Long habitantes;

    @OneToMany(mappedBy = "ciudadDb")
    private Set<EquipoDb> equiposDb = new HashSet<>();
}
