package edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv;

import java.util.ArrayList;







import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.dto.AlumnoEdit;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.dto.AlumnoInfo;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.dto.AlumnoList;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.dto.DocAlumnoEdit;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.dto.DocAlumnoList;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.order.ComparadorAlumnoCicloNombre;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.order.ComparadorAlumnoCursoNombre;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.order.ComparadorAlumnoDni;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.order.ComparadorAlumnoEdadNombre;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Alumno;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.DocAlumno;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.FiltroAvanzadoAlumno;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.NuevoAlumnoModulo;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.excepciones.AlumnoDuplicadoException;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.mapper.AlumnoMapper;

@Service
public class AlumnoService {
	private static ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	@Autowired FileService fileServicio;
	@Autowired I18nService i18nService;
	
	static {
		ArrayList<Integer> listaMatriculadoEn1 = new ArrayList<Integer>();
		ArrayList<Integer> listaMatriculadoEn2 = new ArrayList<Integer>();
		ArrayList<Integer> listaMatriculadoEn3 = new ArrayList<Integer>();
		ArrayList<Integer> listaMatriculadoEn4 = new ArrayList<Integer>();
		listaMatriculadoEn1.add(1);
		listaMatriculadoEn2.add(2);
		listaMatriculadoEn3.add(1);
		listaMatriculadoEn3.add(2);
		listaMatriculadoEn4.add(2);
		alumnos.add(new Alumno("Jose", "12345678T", 20, "DAW", 2, listaMatriculadoEn1));
		alumnos.add(new Alumno("Pedro", "12345677P", 19, "DAM", 1, listaMatriculadoEn2));
		alumnos.add(new Alumno("Juan", "12345667U", 18, "DAM", 1, listaMatriculadoEn3));
		alumnos.add(new Alumno("Maria", "12345567L", 21, "DAM", 2, listaMatriculadoEn4));
	}
	
	//LISTAR
	
	public List<AlumnoList> listaAlumnos(){
		return AlumnoMapper.INSTANCE.alumnosToAlumnosList(alumnos);
	}
	
	public List<AlumnoList> listaAlumnos(String criterioOrdenacion) {
		if(criterioOrdenacion.equals("nombre")) {
			Collections.sort(alumnos);
			return AlumnoMapper.INSTANCE.alumnosToAlumnosList(alumnos);
		}
		if(criterioOrdenacion.equals("dni")) {
			Collections.sort(alumnos, new ComparadorAlumnoDni());
			return AlumnoMapper.INSTANCE.alumnosToAlumnosList(alumnos);
		}
		if(criterioOrdenacion.equals("edadNombre")) {
			Collections.sort(alumnos, new ComparadorAlumnoEdadNombre());
			return AlumnoMapper.INSTANCE.alumnosToAlumnosList(alumnos);
		}
		if(criterioOrdenacion.equals("cicloNombre")) {
			Collections.sort(alumnos, new ComparadorAlumnoCicloNombre());
			return AlumnoMapper.INSTANCE.alumnosToAlumnosList(alumnos);
		}
		if(criterioOrdenacion.equals("cursoNombre")) {
			Collections.sort(alumnos, new ComparadorAlumnoCursoNombre());
			return AlumnoMapper.INSTANCE.alumnosToAlumnosList(alumnos);
		}
		return AlumnoMapper.INSTANCE.alumnosToAlumnosList(alumnos);
	}
	
	////
	
	//ENCONTRAR
	
	public Alumno encontrarAlumnoPorDni(String dni){
		Optional<Alumno> alumnoDuplicado = null;
		
		alumnoDuplicado = alumnos.stream().filter(a->a.getDni().equals(dni)).findFirst();
		if (alumnoDuplicado.isPresent()) {
			return alumnoDuplicado.get();
		} else {
			return null;
		}
	}
	
	public AlumnoInfo encontrarAlumnoInfoPorDni(String dni){
		Optional<Alumno> alumnoDuplicado = null;
		
		alumnoDuplicado = alumnos.stream().filter(a->a.getDni().equals(dni)).findFirst();
		if (alumnoDuplicado.isPresent()) {
			return AlumnoMapper.INSTANCE.alumnoToAlumnoInfo(alumnoDuplicado.get());
		} else {
			return null;
		}
	}
	
	public Optional<DocAlumno> encontrarAlumnoPorDni_IdDoc(String dni, Integer idDoc) {
		Alumno alumnoEnc = encontrarAlumnoPorDni(dni);
		ArrayList<DocAlumno> docsAlumnoEnc = alumnoEnc.getDocsAlumno();
		return docsAlumnoEnc.stream().filter(d -> d.getId() == idDoc).findFirst();		
	}
	
	////
	
	//AÑADIR
	
	public void addAlumno(AlumnoEdit alumnoEdit) throws AlumnoDuplicadoException{
		if(existeAlumno(alumnoEdit.getDni())) {
			throw new AlumnoDuplicadoException(encontrarAlumnoPorDni(alumnoEdit.getDni()), alumnoEdit);
		} else {
			alumnos.add(AlumnoMapper.INSTANCE.alumnoEditToAlumno(alumnoEdit));
		}
	}
	
