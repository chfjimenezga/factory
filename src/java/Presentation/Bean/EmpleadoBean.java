/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Bean;

import BusinessLogic.Controller.EmpleadoController;
import DataAccess.Entity.Materia;
import DataAccess.Entity.Pedido;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "EmpleadoBean")
@ApplicationScoped
//@SessionScoped
public class EmpleadoBean {
        
    private String id_usuario;
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    private FacesMessage facesMessage;
    private static ArrayList<Pedido> pedidos = new ArrayList<>();
    private static ArrayList<Materia> materias = new ArrayList<>();
    private static Materia materia;
    private int id_pedido;
    private String fecha;
    private int cantidad;
    private String estado;
    private Materia materiaPedido;
    
    
    public EmpleadoBean(){
        
        faceContext=FacesContext.getCurrentInstance();
        httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
        id_usuario = "";
        if(httpServletRequest.getSession().getAttribute("sessionUsuario")!=null)
        {
            id_usuario=httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
            materias = new ArrayList<>();
            pedidos = new ArrayList<>();
            id_pedido=0;
            fecha = "";
            cantidad =0;
            estado ="";
            materiaPedido = new Materia();
            
        }
    }      
    
    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public static Materia getMateria() {
        return materia;
    }

    public static void setMateria(Materia materia) {
        EmpleadoBean.materia = materia;
    }
     
    public ArrayList<Materia> getMaterias() {
      return materias;
   }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        EmpleadoBean.pedidos = pedidos;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Materia getMateriaPedido() {
        return materiaPedido;
    }

    public void setMateriaPedido(Materia materiaPedido) {
        this.materiaPedido = materiaPedido;
    }
          
    public void listaMaterias(){
        EmpleadoController empleadoController = new EmpleadoController();
        materias = new ArrayList<>();
        materias = empleadoController.listarMaterias();
        //return "EmpleadoMaterias";
    }
    
    public void listaPedidos(){
        EmpleadoController empleadoController = new EmpleadoController();
        pedidos = new ArrayList<>();
        pedidos = empleadoController.listarPedidos();
        //return "EmpleadoMaterias";
    }
    
    public String logout(){
        materias = new ArrayList<>();
        pedidos = new ArrayList<>();
        LoginBean loginBean = new LoginBean();
        return loginBean.logout();
    }
    
    public String buscaMateria(Materia id_Mat){
        EmpleadoController empleadoController = new EmpleadoController();
        materia = empleadoController.materia(id_Mat.getIdMateria());
        return materia.getNombre();
    }
    
    public String conFormato(Date fecha){
         SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
         String fecha2 = sdf.format(fecha);
         return fecha2;
    }
    
    public void insertarPedido(){
        EmpleadoController empleadoController = new EmpleadoController();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); 
        Date nuevaFecha = new Date();
        try{  
            nuevaFecha = sdf.parse(fecha);  
            }catch(ParseException pe){  
                System.out.println("ERROR DE FECHA");
            } 
        empleadoController.insertarPedido(id_pedido, nuevaFecha, cantidad, estado, materiaPedido);
        //return "Administrador";
    }
    
    public void limpiarValores(int id_materia){
        EmpleadoController empleadoController = new EmpleadoController();
        
        id_pedido=0;
        fecha = "";
        cantidad =0;
        estado ="";
        materiaPedido = empleadoController.materia(id_materia);
    } 
    
    public String eliminarPedido(Integer id_pedido){
        EmpleadoController empleadoController = new EmpleadoController();
        empleadoController.eliminarPedido(id_pedido);
        return "Empleado";
    }
}
