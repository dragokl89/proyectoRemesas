/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author c-ado
 */
@Entity
@Table(name = "viaje")
@NamedQuery(name = "Viaje.findAll", query = "select E from Viaje E")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idviaje;

    @OneToMany(mappedBy = "viaje")
    private List<ViajeAgente> viajeAgentes;

    @ManyToOne
    @JoinColumn(name = "idcamion")
    private Camion camion;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    public int getIdviaje() {
        return idviaje;
    }

    public void setIdviaje(int idviaje) {
        this.idviaje = idviaje;
    }

    public List<ViajeAgente> getViajeAgentes() {
        return viajeAgentes;
    }

    public void setViajeAgentes(List<ViajeAgente> viajeAgentes) {
        this.viajeAgentes = viajeAgentes;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(Camion camion) {
        this.camion = camion;
    }
}
