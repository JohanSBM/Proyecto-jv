/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import EJB.ProveedorFacadeLocal;
import Entity.Proveedor;
import com.csvreader.CsvReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.file.UploadedFile;

@ManagedBean
@SessionScoped
public class ManagedProveedor implements Serializable{
    @EJB   
    private ProveedorFacadeLocal proveedorFacade;
    private List <Proveedor>listaProveedor;
    private Proveedor proveedor;    
    private String msj;
    
    private UploadedFile file;

    public List<Proveedor> getListaProveedor() {
        this.listaProveedor =this.proveedorFacade.findAll();
        return listaProveedor;
    }

    public void setListaProveedor(List<Proveedor> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    @PostConstruct
    public void inti (){
        this.proveedor =new Proveedor();
    }
    
    
     public void guardar(){
        try{
           
            this.proveedorFacade.create(proveedor);
            
         this.msj ="Registro creado correctamente" ;
         this.proveedor = new Proveedor();
         
        }catch (Exception e){
            e.printStackTrace();
            this.msj ="Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
       }
    public void editar(){
        try{
            
            this.proveedorFacade.edit(proveedor);
            
         this.msj ="Registro Actualizados correctamente" ;
          this.proveedor = new Proveedor();
        
        }catch (Exception e){
            e.printStackTrace();
            this.msj ="Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
       }
       public void eliminar(Proveedor eli) {
        try{
            
            this.proveedorFacade.remove(eli);
         this.msj ="Registro eliminado  correctamente" ;
         
        }catch (Exception e){
            e.printStackTrace();
            this.msj ="Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
       }
    public void cargarDatos (Proveedor p){
     
     this.proveedor = p;
    }
     public void limpiar(){
         this.proveedor = new Proveedor();
         
     }
     
    
    
}
