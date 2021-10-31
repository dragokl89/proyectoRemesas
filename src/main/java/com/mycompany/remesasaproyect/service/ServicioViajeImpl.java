/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.service;

import com.mycompany.remesasaproyect.model.Remesa;
import com.mycompany.remesasaproyect.model.ViajeAgente;
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
public class ServicioViajeImpl implements ServicioViaje {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
    
    @Override
    public void agregarAgente(ViajeAgente viajeAgente) {
      EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(viajeAgente);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
    }

    @Override
    public void eliminarViajeAgente(ViajeAgente viajeAgente) {
        EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		try {
			em.remove(em.find(ViajeAgente.class,viajeAgente.getIdviaje_agente()));
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
    }

    @Override
    public void actualizarViajeAgente(ViajeAgente viajeAgente) {
       EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(viajeAgente);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
    }

}
