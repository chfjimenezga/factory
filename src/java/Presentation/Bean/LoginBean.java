/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import BusinessLogic.Controller.LoginUsuario;

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "LoginBean")
@ViewScoped
public class LoginBean {
    private String id_usuario;
    private String contrasena;
    private String mensaje;
    
    public LoginBean(){
        mensaje="";
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public void login(){
        System.out.println("Entro al login de bean");
        LoginUsuario loginusuario = new LoginUsuario();
        mensaje = loginusuario.Login(id_usuario, contrasena);
    }
}
