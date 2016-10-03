/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orprovisa.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "etapa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etapa.findAll", query = "SELECT e FROM Etapa e"),
    @NamedQuery(name = "Etapa.findByIdEtapa", query = "SELECT e FROM Etapa e WHERE e.idEtapa = :idEtapa"),
    @NamedQuery(name = "Etapa.findByNombreEtapa", query = "SELECT e FROM Etapa e WHERE e.nombreEtapa = :nombreEtapa")})
public class Etapa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEtapa")
    private Integer idEtapa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "nombreEtapa")
    private String nombreEtapa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etapa")
    private List<Etapaorden> etapaordenList;

    public Etapa() {
    }

    public Etapa(Integer idEtapa) {
        this.idEtapa = idEtapa;
    }

    public Etapa(Integer idEtapa, String nombreEtapa) {
        this.idEtapa = idEtapa;
        this.nombreEtapa = nombreEtapa;
    }

    public Integer getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Integer idEtapa) {
        this.idEtapa = idEtapa;
    }

    public String getNombreEtapa() {
        return nombreEtapa;
    }

    public void setNombreEtapa(String nombreEtapa) {
        this.nombreEtapa = nombreEtapa;
    }

    @XmlTransient
    public List<Etapaorden> getEtapaordenList() {
        return etapaordenList;
    }

    public void setEtapaordenList(List<Etapaorden> etapaordenList) {
        this.etapaordenList = etapaordenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtapa != null ? idEtapa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etapa)) {
            return false;
        }
        Etapa other = (Etapa) object;
        if ((this.idEtapa == null && other.idEtapa != null) || (this.idEtapa != null && !this.idEtapa.equals(other.idEtapa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orprovisa.model.Etapa[ idEtapa=" + idEtapa + " ]";
    }
    
}
