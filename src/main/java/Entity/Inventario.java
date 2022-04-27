/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="inventario")
public class Inventario implements Serializable{
    @Id
    private int CodInv;
    @Temporal(TemporalType.DATE)
    @Column(name="FechaRecibido")
    private Date FechaRecibido;
    @Column(name="NomProducto")
    private String NomProducto;
    @ManyToOne
    @JoinColumn(name="Id_Categoria")
    private Categ_Producto categoria;
    @Temporal(TemporalType.DATE)
    @Column(name="FechaVecimiento")
    private Date FechaVecimiento;
    @Column(name="Stock")
    private int Stock;
    @ManyToOne
    @JoinColumn(name ="IdEmpleado")
    private Empleados empleado;

    public int getCodInv() {
        return CodInv;
    }

    public void setCodInv(int CodInv) {
        this.CodInv = CodInv;
    }

    public Date getFechaRecibido() {
        return FechaRecibido;
    }

    public void setFechaRecibido(Date FechaRecibido) {
        this.FechaRecibido = FechaRecibido;
    }

    public String getNomProducto() {
        return NomProducto;
    }

    public void setNomProducto(String NomProducto) {
        this.NomProducto = NomProducto;
    }
    
    
    public Categ_Producto getCategoria() {
        return categoria;
    }

    public void setCategoria(Categ_Producto categoria) {
        this.categoria = categoria;
    }

   

    public Date getFechaVecimiento() {
        return FechaVecimiento;
    }

    public void setFechaVecimiento(Date FechaVecimiento) {
        this.FechaVecimiento = FechaVecimiento;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.CodInv;
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
        final Inventario other = (Inventario) obj;
        if (this.CodInv != other.CodInv) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inventario{" + "CodInv=" + CodInv + '}';
    }

   
    
}
