/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import EJB.InventarioFacadeLocal;
import Entity.Categ_Producto;
import Entity.Empleados;
import Entity.Inventario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ManagedInventario {
    @EJB
    private InventarioFacadeLocal inventarioFacade;
    private List<Inventario> listaInventario;
    private Inventario inventario;
    private Categ_Producto categ;   
    private Empleados empleados;
    private String msj;

    public List<Inventario> getListaInventario() {
        this.listaInventario = this.inventarioFacade.findAll();
        return listaInventario;
    }

    public void setListaInventario(List<Inventario> listaInventario) {
        this.listaInventario = listaInventario;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Categ_Producto getCateg() {
        return categ;
    }

    public void setCateg(Categ_Producto categ) {
        this.categ = categ;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

   

   
    
     @PostConstruct
     public void init(){
    this.empleados= new Empleados();
    this.inventario = new Inventario();
    this.categ = new Categ_Producto();
    
    }
     public void guardar() {
        try {
            this.inventario.setEmpleado(empleados);
            this.inventario.setCategoria(categ);
            this.inventarioFacade.create(inventario);

            this.msj = "Registro creado correctamente";
            this.empleados = new Empleados();
            this.inventario = new Inventario();
            this.categ = new Categ_Producto();

        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    public void editar(){
        try {
            this.inventario.setEmpleado(empleados);
            this.inventario.setCategoria(categ);
            this.inventarioFacade.edit(inventario);

            this.msj = "Registro Actualizados correctamente";
            this.empleados = new Empleados();
            this.inventario = new Inventario();
            this.categ = new Categ_Producto();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    public void eliminar(Inventario eli) {
        try{
            
            this.inventarioFacade.remove(eli);
         this.msj ="Registro eliminado  correctamente" ;
         
        }catch (Exception e){
            e.printStackTrace();
            this.msj ="Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
       }
    public void cargarDatos (Inventario in){
     this.empleados.setIdEmpleado(in.getEmpleado().getIdEmpleado());
     this.categ.setId_Categoria(in.getCategoria().getId_Categoria());
     this.inventario = in;
    }
     public void limpiar(){
    this.empleados= new Empleados();
    this.inventario = new Inventario();
    this.categ = new Categ_Producto();
     }
    
    
    
}
