/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg111mil_panaderia.ui;

import pkg111mil_panaderia.modelo.TipoProducto;

/**
 *
 * @author steve-urbit
 */
public interface ContratoControladorVistas {
    public void lanzarVistaCantidad(TipoProducto productoSeleccionado); 
    public void launchVistaCobranza();    
    public void lanzarDetallePedido();
    public void lanzarSelector();
    
}
