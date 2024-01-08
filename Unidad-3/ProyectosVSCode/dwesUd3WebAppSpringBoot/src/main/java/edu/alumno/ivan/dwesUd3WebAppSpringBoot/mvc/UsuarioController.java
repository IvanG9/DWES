package edu.alumno.ivan.dwesUd3WebAppSpringBoot.mvc;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.ImagenUsuario;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.ram.Usuario;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.FileService;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.I18nService;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv.LoginService;

@Controller
@SessionAttributes({"loginNickName", "loginName", "usuario"})
public class UsuarioController {
	@Autowired LoginService loginService;
	@Autowired FileService fileService;
	@Autowired I18nService i18nService;
	
	@RequestMapping(value="imagenUsuario/{nickName}" , method = RequestMethod.GET)
	public ResponseEntity<FileSystemResource> getFile(@PathVariable("nickName") String nickName) {
		try {
			String nombreFicheroConImagen = "Desconocido.jpg";
			if (!"Desconocido".contentEquals(nickName)) {
				Usuario usuarioAMostrarFoto = loginService.encontrarUsuarioPorNickName(nickName);
				nombreFicheroConImagen = usuarioAMostrarFoto.getNombreFicheroConImagen();
			}
			FileSystemResource resource = fileService.getImagenUsuario(nombreFicheroConImagen);
			if (!resource.exists()) {
				throw new Exception("La imagen no existe");
			}
			ResponseEntity<FileSystemResource> responseEntity = new ResponseEntity<>(resource, HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="update-imagenUsuario", method = RequestMethod.GET)
	public String updateImagenUsuario(ModelMap model, @RequestParam String nickName) {
		model.addAttribute("imagenUsuario", new ImagenUsuario(nickName));
		return "update-imagenUsuario";
	}
	
	@RequestMapping(value="guardar-imagen-usuario", method = RequestMethod.POST)
	public String guardarImagenUsuario(ModelMap model, @Valid ImagenUsuario imagenUsuario, BindingResult validacion) {
		if (validacion.hasErrors()) {
			return "update-imagenUsuario";
		}
		
		String nickName = imagenUsuario.getNickname();
		MultipartFile fichero = imagenUsuario.getImagen();
		try {
			if(model.getAttribute("usuario") == null) {
				throw new Exception("Para realizar modificaciones debe estar logeado");
			}
			ArrayList<String> listaErroresAlGuardar = fileService.guardaImagenUsuario(fichero, nickName);
			if(!listaErroresAlGuardar.isEmpty()) {
				String mensajeCompleto = "";
				for (String mensaje : listaErroresAlGuardar) {
					mensajeCompleto += i18nService.getTraduccion(mensaje) + "<br>";
				}
				throw new Exception(mensajeCompleto);
			}
			Usuario quienModifica = (Usuario) model.getAttribute("usuario");
			Usuario usuarioAModificar = loginService.encontrarUsuarioPorNickName(nickName);
			usuarioAModificar.setNombreFicheroConImagen(fileService.getNombreImagenUsuario(fichero, nickName));
			loginService.modificaUsuario(usuarioAModificar, quienModifica.getNickname());
			model.clear();
			model.addAttribute(loginService.encontrarUsuarioPorNickName(nickName));
			model.addAttribute("imagenUsuario", new ImagenUsuario(nickName));
			return "update-imagenUsuario";
		} catch (Exception e) {
			model.addAttribute("usuario", loginService.encontrarUsuarioPorNickName(nickName));
			model.addAttribute("imagenUsuario", new ImagenUsuario(nickName));
			model.addAttribute("errores", e.getMessage());
			return "update-imagenUsuario";
		}
	}
}