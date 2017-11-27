/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos;

import beans.DataBean;
import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ImportarCSV {

    List<DataBean> data;
    List<DataBean> data2;
    
    public ImportarCSV() {
        
        data= new ArrayList<DataBean>();
        data2= new ArrayList<DataBean>();
        
    }
    
    
  public void importarData() throws FileNotFoundException, IOException{
      
      CsvReader importar= new CsvReader("C:/Users/user/Desktop/Tabla_Estrella/bd_cel_10.csv");
      importar.readHeaders();
      
      while (importar.readRecord()) {
                String cel = importar.get(0);
                String status = importar.get(1);
                String fecha= importar.get(2);
                String moneda = importar.get("Price");
                String precio = importar.get("PriceUnit");
                
                DataBean d= new DataBean(cel, status, fecha, precio, moneda);
                 
               d.depurarNumero();
                
                data.add(d);             
            }
      
      importar.close();
      
       for(DataBean datas : data){
             
                System.out.println(datas.getCel() + " - " + datas.getStatus() + " - "
                    + datas.getFecha() + " - " + datas.getPrecio()+ " - " + datas.getMoneda());
            }
      
      
  }  

  public void importarData2() throws FileNotFoundException, IOException{
      
      CsvReader importar= new CsvReader("C:/Users/user/Desktop/Tabla_Estrella/bd_cel_15.csv");
      importar.readHeaders();
      
      while (importar.readRecord()) {
                String cel = importar.get(0);
                String status = importar.get(1);
                String fecha= importar.get(2);
                String moneda = importar.get("Price");
                String precio = importar.get("PriceUnit");
                
                DataBean d= new DataBean(cel, status, fecha, precio, moneda);
                 
               d.depurarNumero();
                
                data2.add(d);             
            }
      
      importar.close();
      
      System.out.println("*********************************************************");
      
       for(DataBean datas : data2){
             
                System.out.println(datas.getCel() + " - " + datas.getStatus() + " - "
                    + datas.getFecha() + " - " + datas.getPrecio()+ " - " + datas.getMoneda());
            }
      
      
  }  

   
  
  
  
    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<DataBean> getData2() {
        return data2;
    }

    public void setData2(List<DataBean> data2) {
        this.data2 = data2;
    }
    
  

    
}
