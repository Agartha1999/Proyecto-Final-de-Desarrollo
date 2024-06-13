/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probar;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class OlvidastecontraseniaController implements Initializable {

    @FXML
    private Button menu;
    @FXML
    private TextField tf_dni;
    @FXML
    private TextField tf_apellidos;
    @FXML
    private TextField tf_nombres;
    @FXML
    private TextField tf_direccion;
    @FXML
    private TextField tf_telefono;
    @FXML
    private TextField tf_contrasenia;
    @FXML
    private Button guardar;
    @FXML
    private Label texto;
    @FXML
    private TextField tf_sexo;
    @FXML
    private TextField tf_email;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void atras1(ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene homaepageScene = new Scene(homePage);
        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        appStage.setScene(homaepageScene);
        appStage.show();
    }
    //accion del boton guardar
    @FXML
    private void conectar_bd(ActionEvent event) {
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_tienda","root",""); 
            //USO DE CONExion
            PreparedStatement pst = cn.prepareStatement("INSERT INTO t_trabajador VALUE(?,?,?,?,?,?,?,?)");
            pst.setString(1, tf_dni.getText().trim());
            pst.setString(2, tf_nombres.getText().trim());
            pst.setString(3, tf_apellidos.getText().trim());
            pst.setString(4, tf_direccion.getText().trim());
            pst.setString(5, tf_telefono.getText().trim());
            pst.setString(6, tf_contrasenia.getText().trim());
            pst.setString(7, tf_sexo.getText().trim());
            pst.setString(8, tf_email.getText().trim());
            
            pst.executeUpdate();
           
            tf_dni.setText("");
            tf_nombres.setText("");
            tf_apellidos.setText("");
            tf_direccion.setText("");
            tf_telefono.setText("");
            tf_contrasenia.setText("");
            tf_sexo.setText("");
            tf_email.setText("");
            texto.setText("Bienvenido!!...Usted esta registrado");
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
