package edu.alumno.ivan.api_rest_mysql_futbol.srv.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.alumno.ivan.api_rest_mysql_futbol.model.db.EquipoDb;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquipList;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.PaginaDto;
import edu.alumno.ivan.api_rest_mysql_futbol.repository.EquipoRepository;
import edu.alumno.ivan.api_rest_mysql_futbol.srv.EquipoService;
import edu.alumno.ivan.api_rest_mysql_futbol.srv.mapper.EquipMapper;

@Service
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoServiceImpl(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @Override
    public PaginaDto<EquipList> findAll(Pageable paging) {

        Page<EquipoDb> paginaEquipoDb = equipoRepository.findAll(paging);
        return new PaginaDto<EquipList>(
                paginaEquipoDb.getNumber(),
                paginaEquipoDb.getSize(),
                paginaEquipoDb.getTotalElements(),
                paginaEquipoDb.getTotalPages(),
                EquipMapper.INSTANCE.equiposDbToEquiposList(paginaEquipoDb.getContent()),
                paginaEquipoDb.getSort());
    }

}
