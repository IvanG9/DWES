package edu.alumno.ivan.dwes_futbol_rest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.alumno.ivan.dwes_futbol_rest.model.dto.JornadaList;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.JornadaInfo;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.PaginaDto;

public interface JornadaService {
    public Optional<JornadaInfo> getJornadaInfoById(Long id);
    public List<JornadaList> findAllJornadaList();
    public List<JornadaList> findAllJornadaList(Sort sort);
    public List<JornadaList> findByFechaContaining(String nombre, Sort sort);
    public PaginaDto<JornadaList> findByFechaContaining(String nombre, Pageable paging);
    public PaginaDto<JornadaList> findAllPageJornadaList(Pageable paging);
}
