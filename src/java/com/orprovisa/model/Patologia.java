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
@Table(name = "patologia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patologia.findAll", query = "SELECT p FROM Patologia p"),
    @NamedQuery(name = "Patologia.findByIdPatologia", query = "SELECT p FROM Patologia p WHERE p.idPatologia = :idPatologia"),
    @NamedQuery(name = "Patologia.findByNombrePatologia", query = "SELECT p FROM Patologia p WHERE p.nombrePatologia = :nombrePatologia")})
public class Patologia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPatologia")
    private Integer idPatologia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "nombrePatologia")
    private String nombrePatologia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patologia")
    private List<Usuariopatologia> usuariopatologiaList;

    public Patologia() {
    }

    public Patologia(Integer idPatologia) {
        this.idPatologia = idPatologia;
    }

    public Patologia(Integer idPatologia, String nombrePatologia) {
        this.idPatologia = idPatologia;
        this.nombrePatologia = nombrePatologia;
    }

    public Integer getIdPatologia() {
        return idPatologia;
    }

    public void setIdPatologia(Integer idPatologia) {
        this.idPatologia = idPatologia;
    }

    public String getNombrePatologia() {
        return nombrePatologia;
    }

    public void setNombrePatologia(String nombrePatologia) {
        this.nombrePatologia = nombrePatologia;
    }

    @XmlTransient
    public List<Usuariopatologia> getUsuariopatologiaList() {
        return usuariopatologiaList;
    }

    public void setUsuariopatologiaList(List<Usuariopatologia> usuariopatologiaList) {
        this.usuariopatologiaList = usuariopatologiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPatologia != null ? idPatologia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patologia)) {
            return false;
        }
        Patologia other = (Patologia) object;
        if ((this.idPatologia == null && other.idPatologia != null) || (this.idPatologia != null && !this.idPatologia.equals(other.idPatologia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orprovisa.model.Patologia[ idPatologia=" + idPatologia + " ]";
    }
    
}
