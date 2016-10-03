/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orprovisa.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "usuariopatologia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuariopatologia.findAll", query = "SELECT u FROM Usuariopatologia u"),
    @NamedQuery(name = "Usuariopatologia.findByUsuarioidUsuario", query = "SELECT u FROM Usuariopatologia u WHERE u.usuariopatologiaPK.usuarioidUsuario = :usuarioidUsuario"),
    @NamedQuery(name = "Usuariopatologia.findByPatologiaidPatologia", query = "SELECT u FROM Usuariopatologia u WHERE u.usuariopatologiaPK.patologiaidPatologia = :patologiaidPatologia"),
    @NamedQuery(name = "Usuariopatologia.findByDescripcion", query = "SELECT u FROM Usuariopatologia u WHERE u.descripcion = :descripcion")})
public class Usuariopatologia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuariopatologiaPK usuariopatologiaPK;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "Patologia_idPatologia", referencedColumnName = "idPatologia", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Patologia patologia;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Usuariopatologia() {
    }

    public Usuariopatologia(UsuariopatologiaPK usuariopatologiaPK) {
        this.usuariopatologiaPK = usuariopatologiaPK;
    }

    public Usuariopatologia(int usuarioidUsuario, int patologiaidPatologia) {
        this.usuariopatologiaPK = new UsuariopatologiaPK(usuarioidUsuario, patologiaidPatologia);
    }

    public UsuariopatologiaPK getUsuariopatologiaPK() {
        return usuariopatologiaPK;
    }

    public void setUsuariopatologiaPK(UsuariopatologiaPK usuariopatologiaPK) {
        this.usuariopatologiaPK = usuariopatologiaPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Patologia getPatologia() {
        return patologia;
    }

    public void setPatologia(Patologia patologia) {
        this.patologia = patologia;
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
        hash += (usuariopatologiaPK != null ? usuariopatologiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariopatologia)) {
            return false;
        }
        Usuariopatologia other = (Usuariopatologia) object;
        if ((this.usuariopatologiaPK == null && other.usuariopatologiaPK != null) || (this.usuariopatologiaPK != null && !this.usuariopatologiaPK.equals(other.usuariopatologiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orprovisa.model.Usuariopatologia[ usuariopatologiaPK=" + usuariopatologiaPK + " ]";
    }
    
}
