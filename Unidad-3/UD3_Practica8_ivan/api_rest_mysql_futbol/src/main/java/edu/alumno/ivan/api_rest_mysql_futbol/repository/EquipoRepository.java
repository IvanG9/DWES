package edu.alumno.ivan.api_rest_mysql_futbol.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.alumno.ivan.api_rest_mysql_futbol.model.db.EquipoDb;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquipoEdit;

public interface EquipoRepository  extends JpaRepository<EquipoDb, String> {
    
    EquipoDb findById(Long id);
    EquipoDb deleteById(Long id);
    EquipoDb save(EquipoEdit equipoEdit);
    Page<EquipoDb> findByNombreCortoContaining(String nombreCorto, Pageable paging);

}   
