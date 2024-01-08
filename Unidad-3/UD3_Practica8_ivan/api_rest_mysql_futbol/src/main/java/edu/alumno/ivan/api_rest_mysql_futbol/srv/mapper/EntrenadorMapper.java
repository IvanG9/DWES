package edu.alumno.ivan.api_rest_mysql_futbol.srv.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import edu.alumno.ivan.api_rest_mysql_futbol.model.db.EntrenadorDb;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EntrenadorEdit;

import java.util.List;
import java.util.Set;

@Mapper
public interface EntrenadorMapper {
    
    EntrenadorMapper INSTANCE= Mappers.getMapper(EntrenadorMapper.class);

    EntrenadorDb entrenadorEditToEntrenadorDb(EntrenadorEdit entrenadorEdit);
    EntrenadorEdit entrenadorDbToEntrenadorEdit(EntrenadorDb entrenadorDb);
    
}
