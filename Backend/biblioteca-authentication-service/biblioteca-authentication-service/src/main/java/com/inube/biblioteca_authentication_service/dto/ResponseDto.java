package com.inube.biblioteca_authentication_service.dto;

public record ResponseDto(Boolean success,
                            String mensaje,
                            String error,
                            Object data) {
}
