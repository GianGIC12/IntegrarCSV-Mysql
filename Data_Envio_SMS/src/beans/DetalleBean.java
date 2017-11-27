/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author user
 */
public class DetalleBean {
    
    String celular;
    int apuestas;
    float monto;

    public DetalleBean() {
    }

    public DetalleBean(String celular, int apuestas, float monto) {
        this.celular = celular;
        this.apuestas = apuestas;
        this.monto = monto;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getApuestas() {
        return apuestas;
    }

    public void setApuestas(int apuestas) {
        this.apuestas = apuestas;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
    

    
}