	////
	
	//ELIMINAR
	
	public void delAlumno(Alumno alumno) {
		alumnos.remove(alumno);
	}
	
	////
	
	//COMPROBAR SI EXISTE ALUMNO
	
	public boolean existeAlumno(String dni) {
		Optional<String> dniAlumno = alumnos.stream().map(a->a.getDni()).filter(id->id.equals(dni)).findFirst();
		if (dniAlumno.isPresent()) {
			return true;
		}
		return false;
	}
	
	////
	
	//MODIFICAR ALUMNO
	
	public void modificaAlumno (AlumnoEdit alumnoEditModificado, String usuarioModificacion) throws Exception {
		if (alumnoEditModificado == null || usuarioModificacion.equals("")) {
			throw new Exception("No se encuentran los datos del alumno o del usuaio de modificacion");
		} else {
			Alumno alumno = encontrarAlumnoPorDni(alumnoEditModificado.getDni());
			AlumnoEdit alumnoEditActual = AlumnoMapper.INSTANCE.alumnoToAlumnoEdit(alumno);
			if (alumnoEditActual.sePuedeModificarUtilizando(alumnoEditModificado)) {
				alumnoEditModificado.setUser(usuarioModificacion);
				alumnoEditModificado.setTs(new Date());
				AlumnoMapper.INSTANCE.updateAlumnoFromAlumnoEdit(alumnoEditModificado, alumno);
			} else {
				throw new Exception(alumnoEditActual.mensajeNoSePuedeModificar());
			}
		}
	}
	
	////	
	
	//LISTA CREACION ALUMNOS
	
	public List<String> listaInteresadoEn() {
		ArrayList<String> listaInteresadoEn = new ArrayList<String>();
		listaInteresadoEn.add("Backend");
		listaInteresadoEn.add("Frontend");
		return listaInteresadoEn;
	}
	
	public List<String> listaHorarios() {
		ArrayList<String> listaHorarios = new ArrayList<String>();
		listaHorarios.add("Manyana");
		listaHorarios.add("Tarde");
		return listaHorarios;
	}
	
	public HashMap <String, String> listaPaises() {
		HashMap<String,String> listaPaises = new HashMap<String,String>();
		listaPaises.put("ES", "España");
		return listaPaises;
	}
	
	////
	
	//DOCUMENTOS
	
	public List<String> opcionesTipoDoc() {
		List<String> opcionesTipoDoc = new ArrayList<String>();
		opcionesTipoDoc.add("Certificado");
		opcionesTipoDoc.add("Justificante");
		opcionesTipoDoc.add("Solicitud");
		return opcionesTipoDoc;
	}
	
	public int siguienteDoc(String dni) {
		Alumno alumnoEncontrado = encontrarAlumnoPorDni(dni);
		if(alumnoEncontrado.getDocsAlumno() == null){
			return 1;
		} else {
			return alumnoEncontrado.getDocsAlumno().size()+1;
		}
	}
	
	public void addDocAlumno (Alumno alumno, DocAlumno docAlumno) {
		ArrayList<DocAlumno> nuevaLista = alumno.getDocsAlumno();
		if (nuevaLista == null) {
			nuevaLista = new ArrayList<DocAlumno>();
		}
		nuevaLista.add(docAlumno);
		alumno.setDocsAlumno(nuevaLista);
	}
	
	public List<DocAlumnoList> encontrarDocsAlumnoListPorDni(String dni) {
		ArrayList<DocAlumnoList> resultado = new ArrayList<DocAlumnoList>();
		Alumno alumno = encontrarAlumnoPorDni(dni);
		if (alumno == null) {
			return resultado;
		} else {
			if (alumno.getDocsAlumno() == null)
				return resultado;
			else {
				return AlumnoMapper.INSTANCE.docsAlumnoToDocsAlumnoList(alumno.getDocsAlumno());
			}
		}
	}
	
	public void addDocAlumnoEdit(DocAlumnoEdit docAlumnoEdit, String usuarioModificacion) throws Exception {
		if (docAlumnoEdit == null) {
			throw new Exception("No se ha podido actualizar el documento porque no han llegado los datos modificados");
		} else {
			String dni = (String) docAlumnoEdit.getDni();
			Alumno alumno = encontrarAlumnoPorDni(dni);
			if (alumno == null) throw new Exception("Alumno desconocido");
			if (usuarioModificacion == null) throw new Exception("Para añadir documentación debe estar logeado");
			
			String extension = fileServicio.getExtensionMultipartfile(docAlumnoEdit.getFichero());
			String nombreFicheroAGuardar = String.format("%s_idDoc_%s.%s", dni, docAlumnoEdit.getId(), extension);
			
			ArrayList<String> listaErroresAlGuardar = fileServicio.guardaDocumentacionAlumno(docAlumnoEdit.getFichero(), nombreFicheroAGuardar);
			if (!listaErroresAlGuardar.isEmpty()) {
				String mensajeCompleto = "";
				for (String mensaje : listaErroresAlGuardar) 
					mensajeCompleto += i18nService.getTraduccion(mensaje) + "<br>";
				throw new Exception(mensajeCompleto);
			}
			docAlumnoEdit.setTipoFichero(extension);
			docAlumnoEdit.setContentTypeFichero(docAlumnoEdit.getFichero().getContentType());
			
			DocAlumno docAlumno = AlumnoMapper.INSTANCE.docAlumnoEditToDocAlumno(docAlumnoEdit);
			if (alumno.getDocsAlumno() != null) 
				alumno.getDocsAlumno().add(docAlumno);
			else {
				alumno.setDocsAlumno(new ArrayList<DocAlumno>(List.of(docAlumno)));
			}
			
			modificaAlumno(AlumnoMapper.INSTANCE.alumnoToAlumnoEdit(alumno), usuarioModificacion);
		}
	}
	
