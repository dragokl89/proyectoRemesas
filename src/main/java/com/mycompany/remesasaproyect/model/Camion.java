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
import javax.persistence.NamedQuery;

/**
 *
 * @author c-ado
 */
@Entity
@NamedQuery(name = "Camion.findAll", query = "select E from Camion E")
public class Camion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idcamion;
    @Column
    private String placa;
    @Column
    private String numUnidad;
    @Column
    private String marca;
    @Column
    private String color;
    @Column
    private String modelo;
    @Column
    private String tipo;

    public int getIdcamion() {
        return idcamion;
    }

    public void setIdcamion(int idcamion) {
        this.idcamion = idcamion;
    }

    

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNumUnidad() {
        return numUnidad;
    }

    public void setNumUnidad(String numUnidad) {
        this.numUnidad = numUnidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

  

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
