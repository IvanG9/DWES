package edu.alumno.ivan.dwes_futbol_rest.reopsitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.alumno.ivan.dwes_futbol_rest.model.db.CiudadDb;

public interface CiudadRepository extends JpaRepository<CiudadDb, Long> {
    List<CiudadDb> findAll();
    List<CiudadDb> findAll(Sort sort);
    Optional<CiudadDb> findById(Long id);
    List<CiudadDb> findByNombreContaining(String nombre, Sort sort);

    //Paginacion
    Page<CiudadDb> findAll(Pageable page);
    Page<CiudadDb> findByNombreContaining(Pageable page, String nombre);
}
