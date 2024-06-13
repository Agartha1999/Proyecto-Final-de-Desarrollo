package Entidad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.ObservableList;

public class TablaFinal {
    Integer Iddetalleventa;
    String Nombre;
    String Precioventa;
    String Fecha;
    String TipoComprobante;


    public TablaFinal(Integer Iddetalleventa, String Nombre,String Precioventa, String Fecha, String TipoComprobante) {
        this.Iddetalleventa = Iddetalleventa;
     
        this.Precioventa = Precioventa;
        this.Fecha = Fecha;
        this.TipoComprobante = TipoComprobante;
        this.Nombre = Nombre;
    }

    public Integer getIddetalleventa() {
        return Iddetalleventa;
    }


    public String getPrecioventa() {
        return Precioventa;
    }

    public String getFecha() {
        return Fecha;
    }

    public String getTipoComprobante() {
        return TipoComprobante;
    }

    public String getNombre() {
        return Nombre;
    }

    public TablaFinal() {
    }

    public void setIddetalle_venta(Integer Iddetalleventa) {
        this.Iddetalleventa = Iddetalleventa;
    }



    public void setPrecioventa(String Precioventa) {
        this.Precioventa = Precioventa;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public void setTipoComprobante(String TipoComprobante) {
        this.TipoComprobante = TipoComprobante;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public static void llenartabla(Connection connection, 
            ObservableList<TablaFinal> lista){
        try{
            //Consultar a la base de datos
            Statement instruccion=connection.createStatement();
            ResultSet resultado = instruccion.executeQuery("SELECT C.Iddetalleventa, P.Nombre, C.Precioventa, C.Fecha, C.TipoComprobante\n" +
"FROM t_producto P INNER JOIN t_detalle_venta C ON P.Idproducto = C.Idproducto;");
            /*
                Integer Iddetalle_venta;
    String Nombre;
    String Precio_venta;
    String Fecha;
    String TipoComprobante;
    Integer IdCliente;
            */
            while(resultado.next()){
                lista.add(new TablaFinal(resultado.getInt("Iddetalleventa"),
                        resultado.getString("Nombre"),
                        resultado.getString("Precioventa"),
                        resultado.getString("Fecha"),
                        resultado.getString("TipoComprobante"))
                     
               
                );
            }
       
        }catch (Exception e){
            System.out.println(e);
        
        }
      
   }
    
}
