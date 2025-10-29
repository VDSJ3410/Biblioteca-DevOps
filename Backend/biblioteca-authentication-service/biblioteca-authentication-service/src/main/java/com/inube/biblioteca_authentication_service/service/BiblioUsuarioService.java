package com.inube.biblioteca_authentication_service.service;

import com.inube.biblioteca_authentication_service.dto.ResponseDto;
import com.inube.biblioteca_authentication_service.entity.BiblioUsuario;
import com.inube.biblioteca_authentication_service.repository.BiblioRepository;
import com.inube.biblioteca_authentication_service.util.Util;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.Utilities;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.*;

@Service
@AllArgsConstructor
public class BiblioUsuarioService {

    private final PasswordEncoder passwordEncoder;
    private final BiblioRepository biblioRepository;
    @Transactional(readOnly = true)
    public ResponseDto findAll(){
        List<BiblioUsuario> biblioUsuarioList = biblioRepository.findAll();
        return new ResponseDto(Util.OKSUCCESS, Util.OKQUERY, null, biblioUsuarioList);
    }
    @Transactional(readOnly = true)
    public ResponseDto findById(UUID uuidUsuario){
        return biblioRepository.findById(uuidUsuario)
                .map(biblioUsuario -> new ResponseDto(Util.OKSUCCESS, Util.OKFOUND, null, biblioUsuario))
                .orElseGet(this::notFoundResponse);
    }
    private ResponseDto notFoundResponse() {
        return new ResponseDto(Util.ERRORSUCCESS, Util.NOTFOUND, Util.NOTFOUND, null);
    }
    @Transactional
    public ResponseDto save(BiblioUsuario biblioUsuario, UUID idusuarioCreacion){
        if (biblioRepository.findByNombreUsuario(biblioUsuario.getNombre()).isPresent()) {
            return new ResponseDto(Util.ERRORSUCCESS, Util.NOTFOUND, Util.NOTFOUND, null );
        }
        String passwordEncoded = passwordEncoder.encode(biblioUsuario.getClave());
        biblioUsuario.setClave(passwordEncoded)
                .setEstatusregistro(Util.OKCODE)
                .setFechacreacion(LocalDateTime.now())
                .setUuidUsuario(idusuarioCreacion);
        biblioRepository.save(biblioUsuario);
        return new ResponseDto(Util.OKSUCCESS, Util.OKQUERY, null, biblioUsuario);
    }
    @Transactional
    public ResponseDto update(BiblioUsuario biblioUsuarioUpdate, UUID uuidUsuario, UUID usuarioModificacion){
        return biblioRepository.findById(uuidUsuario)
                .map(biblioUsuarioExistente -> {
                    BiblioUsuario usuarioDuplicado = biblioRepository.findByNombreUsuario(biblioUsuarioUpdate.getNombre())
                            .filter(u -> !u.getUuidUsuario().equals(biblioUsuarioExistente.getUuidUsuario()))
                            .orElse(null);
                    if (usuarioDuplicado != null) {
                        return new ResponseDto(Util.ERRORSUCCESS, Util.NOTFOUND, Util.NOTFOUND, null);
                    }
                    biblioUsuarioExistente.setNombre(biblioUsuarioUpdate.getNombre())
                            .setUuidUsuario(biblioUsuarioUpdate.getUuidUsuario())
                            .setFechamodificacion(LocalDateTime.now())
                            .setUuidUsuario(usuarioModificacion);
                    biblioRepository.save(biblioUsuarioExistente);
                    return new ResponseDto(Util.OKSUCCESS, Util.OKQUERY, null, biblioUsuarioExistente);
                })
                .orElseGet(this::notFoundResponse);
    }
    @Transactional(readOnly = true)
    public ResponseDto findByUuidPersona(UUID uuidPersona){
        return biblioRepository.findByIdUuidUsuario(uuidPersona)
                .map(biblioUsuario -> new ResponseDto(Util.OKSUCCESS, Util.OKFOUND, null, biblioUsuario))
                .orElseGet(this::notFoundResponse);
    }
    @Transactional
    public ResponseDto deleteByUuidPersona(UUID uuidPersona, UUID uuidUsuario){
        return biblioRepository.findByIdUuidUsuario(uuidPersona)
                .map(biblioUsuario -> {
                    biblioUsuario.setEstatusregistro(Util.DELETECODE)
                            .setFechamodificacion(LocalDateTime.now())
                            .setUuidUsuario(uuidUsuario);
                    biblioRepository.save(biblioUsuario);
                    return new ResponseDto(Util.OKSUCCESS, Util.OKQUERY, null, null);
                })
                .orElseGet(this::notFoundResponse);
    }
    @Transactional
    public ResponseDto deleteById(UUID uuidUsuario, UUID usuarioModificacion){
        return biblioRepository.findById(uuidUsuario)
                .map(biblioUsuario -> {
                    biblioUsuario.setEstatusregistro(Util.DELETECODE)
                            .setFechamodificacion(LocalDateTime.now())
                            .setUuidUsuario(usuarioModificacion);
                    biblioRepository.save(biblioUsuario);
                    return new ResponseDto(Util.OKSUCCESS, Util.OKQUERY, null, null);
                })
                .orElseGet(this::notFoundResponse);
    }


}
