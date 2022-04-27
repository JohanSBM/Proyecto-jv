/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Categ_Producto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class Categ_ProductoFacade extends AbstractFacade<Categ_Producto> implements Categ_ProductoFacadeLocal {

    @PersistenceContext(unitName = "Gransabor")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Categ_ProductoFacade() {
        super(Categ_Producto.class);
    }
    
}
