/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "comentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c")
    , @NamedQuery(name = "Comentario.findByComentarioId", query = "SELECT c FROM Comentario c WHERE c.comentarioId = :comentarioId")
    , @NamedQuery(name = "Comentario.findByComentarioOpinion", query = "SELECT c FROM Comentario c WHERE c.comentarioOpinion = :comentarioOpinion")
    , @NamedQuery(name = "Comentario.findByComentarioTipo", query = "SELECT c FROM Comentario c WHERE c.comentarioTipo = :comentarioTipo")})
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comentario_id")
    private Integer comentarioId;
    @Column(name = "comentario_opinion")
    private String comentarioOpinion;
    @Column(name = "comentario_tipo")
    private String comentarioTipo;
    @JoinColumn(name = "comentario_id", referencedColumnName = "contenido_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Contenido contenido;
    @JoinColumn(name = "comentario_id", referencedColumnName = "usuario_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Comentario() {
    }

    public Comentario(Integer comentarioId) {
        this.comentarioId = comentarioId;
    }

    public Integer getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(Integer comentarioId) {
        this.comentarioId = comentarioId;
    }

    public String getComentarioOpinion() {
        return comentarioOpinion;
    }

    public void setComentarioOpinion(String comentarioOpinion) {
        this.comentarioOpinion = comentarioOpinion;
    }

    public String getComentarioTipo() {
        return comentarioTipo;
    }

    public void setComentarioTipo(String comentarioTipo) {
        this.comentarioTipo = comentarioTipo;
    }

    public Contenido getContenido() {
        return contenido;
    }

    public void setContenido(Contenido contenido) {
        this.contenido = contenido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comentarioId != null ? comentarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.comentarioId == null && other.comentarioId != null) || (this.comentarioId != null && !this.comentarioId.equals(other.comentarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Comentario[ comentarioId=" + comentarioId + " ]";
    }
    
}
