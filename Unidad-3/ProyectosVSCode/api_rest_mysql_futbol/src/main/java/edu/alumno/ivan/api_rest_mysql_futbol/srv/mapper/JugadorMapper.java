package edu.alumno.ivan.api_rest_mysql_futbol.srv.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import edu.alumno.ivan.api_rest_mysql_futbol.model.db.JugadorDb;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.JugadorList;

@Mapper
public interface JugadorMapper {

    JugadorMapper INSTANCE= Mappers.getMapper(JugadorMapper.class);
    List<JugadorList> jugadoresDbToJugadoresList(List<JugadorDb> jugadorDbs);

}
