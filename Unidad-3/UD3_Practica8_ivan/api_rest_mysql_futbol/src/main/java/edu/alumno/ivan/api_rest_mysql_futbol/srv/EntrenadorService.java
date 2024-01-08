package edu.alumno.ivan.api_rest_mysql_futbol.srv;

import java.util.Optional;

import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EntrenadorEdit;

public interface EntrenadorService {
    
    public void deleteById(Long id);
    public EntrenadorEdit save(EntrenadorEdit entrenadorEdit);
    public Optional<EntrenadorEdit> update(EntrenadorEdit entrenadorEdit);

}
