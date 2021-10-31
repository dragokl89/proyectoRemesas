/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.controller;

import com.mycompany.remesasaproyect.model.Agente;
import com.mycompany.remesasaproyect.service.ServicioViaje;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author c-ado
 */
@Named("viajeController")
@javax.faces.view.ViewScoped
public class ViajeController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private SessionController session;
    @Inject
    private ServicioViaje servicioCarrito;

    @PostConstruct
    public void init() {
        
    }
}
