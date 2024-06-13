
package Entidad;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class ClienteControlador extends Conexion {
    public void ingresarCliente(Cliente img){
        try{
            this.conectar();
            String sql="INSERT INTO t_cliente VALUE(?,?,?,?,?,?);";
            PreparedStatement pre =this.getConnection().prepareStatement(sql);
            pre.setInt(1, 0);
            pre.setString(2, img.getDNI());
            pre.setString(3, img.getNombres());
            pre.setString(4, img.getApellidos());
            pre.setString(5, img.getTelefono());
            pre.setString(6, img.getEmail());
            
       
            //pre.setBytes(1, img.getImagen());
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Ingresados Con exito");
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
}
