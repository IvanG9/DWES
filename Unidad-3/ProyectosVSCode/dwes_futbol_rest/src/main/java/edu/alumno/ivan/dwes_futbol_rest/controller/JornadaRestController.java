package edu.alumno.ivan.dwes_futbol_rest.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.alumno.ivan.dwes_futbol_rest.service.JornadaService;
import edu.alumno.ivan.dwes_futbol_rest.exception.ResourceNotFoundException;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.JornadaInfo;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.JornadaList;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.PaginaDto;

@RestController
@RequestMapping("/api/v1")
public class JornadaRestController {

    private JornadaService jornadaService;

    @Autowired
    public JornadaRestController(JornadaService jornadaService) {
        this.jornadaService = jornadaService;
    }

    @GetMapping("/jornadas")
    public ResponseEntity<Map<String, Object>> getAllJornadas(
            @RequestParam(required = false) String fecha,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "num,asc") String[] sort) {
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

            PaginaDto<JornadaList> paginaJornadasList;

            if (fecha == null) {
                paginaJornadasList = jornadaService.findAllPageJornadaList(paging);
            } else {
                paginaJornadasList = jornadaService.findByFechaContaining(fecha, paging);
            }

            List<JornadaList> jornadas = paginaJornadasList.getContent();
            Map<String, Object> response = new HashMap<>();
            response.put("data", jornadas);
            response.put("currentPage", paginaJornadasList.getNumber());
            response.put("pageSize", paginaJornadasList.getSize());
            response.put("totalItems", paginaJornadasList.getTotalElements());
            response.put("totalPages", paginaJornadasList.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/jornadas/orden/{direccionOrden}")
    public Collection<JornadaList> getJornadasList (@PathVariable("direccionOrden") String direccionOrden) {
        return jornadaService.findAllJornadaList(Sort.by(Direction.fromString(direccionOrden), "num"));
    }

    @GetMapping("/jornadas/{num}/info")
    public ResponseEntity<JornadaInfo> getJornadaInfoById(@PathVariable(value = "num") Long num) throws RuntimeException {
        Optional<JornadaInfo> jornadaInfo = jornadaService.getJornadaInfoById(num);

        if (jornadaInfo.isPresent()) {
            return ResponseEntity.ok().body(jornadaInfo.get());
        }

        throw new ResourceNotFoundException("Jornada not found on :: " + num);
    }

    @GetMapping("/jornadas/fecha/{fecha}/orden/{direccionOrden}")
    public Collection<JornadaList> getJornadasNombreContainingOrderBy(
        @PathVariable("direccionOrden") String direccionOrden,
        @PathVariable("fecha") String fecha
        ) {
        return jornadaService.findByFechaContaining(fecha, Sort.by(Direction.fromString(direccionOrden), "num"));
    }
}
