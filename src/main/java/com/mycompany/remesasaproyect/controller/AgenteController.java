/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.controller;

import com.mycompany.remesasaproyect.model.Agente;
import com.mycompany.remesasaproyect.service.ServicioAgente;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import org.primefaces.PrimeFaces;

/**
 *
 * @author c-ado
 */
@Named("agenteController")
@javax.faces.view.ViewScoped
public class AgenteController implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Agente> agentes;
    private List<Agente> agentesFiltrados;

    public List<Agente> getAgentesFiltrados() {
        return agentesFiltrados;
    }

    public void setAgentesFiltrados(List<Agente> agentesFiltrados) {
        this.agentesFiltrados = agentesFiltrados;
    }
    private Agente agente;
    private boolean bandera;
    @Inject
    private EntityManager entityManager;

    @Inject
    private ServicioAgente servicio;

    @Inject
    private SessionController session;

    @PostConstruct
    public void init() {
        agentes = servicio.listar();
        Agente camion = entityManager.find(Agente.class, 1);
        this.agente = new Agente();
    }

    public void rediccionar(String pagina) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
     public void cargarAgente(Agente agente) {
      
        this.agente = agente;
        this.bandera = true;
    }
    
    public void crearAgente() {
        try {
            if (!existeAgente()|| bandera) {
                if (!bandera) {
                    agente.setEstado(1);
                }
                servicio.crear(this.agente);
            } else {
                FacesContext.getCurrentInstance().addMessage("registryForm",
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "El camion ya existe", ""));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            agente = new Agente();
            agentes = servicio.listar();
            PrimeFaces.current().executeScript("PF('dlgAgentes').hide()");
        }
    }

    public void limpiarComponentes() {
        this.agente = new Agente();
    }

    /**
     * Metodo que nos permite saber si el correo que se ingresa en el registro
     * ya existe
     *
     * @return {@link Boolean} con el valor true si el camion existe en la bd
     * ,caso contrario false
     */
    public boolean existeAgente() {

        for (int i = 0; i < agentes.size(); i++) {
            if (agentes.get(i).getCedula().equals(agente.getCedula())) {

                return true;

            }
        }
        return false;

    }

    public List<Agente> getAgentes() {
        return agentes;
    }

    public void setAgentes(List<Agente> agentes) {
        this.agentes = agentes;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public SessionController getSession() {
        return session;
    }

    public void setSession(SessionController session) {
        this.session = session;
    }

    /**
     * Metodo que sirve para saber si los dos campos de password coinciden
     *
     * @return
     */
}
