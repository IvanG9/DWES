package edu.alumno.ivan.api_rest_mysql_futbol.security.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.alumno.ivan.api_rest_mysql_futbol.security.entity.RolDb;
import edu.alumno.ivan.api_rest_mysql_futbol.security.enums.RolNombre;

public interface RolRepository extends JpaRepository<RolDb,Integer>{
    Optional<RolDb> findByNombre(RolNombre roleNombre);
}
