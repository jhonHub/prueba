/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orprovisa.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author HP
 */
@Embeddable
public class UsuariopatologiaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Usuario_idUsuario")
    private int usuarioidUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Patologia_idPatologia")
    private int patologiaidPatologia;

    public UsuariopatologiaPK() {
    }

    public UsuariopatologiaPK(int usuarioidUsuario, int patologiaidPatologia) {
        this.usuarioidUsuario = usuarioidUsuario;
        this.patologiaidPatologia = patologiaidPatologia;
    }

    public int getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(int usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public int getPatologiaidPatologia() {
        return patologiaidPatologia;
    }

    public void setPatologiaidPatologia(int patologiaidPatologia) {
        this.patologiaidPatologia = patologiaidPatologia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuarioidUsuario;
        hash += (int) patologiaidPatologia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariopatologiaPK)) {
            return false;
        }
        UsuariopatologiaPK other = (UsuariopatologiaPK) object;
        if (this.usuarioidUsuario != other.usuarioidUsuario) {
            return false;
        }
        if (this.patologiaidPatologia != other.patologiaidPatologia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orprovisa.model.UsuariopatologiaPK[ usuarioidUsuario=" + usuarioidUsuario + ", patologiaidPatologia=" + patologiaidPatologia + " ]";
    }
    
}
