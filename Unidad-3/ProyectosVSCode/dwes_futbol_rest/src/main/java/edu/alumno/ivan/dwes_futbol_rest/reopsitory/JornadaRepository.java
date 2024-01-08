package edu.alumno.ivan.dwes_futbol_rest.reopsitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.alumno.ivan.dwes_futbol_rest.model.db.JornadaDb;

public interface JornadaRepository extends JpaRepository<JornadaDb, Long> {
    List<JornadaDb> findAll();
    List<JornadaDb> findAll(Sort sort);
    Optional<JornadaDb> findById(Long id);
    List<JornadaDb> findByFechaContaining(Sort sort, String fecha);

    //Paginacion
    Page<JornadaDb> findAll(Pageable page);
    Page<JornadaDb> findByFechaContaining(Pageable page, String fecha);
}