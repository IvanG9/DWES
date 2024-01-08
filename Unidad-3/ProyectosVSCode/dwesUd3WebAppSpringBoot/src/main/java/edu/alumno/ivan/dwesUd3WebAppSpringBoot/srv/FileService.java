package edu.alumno.ivan.dwesUd3WebAppSpringBoot.srv;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.alumno.ivan.dwesUd3WebAppSpringBoot.validaciones.ValidadorDocumentoAlumno;
import edu.alumno.ivan.dwesUd3WebAppSpringBoot.validaciones.ValidadorImagenes;

@Service
public class FileService {
	private static final String USER_HOME_TOMCAT = System.getProperty("user.home");
	private static final String SEPARATOR = File.separator;
	private static final String CARPETA_FICHEROS_DINAMICOS_WEBAPP = USER_HOME_TOMCAT+SEPARATOR+"AlumnosWebApp_DynamicFiles"+SEPARATOR;
	
	private static final String CARPETA_IMAGENES_USUARIOS = CARPETA_FICHEROS_DINAMICOS_WEBAPP+"ImagenesUsuarios";
	private static final String CARPETA_DOCUMENTACION_ALUMNOS = CARPETA_FICHEROS_DINAMICOS_WEBAPP+"DocumentacionAlumnos";
	
	public FileSystemResource getImagenUsuario(String fichero) {
		return new FileSystemResource(new File(CARPETA_IMAGENES_USUARIOS, fichero));
	}
	
	public FileSystemResource getDocumentoAlumno(String nombreFichero) {
		return new FileSystemResource(new File(CARPETA_DOCUMENTACION_ALUMNOS, nombreFichero));
	}
	
	public String guardarFichero(String ruta, MultipartFile fichero) {
		try {
			byte[] fileBytes = fichero.getBytes();
			Path path = Paths.get(ruta);
			Files.write(path, fileBytes);
		} catch (NoSuchFileException e) {
			return "No existe la carpeta para poder guardar '"+e.getMessage()+"'";
		} catch (IOException e) {
			return e.getMessage();
		}
		return null;
	}
	
	public ArrayList<String> guardaImagenUsuario(MultipartFile fichero, String nickName) {
		String nombreFichero = getNombreImagenUsuario(fichero, nickName);
		
		if (!ValidadorImagenes.imagenValida(fichero)) {
			return ValidadorImagenes.mensajesErrorImagen(fichero);
		}
		
		String errorAlGuardar = guardarFichero(CARPETA_IMAGENES_USUARIOS+SEPARATOR+nombreFichero, fichero);
		if (errorAlGuardar==null) {
			return new ArrayList<String>();
		} else {
			return new ArrayList<String>(List.of(errorAlGuardar));
		}
	}
	
	public ArrayList<String> guardaDocumentacionAlumno(MultipartFile fichero, String nombreFichero) {
		if (!ValidadorDocumentoAlumno.documentoValido(fichero)) {
			return ValidadorDocumentoAlumno.mensajesErrorDocumento(fichero);
		}
		
		String errorAlGuardar = guardarFichero(CARPETA_DOCUMENTACION_ALUMNOS+SEPARATOR+nombreFichero, fichero);
		if (errorAlGuardar==null) {
			return new ArrayList<String>();
		} else {
			return new ArrayList<String>(List.of(errorAlGuardar));
		}
	}
	
	public String getNombreImagenUsuario(MultipartFile fichero, String nickName) {
		String extension = ValidadorImagenes.getExtension(fichero);
		String nombreFichero = nickName + "." + extension;
		return nombreFichero;
	}
	
	public String getExtensionMultipartfile(MultipartFile fichero) {
		String filename = fichero.getOriginalFilename();
		int i = filename.lastIndexOf(".");
		return filename.substring(i+1);
	}
	
}