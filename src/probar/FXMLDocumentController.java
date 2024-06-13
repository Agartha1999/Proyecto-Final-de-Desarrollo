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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button boton;
    @FXML
    private Button contrsaenia;
    @FXML
    private TextField TextDNI;
    @FXML
    private PasswordField TextContrasena;
    @FXML
    private Label label;
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   

    private void ingresar(ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("inicio.fxml"));
        Scene homaepageScene = new Scene(homePage);
        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        appStage.setScene(homaepageScene);
        appStage.show();
    }

    @FXML
    private void registrar(ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("olvidastecontrasenia.fxml"));
        Scene homaepageScene = new Scene(homePage);
        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        appStage.setScene(homaepageScene);
        appStage.show();
    }

    @FXML
    private void eventAction(ActionEvent event) throws IOException {
        String DNI =TextDNI.getText();
        String Contrasenia = TextContrasena.getText();
        
        if(DNI.equals(" ")&& Contrasenia.equals(" ")){
            JOptionPane.showMessageDialog(null,"UserName or Password Blank ");  
        }else{
            try{
                
                    Class.forName("com.mysql.jdbc.Driver");
                   
                    con = DriverManager.getConnection("jdbc:mysql://localhost/bd_tienda", "root","");
                    pst=con.prepareStatement("select * from t_trabajador where DNI=? and Contrasenia=? ");
                
                    pst.setString(1, DNI);
                    pst.setString(2, Contrasenia);


                    rs=pst.executeQuery();

                    if(rs.next()){
                        JOptionPane.showMessageDialog(null,"ACCESO EXITOSO ");
                        Parent homePage = FXMLLoader.load(getClass().getResource("inicio.fxml"));
                        Scene homaepageScene = new Scene(homePage);
                        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();

                        appStage.setScene(homaepageScene);
                        appStage.show();
                        


                    }else{
                        JOptionPane.showMessageDialog(null,"ERROR DE INICIO DE SESION ");
                        TextDNI.setText("");
                        TextContrasena.setText(" ");
                        TextDNI.requestFocus();
                    }
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
        }
                             
    } 
                
    @FXML
    private void eventkey(KeyEvent event) {
        //validacion de teclado
        Object evt=event.getSource();
        if (evt.equals(TextDNI)){
            if (event.getCharacter().equals(" ")){
                event.consume();
            }
        }else if(evt.equals(TextContrasena)){
            if (event.getCharacter().equals(" ")){
                event.consume();}
            
        }
    }
    
}
