/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Categ_Producto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Usuario
 */
@Local
public interface Categ_ProductoFacadeLocal {

    void create(Categ_Producto categ_Producto);

    void edit(Categ_Producto categ_Producto);

    void remove(Categ_Producto categ_Producto);

    Categ_Producto find(Object id);

    List<Categ_Producto> findAll();

    List<Categ_Producto> findRange(int[] range);

    int count();
    
}
