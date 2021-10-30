/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.service;

import com.mycompany.remesasaproyect.model.Usuario;
import java.util.List;

/**
 *
 * @author c-ado
 */
public interface ServicioUsuario {

	List<Usuario> listar();

	void crear(Usuario persona);

	Usuario actualizar(Usuario persona);

	void eliminar(int id);
	
}
