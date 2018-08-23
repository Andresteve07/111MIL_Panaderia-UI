
package pkg111mil_panaderia.seleccionar;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Application; 
import javafx.collections.ObservableList; 
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.geometry.Orientation; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane; 
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import pkg111mil_panaderia.modelo.TipoProducto;
import pkg111mil_panaderia.ui.ContratoControladorVistas;

public class VistaSeleccionProducto implements ContratoVistaSeleccionProducto{
    private PresentadorSeleccionProducto presentador;
    private ContratoControladorVistas controlador;
    
    private Scene escena;
    private StackPane lienzo;

    public VistaSeleccionProducto(ContratoControladorVistas controlador) {
        this.controlador = controlador;
        this.presentador = new PresentadorSeleccionProducto(this);
        this.crearYInicializarObjetosVisuales();
       // this.presentador.iniciar();
    }
    
  
    
   private void crearYInicializarObjetosVisuales() {
      List<TipoProducto> productos = this.presentador.dameLosProductos();
      //Creating an array of Buttons 
       List<Button> botonesProductos = new ArrayList<>();
       
       for(TipoProducto prod : productos){
           Button boton = new Button(prod.getNombre());
           
           boton.setOnAction(new EventHandler<ActionEvent>() {

               @Override
               public void handle(ActionEvent event) {
                   controlador.lanzarVistaCantidad(prod);
               }
           });
           botonesProductos.add(boton);
        }
       
       for (int i=0;i<botonesProductos.size();i++){
       
        //botonesProductos.get(0).setBackground(background);
        botonesProductos.get(0).setStyle("-fx-background-image: url('criollitos.jpg')");
        botonesProductos.get(1).setStyle("-fx-background-image: url('pastaFrola.jpg')");
        botonesProductos.get(2).setStyle("-fx-background-image: url('panFrances.jpg')");
        botonesProductos.get(3).setStyle("-fx-background-image: url('facturas.jpg')");
        botonesProductos.get(i).setPrefSize(300,200);
        
        }
       botonesProductos.get(0).setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
       botonesProductos.get(1).setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
       botonesProductos.get(2).setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
       botonesProductos.get(3).setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
       
        TilePane tilePane = new TilePane(30.0,30.0);   
        tilePane.setPadding(new Insets(25, 25, 25, 25));
      
         //Setting the orientation for the Tile Pane 
         tilePane.setOrientation(Orientation.HORIZONTAL); 
       
          //Setting the alignment for the Tile Pane 
          tilePane.setTileAlignment(Pos.CENTER_LEFT); 
       
         //Setting the preferred columns for the Tile Pane 
         tilePane.setPrefRows(4);  
      
          //Retrieving the observable list of the Tile Pane 
         ObservableList list = tilePane.getChildren(); 
       
         //Adding the array of buttons to the pane 
         list.addAll(botonesProductos);
            
         
          //Creating a scene object 
          this.escena = new Scene(tilePane);  
   
   } 

    @Override
    public Scene obtenerEscena() {
        return this.escena;
    }
    

   
}
