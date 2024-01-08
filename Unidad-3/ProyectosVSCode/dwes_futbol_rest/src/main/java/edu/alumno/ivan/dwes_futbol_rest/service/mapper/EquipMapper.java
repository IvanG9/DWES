package edu.alumno.ivan.dwes_futbol_rest.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import edu.alumno.ivan.dwes_futbol_rest.model.db.EquipoDb;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.EquipList;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.EquipEdit;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.EquipoInfo;

@Mapper
public interface EquipMapper {

    EquipMapper INSTANCE = Mappers.getMapper(EquipMapper.class);

    EquipoInfo equipDbToEquipInfo(EquipoDb equipoDb);
    EquipList equipDbToEquipList(EquipoDb equipoDb);
    List<EquipList> equipToEquipList(List<EquipoDb> equipoDb);
    EquipoDb equipEditToEquipDb(EquipEdit equipEdit);
    EquipEdit equipDbToEquipEdit(EquipoDb equipoDb);

}
