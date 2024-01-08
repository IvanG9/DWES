package edu.alumno.ivan.dwes_futbol_rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.alumno.ivan.dwes_futbol_rest.model.db.EquipoDb;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.EquipEdit;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.EquipList;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.EquipoInfo;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.PaginaDto;
import edu.alumno.ivan.dwes_futbol_rest.reopsitory.EquipoRepository;
import edu.alumno.ivan.dwes_futbol_rest.service.EquipoService;
import edu.alumno.ivan.dwes_futbol_rest.service.mapper.EquipMapper;

@Service
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoServiceImpl(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }


    @Override
    public Optional<EquipoInfo> getEquipInfoById(String id) {
        Optional<EquipoDb> jornadaDb = equipoRepository.findById(id);

        if (jornadaDb.isPresent()) {
            return Optional.of(EquipMapper.INSTANCE.equipDbToEquipInfo(jornadaDb.get()));
        }

        return Optional.empty();
    }

    @Override
    public EquipEdit save(EquipEdit equipEdit) {
        EquipoDb equipoDb = equipoRepository.save(EquipMapper.INSTANCE.equipEditToEquipDb(equipEdit));
        return EquipMapper.INSTANCE.equipDbToEquipEdit(equipoDb);
    }


    
    @Override
    public PaginaDto<EquipList> findAllPageEquipList(Pageable paging) {
        Page<EquipoDb> paginaEquipDb = equipoRepository.findAll(paging);

        return new PaginaDto<EquipList>(
            paginaEquipDb.getNumber(),
            paginaEquipDb.getSize(),
            paginaEquipDb.getTotalElements(),
            paginaEquipDb.getTotalPages(),
            EquipMapper.INSTANCE.equipToEquipList(paginaEquipDb.getContent()),
            paginaEquipDb.getSort()
        );
    }

    @Override
    public PaginaDto<EquipList> findByNombreLargoContaining(String nombreLargo, Pageable paging) {
        Page<EquipoDb> paginaEquipDb = equipoRepository.findByNombreLargoContaining(paging, nombreLargo);

        return new PaginaDto<EquipList>(
            paginaEquipDb.getNumber(),
            paginaEquipDb.getSize(),
            paginaEquipDb.getTotalElements(),
            paginaEquipDb.getTotalPages(),
            EquipMapper.INSTANCE.equipToEquipList(paginaEquipDb.getContent()),
            paginaEquipDb.getSort()
        );
    }


    @Override
    public String deleteByDni(Long id) {
        return equipoRepository.findById(id).map(a -> {
            equipoRepository.deleteById(id);
            return "Deleted";
        }).orElse("Not Deleted");
    }

}
