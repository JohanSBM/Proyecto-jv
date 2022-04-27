/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import EJB.Categ_ProductoFacadeLocal;
import Entity.Categ_Producto;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ManagedCateg_Producto {

    @EJB
    private Categ_ProductoFacadeLocal Categ_ProductoFacade;
    private List<Categ_Producto> listaCateg_Producto;
    private Categ_Producto categ;
    private String msj;

    public List<Categ_Producto> getListaCateg_Producto() {
        this.listaCateg_Producto = this.Categ_ProductoFacade.findAll();
        return listaCateg_Producto;
    }

    public void setListaCateg_Producto(List<Categ_Producto> listaCateg_Producto) {
        this.listaCateg_Producto = listaCateg_Producto;
    }

    public Categ_Producto getCateg() {
        return categ;
    }

    public void setCateg(Categ_Producto categ) {
        this.categ = categ;
    }

    @PostConstruct
    public void inti() {
        this.categ = new Categ_Producto();
    }

    public void guardar() {
        try {

            this.Categ_ProductoFacade.create(categ);

            this.msj = "Registro creado correctamente";
            this.categ = new Categ_Producto();

        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void editar() {
        try {

            this.Categ_ProductoFacade.edit(categ);

            this.msj = "Registro Actualizados correctamente";
            this.categ = new Categ_Producto();

        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(Categ_Producto eli) {
        try {

            this.Categ_ProductoFacade.remove(eli);
            this.msj = "Registro eliminado  correctamente";

        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void cargarDatos(Categ_Producto cat) {

        this.categ = cat;
    }

    public void limpiar() {
        this.categ = new Categ_Producto();

    }
}
