package edu.alumno.ivan.dwes_primer_rest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.alumno.ivan.dwes_primer_rest.exception.ResourceNotFoundException;
import edu.alumno.ivan.dwes_primer_rest.model.dto.AlumnoEdit;
import edu.alumno.ivan.dwes_primer_rest.model.dto.AlumnoInfo;
import edu.alumno.ivan.dwes_primer_rest.model.dto.AlumnoList;
import edu.alumno.ivan.dwes_primer_rest.service.AlumnoService;

@RestController
@RequestMapping("/api/v1/")
public class AlumnoRestController {

    private AlumnoService alumnoService;

    @Autowired
    public AlumnoRestController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/alumnos")
    public List<AlumnoList> getAlumnosList() {
        return null;
    }

    @PostMapping("/alumnos")
    public AlumnoEdit newAlumnoEdit(@Valid @RequestBody AlumnoEdit alumnoEdit) {
        return alumnoService.save(alumnoEdit);
    }

    @GetMapping("/alumnos/{dni}")
    public ResponseEntity<AlumnoEdit> getAlumnoEditByDni(
            @PathVariable(value = "dni") String dni) throws RuntimeException {
        Optional<AlumnoEdit> alumnoEdit = alumnoService.getAlumnoEditByDni(dni);
        if (alumnoEdit.isPresent())
            return ResponseEntity.ok().body(alumnoEdit.get());
        else
            throw new ResourceNotFoundException("Alumno not found on :: " + dni);
    }

    @GetMapping("/alumnos/{dni}/info")
    public ResponseEntity<AlumnoInfo> getAlumnoInfoByDni(
            @PathVariable(value = "dni") String dni) throws RuntimeException {
        return null;
    }

    @PutMapping("/alumnos/{dni}")
    public ResponseEntity<AlumnoEdit> updateAlumnoEdit(
            @PathVariable(value = "dni") String dni,
            @Valid @RequestBody AlumnoEdit alumnoEdit) throws RuntimeException {
        return null;
    }
    
    @DeleteMapping("/alumnos/{dni}")
    public String deleteByDni(@PathVariable(value = "dni") String dni) {
        return "";
    }

    @GetMapping("/alumnosDAW")
    public List<AlumnoList> getAlumnosListDAW() {
        return alumnoService.findAllAlumnoListDAW();
    }

    @GetMapping("/alumnosDAM")
    public List<AlumnoList> getAlumnosListDAM() {
        return alumnoService.findAllAlumnoListDAM();
    }

    @GetMapping("/alumnos/ciclo/{ciclo}")
    public List<AlumnoList> getAlumnosListCiclo(@PathVariable("ciclo") String ciclo) {
        return alumnoService.findAllAlumnosListCiclo(ciclo);
    }

    @GetMapping("/alumnos/ciclo/{ciclo}/pais/{pais}")
    public List<AlumnoList> getAlumnosListCicloPais(@PathVariable("ciclo") String ciclo,
            @PathVariable("pais") String pais) {
        return alumnoService.findAllAlumnosListCicloPais(ciclo, pais);
    }

    // Metodos automaticos en Spring Data JPA

    @GetMapping("/alumnosList/dni/{dni}")
    public List<AlumnoList> getAlumnosListByDni(@PathVariable("dni") String dni) {
        return alumnoService.findAlumnosListByDni(dni);
    }

    @GetMapping("/alumnosList/ciclo/{ciclo}")
    public List<AlumnoList> getAlumnosListByCiclo(@PathVariable("ciclo") String ciclo) {
        return alumnoService.findAllAlumnosListCiclo(ciclo);
    }

    @GetMapping("/alumnosList/horario/{horario}")
    public List<AlumnoList> getAlumnosListByHorario(@PathVariable("horario") String horario) {
        return alumnoService.findAlumnosListByHorario(horario);
    }

    @GetMapping("/alumnosList/edad/{edad}")
    public List<AlumnoList> getAlumnosListByEdad(@PathVariable("edad") Integer edad) {
        return alumnoService.findAlumnosListByEdad(edad);
    }

    // Ordenacion de resultados
    @GetMapping("/alumnos/ciclo/{ciclo}/OrderByCurso")
    public List<AlumnoList> getAlumnosListCicloOrderByCurso(@PathVariable("ciclo") String ciclo) {
        return alumnoService.findAllAlumnosListCicloOrderByCurso(ciclo);
    }

    // Métodos con Ordenación SQL en Spring Data JPA
    @GetMapping("/alumnosList/ciclo/{ciclo}/OrderBy/{atributoOrden}/{direccion}")
    public List<AlumnoList> getAlumnosListByCicloOrderBy(@PathVariable("ciclo") String ciclo,
            @PathVariable("atributoOrden") String atributoOrden,
            @PathVariable("direccion") String direccion) {
        return alumnoService.findByCicloOrderBy(ciclo, Sort.by(Direction.fromString(direccion), atributoOrden));
    }

    @GetMapping("/alumnosList/edad/{edad}/OrderBy/{atributoOrden}/{direccion}")
    public List<AlumnoList> getAlumnosListByEdadOrderBy(@PathVariable("edad") Integer edad,
            @PathVariable("atributoOrden") String atributoOrden,
            @PathVariable("direccion") String direccion) {
        return alumnoService.findByEdadOrderBy(edad, Sort.by(Direction.fromString(direccion), atributoOrden));
    }

    // Métodos automáticos con Ordenacion en Spring Data JPA

    @GetMapping("/alumnos/ciclo/{ciclo}/OrderBy/{atributoOrden}/{direccion}")
    public List<AlumnoList> getAlumnosByCicloOrderBy(@PathVariable("ciclo") String ciclo,
                                                    @PathVariable("atributoOrden") String atributoOrden,
                                                    @PathVariable("direccion") String direccion) {
        return alumnoService.findByCiclo(ciclo, Sort.by(Direction.fromString(direccion), atributoOrden));
    }

    @GetMapping("/alumnos/horario/{horario}/OrderBy/{atributoOrden}/{direccion}")
    public List<AlumnoList> getAlumnosByHorarioOrderBy(@PathVariable("horario") String horario,
                                                    @PathVariable("atributoOrden") String atributoOrden,
                                                    @PathVariable("direccion") String direccion) {
        return alumnoService.findByHorario(horario, Sort.by(Direction.fromString(direccion), atributoOrden));
    }

    @GetMapping("/alumnos/edad/{edad}/OrderBy/{atributoOrden}/{direccion}")
    public List<AlumnoList> getAlumnosByEdadOrderBy(@PathVariable("edad") Integer edad,
                                                    @PathVariable("atributoOrden") String atributoOrden,
                                                    @PathVariable("direccion") String direccion) {
        return alumnoService.findByEdad(edad, Sort.by(Direction.fromString(direccion), atributoOrden));
    }

}
