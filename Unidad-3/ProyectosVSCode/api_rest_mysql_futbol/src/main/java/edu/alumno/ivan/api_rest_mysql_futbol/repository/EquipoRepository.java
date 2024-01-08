package edu.alumno.ivan.api_rest_mysql_futbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.alumno.ivan.api_rest_mysql_futbol.model.db.EquipoDb;

public interface EquipoRepository  extends JpaRepository<EquipoDb, String> {
    
}
