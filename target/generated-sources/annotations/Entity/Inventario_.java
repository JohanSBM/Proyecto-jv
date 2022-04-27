package Entity;

import Entity.Categ_Producto;
import Entity.Empleados;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-04-21T23:23:14")
@StaticMetamodel(Inventario.class)
public class Inventario_ { 

    public static volatile SingularAttribute<Inventario, Date> FechaVecimiento;
    public static volatile SingularAttribute<Inventario, Date> FechaRecibido;
    public static volatile SingularAttribute<Inventario, String> NomProducto;
    public static volatile SingularAttribute<Inventario, Empleados> empleado;
    public static volatile SingularAttribute<Inventario, Integer> CodInv;
    public static volatile SingularAttribute<Inventario, Categ_Producto> categoria;
    public static volatile SingularAttribute<Inventario, Integer> Stock;

}