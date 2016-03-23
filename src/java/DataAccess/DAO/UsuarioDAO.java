/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
    
    public ArrayList<Usuario> empleados(String rol) {
        ArrayList<Usuario> empleados = new ArrayList<Usuario>();
        EntityManager em = emf1.createEntityManager();
        //Query q = em.createNamedQuery("Materia.findAll");
        TypedQuery q = (TypedQuery) em.createNamedQuery("Usuario.findByRol");
        q.setParameter("rol",rol);
        
        try {
            List<Usuario> m=q.getResultList();
            
            for (Usuario c : m) {
                empleados.add((Usuario)c);
            }
        } catch (Exception e){
            System.out.println(e.toString());
        } finally {
            return empleados;
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
    
    public Usuario buscarNombreUsuario(String nombre_usuario) {
        
        EntityManager em = emf1.createEntityManager();
        Usuario usuario = null;
        
        try {
            usuario = em.find(Usuario.class
                    , nombre_usuario);
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
    
    public void eliminarUsuario(String id_usuario){
        EntityManager em = emf1.createEntityManager();
        Usuario usuario = null;
        
        try {
            usuario = em.find(Usuario.class,id_usuario);
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        } catch (Exception e){
        } finally {
            em.close();
        }
    }
    
}
