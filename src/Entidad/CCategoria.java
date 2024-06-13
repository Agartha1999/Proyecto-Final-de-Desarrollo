
package Entidad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.ObservableList;


public class CCategoria {
    String IdCategoria;
    String NombresCategoria;
    
    //Otros Atributos

    public CCategoria(String IdCategoria, String NombresCategoria) {
        this.IdCategoria = IdCategoria;
        this.NombresCategoria = NombresCategoria;
    }

    public CCategoria() {
    }

    public String getIdCategoria() {
        return IdCategoria;
    }

    public String getNombresCategoria() {
        return NombresCategoria;
    }

    public void setIdCategoria(String IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public void setNombresCategoria(String NombresCategoria) {
        this.NombresCategoria = NombresCategoria;
    }
    
    
    //metodos
    public String toString(){
        return NombresCategoria;
    }
    
    public static void llenarInformacion(Connection connection, 
            ObservableList<CCategoria> lista){
        try{
            //Consultar a la base de datos
            Statement sentencia=connection.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT *FROM t_categoria");
            
            while(resultado.next()){
                lista.add(new CCategoria(resultado.getString("IdCategoria"),
                              resultado.getString("NombresCategoria"))
               
                );
            }
       
        }catch (Exception e){
            System.out.println(e);
        
        }
        
    }
    
    public static void llenartabla(Connection connection, 
            ObservableList<CCategoria> lista){
        try{
            //Consultar a la base de datos
            Statement instruccion=connection.createStatement();
            ResultSet resultado = instruccion.executeQuery("SELECT * FROM t_categoria");
            
            while(resultado.next()){
                lista.add(new CCategoria(resultado.getString("IdCategoria"),
                              resultado.getString("NombresCategoria"))
               
                );
            }
       
        }catch (Exception e){
            System.out.println(e);
        
        }
        
    
    }
    
    
}
