package edu.alumno.ivan.api_rest_mysql_futbol.srv.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.alumno.ivan.api_rest_mysql_futbol.model.db.EquipoDb;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquipoList;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquiposCiudadEntrenadoresList;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquipoEdit;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquipoInfo;
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
    public PaginaDto<EquiposCiudadEntrenadoresList> findAll(Pageable paging) {

        Page<EquipoDb> paginaEquipoDb = equipoRepository.findAll(paging);
        return new PaginaDto<EquiposCiudadEntrenadoresList>(
                paginaEquipoDb.getNumber(),
                paginaEquipoDb.getSize(),
                paginaEquipoDb.getTotalElements(),
                paginaEquipoDb.getTotalPages(),
                EquipMapper.INSTANCE.equiposDbToEquiposCiudadEntrenadoresList(paginaEquipoDb.getContent()),
                paginaEquipoDb.getSort());
    }

    @Override
    public Optional<EquipoInfo> getEquipoInfoById(String id) {
             Optional<EquipoDb> equipoDb = equipoRepository.findById(id);

        if (equipoDb.isPresent()) {
            return Optional.of(EquipMapper.INSTANCE.equipoDbToEquipoInfo(equipoDb.get()));
        }

        return Optional.empty();
    }

    public void deleteById(String id) {
        equipoRepository.deleteById(id);
    }

    @Override
    public EquipoEdit save(EquipoEdit equipoEdit) {
        EquipoDb equipoDb = equipoRepository.save(EquipMapper.INSTANCE.equipoEditToEquipoDb(equipoEdit));
        return EquipMapper.INSTANCE.equipoDbToEquipoEdit(equipoDb);
    }

    @Override
    public Optional<EquipoEdit> update(EquipoEdit equipoEdit) {
        
        Optional<EquipoEdit> equipoEditExistente = getEquipoEditById(equipoEdit.getId());
        if (equipoEditExistente.isPresent()) {
            deleteById(equipoEdit.getId());
            equipoRepository.save(EquipMapper.INSTANCE.equipoEditToEquipoDb(equipoEdit));
            return getEquipoEditById(equipoEdit.getId());
        } else {
            return Optional.empty();
        }
    }

    private Optional<EquipoEdit> getEquipoEditById(String id) {
        
        Optional<EquipoDb> equipoDb = equipoRepository.findById(id);

        if (equipoDb.isPresent()) {
            return Optional.of(EquipMapper.INSTANCE.equipoDbToEquipoEdit(equipoDb.get()));
        }

        return Optional.empty();
    }

    @Override
    public PaginaDto<EquiposCiudadEntrenadoresList> findByNombreCortoContaining(String nombreCorto,Pageable paging) {

        Page<EquipoDb> paginaEquipoDb = equipoRepository.findByNombreCortoContaining(nombreCorto,paging);
        return new PaginaDto<EquiposCiudadEntrenadoresList>(
                paginaEquipoDb.getNumber(),
                paginaEquipoDb.getSize(),
                paginaEquipoDb.getTotalElements(),
                paginaEquipoDb.getTotalPages(),
                EquipMapper.INSTANCE.equiposDbToEquiposCiudadEntrenadoresList(paginaEquipoDb.getContent()),
                paginaEquipoDb.getSort());
    }



}   
