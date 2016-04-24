/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Controller;

/**
 *
 * @author Usuario
 */
import DataAccess.DAO.*;
import DataAccess.Entity.*;
import java.util.ArrayList;
import java.util.Date;

public class EmpleadoController {
    
    public Materia materia(int id_materia){
        MateriaDAO materiaDAO = new MateriaDAO();
        Materia materia = materiaDAO.buscarIdMateria(id_materia);
        return materia;        
    }
    
    public boolean existeMateria(int id_materia){
        MateriaDAO materiaDAO = new MateriaDAO();
        if (materiaDAO.buscarIdMateria(id_materia)!=null) {
        return true;
        }
        return false;
    }
    
    public ArrayList<Materia> listarMaterias(){
        MateriaDAO materiaDAO = new MateriaDAO();
        
        return materiaDAO.listarMateria();
        
    }
    
    public ArrayList<Pedido> listarPedidos(){
        PedidoDAO pedidoDAO = new PedidoDAO();
        
        return pedidoDAO.listarPedidos();
    }
    
    public Pedido buscarPedido(int id_pedido){
        PedidoDAO pedidoDAO = new PedidoDAO();
        Pedido pedido = new Pedido();
        pedido = pedidoDAO.buscarIdPedido(id_pedido);
        return pedido;
    }
    
    public void insertarPedido(int id_pedido, Date fecha, int cantidad, String estado, String materia){
        PedidoDAO pedidoDAO = new PedidoDAO();
        Pedido pedido = new Pedido();
        Pedido nuevoPedido = new Pedido(id_pedido, fecha, cantidad, estado, materia);
        pedido = pedidoDAO.persist(nuevoPedido);
    }
    
    public void eliminarPedido(Integer id_pedido){
        PedidoDAO pedidoDAO = new PedidoDAO();
        pedidoDAO.eliminarPedido(id_pedido);
    }
    
}
