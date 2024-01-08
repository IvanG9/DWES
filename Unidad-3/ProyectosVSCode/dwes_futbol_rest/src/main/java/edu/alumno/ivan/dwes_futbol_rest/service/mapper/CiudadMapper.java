package edu.alumno.ivan.dwes_futbol_rest.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import edu.alumno.ivan.dwes_futbol_rest.model.db.CiudadDb;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.CiudadInfo;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.CiudadList;

@Mapper
public interface CiudadMapper {
    CiudadMapper INSTANCE = Mappers.getMapper(CiudadMapper.class);

    CiudadInfo ciudadDbToCiudadInfo(CiudadDb ciudadDb);
    CiudadList ciudadDbToCiudadList(CiudadDb ciudadDb);
    List<CiudadList> ciudadesToCiudadList(List<CiudadDb> cidadesDb);
}
