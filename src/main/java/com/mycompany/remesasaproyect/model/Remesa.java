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
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author c-ado
 */
@Entity
@Table(name = "remesa")
@NamedQuery(name = "Remesa.findAll", query = "select E from Remesa E")
public class Remesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idremesa;

    @ManyToOne
    @JoinColumn(name = "idviaje")
    private Viaje viaje;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idempresa")
    private Empresa empresa;
    
    @Column
    private double valor;

    @Column
    private String tipo;
    
    @Column
    private String estado;
}
