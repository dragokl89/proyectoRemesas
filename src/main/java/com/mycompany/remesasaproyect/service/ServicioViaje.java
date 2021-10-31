/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.service;

import com.mycompany.remesasaproyect.model.Remesa;
import com.mycompany.remesasaproyect.model.Viaje;
import com.mycompany.remesasaproyect.model.ViajeAgente;
import java.util.List;

/**
 *
 * @author c-ado
 */
public interface ServicioViaje {
    
    List<Viaje> listar();
    
    void agregarViaje(Viaje viaje);
    void agregarAgente(ViajeAgente viajeAgente);
	/**
	 * Metodo que calcula el total de la compra en el carrito del cliente
	 * @param items {@link List<CarritoProdcuto>} lista de productos que esta en el carrito
	 * @return
	 */
	
	void eliminarViajeAgente(ViajeAgente viajeAgente);
	/**
	 * Metodo que sirve para cambiar la cantidad de un producto en el carrito en la bd
	 * @param item {@link CarritoProducto} producto a cambiar la cantidad 
	 */
	void actualizarViajeAgente(ViajeAgente viajeAgente);
	/**
	 * Metodo que sirve para refrescar los productos del carrito despeus de ser pagados  en la bd
	 * @param items {@link List<CarritoProducto>} lista de los producto del carrito a refrescar
	 * @param factura {@link Factura} factura asociada a la la compra 
	 * @return
	 */
	
}
