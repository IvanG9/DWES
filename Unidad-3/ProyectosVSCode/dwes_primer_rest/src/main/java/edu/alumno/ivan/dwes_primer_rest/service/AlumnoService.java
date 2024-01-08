package edu.alumno.ivan.dwes_primer_rest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import edu.alumno.ivan.dwes_primer_rest.model.dto.AlumnoEdit;
import edu.alumno.ivan.dwes_primer_rest.model.dto.AlumnoInfo;
import edu.alumno.ivan.dwes_primer_rest.model.dto.AlumnoList;

public interface AlumnoService {

    public Optional<AlumnoEdit> getAlumnoEditByDni(String dni);
    public Optional<AlumnoInfo> getAlumnoInfoByDni(String dni);
    public AlumnoEdit save(AlumnoEdit alumnoEdit);
    public String deleteByDni(String dni);
    public Optional<AlumnoEdit> update(AlumnoEdit alumnoEdit);
    public List<AlumnoList> findAllAlumnoList();
    public List<AlumnoList> findAllAlumnoListDAW();
    public List<AlumnoList> findAllAlumnoListDAM();
    public List<AlumnoList> findAllAlumnosListCiclo(String ciclo);
    public List<AlumnoList> findAllAlumnosListCicloPais(String ciclo, String pais);
    //Metodos automaticos en Spring Data JPA
    public List<AlumnoList> findAlumnosListByDni(String dni);
    public List<AlumnoList> findAlumnosListByCiclo(String ciclo);
    public List<AlumnoList> findAlumnosListByHorario(String horario);
    public List<AlumnoList> findAlumnosListByEdad(Integer edad);
    //Ordenacion de resultados
    public List<AlumnoList> findAllAlumnosListCicloOrderByCurso(String ciclo);
    // Métodos automáticos en Spring Data JPA
    public List<AlumnoList> findByCicloOrderBy(String ciclo, Sort sort);
    public List<AlumnoList> findByEdadOrderBy(Integer edad, Sort sort);
    // Métodos automáticos con Ordenacion en Spring Data JPA
    public List<AlumnoList> findByCiclo(String ciclo, Sort sort);
    public List<AlumnoList> findByHorario(String horario, Sort sort);
    public List<AlumnoList> findByEdad(Integer edad, Sort sort);
}   
