package edu.alumno.ivan.dwesUd3WebAppSpringBoot.mvc;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.FiltroModulo;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Modulo;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.NuevoAlumnoModulo;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Pagina;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.AlumnoService;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.I18nService;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.ModuloService;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.PaginaService;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.excepciones.ModuloDuplicadoException;

@Controller
@SessionAttributes({"loginNickName", "loginName", "usuario"})
public class ModuloController {
	Pagina paginaActual = new Pagina("Modulos", "list-modulo");
	@Autowired ModuloService moduloService;
	@Autowired PaginaService paginaServ;
	@Autowired AlumnoService alumnoService;
	@Autowired I18nService i18nService;
	
	@RequestMapping(value="list-modulo",method = RequestMethod.GET)
	public String listarModulos(ModelMap model) {
		paginaActual.setIdioma(i18nService.getIdioma());
		paginaServ.setPagina(paginaActual);
		model.addAttribute("pagina", paginaServ.getPagina());
		model.addAttribute("modulos", moduloService.listaModulos());
		model.addAttribute("modulo", new Modulo(0, "Nuevo Modulo", 8, "DAW"));
		model.addAttribute("filtroModulo", new FiltroModulo());
		return "list-modulo";
	}

	@RequestMapping(value="add-modulo",method = RequestMethod.POST)
	public String addModulo(Modulo modulo, ModelMap model) {
		String errores = "";
		paginaServ.setPagina(paginaActual);
		model.addAttribute("pagina", paginaServ.getPagina());
		try {
			moduloService.addModulo(modulo);
			model.clear();
			return "redirect:list-modulo";
		} catch (ModuloDuplicadoException e) {
			errores=e.toString();
			model.addAttribute("errores", errores);
			model.addAttribute("modulos", moduloService.listaModulos());
			model.addAttribute("modulo", new Modulo(0, "Nuevo Modulo", 8, "DAW"));
			return "list-modulo";
		}
	}
	
	@RequestMapping(value="del-modulo",method = RequestMethod.GET)
	public String eliminarModulo(@RequestParam String id ,ModelMap model) {
		int idEnv;
		idEnv = Integer.parseInt(id);
		Modulo moduloBorrar = moduloService.encontrarModuloPorId(idEnv);
		moduloService.delModulo(moduloBorrar);
		model.clear();
		return "redirect:list-modulo";
	}
	
	@RequestMapping(value="sort-modulo", method= RequestMethod.GET)
	public String moduloOrdenado(@RequestParam String orden, ModelMap model) {
		paginaServ.setPagina(paginaActual);
		model.addAttribute("pagina", paginaServ.getPagina());
		model.addAttribute("modulos", moduloService.listaModulos(orden));
		model.addAttribute("modulo", new Modulo(0, "Nuevo Modulo", 8, "DAW"));
		model.addAttribute("filtroModulo", new FiltroModulo());
		return "list-modulo";
	}
	
	@ModelAttribute("listaFiltro")
	public Object[] getmoduloLista() {
		return moduloService.listaFiltro().toArray();
	}
	
	@RequestMapping(value="filt-modulo", method= RequestMethod.POST)
	public String moduloFiltrado(ModelMap model, @Valid FiltroModulo filtroModulo, BindingResult validacion) {
		paginaServ.setPagina(paginaActual);
		model.addAttribute("pagina", paginaServ.getPagina());
		model.put("filtroModulo", filtroModulo);
		model.addAttribute("modulo", new Modulo(0, "Nuevo Modulo", 8, "DAW"));
		if (validacion.hasErrors()) {
			model.put("modulos", moduloService.listaModulos());
		} else {
			model.put("modulos", moduloService.filtroModulos(filtroModulo));
			
		}
		return "list-modulo";
	}
	
	@RequestMapping(value="matriculados-modulo", method= RequestMethod.GET)
	public String matriculaModulo(@RequestParam String id, ModelMap model) {
		paginaServ.setPagina(paginaActual);
		model.addAttribute("pagina", paginaServ.getPagina());
		int idEnv = Integer.parseInt(id);
		model.addAttribute("modulo", moduloService.encontrarModuloPorId(idEnv));
		model.addAttribute("alumnosM", alumnoService.alumnoMatriculadoEn(idEnv));
		model.addAttribute("alumnosNM", alumnoService.alumnoNoMatriculadoEn(idEnv));
		model.addAttribute("nuevoAlumnoModulo", new NuevoAlumnoModulo());
		return "matriculado-alumno";
	}
	
	@RequestMapping(value="del-alumnoM", method= RequestMethod.GET)
	public String eliminarMatricula(@RequestParam String dni, @RequestParam String id, ModelMap model) {
		paginaServ.setPagina(paginaActual);
		model.addAttribute("pagina", paginaServ.getPagina());
		int idEnv = Integer.parseInt(id);
		alumnoService.eliminarMatricula(dni, idEnv);
		model.clear();
		return matriculaModulo(id, model);
	}
	
	@RequestMapping(value="add-alumnoNM", method= RequestMethod.POST)
	public String addAlumnoNM(ModelMap model, @Valid NuevoAlumnoModulo nuevoAlumnoModulo, BindingResult validacion) {
		paginaServ.setPagina(paginaActual);
		model.addAttribute("pagina", paginaServ.getPagina());
		model.clear();
		if(!validacion.hasErrors()) {
			alumnoService.addMatricula(nuevoAlumnoModulo);
		}
		return matriculaModulo(nuevoAlumnoModulo.getId(), model);
	}
}
