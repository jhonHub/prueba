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
public class ProductocomponentePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idProducto")
    private int idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idComponente")
    private int idComponente;

    public ProductocomponentePK() {
    }

    public ProductocomponentePK(int idProducto, int idComponente) {
        this.idProducto = idProducto;
        this.idComponente = idComponente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(int idComponente) {
        this.idComponente = idComponente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProducto;
        hash += (int) idComponente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductocomponentePK)) {
            return false;
        }
        ProductocomponentePK other = (ProductocomponentePK) object;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idComponente != other.idComponente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orprovisa.model.ProductocomponentePK[ idProducto=" + idProducto + ", idComponente=" + idComponente + " ]";
    }
    
}
