/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import archivos.ExportarCSV;
import archivos.ImportarCSV;
import beans.DataBean;
import beans.DetalleBean;
import gestion.Consultas;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
        // TODO code application logic here
        
        
        DataBean d= new DataBean();
        
        d.setCel("51999973753");
        
        d.depurarNumero();
        
        
        
        ImportarCSV i= new ImportarCSV();
        
        i.importarData();
        i.importarData2();
        
        
        Consultas c= new Consultas();
        
        c.contarNumerosTelefonicos();
        c.contarNumerosTelefonicos2();
        
        c.mostrarNumeros();
        System.out.println("***********************************************************************************");
        c.mostrarNumeros2();
        
        
        List<DataBean> datita= new ArrayList<DataBean>();
        List<DataBean> datita2= new ArrayList<DataBean>();
        
        datita=i.getData();
        datita2=i.getData2();
        
        int contadorcito=0;
        int contadorcito2=0;
        
        String[] numeritos;
        numeritos=c.getNumerosTelefonicos();
        
         String[] numeritos2;
        numeritos2=c.getNumerosTelefonicos2();
        
        
        for (int j = 0; j < c.getContador(); j++) {
            
            System.out.println("****DIA_10*****"+numeritos[j]);
            
        }
       
        
         for (int j = 0; j < c.getContador2(); j++) {
            
            System.out.println("****DIA_15*****"+numeritos2[j]);
            
        }
        
        
        
         for(DataBean datas : datita){
             
             
             for (int j = 0; j < c.getContador(); j++) {
                 
                 if ((datas.getCel()).equalsIgnoreCase(numeritos[j])) {
                    
                     contadorcito++;
                     
                     
                 }
                 
             }
             
             
            }
         
         
         
           for(DataBean datas : datita2){
             
             
             for (int j = 0; j < c.getContador2(); j++) {
                 
                 if ((datas.getCel()).equalsIgnoreCase(numeritos2[j])) {
                    
                     contadorcito2++;
                     
                     
                 }
                 
             }
             
             
            }
         
        
        
        System.out.println("Numeros apostadores del Dia 10: " + contadorcito);
        
         System.out.println("Numeros apostadores del Dia 15: " + contadorcito2);
         
         
         
         c.obtenerDetalles();
         
         c.obtenerDetalles2();
         
         DetalleBean[] detalles;
         detalles= c.getDetalles();
         int contadorDetalles=c.getContadorDetalle();
         
         DetalleBean[] detalles2;
         detalles2= c.getDetalles2();
         int contadorDetalles2=c.getContadorDetalle2();
         
      
         
         
         
     ExportarCSV e= new ExportarCSV();
         
         
      e.exportarResultados(detalles, datita,contadorDetalles);
      e.exportarResultados2(detalles2, datita2, contadorDetalles2);
         
         
    }
    
}
