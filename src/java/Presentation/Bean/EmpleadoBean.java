/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Bean;

import BusinessLogic.Controller.EmpleadoController;
import DataAccess.Entity.Materia;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "EmpleadoBean")
//@RequestScoped
@SessionScoped
public class EmpleadoBean {
        
    private String id_usuario;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
    private static ArrayList<Materia> materias = new ArrayList<Materia>();
    
    public EmpleadoBean(){
        faceContext=FacesContext.getCurrentInstance();
        httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
        if(httpServletRequest.getSession().getAttribute("sessionUsuario")!=null)
        {
            id_usuario=httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
            materias = new ArrayList<Materia>();
        }
    }
    
    
    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public ArrayList<Materia> getMaterias() {
      return materias;
   }
    
    public String logout()
    {
        httpServletRequest.getSession().removeAttribute("sessionUsuario");
        facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO, "Session cerrada correctamente", null);
        faceContext.addMessage(null, facesMessage);
        materias = new ArrayList<Materia>();
        return "index";
    }
    
    public void buscaMateria(){
        EmpleadoController empleadoController = new EmpleadoController();
        
        materias = new ArrayList<Materia>();
        System.out.println("DA CLICK A BEAN");
        materias = empleadoController.listarMaterias();
        
    }
}
