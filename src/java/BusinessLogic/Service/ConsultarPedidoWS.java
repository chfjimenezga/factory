/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Service;

import BusinessLogic.Controller.EmpleadoController;
import DataAccess.Entity.Pedido;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "ConsultarPedidoWS")
public class ConsultarPedidoWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "consultarPedido")
    public Pedido consultarPedido(int id_pedido) {
        EmpleadoController empleadoController = new EmpleadoController();
        Pedido pedido = new Pedido();
        pedido = empleadoController.buscarPedido(id_pedido);
        return pedido;
    }
}