	////
	
	//FILTRO	

	public List<String> cicloListaAlumnos() {
		Set<String> listaSinRepeticiones=alumnos.stream().filter(a->a.getCiclo()!=null).map(a->a.getCiclo()).collect(Collectors.toSet());
		return listaSinRepeticiones.stream().sorted().collect(Collectors.toList());
	}
	
	public List<String> dniListaAlumnos() {
		Set<String> listaSinRepeticiones=alumnos.stream().filter(a->a.getDni()!=null).map(a->a.getDni()).collect(Collectors.toSet());
		return listaSinRepeticiones.stream().sorted().collect(Collectors.toList());
	}
	
	public List<String> horarioListaAlumnos() {
		Set<String> listaSinRepeticiones=alumnos.stream().filter(a->a.getHorario()!=null).map(a->a.getHorario()).collect(Collectors.toSet());
		return listaSinRepeticiones.stream().sorted().collect(Collectors.toList());
	}
	
	public List<Alumno> filtroAvanzadoAlumnos(FiltroAvanzadoAlumno filtroAvanzadoAlumno) {
		List<Alumno> lista = alumnos;
		try {
			if (!"-".equals(filtroAvanzadoAlumno.getDni())) {
				lista=lista.stream().filter(a->a.getDni()!=null && a.getDni().equals(filtroAvanzadoAlumno.getDni())).collect(Collectors.toList());
			}
			if (!"-".equals(filtroAvanzadoAlumno.getCiclo())) {
				lista=lista.stream().filter(a->a.getCiclo()!=null && a.getCiclo().equals(filtroAvanzadoAlumno.getCiclo())).collect(Collectors.toList());
			}
			if (!"-".equals(filtroAvanzadoAlumno.getHorario())) {
				lista=lista.stream().filter(a->a.getHorario()!=null && a.getHorario().equals(filtroAvanzadoAlumno.getHorario())).collect(Collectors.toList());
			}
		} catch (Exception e) {
			lista = new ArrayList<Alumno>();
		}
		
		if (lista == null) return new ArrayList<Alumno>();
		return lista;
	}
	
	////
	
	//MATRICULAS
	
	public List<Alumno> alumnoMatriculadoEn(int id) {
		List<Alumno> matriculados = new ArrayList<Alumno>();
		for(int i = 0; i < alumnos.size(); i++) {
			for(int j = 0; j < alumnos.get(i).getMatriculadoEn().size(); j++) {
				if (alumnos.get(i).getMatriculadoEn().get(j) == id) {
					matriculados.add(alumnos.get(i));
					break;
				}
			}
		}
		return matriculados;
	}
	
	public HashMap<String, String> alumnoNoMatriculadoEn(int id) {
		HashMap<String, String> noMatriculados = new HashMap<String, String>();
		boolean esta;
		for(int i = 0; i < alumnos.size(); i++) {
			esta = false;
			for(int j = 0; j < alumnos.get(i).getMatriculadoEn().size(); j++) {
				if (alumnos.get(i).getMatriculadoEn().get(j) == id) {
					esta = true;
					break;
				}
			}
			if (!esta) {
				noMatriculados.put(alumnos.get(i).getDni(), alumnos.get(i).getNombre());
			}
		}
		return noMatriculados;
	}
	
	public void eliminarMatricula(String dni, int id) {
		Alumno alumnoEnc = encontrarAlumnoPorDni(dni);
		ArrayList<Integer> nuevaLista = new ArrayList<Integer>();
		for (int i = 0; i < alumnoEnc.getMatriculadoEn().size(); i++) {
			if (alumnoEnc.getMatriculadoEn().get(i) != id) {
				nuevaLista.add(alumnoEnc.getMatriculadoEn().get(i));
			}
		}
		alumnoEnc.setMatriculadoEn(nuevaLista);
	}
	
	
	public void addMatricula(NuevoAlumnoModulo nuevoAl) {
		if (encontrarAlumnoPorDni(nuevoAl.getDni()) != null) {
			Alumno alumno = encontrarAlumnoPorDni(nuevoAl.getDni());
			int id = Integer.parseInt(nuevoAl.getId());
			ArrayList<Integer> lista = alumno.getMatriculadoEn();
			lista.add(id);
			alumno.setMatriculadoEn(lista);
		}
	}
	
	////
}