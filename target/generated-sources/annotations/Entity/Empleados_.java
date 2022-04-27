package Entity;

import Entity.Tipo;
import Entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-04-21T23:23:14")
@StaticMetamodel(Empleados.class)
public class Empleados_ { 

    public static volatile SingularAttribute<Empleados, String> Correo;
    public static volatile SingularAttribute<Empleados, String> Celular;
    public static volatile SingularAttribute<Empleados, Tipo> tipo;
    public static volatile SingularAttribute<Empleados, Integer> IdEmpleado;
    public static volatile SingularAttribute<Empleados, String> NomEmp;
    public static volatile SingularAttribute<Empleados, String> ApeEmp;
    public static volatile SingularAttribute<Empleados, String> Direccion;
    public static volatile SingularAttribute<Empleados, Usuario> usuario;

}