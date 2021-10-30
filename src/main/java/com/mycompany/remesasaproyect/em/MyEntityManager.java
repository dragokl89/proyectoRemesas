/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.em;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author pablo
 */
@ApplicationScoped
@Named
public class MyEntityManager {
    
    @ApplicationScoped
    @Produces
    public EntityManager entityManager(){
        return Persistence.createEntityManagerFactory("my_persistence_unit").createEntityManager();
    }
    
}
