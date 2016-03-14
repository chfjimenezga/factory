/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Controller;

import DataAccess.DAO.*;
import DataAccess.Entity.*;
import java.math.BigInteger;

/**
 *
 * @author Usuario
 */
public class LoginUsuario {
    
    
    public boolean Login(String id_usuario, String contrasenaUsuario){
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if (usuarioDAO.buscarIdUsuario(id_usuario)!=null) {
            Usuario usuario = new Usuario();
            usuario = usuarioDAO.buscarIdUsuario(id_usuario);
            if(usuario.getContraseña().equals(contrasenaUsuario)){
                return true;
}
            return false;
        } else {
            return false;            
        }       
    }
    
    public String Rol(String id_usuario){
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Usuario usuario = new Usuario();
    usuario = usuarioDAO.buscarIdUsuario(id_usuario);
    return usuario.getRol();
    }
    
}
