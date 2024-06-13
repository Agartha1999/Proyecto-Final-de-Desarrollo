package probar;

import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import Entidad.CCategoria;
import Entidad.Producto;
import Entidad.Conexion;
import Entidad.ProductoCategoria;
import Entidad.ProductoControlador;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class AgregarController implements Initializable {
   //================================================
   //direcciones de atras y salida
   @FXML
   private Button atras;
   @FXML
   private Button cerrar;
   //=====================================================
   //Para cargar y almacenar la imagen
    @FXML
    private Button btnguardar;
    @FXML
    private ImageView ivImagen;
    @FXML
    private TextField Jtxtimagen;
   //============ COMBO BOX PARA CATEGORIA================
   private Conexion conexion;
   @FXML
   //=========================================================
   //private Label tf_imagen;
   // @FXML
    private Text texto;
    @FXML
    private TextField tf_producto;
    @FXML
    private TextField tf_nombre;
    @FXML
    private TextField tf_compra;
    @FXML
    private TextField tf_descripcion;
    //=============================================================
    @FXML private ComboBox<CCategoria> controlador;
    //Colecciones
    private ObservableList<CCategoria> listacategorias;

    private ObservableList<ProductoCategoria> list;
    private ObservableList<Producto> producto;

 
    
    @FXML
    private Button bguardar;
    @FXML
    private Button beliminar;
    @FXML
    private Button bactualizar;
    @FXML
   private TableView<ProductoCategoria> tabla;
    
    @FXML
    private TableColumn<ProductoCategoria, String> C_Idproducto;
    @FXML
    private TableColumn<ProductoCategoria, String> C_Nombre;
    @FXML
    private TableColumn<ProductoCategoria, String> C_Categoria;
    @FXML
    private TableColumn<ProductoCategoria, String> C_Descripcion;
   
    @FXML
    private TableColumn<ProductoCategoria, Byte> C_Imagen;
    @FXML
    private TableColumn<ProductoCategoria,String> C_Precio;
    @FXML
    private Button btLimpiar;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conexion = new Conexion();
        conexion.establecerConexion();
        //Cargar combo box
        listacategorias=FXCollections.observableArrayList();
        
        
        //Cargado de lista de elementos de la base de datos
        CCategoria.llenarInformacion(conexion.getConnection(),listacategorias);
        controlador.setItems(listacategorias); //null
        //LLENAR LA TABLA
        
        list=FXCollections.observableArrayList();
        ProductoCategoria.llenartabla(conexion.getConnection(),list);

        C_Idproducto.setCellValueFactory(new PropertyValueFactory <ProductoCategoria,String> ("Idproducto"));
        C_Nombre.setCellValueFactory(new PropertyValueFactory <ProductoCategoria,String> ("Nombre"));
        C_Categoria.setCellValueFactory(new PropertyValueFactory <ProductoCategoria,String> ("NombresCategoria"));
        C_Descripcion.setCellValueFactory(new PropertyValueFactory <ProductoCategoria,String> ("Descripcion"));
        C_Precio.setCellValueFactory(new PropertyValueFactory <ProductoCategoria,String> ("Precioinicial"));
        C_Imagen.setCellValueFactory(new PropertyValueFactory <ProductoCategoria,Byte> ("Imagen"));
        
        tabla.setItems(list);
        
    } 
    
    //================= BOTONES DE ENTRADA Y DE SALIDA =============================
//===================================================================================
    private void AT1(ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("inicio.fxml"));
        Scene homaepageScene = new Scene(homePage);
        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        appStage.setScene(homaepageScene);
        appStage.show();
    }

    private void inicio(ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene homaepageScene = new Scene(homePage);
        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        appStage.setScene(homaepageScene);
        appStage.show();
    }

    @FXML
    private void AT1(javafx.event.ActionEvent event) throws IOException {
        
        Parent homePage = FXMLLoader.load(getClass().getResource("inicio.fxml"));
        Scene homaepageScene = new Scene(homePage);
        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        appStage.setScene(homaepageScene);
        appStage.show();
    }

    @FXML
    private void inicio(javafx.event.ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene homaepageScene = new Scene(homePage);
        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        appStage.setScene(homaepageScene);
        appStage.show();
    }
