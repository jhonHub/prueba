/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orprovisa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "ordendeservicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordendeservicio.findAll", query = "SELECT o FROM Ordendeservicio o"),
    @NamedQuery(name = "Ordendeservicio.findByIdOrdenDeServicio", query = "SELECT o FROM Ordendeservicio o WHERE o.idOrdenDeServicio = :idOrdenDeServicio"),
    @NamedQuery(name = "Ordendeservicio.findByFechaAsignacion", query = "SELECT o FROM Ordendeservicio o WHERE o.fechaAsignacion = :fechaAsignacion"),
    @NamedQuery(name = "Ordendeservicio.findByFechaFin", query = "SELECT o FROM Ordendeservicio o WHERE o.fechaFin = :fechaFin"),
    @NamedQuery(name = "Ordendeservicio.findByFechaFinalizacion", query = "SELECT o FROM Ordendeservicio o WHERE o.fechaFinalizacion = :fechaFinalizacion"),
    @NamedQuery(name = "Ordendeservicio.findByIdPaciente", query = "SELECT o FROM Ordendeservicio o WHERE o.idPaciente = :idPaciente")})
public class Ordendeservicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOrdenDeServicio")
    private Integer idOrdenDeServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaAsignacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "fechaFinalizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPaciente")
    private int idPaciente;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false)
    private Producto idProducto;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordendeservicio")
    private List<Etapaorden> etapaordenList;

    public Ordendeservicio() {
    }

    public Ordendeservicio(Integer idOrdenDeServicio) {
        this.idOrdenDeServicio = idOrdenDeServicio;
    }

    public Ordendeservicio(Integer idOrdenDeServicio, Date fechaAsignacion, Date fechaFin, int idPaciente) {
        this.idOrdenDeServicio = idOrdenDeServicio;
        this.fechaAsignacion = fechaAsignacion;
        this.fechaFin = fechaFin;
        this.idPaciente = idPaciente;
    }

    public Integer getIdOrdenDeServicio() {
        return idOrdenDeServicio;
    }

    public void setIdOrdenDeServicio(Integer idOrdenDeServicio) {
        this.idOrdenDeServicio = idOrdenDeServicio;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        hash += (idOrdenDeServicio != null ? idOrdenDeServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordendeservicio)) {
            return false;
        }
        Ordendeservicio other = (Ordendeservicio) object;
        if ((this.idOrdenDeServicio == null && other.idOrdenDeServicio != null) || (this.idOrdenDeServicio != null && !this.idOrdenDeServicio.equals(other.idOrdenDeServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orprovisa.model.Ordendeservicio[ idOrdenDeServicio=" + idOrdenDeServicio + " ]";
    }
    
}
