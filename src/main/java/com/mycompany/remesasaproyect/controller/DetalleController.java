/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.controller;

import com.mycompany.remesasaproyect.model.Agente;
import com.mycompany.remesasaproyect.model.Camion;
import com.mycompany.remesasaproyect.model.Remesa;
import com.mycompany.remesasaproyect.model.Viaje;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Named("detalleController")
@javax.faces.view.ViewScoped
public class DetalleController implements Serializable {

    private Agente conductor;
    private Agente escolta;
    private Remesa remesa;
    private Camion camion;
    private Viaje viaje;
    @Inject
    private SessionController session;

    @PostConstruct
    public void init() {
        this.remesa = session.getRemesa();
        System.out.println(remesa.getTipo());
        this.conductor= remesa.getViaje().getViajeAgentes().get(0).getAgente();
        this.escolta= remesa.getViaje().getViajeAgentes().get(1).getAgente();
        this.camion = remesa.getViaje().getCamion();
        this.viaje = remesa.getViaje();
    }
    
    

    public Agente getConductor() {
        return conductor;
    }

    public void setConductor(Agente conductor) {
        this.conductor = conductor;
    }

    public Agente getEscolta() {
        return escolta;
    }

    public void setEscolta(Agente escolta) {
        this.escolta = escolta;
    }

    public Remesa getRemesa() {
        return remesa;
    }

    public void setRemesa(Remesa remesa) {
        this.remesa = remesa;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public SessionController getSession() {
        return session;
    }

    public void setSession(SessionController session) {
        this.session = session;
    }
}
