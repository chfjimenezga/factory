/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Usuario;
import java.math.BigInteger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
public class UsuarioDAO {
    
    public EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("factoryPU");
    
    public Usuario persist(Usuario usuario) {
        
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        
        try {
            em.persist(usuario);
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            return usuario;  
        }
    }
    
    public Usuario buscarIdUsuario(String id_usuario) {
        
        EntityManager em = emf1.createEntityManager();
        Usuario usuario = null;
        
        try {
            usuario = em.find(Usuario.class
                    , id_usuario);
        } catch (Exception e){
        } finally {
            em.close();
            return usuario;
        }
    }
    
    
    public void editar(Usuario usuario){
        Usuario nuevoUsuario;
        EntityManager em = emf1.createEntityManager();  
        em.getTransaction().begin();
        try {
           nuevoUsuario = em.merge(em.find(Usuario.class, usuario.getIdUsuario())); 
           nuevoUsuario.setNombre(usuario.getNombre());
           nuevoUsuario.setContraseña(usuario.getContraseña());
           nuevoUsuario.setRol(usuario.getRol());
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
