/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.ObservableList;


public class Trabajador {
    String DNI;
    String Nombres;
    String Apellidos;
    String Direccion;
    String Telefono;
    String Contrasenia;
    String Sexo;
    String Email;

    public Trabajador(String DNI, String Nombres, String Apellidos, String Direccion, String Telefono, String Contrasenia, String Sexo, String Email) {
        this.DNI = DNI;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Contrasenia = Contrasenia;
        this.Sexo = Sexo;
        this.Email = Email;
    }

    public Trabajador() {
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

    public String getDireccion() {
        return Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public String getSexo() {
        return Sexo;
    }

    public String getEmail() {
        return Email;
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

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public void setContrasenia(String Contrasenia) {
        this.Contrasenia = Contrasenia;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public String toString(){
        return Nombres;
    }
    
    public static void llenartabla(Connection connection, 
            ObservableList<Trabajador> lista){
        try{
            //Consultar a la base de datos
            Statement instruccion=connection.createStatement();
            ResultSet resultado = instruccion.executeQuery("SELECT * FROM t_trabajador");
            
            while(resultado.next()){
                lista.add(new Trabajador(resultado.getString("DNI"),
                        resultado.getString("Nombres"),
                        resultado.getString("Apellidos"),
                        resultado.getString("Direccion"),
                        resultado.getString("Telefono"),
                        resultado.getString("Contrasenia"),
                        resultado.getString("Sexo"),
                        resultado.getString("Email"))
               
                );
            }
       
        }catch (Exception e){
            System.out.println(e);
        
        }
        
    }
        public static void llenarinformacion(Connection connection, 
            ObservableList<Trabajador> lista){
        try{
            //Consultar a la base de datos
            Statement instruccion=connection.createStatement();
            ResultSet resultado = instruccion.executeQuery("SELECT * FROM t_trabajador");
            
            while(resultado.next()){
                lista.add(new Trabajador(resultado.getString("DNI"),
                        resultado.getString("Nombres"),
                        resultado.getString("Apellidos"),
                        resultado.getString("Direccion"),
                        resultado.getString("Telefono"),
                        resultado.getString("Contrasenia"),
                        resultado.getString("Sexo"),
                        resultado.getString("Email"))
               
                );
            }
       
        }catch (Exception e){
            System.out.println(e);
        
        }
        
    }
    
    
    
}
