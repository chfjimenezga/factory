/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Usuario
 */
@Embeddable
public class UsuarioModificaPedidoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Usuario_id_usuario")
    private String usuarioidusuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Pedido_id_pedido")
    private int pedidoidpedido;

    public UsuarioModificaPedidoPK() {
    }

    public UsuarioModificaPedidoPK(String usuarioidusuario, int pedidoidpedido) {
        this.usuarioidusuario = usuarioidusuario;
        this.pedidoidpedido = pedidoidpedido;
    }

    public String getUsuarioidusuario() {
        return usuarioidusuario;
    }

    public void setUsuarioidusuario(String usuarioidusuario) {
        this.usuarioidusuario = usuarioidusuario;
    }

    public int getPedidoidpedido() {
        return pedidoidpedido;
    }

    public void setPedidoidpedido(int pedidoidpedido) {
        this.pedidoidpedido = pedidoidpedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioidusuario != null ? usuarioidusuario.hashCode() : 0);
        hash += (int) pedidoidpedido;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioModificaPedidoPK)) {
            return false;
        }
        UsuarioModificaPedidoPK other = (UsuarioModificaPedidoPK) object;
        if ((this.usuarioidusuario == null && other.usuarioidusuario != null) || (this.usuarioidusuario != null && !this.usuarioidusuario.equals(other.usuarioidusuario))) {
            return false;
        }
        if (this.pedidoidpedido != other.pedidoidpedido) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.UsuarioModificaPedidoPK[ usuarioidusuario=" + usuarioidusuario + ", pedidoidpedido=" + pedidoidpedido + " ]";
    }
    
}
