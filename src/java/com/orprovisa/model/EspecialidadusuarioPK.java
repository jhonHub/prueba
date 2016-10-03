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
public class EspecialidadusuarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idEspecialidad")
    private int idEspecialidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuario")
    private int idusuario;

    public EspecialidadusuarioPK() {
    }

    public EspecialidadusuarioPK(int idEspecialidad, int idusuario) {
        this.idEspecialidad = idEspecialidad;
        this.idusuario = idusuario;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEspecialidad;
        hash += (int) idusuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspecialidadusuarioPK)) {
            return false;
        }
        EspecialidadusuarioPK other = (EspecialidadusuarioPK) object;
        if (this.idEspecialidad != other.idEspecialidad) {
            return false;
        }
        if (this.idusuario != other.idusuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orprovisa.model.EspecialidadusuarioPK[ idEspecialidad=" + idEspecialidad + ", idusuario=" + idusuario + " ]";
    }
    
}
