package edu.alumno.ivan.dwesUd3WebAppSpringBoot.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.server.ResponseStatusException;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.dto.AlumnoEdit;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.dto.DocAlumnoEdit;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Alumno;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.DocAlumno;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.FiltroAvanzadoAlumno;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Pagina;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Usuario;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.AlumnoService;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.FileService;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.I18nService;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.ModuloService;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.PaginaService;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.excepciones.AlumnoDuplicadoException;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.mapper.AlumnoMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@SessionAttributes({"loginNickName", "loginName", "usuario"})
public class AlumnoController {
	Pagina paginaActual = new Pagina("Alumnos", "list-alumno");
	@Autowired AlumnoService alumnoService;
	@Autowired ModuloService moduloService;
	@Autowired PaginaService paginaServ;
	@Autowired FileService fileServicio;
	@Autowired I18nService i18nService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,true));
	}
	
	@RequestMapping(value="list-alumno",method = RequestMethod.GET)
	public String listarAlumnos(ModelMap model) {
		paginaActual.setIdioma(i18nService.getIdioma());
		paginaServ.setPagina(paginaActual);
		model.addAttribute("pagina", paginaServ.getPagina());
		model.addAttribute("alumnos", alumnoService.listaAlumnos());
		model.addAttribute("filtroAvanzadoAlumno", new FiltroAvanzadoAlumno());
		return "list-alumno";
	}
	
	@RequestMapping(value="add-alumno",method = RequestMethod.GET)
	public String mostrarAlumno(ModelMap model) {
		paginaServ.setPagina(paginaActual);
		model.addAttribute("pagina", paginaServ.getPagina());
		model.addAttribute("alumnoEdit", new AlumnoEdit());
		return "add-alumno";
	}
	
	@ModelAttribute("interesadoEnLista")
	public Object[] getinteresadoEnLista() {
		return alumnoService.listaInteresadoEn().toArray();
	}
	
	@ModelAttribute("horarioLista")
	public Object[] gethorarioLista() {
		return alumnoService.listaHorarios().toArray();
	}
	
	@ModelAttribute("paisLista")
	public HashMap<String,String> getpaisLista() {
		return alumnoService.listaPaises();
	}
	
	@ModelAttribute("moduloLista")
	public Object[] getmoduloLista() {
		return moduloService.listaModulos().toArray();
	}

	@RequestMapping(value="add-alumno",method = RequestMethod.POST)
	public String addAlumno(@Valid AlumnoEdit alumnoEdit, BindingResult validacion, ModelMap model) {
		paginaServ.setPagina(paginaActual);
		model.addAttribute("pagina", paginaServ.getPagina());
		if (validacion.hasErrors()) {
			return "add-alumno";
		}
		String errores = "";
		try {
			alumnoService.addAlumno(alumnoEdit);
			model.clear();
			return "redirect:list-alumno";
		} catch (AlumnoDuplicadoException e) {
			errores=e.toString();
			model.addAttribute("errores", errores);
			return "add-alumno";
		}
	}
	
	@RequestMapping(value="del-alumno",method = RequestMethod.GET)
	public String eliminarAlumno(@RequestParam String dni ,ModelMap model) {
		try {
			Alumno alumnoBorrar = alumnoService.encontrarAlumnoPorDni(dni);
			alumnoService.delAlumno(alumnoBorrar);
			model.clear();
			return "redirect:list-alumno";
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return "redirect:list-alumno";
		}
	}
	
	@RequestMapping(value="update-alumno", method = RequestMethod.GET)
	public String alumnoModificar(@RequestParam String dni, ModelMap model) {
		paginaServ.setPagina(paginaActual);
		model.addAttribute("pagina", paginaServ.getPagina());
		Alumno alumnoModificar = alumnoService.encontrarAlumnoPorDni(dni);
		model.addAttribute("alumnoEdit", AlumnoMapper.INSTANCE.alumnoToAlumnoEdit(alumnoModificar));
		return "update-alumno";
	}
	
	@RequestMapping(value="update-alumno", method = RequestMethod.POST)
	public String alumnoModificado(ModelMap model, @Valid AlumnoEdit alumnoEdit, BindingResult validacion) {
		if (validacion.hasErrors()) {
			paginaServ.setPagina(paginaActual);
			model.addAttribute("pagina", paginaServ.getPagina());
			return "update-alumno";
		}
		try {
			alumnoService.modificaAlumno(alumnoEdit, model.getAttribute("loginNickName").toString());
			model.clear();
			return "redirect:list-alumno";
		} catch (Exception e) {
			paginaServ.setPagina(paginaActual);
			model.addAttribute("pagina", paginaServ.getPagina());
			model.addAttribute("errores", e.getMessage());
			return "update-alumno";
		}
	}
	
	@RequestMapping(value="sort-alumno", method= RequestMethod.GET)
	public String alumnoOrdenado(@RequestParam String orden, ModelMap model) {
		paginaServ.setPagina(paginaActual);
		model.addAttribute("pagina", paginaServ.getPagina());
		model.addAttribute("alumnos", alumnoService.listaAlumnos(orden));
		model.addAttribute("filtroAvanzadoAlumno", new FiltroAvanzadoAlumno());
		return "list-alumno";
	}
	
	@ModelAttribute("opcionesTipoDoc")
	public Object[] getopcionesTipoDoc() {
		return alumnoService.opcionesTipoDoc().toArray();
	}
	
	@RequestMapping(value="docs-alumno", method= RequestMethod.GET)
	public String getDocsAlumno(ModelMap model, @RequestParam String dni) {
		paginaServ.setPagina(paginaActual);
		model.addAttribute("alumnoInfo", alumnoService.encontrarAlumnoInfoPorDni(dni));
		model.addAttribute("docAlumnoEdit", new DocAlumno(alumnoService.siguienteDoc(dni)));
		model.addAttribute("docsAlumnoList", alumnoService.encontrarDocsAlumnoListPorDni(dni));
		model.addAttribute("pagina", paginaServ.getPagina());
		return "docs-alumno";
	}
	
	@RequestMapping(value="add-docAlumno", method= RequestMethod.POST)
	public String addDocAlumno(ModelMap model, @Valid DocAlumnoEdit docAlumnoEdit, BindingResult validacion) {
		String dni = "";
		if (docAlumnoEdit.getDni() != null)
			dni = (String) docAlumnoEdit.getDni();
		paginaServ.setPagina(paginaActual);
		model.addAttribute("pagina", paginaServ.getPagina());
		if (validacion.hasErrors()) {
			model.addAttribute("alumnoInfo", alumnoService.encontrarAlumnoInfoPorDni(docAlumnoEdit.getDni()));
			model.addAttribute("docsAlumnoList", alumnoService.encontrarDocsAlumnoListPorDni(dni));
			return "docs-alumno";
		}
		
		Alumno alumno = alumnoService.encontrarAlumnoPorDni(dni);
		
		try {
			if (alumno == null) {
				throw new Exception("Alumno desconocido");
			}
			if (model.getAttribute("loginNickName") == null) {
				throw new Exception("Para añadir documentación debe estar logeado");
			}			
			Usuario usuarioActivo = (Usuario) model.getAttribute("usuario");
			alumnoService.addDocAlumnoEdit(docAlumnoEdit, usuarioActivo.getNickname());
			model.addAttribute("alumnoInfo", alumnoService.encontrarAlumnoInfoPorDni(dni));
			model.addAttribute("docAlumnoEdit", new DocAlumnoEdit(alumnoService.siguienteDoc(dni)));
			model.addAttribute("docsAlumnoList", alumnoService.encontrarDocsAlumnoListPorDni(dni));
			return "docs-alumno";
		} catch (Exception e) {
			model.addAttribute(alumnoService.encontrarAlumnoPorDni(dni));
			model.addAttribute("docsAlumnoList", alumnoService.encontrarDocsAlumnoListPorDni(dni));
			model.addAttribute("errores", e.getMessage());
			return "docs-alumno";
		}
	}
	
	@RequestMapping(value = "/descargar-docAlumno/{dni}/{idDoc}", method = RequestMethod.GET)
	public @ResponseBody void descargarDocAlumno(HttpServletResponse response, @PathVariable("dni") String dni, @PathVariable("idDoc") Integer idDoc) throws IOException {
		try {
			Optional<DocAlumno> docAlumno = alumnoService.encontrarAlumnoPorDni_IdDoc(dni, idDoc);
			if (docAlumno.isPresent()) {
				String nombreFichero = dni +"_idDoc_"+idDoc+"."+docAlumno.get().getTipoFichero();
				FileSystemResource resource = fileServicio.getDocumentoAlumno(nombreFichero);
				if (!resource.exists()) {
					throw new IOException("El documento con el dni '"+dni+"' y el id '"+idDoc+"' no existe.");
				}
				File fichero = resource.getFile();
				
				response.setContentType(docAlumno.get().getContentTypeFichero());
				response.setHeader("Content-Disposition", "attachment; filename="+fichero.length());
				response.setHeader("Content-Length", String.valueOf(fichero.length()));
				InputStream in = new FileInputStream(fichero);
				FileCopyUtils.copy(in, response.getOutputStream());
				
			} else {
				throw new IOException("El documento con el dni '"+dni+"' y el id '"+idDoc+"' no existe.");
			}
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@ModelAttribute("cicloListaAlumnos")
	public List<String> getCicloListaAlumnos() {
		return alumnoService.cicloListaAlumnos();
	}
	
	@ModelAttribute("dniListaAlumnos")
	public List<String> getDniListaAlumnos() {
		return alumnoService.dniListaAlumnos();
	}
	
	@ModelAttribute("horarioListaAlumnos")
	public List<String> getHorarioListaAlumnos() {
		return alumnoService.horarioListaAlumnos();
	}
	
	@RequestMapping(value="filtro-avanzado-alumno", method= RequestMethod.POST)
	public String filtroAvanzadoAlumno(ModelMap model, @Valid FiltroAvanzadoAlumno filtroAvanzadoAlumno, BindingResult validacion) {
		paginaServ.setPagina(paginaActual);
		model.addAttribute("pagina", paginaServ.getPagina());
		model.put("filtroAvanzadoAlumno", filtroAvanzadoAlumno);
		if (validacion.hasErrors()) {
			model.put("alumnos", alumnoService.listaAlumnos());
		} else {
			model.put("alumnos", alumnoService.filtroAvanzadoAlumnos(filtroAvanzadoAlumno));
		}
		return "list-alumno";
	}
	
}
