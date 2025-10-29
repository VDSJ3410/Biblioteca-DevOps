package com.inube.biblioteca_authentication_service.dto;

import jakarta.validation.constraints.NotBlank;

public record TokenDto(@NotBlank String token) {
}
