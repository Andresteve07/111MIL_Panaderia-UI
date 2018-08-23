/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detalledepedido.Proveedor;

import java.util.ArrayList;
import pkg111mil_panaderia.modelo.DetallePedido;

/**
 *
 * @author PC
 */
public interface ContratoProveedorDetalles {
    
    public ArrayList<DetallePedido> getDetallesPedido();
    public ArrayList<String> getURLS();
    
}
