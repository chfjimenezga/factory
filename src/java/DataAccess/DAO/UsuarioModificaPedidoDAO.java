/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;


import DataAccess.Entity.UsuarioModificaPedido;
import DataAccess.Entity.UsuarioModificaPedidoPK;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario
 */
public class UsuarioModificaPedidoDAO {
    public EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("factoryPU");
    
    public UsuarioModificaPedido persist(UsuarioModificaPedido usuarioModificaPedido) {
        
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        
        try {
            em.persist(usuarioModificaPedido);
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            return usuarioModificaPedido;  
        }
    }
    
    public UsuarioModificaPedido buscarIdSesion(UsuarioModificaPedidoPK usuarioModificaPedidoPK) {
        
        EntityManager em = emf1.createEntityManager();
        UsuarioModificaPedido usuarioModificaPedido = null;
        
        try {
            usuarioModificaPedido = em.find(UsuarioModificaPedido.class
                    , usuarioModificaPedidoPK);
        } catch (Exception e){
        } finally {
            em.close();
            return usuarioModificaPedido;
        }
    }
    
    public void edit(UsuarioModificaPedido usuarioModificaPedido){
        UsuarioModificaPedido nuevoUsuarioModificaPedido;
        EntityManager em = emf1.createEntityManager();  
        em.getTransaction().begin();
        try {
           nuevoUsuarioModificaPedido = em.merge(em.find(UsuarioModificaPedido.class, usuarioModificaPedido.getAccion())); 
           nuevoUsuarioModificaPedido.setPedido(usuarioModificaPedido.getPedido());
           nuevoUsuarioModificaPedido.setUsuario(usuarioModificaPedido.getUsuario());
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
