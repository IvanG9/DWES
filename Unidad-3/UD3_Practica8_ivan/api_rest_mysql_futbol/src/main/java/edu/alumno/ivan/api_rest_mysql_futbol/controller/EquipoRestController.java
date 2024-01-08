package edu.alumno.ivan.api_rest_mysql_futbol.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.alumno.ivan.api_rest_mysql_futbol.exception.ResourceNotFoundException;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquipoList;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquiposCiudadEntrenadoresList;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquipoEdit;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EquipoInfo;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.PaginaDto;
import edu.alumno.ivan.api_rest_mysql_futbol.srv.EquipoService;

@RestController
@RequestMapping("/api/v1")
public class EquipoRestController {

    private EquipoService equipoService;

    @Autowired
    public EquipoRestController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    // Listar equipo info

    @GetMapping("/equipos/{id}/info")
    public ResponseEntity<EquipoInfo> getEquipoInfoById(@PathVariable(value = "id") String id)
            throws ResourceNotFoundException {
        Optional<EquipoInfo> equipoInfo = equipoService.getEquipoInfoById(id);

        if (equipoInfo.isPresent()) {
            return ResponseEntity.ok().body(equipoInfo.get());
        }

        throw new ResourceNotFoundException("No se ha encontrado el equipo " + id);
    }

    // Eliminar equipos

    @DeleteMapping("/equipos/{id}")
    public void deleteEquipo(@PathVariable("id") String id) {
        equipoService.deleteById(id);
    }

    // Crear equipo

    @PostMapping("/nuevoEquipo")
    public EquipoEdit addEquipo(@RequestBody EquipoEdit equipoEdit) {
        return equipoService.save(equipoEdit);
    }

    // Actualizar Equipo

    @PutMapping("/equiposMod")
    public Optional<EquipoEdit> updateEquipoEdit(@Valid @RequestBody EquipoEdit equipoEdit) throws RuntimeException {
                
        return equipoService.update(equipoEdit);

    }


    //Paginacion Equipos
    @GetMapping("/equipos")
    public ResponseEntity<Map<String, Object>> getAllEquipos(
            @RequestParam(required = false) String nombreCorto,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "nombreLargo,asc") String[] sort) {
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

            PaginaDto<EquiposCiudadEntrenadoresList> paginaEquipoList = null;

            if(nombreCorto != null){
                paginaEquipoList = equipoService.findByNombreCortoContaining(nombreCorto,paging);
            }else{
                paginaEquipoList = equipoService.findAll(paging);
            }

            List<EquiposCiudadEntrenadoresList> equipos = paginaEquipoList.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("data", equipos);
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
