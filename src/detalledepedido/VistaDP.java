/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detalledepedido;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import pkg111mil_panaderia.modelo.DetallePedido;
import pkg111mil_panaderia.ui.ContratoControladorVistas;

/**
 *
 * @author utku30
 */
public class VistaDP implements ContratoVistaDP {
    private ContratoPresentadorDP presentadorDP;
    private ContratoControladorVistas controlador;
    
    
    private Scene scene;
    private GridPane grid;
    private BorderPane panel;
    private int contador;
    
    
    public VistaDP(ContratoControladorVistas controlador) {
        this.controlador = controlador;
        this.presentadorDP = new PresentadorDP(this);
        this.iniciarGrafica();
        this.presentadorDP.iniciar();
    }
    
    
    private void iniciarGrafica(){
        /**
         * CREACION DE PANELES
         */
        // Creacion de la grilla (CENTER OF PANEL)
        this.grid = new GridPane();
        this.grid.setHgap(10);
        this.grid.setVgap(10);
        this.grid.setPadding(new Insets(10));
        
        
        // Creacion de caja horizontal (BOTTOM OF PANEL)
        HBox caja = new HBox();
        caja.setPadding(new Insets(10));
        caja.setSpacing(20);
        caja.setStyle("-fx-background-color: #926B60;");
        caja.setAlignment(Pos.CENTER);
        
        
        // Creacion de caja horizontal (TOP OF PANEL)
        HBox caja2 = new HBox();
        caja2.setPadding(new Insets(10));
        caja2.setStyle("-fx-background-color: #926B60;");
        caja2.setAlignment(Pos.CENTER);
        
        
        /**
         * CREACION Y AGREGADO DE ELEMENTOS A PANELES
         */
        // (BOTTOM) Creacion de elementos y agregado a caja horizontal
        String urlBotonCancelarGeneral = "/detalledepedido/Proveedor/Imagenes/cancelar.png";
        Image imagenBotonCancelar = new Image(urlBotonCancelarGeneral);
        ImageView imagenVistaBotonCancelar = new ImageView(imagenBotonCancelar);
        imagenVistaBotonCancelar.setFitWidth(60);
        imagenVistaBotonCancelar.setFitHeight(60);
        Button botonCancelarGral = new Button("Cancelar Pedidos", imagenVistaBotonCancelar);
        
        String urlBotonCobrar = "/detalledepedido/Proveedor/Imagenes/pesos.jpg";
        Image imagenBotonCobrar = new Image(urlBotonCobrar);
        ImageView imagenVistaBotonCobrar = new ImageView(imagenBotonCobrar);
        imagenVistaBotonCobrar.setFitWidth(60);
        imagenVistaBotonCobrar.setFitHeight(60);
        Button botonCobrar = new Button("Cobrar", imagenVistaBotonCobrar);
        
        
        float totalPedidos = 0;
        for(DetallePedido detalle : this.presentadorDP.getDetallePedido()) {
            totalPedidos += detalle.calcularTotalDetalle();
        }
        Label total = new Label();
        total.setText(String.valueOf(totalPedidos));
        total.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        total.setAlignment(Pos.CENTER);
        
        caja.getChildren().add(botonCobrar);
        caja.getChildren().add(total);
        caja.getChildren().add(botonCancelarGral);
        
        
        // (TOP) Creacion de elementos y agregados a posicion
        Label titulo = new Label("COBRO DE PEDIDOS");
        titulo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        titulo.setAlignment(Pos.CENTER);
        caja2.getChildren().add(titulo);
       
        
        // (CENTER) Creacion de elementos y agregado a la grilla
        List<Label> labelEstado = new ArrayList();
        List<HBox> filasHorizontales = new ArrayList();
            
            int i = 0;
            // Filas Secundarias
            for(DetallePedido detalle : this.presentadorDP.getDetallePedido()) {
                // Obtencion de las caracteristicas de cada detalle
                String producto = detalle.getTipoProducto().getNombre();
                String cantidadProd = String.valueOf(detalle.getCantidad());
                String precioProd = String.valueOf(detalle.getTipoProducto().getPrecioUnitario());

                // Creacion de labels, botones e imagenes de cada fila
                Label nombreProducto = new Label("Producto: " + "\n" + producto);
                Label cantidadProductos = new Label("Cantidad: " + "\n" + cantidadProd);
                Label precioProducto = new Label("Precio Unit.: " + "\n" + precioProd);
                Label estadoPed = new Label("Confirmado");
                
                // Caracteristicas del boton Cancelar
                String urlBoton = "/detalledepedido/Proveedor/Imagenes/cancelar.png";
                Image imagenBoton = new Image(urlBoton);
                ImageView imagenVistaBoton = new ImageView(imagenBoton);
                imagenVistaBoton.setFitWidth(60);
                imagenVistaBoton.setFitHeight(60);
                Button botonCancelar = new Button("Cancelar", imagenVistaBoton);
                
                // Caracteristicas de la imagen del producto
                String url = this.presentadorDP.getURLS().get(i);
                Image imagen = new Image(url);
                ImageView imagenVista = new ImageView(imagen);
                imagenVista.setFitWidth(150);
                imagenVista.setFitHeight(150);

                // Seteo de caracteristicas de labels
                nombreProducto.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                cantidadProductos.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                precioProducto.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                estadoPed.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                
                // Seteo de caracteristicas de la fila
                HBox filaHorizontal = new HBox();
                filaHorizontal.setPadding(new Insets(20));
                filaHorizontal.setSpacing(50);
                filaHorizontal.setAlignment(Pos.CENTER);
                filaHorizontal.setStyle("-fx-padding: 10;" + 
                                        "-fx-border-style: solid inside;" + 
                                        "-fx-border-width: 5;" +
                                        "-fx-border-insets: 5;" + 
                                        "-fx-border-radius: 5;" + 
                                        "-fx-border-color: #614B4B;");
                
                // Agregado de elementos a la fila
                filaHorizontal.getChildren().add(imagenVista);
                filaHorizontal.getChildren().add(nombreProducto);
                filaHorizontal.getChildren().add(cantidadProductos);
                filaHorizontal.getChildren().add(precioProducto);
                filaHorizontal.getChildren().add(estadoPed);
                filaHorizontal.getChildren().add(botonCancelar);

                labelEstado.add(estadoPed);
                filasHorizontales.add(filaHorizontal);
                
                // Seteo de funciones de botones
                botonCancelar.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(estadoPed.getText().equals("Cancelado") != true) {
                        estadoPed.setText("Cancelado");
                        float precioTotal = Float.parseFloat(total.getText());
                        float cantProductosACancelar = Float.parseFloat(cantidadProd);
                        float precioProductoACancelar = Float.parseFloat(precioProd);
                        float precioFinal = precioTotal - (cantProductosACancelar * precioProductoACancelar);

                        String nuevoPrecio = String.valueOf(precioFinal);
                        total.setText(nuevoPrecio);
                    }
                }
                });
                
                i++;
            }
        
    
        /**
         * ACCION DE BOTONES 
         */
        // Boton que cancela los pedidos
        botonCancelarGral.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            // LLAMAR A OTRA VISTA DEL CONTROLADOR???
            total.setText("0");
            for(Label label : labelEstado) {
                label.setText("Cancelado");
            }
        }
        });
        
        
        // Boton que cobra todos los pedidos
        botonCobrar.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            List<Integer> banderas = new ArrayList();
            for(int i = 0; i < labelEstado.size(); i++) {
                Label label = labelEstado.get(i);
                if(label.getText().equals("Cancelado") == true) {
                    banderas.add(0);
                }
                else {
                    banderas.add(1);
                }
            }
           
            int cantPedCanc = 0;
            for(int i = 0; i < banderas.size(); i++) {
                if(banderas.get(i) == 0) {
                    cantPedCanc ++;
                }
            }
            
            if(cantPedCanc < 4){
                imprimirFactura(banderas);
            }
            else {
                System.out.println("Todos los pedidos fueron cancelados!");
            }
            controlador.launchVistaCobranza();
        }
        });
        
        
        // Creacion de caja vertical (CENTER OF PANEL)
        VBox caja3 = new VBox();
        caja3.setPadding(new Insets(10));
        caja3.setSpacing(10);
        caja3.setStyle("-fx-background-color: #CFBAA1;");
        
        Label labelText = new Label("Seleccione una de las opciones siguientes por favor:" + "\n" + 
                "Tenga en cuenta que una vez cancelado el pedido no se puede revertir al estado original.");
        labelText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        labelText.setAlignment(Pos.CENTER);
        caja3.getChildren().add(labelText);
        for(HBox cajaContenedora : filasHorizontales) {
            caja3.getChildren().add(cajaContenedora);
        }
        
        // Creacion del ScrollPane
        ScrollPane scroll = new ScrollPane();
        scroll.setContent(caja3);
        scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
        scroll.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        
        // Creacion del panel Principal
        this.panel = new BorderPane();
        this.panel.setPadding(new Insets(10));
        this.panel.setCenter(scroll);
        this.panel.setBottom(caja);
        this.panel.setTop(caja2);
        
        
        /**
         * Seteo de Escena
         */
        this.scene = new Scene(this.panel, 1035, 800);
        
    }
    
    @Override
    public Scene getScene() {
        return this.scene;
    }

    public void imprimirFactura(List<Integer> lista){
        ArrayList<DetallePedido> pedidosNoCancelados = new ArrayList(); 
        for(int i = 0; i < this.presentadorDP.getDetallePedido().size(); i++) {
            if(lista.get(i) == 1) {
                DetallePedido pedido = this.presentadorDP.getDetallePedido().get(i);
                pedidosNoCancelados.add(pedido);
            }
        }
        float total = 0;
        for(DetallePedido detalle : pedidosNoCancelados) {
            total += detalle.calcularTotalDetalle();
        }
        System.out.println("");
        System.out.println("*** FACTURA ***");
        System.out.println("Tipo Producto         Precio U          Cantidad");
        for(DetallePedido detalle : pedidosNoCancelados) {
            System.out.println(detalle.getTipoProducto().getNombre() + "            " + 
                    detalle.getTipoProducto().getPrecioUnitario() + "               " + detalle.getCantidad());
        }
        System.out.println("");
        System.out.println("Total a pagar: " + total);
        System.out.println("*** FIN DE FACTURA ***");
    }
    
    public int getConteo() {
        return this.contador;
    }
}
