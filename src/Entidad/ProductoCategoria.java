/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class ProductoCategoria {
    String Idproducto;
    String Nombre;
    byte[] Imagen;
    String Precioinicial;
    String Descripcion;
    //atributos adicionales para la tabña
    String NombresCategoria;

    
    public ProductoCategoria(String Idproducto, String Nombre, byte[] Imagen, String Precioinicial, String Descripcion, String NombresCategoria) {
        this.Idproducto = Idproducto;
        this.Nombre = Nombre;
        this.Imagen = Imagen;
        this.Precioinicial = Precioinicial;
        this.Descripcion = Descripcion;
        this.NombresCategoria = NombresCategoria;
    }


    public void setNombresCategoria(String NombresCategoria) {
        this.NombresCategoria = NombresCategoria;
    }

    public String getNombresCategoria() {
        return NombresCategoria;
    }
   
  
    public String getIdproducto() {
        return Idproducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public byte[] getImagen() {
        return Imagen;
    }
    public String getPrecioinicial() {
        return Precioinicial;
    }
    
    public String getDescripcion() {
        return Descripcion;
    }


//============================================================
    public void setIdproducto(String Idproducto) {
        this.Idproducto = Idproducto;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setImagen(byte[] Imagen) {
        this.Imagen = Imagen;
    }
    
    public void setPrecioinicial(String Precioinicial) {
        this.Precioinicial = Precioinicial;
    }
    
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public ProductoCategoria() {
    }

   public static void llenartabla(Connection connection, 
            ObservableList<ProductoCategoria> lista){
        try{
            //Consultar a la base de datos
            Statement instruccion=connection.createStatement();
            ResultSet resultado = instruccion.executeQuery("SELECT P.Idproducto, P.Nombre, P.Descripcion, P.Imagen, P.Precioinicial,C.NombresCategoria\n" +
                                                            "FROM t_producto P INNER JOIN t_categoria C ON P.IdCategoria = C.IdCategoria");
            
            while(resultado.next()){
                lista.add(new ProductoCategoria(resultado.getString("IdProducto"),
                        resultado.getString("Nombre"),
                        resultado.getBytes("Imagen"),
                        resultado.getString("Precioinicial"),
                        resultado.getString("Descripcion"),
                        resultado.getString("NombresCategoria"))
               
                );
            }
       
        }catch (Exception e){
            System.out.println(e);
        
        }
      
   }
   
   public static void eliminartabla(Connection connection, 
            ObservableList<ProductoCategoria> lista){
        try{
            //Consultar a la base de datos
            Statement instruccion=connection.createStatement();
            ResultSet resultado = instruccion.executeQuery("SELECT P.Idproducto, P.Nombre, P.Descripcion, P.Imagen, P.Precioinicial,C.NombresCategoria\n" +
                                                            "FROM t_producto P INNER JOIN t_categoria C ON P.IdCategoria = C.IdCategoria");
            
            while(resultado.next()){
                lista.add(new ProductoCategoria(resultado.getString("IdProducto"),
                        resultado.getString("Nombre"),
                        resultado.getBytes("Imagen"),
                        resultado.getString("Precioinicial"),
                        resultado.getString("Descripcion"),
                        resultado.getString("NombresCategoria"))
               
                );
            }
       
        }catch (Exception e){
            System.out.println(e);
        
        }
      
   }

    
    
}
