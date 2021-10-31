/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author c-ado
 */
@Entity
@Table(name = "viaje_agente")
public class ViajeAgente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idviaje_agente;

    @ManyToOne
    @JoinColumn(name = "idviaje")
    private Viaje viaje;

    @ManyToOne
    @JoinColumn(name = "idagente")
    private Agente agente;

    public int getIdviaje_agente() {
        return idviaje_agente;
    }

    public void setIdviaje_agente(int idviaje_agente) {
        this.idviaje_agente = idviaje_agente;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }
}
