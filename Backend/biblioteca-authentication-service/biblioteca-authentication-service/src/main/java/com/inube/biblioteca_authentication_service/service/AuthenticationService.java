package com.inube.biblioteca_authentication_service.service;

import com.inube.biblioteca_authentication_service.dto.LoginDto;
import com.inube.biblioteca_authentication_service.dto.ResponseDto;
import com.inube.biblioteca_authentication_service.dto.TokenDto;
import com.inube.biblioteca_authentication_service.entity.BiblioUsuario;
import com.inube.biblioteca_authentication_service.repository.BiblioRepository;
import com.inube.biblioteca_authentication_service.security.JwtUtil;
import com.inube.biblioteca_authentication_service.util.Util;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

    private final BiblioRepository biblioRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    //private final ViwLoginRepository viwLoginRepository;

    //private final ViwUsuarioSucursalRepository viwUsuarioSucursalRepository;

    @Transactional(readOnly = true)
    public ResponseDto login(LoginDto loginDto){
        Optional<BiblioUsuario> biblioUsuarioOptional = biblioRepository.findByNombreUsuario(loginDto.nombreUsuario());
        if (biblioUsuarioOptional.isEmpty()){
            logger.error("{}: {}", Util.LOGINFAIL, loginDto.nombreUsuario());
            return new ResponseDto(Util.ERRORSUCCESS, Util.NOTUSER, Util.NOTFOUND, null);
        }
        BiblioUsuario biblioUsuario = biblioUsuarioOptional.get();
        if (!passwordEncoder.matches(loginDto.passwordUsuario(), biblioUsuario.getClave())){
            logger.error("{}: {}", Util.LOGINFAIL, loginDto.nombreUsuario());
            return new ResponseDto(Util.ERRORSUCCESS, Util.NOTUSER, Util.NOTFOUND, null);
        }

        logger.info("{}: {}", Util.LOGINOK, loginDto.nombreUsuario());
        return new ResponseDto(Util.OKSUCCESS, Util.OKQUERY, null, biblioUsuario);
    }

    public ResponseDto validate(String token){
        if (jwtUtil.isInvalid(token)){
            return new ResponseDto(Util.ERRORSUCCESS, Util.TOKENINVALID, Util.NOTFOUND, null);
        }
        return new ResponseDto(Util.OKSUCCESS, Util.TOKENVALID, Util.SESSIONVALID, new TokenDto(token));
    }
}
