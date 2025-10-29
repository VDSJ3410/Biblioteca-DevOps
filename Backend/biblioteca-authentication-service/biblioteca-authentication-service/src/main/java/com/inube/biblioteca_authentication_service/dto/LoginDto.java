package com.inube.biblioteca_authentication_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record LoginDto(@JsonProperty ("username")
                       @NotBlank String nombreUsuario,
                       @JsonProperty ("clave")
                       @NotBlank String passwordUsuario) {

}
