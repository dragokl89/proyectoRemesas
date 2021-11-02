/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.service;

import com.mycompany.remesasaproyect.model.Usuario;
import java.time.LocalDateTime;
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
public class ServicioUsuarioImpl implements ServicioUsuario {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");

    @SuppressWarnings("unchecked")
    @Override
    public List<Usuario> listar() {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public void crear(Usuario persona) {

        EntityManager em = emf.createEntityManager();
        //persona.setRol("cliente");
        em.getTransaction().begin();
        try {
            if (persona.getIdUsuario() == 0) {
                em.persist(persona);
             
            } else {
                em.merge(persona);
            }
            em.getTransaction().commit();
        } catch (Exception e) {

            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public Usuario actualizar(Usuario persona) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        try {

            em.merge(persona);
            em.getTransaction().commit();
            return persona;
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
        em.remove(em.find(Usuario.class, id));
        em.getTransaction().commit();
    }

}
