package Entity;

import Entity.Proveedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-04-21T23:23:14")
@StaticMetamodel(Categ_Producto.class)
public class Categ_Producto_ { 

    public static volatile SingularAttribute<Categ_Producto, String> Nom_Pro;
    public static volatile SingularAttribute<Categ_Producto, Integer> Id_Categoria;
    public static volatile SingularAttribute<Categ_Producto, String> Tipo_Pro;
    public static volatile SingularAttribute<Categ_Producto, Proveedor> proveedor;

}