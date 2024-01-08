package edu.alumno.ivan.api_rest_mysql_futbol.srv.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.alumno.ivan.api_rest_mysql_futbol.model.db.EntrenadorDb;
import edu.alumno.ivan.api_rest_mysql_futbol.model.dto.EntrenadorEdit;
import edu.alumno.ivan.api_rest_mysql_futbol.repository.EntrenadorRepository;
import edu.alumno.ivan.api_rest_mysql_futbol.srv.EntrenadorService;
import edu.alumno.ivan.api_rest_mysql_futbol.srv.mapper.EntrenadorMapper;

@Service
public class EntrenadorServiceImpl implements EntrenadorService {

    private final EntrenadorRepository entrenadorRepository;

    public EntrenadorServiceImpl(EntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }

    @Override
    public void deleteById(Long id) {
        entrenadorRepository.deleteById(id);
    }

    @Override
    public EntrenadorEdit save(EntrenadorEdit entrenadorEdit) {
        EntrenadorDb entrenadorDb = entrenadorRepository
                .save(EntrenadorMapper.INSTANCE.entrenadorEditToEntrenadorDb(entrenadorEdit));
        return EntrenadorMapper.INSTANCE.entrenadorDbToEntrenadorEdit(entrenadorDb);
    }

    @Override
    public Optional<EntrenadorEdit> update(EntrenadorEdit entrenadorEdit) {

        Optional<EntrenadorEdit> entrenadorEditExistente = getEntrenadorEditById(entrenadorEdit.getId());
        if (entrenadorEditExistente.isPresent()) {
            entrenadorRepository.save(EntrenadorMapper.INSTANCE.entrenadorEditToEntrenadorDb(entrenadorEdit));
            return getEntrenadorEditById(entrenadorEdit.getId());
        } else {
            return Optional.empty();
        }
    }

    private Optional<EntrenadorEdit> getEntrenadorEditById(Long id) {

        Optional<EntrenadorDb> entrenadorDb = entrenadorRepository.findById(id);

        if (entrenadorDb.isPresent()) {
            return Optional.of(EntrenadorMapper.INSTANCE.entrenadorDbToEntrenadorEdit(entrenadorDb.get()));
        }

        return Optional.empty();
    }

}
