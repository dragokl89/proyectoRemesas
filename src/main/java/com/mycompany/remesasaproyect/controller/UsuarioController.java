/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.remesasaproyect.controller;

import com.mycompany.remesasaproyect.model.Remesa;
import com.mycompany.remesasaproyect.model.Usuario;
import com.mycompany.remesasaproyect.service.ServicioRemesa;
import com.mycompany.remesasaproyect.service.ServicioUsuario;
import com.mycompany.remesasaproyect.service.ServicioUsuarioImpl;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import org.primefaces.PrimeFaces;

/**
 *
 * @author c-ado
 */
@Named("usuarioController")
@ViewScoped
public class UsuarioController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;
    @Inject
    private ServicioRemesa servicioRemesa;
    private String nombre;
    private String contrasena;
    private List<Usuario> usuarios;
    private List<Usuario> usuariosFiltrados;
    private Usuario usuario;

    public List<Usuario> getUsuariosFiltrados() {
        return usuariosFiltrados;
    }

    public void setUsuariosFiltrados(List<Usuario> usuariosFiltrados) {
        this.usuariosFiltrados = usuariosFiltrados;
    }

  

   
    boolean bandera;
    @Inject
    private ServicioUsuario servicio;

    @Inject
    private SessionController session;

    @PostConstruct
    public void init() {
        usuarios = servicio.listar();
        
        Usuario user = entityManager.find(Usuario.class, 1);

            this.usuario = new Usuario();
        
        this.bandera = false;
 
    }
    public boolean esAdmin(Usuario aux){
        if(aux.getRol().equals("admin")){
            return true;
        }
        return false;
    }
    public void ingresar() {

        Usuario persona = coincidenCredenciales();

        if (persona != null) {
            if (persona.getRol().equals("admin")) {
                session.setUsuario(persona);
                
                rediccionar("adminUsuarios.xhtml");
            } else {
                session.setUsuario(persona);
                System.out.println(session.getUsuario().getNombre());
                rediccionar("clientes.xhtml");
            }
        } else {
            FacesContext.getCurrentInstance().addMessage("loginForm",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "No coinciden las credenciales", ""));

        }

    }
    

    /**
     * Metodo que redireccion a la persona a la pagina deseada
     *
     * @param pagina {@link String} direccion de la pagina a ingresar
     */
    public void rediccionar(String pagina) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Metodo que nos permite verificar si las credenciales ingresadas por el
     * usuario tienen coincidencias
     *
     * @return {@link Usuario} persona registrada con la base de datos que
     * coincide con las credenciales ingresadas
     */
    public Usuario coincidenCredenciales() {

        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i).getNombre().equalsIgnoreCase(nombre)
                    && usuarios.get(i).getContrasena().equals(contrasena)) {
                return usuarios.get(i);
            }

        }
        System.out.println("no papu");
        return null;

    }

    /**
     * Metodo que nos permite crear una persona
     */
    public void crearUsuario() {

        try {
            System.out.println("Hola mundo2");
            if (!existeUsuario() || bandera) {
                if (!bandera) {
                    usuario.setEstado(true);
                }
                servicio.crear(usuario);
            } else {
                FacesContext.getCurrentInstance().addMessage("registryForm",
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario ya existe", ""));
            }

        } catch (Exception e) {
            System.out.println("F papu");
        } finally {
            usuario = new Usuario();
            usuarios = servicio.listar();
            PrimeFaces.current().executeScript("PF('dlgAlbums').hide()");
            this.bandera=false;
        }

    }

    public void cargarUsuario(Usuario usuario) {

        this.usuario = usuario;
        this.bandera = true;
    }

    /**
     * Metodo que nos permite saber si el correo que se ingresa en el registro
     * ya existe
     *
     * @return {@link Boolean} con el valor true si el usuario existe en la bd
     * ,caso contrario false
     */
    public boolean existeUsuario() {

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombre().equals(usuario.getNombre())) {
                return true;
            }
        }
        return false;

    }

    public void limpiarComponentes() {
        System.out.println("Limpieza");
        this.usuario = new Usuario();
    }

    /**
     * Metodo que sirve para saber si los dos campos de password coinciden
     *
     * @return
     */
    public boolean coincidenPasswords() {
        if (contrasena.equals(usuario.getContrasena())) {
            return true;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public SessionController getSession() {
        return session;
    }

    public void setSession(SessionController session) {
        this.session = session;
    }
    
    public void eliminarUsuario(Usuario us){
        
        us.setEstado(false);
        this.usuario=us;
        servicio.crear(this.usuario);
        this.usuarios = servicio.listar();
        
    }
}
