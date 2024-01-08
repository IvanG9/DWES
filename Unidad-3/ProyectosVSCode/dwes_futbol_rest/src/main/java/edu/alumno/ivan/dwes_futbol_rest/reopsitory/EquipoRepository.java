package edu.alumno.ivan.dwes_futbol_rest.reopsitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.alumno.ivan.dwes_futbol_rest.model.db.EquipoDb;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.EquipEdit;

public interface EquipoRepository extends JpaRepository<EquipoDb, Long> {

    EquipEdit save(EquipEdit equipEdit);
    Optional<EquipoDb> findById(String id);
    List<EquipoDb> findAll();
    List<EquipoDb> findAll(Sort sort);
    EquipoDb save(EquipoDb equipEditToEquipDb);
    Page<EquipoDb> findAll(Pageable page);
    Page<EquipoDb> findByNombreLargoContaining(Pageable page, String id);

}
