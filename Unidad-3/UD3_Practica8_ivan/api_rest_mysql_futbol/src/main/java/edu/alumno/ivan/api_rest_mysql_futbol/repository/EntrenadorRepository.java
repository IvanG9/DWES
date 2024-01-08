package edu.alumno.ivan.api_rest_mysql_futbol.repository;

import edu.alumno.ivan.api_rest_mysql_futbol.model.db.EntrenadorDb;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EntrenadorEdit;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadorRepository extends JpaRepository<EntrenadorDb, Long> {

    Optional<EntrenadorDb> findById(Long id);
    void deleteById(Long id);
    EntrenadorDb save(EntrenadorEdit entrenadorEdit);
}
