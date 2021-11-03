/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.service;

import com.mycompany.remesasaproyect.model.Remesa;
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
public class ServicioRemesaImpl implements ServicioRemesa {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");

    @Inject
    EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Remesa> listar() {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Remesa.findAll").getResultList();
    }

    @Override
    public void crear(Remesa remesa) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        try {
            if (remesa.getIdremesa() == 0) {
                em.persist(remesa);
            } else {
                em.merge(remesa);
            }
            em.getTransaction().commit();
        } catch (Exception e) {

            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Remesa> listar(Usuario usr) {
        int gender;
        gender = usr.getIdUsuario();
        return em.createQuery("select E from Remesa E WHERE E.usuario = :usr",Remesa.class).setParameter("usr", usr).getResultList();
    }

}
