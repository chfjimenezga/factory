/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "usuario_modifica_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioModificaPedido.findAll", query = "SELECT u FROM UsuarioModificaPedido u"),
    @NamedQuery(name = "UsuarioModificaPedido.findByAccion", query = "SELECT u FROM UsuarioModificaPedido u WHERE u.accion = :accion"),
    @NamedQuery(name = "UsuarioModificaPedido.findByUsuarioidusuario", query = "SELECT u FROM UsuarioModificaPedido u WHERE u.usuarioModificaPedidoPK.usuarioidusuario = :usuarioidusuario"),
    @NamedQuery(name = "UsuarioModificaPedido.findByPedidoidpedido", query = "SELECT u FROM UsuarioModificaPedido u WHERE u.usuarioModificaPedidoPK.pedidoidpedido = :pedidoidpedido")})
public class UsuarioModificaPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioModificaPedidoPK usuarioModificaPedidoPK;
    @Size(max = 45)
    @Column(name = "accion")
    private String accion;
    @JoinColumn(name = "Pedido_id_pedido", referencedColumnName = "id_pedido", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pedido pedido;
    @JoinColumn(name = "Usuario_id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public UsuarioModificaPedido() {
    }

    public UsuarioModificaPedido(UsuarioModificaPedidoPK usuarioModificaPedidoPK) {
        this.usuarioModificaPedidoPK = usuarioModificaPedidoPK;
    }

    public UsuarioModificaPedido(String usuarioidusuario, int pedidoidpedido) {
        this.usuarioModificaPedidoPK = new UsuarioModificaPedidoPK(usuarioidusuario, pedidoidpedido);
    }

    public UsuarioModificaPedidoPK getUsuarioModificaPedidoPK() {
        return usuarioModificaPedidoPK;
    }

    public void setUsuarioModificaPedidoPK(UsuarioModificaPedidoPK usuarioModificaPedidoPK) {
        this.usuarioModificaPedidoPK = usuarioModificaPedidoPK;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioModificaPedidoPK != null ? usuarioModificaPedidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioModificaPedido)) {
            return false;
        }
        UsuarioModificaPedido other = (UsuarioModificaPedido) object;
        if ((this.usuarioModificaPedidoPK == null && other.usuarioModificaPedidoPK != null) || (this.usuarioModificaPedidoPK != null && !this.usuarioModificaPedidoPK.equals(other.usuarioModificaPedidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.UsuarioModificaPedido[ usuarioModificaPedidoPK=" + usuarioModificaPedidoPK + " ]";
    }
    
}
