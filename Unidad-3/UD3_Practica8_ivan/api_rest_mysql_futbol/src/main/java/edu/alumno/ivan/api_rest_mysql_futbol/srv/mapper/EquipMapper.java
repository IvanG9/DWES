package edu.alumno.ivan.api_rest_mysql_futbol.srv.mapper;


import org.mapstruct.Mapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;
import java.util.Set;

import edu.alumno.ivan.api_rest_mysql_futbol.model.db.EquipoDb;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquipoList;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquiposCiudadEntrenadoresList;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquipoEdit;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquipoInfo;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquipoInfoNombre;

@Mapper
public interface EquipMapper {
    
    EquipMapper INSTANCE= Mappers.getMapper(EquipMapper.class);

    @Mapping(target = "nombreCiudad", source = "ciudadDb.nombre")
    EquiposCiudadEntrenadoresList equipoDbToEquiposCiudadEntrenadoresList(EquipoDb equipoDb);
    List<EquiposCiudadEntrenadoresList> equiposDbToEquiposCiudadEntrenadoresList(List<EquipoDb> content);
    EquipoList equipoDbToEquipList(EquipoDb equipoDb);
    Set<EquipoInfoNombre> equiposDbToEquiposInfoNombre(Set<EquipoDb> equipoDbs);
    List<EquipoList> equiposDbToEquiposList(List<EquipoDb> content);
    EquipoInfo equipoDbToEquipoInfo(EquipoDb equipoDb);
    EquipoEdit equipoDbToEquipoEdit(EquipoDb equipoDb);
    EquipoDb equipoEditToEquipoDb(EquipoEdit equipoEdit);

}