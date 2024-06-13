
package Entidad;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class ProductoControlador extends Conexion{
    
    public void ingresarProducto(Producto img){
        try{
            this.conectar();
            String sql="INSERT INTO t_producto VALUE(?,?,?,?,?,?);";
            PreparedStatement pre =this.getConnection().prepareStatement(sql);
            pre.setString(1, img.getIdproducto());
            pre.setString(2, img.getNombre());
            pre.setBytes(3, img.getImagen());
            pre.setString(4, img.getPrecioinicial());
            pre.setString(5, img.getDescripcion());
            pre.setString(6, img.getIdCategoria());
            
       
            //pre.setBytes(1, img.getImagen());
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Ingresados Con exito");
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
 
}
