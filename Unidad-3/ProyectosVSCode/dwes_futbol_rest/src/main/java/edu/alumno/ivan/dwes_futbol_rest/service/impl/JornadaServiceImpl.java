package edu.alumno.ivan.dwes_futbol_rest.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.alumno.ivan.dwes_futbol_rest.model.db.JornadaDb;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.JornadaList;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.JornadaInfo;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.PaginaDto;
import edu.alumno.ivan.dwes_futbol_rest.reopsitory.JornadaRepository;
import edu.alumno.ivan.dwes_futbol_rest.service.mapper.JornadaMapper;
import edu.alumno.ivan.dwes_futbol_rest.service.JornadaService;

@Service
public class JornadaServiceImpl implements JornadaService {

    private final JornadaRepository jornadaRepository;

    public JornadaServiceImpl(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    @Override
    public Optional<JornadaInfo> getJornadaInfoById(Long id) {
        Optional<JornadaDb> jornadaDb = jornadaRepository.findById(id);

        if (jornadaDb.isPresent()) {
            return Optional.of(JornadaMapper.INSTANCE.JornadaDbToJornadaInfo(jornadaDb.get()));
        }

        return Optional.empty();
    }

    @Override
    public List<JornadaList> findAllJornadaList() {
        return JornadaMapper.INSTANCE.jornadasToJornadaList(jornadaRepository.findAll());
    }

    @Override
    public List<JornadaList> findAllJornadaList(Sort sort) {
        return JornadaMapper.INSTANCE.jornadasToJornadaList(jornadaRepository.findAll(sort));
    }

    @Override
    public List<JornadaList> findByFechaContaining(String fecha, Sort sort) {
        return JornadaMapper.INSTANCE.jornadasToJornadaList(jornadaRepository.findByFechaContaining(sort, fecha));
    }

    @Override
    public PaginaDto<JornadaList> findByFechaContaining(String fecha, Pageable paging) {
        Page<JornadaDb> paginaJornadaDb = jornadaRepository.findByFechaContaining(paging, fecha);

        return new PaginaDto<JornadaList>(
            paginaJornadaDb.getNumber(),
            paginaJornadaDb.getSize(),
            paginaJornadaDb.getTotalElements(),
            paginaJornadaDb.getTotalPages(),
            JornadaMapper.INSTANCE.jornadasToJornadaList(paginaJornadaDb.getContent()),
            paginaJornadaDb.getSort()
        );
    }

    @Override
    public PaginaDto<JornadaList> findAllPageJornadaList(Pageable paging) {
        Page<JornadaDb> paginaJornadaDb = jornadaRepository.findAll(paging);

        return new PaginaDto<JornadaList>(
            paginaJornadaDb.getNumber(),
            paginaJornadaDb.getSize(),
            paginaJornadaDb.getTotalElements(),
            paginaJornadaDb.getTotalPages(),
            JornadaMapper.INSTANCE.jornadasToJornadaList(paginaJornadaDb.getContent()),
            paginaJornadaDb.getSort()
        );
    }
    
}
