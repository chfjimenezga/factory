/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Bean;

import BusinessLogic.Controller.AdministradorController;
import BusinessLogic.Controller.LoginUsuario;
import DataAccess.Entity.Materia;
import DataAccess.Entity.Usuario;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Usuario
 */
@ManagedBean(name = "AdministradorBean")
@RequestScoped
public class AdministradorBean {
    
    private String id_usuario;
    private String nombre_usuario;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
    private static ArrayList<Materia> materias = new ArrayList<Materia>();
    private static ArrayList<Usuario> empleados = new ArrayList<Usuario>();
    
    public AdministradorBean(){
        faceContext=FacesContext.getCurrentInstance();
        httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
        if(httpServletRequest.getSession().getAttribute("sessionUsuario")!=null)
        {
            id_usuario=httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
            LoginUsuario loginUsuario = new LoginUsuario();
            nombre_usuario = loginUsuario.nombre(id_usuario);
            materias = new ArrayList<Materia>();
        }
    }
    
    
    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    
    public ArrayList<Materia> getMaterias() {
      return materias;
   }
    
    public ArrayList<Usuario> getEmpleados() {
      return empleados;
   }
       
    public String logout()
    {
        httpServletRequest.getSession().removeAttribute("sessionUsuario");
        facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO, "Session cerrada correctamente", null);
        faceContext.addMessage(null, facesMessage);
        materias = new ArrayList<Materia>();
        System.out.println("CARAJO");
        return "index";
    }
    /*
    public void buscaMateria(){
        AdministradorController administradorController = new AdministradorController();
        
        Materia materia = new  Materia();
        materias = new ArrayList<Materia>();
        
        int i=1;
        while(administradorController.existeMateria(i)){
            materia = administradorController.listaMateria(i);
            materias.add(materia);
            i++;
        }
        
    }*/
    public void buscaMateria(){
        AdministradorController administradorController = new AdministradorController();
        
        materias = new ArrayList<Materia>();
        System.out.println("DA CLICK A BEAN");
        materias = administradorController.todasMaterias();
        
    }
    
    public void buscaEmpleados(){
        AdministradorController administradorController = new AdministradorController();
        
        empleados = new ArrayList<Usuario>();
        empleados = administradorController.empleados();
        
    }
    
}
