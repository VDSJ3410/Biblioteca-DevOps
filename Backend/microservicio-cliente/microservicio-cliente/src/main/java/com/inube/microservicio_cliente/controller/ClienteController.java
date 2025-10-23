package com.inube.microservicio_cliente.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/microservicio-cliente")
public class ClienteController {

    @Value("{mensaje}")
    private String mensaje;

    @GetMapping("/mensaje")
    public String mostrarMensaje(){
        return mensaje;
    }
}
