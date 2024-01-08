package edu.alumno.ivan.api_rest_mysql_futbol.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.alumno.ivan.api_rest_mysql_futbol.security.entity.UsuarioDb;
import edu.alumno.ivan.api_rest_mysql_futbol.security.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<UsuarioDb> getByNickname(String nickname){
        return usuarioRepository.findByNickname(nickname);
    }

    public boolean existsByNickname(String nickname){
        return usuarioRepository.existsByNickname(nickname);

    }
    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public void save(UsuarioDb usuario){
        usuarioRepository.save(usuario);
    }


}
