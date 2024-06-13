
package Entidad;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    //Atributos
    private Connection connection;
    private String url = "jdbc:mysql://localhost/bd_tienda";
    private String usuario = "root";
    private String contrasena = "";

    //set y get para connection

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public Boolean conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bd_tienda","root","");
            return true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            return false;
            
        }
    
    }
    //Conectarme a la base de datos
    public void establecerConexion(){
        try {
            connection = DriverManager.getConnection(url, usuario, contrasena);
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
    //Cerrar la conexion 
    public void cerrarConexion(){
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
