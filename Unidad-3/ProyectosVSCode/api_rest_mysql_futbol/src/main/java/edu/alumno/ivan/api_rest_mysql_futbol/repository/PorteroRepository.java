package edu.alumno.ivan.api_rest_mysql_futbol.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.alumno.ivan.api_rest_mysql_futbol.model.db.JugadorId;
import edu.alumno.ivan.api_rest_mysql_futbol.model.db.PorteroDb;


public interface PorteroRepository extends JpaRepository<PorteroDb, JugadorId> {
    
    List<PorteroDb> findAll(Sort sort);
    Page<PorteroDb> findAll(Pageable page);
}
