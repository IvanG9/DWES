package edu.alumno.ivan.api_rest_mysql_futbol.security.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginUsuario {
    @NotBlank
    private String nickname;
    @NotBlank
    private String password;
}
