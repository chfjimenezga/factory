/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Sesion;
import java.math.BigInteger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 *
 * @author Usuario
 */
public class SesionDAO {
    
    
    public EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("factoryPU");
    
    public Sesion persist(Sesion sesion) {
        
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        
        try {
            em.persist(sesion);
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            return sesion;  
        }
    }
    
    public Sesion buscarIdSesion(int id_sesion) {
        
        EntityManager em = emf1.createEntityManager();
        Sesion sesion = null;
        
        try {
            sesion = em.find(Sesion.class
                    , id_sesion);
        } catch (Exception e){
        } finally {
            em.close();
            return sesion;
        }
    }
    
    public void edit(Sesion sesion){
        Sesion nuevaSesion;
        EntityManager em = emf1.createEntityManager();  
        em.getTransaction().begin();
        try {
           nuevaSesion = em.merge(em.find(Sesion.class, sesion.getIdSesion())); 
           nuevaSesion.setFechaInicio(sesion.getFechaInicio());
           nuevaSesion.setFechaInicio(sesion.getFechaInicio());
           nuevaSesion.setFechaInicio(sesion.getFechaInicio());
           nuevaSesion.setFechaInicio(sesion.getFechaInicio());
           nuevaSesion.setFechaInicio(sesion.getFechaInicio());
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
