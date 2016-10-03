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
@Table(name = "permisorol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permisorol.findAll", query = "SELECT p FROM Permisorol p"),
    @NamedQuery(name = "Permisorol.findByIdPermiso", query = "SELECT p FROM Permisorol p WHERE p.permisorolPK.idPermiso = :idPermiso"),
    @NamedQuery(name = "Permisorol.findByIdRol", query = "SELECT p FROM Permisorol p WHERE p.permisorolPK.idRol = :idRol"),
    @NamedQuery(name = "Permisorol.findByDescripcion", query = "SELECT p FROM Permisorol p WHERE p.descripcion = :descripcion")})
public class Permisorol implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PermisorolPK permisorolPK;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idPermiso", referencedColumnName = "idPermiso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Permiso permiso;
    @JoinColumn(name = "idRol", referencedColumnName = "idRol", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rol rol;

    public Permisorol() {
    }

    public Permisorol(PermisorolPK permisorolPK) {
        this.permisorolPK = permisorolPK;
    }

    public Permisorol(int idPermiso, int idRol) {
        this.permisorolPK = new PermisorolPK(idPermiso, idRol);
    }

    public PermisorolPK getPermisorolPK() {
        return permisorolPK;
    }

    public void setPermisorolPK(PermisorolPK permisorolPK) {
        this.permisorolPK = permisorolPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permisorolPK != null ? permisorolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permisorol)) {
            return false;
        }
        Permisorol other = (Permisorol) object;
        if ((this.permisorolPK == null && other.permisorolPK != null) || (this.permisorolPK != null && !this.permisorolPK.equals(other.permisorolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orprovisa.model.Permisorol[ permisorolPK=" + permisorolPK + " ]";
    }
    
}
