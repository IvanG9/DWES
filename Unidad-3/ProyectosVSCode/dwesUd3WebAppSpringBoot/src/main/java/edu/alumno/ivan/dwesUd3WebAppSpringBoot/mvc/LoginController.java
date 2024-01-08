package edu.alumno.ivan.dwesUd3WebAppSpringBoot.mvc;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Pagina;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Usuario;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.I18nService;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.LogErrorService;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.LoginService;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.PaginaService;

@Controller
@SessionAttributes({"loginNickName", "loginName", "usuario"})
public class LoginController {
	@Autowired LoginService loginService;
	@Autowired LogErrorService logErrorService;
	@Autowired PaginaService paginaServ;
	@Autowired I18nService i18nService;
	
	@RequestMapping(value={"/","login"},method = RequestMethod.GET)
	public String mostrarLogin(HttpServletRequest request, HttpServletResponse response, Locale locale, ModelMap model) {
		i18nService.configuraIdiomaPeticion(request, response, locale);
		
		model.put("pagina", new Pagina("Home", "login", i18nService.getIdioma()));
		model.addAttribute("usuario", new Usuario());
		model.put("loginNickName", "Desconocido");
		model.put("loginName", "Usuario desconocido");
		return "login";
	}
	
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String procesaLogin(ModelMap model, @Valid Usuario usuario,BindingResult validacion) {
		if(!loginService.usuarioValido(usuario)) {
			model.put("pagina", paginaServ.getPagina());
			model.put("errores", "Usuario '"+usuario.getNickname()+"' o contraseña incorrecta");
			logErrorService.addLogError("Login Incorrecto", "Login incorrecto de '"+usuario.getNickname()+"'");
			return "login";
		}
		paginaServ.setPagina(new Pagina("Bienvenida", "login"));
		model.put("pagina", paginaServ.getPagina());
		model.put("usuario", loginService.encontrarUsuarioPorNickName(usuario.getNickname()));
		model.put("loginNickName", usuario.getNickname());
		model.put("loginName", usuario.getNombre());
		return "bienvenida";
	}
}
