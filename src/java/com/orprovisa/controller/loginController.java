
package com.orprovisa.controller;

import com.orprovisa.ejb.UsuarioFacade;
import com.orprovisa.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class loginController implements Serializable{
    
    @EJB
    private UsuarioFacade usuarioEJB;
    private Usuario usuario;
   
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String iniciarSesion(){
        Usuario us;
        String redireccion = null;
        try {
            us = usuarioEJB.iniciarSesion(usuario);
            
            if (us != null ) {
            redireccion = "template?faces-redirect=true";    
            }else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso","usuario o clave invalidos"));    
            }
            
        } catch (Exception e) {
          FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso","Valores nulos invalidos"));
        }
        return redireccion;
    }
}
