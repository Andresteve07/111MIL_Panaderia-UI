/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detalledepedido;

import detalledepedido.Proveedor.ContratoProveedorDetalles;
import detalledepedido.Proveedor.FalsoProveedor;
import detalledepedido.Proveedor.VerdaderoProveedor;
import java.util.ArrayList;
import pkg111mil_panaderia.modelo.DetallePedido;

/**
 *
 * @author utku30
 */
public class PresentadorDP implements ContratoPresentadorDP {
     private ContratoVistaDP vista;
     private ContratoProveedorDetalles proveedor;
    
    public PresentadorDP(ContratoVistaDP vista) {
        this.vista = vista;
        this.proveedor = new VerdaderoProveedor();
    }

    @Override
    public void iniciar() {
        
    }

    @Override
    public ArrayList<DetallePedido> getDetallePedido() {
        return (this.proveedor.getDetallesPedido());
    }
    
    @Override
    public ArrayList<String> getURLS() {
        return this.proveedor.getURLS();
    }
}
