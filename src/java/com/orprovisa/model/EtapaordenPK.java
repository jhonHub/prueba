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
public class EtapaordenPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idEtapa")
    private int idEtapa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idOrdendeServicio")
    private int idOrdendeServicio;

    public EtapaordenPK() {
    }

    public EtapaordenPK(int idEtapa, int idOrdendeServicio) {
        this.idEtapa = idEtapa;
        this.idOrdendeServicio = idOrdendeServicio;
    }

    public int getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(int idEtapa) {
        this.idEtapa = idEtapa;
    }

    public int getIdOrdendeServicio() {
        return idOrdendeServicio;
    }

    public void setIdOrdendeServicio(int idOrdendeServicio) {
        this.idOrdendeServicio = idOrdendeServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEtapa;
        hash += (int) idOrdendeServicio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtapaordenPK)) {
            return false;
        }
        EtapaordenPK other = (EtapaordenPK) object;
        if (this.idEtapa != other.idEtapa) {
            return false;
        }
        if (this.idOrdendeServicio != other.idOrdendeServicio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orprovisa.model.EtapaordenPK[ idEtapa=" + idEtapa + ", idOrdendeServicio=" + idOrdendeServicio + " ]";
    }
    
}
