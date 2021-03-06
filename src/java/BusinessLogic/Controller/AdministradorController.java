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
    
    public boolean editarEmpleado(String id_empleado, String nombre_empleado,String contraseña_empleado){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario empleado = new Usuario(id_empleado,nombre_empleado,contraseña_empleado,"Empleado");
        usuarioDAO.editar(empleado);
        return true;
    }
    
    public void eliminarEmpleado(String id_usuario){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.eliminarUsuario(id_usuario);
    }
    
    public void insertarEmpleado(String id_usuario, String nombre_usuario, String contraseña){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        Usuario newUsuario = new Usuario(id_usuario,nombre_usuario,contraseña,"Empleado");
        usuario = usuarioDAO.persist(newUsuario);
    }
    
    public Materia buscarMateria(int id_materia){
        MateriaDAO materiaDAO = new MateriaDAO();
        return materiaDAO.buscarIdMateria(id_materia);
    }
    
    public boolean editarMateria(int id_materia, String nombre_materia, int cantidad_materia ,String descripcion_materia, String unidad_materia){
        MateriaDAO materiaDAO = new MateriaDAO();
        Materia materia = new Materia(id_materia, nombre_materia, cantidad_materia, unidad_materia);
        materia.setDescripcion(descripcion_materia);
        materiaDAO.editar(materia);
        return true;
    }
    
    public void insertarMateria(Integer id_materia, String nombre_materia, int cantidad_materia ,String descripcion_materia, String unidad_materia){
        MateriaDAO materiaDAO = new MateriaDAO();
        Materia materia = new Materia();
        Materia newMateria = new Materia(id_materia, nombre_materia, cantidad_materia, unidad_materia);
        //newMateria.setDescripcion(descripcion_materia);
        materia = materiaDAO.persist(newMateria);
        materia.setDescripcion(descripcion_materia);
        materiaDAO.editar(materia);
    }
    
    public void eliminarMateria(Integer id_materia){
        MateriaDAO materiaDAO = new MateriaDAO();
        materiaDAO.eliminarMateria(id_materia);
    }
    
}
