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
@Table(name = "especialidadusuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especialidadusuario.findAll", query = "SELECT e FROM Especialidadusuario e"),
    @NamedQuery(name = "Especialidadusuario.findByIdEspecialidad", query = "SELECT e FROM Especialidadusuario e WHERE e.especialidadusuarioPK.idEspecialidad = :idEspecialidad"),
    @NamedQuery(name = "Especialidadusuario.findByIdusuario", query = "SELECT e FROM Especialidadusuario e WHERE e.especialidadusuarioPK.idusuario = :idusuario"),
    @NamedQuery(name = "Especialidadusuario.findByDescripcion", query = "SELECT e FROM Especialidadusuario e WHERE e.descripcion = :descripcion")})
public class Especialidadusuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EspecialidadusuarioPK especialidadusuarioPK;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idEspecialidad", referencedColumnName = "idEspecialidad", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Especialidad especialidad;
    @JoinColumn(name = "idusuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Especialidadusuario() {
    }

    public Especialidadusuario(EspecialidadusuarioPK especialidadusuarioPK) {
        this.especialidadusuarioPK = especialidadusuarioPK;
    }

    public Especialidadusuario(int idEspecialidad, int idusuario) {
        this.especialidadusuarioPK = new EspecialidadusuarioPK(idEspecialidad, idusuario);
    }

    public EspecialidadusuarioPK getEspecialidadusuarioPK() {
        return especialidadusuarioPK;
    }

    public void setEspecialidadusuarioPK(EspecialidadusuarioPK especialidadusuarioPK) {
        this.especialidadusuarioPK = especialidadusuarioPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (especialidadusuarioPK != null ? especialidadusuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialidadusuario)) {
            return false;
        }
        Especialidadusuario other = (Especialidadusuario) object;
        if ((this.especialidadusuarioPK == null && other.especialidadusuarioPK != null) || (this.especialidadusuarioPK != null && !this.especialidadusuarioPK.equals(other.especialidadusuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orprovisa.model.Especialidadusuario[ especialidadusuarioPK=" + especialidadusuarioPK + " ]";
    }
    
}
