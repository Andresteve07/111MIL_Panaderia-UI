package pkg111mil_panaderia.cantidad;

import pkg111mil_panaderia.modelo.DetallePedido;
import pkg111mil_panaderia.modelo.TipoProducto;

public class PresentadorCantidad implements ContratoPresentadorCantidad{
    
    private ContratoVistaCantidad vista;
    private TipoProducto producto;
    
    public PresentadorCantidad(ContratoVistaCantidad vista, TipoProducto producto){
        this.vista = vista;
        this.producto = producto;
    }
    @Override
    public float calcularTotal(float cantidad){
        return this.producto.getPrecioUnitario()* cantidad;
    }
    @Override
    public void iniciar(){
        
    }

    @Override
    public float calcularMontoTotal(float cantidadIngresada) {
           return this.producto.getPrecioUnitario() * cantidadIngresada;
    }

    @Override
    public DetallePedido crearDetalle(float cantidadIngresada) {
        DetallePedido pedido = new DetallePedido(cantidadIngresada, producto);
        return pedido;
    }
}