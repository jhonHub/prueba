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
public class PermisorolPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idPermiso")
    private int idPermiso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRol")
    private int idRol;

    public PermisorolPK() {
    }

    public PermisorolPK(int idPermiso, int idRol) {
        this.idPermiso = idPermiso;
        this.idRol = idRol;
    }

    public int getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPermiso;
        hash += (int) idRol;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisorolPK)) {
            return false;
        }
        PermisorolPK other = (PermisorolPK) object;
        if (this.idPermiso != other.idPermiso) {
            return false;
        }
        if (this.idRol != other.idRol) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orprovisa.model.PermisorolPK[ idPermiso=" + idPermiso + ", idRol=" + idRol + " ]";
    }
    
}
