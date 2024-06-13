/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class InicioController implements Initializable {

    @FXML
    private Button agregar2;
    @FXML
    private Button cerrar;
    @FXML
    private Button cerrar1;
    @FXML
    private Button operacion;
    @FXML
    private Button productos;
    @FXML
    private Button clientes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void A1(ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("agregar1.fxml"));
        Scene homaepageScene = new Scene(homePage);
        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        appStage.setScene(homaepageScene);
        appStage.show();
    }
  
    @FXML
    private void A2(ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("agregar.fxml"));
        Scene homaepageScene = new Scene(homePage);
        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        appStage.setScene(homaepageScene);
        appStage.show();
    }

    @FXML
    private void CS(ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("cerrarsesion.fxml"));
        Scene homaepageScene = new Scene(homePage);
        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        appStage.setScene(homaepageScene);
        appStage.show();
    }

    private void ED1(ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("editar1.fxml"));
        Scene homaepageScene = new Scene(homePage);
        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        appStage.setScene(homaepageScene);
        appStage.show();
    }

    private void ED2(ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("editar2.fxml"));
        Scene homaepageScene = new Scene(homePage);
        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        appStage.setScene(homaepageScene);
        appStage.show();
    }

    @FXML
    private void listarfecha(ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("OPERACION.fxml"));
        Scene homaepageScene = new Scene(homePage);
        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        appStage.setScene(homaepageScene);
        appStage.show();
    }

    @FXML
    private void Accion1(ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("ventas.fxml"));
        Scene homaepageScene = new Scene(homePage);
        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        appStage.setScene(homaepageScene);
        appStage.show();
        
    }

    @FXML
    private void accion3(ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("clientes.fxml"));
        Scene homaepageScene = new Scene(homePage);
        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        appStage.setScene(homaepageScene);
        appStage.show();
    }
    
}
