package Entity;

import Entity.Tipo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-04-21T23:23:14")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Tipo> tipo;
    public static volatile SingularAttribute<Usuario, Integer> IdUsuario;
    public static volatile SingularAttribute<Usuario, String> pass;
    public static volatile SingularAttribute<Usuario, String> usuario;

}