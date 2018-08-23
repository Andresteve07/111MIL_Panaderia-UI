/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detalledepedido.Proveedor;

import java.util.ArrayList;
import pkg111mil_panaderia.modelo.DetallePedido;
import pkg111mil_panaderia.modelo.TipoProducto;
import pkg111mil_panaderia.modelo.UnidadMedida;

/**
 *
 * @author PC
 */
public class FalsoProveedor implements ContratoProveedorDetalles{

    private ArrayList<DetallePedido> listaDetalles;
    private ArrayList<String> listaURLS;
    
    public FalsoProveedor() {
        this.listaDetalles = new ArrayList();
        this.listaURLS = new ArrayList();
        
        UnidadMedida medida1 = UnidadMedida.UNIDAD;
        
        TipoProducto tipo1 = new TipoProducto("Criollo   ", 3.50f, medida1, 1000);
        TipoProducto tipo2 = new TipoProducto("Pan Casero", 8.50f, medida1, 1000);
        TipoProducto tipo3 = new TipoProducto("Factura   ", 5.00f, medida1, 1000);
        TipoProducto tipo4 = new TipoProducto("Pan bollo ", 7.00f, medida1, 1000);
        
        DetallePedido detalle1 = new DetallePedido(4, tipo1);
        DetallePedido detalle2 = new DetallePedido(1, tipo2);
        DetallePedido detalle3 = new DetallePedido(5, tipo3);
        DetallePedido detalle4 = new DetallePedido(2, tipo4);
        
        this.listaDetalles.add(detalle1);
        this.listaDetalles.add(detalle2);
        this.listaDetalles.add(detalle3);
        this.listaDetalles.add(detalle4);
        
        String urlCriollo = "/detalledepedido/Proveedor/Imagenes/criollo.jpg";
        String urlPanCasero = "/detalledepedido/Proveedor/Imagenes/pan casero.jpg";
        String urlFactura = "/detalledepedido/Proveedor/Imagenes/factura.jpg";
        String urlPanBollo = "/detalledepedido/Proveedor/Imagenes/bollo de pan.jpg";
        
        listaURLS.add(urlCriollo);
        listaURLS.add(urlPanCasero);
        listaURLS.add(urlFactura);
        listaURLS.add(urlPanBollo);
    }
    
    
    @Override
    public ArrayList<DetallePedido> getDetallesPedido() {
        return this.listaDetalles;
    }
    
    @Override 
    public ArrayList<String> getURLS() {
        return this.listaURLS;
    }
}
