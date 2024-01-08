package edu.alumno.ivan.dwesUd3WebAppSpringBoot.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.LogError;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Pagina;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.I18nService;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.LogErrorService;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.PaginaService;

@Controller
@SessionAttributes({"loginNickName", "loginName", "usuario"})
public class LogErrorController {
	Pagina paginaActual = new Pagina("Errores", "list-error");
	@Autowired LogErrorService logErrorService;
	@Autowired PaginaService paginaServ;
	@Autowired I18nService i18nService;
	
	@RequestMapping(value="list-logerror",method = RequestMethod.GET)
	public String listarErrores(ModelMap model) {
		paginaActual.setIdioma(i18nService.getIdioma());
		paginaServ.setPagina(paginaActual);
		model.addAttribute("pagina", paginaServ.getPagina());
		model.addAttribute("errores", logErrorService.listaErrores());
		return "list-error";
	}

	@RequestMapping(value="del-error",method = RequestMethod.GET)
	public String eliminarError(@RequestParam String id ,ModelMap model) {
		int idEnv;
		idEnv = Integer.parseInt(id);
		LogError errorBorrar = logErrorService.encontrarLogErrorPorId(idEnv);
		logErrorService.delLogError(errorBorrar);
		model.clear();
		return "redirect:list-logerror";
	}
}
