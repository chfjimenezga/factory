package DataAccess.Entity;

import DataAccess.Entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-14T02:31:34")
@StaticMetamodel(Sesion.class)
public class Sesion_ { 

    public static volatile SingularAttribute<Sesion, Integer> idSesion;
    public static volatile SingularAttribute<Sesion, String> fechaInicio;
    public static volatile SingularAttribute<Sesion, String> fechaVencimiento;
    public static volatile SingularAttribute<Sesion, Usuario> idUsuario;
    public static volatile SingularAttribute<Sesion, String> fechaFin;
    public static volatile SingularAttribute<Sesion, String> token;

}