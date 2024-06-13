
package Entidad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.ObservableList;


public class DetalleVenta {
    Integer Iddetalle_venta;
    String Precio_venta;
    String Fecha;
    String TipoComprobante;
    String DNI;
    Integer IdCliente;
    String Idproducto;

    public DetalleVenta(Integer Iddetalle_venta, String Precio_venta, String Fecha, String TipoComprobante, String DNI, Integer IdCliente, String Idproducto) {
        this.Iddetalle_venta = Iddetalle_venta;
        this.Precio_venta = Precio_venta;
        this.Fecha = Fecha;
        this.TipoComprobante = TipoComprobante;
        this.DNI = DNI;
        this.IdCliente = IdCliente;
        this.Idproducto = Idproducto;
    }

    public DetalleVenta() {
    }

    public void setIddetalle_venta(Integer Iddetalle_venta) {
        this.Iddetalle_venta = Iddetalle_venta;
    }

    public void setPrecio_venta(String Precio_venta) {
        this.Precio_venta = Precio_venta;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public void setTipoComprobante(String TipoComprobante) {
        this.TipoComprobante = TipoComprobante;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setIdCliente(Integer IdCliente) {
        this.IdCliente = IdCliente;
    }

    public void setIdproducto(String Idproducto) {
        this.Idproducto = Idproducto;
    }

    public Integer getIddetalle_venta() {
        return Iddetalle_venta;
    }

    public String getPrecio_venta() {
        return Precio_venta;
    }

    public String getFecha() {
        return Fecha;
    }

    public String getTipoComprobante() {
        return TipoComprobante;
    }

    public String getDNI() {
        return DNI;
    }

    public Integer getIdCliente() {
        return IdCliente;
    }

    public String getIdproducto() {
        return Idproducto;
    }
    
    /*
        Integer Iddetalle_venta;
    Float Precio_venta;
    Long Fecha;
    String TipoComprobante;
    String DNI;
    Integer IdCliente;
    String Idproducto;
    */
    
    public static void llenartabla(Connection connection, 
            ObservableList<DetalleVenta> lista){
        try{
            //Consultar a la base de datos
            Statement instruccion=connection.createStatement();
            ResultSet resultado = instruccion.executeQuery("SELECT * FROM t_trabajador");
            
            while(resultado.next()){
                lista.add(new DetalleVenta(resultado.getInt("Iddetalle_venta"),
                        resultado.getString("Precio_venta"),
                        resultado.getString("Fecha"),
                        resultado.getString("TipoComprobante"),
                        resultado.getString("DNI"),
                        resultado.getInt("IdCliente"),
                        resultado.getString("Idproducto"))
               
                );
            }
       
        }catch (Exception e){
            System.out.println(e);
        
        }
        
    }
    
}
