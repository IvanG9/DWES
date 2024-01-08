package edu.alumno.ivan.api_rest_mysql_futbol.srv.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.alumno.ivan.api_rest_mysql_futbol.model.db.PorteroDb;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.PaginaDto;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.PorteroList;
import edu.alumno.ivan.api_rest_mysql_futbol.repository.PorteroRepository;
import edu.alumno.ivan.api_rest_mysql_futbol.srv.PorteroService;
import edu.alumno.ivan.api_rest_mysql_futbol.srv.mapper.PorteroMapper;

@Service
public class PorteroServiceImpl implements PorteroService {

    private final PorteroRepository porteroRepository;

    public PorteroServiceImpl(PorteroRepository porteroRepository){
        this.porteroRepository = porteroRepository;
    }

    @Override
    public PaginaDto<PorteroList> findAll(Pageable paging) {

        Page<PorteroDb> paginaJugadorDb = porteroRepository.findAll(paging);
        return new PaginaDto<PorteroList>(
            paginaJugadorDb.getNumber(),
            paginaJugadorDb.getSize(),
            paginaJugadorDb.getTotalElements(),
            paginaJugadorDb.getTotalPages(),
            PorteroMapper.INSTANCE.porterosDbToPorterosList(paginaJugadorDb.getContent()),
            paginaJugadorDb.getSort());
    }


}
