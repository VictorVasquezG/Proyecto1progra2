/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pck_vendedores;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author WINDOWS
 */
public class cls_vendedores {
    
    private static final Scanner s = new Scanner(System.in);
    public static void p2(){
String url = "jdbc:mysql://localhost:3306/vicvago?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
 int suma = 0;
 int sumaF = 0;
 int sumaM = 0;
 int sumaA = 0;
 int sumaMY = 0;
 int sumaJ = 0;
try {
         //paso 2 creamos el objeto conexion
            Connection conexion = DriverManager.getConnection(url,"root","Pompeii1234");
            //paso 3 creamos el objeto statement
            Statement sentencia = conexion.createStatement();
            //paso 4 creamos la instruccion
            String sql = "SELECT * FROM tb_vicvago";
            // paso 5 ejecutamos el query
            ResultSet resultado = sentencia.executeQuery(sql);
            // paso 6. procesar el resultado
            // explicar como se maneja al siguiente registro
            while(resultado.next()){
                System.out.println("ID ="+resultado.getInt(1));
                System.out.println("CORRELATIVO = "+resultado.getInt(2));
                System.out.println("NOMBRE ="+resultado.getString(3));
                System.out.println("ENE ="+resultado.getInt(4));
                System.out.println("FEB ="+resultado.getInt(5));
                System.out.println("MAR ="+resultado.getInt(6));
                System.out.println("ABR ="+resultado.getInt(7));
                System.out.println("MAY ="+resultado.getInt(8));
                System.out.println("JUN ="+resultado.getInt(9));
                
                suma += resultado.getInt(4);
                sumaF += resultado.getInt(5);
                sumaM += resultado.getInt(6);
                sumaA += resultado.getInt(7);
                sumaMY += resultado.getInt(8);
                sumaJ += resultado.getInt(9);
                
                
                
             }
            System.out.println("SUMATORIA TOTAL DE ENERO: "+suma);
            System.out.println("SUMATORIA TOTAL DE FEBRERO: "+sumaF);
            System.out.println("SUMATORIA TOTAL DE MARZO: "+sumaM);
            System.out.println("SUMATORIA TOTAL DE ABRIL: "+sumaA);
            System.out.println("SUMATORIA TOTAL DE MAYO: "+sumaMY);
            System.out.println("SUMATORIA TOTAL DE JUNIO: "+sumaJ);
        } catch (SQLException ex) {
            System.out.println("Hubo clavo:"+ex.getMessage());
        }
}
public static void m_principal() {
    
        int opcion =0;

    System.out.println("""
                       1. CONSULTA DE ID
                       2. LISTADO DE LOS VENDEDORES
                       3. ACTUALIZAR DATOS DE VENDEDORES
                       4. MODIFICAR DATOS DE VENDEDORES""");
    opcion = s.nextInt();
    
    switch(opcion){
        case 1:
            
        case 2:
            p2();
        case 3:
            
        case 4:
    }
    
    
}
    public static void main(String[] args) {
        m_principal();
    }
}
