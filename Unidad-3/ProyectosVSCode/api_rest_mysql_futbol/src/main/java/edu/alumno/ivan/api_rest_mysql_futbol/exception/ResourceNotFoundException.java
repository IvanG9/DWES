package edu.alumno.ivan.api_rest_mysql_futbol.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
