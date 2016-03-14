/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import BusinessLogic.Controller.LoginUsuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "LoginBean")
@RequestScoped
public class LoginBean {
    private String id_usuario;
    private String contrasena;
    private String mensaje;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;

    
    public LoginBean(){
        mensaje="";
        faceContext=FacesContext.getCurrentInstance();
        httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
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
    
    public String login(){
        System.out.println("Entro al login de bean");
        LoginUsuario loginUsuario = new LoginUsuario();
        
        if (loginUsuario.Login(id_usuario, contrasena)){
            httpServletRequest.getSession().setAttribute("sessionUsuario", id_usuario);
            facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Correcto", null);
            faceContext.addMessage(null, facesMessage);
            return loginUsuario.Rol(id_usuario);
        }else{
            FacesMessage fm = new FacesMessage("Error de login, verifique información","ERROR MSG");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "index";
        }
    }
}
