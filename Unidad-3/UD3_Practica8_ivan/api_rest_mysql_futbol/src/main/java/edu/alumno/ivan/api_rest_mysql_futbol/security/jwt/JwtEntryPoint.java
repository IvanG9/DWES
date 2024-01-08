package edu.alumno.ivan.api_rest_mysql_futbol.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res,
            AuthenticationException e) throws IOException, ServletException {

        logger.error("Fallo en el metodo commence");
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado");

    }

}
    