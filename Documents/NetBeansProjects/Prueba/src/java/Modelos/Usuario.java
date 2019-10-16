/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author camil
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUsuarioId", query = "SELECT u FROM Usuario u WHERE u.usuarioId = :usuarioId")
    , @NamedQuery(name = "Usuario.findByUsuarioNombres", query = "SELECT u FROM Usuario u WHERE u.usuarioNombres = :usuarioNombres")
    , @NamedQuery(name = "Usuario.findByUsuariosApellidos", query = "SELECT u FROM Usuario u WHERE u.usuariosApellidos = :usuariosApellidos")
    , @NamedQuery(name = "Usuario.findByUsuarioCreacion", query = "SELECT u FROM Usuario u WHERE u.usuarioCreacion = :usuarioCreacion")
    , @NamedQuery(name = "Usuario.findByUsuarioEmail", query = "SELECT u FROM Usuario u WHERE u.usuarioEmail = :usuarioEmail")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuario_id")
    private Integer usuarioId;
    @Column(name = "usuario_nombres")
    private Serializable usuarioNombres;
    @Column(name = "usuarios_apellidos")
    private String usuariosApellidos;
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    @Column(name = "usuario_email")
    private String usuarioEmail;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Contenido contenido;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Comentario comentario;

    public Usuario() {
    }

    public Usuario(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Serializable getUsuarioNombres() {
        return usuarioNombres;
    }

    public void setUsuarioNombres(Serializable usuarioNombres) {
        this.usuarioNombres = usuarioNombres;
    }

    public String getUsuariosApellidos() {
        return usuariosApellidos;
    }

    public void setUsuariosApellidos(String usuariosApellidos) {
        this.usuariosApellidos = usuariosApellidos;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public Contenido getContenido() {
        return contenido;
    }

    public void setContenido(Contenido contenido) {
        this.contenido = contenido;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Usuario[ usuarioId=" + usuarioId + " ]";
    }
    
}
