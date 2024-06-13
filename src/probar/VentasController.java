/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probar;

import Entidad.Cliente;
import Entidad.Conexion;
import Entidad.DetalleVenta;
import Entidad.DetalleVentaControlador;
import Entidad.Producto;
import Entidad.TablaFinal;
import Entidad.Trabajador;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class VentasController implements Initializable {

    @FXML
    private ComboBox<Trabajador> C_trabajador;
    @FXML
    private ComboBox<Cliente> C_cliente;
    @FXML
    private ComboBox<Producto> C_producto;
    private ObservableList<Trabajador> trabajador;
    private ObservableList<Cliente> listacliente;
    private ObservableList<Producto> listaproducto;
    private ObservableList<TablaFinal> list;
    //===================================================
    
    //============ COMBO BOX PARA A================
   private Conexion conexion;
    @FXML
    private Button atras;
    @FXML
    private Button cerrarsesion;
    @FXML
    private TextField tf_precioventa;
    @FXML
    private TextField tf_fecha;
    @FXML
    private TextField tf_comprobante;
    @FXML
    private Button btnguardar;
    @FXML
    private Button btnactualizar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private TableColumn<TablaFinal, Integer> C_IddetalleVenta;


    private TableView<TablaFinal> tablavista;
    @FXML
    private AnchorPane TablaCompleta;
    @FXML
    private TableColumn<TablaFinal, String> C_Nombre;
    @FXML
    private TableColumn<TablaFinal, String> C_Precio_venta;
    @FXML
    private TableColumn<TablaFinal, String> C_Fecha;
    @FXML
    private TableColumn<TablaFinal, String> C_TipoComrpobante;
    @FXML
    private TableView<TablaFinal> Tablavista;


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conexion = new Conexion();
        conexion.establecerConexion();
        //Cargar combo box
        trabajador=FXCollections.observableArrayList();
        //Cargado de lista de elementos de la base de datos
        Trabajador.llenarinformacion(conexion.getConnection(),trabajador);
        C_trabajador.setItems(trabajador); //null
        //LLENAR LA TABLA
        
        //Cargar combo box
        listacliente=FXCollections.observableArrayList();
        //Cargado de lista de elementos de la base de datos
        Cliente.llenarInformacion(conexion.getConnection(),listacliente);
        C_cliente.setItems(listacliente); //null
        
        //Cargar combo box
        listaproducto=FXCollections.observableArrayList();
        //Cargado de lista de elementos de la base de datos
        Producto.llenarInformacion(conexion.getConnection(),listaproducto);
        C_producto.setItems(listaproducto); //null
        
        //===========================================================================
        //============================IMPLEMENTACION=================================
        
        list=FXCollections.observableArrayList();
        TablaFinal.llenartabla(conexion.getConnection(),list);

        C_IddetalleVenta.setCellValueFactory(new PropertyValueFactory <TablaFinal,Integer> ("Iddetalleventa"));
        C_Nombre.setCellValueFactory(new PropertyValueFactory <TablaFinal,String> ("Nombre"));
        C_Precio_venta.setCellValueFactory(new PropertyValueFactory <TablaFinal,String> ("Precioventa"));
        C_Fecha.setCellValueFactory(new PropertyValueFactory <TablaFinal,String> ("Fecha"));
        C_TipoComrpobante.setCellValueFactory(new PropertyValueFactory <TablaFinal,String> ("TipoComprobante"));
   
        
        Tablavista.setItems(list);
   
    }    

    @FXML
    private void accionatras(ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("inicio.fxml"));
        Scene homaepageScene = new Scene(homePage);
        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        appStage.setScene(homaepageScene);
        appStage.show();
    }

    @FXML
    private void accioncerrarsesion(ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("cerrarsesion.fxml"));
        Scene homaepageScene = new Scene(homePage);
        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        appStage.setScene(homaepageScene);
        appStage.show();
    }

    @FXML
    private void accion_guardar(ActionEvent event) {
        DetalleVentaControlador imc = new DetalleVentaControlador();
        DetalleVenta in = new DetalleVenta();
        
        String precio =(tf_precioventa.getText().trim());
        String fecha =(tf_fecha.getText().trim());
        String Tipo =(tf_comprobante.getText().trim());
       
        if (!C_producto.getSelectionModel().isEmpty()) {
        String Idproducto =(C_producto.getValue().getIdproducto());
        in.setIdproducto(Idproducto);}
        
        if (!C_cliente.getSelectionModel().isEmpty()) {
        Integer IdCliente =(C_cliente.getValue().getIdCliente());
        in.setIdCliente(IdCliente);}
        
        if (!C_trabajador.getSelectionModel().isEmpty()) {
        String DNI =(C_trabajador.getValue().getDNI());
        in.setDNI(DNI);}
        
        in.setPrecio_venta(precio);
        in.setFecha(fecha);
        in.setTipoComprobante(Tipo);
    
        imc.ingresarVenta(in);    
    }

    @FXML
    private void acciona_ctualizar(ActionEvent event) {
        list=FXCollections.observableArrayList();
        TablaFinal.llenartabla(conexion.getConnection(),list);

        C_IddetalleVenta.setCellValueFactory(new PropertyValueFactory <TablaFinal,Integer> ("Iddetalleventa"));
        C_Nombre.setCellValueFactory(new PropertyValueFactory <TablaFinal,String> ("Nombre"));
        C_Precio_venta.setCellValueFactory(new PropertyValueFactory <TablaFinal,String> ("Precioventa"));
        C_Fecha.setCellValueFactory(new PropertyValueFactory <TablaFinal,String> ("Fecha"));
        C_TipoComrpobante.setCellValueFactory(new PropertyValueFactory <TablaFinal,String> ("TipoComprobante"));
   
        
        Tablavista.setItems(list);
    }

    @FXML
    private void accion_limpiar(ActionEvent event) {
        tf_precioventa.setText("");
        tf_fecha.setText("");
        tf_comprobante.setText("");
        C_producto.getSelectionModel().select(null);
        C_cliente.getSelectionModel().select(null);
        C_trabajador.getSelectionModel().select(null);
    }
    
}
