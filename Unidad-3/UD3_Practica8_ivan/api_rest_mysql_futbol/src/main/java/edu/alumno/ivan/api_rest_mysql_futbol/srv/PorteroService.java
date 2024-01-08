package edu.alumno.ivan.api_rest_mysql_futbol.srv;

import org.springframework.data.domain.Pageable;

import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.PaginaDto;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.PorteroList;

public interface PorteroService {
    public PaginaDto<PorteroList> findAll(Pageable pagin);
}
