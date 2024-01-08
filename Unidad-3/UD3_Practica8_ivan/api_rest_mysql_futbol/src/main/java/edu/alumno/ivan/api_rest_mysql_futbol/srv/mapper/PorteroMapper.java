package edu.alumno.ivan.api_rest_mysql_futbol.srv.mapper;


import org.mapstruct.Mapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;



import edu.alumno.ivan.api_rest_mysql_futbol.model.db.PorteroDb;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.PorteroList;

@Mapper
public interface PorteroMapper {
    
    PorteroMapper INSTANCE= Mappers.getMapper(PorteroMapper.class);

    @Mapping(target = "nombre", source = "jugadorDb.nombre")
    PorteroList porteroDbToPorteroList(PorteroDb porteroDb);
    List<PorteroList> porterosDbToPorterosList(List<PorteroDb>porterosDb);
}