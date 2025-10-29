package com.inube.biblioteca_authentication_service.controller;

import com.inube.biblioteca_authentication_service.dto.ResponseDto;
import com.inube.biblioteca_authentication_service.entity.BiblioUsuario;
import com.inube.biblioteca_authentication_service.service.BiblioUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class BiblioUsuarioController {

    private final BiblioUsuarioService biblioUsuarioService;

    @GetMapping("")
    public ResponseEntity<ResponseDto> findAll(){
        return ResponseEntity.ok(biblioUsuarioService.findAll());
    }
    @GetMapping("/{uuidUsuario}")
    public ResponseEntity<ResponseDto> findById(@PathVariable("uuidUsuario") UUID uuidUsuario){
        return ResponseEntity.ok(biblioUsuarioService.findById(uuidUsuario));
    }
    @GetMapping("/persona/{uuidPersona}")
    public ResponseEntity<ResponseDto> findByUuidPersona(@PathVariable("uuidPersona") UUID uuidPersona){
        return ResponseEntity.ok(biblioUsuarioService.findByUuidPersona(uuidPersona));
    }
    @PostMapping("")
    public ResponseEntity<ResponseDto> save (@RequestBody BiblioUsuario biblioUsuario,
                                             @RequestHeader("uuidUsuario") UUID uuidUsuario){
        return ResponseEntity.ok(biblioUsuarioService.save(biblioUsuario, uuidUsuario));
    }
    @PutMapping("/{uuidUsuario}")
    public ResponseEntity<ResponseDto> update(@RequestBody BiblioUsuario biblioUsuario,
                                              @PathVariable("uuidUsuario") UUID uuidUsuario,
                                              @RequestHeader("uuidUsuario") UUID usuarioModificacion){
        return ResponseEntity.ok(biblioUsuarioService.update(biblioUsuario, uuidUsuario, usuarioModificacion));
    }
    @DeleteMapping("/{uuidUsuario}")
    public ResponseEntity<ResponseDto> deleteById(@PathVariable("uuidUsuario") UUID uuidUsuario,
                                                  @RequestHeader("uuidUsuario") UUID usuarioModificacion){
        return ResponseEntity.ok(biblioUsuarioService.deleteById(uuidUsuario,usuarioModificacion));
    }
    @DeleteMapping("/persona/{uuidPersona}")
    public ResponseEntity<ResponseDto> deleteByUuidPersona(@PathVariable("uuidPersona") UUID uuidPersona,
                                                           @RequestHeader("uuidUsuario") UUID usuarioModificacion){
        return ResponseEntity.ok(biblioUsuarioService.deleteByUuidPersona(uuidPersona,usuarioModificacion));
    }

}
