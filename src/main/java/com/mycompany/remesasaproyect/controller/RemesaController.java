/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.controller;

import com.mycompany.remesasaproyect.model.Remesa;
import com.mycompany.remesasaproyect.model.Usuario;
import com.mycompany.remesasaproyect.service.ServicioRemesa;
import com.mycompany.remesasaproyect.service.ServicioUsuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import org.primefaces.PrimeFaces;

/**
 *
 * @author c-ado
 */
@Named("remesaController")
@ViewScoped
public class RemesaController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Remesa> getRemesas() {
        return remesas;
    }

    public void setRemesas(List<Remesa> remesas) {
        this.remesas = remesas;
    }

    public SessionController getSession() {
        return session;
    }

    public void setSession(SessionController session) {
        this.session = session;
    }

    private Usuario usuario;
    private List<Remesa> remesas; 
    

    boolean bandera;
    @Inject
    private ServicioRemesa servicio;

    @Inject
    private SessionController session;

    @PostConstruct
    public void init() {
        remesas = servicio.listar();

    }



}
