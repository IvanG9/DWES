package edu.alumno.ivan.dwesUd3WebAppSpringBoot.validaciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

public class ValidadorDocumentoAlumno implements ConstraintValidator<DocumentoAlumnoValido, MultipartFile> {
	public static final List<String> tiposDeDocumentos = Arrays.asList("image/png", "image/jpg", "image/jpeg", 
			"image/gif", "text/plain", "application/pdf", "application/msword", "application/vdn.ms-excel", 
			"application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/excel",
			"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
			"application/vnd.oasis.opendocument.text", "application/vnd.oasis.opendocument.spreadsheet",
			"application/x-rar-compressed", "application/zip",
			"application/x-zip-compressed", "multipart/x-zip");
	public static final long MAX_BYTES = 2097152;
	
	@Override
	public void initialize (DocumentoAlumnoValido constraintAnnotation) {
		
	}
	
	@Override
	public boolean isValid (MultipartFile multipartFile, ConstraintValidatorContext	context){
		boolean result = true;
		
		ArrayList<String> listaErrores = mensajesErrorDocumento(multipartFile);
		
		if(!listaErrores.isEmpty()) {
			context.disableDefaultConstraintViolation();
			for (String textoError : listaErrores) {
				context.buildConstraintViolationWithTemplate(textoError).addConstraintViolation();
			}
			result = false;
		}
		return result;
	}
	
	public static ArrayList<String> mensajesErrorDocumento (MultipartFile fichero) {
		ArrayList<String> errores = new ArrayList<String>();
		
		if (fichero == null || fichero.isEmpty()) {
			errores.add("Proporcione un fichero valido.");
			return errores;
		}
		
		String contentType = fichero.getContentType();
		
		if(!tipoDeDocumentoValido(contentType)) {
			errores.add("Tipo de documento '"+contentType+"' no permitido.");
		}
		
		if (fichero.getSize() > MAX_BYTES) {
			errores.add("Tamaño maximo del documento excedido ("+MAX_BYTES+" bytes)");
		}
		return errores;
	}
	
	public static  boolean tipoDeDocumentoValido(String contentType) {
		return tiposDeDocumentos.contains(contentType);
	}
	
	public static boolean documentoValido(MultipartFile fichero) {
		ArrayList<String> listaErrores = mensajesErrorDocumento(fichero);
		return listaErrores.isEmpty()?true : false;
	}
	
	public static String getExtension(MultipartFile fichero) {
		String result = "";
		for (String tipoValido : tiposDeDocumentos) {
			if (fichero.getContentType().equals(tipoValido))
				return tipoValido.split("/")[1];
		}
		return result;
	}
}