package edu.alumno.ivan.api_rest_mysql_futbol.srv.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import edu.alumno.ivan.api_rest_mysql_futbol.model.db.JugadorDb;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.JugadorList;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.PaginaDto;
import edu.alumno.ivan.api_rest_mysql_futbol.repository.JugadorRepository;
import edu.alumno.ivan.api_rest_mysql_futbol.srv.JugadorService;
import edu.alumno.ivan.api_rest_mysql_futbol.srv.mapper.JugadorMapper;

@Service
public class JugadorServiceImpl implements JugadorService {

    private final JugadorRepository jugadorRepository;

    public JugadorServiceImpl(JugadorRepository jugadorRepository){
        this.jugadorRepository = jugadorRepository;
    }

    @Override
    public PaginaDto<JugadorList> findAll(Pageable paging) {

        Page<JugadorDb> paginaJugadorDb = jugadorRepository.findAll(paging);
        return new PaginaDto<JugadorList>(
            paginaJugadorDb.getNumber(),
            paginaJugadorDb.getSize(),
            paginaJugadorDb.getTotalElements(),
            paginaJugadorDb.getTotalPages(),
            JugadorMapper.INSTANCE.jugadoresDbToJugadoresList(paginaJugadorDb.getContent()),
            paginaJugadorDb.getSort());
    }


}
