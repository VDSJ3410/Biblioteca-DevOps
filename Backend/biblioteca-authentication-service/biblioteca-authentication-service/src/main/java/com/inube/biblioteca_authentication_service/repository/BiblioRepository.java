package com.inube.biblioteca_authentication_service.repository;

import com.inube.biblioteca_authentication_service.entity.BiblioUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BiblioRepository extends JpaRepository <BiblioUsuario, UUID>,
        JpaSpecificationExecutor <BiblioUsuario> {

    Optional<BiblioUsuario> findByNombreUsuario(String nombre);
    Optional<BiblioUsuario> findByIdUuidUsuario(UUID uuidUsuario);
}
