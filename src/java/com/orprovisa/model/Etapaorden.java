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
@Table(name = "etapaorden")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etapaorden.findAll", query = "SELECT e FROM Etapaorden e"),
    @NamedQuery(name = "Etapaorden.findByIdEtapa", query = "SELECT e FROM Etapaorden e WHERE e.etapaordenPK.idEtapa = :idEtapa"),
    @NamedQuery(name = "Etapaorden.findByIdOrdendeServicio", query = "SELECT e FROM Etapaorden e WHERE e.etapaordenPK.idOrdendeServicio = :idOrdendeServicio"),
    @NamedQuery(name = "Etapaorden.findByDescripcion", query = "SELECT e FROM Etapaorden e WHERE e.descripcion = :descripcion")})
public class Etapaorden implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EtapaordenPK etapaordenPK;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idEtapa", referencedColumnName = "idEtapa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Etapa etapa;
    @JoinColumn(name = "idOrdendeServicio", referencedColumnName = "idOrdenDeServicio", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ordendeservicio ordendeservicio;

    public Etapaorden() {
    }

    public Etapaorden(EtapaordenPK etapaordenPK) {
        this.etapaordenPK = etapaordenPK;
    }

    public Etapaorden(int idEtapa, int idOrdendeServicio) {
        this.etapaordenPK = new EtapaordenPK(idEtapa, idOrdendeServicio);
    }

    public EtapaordenPK getEtapaordenPK() {
        return etapaordenPK;
    }

    public void setEtapaordenPK(EtapaordenPK etapaordenPK) {
        this.etapaordenPK = etapaordenPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public Ordendeservicio getOrdendeservicio() {
        return ordendeservicio;
    }

    public void setOrdendeservicio(Ordendeservicio ordendeservicio) {
        this.ordendeservicio = ordendeservicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (etapaordenPK != null ? etapaordenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etapaorden)) {
            return false;
        }
        Etapaorden other = (Etapaorden) object;
        if ((this.etapaordenPK == null && other.etapaordenPK != null) || (this.etapaordenPK != null && !this.etapaordenPK.equals(other.etapaordenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orprovisa.model.Etapaorden[ etapaordenPK=" + etapaordenPK + " ]";
    }
    
}
