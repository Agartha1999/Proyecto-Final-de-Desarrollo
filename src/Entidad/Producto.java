
package Entidad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.ObservableList;

public class Producto {
    String Idproducto;
    String Nombre;
    byte[] Imagen;
    String Precioinicial;
    String Descripcion;
    String IdCategoria;
    //atributos adicionales para la tabña
   
    
    String NombresCategoria;

    public void setNombresCategoria(String NombresCategoria) {
        this.NombresCategoria = NombresCategoria;
    }

    public String getNombresCategoria() {
        return NombresCategoria;
    }
    
    
 

    public Producto(String Idproducto, String Nombre, byte[] Imagen,String Precioinicial, String Descripcion,String IdCategoria) {
        this.Idproducto = Idproducto;
        this.Nombre = Nombre;
        this.Imagen = Imagen;
        this.Precioinicial = Precioinicial;
        this.Descripcion = Descripcion;
        this.IdCategoria=IdCategoria;
    }

    public Producto() {
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

    public String getIdCategoria() {
        return IdCategoria;
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

   
    public void setIdCategoria(String IdCategoria) {
        this.IdCategoria = IdCategoria;
    } 
    
    public String toString(){
        return Nombre;
    }
    
    
    public static void llenarInformacion(Connection connection, 
            ObservableList<Producto> lista){
        try{
            //Consultar a la base de datos
            Statement instruccion=connection.createStatement();
            ResultSet resultado = instruccion.executeQuery("SELECT P.Idproducto, P.Nombre, P.Descripcion, P.Imagen, P.Precioinicial,C.NombresCategoria\n" +
                                                            "FROM t_producto P INNER JOIN t_categoria C ON P.IdCategoria = C.IdCategoria");
            
            while(resultado.next()){
                lista.add(new Producto(resultado.getString("IdProducto"),
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
    
    public static void llenartabla(Connection connection, 
            ObservableList<Producto> lista){
        try{
            //Consultar a la base de datos
            Statement instruccion=connection.createStatement();
            ResultSet resultado = instruccion.executeQuery("SELECT*FROM t_producto");
            
            while(resultado.next()){
                lista.add(new Producto(resultado.getString("IdProducto"),
                        resultado.getString("Nombre"),
                        resultado.getBytes("Imagen"),
                        resultado.getString("Precioinicial"),
                        resultado.getString("Descripcion"),
                        resultado.getString("IdCategoria"))
               
                );
            }
       
        }catch (Exception e){
            System.out.println(e);
        
        }
        
    
    }
    
    public static void eliminartabla(Connection connection, 
            ObservableList<Producto> lista){
        try{
            //Consultar a la base de datos
            Statement instruccion=connection.createStatement();
            ResultSet resultado = instruccion.executeQuery("delete from t_producto where IdProducto");
            
            while(resultado.next()){
                lista.add(new Producto(resultado.getString("IdProducto"),
                        resultado.getString("Nombre"),
                        resultado.getBytes("Imagen"),
                        resultado.getString("Precioinicial"),
                        resultado.getString("Descripcion"),
                        resultado.getString("IdCategoria"))
               
                );
            }
       
        }catch (Exception e){
            System.out.println(e);
        
        }
        
    
    }
    
    
    

    
}
