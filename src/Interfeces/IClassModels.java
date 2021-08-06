/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfeces;

import Controller.AdministracionMV;
import Controller.AlimentosVM;
import Controller.CategoriaVM;
import Controller.ClientesVM;
import Controller.CotizacionesMV;
import Controller.PedidoVM;
import Controller.SuministroVM;
import Controller.VentasVM;
import Models.PedidoSQL;
import Models.ventaSQL;
import Reportes.Pdf;

/**
 * en esta clase interface se intancian todos los objetos de los diferentes modulos correpondientes
 * @author elmer
 */
public interface IClassModels {
    
    public ClientesVM cliente = new ClientesVM();
    public SuministroVM suministro = new SuministroVM();
    public CategoriaVM categoria = new CategoriaVM();
    public AlimentosVM alimento = new AlimentosVM();
    public AdministracionMV administracion = new AdministracionMV();
    public CotizacionesMV cotizacion = new CotizacionesMV();
    public PedidoVM pedido = new PedidoVM();
    public Pdf reportePdf = new Pdf();
    public VentasVM venta = new VentasVM();
    public ventaSQL registro1 = new ventaSQL();
    public PedidoSQL pedidoSQL = new PedidoSQL();
    
}
