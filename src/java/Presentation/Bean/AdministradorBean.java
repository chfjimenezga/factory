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
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Usuario
 */
@ManagedBean(name = "AdministradorBean")
//@RequestScoped
//@ViewScoped
@ApplicationScoped
//@SessionScoped
public class AdministradorBean {
    
    private String id_usuario;
    private String nombre_usuario;
    private int materiaID;
    private String materiaNombre;
    private String materiaDescripcion;
    private String materiaUnidad;
    private int materiaCantidad;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
    private static ArrayList<Materia> materias = new ArrayList<Materia>();
    private static ArrayList<Usuario> empleados = new ArrayList<Usuario>();
    private String empleadoID;
    private String empleadoNombre;
    private String empleadoContrasenia;
            
    public AdministradorBean(){
        faceContext=FacesContext.getCurrentInstance();
        httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
        if(httpServletRequest.getSession().getAttribute("sessionUsuario")!=null)
        {
            id_usuario=httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
            LoginUsuario loginUsuario = new LoginUsuario();
            nombre_usuario = loginUsuario.nombre(id_usuario);
            materias = new ArrayList<Materia>();
            empleados = new ArrayList<Usuario>();
            empleadoID = "";
            empleadoNombre = "";
            empleadoContrasenia = "";
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
    
    
    public String getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(String empleadoID) {
        this.empleadoID = empleadoID;
    }

    public String getEmpleadoNombre() {
        return empleadoNombre;
    }

    public void setEmpleadoNombre(String empleadoNombre) {
        this.empleadoNombre = empleadoNombre;
    }

    public String getEmpleadoContrasenia() {
        return empleadoContrasenia;
    }

    public void setEmpleadoContrasenia(String empleadoContrasenia) {
        this.empleadoContrasenia = empleadoContrasenia;
    }

    public int getMateriaID() {
        return materiaID;
    }

    public void setMateriaID(int materiaID) {
        this.materiaID = materiaID;
    }

    public String getMateriaNombre() {
        return materiaNombre;
    }

    public void setMateriaNombre(String materiaNombre) {
        this.materiaNombre = materiaNombre;
    }

    public String getMateriaDescripcion() {
        return materiaDescripcion;
    }

    public void setMateriaDescripcion(String materiaDescripcion) {
        this.materiaDescripcion = materiaDescripcion;
    }

    public String getMateriaUnidad() {
        return materiaUnidad;
    }

    public void setMateriaUnidad(String materiaUnidad) {
        this.materiaUnidad = materiaUnidad;
    }

    public int getMateriaCantidad() {
        return materiaCantidad;
    }

    public void setMateriaCantidad(int materiaCantidad) {
        this.materiaCantidad = materiaCantidad;
    }
    
    
       /*
    public String logout()
    {
        httpServletRequest.getSession().removeAttribute("sessionUsuario");
        facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO, "Session cerrada correctamente", null);
        faceContext.addMessage(null, facesMessage);
        materias = new ArrayList<Materia>();
        empleados = new ArrayList<Usuario>();
        return "index";
    }*/
        
    public void buscaMateria(){
        AdministradorController administradorController = new AdministradorController();
        
        //iniciarTablas();
        materias = administradorController.todasMaterias();
        
    }
    
    public void buscaEmpleados(){
        AdministradorController administradorController = new AdministradorController();
        
        //iniciarTablas();
        empleados = administradorController.empleados();
        //empleadoID = "segundo";
        
    }
    
    public String editarEmpleado(String idUsuario){
        System.out.println(idUsuario);
        Usuario empleado = new Usuario();
        AdministradorController administradorController = new AdministradorController();
        empleado = administradorController.buscarEmpleado(idUsuario);
        empleadoID = empleado.getIdUsuario();
        empleadoNombre = empleado.getNombre();
        setEmpleadoNombre(empleadoNombre);
        empleadoContrasenia = empleado.getContraseña();
        iniciarTablas();
        return "EditarEmpleado";
    }
    
    public String salvarEmpleado(){
        AdministradorController administradorController = new AdministradorController();
        administradorController.editarEmpleado(empleadoID, empleadoNombre, empleadoContrasenia);
        iniciarTablas();
        return "Administrador";
    }
    
    public void iniciarTablas(){
        materias = new ArrayList<Materia>();
        empleados = new ArrayList<Usuario>();
    }
    
    public String eliminarEmpleado(String idUsuario){
        AdministradorController administradorController = new AdministradorController();
        administradorController.eliminarEmpleado(idUsuario);
        return "Administrador";
    }
    
    public String insertarEmpleado(){
        AdministradorController administradorController = new AdministradorController();
        administradorController.insertarEmpleado(empleadoID, empleadoNombre, empleadoContrasenia);
        return "Administrador";
    }
    
    public void limpiarEmpleado(){
        empleadoID="";
        empleadoNombre="";
        empleadoContrasenia="";
    }
        
    public String editarMateria(int idMateria){
        Materia materia = new Materia();
        AdministradorController administradorController = new AdministradorController();
        materia = administradorController.buscarMateria(idMateria);
        materiaID = materia.getIdMateria();
        materiaNombre = materia.getNombre();
        materiaDescripcion = materia.getDescripcion();
        materiaUnidad = materia.getUnidadDeMedida();
        materiaCantidad = materia.getCantidadDisponible();
        iniciarTablas();
        return "EditarMateria";
    }
    
    public String salvarMateria(){
        AdministradorController administradorController = new AdministradorController();
        administradorController.editarMateria(materiaID, materiaNombre, materiaCantidad, materiaDescripcion, materiaUnidad);
        iniciarTablas();
        return "Administrador";
    }
    
    public String insertarMateria(){
        AdministradorController administradorController = new AdministradorController();
        administradorController.insertarMateria(materiaID, materiaNombre, materiaCantidad, materiaDescripcion,materiaUnidad);
        return "Administrador";
    }
    
    public void limpiarMateria(){
        materiaID = 0;
        materiaNombre = "";
        materiaCantidad = 0;
        materiaDescripcion = "";
        materiaUnidad = "";
    }
    
    public String eliminarMateria(Integer idMateria){
        AdministradorController administradorController = new AdministradorController();
        administradorController.eliminarMateria(idMateria);
        return "Administrador";
    }
    
}
