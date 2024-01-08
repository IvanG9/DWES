package edu.alumno.ivan.api_rest_mysql_futbol.security.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NuevoUsuario {
    @NotBlank
    private String nickname;
    @NotBlank
    private String nombre;
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    private Set<String> roles = new HashSet<>();
}