//=================================================================================
//=========================================================================================

    private void accionguardar(ActionEvent event) {
        ProductoControlador imc = new ProductoControlador();
        Producto in = new Producto();
        String Id =(tf_producto.getText().trim());
        String nombre =(tf_nombre.getText().trim());
        byte[] byt =(Jtxtimagen.getText()).getBytes();
        String compra =(tf_compra.getText().trim());
        String descripcion =(tf_descripcion.getText().trim());
        if (!controlador.getSelectionModel().isEmpty()) {
        String IdCategoria =(controlador.getValue().getIdCategoria());
        
        in.setIdCategoria(IdCategoria);}
        in.setImagen(byt);
        in.setIdproducto(Id);
        in.setNombre(nombre);
        in.setPrecioinicial(compra);
        in.setDescripcion(descripcion);
        imc.ingresarProducto(in);    
        
      
    }

    @FXML
    public void accioneliminar(javafx.event.ActionEvent event) {
        Producto.eliminartabla(conexion.getConnection(),producto);
        list.remove(tabla.getSelectionModel().getSelectedIndex());
        
    }

    @FXML
    public void accionactualizar(javafx.event.ActionEvent event) {
        list=FXCollections.observableArrayList();
        ProductoCategoria.llenartabla(conexion.getConnection(),list);

        C_Idproducto.setCellValueFactory(new PropertyValueFactory <ProductoCategoria,String> ("Idproducto"));
        C_Nombre.setCellValueFactory(new PropertyValueFactory <ProductoCategoria,String> ("Nombre"));
        C_Categoria.setCellValueFactory(new PropertyValueFactory <ProductoCategoria,String> ("NombresCategoria"));
        C_Descripcion.setCellValueFactory(new PropertyValueFactory <ProductoCategoria,String> ("Descripcion"));
        C_Precio.setCellValueFactory(new PropertyValueFactory <ProductoCategoria,String> ("Precioinicial"));
        C_Imagen.setCellValueFactory(new PropertyValueFactory <ProductoCategoria,Byte> ("Imagen"));
        
        tabla.setItems(list);
    }

    @FXML
    public void accionguardar(javafx.event.ActionEvent event) {
        ProductoControlador imc = new ProductoControlador();
        Producto in = new Producto();
        String Id =(tf_producto.getText().trim());
        String nombre =(tf_nombre.getText().trim());
        byte[] byt =(Jtxtimagen.getText()).getBytes();
        String compra =(tf_compra.getText().trim());
        String descripcion =(tf_descripcion.getText().trim());
        
        if (!controlador.getSelectionModel().isEmpty()) {
        String IdCategoria =(controlador.getValue().getIdCategoria());
        in.setIdCategoria(IdCategoria);}
        
        in.setImagen(byt);
        in.setIdproducto(Id);
        in.setNombre(nombre);
        in.setPrecioinicial(compra);
        in.setDescripcion(descripcion);
        
        imc.ingresarProducto(in);
       
    }
//================================================================================
    @FXML
    private void cargarimagen(javafx.event.ActionEvent event) {
        FileChooser archivo = new FileChooser();
        archivo.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images","*.*"),
                new FileChooser.ExtensionFilter("JPG","*.jpg"),
                new FileChooser.ExtensionFilter("PNG","*.png"),
                new FileChooser.ExtensionFilter("JPEG","*.jpeg")   
        );
        archivo.setTitle("Cargar la imagen");
        File ventana =archivo.showOpenDialog(null);
        if (ventana != null){
            Image ima = new Image("file:" +ventana.getAbsolutePath());
            ivImagen.setImage(ima);
            Jtxtimagen.setText(String.valueOf(ventana.getAbsolutePath()));
            
        }
    }

    @FXML
    public void accionlimpiar(javafx.event.ActionEvent event) {
        tf_producto.setText("");
        tf_nombre.setText("");
        Jtxtimagen.setText("");
        tf_compra.setText("");
        tf_descripcion.setText("");
        controlador.getSelectionModel().select(null);
        
    }
}
