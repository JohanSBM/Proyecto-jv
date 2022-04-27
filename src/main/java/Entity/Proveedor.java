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
import javax.persistence.Table;

@Entity
@Table (name ="proveedor")
public class Proveedor implements Serializable{
    @Id
    private int IdProv;
    @Column (name="NITEmpresa")
    private int NITEmpresa;
    @Column (name="NomProv")
    private String NomProv;
    @Column (name="TelProv")
    private String TelProv;
    @Column (name="CorreoProv")
    private String CorreoProv;
    
    public Proveedor (){
    }
    public Proveedor(int IdProv){
    this.IdProv =IdProv;    
    }
    
    public Proveedor(int IdProv ,int NITEmpresa,String NomProv,String TelProv,String CorreoProv){
    this.IdProv = IdProv;
    this.NITEmpresa =NITEmpresa;
    this.NomProv = NomProv;
    this.TelProv = TelProv;
    this.CorreoProv =CorreoProv;
    }

    public int getIdProv() {
        return IdProv;
    }

    public void setIdProv(int IdProv) {
        this.IdProv = IdProv;
    }

    public int getNITEmpresa() {
        return NITEmpresa;
    }

    public void setNITEmpresa(int NITEmpresa) {
        this.NITEmpresa = NITEmpresa;
    }

    public String getNomProv() {
        return NomProv;
    }

    public void setNomProv(String NomProv) {
        this.NomProv = NomProv;
    }

    public String getTelProv() {
        return TelProv;
    }

    public void setTelProv(String TelProv) {
        this.TelProv = TelProv;
    }

    public String getCorreoProv() {
        return CorreoProv;
    }

    public void setCorreoProv(String CoreoProv) {
        this.CorreoProv = CoreoProv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.IdProv;
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
        final Proveedor other = (Proveedor) obj;
        if (this.IdProv != other.IdProv) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "IdProv=" + IdProv + '}';
    }
    
    
}
