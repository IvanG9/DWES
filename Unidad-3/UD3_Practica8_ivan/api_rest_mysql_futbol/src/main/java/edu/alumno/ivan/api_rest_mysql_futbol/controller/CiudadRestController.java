package edu.alumno.ivan.api_rest_mysql_futbol.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.alumno.ivan.api_rest_mysql_futbol.exception.ResourceNotFoundException;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.CiudadInfo;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.CiudadList;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.PaginaDto;
import edu.alumno.ivan.api_rest_mysql_futbol.srv.CiudadService;

@RestController
@RequestMapping("/api/v1")
public class CiudadRestController {

    private CiudadService ciudadService;

    @Autowired
    public CiudadRestController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @GetMapping("/ciudades")
    public ResponseEntity<Map<String, Object>> getAllCiudades(
            @RequestParam(required = false) String nombre,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {
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

            PaginaDto<CiudadList> paginaCiudadesList;

            if (nombre == null) {
                paginaCiudadesList = ciudadService.findAllPageCiudadList(paging);
            } else {
                paginaCiudadesList = ciudadService.findByNombreContaining(nombre, paging);
            }

            List<CiudadList> ciudades = paginaCiudadesList.getContent();
            Map<String, Object> response = new HashMap<>();
            response.put("data", ciudades);
            response.put("currentPage", paginaCiudadesList.getNumber());
            response.put("pageSize", paginaCiudadesList.getSize());
            response.put("totalItems", paginaCiudadesList.getTotalElements());
            response.put("totalPages", paginaCiudadesList.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ciudades/orden/{direccionOrden}")
    public Collection<CiudadList> getCiudadesList(@PathVariable("direccionOrden") String direccionOrden) {
        return ciudadService.findAllCiudadList(Sort.by(Direction.fromString(direccionOrden), "nombre"));
    }

    @GetMapping("/ciudades/{id}/info")
    public ResponseEntity<CiudadInfo> getCiudadInfoById(@PathVariable(value = "id") Long id) throws RuntimeException {
        Optional<CiudadInfo> ciudadInfo = ciudadService.getCiudadInfoById(id);

        if (ciudadInfo.isPresent()) {
            return ResponseEntity.ok().body(ciudadInfo.get());
        }

        throw new ResourceNotFoundException("Ciudad not found on :: " + id);
    }

    @GetMapping("/ciudades/nombre/{nombre}/orden/{direccionOrden}")
    public Collection<CiudadList> getCiudadesNombreContainingOrderBy(
            @PathVariable("direccionOrden") String direccionOrden,
            @PathVariable("nombre") String nombre) {
        return ciudadService.findByNombreContaining(nombre, Sort.by(Direction.fromString(direccionOrden), "nombre"));
    }

}
