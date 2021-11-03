/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.service;

import com.mycompany.remesasaproyect.model.Agente;
import com.mycompany.remesasaproyect.model.Usuario;
import java.util.List;

/**
 *
 * @author c-ado
 */
public interface ServicioAgente {
    List<Agente> listar();

	void crear(Agente agente);

	Agente actualizar(Agente agente);

	void eliminar(int id);
        
        Agente buscarAgente(int id);
}
