/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pck_vendedores;

import java.sql.*;

/**
 *
 * @author WINDOWS
 */
public class cls_new {
    
    public static void Vendedores() {

        String url = "jdbc:mysql://localhost:3306/vicvago?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {

            Connection conexion = DriverManager.getConnection(url, "root", "Pompeii1234");

            Statement sentencia = conexion.createStatement();

            String sql = "SELECT * FROM tb_vicvago ";

            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                System.out.println("\nID =" + resultado.getInt(1));
                System.out.println("\nCorrelativo =" + resultado.getInt(2));
                System.out.println("NOMBRE = " + resultado.getString(3));
                System.out.println("ENE =" + resultado.getInt(4));
                System.out.println("FEB =" + resultado.getInt(5));
                System.out.println("MAR =" + resultado.getInt(6));
                System.out.println("ABR =" + resultado.getInt(7));
                System.out.println("MAY =" + resultado.getInt(8));
                System.out.println("JUN =" + resultado.getInt(9));
            }
        } catch (SQLException ex) {
            System.out.println("Hubo hay problemas:" + ex.getMessage());
        }
    }

    public static void SumasMesesVentas() {

        String url = "jdbc:mysql://localhost:3306/vicvago?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {

            Connection conexion = DriverManager.getConnection(url, "root", "Pompeii1234");

            Statement sentencia = conexion.createStatement();

            String sql = "Select id, NOMBRE, (ENE+FEB+MAR+ABR+MAY+JUN) from tb_vicvago";
//            System.out.println(sql);

            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                System.out.println("\nNiv =" + resultado.getInt(1));
                System.out.println("Vendedor = " + resultado.getString(2));
                System.out.println("Total meses venta =" + resultado.getInt(3));
            }

        } catch (SQLException ex) {
            System.out.println("Hubo clavo:" + ex.getMessage());
        }
    }

    public static void Actualizar(int id, String nombre) {
        String url = "jdbc:mysql://localhost:3306/vicvago?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {

            Connection conexion = DriverManager.getConnection(url, "root", "Pompeii1234");

            Statement sentencia = conexion.createStatement();

            String sql = "Update tb_vicvago set NOMBRE = '" + nombre + "' where CORRELATIVO = " + id;
            System.out.println(sql);

            sentencia.execute(sql);

        } catch (SQLException ex) {
            System.out.println("Hubo clavo:" + ex.getMessage());
        }
    }

    public static void Eliminar(int id) {
        int cantidad1 = 0;
        String url = "jdbc:mysql://localhost:3306/vicvago?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {

            Connection conexion = DriverManager.getConnection(url, "root", "Pompeii1234");

            Statement sentencia = conexion.createStatement();

            String sql = "delete from tb_vicvago where CORRELATIVO = " + id;

            System.out.println(sql);

            sentencia.execute(sql);

        } catch (SQLException ex) {
            System.out.println("Hubo clavo:" + ex.getMessage());
        }
    }

 public static void sumames() {

        String url = "jdbc:mysql://localhost:3306/vicvago?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {

            Connection conexion = DriverManager.getConnection(url, "root", "Pompeii1234");

            Statement sentencia = conexion.createStatement();

            String sql = "select sum(ENE), sum(FEB), sum(MAR), sum(ABR), sum(MAY), sum(JUN) from tb_vicvago";

            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                System.out.println("\n\nVentas totales por mes ");
                System.out.println("ENE ="+resultado.getInt(1));
                System.out.println("FEB ="+resultado.getInt(2));
                System.out.println("MAR ="+resultado.getInt(3));
                System.out.println("ABR ="+resultado.getInt(4));
                System.out.println("MAY ="+resultado.getInt(5));
                System.out.println("JUN ="+resultado.getInt(6));
            }
        } catch (SQLException ex) {
            System.out.println("Hubo hay problemas:" + ex.getMessage());
        }
    }   
    public static void main(String[] args) {
        //Vendedores();
//SumasMesesVentas();
//Actualizar(1,"Hola");
//Eliminar(2);
sumames();
    }
}
