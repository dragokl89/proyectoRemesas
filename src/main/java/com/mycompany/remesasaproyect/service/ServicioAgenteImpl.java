/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.service;

import com.mycompany.remesasaproyect.model.Agente;
import com.mycompany.remesasaproyect.model.Agente;
import com.mycompany.remesasaproyect.model.Remesa;
import com.mycompany.remesasaproyect.model.Usuario;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author c-ado
 */
@ApplicationScoped
public class ServicioAgenteImpl implements ServicioAgente {
 private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
      @Inject
    EntityManager em;
    @SuppressWarnings("unchecked")
    @Override
    public List<Agente> listar() {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Agente.findAll").getResultList();
    }

    @Override
    public void crear(Agente agente) {
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try {
           if (agente.getIdagente() == 0) {
                em.persist(agente);
             
            } else {
                em.merge(agente);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public Agente actualizar(Agente agente) {
       EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        try {

            em.merge(agente);
            em.getTransaction().commit();
            return agente;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        } finally {

        }
    }

    @Override
    public void eliminar(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Agente.class, id));
        em.getTransaction().commit();
    }

    @Override
    public Agente buscarAgente(int i) {
        EntityManager em = emf.createEntityManager();
        return em.find(Agente.class, i);
    }
    
}
