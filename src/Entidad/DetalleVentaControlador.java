
package Entidad;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class DetalleVentaControlador extends Conexion{
    public void ingresarVenta(DetalleVenta img){
        try{
  
            this.conectar();
            String sql="INSERT INTO t_detalle_venta VALUE(?,?,?,?,?,?,?);";
            PreparedStatement pre =this.getConnection().prepareStatement(sql);
            pre.setInt(1, 0);
            pre.setString(2, img.getPrecio_venta());
            pre.setString(3, img.getFecha());
            pre.setString(4, img.getTipoComprobante());
            pre.setString(5, img.getDNI());
            pre.setInt(6, img.getIdCliente());
            pre.setString(7, img.getIdproducto());
            
       
            //pre.setBytes(1, img.getImagen());
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Ingresados Con exito");
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
}
