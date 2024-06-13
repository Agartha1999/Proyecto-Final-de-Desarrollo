
package Entidad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.ObservableList;


public class Cliente {
    Integer IdCliente;
    String DNI;
    String Nombres;
    String Apellidos;
    String Telefono;
    String Email;

    public Cliente(Integer IdCliente, String DNI, String Nombres, String Apellidos, String Telefono, String Email) {
        this.IdCliente = IdCliente;
        this.DNI = DNI;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Telefono = Telefono;
        this.Email = Email;
    }

    public Cliente() {
    }

    public void setIdCliente(Integer IdCliente) {
        this.IdCliente = IdCliente;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Integer getIdCliente() {
        return IdCliente;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getEmail() {
        return Email;
    }
    
    public String toString(){
        return DNI +"-"+Nombres;
    }
    
     public static void llenartabla(Connection connection, 
            ObservableList<Cliente> lista){
        try{
            //Consultar a la base de datos
            Statement instruccion=connection.createStatement();
            ResultSet resultado = instruccion.executeQuery("SELECT * FROM t_cliente");
            
            while(resultado.next()){
                lista.add(new Cliente(resultado.getInt("IdCliente"),
                        resultado.getString("DNI"),
                        resultado.getString("Nombres"),
                        resultado.getString("Apellidos"),
                        resultado.getString("Telefono"),
                        resultado.getString("Email"))
               
                );
            }
       
        }catch (Exception e){
            System.out.println(e);
        
        }
        
    }
     public static void llenarInformacion(Connection connection, 
            ObservableList<Cliente> lista){
        try{
            //Consultar a la base de datos
            Statement instruccion=connection.createStatement();
            ResultSet resultado = instruccion.executeQuery("SELECT * FROM t_cliente");
            
            while(resultado.next()){
                lista.add(new Cliente(resultado.getInt("IdCliente"),
                        resultado.getString("DNI"),
                        resultado.getString("Nombres"),
                        resultado.getString("Apellidos"),
                        resultado.getString("Telefono"),
                        resultado.getString("Email"))
               
                );
            }
       
        }catch (Exception e){
            System.out.println(e);
        
        }
        
    }
    
}
