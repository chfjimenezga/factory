/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Pedido;
import java.math.BigInteger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
    
    
}
