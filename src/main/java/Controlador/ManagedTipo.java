/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import EJB.TipoFacadeLocal;
import Entity.Tipo;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ManagedTipo implements Serializable{
    @EJB
    private TipoFacadeLocal tipoFacade;
    private List<Tipo>listaTipo;
    private Tipo tipo;
    private String msj;

    public List<Tipo> getListaTipo() {
        this.listaTipo=this.tipoFacade.findAll();
        return listaTipo;
    }

    public void setListaTipo(List<Tipo> listaTipo) {
        this.listaTipo = listaTipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    @PostConstruct
    public void init(){
     this.tipo= new Tipo();    
     
    }
     public void guardar(){
        try{
           
            this.tipoFacade.create(tipo);
            
         this.msj ="Registro creado correctamente" ;
         this.tipo = new Tipo();
         
        }catch (Exception e){
            e.printStackTrace();
            this.msj ="Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
       }
    public void editar(){
        try{
            
            this.tipoFacade.edit(tipo);
            
         this.msj ="Registro Actualizados correctamente" ;
         this.tipo = new Tipo();
        
        }catch (Exception e){
            e.printStackTrace();
            this.msj ="Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
       }
       public void eliminar(Tipo eli) {
        try{
            
            this.tipoFacade.remove(eli);
         this.msj ="Registro eliminado  correctamente" ;
         
        }catch (Exception e){
            e.printStackTrace();
            this.msj ="Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
       }
    public void cargarDatos (Tipo ti){
     
     this.tipo = ti;
    }
     public void limpiar(){
       this.tipo = new Tipo();
         
     }
     
    }



