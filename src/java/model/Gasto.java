/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lisandro
 */
public class Gasto {
    private int idGasto;
    private Categoria categoria;
    private float importe;

    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGastor) {
        this.idGasto = idGastor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public Gasto(int idGasto, Categoria categoria, float importe) {
        this.idGasto = idGasto;
        this.categoria = categoria;
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Gasto{" + "idGasto=" + idGasto + ", categoria=" + categoria + ", importe=" + importe + '}';
    }
          
    
    
}
