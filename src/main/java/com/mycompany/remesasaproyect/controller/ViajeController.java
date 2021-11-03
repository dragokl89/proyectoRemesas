/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.controller;

import com.mycompany.remesasaproyect.model.Agente;
import com.mycompany.remesasaproyect.model.Camion;
import com.mycompany.remesasaproyect.model.Remesa;
import com.mycompany.remesasaproyect.model.Usuario;
import com.mycompany.remesasaproyect.model.Viaje;
import com.mycompany.remesasaproyect.model.ViajeAgente;
import com.mycompany.remesasaproyect.service.ServicioAgente;
import com.mycompany.remesasaproyect.service.ServicioCamion;
import com.mycompany.remesasaproyect.service.ServicioRemesa;
import com.mycompany.remesasaproyect.service.ServicioViaje;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

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
    private ServicioViaje servicioViaje;
    @Inject
    private ServicioRemesa servicioRemesa;

    @Inject
    private ServicioCamion servicioCamion;
    @Inject
    private ServicioAgente servicioAgente;

    private List<Remesa> remesas;

    private List<Remesa> remesasFiltradas;

    private List<Viaje> viajes;

    private List<Agente> agentes;

    private List<Camion> camiones;

    private Remesa remesa;
    private Viaje viaje;
    private Agente piloto;
    private Agente escolta;
    private Camion camion;
    private Date fecha;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    @PostConstruct
    public void init() {
        this.remesas = servicioRemesa.listar();
        this.viajes = servicioViaje.listar();
        this.agentes = servicioAgente.listar();
        this.camiones = servicioCamion.listar();
        this.remesa = new Remesa();
        this.viaje = new Viaje();
        this.piloto = new Agente();
        this.escolta = new Agente();
        this.camion = new Camion();
        this.bandera = false;
    }

    public void aprobarRemesa() {
        try {
            
            this.viaje.setCamion(camion);
            servicioViaje.agregarViaje(this.viaje);

            ViajeAgente viajePiloto = new ViajeAgente();
            viajePiloto.setViaje(this.viaje);
            viajePiloto.setAgente(this.piloto);
            this.servicioViaje.agregarAgente(viajePiloto);

            ViajeAgente viajeEscolta = new ViajeAgente();
            viajeEscolta.setViaje(this.viaje);
            viajeEscolta.setAgente(this.escolta);
            this.servicioViaje.agregarAgente(viajeEscolta);

            this.remesa.setViaje(this.viaje);
            remesa.setEstado("Aprobada");
            servicioRemesa.crear(remesa);
        } catch (Exception e) {
            System.out.println("F papu");
        } finally {
            remesa = new Remesa();
            remesas = servicioRemesa.listar();
            PrimeFaces.current().executeScript("PF('dlgRemesas').hide()");
            this.bandera = false;
        }
    }
    
    public void rechazarRemesa() {
        try {
            remesa.setEstado("Rechazada");
            servicioRemesa.crear(remesa);
        } catch (Exception e) {
            System.out.println("F papu");
        } finally {
            remesa = new Remesa();
            remesas = servicioRemesa.listar();
            PrimeFaces.current().executeScript("PF('dlgRemesas').hide()");
            this.bandera = false;
        }
    }

    
    public boolean esPiloto(Agente agen){
        if(agen.getTipo().equals("Conductor")){
            return true;
        }
        return false;
    }
    
    public void cargarRemesa(Remesa remesa) {
    this.remesa = remesa;
    }

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

    public List<Agente> getAgentes() {
        return agentes;
    }

    public void setAgentes(List<Agente> agentes) {
        this.agentes = agentes;
    }

    public Agente getPiloto() {
        return piloto;
    }

    public void setPiloto(Agente piloto) {
        this.piloto = piloto;
    }

    public Agente getEscolta() {
        return escolta;
    }

    public void setEscolta(Agente escolta) {
        this.escolta = escolta;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    private boolean bandera;

    public ServicioRemesa getServicioRemesa() {
        return servicioRemesa;
    }

    public void setServicioRemesa(ServicioRemesa servicioRemesa) {
        this.servicioRemesa = servicioRemesa;
    }

    public SessionController getSession() {
        return session;
    }

    public void setSession(SessionController session) {
        this.session = session;
    }

    public ServicioViaje getServicioViaje() {
        return servicioViaje;
    }

    public void setServicioViaje(ServicioViaje servicioViaje) {
        this.servicioViaje = servicioViaje;
    }

    public List<Remesa> getRemesas() {
        return remesas;
    }

    public void setRemesas(List<Remesa> remesas) {
        this.remesas = remesas;
    }

    public List<Remesa> getRemesasFiltradas() {
        return remesasFiltradas;
    }

    public void setRemesasFiltradas(List<Remesa> remesasFiltradas) {
        this.remesasFiltradas = remesasFiltradas;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
    }

    public Remesa getRemesa() {
        return remesa;
    }

    public void setRemesa(Remesa remesa) {
        this.remesa = remesa;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

}
