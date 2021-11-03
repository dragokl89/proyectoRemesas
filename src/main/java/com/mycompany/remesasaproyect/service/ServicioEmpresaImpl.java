/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.service;

import com.mycompany.remesasaproyect.model.Empresa;
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
public class ServicioEmpresaImpl implements ServicioEmpresa {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Empresa> listar() {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Empresa.findAll").getResultList();
    }
    
}
