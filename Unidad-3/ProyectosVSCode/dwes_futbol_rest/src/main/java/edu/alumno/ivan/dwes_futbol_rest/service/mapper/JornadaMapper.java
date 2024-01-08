package edu.alumno.ivan.dwes_futbol_rest.service.mapper;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import edu.alumno.ivan.dwes_futbol_rest.model.db.JornadaDb;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.JornadaInfo;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.JornadaList;

@Mapper
public interface JornadaMapper {
    JornadaMapper INSTANCE = Mappers.getMapper(JornadaMapper.class);

    JornadaInfo JornadaDbToJornadaInfo(JornadaDb jornadaDb);
    JornadaList JornadaDbToJornadaList(JornadaDb jornadaDb);
    List<JornadaList> jornadasToJornadaList(List<JornadaDb> jornadaDbs);
}

