/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

;
import EJB.UsuarioFacadeLocal;
import Entity.Tipo;
import Entity.Usuario;
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
public class ManagedUsuario implements Serializable {
    @EJB
 
    private UsuarioFacadeLocal usuarioFacade;
    private List<Usuario> listaUsuario;
    private Usuario usuario;
    private Tipo tipo;
    private String msj;

    public List<Usuario> getListaUsuario() {
        this.listaUsuario = this.usuarioFacade.findAll();
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
  

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }


    
    @PostConstruct
    public void init(){
        this.usuario = new Usuario();
        this.tipo = new Tipo();
        
       
    }
     public void guardar(){
        try{
           
            this.usuarioFacade.create(usuario);
            this.usuario.setTipo(tipo);
            
         this.msj ="Registro creado correctamente" ;
         this.tipo = new Tipo();
         this.usuario = new Usuario();
        
        }catch (Exception e){
            e.printStackTrace();
            this.msj ="Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
       }
    public void editar(){
        try{
          this.usuarioFacade.create(usuario);
            this.usuario.setTipo(tipo);
            
         this.msj ="Registro Actualizados correctamente" ;
         this.tipo = new Tipo();
         this.usuario = new Usuario();
         
        }catch (Exception e){
            e.printStackTrace();
            this.msj ="Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
       }
    public void eliminar(Usuario eli) {
        try{
            
            this.usuarioFacade.remove(eli);
         this.msj ="Registro eliminado  correctamente" ;
         
        }catch (Exception e){
            e.printStackTrace();
            this.msj ="Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
       }
    public void cargarDatos (Usuario u){
     this.tipo.setId_tipo(u.getTipo().getId_tipo());
     
     this.usuario = u;
    }
     public void limpiar(){
       this.tipo = new Tipo();
         this.usuario = new Usuario();
         
     }
     
    public ManagedUsuario() {
    }
     public String validar(){
        Usuario us;
        String ruta= null;
        try{
         us=usuarioFacade.acceder(usuario); 
         if(us != null){
           ruta="principal";         
         }else{
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Datos incorrectos","Usuario incorrecto"));

         }
            
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Datos incorrectos","Error"));
            
        }
        return ruta;
    }
}


