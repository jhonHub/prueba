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
@Table(name = "productocomponente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productocomponente.findAll", query = "SELECT p FROM Productocomponente p"),
    @NamedQuery(name = "Productocomponente.findByIdProducto", query = "SELECT p FROM Productocomponente p WHERE p.productocomponentePK.idProducto = :idProducto"),
    @NamedQuery(name = "Productocomponente.findByIdComponente", query = "SELECT p FROM Productocomponente p WHERE p.productocomponentePK.idComponente = :idComponente"),
    @NamedQuery(name = "Productocomponente.findByDescripcion", query = "SELECT p FROM Productocomponente p WHERE p.descripcion = :descripcion")})
public class Productocomponente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductocomponentePK productocomponentePK;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idComponente", referencedColumnName = "idComponente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Componente componente;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public Productocomponente() {
    }

    public Productocomponente(ProductocomponentePK productocomponentePK) {
        this.productocomponentePK = productocomponentePK;
    }

    public Productocomponente(int idProducto, int idComponente) {
        this.productocomponentePK = new ProductocomponentePK(idProducto, idComponente);
    }

    public ProductocomponentePK getProductocomponentePK() {
        return productocomponentePK;
    }

    public void setProductocomponentePK(ProductocomponentePK productocomponentePK) {
        this.productocomponentePK = productocomponentePK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productocomponentePK != null ? productocomponentePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productocomponente)) {
            return false;
        }
        Productocomponente other = (Productocomponente) object;
        if ((this.productocomponentePK == null && other.productocomponentePK != null) || (this.productocomponentePK != null && !this.productocomponentePK.equals(other.productocomponentePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orprovisa.model.Productocomponente[ productocomponentePK=" + productocomponentePK + " ]";
    }
    
}
