/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.controller;


import com.mycompany.remesasaproyect.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named
public class Test implements Serializable {
    
    private String nombre="";
    @Inject
    private EntityManager entityManager;
    
    @PostConstruct
    public void init(){
        Usuario user=entityManager.find(Usuario.class, 1);
        nombre=user.getNombre();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
