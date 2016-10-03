/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orprovisa.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByIdmenu", query = "SELECT m FROM Menu m WHERE m.idmenu = :idmenu"),
    @NamedQuery(name = "Menu.findByNombre", query = "SELECT m FROM Menu m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Menu.findByTipo", query = "SELECT m FROM Menu m WHERE m.tipo = :tipo"),
    @NamedQuery(name = "Menu.findByEstado", query = "SELECT m FROM Menu m WHERE m.estado = :estado")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmenu")
    private Integer idmenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinColumn(name = "Rol_idRol", referencedColumnName = "idRol")
    @ManyToOne(optional = false)
    private Rol rolidRol;
    @OneToMany(mappedBy = "codigoSubmenu")
    private List<Menu> menuList;
    @JoinColumn(name = "codigoSubmenu", referencedColumnName = "idmenu")
    @ManyToOne
    private Menu codigoSubmenu;

    public Menu() {
    }

    public Menu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public Menu(Integer idmenu, String nombre, String tipo, int estado) {
        this.idmenu = idmenu;
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Integer getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Rol getRolidRol() {
        return rolidRol;
    }

    public void setRolidRol(Rol rolidRol) {
        this.rolidRol = rolidRol;
    }

    @XmlTransient
    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Menu getCodigoSubmenu() {
        return codigoSubmenu;
    }

    public void setCodigoSubmenu(Menu codigoSubmenu) {
        this.codigoSubmenu = codigoSubmenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmenu != null ? idmenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.idmenu == null && other.idmenu != null) || (this.idmenu != null && !this.idmenu.equals(other.idmenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orprovisa.model.Menu[ idmenu=" + idmenu + " ]";
    }
    
}
