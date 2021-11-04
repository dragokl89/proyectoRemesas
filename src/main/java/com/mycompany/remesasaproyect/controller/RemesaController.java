/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.controller;

import com.mycompany.remesasaproyect.model.Agente;
import com.mycompany.remesasaproyect.model.Camion;
import com.mycompany.remesasaproyect.model.Empresa;
import com.mycompany.remesasaproyect.model.Remesa;
import com.mycompany.remesasaproyect.model.Usuario;
import com.mycompany.remesasaproyect.model.Viaje;
import com.mycompany.remesasaproyect.service.ServicioEmpresa;
import com.mycompany.remesasaproyect.service.ServicioRemesa;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
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
    private ServicioRemesa servicioRemesa;
    @Inject
    private ServicioEmpresa servicioEmpresa;
    @Inject
    private SessionController session;
    private Remesa remesa;
    private Usuario usuario;
    private List<Remesa> remesas;
    private List<Remesa> remesasFiltradas;
    private List<Empresa> empresas;
    private Empresa empresa;
    private Agente conductor;
    private Agente escolta;
    private Camion camion;
    private Viaje viaje;

    public Agente getEscolta() {
        return escolta;
    }

    public void setEscolta(Agente escolta) {
        this.escolta = escolta;
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
    
    
    public Agente getConductor() {
        return conductor;
    }

    public void setConductor(Agente conductor) {
        this.conductor = conductor;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @PostConstruct
    public void init() {
        this.remesa = new Remesa();
        this.usuario = session.getUsuario();
        this.remesas = servicioRemesa.listar(usuario);
        this.empresas = servicioEmpresa.listar();
        this.empresa = new Empresa();
    }

   public void cargarRemesa(Remesa rem){
       this.remesa = rem;
       this.conductor= remesa.getViaje().getViajeAgentes().get(0).getAgente();
       this.escolta= remesa.getViaje().getViajeAgentes().get(1).getAgente();
       this.camion=remesa.getViaje().getCamion();
       this.viaje = remesa.getViaje();
   }

    public void creaRemesa() throws IOException {
       
        try {
            this.remesa.setEstado("espera");
            this.remesa.setUsuario(this.usuario);
            this.remesa.setEmpresa(empresa);
            servicioRemesa.crear(remesa);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            remesa = new Remesa();
            System.out.println(usuario.getNombre());
            remesas =servicioRemesa.listar(usuario);
            System.out.println("Largo:"+remesas.size());
            PrimeFaces.current().executeScript("PF('dlgRemesas').hide()");
            this.bandera = false;
        }
    }

    public ServicioRemesa getServicioRemesa() {
        return servicioRemesa;
    }

    public void setServicioRemesa(ServicioRemesa servicioRemesa) {
        this.servicioRemesa = servicioRemesa;
    }

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

    public List<Remesa> getRemesasFiltradas() {
        return remesasFiltradas;
    }

    public ServicioEmpresa getServicioEmpresa() {
        return servicioEmpresa;
    }

    public void setServicioEmpresa(ServicioEmpresa servicioEmpresa) {
        this.servicioEmpresa = servicioEmpresa;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public void setRemesasFiltradas(List<Remesa> remesasFiltradas) {
        this.remesasFiltradas = remesasFiltradas;
    }
    boolean bandera;

    public Remesa getRemesa() {
        return remesa;
    }

    public void setRemesa(Remesa remesa) {
        this.remesa = remesa;
    }
}
