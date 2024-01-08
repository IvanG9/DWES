package edu.alumno.ivan.dwes_ud3_primer_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.alumno.ivan.dwes_ud3_primer_jpa.model.db.ModuloDb;

@Repository
public interface ModuloRepository extends JpaRepository<ModuloDb, Long>{
    
}

