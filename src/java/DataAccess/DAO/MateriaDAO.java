/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Materia;
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
public class MateriaDAO {
    
    public EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("factoryPU");
    
    public Materia persist(Materia materia) {
        
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        
        try {
            em.persist(materia);
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            return materia;  
        }
    }
    
    public ArrayList<Materia> listarMateria() {
        ArrayList<Materia> materias = new ArrayList<Materia>();
        EntityManager em = emf1.createEntityManager();
        //Query q = em.createNamedQuery("Materia.findAll");
        TypedQuery q = (TypedQuery) em.createNamedQuery("Materia.findAll");
        
        try {
            List<Materia> m=q.getResultList();
            
            System.out.println("Tamanio: "+m.size());
            
            for (Materia c : m) {
                System.out.println("A");
                System.out.println(c.getNombre()+" "+c.getCantidadDisponible());
                materias.add((Materia)c);
            }
        } catch (Exception e){
            System.out.println(e.toString());
        } finally {
            return materias;
        }
    }
    
    public Materia buscarIdMateria(int id_materia) {
        
        EntityManager em = emf1.createEntityManager();
        Materia materia = null;
        
        try {
            materia = em.find(Materia.class
                    , id_materia);
        } catch (Exception e){
        } finally {
            em.close();
            return materia;
        }
    }
    
    public void edit(Materia materia){
        Materia nuevaMateria;
        EntityManager em = emf1.createEntityManager();  
        em.getTransaction().begin();
        try {
           nuevaMateria = em.merge(em.find(Materia.class, materia.getIdMateria())); 
           nuevaMateria.setNombre(materia.getNombre());
           nuevaMateria.setDescripcion(materia.getDescripcion());
           nuevaMateria.setCantidadDisponible(materia.getCantidadDisponible());
           nuevaMateria.setUnidadDeMedida(materia.getUnidadDeMedida());
           em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public boolean editCantidadDisponible(int id_materia, int cantidadDisponible) {
        Materia nuevaMateria;
        EntityManager em = emf1.createEntityManager();  
        em.getTransaction().begin();
        boolean success = true;
        
        try {
            nuevaMateria = em.merge(em.find(Materia.class, id_materia)); 
            nuevaMateria.setCantidadDisponible(cantidadDisponible);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            success = false;
        } finally {
            em.close();
            return success;
        }
    } 
    
}
