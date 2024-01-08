package edu.alumno.ivan.api_rest_mysql_futbol.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.alumno.ivan.api_rest_mysql_futbol.model.db.JugadorDb;
import edu.alumno.ivan.api_rest_mysql_futbol.model.db.JugadorId;


public interface JugadorRepository extends JpaRepository<JugadorDb, JugadorId> {
    
    List<JugadorDb> findAll(Sort sort);
    List<JugadorDb> findByNombreContaining(String nombre, Sort sort);
    Page<JugadorDb> findAll(Pageable page);
    Page<JugadorDb> findByNombreContaining(String nombre,Pageable pageable);

}
