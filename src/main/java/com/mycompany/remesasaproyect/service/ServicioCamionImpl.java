/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.service;

import com.mycompany.remesasaproyect.model.Camion;
import com.mycompany.remesasaproyect.model.Usuario;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author c-ado
 */
@ApplicationScoped
public class ServicioCamionImpl implements ServicioCamion {
 private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");

    @SuppressWarnings("unchecked")
    @Override
    public List<Camion> listar() {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Camion.findAll").getResultList();
    }

    @Override
    public void crear(Camion camion) {
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try {
          if (camion.getIdcamion() == 0) {
                em.persist(camion);
             
            } else {
                em.merge(camion);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public Camion actualizar(Camion camion) {
       EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        try {

            em.merge(camion);
            em.getTransaction().commit();
            return camion;
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
        em.remove(em.find(Camion.class, id));
        em.getTransaction().commit();
    }
    
}
