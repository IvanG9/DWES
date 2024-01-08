package edu.alumno.ivan.api_rest_mysql_futbol.srv.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.alumno.ivan.api_rest_mysql_futbol.model.db.CiudadDb;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.CiudadInfo;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.CiudadList;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.PaginaDto;
import edu.alumno.ivan.api_rest_mysql_futbol.repository.CiudadRepository;
import edu.alumno.ivan.api_rest_mysql_futbol.srv.CiudadService;
import edu.alumno.ivan.api_rest_mysql_futbol.srv.mapper.CiudadMapper;



@Service
public class CiudadServiceImpl implements CiudadService {

    private final CiudadRepository ciudadRepository;

    public CiudadServiceImpl(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    @Override
    public Optional<CiudadInfo> getCiudadInfoById(Long id) {
        Optional<CiudadDb> ciudadDb = ciudadRepository.findById(id);

        if (ciudadDb.isPresent()) {
            return Optional.of(CiudadMapper.INSTANCE.ciudadDbToCiudadInfo(ciudadDb.get()));
        }

        return Optional.empty();
    }

    @Override
    public List<CiudadList> findAllCiudadList() {
        return CiudadMapper.INSTANCE.ciudadesToCiudadList(ciudadRepository.findAll());
    }

    @Override
    public List<CiudadList> findAllCiudadList(Sort sort) {
        return CiudadMapper.INSTANCE.ciudadesToCiudadList(ciudadRepository.findAll(sort));
    }

    @Override
    public List<CiudadList> findByNombreContaining(String nombre, Sort sort) {
        return CiudadMapper.INSTANCE.ciudadesToCiudadList(ciudadRepository.findByNombreContaining(nombre, sort));
    }

    @Override
    public PaginaDto<CiudadList> findAllPageCiudadList(Pageable paging) {
        Page<CiudadDb> paginaCiudadDb = ciudadRepository.findAll(paging);

        return new PaginaDto<CiudadList>(
            paginaCiudadDb.getNumber(),
            paginaCiudadDb.getSize(),
            paginaCiudadDb.getTotalElements(),
            paginaCiudadDb.getTotalPages(),
            CiudadMapper.INSTANCE.ciudadesToCiudadList(paginaCiudadDb.getContent()),
            paginaCiudadDb.getSort()
        );
    }

    @Override
    public PaginaDto<CiudadList> findByNombreContaining(String nombre, Pageable paging) {
        Page<CiudadDb> paginaCiudadDb = ciudadRepository.findByNombreContaining(paging, nombre);

        return new PaginaDto<CiudadList>(
            paginaCiudadDb.getNumber(),
            paginaCiudadDb.getSize(),
            paginaCiudadDb.getTotalElements(),
            paginaCiudadDb.getTotalPages(),
            CiudadMapper.INSTANCE.ciudadesToCiudadList(paginaCiudadDb.getContent()),
            paginaCiudadDb.getSort()
        );
    }

    @Override
    public CiudadDb addCiudad(String nombre,Long habitantes) {
        try{
            CiudadDb ciudadDb = new CiudadDb();
            ciudadDb.setNombre(nombre);
            ciudadDb.setHabitantes(habitantes);
            return ciudadRepository.save(ciudadDb);
        } catch (Exception e) {
            
        }
        return null;
     
    }



    @Override
    public Optional<CiudadInfo> getCiudadInfoByNombre(String nombre) {

        Optional<CiudadDb> ciudadDb = ciudadRepository.findByNombre(nombre);

        if (ciudadDb.isPresent()) {
            return Optional.of(CiudadMapper.INSTANCE.ciudadDbToCiudadInfo(ciudadDb.get()));
        }

        return Optional.empty();
    }

    @Override
    public void addCiudad(CiudadDb ciudadDb) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addCiudad'");
    }

}