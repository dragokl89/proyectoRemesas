/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.controller;

import com.mycompany.remesasaproyect.model.Remesa;
import com.mycompany.remesasaproyect.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("sessionController")
@SessionScoped
public class SessionController implements Serializable {

    private static final long serialVersionUID = 1L;
    private Usuario usuario;
    private Remesa remesa;

    public Remesa getRemesa() {
        return remesa;
    }

    public void setRemesa(Remesa remesa) {
        this.remesa = remesa;
    }

    @PostConstruct
    public void init() {
        System.out.println("***********************************");
        System.out.println("ingresamos a una nueva sesion");
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
