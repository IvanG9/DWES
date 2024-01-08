package edu.alumno.ivan.dwes_futbol_rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.alumno.ivan.dwes_futbol_rest.model.dto.EquipEdit;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.EquipList;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.EquipoInfo;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.PaginaDto;

public interface EquipoService {
    public Optional<EquipoInfo> getEquipInfoById(String id);
    public EquipEdit save(EquipEdit equipEdit);
    public String deleteByDni(Long dni);
    public PaginaDto<EquipList> findByNombreLargoContaining(String nombreLargo, Pageable paging);
    public PaginaDto<EquipList> findAllPageEquipList(Pageable paging);
 
}
