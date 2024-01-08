package edu.alumno.ivan.dwes_futbol_rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.alumno.ivan.dwes_futbol_rest.model.dto.CiudadInfo;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.CiudadList;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.PaginaDto;

public interface CiudadService {
    public Optional<CiudadInfo> getCiudadInfoById(Long id);
    public List<CiudadList> findAllCiudadList();
    public List<CiudadList> findAllCiudadList(Sort sort);
    public List<CiudadList> findByNombreContaining(String nombre, Sort sort);
    public PaginaDto<CiudadList> findByNombreContaining(String nombre, Pageable paging);
    public PaginaDto<CiudadList> findAllPageCiudadList(Pageable paging);
}