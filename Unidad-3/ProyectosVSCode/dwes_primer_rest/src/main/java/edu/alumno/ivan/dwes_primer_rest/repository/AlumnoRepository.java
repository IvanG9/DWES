package edu.alumno.ivan.dwes_primer_rest.repository;

import java.util.Collection;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.alumno.ivan.dwes_primer_rest.model.db.AlumnoDb;

@Repository
public interface AlumnoRepository extends JpaRepository<AlumnoDb, String> {

    @Query("SELECT a FROM AlumnoDb a WHERE a.ciclo='DAW'")
    Collection<AlumnoDb> findAllAlumnoDbDAW();

    @Query(value = "SELECT * FROM alumnos as a WHERE a.ciclo='DAM'", nativeQuery = true)
    Collection<AlumnoDb> findAllAlumnoDbDAM();

    @Query("SELECT a FROM AlumnoDb a WHERE a.ciclo=:ciclo")
    Collection<AlumnoDb> findAllAlumnoDbCiclo(@Param("ciclo") String ciclo);

    @Query("SELECT a FROM AlumnoDb a WHERE a.ciclo=:ciclo AND a.pais=:pais")
    Collection<AlumnoDb> findAllAlumnoDbCicloPais(@Param("ciclo") String ciclo,
            @Param("pais") String pais);

    // Metodos automaticos en Spring Data JPA

    Collection<AlumnoDb> findByDni(String dni);

    Collection<AlumnoDb> findByCiclo(String ciclo);

    Collection<AlumnoDb> findByHorario(String horario);

    Collection<AlumnoDb> findByEdad(Integer edad);

    // Ordenación de resultados
    @Query("SELECT a FROM AlumnoDb a WHERE a.ciclo=:ciclo ORDER BY a.curso ASC")
    Collection<AlumnoDb> findAllAlumnoDbCicloOrderByCurso(@Param("ciclo") String ciclo);

    // Consultas con varias ordenaciones en Spring Data JPA
    @Query("SELECT a FROM AlumnoDb a WHERE a.ciclo=:ciclo")
    Collection<AlumnoDb> findByCicloOrderBy(String ciclo, Sort sort);

    @Query("SELECT a FROM AlumnoDb a WHERE a.edad=:edad")
    Collection<AlumnoDb> findByEdadOrderBy(Integer edad, Sort sort);

    // Métodos automáticos en Spring Data JPA
    Collection<AlumnoDb> findByCiclo(String ciclo, Sort sort);

    Collection<AlumnoDb> findByHorario(String horario, Sort sort);

    Collection<AlumnoDb> findByEdad(Integer edad, Sort sort);
}
