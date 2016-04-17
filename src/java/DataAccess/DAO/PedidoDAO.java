/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Pedido;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
/**
 *
 * @author Usuario
 */
public class PedidoDAO {
    
    public EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("factoryPU");
    
    public Pedido persist(Pedido pedido) {
        
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        
        try {
            em.persist(pedido);
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            return pedido;  
        }
    }
    
    public Pedido buscarIdPedido(int id_pedido) {
        
        EntityManager em = emf1.createEntityManager();
        Pedido pedido = null;
        
        try {
            pedido = em.find(Pedido.class
                    , id_pedido);
        } catch (Exception e){
        } finally {
            em.close();
            return pedido;
        }
    }
    
    public void edit(Pedido pedido){
        Pedido nuevoPedido;
        EntityManager em = emf1.createEntityManager();  
        em.getTransaction().begin();
        try {
           nuevoPedido = em.merge(em.find(Pedido.class, pedido.getIdPedido())); 
           nuevoPedido.setFechaSolicitud(pedido.getFechaSolicitud());
           nuevoPedido.setCantidad(pedido.getCantidad());
           nuevoPedido.setEstado(pedido.getEstado());
           nuevoPedido.setIdMateria(pedido.getIdMateria());
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public ArrayList<Pedido> listarPedidos() {
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        EntityManager em = emf1.createEntityManager();
        //Query q = em.createNamedQuery("Materia.findAll");
        TypedQuery q = (TypedQuery) em.createNamedQuery("Pedido.findAll");
        
        try {
            List<Pedido> m=q.getResultList();
            
            for (Pedido c : m) {
                pedidos.add((Pedido)c);
            }
        } catch (Exception e){
            System.out.println(e.toString());
        } finally {
            return pedidos;
        }
    }
    
    public void eliminarPedido(Integer id_pedido){
        EntityManager em = emf1.createEntityManager();
        Pedido pedido = null;
        
        try {
            pedido = em.find(Pedido.class,id_pedido);
            em.getTransaction().begin();
            em.remove(pedido);
            em.getTransaction().commit();
        } catch (Exception e){
        } finally {
            em.close();
        }
    }
    
    
}
