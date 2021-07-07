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
import Reportes.Pdf;
import Views.ListaAlimentos;

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
    public ListaAlimentos la = new ListaAlimentos();
    public Pdf reportePdf = new Pdf();
}
