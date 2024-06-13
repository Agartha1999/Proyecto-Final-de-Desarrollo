/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probar;

import Entidad.Cliente;
import Entidad.ClienteControlador;
import Entidad.Conexion;
import Entidad.Producto;
import Entidad.ProductoControlador;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ClientesController implements Initializable {

    @FXML
    private Button atras;
    @FXML
    private Button cerrarsesion;
    @FXML
    private TextField tf_DNI;
    @FXML
    private TextField tf_nombres;
    @FXML
    private TextField tf_apellidos;
    @FXML
    private TextField tf_telefono;
    @FXML
    private TextField tf_email;
    @FXML
    private Button btnguardar;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private TableView<Cliente> TablaTodo;
    @FXML
    private TableColumn<Cliente, Integer> ID;
    @FXML
    private TableColumn<Cliente, String> DNI;
    @FXML
    private TableColumn<Cliente, String> Nombres;
    @FXML
    private TableColumn<Cliente, String> Apellidos;
    @FXML
    private TableColumn<Cliente, String> Telefono;
    @FXML
    private TableColumn<Cliente, String> Email;
    
    @FXML
    private ObservableList<Cliente> list;
    
     //============ COMBO BOX PARA CATEGORIA================
   private Conexion conexion;
   @FXML
   //=========

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conexion = new Conexion();
        conexion.establecerConexion();
        //Cargar combo box
     
        
        list=FXCollections.observableArrayList();
        Cliente.llenartabla(conexion.getConnection(),list);

        ID.setCellValueFactory(new PropertyValueFactory <Cliente,Integer> ("IdCliente"));
        Nombres.setCellValueFactory(new PropertyValueFactory <Cliente,String> ("Nombres"));
        Apellidos.setCellValueFactory(new PropertyValueFactory <Cliente,String> ("Apellidos"));
        DNI.setCellValueFactory(new PropertyValueFactory <Cliente,String> ("DNI"));
        Telefono.setCellValueFactory(new PropertyValueFactory <Cliente,String> ("Telefono"));
        Email.setCellValueFactory(new PropertyValueFactory <Cliente,String> ("Email"));
        
        TablaTodo.setItems(list);
        // TODO
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
        
        ClienteControlador imc = new ClienteControlador();
        Cliente in = new Cliente();
        
        String nombre =(tf_nombres.getText().trim());
        String apellidos =(tf_apellidos.getText()).trim();
        String DNI =(tf_DNI.getText().trim());
        String Telefono =(tf_telefono.getText().trim());
        String Email =(tf_email.getText().trim());
        
        
        in.setNombres(nombre);
        in.setApellidos(apellidos);
        in.setDNI(DNI);
        in.setTelefono(Telefono);
        in.setEmail(Email);
        
        imc.ingresarCliente(in);
    }

    @FXML
    private void accion_actualizar(ActionEvent event) {
        list=FXCollections.observableArrayList();
        Cliente.llenartabla(conexion.getConnection(),list);

        ID.setCellValueFactory(new PropertyValueFactory <Cliente,Integer> ("IdCliente"));
        Nombres.setCellValueFactory(new PropertyValueFactory <Cliente,String> ("Nombres"));
        Apellidos.setCellValueFactory(new PropertyValueFactory <Cliente,String> ("Apellidos"));
        DNI.setCellValueFactory(new PropertyValueFactory <Cliente,String> ("DNI"));
        Telefono.setCellValueFactory(new PropertyValueFactory <Cliente,String> ("Telefono"));
        Email.setCellValueFactory(new PropertyValueFactory <Cliente,String> ("Email"));
        
        TablaTodo.setItems(list);
    }

    @FXML
    private void accion_Limpiar(ActionEvent event) {
        tf_nombres.setText("");
        tf_apellidos.setText("");
        tf_DNI.setText("");
        tf_telefono.setText("");
        tf_email.setText("");
    }
    
}
