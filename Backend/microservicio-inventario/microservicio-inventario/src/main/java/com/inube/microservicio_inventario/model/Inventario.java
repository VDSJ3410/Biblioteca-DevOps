package com.inube.microservicio_inventario.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "INVENTARIOS")
public class Inventario {

    @Id
    @Column(name = "ID_INVENTARIO")
    private Long idInventario;

    @Column(name = "ID_CATEGORIA_INVENTARIO", nullable = false)
    private Long idCategoriaInventario;

    @Column(name = "ID_TIPO_INVENTARIO", nullable = false)
    private Long idTipoInventario;

    @Column(name = "TITULO", nullable = false, length = 100)
    private String titulo;

    @Column(name = "FECHA_PUBLICACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;

    @Column(name = "NUMERO_PAGINAS", nullable = false)
    private Integer numeroPaginas;

    @Column(name = "ISBN", nullable = false, length = 150)
    private String isbn;

    @Column(name = "SINTESIS", nullable = false, length = 150)
    private String sintesis;

    @Column(name = "ESTATUSREGISTRO", nullable = false)
    private Integer estatusRegistro;

    @Column(name = "FECHACREACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @Column(name = "USUARIOCREACION", nullable = false, length = 100)
    private String usuarioCreacion;

    @Column(name = "FECHAMODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;

    @Column(name = "USUARIOMODIFICACION", length = 100)
    private String usuarioModificacion;

    @Column(name = "OBSREGISTRO", length = 100)
    private String obsRegistro;

    // Getters y Setters
    public Long getIdInventario() { return idInventario; }
    public void setIdInventario(Long idInventario) { this.idInventario = idInventario; }

    public Long getIdCategoriaInventario() { return idCategoriaInventario; }
    public void setIdCategoriaInventario(Long idCategoriaInventario) { this.idCategoriaInventario = idCategoriaInventario; }

    public Long getIdTipoInventario() { return idTipoInventario; }
    public void setIdTipoInventario(Long idTipoInventario) { this.idTipoInventario = idTipoInventario; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Date getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(Date fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }

    public Integer getNumeroPaginas() { return numeroPaginas; }
    public void setNumeroPaginas(Integer numeroPaginas) { this.numeroPaginas = numeroPaginas; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getSintesis() { return sintesis; }
    public void setSintesis(String sintesis) { this.sintesis = sintesis; }

    public Integer getEstatusRegistro() { return estatusRegistro; }
    public void setEstatusRegistro(Integer estatusRegistro) { this.estatusRegistro = estatusRegistro; }

    public Date getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public String getUsuarioCreacion() { return usuarioCreacion; }
    public void setUsuarioCreacion(String usuarioCreacion) { this.usuarioCreacion = usuarioCreacion; }

    public Date getFechaModificacion() { return fechaModificacion; }
    public void setFechaModificacion(Date fechaModificacion) { this.fechaModificacion = fechaModificacion; }

    public String getUsuarioModificacion() { return usuarioModificacion; }
    public void setUsuarioModificacion(String usuarioModificacion) { this.usuarioModificacion = usuarioModificacion; }

    public String getObsRegistro() { return obsRegistro; }
    public void setObsRegistro(String obsRegistro) { this.obsRegistro = obsRegistro; }
}

