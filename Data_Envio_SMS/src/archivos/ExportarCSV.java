/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import beans.DataBean;
import beans.DetalleBean;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author user
 */
public class ExportarCSV {

    public ExportarCSV() {
    }

    public void exportarResultados(DetalleBean[] detalles, List<DataBean> datita,int contadorDetalles) throws IOException {

        String outputFile = "C:/Users/user/Desktop/Tabla_Estrella/bd_detalle_10.csv";
        boolean alreadyExists = new File(outputFile).exists();

        if (alreadyExists) {
            File bd_detalle_10 = new File(outputFile);
            bd_detalle_10.delete();
        }

        CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

        csvOutput.write("phone");
        csvOutput.write("apuestas");
        csvOutput.write("monto");
        csvOutput.endRecord();
        
        
        
         for(DataBean datas : datita){
             
            
             for (int j = 0; j < contadorDetalles; j++) {
                 
                 if ((datas.getCel()).equalsIgnoreCase(detalles[j].getCelular())) {
                    
                     System.out.println("Escrito*****"+j);
                     
                csvOutput.write(detalles[j].getCelular());
                csvOutput.write(detalles[j].getApuestas()+"");
                csvOutput.write(detalles[j].getMonto()+"");
                csvOutput.endRecord(); 
                     
                     
                     
                 }
                 
             }
             
             
            }
        
        
        
        
        
        

        csvOutput.close();

    }

    
      public void exportarResultados2(DetalleBean[] detalles2, List<DataBean> datita2,int contadorDetalles2) throws IOException {

        String outputFile = "C:/Users/user/Desktop/Tabla_Estrella/bd_detalle_15.csv";
        boolean alreadyExists = new File(outputFile).exists();

        if (alreadyExists) {
            File bd_detalle_15 = new File(outputFile);
            bd_detalle_15.delete();
        }

        CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

        csvOutput.write("phone");
        csvOutput.write("apuestas");
        csvOutput.write("monto");
        csvOutput.endRecord();
        
        
        
         for(DataBean datas : datita2){
             
            
             for (int j = 0; j < contadorDetalles2; j++) {
                 System.out.println("FAILLLLLLLLLLLLLLLLLLLL");
                      
                 if ((datas.getCel()).equalsIgnoreCase(detalles2[j].getCelular())) {
                    
                     System.out.println("Escrito*****"+j);
                     
                csvOutput.write(detalles2[j].getCelular());
                csvOutput.write(detalles2[j].getApuestas()+"");
                csvOutput.write(detalles2[j].getMonto()+"");
                csvOutput.endRecord(); 
                     
                     
                     
                 }
                 
             }
             
             
            }
        
        
        
        
        
        

        csvOutput.close();

    }

    
}
