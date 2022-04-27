/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="Empleados")
public class Empleados implements  Serializable{
    @Id
    private int IdEmpleado;
    @Column(name="NomEmp")
    private String NomEmp;
     @Column(name="ApeEmp")
    private String ApeEmp;
     @ManyToOne
     @JoinColumn(name="id_tipo")
    private Tipo tipo;
      @Column(name="Direccion")
    private String Direccion;
       @Column(name="Correo")
    private String Correo;
        @Column(name="Celular")
    private String Celular;
     @ManyToOne
      @JoinColumn(name="IdUsuario")
    private Usuario usuario;    

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getNomEmp() {
        return NomEmp;
    }

    public void setNomEmp(String NomEmp) {
        this.NomEmp = NomEmp;
    }

    public String getApeEmp() {
        return ApeEmp;
    }

    public void setApeEmp(String ApeEmp) {
        this.ApeEmp = ApeEmp;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.IdEmpleado;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleados other = (Empleados) obj;
        if (this.IdEmpleado != other.IdEmpleado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empleados{" + "IdEmpleado=" + IdEmpleado + '}';
    }

   
    
    
}
