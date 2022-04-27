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

/**
 *
 * @author Usuario
 */
@Entity
@Table(name="categ_producto")
public class Categ_Producto  implements Serializable{
    @Id
     private int Id_Categoria;
    @Column(name="Nom_Pro")
     private String Nom_Pro;
    @Column(name="Tipo_Pro")
     private String Tipo_Pro;
    @ManyToOne
    @JoinColumn(name="IdProv")
     private Proveedor proveedor;

    public int getId_Categoria() {
        return Id_Categoria;
    }

    public void setId_Categoria(int Id_Categoria) {
        this.Id_Categoria = Id_Categoria;
    }

    public String getNom_Pro() {
        return Nom_Pro;
    }

    public void setNom_Pro(String Nom_Pro) {
        this.Nom_Pro = Nom_Pro;
    }

  

    public String getTipo_Pro() {
        return Tipo_Pro;
    }

    public void setTipo_Pro(String Tipo_Pro) {
        this.Tipo_Pro = Tipo_Pro;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.Id_Categoria;
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
        final Categ_Producto other = (Categ_Producto) obj;
        if (this.Id_Categoria != other.Id_Categoria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Categ_Producto{" + "Id_Categoria=" + Id_Categoria + '}';
    }
     
     
    
}