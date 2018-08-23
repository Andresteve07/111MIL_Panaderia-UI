/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg111mil_panaderia.ui;
import detalledepedido.ContratoVistaDP;
import detalledepedido.VistaDP;
import javafx.application.Application;
import javafx.stage.Stage;
import pkg111mil_panaderia.cantidad.ContratoVistaCantidad;
import pkg111mil_panaderia.modelo.TipoProducto;
import pkg111mil_panaderia.seleccionar.VistaSeleccionProducto;
import pkg111mil_panaderia.cantidad.VistaCantidad;
import pkg111mil_panaderia.cobrar.ContratoVistaCobranza;
import pkg111mil_panaderia.cobrar.VistaCobranza;
import pkg111mil_panaderia.seleccionar.ContratoVistaSeleccionProducto;

/**
 *
 * @author steve-urbit
 */
public class UI extends Application implements ContratoControladorVistas{
    private Stage escenarioPrincipal;
    private ContratoVistaSeleccionProducto vistaSelector;
    private ContratoVistaCobranza vistaCobranza;
    private ContratoVistaCantidad vistaCantidad;
    private ContratoVistaDP vistaDP;
    
   
    
    @Override
    public void start(Stage primaryStage) {
       
        this.escenarioPrincipal = primaryStage;
        this.lanzarSelector();
        this.escenarioPrincipal.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
    @Override
    public void launchVistaCobranza() {
        if(this.vistaCobranza == null){
            this.vistaCobranza = new VistaCobranza();
        }
        this.escenarioPrincipal.setScene(this.vistaCobranza.getScene());
    }

    @Override
    public void lanzarVistaCantidad(TipoProducto productoSeleccionado) {
        if(this.vistaCantidad == null){
            this.vistaCantidad = new VistaCantidad(this, productoSeleccionado);
        }
        this.escenarioPrincipal.setScene(this.vistaCantidad.getScene());
    }

    @Override
    public void lanzarDetallePedido() {
        if(this.vistaDP == null){
            this.vistaDP = new VistaDP(this);
        }
        this.escenarioPrincipal.setScene(this.vistaDP.getScene());
    }

    @Override
    public void lanzarSelector() {
        if(this.vistaSelector == null){
            this.vistaSelector = new VistaSeleccionProducto(this);
        }
        this.escenarioPrincipal.setScene(this.vistaSelector.obtenerEscena());
    }
    
}
