package edu.alumno.ivan.api_rest_mysql_futbol.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EntrenadorEdit;
import edu.alumno.ivan.api_rest_mysql_futbol.srv.EntrenadorService;

@RestController
@RequestMapping("/api/v1")
public class EntrenadorRestController {

    private EntrenadorService entrenadorService;

    @Autowired
    public EntrenadorRestController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    // Eliminar Entrenador

    /*@PreAuthorize("hashRole['ROLE_ADMIN']")*/
    @DeleteMapping("/entrenador/{id}")
    public void deleteEntrenador(@PathVariable("id") Long id) {
        entrenadorService.deleteById(id);
    }

    // Crear entrenador
    /*@PreAuthorize("hashRole['ROLE_ADMIN']")*/
    @PostMapping("/nuevoEntrenador")
    public EntrenadorEdit addEntrenador(@RequestBody EntrenadorEdit entrenadorEdit) {
        return entrenadorService.save(entrenadorEdit);
    }

    // Actualizar Entrenador
    /*@PreAuthorize("hashRole['ROLE_ADMIN']")*/
    @PutMapping("/entrenadorMod")
    public Optional<EntrenadorEdit> updateEntrenadorEdit(@Valid @RequestBody EntrenadorEdit entrenadorEdit)
            throws RuntimeException {

        return entrenadorService.update(entrenadorEdit);

    }

}
