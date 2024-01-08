package edu.alumno.ivan.api_rest_mysql_futbol.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.JugadorList;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.PaginaDto;
import edu.alumno.ivan.api_rest_mysql_futbol.srv.JugadorService;


@RestController
@RequestMapping("/api/v1")
public class JugadorRestController {
    
    private JugadorService jugadorService;

    @Autowired
    public JugadorRestController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping("/jugadores")
    public ResponseEntity<Map<String,Object>> getAllJugadores(
        @RequestParam(required = false) String nombre,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "3") int size,
        @RequestParam(defaultValue = "idEquipo,asc") String[] sort
    ) {
        try {
            List<Order> criteriosOrdenacion = new ArrayList<Order>();

            if (sort[0].contains(",")) {
                for (String criterioOrdenacion : sort) {
                    String[] orden = criterioOrdenacion.split(",");
                    if (orden.length > 1) {
                        criteriosOrdenacion.add(new Order(Direction.fromString(orden[1]), orden[0]));
                    } else {
                        criteriosOrdenacion.add(new Order(Direction.fromString("asc"), orden[0]));
                    }
                }
            } else {
                criteriosOrdenacion.add(new Order(Direction.fromString(sort[1]), sort[0]));
            }

            Sort sorts = Sort.by(criteriosOrdenacion);

            Pageable paging = PageRequest.of(page, size, sorts);

            PaginaDto<JugadorList> paginaEquipoList=jugadorService.findAll(paging);

            List<JugadorList> ciudades = paginaEquipoList.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("data", ciudades);
            response.put("currentPage", paginaEquipoList.getNumber());
            response.put("pageSize", paginaEquipoList.getSize());
            response.put("totalItems", paginaEquipoList.getTotalElements());
            response.put("totalPages", paginaEquipoList.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
