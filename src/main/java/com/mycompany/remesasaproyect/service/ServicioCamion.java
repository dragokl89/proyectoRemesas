/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.service;

import com.mycompany.remesasaproyect.model.Camion;
import java.util.List;

/**
 *
 * @author c-ado
 */
public interface ServicioCamion {

    List<Camion> listar();

    void crear(Camion camion);

    Camion actualizar(Camion camion);

    void eliminar(int id);
}
