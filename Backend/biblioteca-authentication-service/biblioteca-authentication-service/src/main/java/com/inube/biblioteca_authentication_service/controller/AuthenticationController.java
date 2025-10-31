package com.inube.biblioteca_authentication_service.controller;

import com.inube.biblioteca_authentication_service.dto.LoginDto;
import com.inube.biblioteca_authentication_service.dto.ResponseDto;
import com.inube.biblioteca_authentication_service.dto.TokenDto;
import com.inube.biblioteca_authentication_service.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login (@RequestBody @Valid LoginDto loginDto){
        return ResponseEntity.ok(authenticationService.login(loginDto));
    }

    @PostMapping("/validate")
    public ResponseEntity<ResponseDto> validate(@RequestBody @Valid TokenDto tokenDto){
        return ResponseEntity.ok(authenticationService.validate(tokenDto.token()));
    }
}
