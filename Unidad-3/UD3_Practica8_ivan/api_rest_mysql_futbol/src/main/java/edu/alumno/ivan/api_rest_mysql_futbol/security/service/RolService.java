package edu.alumno.ivan.api_rest_mysql_futbol.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.alumno.ivan.api_rest_mysql_futbol.security.entity.RolDb;
import edu.alumno.ivan.api_rest_mysql_futbol.security.enums.RolNombre;
import edu.alumno.ivan.api_rest_mysql_futbol.security.repository.RolRepository;

@Service
@Transactional
public class RolService {
    
    @Autowired
    RolRepository RolRepository;

    public Optional<RolDb> getByRolNombre(RolNombre rolNombre){
        return RolRepository.findByNombre(rolNombre);
    }

    public void save (RolDb rol){
        RolRepository.save(rol);
    }


}
