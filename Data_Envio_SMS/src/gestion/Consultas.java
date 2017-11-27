/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import beans.DetalleBean;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class Consultas {

    String sql;
    String[] numerosTelefonicos;
    String[] numerosTelefonicos2;
    int contador, contador2,contadorDetalle,contadorDetalle2;
    DetalleBean[] detalles;
    DetalleBean[] detalles2;

    public Consultas() {

        numerosTelefonicos = new String[10000];
        numerosTelefonicos2 = new String[10000];
        detalles = new DetalleBean[10000];
        detalles2 = new DetalleBean[10000];
        contador = 0;
        contador2 = 0;
        contadorDetalle=0;
        contadorDetalle2=0;

    }

    public void iniciar() {

        for (int i = 0; i < 10000; i++) {

            numerosTelefonicos[i] = "";
            numerosTelefonicos2[i] = "";
        }

    }

    public void contarNumerosTelefonicos() throws SQLException {

        Conexion objCon = new Conexion();

        objCon.conectar();

        sql = "select distinct(b.phone) from user_bet as a\n"
                + "join user_user as b\n"
                + "on a.idUser= b.id\n"
                + "where (a.created_at>='2017-11-10' and a.created_at<='2017-11-11')\n"
                + "\n"
                + "";

        PreparedStatement stm = objCon.getCon().prepareStatement(sql);

        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            /**
             * System.out.println(rs.getString("id")+ ","
             * +rs.getString("idAviso") + "," + rs.getString("idCaracteristica")
             * + "," + rs.getString("valor"));
             */
            String phone = rs.getString("phone");

            if (phone == null) {

                phone = "999999999";

            }

            int digitos = phone.length();

            if (digitos == 10) {
                phone = phone.substring(1, 10);

            } else if (digitos == 11) {

                phone = phone.substring(2, 11);

            } else if (digitos == 12) {

                phone = phone.substring(3, 12);

            }

            numerosTelefonicos[contador] = phone;

            contador++;

        }

        objCon.desconectar();

    }

    public void contarNumerosTelefonicos2() throws SQLException {

        Conexion objCon = new Conexion();

        objCon.conectar();

        sql = "select distinct(b.phone) from user_bet as a\n"
                + "join user_user as b\n"
                + "on a.idUser= b.id\n"
                + "where "
                + "(a.created_at>='2017-11-15' and a.created_at<='2017-11-16')\n"
                + "\n"
                + "";

        PreparedStatement stm = objCon.getCon().prepareStatement(sql);

        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            /**
             * System.out.println(rs.getString("id")+ ","
             * +rs.getString("idAviso") + "," + rs.getString("idCaracteristica")
             * + "," + rs.getString("valor"));
             */
            String phone = rs.getString("phone");

            if (phone == null) {

                phone = "999999999";

            }

            int digitos = phone.length();

            if (digitos == 10) {
                phone = phone.substring(1, 10);

            } else if (digitos == 11) {

                phone = phone.substring(2, 11);

            } else if (digitos == 12) {

                phone = phone.substring(3, 12);

            }

            numerosTelefonicos2[contador2] = phone;

            contador2++;

        }

        objCon.desconectar();

    }

    public void obtenerDetalles() throws SQLException {

        Conexion objCon = new Conexion();

        objCon.conectar();

        sql = "select \n"
                + "b.phone, \n"
                + "count(b.id) as apuestas,\n"
                + "sum(a.amount) as monto \n"
                + "from db_apuestatotal_prod.user_bet as a\n"
                + "join db_apuestatotal_prod.user_user as b\n"
                + "on a.idUser= b.id\n"
                + "where (a.created_at>='2017-11-10' \n"
                + "and a.created_at<='2017-11-11')\n"
                + "##or (a.created_at>='2017-11-15' and a.created_at<='2017-11-16')\n"
                + "group by b.phone\n"
                + "order by b.phone desc";

        PreparedStatement stm = objCon.getCon().prepareStatement(sql);

        ResultSet rs = stm.executeQuery();
        
        while (rs.next()) {
            
            String phone = rs.getString("phone");
            
            
            if (phone == null) {

                phone = "999999999";

            }
            
             int digitos = phone.length();

            if (digitos == 10) {
                phone = phone.substring(1, 10);

            } else if (digitos == 11) {

                phone = phone.substring(2, 11);

            } else if (digitos == 12) {

                phone = phone.substring(3, 12);

            }
            
          
                
               DetalleBean objBean= new DetalleBean();
                
               objBean.setCelular(phone);
               objBean.setApuestas(rs.getInt("apuestas"));
               objBean.setMonto(rs.getFloat("monto")); 
                
               detalles[contadorDetalle]= objBean;
               
               contadorDetalle++;
                
                
            
            
            
            
            
        }
        
       
    objCon.desconectar();
    
        
        for (int i = 0; i < contadorDetalle; i++) {
            
            
            System.out.println(detalles[i].getCelular()+"*******");
            
        }
    
    

    }
    
    public void obtenerDetalles2() throws SQLException {

        Conexion objCon = new Conexion();

        objCon.conectar();

        sql = "select \n"
                + "b.phone, \n"
                + "count(b.id) as apuestas,\n"
                + "sum(a.amount) as monto \n"
                + "from db_apuestatotal_prod.user_bet as a\n"
                + "join db_apuestatotal_prod.user_user as b\n"
                + "on a.idUser= b.id\n"
                + "where (a.created_at>='2017-11-15' \n"
                + "and a.created_at<='2017-11-16')\n"
                + "##or (a.created_at>='2017-11-15' and a.created_at<='2017-11-16')\n"
                + "group by b.phone\n"
                + "order by b.phone desc";

        PreparedStatement stm = objCon.getCon().prepareStatement(sql);

        ResultSet rs = stm.executeQuery();
        
        while (rs.next()) {
            
            String phone = rs.getString("phone");
            
            
            if (phone == null) {

                phone = "999999999";

            }
            
             int digitos = phone.length();

            if (digitos == 10) {
                phone = phone.substring(1, 10);

            } else if (digitos == 11) {

                phone = phone.substring(2, 11);

            } else if (digitos == 12) {

                phone = phone.substring(3, 12);

            }
            
   
               DetalleBean objBean= new DetalleBean();
                
               objBean.setCelular(phone);
               objBean.setApuestas(rs.getInt("apuestas"));
               objBean.setMonto(rs.getFloat("monto")); 
                
               detalles2[contadorDetalle]= objBean;
               
               contadorDetalle2++;
 
            
        }
        
       
    objCon.desconectar();
    
        
        for (int i = 0; i < contadorDetalle2; i++) {
            
            
            System.out.println(detalles[i].getCelular()+"*******");
            
        }
    
    

    }
    
    
    
    

    public void mostrarNumeros() {

        for (int i = 0; i < contador; i++) {

            System.out.println("Numero " + i + " " + numerosTelefonicos[i]);

        }

        /**
         *
         * for (int i = 0; i < 100000; i++) {
         *
         * if (subCategoria[i].equalsIgnoreCase("")) {
         *
         * } else {
         *
         * System.out.println(i + ";" + subCategoria[i] + ";" + marca[i] + ";" +
         * modelo[i] + ";" + anio[i] + ";" + estado[i] + ";" + color[i] + ";" +
         * combustible[i] + ";" + kilometraje[i] + ";" + motor[i] + ";" +
         * asientos[i] + ";" + transmision[i] + ";" + timon[i] + ";" +
         * traccion[i] + ";" + estilo[i] + ";" + cilindros[i] + ";" +
         * trenManejo[i] + ";" + chasis[i] + ";" + precio[i] + ";" +
         * monedaSimbolo[i] + ";" + fecha[i] + ";" + estadoPublicacion[i] );
         *
         * }
         *
         * }
         *
         *
         */
    }

    public void mostrarNumeros2() {

        for (int i = 0; i < contador2; i++) {

            System.out.println("Numero " + i + " " + numerosTelefonicos2[i]);

        }

        /**
         *
         * for (int i = 0; i < 100000; i++) {
         *
         * if (subCategoria[i].equalsIgnoreCase("")) {
         *
         * } else {
         *
         * System.out.println(i + ";" + subCategoria[i] + ";" + marca[i] + ";" +
         * modelo[i] + ";" + anio[i] + ";" + estado[i] + ";" + color[i] + ";" +
         * combustible[i] + ";" + kilometraje[i] + ";" + motor[i] + ";" +
         * asientos[i] + ";" + transmision[i] + ";" + timon[i] + ";" +
         * traccion[i] + ";" + estilo[i] + ";" + cilindros[i] + ";" +
         * trenManejo[i] + ";" + chasis[i] + ";" + precio[i] + ";" +
         * monedaSimbolo[i] + ";" + fecha[i] + ";" + estadoPublicacion[i] );
         *
         * }
         *
         * }
         *
         *
         */
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String[] getNumerosTelefonicos() {
        return numerosTelefonicos;
    }

    public void setNumerosTelefonicos(String[] numerosTelefonicos) {
        this.numerosTelefonicos = numerosTelefonicos;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String[] getNumerosTelefonicos2() {
        return numerosTelefonicos2;
    }

    public void setNumerosTelefonicos2(String[] numerosTelefonicos2) {
        this.numerosTelefonicos2 = numerosTelefonicos2;
    }

    public int getContador2() {
        return contador2;
    }

    public void setContador2(int contador2) {
        this.contador2 = contador2;
    }

    public int getContadorDetalle() {
        return contadorDetalle;
    }

    public void setContadorDetalle(int contadorDetalle) {
        this.contadorDetalle = contadorDetalle;
    }

    public DetalleBean[] getDetalles() {
        return detalles;
    }

    public void setDetalles(DetalleBean[] detalles) {
        this.detalles = detalles;
    }

    public int getContadorDetalle2() {
        return contadorDetalle2;
    }

    public void setContadorDetalle2(int contadorDetalle2) {
        this.contadorDetalle2 = contadorDetalle2;
    }

    public DetalleBean[] getDetalles2() {
        return detalles2;
    }

    public void setDetalles2(DetalleBean[] detalles2) {
        this.detalles2 = detalles2;
    }
    
    
    
    
    

}
