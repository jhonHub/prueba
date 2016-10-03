/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orprovisa.ejb;

import com.orprovisa.model.Permisorol;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class PermisorolFacade extends AbstractFacade<Permisorol> {

    @PersistenceContext(unitName = "orprovisaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PermisorolFacade() {
        super(Permisorol.class);
    }
    
}
