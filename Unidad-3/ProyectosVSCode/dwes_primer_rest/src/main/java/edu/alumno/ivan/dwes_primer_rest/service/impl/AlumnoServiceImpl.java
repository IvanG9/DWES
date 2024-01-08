package edu.alumno.ivan.dwes_primer_rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import edu.alumno.ivan.dwes_primer_rest.model.db.AlumnoDb;
import edu.alumno.ivan.dwes_primer_rest.model.dto.AlumnoEdit;
import edu.alumno.ivan.dwes_primer_rest.model.dto.AlumnoInfo;
import edu.alumno.ivan.dwes_primer_rest.model.dto.AlumnoList;
import edu.alumno.ivan.dwes_primer_rest.repository.AlumnoRepository;
import edu.alumno.ivan.dwes_primer_rest.service.AlumnoService;
import edu.alumno.ivan.dwes_primer_rest.service.mapper.AlumnoMapper;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public Optional<AlumnoEdit> getAlumnoEditByDni(String dni) {
        Optional<AlumnoDb> alumnoDb = alumnoRepository.findById(dni);
        if (alumnoDb.isPresent())
            return Optional.of(AlumnoMapper.INSTANCE.alumnoDbToAlumnoEdit(alumnoDb.get()));
        else
            return Optional.empty();
    }

    @Override
    public Optional<AlumnoInfo> getAlumnoInfoByDni(String dni) {
        Optional<AlumnoDb> alumnoDb = alumnoRepository.findById(dni);
        if (alumnoDb.isPresent()) {
            return Optional.of(AlumnoMapper.INSTANCE.alumnoDbToAlumnoInfo(alumnoDb.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public AlumnoEdit save(AlumnoEdit alumnoEdit) {
        AlumnoDb alumnoDb = alumnoRepository.save(AlumnoMapper.INSTANCE.alumnoEditToAlumnoDb(alumnoEdit));
        return AlumnoMapper.INSTANCE.alumnoDbToAlumnoEdit(alumnoDb);
    }

    @Override
    public String deleteByDni(String id) {
        
        alumnoRepository.deleteById(id);
        return "Eliminado el Equipo "+ id+ " correctamente";
    
    }

    @Override
    public Optional<AlumnoEdit> update(AlumnoEdit alumnoEdit) {
        Optional<AlumnoEdit> alumnoEditExistente = getAlumnoEditByDni(alumnoEdit.getDni());
        if (alumnoEditExistente.isPresent()) {
            deleteByDni(alumnoEdit.getDni());
            save(alumnoEdit);
            return getAlumnoEditByDni(alumnoEdit.getDni());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<AlumnoList> findAllAlumnoList() {
        List<AlumnoDb> alumnosDb = alumnoRepository.findAll();
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList(alumnosDb);
    }

    @Override
    public List<AlumnoList> findAllAlumnoListDAW() {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findAllAlumnoDbDAW());
    }

    @Override
    public List<AlumnoList> findAllAlumnoListDAM() {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findAllAlumnoDbDAM());

    }

    @Override
    public List<AlumnoList> findAllAlumnosListCiclo(String ciclo) {
        return AlumnoMapper.INSTANCE
                .alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findAllAlumnoDbCiclo(ciclo));
    }

    @Override
    public List<AlumnoList> findAllAlumnosListCicloPais(String ciclo, String pais) {
        return AlumnoMapper.INSTANCE
                .alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findAllAlumnoDbCicloPais(ciclo, pais));
    }

    // Metodos automaticos en Spring Data JPA
    @Override
    public List<AlumnoList> findAlumnosListByDni(String dni) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findByDni(dni));
    }

    @Override
    public List<AlumnoList> findAlumnosListByCiclo(String ciclo) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findByCiclo(ciclo));
    }

    @Override
    public List<AlumnoList> findAlumnosListByHorario(String horario) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findByHorario(horario));
    }

    @Override
    public List<AlumnoList> findAlumnosListByEdad(Integer edad) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findByEdad(edad));
    }

    // Ordenacion de resultados

    @Override
    public List<AlumnoList> findAllAlumnosListCicloOrderByCurso(String ciclo) {
        return AlumnoMapper.INSTANCE
                .alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findAllAlumnoDbCicloOrderByCurso(ciclo));
    }

    // Consultas con varias ordenaciones en Spring Data JPA

    @Override
    public List<AlumnoList> findByCicloOrderBy(String ciclo, Sort sort) {
        return AlumnoMapper.INSTANCE
                .alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findByCicloOrderBy(ciclo, sort));
    }

    @Override
    public List<AlumnoList> findByEdadOrderBy(Integer edad, Sort sort) {
        return AlumnoMapper.INSTANCE
                .alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findByEdadOrderBy(edad, sort));
    }

    // Métodos automáticos con Ordenacion en Spring Data JPA

    @Override
    public List<AlumnoList> findByCiclo(String ciclo, Sort sort) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findByCiclo(ciclo, sort));
    }

    @Override
    public List<AlumnoList> findByHorario(String horario, Sort sort) {
        return AlumnoMapper.INSTANCE
                .alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findByHorario(horario, sort));
    }

    @Override
    public List<AlumnoList> findByEdad(Integer edad, Sort sort) {
        return AlumnoMapper.INSTANCE.alumnosToAlumnosList((List<AlumnoDb>) alumnoRepository.findByEdad(edad, sort));
    }
}
