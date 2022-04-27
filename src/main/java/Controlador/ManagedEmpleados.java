/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import EJB.EmpleadosFacadeLocal;
import Entity.Empleados;
import Entity.Tipo;
import Entity.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ManagedEmpleados {
    @EJB
    private EmpleadosFacadeLocal empleadosFacade;
    private List<Empleados> listaEmpelados;
    private Tipo tipo;
    private Usuario usuario;
    private Empleados empleados;
    private String msj;

    public List<Empleados> getListaEmpelados() {
        this.listaEmpelados=this.empleadosFacade.findAll();
        return listaEmpelados;
    }

    public void setListaEmpelados(List<Empleados> listaEmpelados) {
        this.listaEmpelados = listaEmpelados;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
    this.tipo = new Tipo();
    this.usuario= new Usuario();
    
    }
    
    public void guardar(){
        try{
            this.empleados.setTipo(tipo);
            this.empleados.setUsuario(usuario);
            this.empleadosFacade.create(empleados);
            
         this.msj ="Registro creado correctamente" ;
         this.tipo = new Tipo();
         this.usuario = new Usuario();
         this.empleados= new Empleados();
        }catch (Exception e){
            e.printStackTrace();
            this.msj ="Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
       }
    public void editar(){
        try{
            this.empleados.setTipo(tipo);
            this.empleados.setUsuario(usuario);
            this.empleadosFacade.edit(empleados);
            
         this.msj ="Registro Actualizados correctamente" ;
         this.tipo = new Tipo();
         this.usuario = new Usuario();
         this.empleados= new Empleados();
        }catch (Exception e){
            e.printStackTrace();
            this.msj ="Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
       }
    public void eliminar(Empleados eli) {
        try{
            
            this.empleadosFacade.remove(eli);
         this.msj ="Registro eliminado  correctamente" ;
         
        }catch (Exception e){
            e.printStackTrace();
            this.msj ="Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
       }
    public void cargarDatos (Empleados e){
     this.tipo.setId_tipo(e.getTipo().getId_tipo());
     this.usuario.setIdUsuario(e.getUsuario().getIdUsuario());
     this.empleados = e;
    }
     public void limpiar(){
       this.tipo = new Tipo();
         this.usuario = new Usuario();
         this.empleados= new Empleados();
     }
     
    }

