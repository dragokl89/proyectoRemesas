/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.controller;

import com.mycompany.remesasaproyect.model.Camion;
import com.mycompany.remesasaproyect.model.Usuario;
import com.mycompany.remesasaproyect.service.ServicioCamion;
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
@Named("camionController")
@javax.faces.view.ViewScoped
public class CamionController implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Camion> camiones;
    private List<Camion> camionesFiltrados;

    public List<Camion> getCamionesFiltrados() {
        return camionesFiltrados;
    }

    public void setCamionesFiltrados(List<Camion> camionesFiltrados) {
        this.camionesFiltrados = camionesFiltrados;
    }


    private Camion camion;
    private boolean bandera;
    @Inject
    private EntityManager entityManager;

    @Inject
    private ServicioCamion servicio;

    @Inject
    private SessionController session;

    @PostConstruct
    public void init() {
        camiones = servicio.listar();
        Camion camion = entityManager.find(Camion.class, 1);
        this.camion = new Camion();
    }

    public void rediccionar(String pagina) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void crearCamion() {
        try {
            if (!existeCamion() || bandera) {
                servicio.crear(camion);
            } else {
                FacesContext.getCurrentInstance().addMessage("registryForm",
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "El camion ya existe", ""));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            camion = new Camion();
            camiones = servicio.listar();
            PrimeFaces.current().executeScript("PF('dlgCamiones').hide()");
            this.bandera = false;
        }
    }

    public void limpiarComponentes() {
        this.camion = new Camion();
    }

    /**
     * Metodo que nos permite saber si el correo que se ingresa en el registro
     * ya existe
     *
     * @return {@link Boolean} con el valor true si el camion existe en la bd
     * ,caso contrario false
     */
    public boolean existeCamion() {

        for (int i = 0; i < camiones.size(); i++) {
            if (camiones.get(i).getPlaca().equals(camion.getPlaca())) {
                if (camiones.get(i).getNumUnidad().equals(camion.getNumUnidad())) {
                    return true;
                }
            }
        }
        return false;

    }

   
    public void cargarCamion(Camion camion) {

        this.camion = camion;
        this.bandera = true;
    }

    /**
     * Metodo que sirve para saber si los dos campos de password coinciden
     *
     * @return
     */
    public List<Camion> getCamiones() {
        return camiones;
    }

    public void setCamiones(List<Camion> camiones) {
        this.camiones = camiones;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    public SessionController getSession() {
        return session;
    }

    public void setSession(SessionController session) {
        this.session = session;
    }

}
