package DataAccess.Entity;

import DataAccess.Entity.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-14T02:31:34")
@StaticMetamodel(Materia.class)
public class Materia_ { 

    public static volatile SingularAttribute<Materia, String> descripcion;
    public static volatile SingularAttribute<Materia, Integer> idMateria;
    public static volatile SingularAttribute<Materia, String> unidadDeMedida;
    public static volatile CollectionAttribute<Materia, Pedido> pedidoCollection;
    public static volatile SingularAttribute<Materia, String> nombre;
    public static volatile SingularAttribute<Materia, Integer> cantidadDisponible;

}