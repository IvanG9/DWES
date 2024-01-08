package edu.alumno.ivan.api_rest_mysql_futbol.srv;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquipoList;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquiposCiudadEntrenadoresList;
import edu.alumno.ivan.api_rest_mysql_futbol.model.db.EquipoDb;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquipoEdit;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquipoInfo;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.PaginaDto;

public interface EquipoService {

    public PaginaDto<EquiposCiudadEntrenadoresList> findAll (Pageable pagin);
    public PaginaDto<EquiposCiudadEntrenadoresList> findByNombreCortoContaining(String nombreCorto, Pageable paging);
    public Optional<EquipoInfo> getEquipoInfoById(String id);
    public void deleteById(String id);
    public EquipoEdit save(EquipoEdit equipoEdit);
    public Optional<EquipoEdit> update(EquipoEdit equipoEdit);
  
}
