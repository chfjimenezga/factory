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

public class AdministradorController {
    
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
    
    public ArrayList<Materia> todasMaterias(){
        MateriaDAO materiaDAO = new MateriaDAO();
        return materiaDAO.listarMateria();
    }
    
    public ArrayList<Usuario> empleados(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.empleados("Empleado");
    }
    
    public Usuario buscarEmpleado(String id_usuario){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.buscarIdUsuario(id_usuario);
    }
}
