/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.controller;

import com.mycompany.remesasaproyect.model.Agente;
import com.mycompany.remesasaproyect.service.ServicioAgente;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dameImagenAngete")
@ApplicationScoped
public class ImagenBuscador extends HttpServlet{
    
    @Inject
    private ServicioAgente agentService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        Agente agentbyId = agentService.buscarAgente(id);
        System.out.println(agentbyId.getNombre());
        resp.resetBuffer();
        resp.getOutputStream().write(agentbyId.getFotografia());
        resp.getOutputStream().close();
    }
}
