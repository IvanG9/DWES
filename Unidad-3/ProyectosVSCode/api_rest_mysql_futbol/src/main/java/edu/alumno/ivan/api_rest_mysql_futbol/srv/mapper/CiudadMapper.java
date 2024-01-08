package edu.alumno.ivan.api_rest_mysql_futbol.srv.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import edu.alumno.ivan.api_rest_mysql_futbol.model.db.CiudadDb;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.CiudadInfo;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.CiudadList;



@Mapper(uses = EquipMapper.class)
public interface CiudadMapper {
    CiudadMapper INSTANCE = Mappers.getMapper(CiudadMapper.class);

    CiudadList ciudadDbToCiudadList(CiudadDb ciudadDb);
    List<CiudadList> ciudadesToCiudadList(List<CiudadDb> cidadesDb);

    @Mapping(target = "equiposInfoNombres" ,source = "equiposDb")
    CiudadInfo ciudadDbToCiudadInfo(CiudadDb ciudadDb);
}

