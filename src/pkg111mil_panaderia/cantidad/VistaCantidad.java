package pkg111mil_panaderia.cantidad;

import java.awt.BorderLayout;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import pkg111mil_panaderia.modelo.TipoProducto;
import pkg111mil_panaderia.ui.ContratoControladorVistas;

public class VistaCantidad implements ContratoVistaCantidad{
    
    private ContratoPresentadorCantidad presentador;
    private ContratoControladorVistas controlador;
    private TipoProducto producto;
    
    private Scene scene;
    private GridPane lienzo;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;
    private Button punto;
    private Button ok;
    private Button cancelar;
    private Button borrar;
    private Label textoCantidad;
    private Label textoMonto;
    private float cantidadIngresada;
    
    public VistaCantidad(ContratoControladorVistas controlador, TipoProducto producto){
        this.controlador = controlador;
        this.producto = producto;
        this.iniciarInterfazGrafica();
        this.presentador = new PresentadorCantidad(this, producto);
        this.presentador.iniciar();
    }
    
    public void iniciarInterfazGrafica(){
        
        BorderPane border = new BorderPane();
        
        VBox vbox = new VBox();
        border.setCenter(vbox);
        vbox.setSpacing(10);
        
        HBox hboxCantidad = new HBox();
        HBox hboxMonto = new HBox();
        hboxMonto.setAlignment(Pos.CENTER_RIGHT);
        
        HBox hboxOk = new HBox();
        //stackPane.setPadding(new Insets(5, 5, 5, 5));
        
        
        this.lienzo = new GridPane();
        //this.lienzo.setAlignment(Pos.CENTER);
        this.lienzo.setHgap(10);
        this.lienzo.setVgap(10);
        //this.lienzo.setPadding(new Insets(20, 20, 20, 20));
        
        
        btn1 = new Button();
        btn2 = new Button();
        btn3 = new Button();
        btn4 = new Button();
        btn5 = new Button();
        btn6 = new Button();
        btn7 = new Button();
        btn8 = new Button();
        btn9 = new Button();
        btn0 = new Button();
        punto = new Button();
        borrar = new Button();
        ok = new Button();
        cancelar = new Button();
        textoCantidad = new Label("");
        textoMonto = new Label("");
        
        textoCantidad.setMinSize(100, 25);
        textoMonto.setMinSize(50, 25);
        //textoMonto.setAlignment(Pos.CENTER_RIGHT);
        
        btn1.setText("1");
        btn2.setText("2");
        btn3.setText(" 3 ");
        btn4.setText("4");
        btn5.setText("5");
        btn6.setText(" 6 ");
        btn7.setText("7");
        btn8.setText("8");
        btn9.setText(" 9 ");
        btn0.setText("0");
        punto.setText(" . ");
        borrar.setText("<-");
        ok.setText("OK");
        cancelar.setText(" X ");
        /*
        this.lienzo.add(this.textoCantidad, 0, 0, 3, 1);
        this.lienzo.add(this.textoMonto, 2, 1, 3, 2);
        this.lienzo.add(btn1, 0, 3);
        this.lienzo.add(btn2, 1, 3);
        this.lienzo.add(btn3, 2, 3);
        this.lienzo.add(btn4, 0, 4);
        this.lienzo.add(btn5, 1, 4);
        this.lienzo.add(btn6, 2, 4);
        this.lienzo.add(btn7, 0, 5);
        this.lienzo.add(btn8, 1, 5);
        this.lienzo.add(btn9, 2, 5);
        this.lienzo.add(punto, 0, 6);
        this.lienzo.add(btn0, 1, 6);
        this.lienzo.add(borrar, 2, 6);
        this.lienzo.add(ok, 0, 7);
        this.lienzo.add(cancelar, 2, 7);*/
        
        hboxCantidad.getChildren().add(textoCantidad);
        hboxMonto.getChildren().add(textoMonto);
        
        this.lienzo.add(btn1, 0, 3);
        this.lienzo.add(btn2, 1, 3);
        this.lienzo.add(btn3, 2, 3);
        this.lienzo.add(btn4, 0, 4);
        this.lienzo.add(btn5, 1, 4);
        this.lienzo.add(btn6, 2, 4);
        this.lienzo.add(btn7, 0, 5);
        this.lienzo.add(btn8, 1, 5);
        this.lienzo.add(btn9, 2, 5);
        this.lienzo.add(punto, 0, 6);
        this.lienzo.add(btn0, 1, 6);
        this.lienzo.add(borrar, 2, 6);
        
        //stackPane.setAlignment(Pos.CENTER_LEFT);
        hboxOk.getChildren().add(ok);
        hboxOk.getChildren().add(cancelar);
        hboxOk.setSpacing(35);
        
        vbox.setPadding(new Insets(10));
        
        
        vbox.getChildren().add(hboxCantidad);
        vbox.getChildren().add(hboxMonto);
        vbox.getChildren().add(lienzo);
        vbox.getChildren().add(hboxOk);
        
        vbox.setAlignment(Pos.CENTER);
        vbox.setMaxWidth(Region.USE_PREF_SIZE);
        this.scene = new Scene(border, 500, 500);
       
        ok.setStyle("-fx-background-color: #00FF00");
        cancelar.setStyle("-fx-background-color: #FF0000");
       
        cantidadIngresada = 0;
       
        btn1.setOnAction((ActionEvent event) -> {
           accionBoton(1);
        });
       
        btn2.setOnAction((ActionEvent event) -> {
           accionBoton(2);
        });
       
        btn3.setOnAction((ActionEvent event) -> {
           accionBoton(3);
        });
       
        btn4.setOnAction((ActionEvent event) -> {
           accionBoton(4);
        });
       
        btn5.setOnAction((ActionEvent event) -> {
           accionBoton(5);
        });
       
        btn6.setOnAction((ActionEvent event) -> {
           accionBoton(6);
        });
       
        btn7.setOnAction((ActionEvent event) -> {
           accionBoton(7);
        });
       
        btn8.setOnAction((ActionEvent event) -> {
           accionBoton(8);
        });
       
        btn9.setOnAction((ActionEvent event) -> {
           accionBoton(9);
        });
       
        btn0.setOnAction((ActionEvent event) -> {
           accionBoton(0);
        });
       
        punto.setOnAction((ActionEvent event) -> {
           textoCantidad.setText(textoCantidad.getText() + ".");
        }); 
       
        cancelar.setOnAction((ActionEvent event) -> {
           textoCantidad.setText("");
           textoMonto.setText("");
        }); 
       
        borrar.setOnAction((ActionEvent event) -> {
           String textoActual = textoCantidad.getText();
           String nuevoTexto = textoActual.substring(0, textoActual.length() - 1);
           this.textoCantidad.setText(nuevoTexto);
           cantidadIngresada = Float.parseFloat(textoCantidad.getText());
           this.textoMonto.setText("" + this.presentador.calcularMontoTotal(cantidadIngresada));
        });
       
        ok.setOnAction((ActionEvent event) -> {
           //presentador.crearDetalle(cantidadIngresada);
           //presentador.calcularMontoTotal(cantidadIngresada);
            controlador.lanzarDetallePedido();
        });
       
        this.textoCantidad.setStyle("-fx-border-color: #000000");
        this.textoMonto.setStyle("-fx-border-color: #000000");
       
    }
    
    private void accionBoton(int numero){
        textoCantidad.setText(textoCantidad.getText() + numero);
        cantidadIngresada = Float.parseFloat(textoCantidad.getText());
        //textoMonto.setText("" + cantidadIngresada*producto.getPrecioUnitario());
        textoMonto.setText("" + this.presentador.calcularMontoTotal(cantidadIngresada));
    }
    
    @Override
    public Scene getScene() {
        return this.scene;
    }
}