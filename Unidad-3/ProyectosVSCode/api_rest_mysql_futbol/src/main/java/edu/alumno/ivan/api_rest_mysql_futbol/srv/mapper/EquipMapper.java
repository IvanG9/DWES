package edu.alumno.ivan.api_rest_mysql_futbol.srv.mapper;


import org.mapstruct.Mapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;
import java.util.Set;

import edu.alumno.ivan.api_rest_mysql_futbol.model.db.EquipoDb;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquipList;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquipoInfoNombre;

@Mapper
public interface EquipMapper {
    
    EquipMapper INSTANCE= Mappers.getMapper(EquipMapper.class);

    @Mapping(target = "nombreCiudad", source = "ciudadDb.nombre")
    EquipList equipoDbToEquipList(EquipoDb equipoDb);
    
    List<EquipList> equiposDbToEquiposList(List<EquipoDb> equipoDb);
    Set<EquipoInfoNombre> equiposDbToEquiposInfoNombre(Set<EquipoDb> equipoDbs);
}