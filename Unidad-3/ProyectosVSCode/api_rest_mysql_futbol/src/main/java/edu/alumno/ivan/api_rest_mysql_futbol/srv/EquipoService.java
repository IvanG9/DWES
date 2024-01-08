package edu.alumno.ivan.api_rest_mysql_futbol.srv;

import org.springframework.data.domain.Pageable;

import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquipList;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.PaginaDto;

public interface EquipoService {
    public PaginaDto<EquipList> findAll(Pageable pagin);
}
