/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.math.BigInteger;

/**
 *
 * @author user
 */
public class DataBean {
    
    String cel,fecha;
    String status,moneda;
    String precio;

    public DataBean() {
    }

    public DataBean(String cel, String status,String fecha ,String precio, String moneda) {
        this.cel = cel;
        this.status = status;
        this.moneda = moneda;
        this.precio = precio;
        this.fecha = fecha;
    }
    
    public void depurarNumero(){
        
   
   cel= cel.substring(2, 11);
        
    
    
       
        
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

  

    
}
