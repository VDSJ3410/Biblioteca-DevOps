package com.inube.biblioteca_authentication_service.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.SQLRestriction;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


@Entity
@Data
@Accessors (chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLRestriction("estatusregistro<>99")
@Table(name = "usuarios")
public class BiblioUsuario implements Serializable  {

    @Serial
    private static final long serealVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column (name = "ID_USUARIO")
    @JsonProperty("uuidUsuario")
    private UUID uuidUsuario;

    @Column(name = "nombre")
    @JsonProperty("nombre")
    private String nombre;

    @Column(name = "apaterno")
    @JsonProperty("apaterno")
    private String apaterno;

    @Column(name = "amaterno")
    @JsonProperty("amaterno")
    private String amaterno;

    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @Column(name = "telefono")
    @JsonProperty("telefono")
    private String telefono;

    @Column(name = "direccion")
    @JsonProperty("direccion")
    private String direccion;

    @Column(name = "username")
    @JsonProperty("username")
    private String usernam;

    @Column(name = "clave")
    @JsonProperty("clave")
    private String clave;

    @Column(name = "estatusregistro")
    @JsonProperty("estatusregistro")
    private Integer estatusregistro;

    @Column(name = "fechacreacion")
    @JsonProperty("fechacreacion")
    private LocalDateTime fechacreacion;

    @Column(name = "usuariocreacion")
    @JsonProperty("usuariocreacion")
    private String usuariocreacion;

    @Column(name = "fechamodificacion")
    @JsonProperty("fechamodificacion")
    private LocalDateTime fechamodificacion;

    @Column(name = "usuariomodificacion")
    @JsonProperty("usuariomodificacion")
    private String usuariomodificacion;

    @Column(name = "obsregistro")
    @JsonProperty("obsregistro")
    private String obsregistro;

}

