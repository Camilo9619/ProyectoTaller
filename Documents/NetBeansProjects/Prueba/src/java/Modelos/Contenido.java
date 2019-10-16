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
import javax.persistence.JoinColumn;
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
@Table(name = "contenido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contenido.findAll", query = "SELECT c FROM Contenido c")
    , @NamedQuery(name = "Contenido.findByContenidoId", query = "SELECT c FROM Contenido c WHERE c.contenidoId = :contenidoId")
    , @NamedQuery(name = "Contenido.findByContenidoNombre", query = "SELECT c FROM Contenido c WHERE c.contenidoNombre = :contenidoNombre")
    , @NamedQuery(name = "Contenido.findByContenidoCategoria", query = "SELECT c FROM Contenido c WHERE c.contenidoCategoria = :contenidoCategoria")})
public class Contenido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contenido_id")
    private Integer contenidoId;
    @Column(name = "contenido_nombre")
    private String contenidoNombre;
    @Column(name = "contenido_categoria")
    private String contenidoCategoria;
    @JoinColumn(name = "contenido_id", referencedColumnName = "usuario_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "contenido")
    private Comentario comentario;

    public Contenido() {
    }

    public Contenido(Integer contenidoId) {
        this.contenidoId = contenidoId;
    }

    public Integer getContenidoId() {
        return contenidoId;
    }

    public void setContenidoId(Integer contenidoId) {
        this.contenidoId = contenidoId;
    }

    public String getContenidoNombre() {
        return contenidoNombre;
    }

    public void setContenidoNombre(String contenidoNombre) {
        this.contenidoNombre = contenidoNombre;
    }

    public String getContenidoCategoria() {
        return contenidoCategoria;
    }

    public void setContenidoCategoria(String contenidoCategoria) {
        this.contenidoCategoria = contenidoCategoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        hash += (contenidoId != null ? contenidoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contenido)) {
            return false;
        }
        Contenido other = (Contenido) object;
        if ((this.contenidoId == null && other.contenidoId != null) || (this.contenidoId != null && !this.contenidoId.equals(other.contenidoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Contenido[ contenidoId=" + contenidoId + " ]";
    }
    
}
