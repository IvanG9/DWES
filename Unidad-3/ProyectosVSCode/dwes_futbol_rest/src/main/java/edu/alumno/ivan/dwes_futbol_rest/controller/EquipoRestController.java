package edu.alumno.ivan.dwes_futbol_rest.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import edu.alumno.ivan.dwes_futbol_rest.exception.ResourceNotFoundException;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.EquipEdit;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.EquipList;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.EquipoInfo;
import edu.alumno.ivan.dwes_futbol_rest.model.dto.PaginaDto;
import edu.alumno.ivan.dwes_futbol_rest.service.EquipoService;

@RestController
@RequestMapping("/api/v1")
public class EquipoRestController {

    private EquipoService equipoService;

    @GetMapping("/equipos")

    public ResponseEntity<Map<String, Object>> getAllEquips(

            @RequestParam(required = false) String nombreLargo,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort

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

            PaginaDto<EquipList> paginaEquipsList;

            if (nombreLargo == null) {
                paginaEquipsList = equipoService.findAllPageEquipList(paging);
            } else {
                paginaEquipsList = equipoService.findByNombreLargoContaining(nombreLargo,paging);
            }

            List<EquipList> ciudades = paginaEquipsList.getContent();
            Map<String, Object> response = new HashMap<>();
            response.put("data", ciudades);
            response.put("currentPage", paginaEquipsList.getNumber());
            response.put("pageSize", paginaEquipsList.getSize());
            response.put("totalItems", paginaEquipsList.getTotalElements());
            response.put("totalPages", paginaEquipsList.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Autowired
    public EquipoRestController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping("/equipos/{id}/info")
    public ResponseEntity<EquipoInfo> getJornadaInfoById(@PathVariable(value = "id") String id)
            throws RuntimeException {
        Optional<EquipoInfo> jornadaInfo = equipoService.getEquipInfoById(id);

        if (jornadaInfo.isPresent()) {
            return ResponseEntity.ok().body(jornadaInfo.get());
        }

        throw new ResourceNotFoundException("Jornada not found on :: " + id);
    }

    @PutMapping("/equipos/{id}")
    public ResponseEntity<EquipEdit> updateEquipEdit(
            @PathVariable(value = "id") String id,
            @Valid @RequestBody EquipEdit equipEdit) throws RuntimeException {
        return null;
    }

    @DeleteMapping("/equipos/{id}")
    public String deleteById(@PathVariable(value = "id") String id) {
        return "";
    }

}
