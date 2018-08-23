/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detalledepedido.Proveedor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pkg111mil_panaderia.modelo.DetallePedido;
import pkg111mil_panaderia.modelo.TipoProducto;
import pkg111mil_panaderia.modelo.UnidadMedida;

/**
 *
 * @author steve-urbit
 */
public class VerdaderoProveedor implements ContratoProveedorDetalles{
    static final String URL_BASE_DE_DATOS = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10253043";
    static final String CONTROLADOR_BASE_DATOS = "com.mysql.jdbc.Driver";
    static final String USUARIO_BASE_DATOS = "sql10253043";
    static final String PASSWORD_BASE_DATOS = "e7pVpksWPQ";
    private ArrayList<String> listaURLS;
    
    public VerdaderoProveedor() {
        listaURLS = new ArrayList<>();
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
        Connection conexion = null;
        PreparedStatement sentenciaParametrizada = null;
        ResultSet resultados = null;
        ArrayList<DetallePedido> detalles = new ArrayList<>();
        TipoProducto tp = new TipoProducto("Criollo   ", 80.66f, UnidadMedida.PESO, 150.0f);
        
        
        try{
            Class.forName(CONTROLADOR_BASE_DATOS);
            conexion = DriverManager.getConnection(
                    URL_BASE_DE_DATOS,
                    USUARIO_BASE_DATOS,
                    PASSWORD_BASE_DATOS);
            //sentencia = conexion.createStatement();           
            sentenciaParametrizada = conexion.prepareStatement(
                    "SELECT cantidad FROM detalle");
            resultados = sentenciaParametrizada.executeQuery();
            while(resultados.next()){
                Float cantidad = resultados.getFloat(1);
                detalles.add(new DetallePedido(cantidad, tp));
            }
            return detalles;
        } catch(SQLException exc){
            exc.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                resultados.close();
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public ArrayList<String> getURLS() {
        return this.listaURLS;
    }
    
}
