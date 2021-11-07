/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import /*Backup*/ HerrBD.BackupMySQL;
import Conexion.Conexion;
import Controller.ClientesVM;
import Controller.CotizacionesMV;
import Controller.LoginVM;
import Library.Objectos;
import Controller.PedidoVM;
import Controller.UsuariosVM;
import Interfeces.IClassModels;
import Models.PedidoSQL;
import Models.TVentas;
import Models.Usuarios.TUsuarios;
import Models.Venta;
import Models.controlMesa;
import Models.controlPedido;
import Models.ventaSQL;
import java.sql.Statement;
import Reportes.Excel;
import Reportes.JreportJaper;
import Reportes.Pdf;
import SaveColor.ReadColor;
import SaveColor.SaveColor;
import static Views.ListarClientes.apellidoCliente;
import static Views.ListarClientes.nidCliente;
import static Views.ListarClientes.nombreClienteVenta;
import alertas.AlertError;
import alertas.AlertWarningSalir;
import alertas.WarningBackup;
import alertas.WarningRestore;
import app.bolivia.swing.JCTextField;
import java.awt.Color;
import java.awt.Desktop;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import necesario.RSFileChooser;
import rojerusan.RSNotifyFade;
import rojerusan.RSPanelsSlider;

/**
 *
 * @author Gustavo
 */
public class Sistema extends javax.swing.JFrame implements IClassModels {

    /**
     * Creates new form Sistema
     */
    // loging
    private LoginVM login;
    private UsuariosVM usuario;
    private static TUsuarios _dataUsuario;

    private boolean minimiza = false;
    private int idCliente = 0;
    //  private Conexion conexion = Conexion.createInstance();
    private String sql = "";
    private Statement st;
    controlMesa mesas = new controlMesa();
    controlPedido pedidos = new controlPedido();
    private int fac;

    public Sistema(TUsuarios dataUsuario) {

        initComponents();

        _dataUsuario = dataUsuario;
        //CODIGO DE USUARIO
        login = new LoginVM();
        Object[] perfil = {
            jLabelNombreUsuario,
            LabelImage_Usuario,};
        usuario = new UsuariosVM(dataUsuario, perfil);

        //CODIGO DE CLIENTE
        // cliente = new ClientesVM(dataUsuario);
//        if(ReadColor.colorFondo.exists()){
        //            jPanel19.setBackground(ReadColor.leerColorFondo());
        //        }
        //        
        //        if(ReadColor.colorBarra.exists()){
        //            jPanel1.setBackground(ReadColor.leerColorBarra());
        //        }
        //        if(ReadColor.colorTexto.exists()){
        //            texto.setForeground(ReadColor.leerColorTexto());
        //        }
        this.setExtendedState(MAXIMIZED_BOTH);
        JTextField categoria = new JTextField();
        categoria.setText("");
        TabbedPanePrincipal.setSelectedIndex(6);
        //rsscalelabel.RSScaleLabel.setScaleLabel(jLabel6, "src/Resources/logo.png");
        //   TextField_BuscarVentas.setEditable(false);

        tablePedidos.setRowHeight(30);
        tablaCotizaciones.setRowHeight(30);
        tablaVentas.setRowHeight(30);
        tableMostrarPedidos.setRowHeight(30);

        registro1.listar("");
        tipoAl.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (tipoAl.getSelectedIndex() == 0) {
                    tipoL.setIcon(new ImageIcon(getClass().getResource("/Resources/tipoAlL.png")));
                    nombreL.setIcon(new ImageIcon(getClass().getResource("/Resources/nombreL.png")));
                }
                if (tipoAl.getSelectedIndex() == 1) {
                    System.out.println("entro");
                    tipoL.setIcon(new ImageIcon(getClass().getResource("/Resources/bebida.png")));
                    nombreL.setIcon(new ImageIcon(getClass().getResource("/Resources/bebida1.png")));

                    categoria.setText("1");
                }
                if (tipoAl.getSelectedIndex() == 2) {
                    tipoL.setIcon(new ImageIcon(getClass().getResource("/Resources/botana.png")));
                    nombreL.setIcon(new ImageIcon(getClass().getResource("/Resources/botana1.png")));
                    categoria.setText("2");
                }
                if (tipoAl.getSelectedIndex() == 3) {
                    tipoL.setIcon(new ImageIcon(getClass().getResource("/Resources/caldo.png")));
                    nombreL.setIcon(new ImageIcon(getClass().getResource("/Resources/caldo1.png")));
                }
                if (tipoAl.getSelectedIndex() == 4) {
                    tipoL.setIcon(new ImageIcon(getClass().getResource("/Resources/camaron.png")));
                    nombreL.setIcon(new ImageIcon(getClass().getResource("/Resources/camaron1.png")));
                }
                if (tipoAl.getSelectedIndex() == 5) {
                    tipoL.setIcon(new ImageIcon(getClass().getResource("/Resources/coctel.png")));
                    nombreL.setIcon(new ImageIcon(getClass().getResource("/Resources/coctel1.png")));
                }
                if (tipoAl.getSelectedIndex() == 6) {
                    tipoL.setIcon(new ImageIcon(getClass().getResource("/Resources/desayuno.png")));
                    nombreL.setIcon(new ImageIcon(getClass().getResource("/Resources/desayuno1.png")));
                }
                if (tipoAl.getSelectedIndex() == 7) {
                    tipoL.setIcon(new ImageIcon(getClass().getResource("/Resources/filete.png")));
                    nombreL.setIcon(new ImageIcon(getClass().getResource("/Resources/filete1.png")));
                }
                if (tipoAl.getSelectedIndex() == 8) {
                    tipoL.setIcon(new ImageIcon(getClass().getResource("/Resources/langosta.png")));
                    nombreL.setIcon(new ImageIcon(getClass().getResource("/Resources/langosta1.png")));
                }
                if (tipoAl.getSelectedIndex() == 9) {
                    tipoL.setIcon(new ImageIcon(getClass().getResource("/Resources/langostino.png")));
                    nombreL.setIcon(new ImageIcon(getClass().getResource("/Resources/langostino1.png")));
                }
                if (tipoAl.getSelectedIndex() == 10) {
                    tipoL.setIcon(new ImageIcon(getClass().getResource("/Resources/pescado.png")));
                    nombreL.setIcon(new ImageIcon(getClass().getResource("/Resources/pescado1.png")));
                }
                if (tipoAl.getSelectedIndex() == 11) {
                    tipoL.setIcon(new ImageIcon(getClass().getResource("/Resources/pulpo.png")));
                    nombreL.setIcon(new ImageIcon(getClass().getResource("/Resources/pulpo1.png")));
                }
            }
        });
        new rojerusan.RSNotifyFade("Sistema", "Bienvenido al sistema punto de venta", 6, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.SUCCESS).setVisible(true);
        registrarPedido.setEnabled(false);
        busca1.setEnabled(false);
        ComboBoxSuministro1.setEnabled(false);
        borrar1.setEnabled(false);
        cancelar1.setEnabled(false);
        pedidoSQL.listar("");

        rSMaterialButtonRectangle13.setEnabled(false);
        ComboBoxMesas.setEnabled(false);
        rSMaterialButtonRectangle24.setEnabled(false);
        calculo.setEnabled(false);
        vender.setEnabled(false);
        borrar.setEnabled(false);
        cancelar.setEnabled(false);
        rSMaterialButtonRectangle12.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel21 = new javax.swing.JPanel();
        jPanel1Principal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCerrar = new rojerusan.RSButtonMetro();
        btnCerrar1 = new rojerusan.RSButtonMetro();
        TabbedPanePrincipal = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        buscar1 = new app.bolivia.swing.JCTextField();
        codigoL2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        TabbedPaneCliente1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        LabelImage_Cliente = new javax.swing.JLabel();
        LabelCliente_Nid = new javax.swing.JLabel();
        TextFieldCliente_Nid = new javax.swing.JTextField();
        LabelCliente_Nombre = new javax.swing.JLabel();
        TextFieldCliente_Nombre = new javax.swing.JTextField();
        LabelCliente_Apellido = new javax.swing.JLabel();
        TextFieldCliente_Apellido = new javax.swing.JTextField();
        LabelCliente_Email = new javax.swing.JLabel();
        TextFieldCliente_Email = new javax.swing.JTextField();
        LabelCliente_Telefono = new javax.swing.JLabel();
        TextFieldCliente_Telefono = new javax.swing.JTextField();
        LabelCliente_Direccion = new javax.swing.JLabel();
        TextFieldCliente_Direccion = new javax.swing.JTextField();
        CheckBoxCliente_Credito = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        labelReport_Nombre = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        LabelCliente_Nombre3 = new javax.swing.JLabel();
        labelCliente_Deuda = new javax.swing.JLabel();
        LabelCliente_Nombre4 = new javax.swing.JLabel();
        labelCliente_Deuda1 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        LabelCliente_Nombre5 = new javax.swing.JLabel();
        labelCliente_FechaPago = new javax.swing.JLabel();
        LabelCliente_Nombre6 = new javax.swing.JLabel();
        labelCliente_Pago = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        LabelCliente_Nombre7 = new javax.swing.JLabel();
        labelCliente_Ticket = new javax.swing.JLabel();
        labelCliente_Pago1 = new javax.swing.JLabel();
        labelReport_Pagos = new javax.swing.JLabel();
        TextFieldClientes_Pagos = new javax.swing.JTextField();
        ButtonCliente_Agregar = new rojerusan.RSMaterialButtonRectangle();
        ButtonCliente_Cancelar = new rojerusan.RSMaterialButtonRectangle();
        ButtonCliente_Agregar1 = new rojerusan.RSMaterialButtonRectangle();
        jPanel9 = new javax.swing.JPanel();
        TabbedPaneCliente2 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Clientes =   Table_Clientes = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableCliente_Report =   TableCliente_Report = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        LabelCliente_Nombre1 = new javax.swing.JLabel();
        SpinnerPaginas_Clientes = new javax.swing.JSpinner();
        ButtonCliente_Paginas2 = new javax.swing.JButton();
        ButtonCliente_Paginas1 = new javax.swing.JButton();
        ButtonCliente_Paginas3 = new javax.swing.JButton();
        ButtonCliente_Paginas4 = new javax.swing.JButton();
        LabelCliente_Paginas = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TextField_BuscarInventario = new javax.swing.JTextField();
        jTabbedPaneInventario1 = new javax.swing.JTabbedPane();
        jPanel25 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        btnGenerarReporteSuministros = new javax.swing.JButton();
        btnGenerarReporteSuministrosPDF = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        rSMaterialButtonRectangle6 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle7 = new rojerusan.RSMaterialButtonRectangle();
        jPanel28 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        labelReport_Nombre1 = new javax.swing.JLabel();
        LabelInventario_codigo = new javax.swing.JLabel();
        LabelInventario_nombre = new javax.swing.JLabel();
        TextFieldInventario_nombreg = new javax.swing.JLabel();
        LabelInventario_precio = new javax.swing.JLabel();
        LabelInventario_precio1 = new javax.swing.JLabel();
        TextFieldInventario_codigo = new app.bolivia.swing.JCTextField();
        codigoL8 = new javax.swing.JLabel();
        TextFieldInventario_precio = new app.bolivia.swing.JCTextField();
        TextFieldInventario_nombreg1 = new app.bolivia.swing.JCTextField();
        nombreL2 = new javax.swing.JLabel();
        TextFieldInventario_stock = new app.bolivia.swing.JCTextField();
        nombreL3 = new javax.swing.JLabel();
        ComboBoxSuministro = new org.bolivia.combo.SComboBoxBlue();
        rSMaterialButtonRectangle8 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle9 = new rojerusan.RSMaterialButtonRectangle();
        jPanel23 = new javax.swing.JPanel();
        labelReport_Nombre2 = new javax.swing.JLabel();
        LabelInventario_CategoriaNombre = new javax.swing.JLabel();
        TextFieldInventario_categoriaDescrip = new javax.swing.JTextField();
        LabelInventario_CategoriaDescrip = new javax.swing.JLabel();
        TextFieldInventario_CategoriaNombre = new javax.swing.JTextField();
        rSMaterialButtonRectangle10 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle11 = new rojerusan.RSMaterialButtonRectangle();
        jLabel24 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        codigo = new app.bolivia.swing.JCTextField();
        tipoAl = new org.bolivia.combo.SComboBoxBlue();
        tipoL = new javax.swing.JLabel();
        codigoL = new javax.swing.JLabel();
        nombre = new app.bolivia.swing.JCTextField();
        nombreL = new javax.swing.JLabel();
        precio = new app.bolivia.swing.JCTextField();
        nombreL1 = new javax.swing.JLabel();
        jLabelInventario_platillosCodigo = new javax.swing.JLabel();
        jLabelInventario_platillosNombre = new javax.swing.JLabel();
        jLabelInventario_platillosPrecio = new javax.swing.JLabel();
        jLabelInventario_platillosTipo = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        registrar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        jTabbedPaneInventario2 = new javax.swing.JTabbedPane();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        rSTableMetro3 = rSTableMetro3 = new rojerusan.RSTableMetro(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jPanel33 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        xd = xd= new rojerusan.RSTableMetro(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jPanel34 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableInventario_categoria = TableInventario_categoria = new rojerusan.RSTableMetro(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jPanel36 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        buscar = new app.bolivia.swing.JCTextField();
        codigoL1 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TableInventario_platillos = TableInventario_platillos = new rojerusan.RSTableMetro(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        btnGenerarReportePlatillos = new javax.swing.JButton();
        btnGenerarReporteSuministrosPDF1 = new javax.swing.JButton();
        LabelCliente_Nombre2 = new javax.swing.JLabel();
        SpinnerPaginasInventario_suministro2 = new javax.swing.JSpinner();
        LabelInventarioSuministro_Paginas2 = new javax.swing.JLabel();
        ButtonCliente_Paginas8 = new javax.swing.JButton();
        ButtonCliente_Paginas5 = new javax.swing.JButton();
        ButtonCliente_Paginas7 = new javax.swing.JButton();
        ButtonCliente_Paginas6 = new javax.swing.JButton();
        PanelCotizaciones = new javax.swing.JPanel();
        PanelNombre = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        rSLabelFecha3 = new rojeru_san.RSLabelFecha();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel18 = new javax.swing.JPanel();
        jPanel71 = new javax.swing.JPanel();
        jLabelInventario_platillosCodigo2 = new javax.swing.JLabel();
        jLabelInventario_platillosNombre2 = new javax.swing.JLabel();
        jLabelInventario_platillosPrecio2 = new javax.swing.JLabel();
        jLabelInventario_platillosTipo2 = new javax.swing.JLabel();
        rSMaterialButtonRectangle25 = new rojerusan.RSMaterialButtonRectangle();
        borrar2 = new javax.swing.JButton();
        cancelar2 = new javax.swing.JButton();
        rSMaterialButtonRectangle26 = new rojerusan.RSMaterialButtonRectangle();
        jPanel72 = new javax.swing.JPanel();
        TextFieldInventario_codigo1 = new app.bolivia.swing.JCTextField();
        codigoL16 = new javax.swing.JLabel();
        jPanel73 = new javax.swing.JPanel();
        busca2 = new javax.swing.JButton();
        rSMaterialButtonRectangle27 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle28 = new rojerusan.RSMaterialButtonRectangle();
        jScrollPane10 = new javax.swing.JScrollPane();
        tablaCotizaciones = new rojerusan.RSTableMetro();
        jPanel47 = new javax.swing.JPanel();
        TotalCotizacion = new app.bolivia.swing.JCTextField();
        codigoL14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nidCotizacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nombreCotizacion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        apellidoCotizacion = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Subtotal = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        porcentaje = new javax.swing.JTextField();
        descuento = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        dirCotizacion = new javax.swing.JTextField();
        jPanel44 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel51 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        buscar2 = new app.bolivia.swing.JCTextField();
        codigoL9 = new javax.swing.JLabel();
        eliminar1 = new javax.swing.JButton();
        eliminarT = new javax.swing.JButton();
        limpiar1 = new javax.swing.JButton();
        buscF = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ventasH = new javax.swing.JButton();
        ventasH1 = new javax.swing.JButton();
        fecha = new com.toedter.calendar.JDateChooser();
        btnGenerarReporteSuministrosPDF2 = new javax.swing.JButton();
        txtIdVenta = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablaVentas = new rojeru_san.complementos.TableMetro();
        jPanel3 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        rSLabelFecha1 = new rojeru_san.RSLabelFecha();
        codigoL5 = new javax.swing.JLabel();
        recibi = new app.bolivia.swing.JCTextField();
        codigoL6 = new javax.swing.JLabel();
        cambio = new app.bolivia.swing.JCTextField();
        codigoL7 = new javax.swing.JLabel();
        rSMaterialButtonRectangle12 = new rojerusan.RSMaterialButtonRectangle();
        jPanel38 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        numFac = new app.bolivia.swing.JCTextField();
        codigoL4 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        calculo = new javax.swing.JButton();
        vender = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        ComboBoxMesas = new org.bolivia.combo.SComboBoxBlue();
        rSMaterialButtonRectangle30 = new rojerusan.RSMaterialButtonRectangle();
        jPanel40 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaPedidosVenta = tablaPedidosVenta = new rojerusan.RSTableMetro(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        total = new app.bolivia.swing.JCTextField();
        codigoL3 = new javax.swing.JLabel();
        rSMaterialButtonRectangle24 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle31 = new rojerusan.RSMaterialButtonRectangle();
        jPanel45 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        rSMaterialButtonRectangle13 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle29 = new rojerusan.RSMaterialButtonRectangle();
        jPanel31 = new javax.swing.JPanel();
        PanelNombre1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel46 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jLabelInventario_platillosCodigo1 = new javax.swing.JLabel();
        jLabelInventario_platillosNombre1 = new javax.swing.JLabel();
        jLabelInventario_platillosPrecio1 = new javax.swing.JLabel();
        jLabelInventario_platillosTipo1 = new javax.swing.JLabel();
        registrarPedido = new rojerusan.RSMaterialButtonRectangle();
        borrar1 = new javax.swing.JButton();
        cancelar1 = new javax.swing.JButton();
        nuevoPedido = new rojerusan.RSMaterialButtonRectangle();
        ComboBoxSuministro1 = new org.bolivia.combo.SComboBoxBlue();
        jPanel70 = new javax.swing.JPanel();
        rSLabelFecha2 = new rojeru_san.RSLabelFecha();
        codigoL12 = new javax.swing.JLabel();
        jPanel61 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablePedidos = new rojerusan.RSTableMetro();
        jPanel63 = new javax.swing.JPanel();
        busca1 = new javax.swing.JButton();
        registrar1 = new javax.swing.JButton();
        TotalPedidos = new app.bolivia.swing.JCTextField();
        codigoL11 = new javax.swing.JLabel();
        numFac1 = new app.bolivia.swing.JCTextField();
        codigoL10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableMostrarPedidos = new rojerusan.RSTableMetro();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jPanel57 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        mesa1 = new javax.swing.JLabel();
        rSMaterialButtonRectangle14 = new rojerusan.RSMaterialButtonRectangle();
        jPanel59 = new javax.swing.JPanel();
        mesa6 = new javax.swing.JLabel();
        rSMaterialButtonRectangle19 = new rojerusan.RSMaterialButtonRectangle();
        jPanel60 = new javax.swing.JPanel();
        mesa2 = new javax.swing.JLabel();
        rSMaterialButtonRectangle15 = new rojerusan.RSMaterialButtonRectangle();
        jPanel62 = new javax.swing.JPanel();
        mesa7 = new javax.swing.JLabel();
        rSMaterialButtonRectangle20 = new rojerusan.RSMaterialButtonRectangle();
        jPanel64 = new javax.swing.JPanel();
        mesa3 = new javax.swing.JLabel();
        rSMaterialButtonRectangle16 = new rojerusan.RSMaterialButtonRectangle();
        jPanel66 = new javax.swing.JPanel();
        mesa8 = new javax.swing.JLabel();
        rSMaterialButtonRectangle21 = new rojerusan.RSMaterialButtonRectangle();
        jPanel65 = new javax.swing.JPanel();
        mesa4 = new javax.swing.JLabel();
        rSMaterialButtonRectangle17 = new rojerusan.RSMaterialButtonRectangle();
        jPanel67 = new javax.swing.JPanel();
        mesa9 = new javax.swing.JLabel();
        rSMaterialButtonRectangle22 = new rojerusan.RSMaterialButtonRectangle();
        jPanel68 = new javax.swing.JPanel();
        mesa5 = new javax.swing.JLabel();
        rSMaterialButtonRectangle18 = new rojerusan.RSMaterialButtonRectangle();
        jPanel69 = new javax.swing.JPanel();
        mesa10 = new javax.swing.JLabel();
        rSMaterialButtonRectangle23 = new rojerusan.RSMaterialButtonRectangle();
        jPanel49 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jPanel19 = new javax.swing.JPanel();
        LabelImage_Usuario = new rojerusan.RSLabelCircleImage();
        jLabelNombreUsuario = new javax.swing.JLabel();
        rSButtonMaterialIconUno2 = new rsmaterialcomponents.RSButtonMaterialIconUno();
        btnDasboard = new rsmaterialcomponents.RSButtonMaterialIconUno();
        btnVentas = new rsmaterialcomponents.RSButtonMaterialIconUno();
        btnPedidos = new rsmaterialcomponents.RSButtonMaterialIconUno();
        btnContizaciones = new rsmaterialcomponents.RSButtonMaterialIconUno();
        btnInventario = new rsmaterialcomponents.RSButtonMaterialIconUno();
        btnUsuarios = new rsmaterialcomponents.RSButtonMaterialIconUno();
        btnConfiguracion = new rsmaterialcomponents.RSButtonMaterialIconUno();
        btnAbout = new rsmaterialcomponents.RSButtonMaterialIconUno();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        rSPanelsSlider1 = new rojerusan.RSPanelsSlider();
        pnlDasboard = new javax.swing.JPanel();
        jPanel78 = new javax.swing.JPanel();
        rSLabelImage1 = new rojerusan.RSLabelImage();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        jLabel12 = new javax.swing.JLabel();
        rSLabelImage4 = new rojerusan.RSLabelImage();
        rSLabelImage2 = new rojerusan.RSLabelImage();
        pnlInicio = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        rSCalendar1 = new rojerusan.RSCalendar();
        pnlConf = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        rSButtonMetro1 = new rojerusan.RSButtonMetro();
        jLabel11 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        rSButtonMetro3 = new rojerusan.RSButtonMetro();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        btnBackup = new rojerusan.RSButtonMetro();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jPanel74 = new javax.swing.JPanel();
        rSButtonMetro5 = new rojerusan.RSButtonMetro();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        pnlUsuarios = new javax.swing.JPanel();
        jPanel76 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane13 = new javax.swing.JScrollPane();
        jPanel77 = new javax.swing.JPanel();
        TextFieldUsuario_Nombre = new rojerusan.RSMetroTextFullPlaceHolder();
        TextFieldUsuario_Email = new rojerusan.RSMetroTextFullPlaceHolder();
        TextFieldUsuario_Password = new rojerusan.RSMetroTextPassPlaceHolderView();
        btnRegistrar = new rojerusan.RSButtonHover();
        btnCancelar = new rojerusan.RSButtonHover();
        TextFieldUsuario_Apellido = new rojerusan.RSMetroTextFullPlaceHolder();
        TextFieldUsuario_Nid = new rojerusan.RSMetroTextFullPlaceHolder();
        TextFieldUsuario_Telefono = new rojerusan.RSMetroTextFullPlaceHolder();
        TextFieldUsuario_Usuario = new rojerusan.RSMetroTextFullPlaceHolder();
        TextFieldUsuario_Direccion = new rojerusan.RSMetroTextFullPlaceHolder();
        CheckBoxUsuario_State = new javax.swing.JCheckBox();
        ComboBoxUsuario_Role = new rojerusan.RSComboMetro();
        jPanel75 = new javax.swing.JPanel();
        jPanel79 = new javax.swing.JPanel();
        rSFotoSquare1 = new javax.swing.JLabel();
        TextField_BuscarUsuario = new rojerusan.RSMetroTextFullPlaceHolder();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        scrollUsuarios = new javax.swing.JScrollPane();
        Table_Usuarios =   Table_Usuarios = new rojerusan.RSTableMetro(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        pnlUsuarioDenegado = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        ButtonCliente = new javax.swing.JButton();
        ButtonInventario = new javax.swing.JButton();
        ButtonCotizacion = new javax.swing.JButton();
        ButtonClienteConfig = new javax.swing.JButton();
        rSLabelHora1 = new rojeru_san.RSLabelHora();
        ButtonClienteConfig2 = new javax.swing.JButton();
        BtnVentas = new rojerusan.RSButtonRound();

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1Principal.setBackground(new java.awt.Color(34, 102, 145));
        jPanel1Principal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Cooper Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema punto de ventas");

        btnCerrar.setBackground(new java.awt.Color(255, 0, 51));
        btnCerrar.setText("X");
        btnCerrar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnCerrar.setGrosorLinea(3);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnCerrar1.setBackground(new java.awt.Color(255, 0, 51));
        btnCerrar1.setText("__");
        btnCerrar1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnCerrar1.setGrosorLinea(3);
        btnCerrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1PrincipalLayout = new javax.swing.GroupLayout(jPanel1Principal);
        jPanel1Principal.setLayout(jPanel1PrincipalLayout);
        jPanel1PrincipalLayout.setHorizontalGroup(
            jPanel1PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1PrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1PrincipalLayout.setVerticalGroup(
            jPanel1PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1PrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1PrincipalLayout.createSequentialGroup()
                        .addComponent(btnCerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1PrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        TabbedPanePrincipal.setBackground(new java.awt.Color(255, 255, 255));
        TabbedPanePrincipal.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        TabbedPanePrincipal.setEnabled(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(34, 102, 145));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Clientes");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, -1, -1));

        buscar1.setBackground(new java.awt.Color(34, 102, 145));
        buscar1.setForeground(new java.awt.Color(255, 255, 255));
        buscar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buscar1.setOpaque(false);
        buscar1.setPhColor(new java.awt.Color(255, 255, 255));
        buscar1.setPlaceholder("CÓDIGO/NOMBRE");
        buscar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscar1MouseClicked(evt);
            }
        });
        buscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscar1KeyReleased(evt);
            }
        });
        jPanel4.add(buscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 180, -1));

        codigoL2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        codigoL2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buscarL.png"))); // NOI18N
        jPanel4.add(codigoL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 250, 52));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TabbedPaneCliente1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TabbedPaneCliente1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TabbedPaneCliente1StateChanged(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelImage_Cliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelImage_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login.png"))); // NOI18N
        LabelImage_Cliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LabelImage_Cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LabelImage_Cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelImage_ClienteMouseClicked(evt);
            }
        });
        jPanel8.add(LabelImage_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, 114));

        LabelCliente_Nid.setBackground(new java.awt.Color(70, 106, 124));
        LabelCliente_Nid.setText("Nid");

        TextFieldCliente_Nid.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        TextFieldCliente_Nid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldCliente_NidKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldCliente_NidKeyTyped(evt);
            }
        });

        LabelCliente_Nombre.setBackground(new java.awt.Color(70, 106, 124));
        LabelCliente_Nombre.setText("Nombre");

        TextFieldCliente_Nombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        TextFieldCliente_Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldCliente_NombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldCliente_NombreKeyTyped(evt);
            }
        });

        LabelCliente_Apellido.setBackground(new java.awt.Color(70, 106, 124));
        LabelCliente_Apellido.setText("Apellido");

        TextFieldCliente_Apellido.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        TextFieldCliente_Apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldCliente_ApellidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldCliente_ApellidoKeyTyped(evt);
            }
        });

        LabelCliente_Email.setBackground(new java.awt.Color(70, 106, 124));
        LabelCliente_Email.setText("Email");

        TextFieldCliente_Email.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        TextFieldCliente_Email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldCliente_EmailKeyReleased(evt);
            }
        });

        LabelCliente_Telefono.setBackground(new java.awt.Color(70, 106, 124));
        LabelCliente_Telefono.setText("Telefono");

        TextFieldCliente_Telefono.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        TextFieldCliente_Telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldCliente_TelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldCliente_TelefonoKeyTyped(evt);
            }
        });

        LabelCliente_Direccion.setBackground(new java.awt.Color(70, 106, 124));
        LabelCliente_Direccion.setText("Direccion");

        TextFieldCliente_Direccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        TextFieldCliente_Direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldCliente_DireccionKeyReleased(evt);
            }
        });

        CheckBoxCliente_Credito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxCliente_CreditoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextFieldCliente_Nid, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelCliente_Nid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextFieldCliente_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(LabelCliente_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(LabelCliente_Apellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextFieldCliente_Apellido)
                                    .addComponent(TextFieldCliente_Telefono)
                                    .addComponent(LabelCliente_Telefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(LabelCliente_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TextFieldCliente_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(LabelCliente_Direccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(TextFieldCliente_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(2, 2, 2))))))
                            .addComponent(CheckBoxCliente_Credito))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCliente_Nid)
                    .addComponent(LabelCliente_Nombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldCliente_Nid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldCliente_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCliente_Apellido)
                    .addComponent(LabelCliente_Email))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldCliente_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldCliente_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCliente_Telefono)
                    .addComponent(LabelCliente_Direccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldCliente_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldCliente_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckBoxCliente_Credito)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        TabbedPaneCliente1.addTab("Registros deClientes", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelReport_Nombre.setBackground(new java.awt.Color(70, 106, 124));
        labelReport_Nombre.setText("Nombre del cliente");

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        LabelCliente_Nombre3.setBackground(new java.awt.Color(70, 106, 124));
        LabelCliente_Nombre3.setText("Deuda del cliente");

        labelCliente_Deuda.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelCliente_Deuda.setForeground(new java.awt.Color(70, 106, 124));
        labelCliente_Deuda.setText("--/--/--");

        LabelCliente_Nombre4.setBackground(new java.awt.Color(70, 106, 124));
        LabelCliente_Nombre4.setText("Fecha de la deuda");

        labelCliente_Deuda1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelCliente_Deuda1.setForeground(new java.awt.Color(70, 106, 124));
        labelCliente_Deuda1.setText("0.00");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCliente_Deuda1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelCliente_Nombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelCliente_Nombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCliente_Deuda, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCliente_Nombre3)
                    .addComponent(LabelCliente_Nombre4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCliente_Deuda)
                    .addComponent(labelCliente_Deuda1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        LabelCliente_Nombre5.setBackground(new java.awt.Color(70, 106, 124));
        LabelCliente_Nombre5.setText("Ultimo pago del cliente");

        labelCliente_FechaPago.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelCliente_FechaPago.setForeground(new java.awt.Color(70, 106, 124));
        labelCliente_FechaPago.setText("--/--/--");

        LabelCliente_Nombre6.setBackground(new java.awt.Color(70, 106, 124));
        LabelCliente_Nombre6.setText("Fecha del pago");

        labelCliente_Pago.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelCliente_Pago.setForeground(new java.awt.Color(70, 106, 124));
        labelCliente_Pago.setText("0.00");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCliente_Pago, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelCliente_Nombre5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelCliente_Nombre6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCliente_FechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCliente_Nombre5)
                    .addComponent(LabelCliente_Nombre6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCliente_FechaPago)
                    .addComponent(labelCliente_Pago))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        LabelCliente_Nombre7.setBackground(new java.awt.Color(70, 106, 124));
        LabelCliente_Nombre7.setText("Numero del ultimo ticket");

        labelCliente_Ticket.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelCliente_Ticket.setForeground(new java.awt.Color(70, 106, 124));
        labelCliente_Ticket.setText("0000000000");

        labelCliente_Pago1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelCliente_Pago1.setForeground(new java.awt.Color(70, 106, 124));
        labelCliente_Pago1.setText("Ticket:");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelCliente_Nombre7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(labelCliente_Pago1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelCliente_Ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelCliente_Nombre7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCliente_Ticket)
                    .addComponent(labelCliente_Pago1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelReport_Pagos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelReport_Pagos.setForeground(new java.awt.Color(70, 106, 124));
        labelReport_Pagos.setText("Pagos");

        TextFieldClientes_Pagos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelReport_Pagos))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(TextFieldClientes_Pagos, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(labelReport_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelReport_Nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelReport_Pagos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextFieldClientes_Pagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        TabbedPaneCliente1.addTab("Pagos y reportes", jPanel7);

        ButtonCliente_Agregar.setBackground(new java.awt.Color(34, 102, 145));
        ButtonCliente_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        ButtonCliente_Agregar.setText("Ingresar");
        ButtonCliente_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCliente_AgregarActionPerformed(evt);
            }
        });

        ButtonCliente_Cancelar.setBackground(new java.awt.Color(34, 102, 145));
        ButtonCliente_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        ButtonCliente_Cancelar.setText("Cancelar");
        ButtonCliente_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCliente_CancelarActionPerformed(evt);
            }
        });

        ButtonCliente_Agregar1.setBackground(new java.awt.Color(34, 102, 145));
        ButtonCliente_Agregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        ButtonCliente_Agregar1.setText("Eliminar");
        ButtonCliente_Agregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCliente_Agregar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TabbedPaneCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(ButtonCliente_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonCliente_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonCliente_Agregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabbedPaneCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCliente_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(ButtonCliente_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(ButtonCliente_Agregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TabbedPaneCliente2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TabbedPaneCliente2StateChanged(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Table_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Table_Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_ClientesMouseClicked(evt);
            }
        });
        Table_Clientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Table_ClientesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Table_Clientes);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
        );

        TabbedPaneCliente2.addTab("Lista de clientes", jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TableCliente_Report.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TableCliente_Report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableCliente_ReportMouseClicked(evt);
            }
        });
        TableCliente_Report.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TableCliente_ReportKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(TableCliente_Report);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
        );

        TabbedPaneCliente2.addTab("Pagos y reportes", jPanel11);

        LabelCliente_Nombre1.setBackground(new java.awt.Color(70, 106, 124));
        LabelCliente_Nombre1.setText("Registros por paginas");

        SpinnerPaginas_Clientes.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinnerPaginas_ClientesStateChanged(evt);
            }
        });

        ButtonCliente_Paginas2.setBackground(new java.awt.Color(51, 51, 51));
        ButtonCliente_Paginas2.setForeground(new java.awt.Color(51, 51, 51));
        ButtonCliente_Paginas2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Left.png"))); // NOI18N
        ButtonCliente_Paginas2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonCliente_Paginas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCliente_Paginas2ActionPerformed(evt);
            }
        });

        ButtonCliente_Paginas1.setBackground(new java.awt.Color(51, 51, 51));
        ButtonCliente_Paginas1.setForeground(new java.awt.Color(51, 51, 51));
        ButtonCliente_Paginas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Left-12.png"))); // NOI18N
        ButtonCliente_Paginas1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonCliente_Paginas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCliente_Paginas1ActionPerformed(evt);
            }
        });

        ButtonCliente_Paginas3.setBackground(new java.awt.Color(51, 51, 51));
        ButtonCliente_Paginas3.setForeground(new java.awt.Color(51, 51, 51));
        ButtonCliente_Paginas3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Right.png"))); // NOI18N
        ButtonCliente_Paginas3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonCliente_Paginas3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCliente_Paginas3ActionPerformed(evt);
            }
        });

        ButtonCliente_Paginas4.setBackground(new java.awt.Color(51, 51, 51));
        ButtonCliente_Paginas4.setForeground(new java.awt.Color(51, 51, 51));
        ButtonCliente_Paginas4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Right-12.png"))); // NOI18N
        ButtonCliente_Paginas4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonCliente_Paginas4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCliente_Paginas4ActionPerformed(evt);
            }
        });

        LabelCliente_Paginas.setBackground(new java.awt.Color(70, 106, 124));
        LabelCliente_Paginas.setText("Paaginas");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TabbedPaneCliente2)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(LabelCliente_Nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(272, 272, 272)
                                .addComponent(LabelCliente_Paginas, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(SpinnerPaginas_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(246, 246, 246)
                                .addComponent(ButtonCliente_Paginas1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonCliente_Paginas2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonCliente_Paginas3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonCliente_Paginas4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabbedPaneCliente2)
                .addGap(4, 4, 4)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCliente_Nombre1)
                    .addComponent(LabelCliente_Paginas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonCliente_Paginas2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonCliente_Paginas1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonCliente_Paginas3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonCliente_Paginas4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpinnerPaginas_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabbedPanePrincipal.addTab("Clientes", jPanel2);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel17.setBackground(new java.awt.Color(34, 102, 145));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Inventario");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Buscar");

        TextField_BuscarInventario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(289, 289, 289)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextField_BuscarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(TextField_BuscarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneInventario1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPaneInventario1StateChanged(evt);
            }
        });
        jTabbedPaneInventario1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTabbedPaneInventario1KeyPressed(evt);
            }
        });

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setForeground(new java.awt.Color(255, 255, 255));

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnGenerarReporteSuministros.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGenerarReporteSuministros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/excel.png"))); // NOI18N
        btnGenerarReporteSuministros.setText("Excel");
        btnGenerarReporteSuministros.setBorderPainted(false);
        btnGenerarReporteSuministros.setContentAreaFilled(false);
        btnGenerarReporteSuministros.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerarReporteSuministros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGenerarReporteSuministros.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/excel1.png"))); // NOI18N
        btnGenerarReporteSuministros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGenerarReporteSuministros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteSuministrosActionPerformed(evt);
            }
        });

        btnGenerarReporteSuministrosPDF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGenerarReporteSuministrosPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pdf1.png"))); // NOI18N
        btnGenerarReporteSuministrosPDF.setText("PDF");
        btnGenerarReporteSuministrosPDF.setBorderPainted(false);
        btnGenerarReporteSuministrosPDF.setContentAreaFilled(false);
        btnGenerarReporteSuministrosPDF.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerarReporteSuministrosPDF.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGenerarReporteSuministrosPDF.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pdf.png"))); // NOI18N
        btnGenerarReporteSuministrosPDF.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGenerarReporteSuministrosPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteSuministrosPDFActionPerformed(evt);
            }
        });

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/bodega.png"))); // NOI18N

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(btnGenerarReporteSuministros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnGenerarReporteSuministrosPDF)
                .addGap(63, 63, 63))
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 228, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGenerarReporteSuministros, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerarReporteSuministrosPDF))
                .addGap(16, 16, 16))
        );

        rSMaterialButtonRectangle6.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle6.setText("Cancelar");

        rSMaterialButtonRectangle7.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle7.setText("Ingresar");
        rSMaterialButtonRectangle7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(rSMaterialButtonRectangle6, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSMaterialButtonRectangle7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMaterialButtonRectangle6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 148, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPaneInventario1.addTab("Bodega", jPanel25);

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelReport_Nombre1.setBackground(new java.awt.Color(70, 106, 124));
        labelReport_Nombre1.setText("Administrar Suministro");
        jPanel30.add(labelReport_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 142, -1));

        LabelInventario_codigo.setBackground(new java.awt.Color(70, 106, 124));
        LabelInventario_codigo.setText("Código");
        jPanel30.add(LabelInventario_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 80, 30));

        LabelInventario_nombre.setBackground(new java.awt.Color(70, 106, 124));
        LabelInventario_nombre.setText("Nombre");
        jPanel30.add(LabelInventario_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 80, 40));

        TextFieldInventario_nombreg.setBackground(new java.awt.Color(70, 106, 124));
        TextFieldInventario_nombreg.setText("Stock");
        jPanel30.add(TextFieldInventario_nombreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 70, 30));

        LabelInventario_precio.setBackground(new java.awt.Color(70, 106, 124));
        LabelInventario_precio.setText("Precio");
        jPanel30.add(LabelInventario_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 80, 30));

        LabelInventario_precio1.setBackground(new java.awt.Color(70, 106, 124));
        LabelInventario_precio1.setText("Categoria");
        jPanel30.add(LabelInventario_precio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 80, 30));

        TextFieldInventario_codigo.setEditable(false);
        TextFieldInventario_codigo.setBackground(new java.awt.Color(34, 102, 145));
        TextFieldInventario_codigo.setForeground(new java.awt.Color(255, 255, 255));
        TextFieldInventario_codigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextFieldInventario_codigo.setOpaque(false);
        TextFieldInventario_codigo.setPhColor(new java.awt.Color(255, 255, 255));
        TextFieldInventario_codigo.setPlaceholder("CÓDIGO");
        jPanel30.add(TextFieldInventario_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 180, -1));

        codigoL8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/codigoL.png"))); // NOI18N
        jPanel30.add(codigoL8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 250, 60));

        TextFieldInventario_precio.setBackground(new java.awt.Color(34, 102, 145));
        TextFieldInventario_precio.setForeground(new java.awt.Color(255, 255, 255));
        TextFieldInventario_precio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextFieldInventario_precio.setOpaque(false);
        TextFieldInventario_precio.setPhColor(new java.awt.Color(255, 255, 255));
        TextFieldInventario_precio.setPlaceholder("PRECIO");
        TextFieldInventario_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldInventario_precioActionPerformed(evt);
            }
        });
        TextFieldInventario_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldInventario_precioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldInventario_precioKeyTyped(evt);
            }
        });
        jPanel30.add(TextFieldInventario_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 180, -1));

        TextFieldInventario_nombreg1.setBackground(new java.awt.Color(34, 102, 145));
        TextFieldInventario_nombreg1.setForeground(new java.awt.Color(255, 255, 255));
        TextFieldInventario_nombreg1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextFieldInventario_nombreg1.setOpaque(false);
        TextFieldInventario_nombreg1.setPhColor(new java.awt.Color(255, 255, 255));
        TextFieldInventario_nombreg1.setPlaceholder("NOMBRE ALIMENTO");
        TextFieldInventario_nombreg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldInventario_nombreg1ActionPerformed(evt);
            }
        });
        TextFieldInventario_nombreg1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldInventario_nombreg1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldInventario_nombreg1KeyTyped(evt);
            }
        });
        jPanel30.add(TextFieldInventario_nombreg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 180, -1));

        nombreL2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/nombreL.png"))); // NOI18N
        jPanel30.add(nombreL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 250, 60));

        TextFieldInventario_stock.setBackground(new java.awt.Color(34, 102, 145));
        TextFieldInventario_stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldInventario_stockKeyTyped(evt);
            }
        });
        jPanel30.add(TextFieldInventario_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 162, 240, 40));

        nombreL3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/precioL.png"))); // NOI18N
        jPanel30.add(nombreL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 243, 52));

        ComboBoxSuministro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONAR CATEGORIA" }));
        ComboBoxSuministro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ComboBoxSuministro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxSuministroActionPerformed(evt);
            }
        });
        jPanel30.add(ComboBoxSuministro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 220, 40));

        rSMaterialButtonRectangle8.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle8.setText("Ingresar");
        rSMaterialButtonRectangle8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle8ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle9.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle9.setText("Cancelar");
        rSMaterialButtonRectangle9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(rSMaterialButtonRectangle8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSMaterialButtonRectangle9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMaterialButtonRectangle9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(179, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 178, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneInventario1.addTab("Suministros", jPanel28);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        labelReport_Nombre2.setBackground(new java.awt.Color(70, 106, 124));
        labelReport_Nombre2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelReport_Nombre2.setText("Administrar Categoria");

        LabelInventario_CategoriaNombre.setBackground(new java.awt.Color(70, 106, 124));
        LabelInventario_CategoriaNombre.setText("Nombre");

        TextFieldInventario_categoriaDescrip.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        TextFieldInventario_categoriaDescrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldInventario_categoriaDescripActionPerformed(evt);
            }
        });
        TextFieldInventario_categoriaDescrip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldInventario_categoriaDescripKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldInventario_categoriaDescripKeyTyped(evt);
            }
        });

        LabelInventario_CategoriaDescrip.setBackground(new java.awt.Color(70, 106, 124));
        LabelInventario_CategoriaDescrip.setText("Descripcion");

        TextFieldInventario_CategoriaNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        TextFieldInventario_CategoriaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldInventario_CategoriaNombreActionPerformed(evt);
            }
        });
        TextFieldInventario_CategoriaNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldInventario_CategoriaNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldInventario_CategoriaNombreKeyTyped(evt);
            }
        });

        rSMaterialButtonRectangle10.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle10.setText("Ingresar");
        rSMaterialButtonRectangle10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle10ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle11.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle11.setText("Cancelar");
        rSMaterialButtonRectangle11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle11ActionPerformed(evt);
            }
        });

        jLabel24.setForeground(new java.awt.Color(255, 51, 51));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/categoria.png"))); // NOI18N

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(rSMaterialButtonRectangle10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rSMaterialButtonRectangle11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 198, Short.MAX_VALUE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TextFieldInventario_CategoriaNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                    .addComponent(LabelInventario_CategoriaNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelInventario_CategoriaDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextFieldInventario_categoriaDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelReport_Nombre2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelReport_Nombre2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelInventario_CategoriaDescrip)
                    .addComponent(LabelInventario_CategoriaNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldInventario_categoriaDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldInventario_CategoriaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMaterialButtonRectangle10, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(172, Short.MAX_VALUE))
        );

        jTabbedPaneInventario1.addTab("Categoria", jPanel23);

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "REGISTRO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        codigo.setEditable(false);
        codigo.setBackground(new java.awt.Color(34, 102, 145));
        codigo.setForeground(new java.awt.Color(255, 255, 255));
        codigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        codigo.setOpaque(false);
        codigo.setPhColor(new java.awt.Color(255, 255, 255));
        codigo.setPlaceholder("CÓDIGO");
        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });
        jPanel41.add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 180, -1));

        tipoAl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TIPO ALIMENTO", "BEBIDAS", "BOTANAS", "CALDOS", "CAMARONES", "COCTELES", "DESAYUNOS", "FILETE", "LANGOSTA", "LANGOSTINO", "PESCADO", "PULPO" }));
        tipoAl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tipoAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoAlActionPerformed(evt);
            }
        });
        jPanel41.add(tipoAl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 183, -1));

        tipoL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tipoAlL.png"))); // NOI18N
        jPanel41.add(tipoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 60, 52));

        codigoL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/codigoL.png"))); // NOI18N
        jPanel41.add(codigoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 250, 60));

        nombre.setBackground(new java.awt.Color(34, 102, 145));
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nombre.setOpaque(false);
        nombre.setPhColor(new java.awt.Color(255, 255, 255));
        nombre.setPlaceholder("NOMBRE ALIMENTO");
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        jPanel41.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 180, -1));

        nombreL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/nombreL.png"))); // NOI18N
        jPanel41.add(nombreL, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 250, 60));

        precio.setBackground(new java.awt.Color(34, 102, 145));
        precio.setForeground(new java.awt.Color(255, 255, 255));
        precio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        precio.setOpaque(false);
        precio.setPhColor(new java.awt.Color(255, 255, 255));
        precio.setPlaceholder("PRECIO");
        precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioKeyTyped(evt);
            }
        });
        jPanel41.add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 180, -1));

        nombreL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/precioL.png"))); // NOI18N
        jPanel41.add(nombreL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 243, 52));
        jPanel41.add(jLabelInventario_platillosCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 70, 40));
        jPanel41.add(jLabelInventario_platillosNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 70, 40));
        jPanel41.add(jLabelInventario_platillosPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 70, 50));
        jPanel41.add(jLabelInventario_platillosTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 70, 50));

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));
        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "OPCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        registrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/regis1.png"))); // NOI18N
        registrar.setText("Registrar");
        registrar.setBorderPainted(false);
        registrar.setContentAreaFilled(false);
        registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        registrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/regis2.png"))); // NOI18N
        registrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/actualizar.png"))); // NOI18N
        actualizar.setText("Actualizar");
        actualizar.setBorderPainted(false);
        actualizar.setContentAreaFilled(false);
        actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        actualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        actualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/actualizar1.png"))); // NOI18N
        actualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrar1.png"))); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.setBorderPainted(false);
        eliminar.setContentAreaFilled(false);
        eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        eliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrar2.png"))); // NOI18N
        eliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        limpiar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/limpiar1.png"))); // NOI18N
        limpiar.setText("Limpiar");
        limpiar.setBorderPainted(false);
        limpiar.setContentAreaFilled(false);
        limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        limpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        limpiar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/limpiar2.png"))); // NOI18N
        limpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(registrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel35Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(178, Short.MAX_VALUE)))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addContainerGap(439, Short.MAX_VALUE)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel35Layout.createSequentialGroup()
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 302, Short.MAX_VALUE)))
        );

        jTabbedPaneInventario1.addTab("Platillos", jPanel35);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        rSTableMetro3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(rSTableMetro3);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneInventario2.addTab("Bodega", jPanel24);

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));

        xd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        xd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xdMouseClicked(evt);
            }
        });
        xd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                xdKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(xd);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPaneInventario2.addTab("Suministros", jPanel33);

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));

        TableInventario_categoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableInventario_categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableInventario_categoriaMouseClicked(evt);
            }
        });
        TableInventario_categoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TableInventario_categoriaKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(TableInventario_categoria);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPaneInventario2.addTab("Categoria", jPanel34);

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));
        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "BUSQUEDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscar.setBackground(new java.awt.Color(34, 102, 145));
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buscar.setOpaque(false);
        buscar.setPhColor(new java.awt.Color(255, 255, 255));
        buscar.setPlaceholder("CÓDIGO/NOMBRE");
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarMouseClicked(evt);
            }
        });
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
        });
        jPanel43.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 180, -1));

        codigoL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        codigoL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buscarL.png"))); // NOI18N
        jPanel43.add(codigoL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 250, 52));

        TableInventario_platillos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableInventario_platillos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableInventario_platillosMouseClicked(evt);
            }
        });
        TableInventario_platillos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TableInventario_platillosKeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(TableInventario_platillos);

        btnGenerarReportePlatillos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGenerarReportePlatillos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/excel.png"))); // NOI18N
        btnGenerarReportePlatillos.setText("Excel");
        btnGenerarReportePlatillos.setBorderPainted(false);
        btnGenerarReportePlatillos.setContentAreaFilled(false);
        btnGenerarReportePlatillos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerarReportePlatillos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGenerarReportePlatillos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/excel1.png"))); // NOI18N
        btnGenerarReportePlatillos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGenerarReportePlatillos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReportePlatillosActionPerformed(evt);
            }
        });

        btnGenerarReporteSuministrosPDF1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGenerarReporteSuministrosPDF1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pdf1.png"))); // NOI18N
        btnGenerarReporteSuministrosPDF1.setText("PDF");
        btnGenerarReporteSuministrosPDF1.setBorderPainted(false);
        btnGenerarReporteSuministrosPDF1.setContentAreaFilled(false);
        btnGenerarReporteSuministrosPDF1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerarReporteSuministrosPDF1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGenerarReporteSuministrosPDF1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pdf.png"))); // NOI18N
        btnGenerarReporteSuministrosPDF1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGenerarReporteSuministrosPDF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteSuministrosPDF1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGenerarReportePlatillos)
                        .addGap(37, 37, 37)
                        .addComponent(btnGenerarReporteSuministrosPDF1)
                        .addGap(0, 304, Short.MAX_VALUE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGenerarReporteSuministrosPDF1)
                            .addComponent(btnGenerarReportePlatillos, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneInventario2.addTab("Platillos", jPanel36);

        LabelCliente_Nombre2.setBackground(new java.awt.Color(70, 106, 124));
        LabelCliente_Nombre2.setText("Registros por paginas");

        SpinnerPaginasInventario_suministro2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinnerPaginasInventario_suministro2StateChanged(evt);
            }
        });

        LabelInventarioSuministro_Paginas2.setBackground(new java.awt.Color(70, 106, 124));
        LabelInventarioSuministro_Paginas2.setText("Paaginas");

        ButtonCliente_Paginas8.setBackground(new java.awt.Color(51, 51, 51));
        ButtonCliente_Paginas8.setForeground(new java.awt.Color(51, 51, 51));
        ButtonCliente_Paginas8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Right-12.png"))); // NOI18N
        ButtonCliente_Paginas8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonCliente_Paginas8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCliente_Paginas8ActionPerformed(evt);
            }
        });

        ButtonCliente_Paginas5.setBackground(new java.awt.Color(51, 51, 51));
        ButtonCliente_Paginas5.setForeground(new java.awt.Color(51, 51, 51));
        ButtonCliente_Paginas5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Left-12.png"))); // NOI18N
        ButtonCliente_Paginas5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonCliente_Paginas5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCliente_Paginas5ActionPerformed(evt);
            }
        });

        ButtonCliente_Paginas7.setBackground(new java.awt.Color(51, 51, 51));
        ButtonCliente_Paginas7.setForeground(new java.awt.Color(51, 51, 51));
        ButtonCliente_Paginas7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Right.png"))); // NOI18N
        ButtonCliente_Paginas7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonCliente_Paginas7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCliente_Paginas7ActionPerformed(evt);
            }
        });

        ButtonCliente_Paginas6.setBackground(new java.awt.Color(51, 51, 51));
        ButtonCliente_Paginas6.setForeground(new java.awt.Color(51, 51, 51));
        ButtonCliente_Paginas6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Left.png"))); // NOI18N
        ButtonCliente_Paginas6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonCliente_Paginas6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCliente_Paginas6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jTabbedPaneInventario1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelCliente_Nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SpinnerPaginasInventario_suministro2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(58, 58, 58)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(135, 135, 135)
                                        .addComponent(LabelInventarioSuministro_Paginas2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(ButtonCliente_Paginas5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ButtonCliente_Paginas6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ButtonCliente_Paginas7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ButtonCliente_Paginas8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jTabbedPaneInventario2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPaneInventario1)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jTabbedPaneInventario2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelCliente_Nombre2)
                            .addComponent(LabelInventarioSuministro_Paginas2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SpinnerPaginasInventario_suministro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonCliente_Paginas6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonCliente_Paginas5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonCliente_Paginas7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonCliente_Paginas8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        TabbedPanePrincipal.addTab("inventario", jPanel16);

        PanelCotizaciones.setBackground(new java.awt.Color(255, 255, 255));
        PanelCotizaciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PanelNombre.setBackground(new java.awt.Color(34, 102, 145));
        PanelNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cotizaciones");

        rSLabelFecha3.setForeground(new java.awt.Color(255, 255, 255));
        rSLabelFecha3.setToolTipText("");
        rSLabelFecha3.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 24)); // NOI18N

        javax.swing.GroupLayout PanelNombreLayout = new javax.swing.GroupLayout(PanelNombre);
        PanelNombre.setLayout(PanelNombreLayout);
        PanelNombreLayout.setHorizontalGroup(
            PanelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNombreLayout.createSequentialGroup()
                .addGap(437, 437, 437)
                .addComponent(jLabel9)
                .addGap(106, 106, 106)
                .addComponent(rSLabelFecha3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelNombreLayout.setVerticalGroup(
            PanelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNombreLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rSLabelFecha3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        jTabbedPane2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane2StateChanged(evt);
            }
        });

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jPanel71.setBackground(new java.awt.Color(255, 255, 255));
        jPanel71.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "REGISTRO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        rSMaterialButtonRectangle25.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Cancelar.png"))); // NOI18N
        rSMaterialButtonRectangle25.setText("Registrar cotizacón");
        rSMaterialButtonRectangle25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle25ActionPerformed(evt);
            }
        });

        borrar2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        borrar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elimina2.png"))); // NOI18N
        borrar2.setContentAreaFilled(false);
        borrar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        borrar2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        borrar2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        borrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar2ActionPerformed(evt);
            }
        });

        cancelar2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cancelar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cancela2.png"))); // NOI18N
        cancelar2.setContentAreaFilled(false);
        cancelar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cancelar2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelar2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar2ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle26.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Cancelar.png"))); // NOI18N
        rSMaterialButtonRectangle26.setText("nUEVA COTIZACIÓN");
        rSMaterialButtonRectangle26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle26ActionPerformed(evt);
            }
        });

        jPanel72.setBackground(new java.awt.Color(255, 255, 255));
        jPanel72.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TextFieldInventario_codigo1.setBackground(new java.awt.Color(34, 102, 145));
        TextFieldInventario_codigo1.setForeground(new java.awt.Color(255, 255, 255));
        TextFieldInventario_codigo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextFieldInventario_codigo1.setOpaque(false);
        TextFieldInventario_codigo1.setPhColor(new java.awt.Color(255, 255, 255));
        TextFieldInventario_codigo1.setPlaceholder("CÓDIGO");
        jPanel72.add(TextFieldInventario_codigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, -1));

        codigoL16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/codigoL.png"))); // NOI18N
        jPanel72.add(codigoL16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 60));

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel71Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel71Layout.createSequentialGroup()
                        .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelInventario_platillosPrecio2)
                            .addComponent(jLabelInventario_platillosNombre2)
                            .addComponent(jLabelInventario_platillosCodigo2)
                            .addComponent(jLabelInventario_platillosTipo2)
                            .addGroup(jPanel71Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cancelar2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(borrar2)
                                        .addComponent(rSMaterialButtonRectangle25, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rSMaterialButtonRectangle26, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelInventario_platillosPrecio2)
                    .addComponent(jLabelInventario_platillosNombre2)
                    .addComponent(jLabelInventario_platillosCodigo2)
                    .addComponent(jLabelInventario_platillosTipo2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSMaterialButtonRectangle26, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSMaterialButtonRectangle25, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(borrar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelar2)
                .addGap(113, 113, 113))
        );

        jPanel73.setBackground(new java.awt.Color(255, 255, 255));
        jPanel73.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        busca2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        busca2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/alimento2.png"))); // NOI18N
        busca2.setContentAreaFilled(false);
        busca2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        busca2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        busca2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        busca2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busca2ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle27.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Cancelar.png"))); // NOI18N
        rSMaterialButtonRectangle27.setText("BUscar Cliente");
        rSMaterialButtonRectangle27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle27ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle28.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Cancelar.png"))); // NOI18N
        rSMaterialButtonRectangle28.setText("Nuevo Cliente");
        rSMaterialButtonRectangle28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle28ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel73Layout = new javax.swing.GroupLayout(jPanel73);
        jPanel73.setLayout(jPanel73Layout);
        jPanel73Layout.setHorizontalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSMaterialButtonRectangle27, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rSMaterialButtonRectangle28, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(busca2)
                .addContainerGap(437, Short.MAX_VALUE))
        );
        jPanel73Layout.setVerticalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(busca2)
                    .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rSMaterialButtonRectangle27, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rSMaterialButtonRectangle28, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaCotizaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "PRECIO $", "CANTIDAD", "IMPORTE $"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(tablaCotizaciones);

        jPanel47.setBackground(new java.awt.Color(255, 255, 255));
        jPanel47.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));

        TotalCotizacion.setBackground(new java.awt.Color(34, 102, 145));
        TotalCotizacion.setForeground(new java.awt.Color(255, 255, 255));
        TotalCotizacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TotalCotizacion.setOpaque(false);
        TotalCotizacion.setPhColor(new java.awt.Color(255, 255, 255));
        TotalCotizacion.setPlaceholder("TOTAL");
        TotalCotizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalCotizacionActionPerformed(evt);
            }
        });

        codigoL14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/total.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Datos del Cliente");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NID");

        nidCotizacion.setEditable(false);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("NOMBRE:");

        nombreCotizacion.setEditable(false);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("APELLIDO:");

        apellidoCotizacion.setEditable(false);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("SUBTOTAL:");

        Subtotal.setEditable(false);
        Subtotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SubtotalKeyReleased(evt);
            }
        });

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("DESCUENTO (%) :");

        porcentaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                porcentajeKeyReleased(evt);
            }
        });

        descuento.setEditable(false);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("DIRECCIÓN:");

        dirCotizacion.setEditable(false);

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel47Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(TotalCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(codigoL14)))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel47Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(porcentaje))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Subtotal, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(descuento))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel47Layout.createSequentialGroup()
                                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dirCotizacion, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(apellidoCotizacion)))
                            .addGroup(jPanel47Layout.createSequentialGroup()
                                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel47Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(nombreCotizacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                            .addComponent(nidCotizacion, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(22, 22, 22)))
                .addContainerGap())
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nidCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nombreCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidoCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(dirCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(Subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(TotalCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(codigoL14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE))
                    .addComponent(jPanel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jPanel73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Nueva cotizacion ", jPanel18);

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1268, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Buscar Cotizacion ", jPanel44);

        javax.swing.GroupLayout PanelCotizacionesLayout = new javax.swing.GroupLayout(PanelCotizaciones);
        PanelCotizaciones.setLayout(PanelCotizacionesLayout);
        PanelCotizacionesLayout.setHorizontalGroup(
            PanelCotizacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCotizacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCotizacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2))
                .addContainerGap())
        );
        PanelCotizacionesLayout.setVerticalGroup(
            PanelCotizacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCotizacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        TabbedPanePrincipal.addTab("Cotizaciones", PanelCotizaciones);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel51.setBackground(new java.awt.Color(255, 255, 255));

        jPanel52.setBackground(new java.awt.Color(255, 255, 255));

        jPanel54.setBackground(new java.awt.Color(255, 255, 255));
        jPanel54.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "OPCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel54.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscar2.setBackground(new java.awt.Color(34, 102, 145));
        buscar2.setForeground(new java.awt.Color(255, 255, 255));
        buscar2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buscar2.setOpaque(false);
        buscar2.setPhColor(new java.awt.Color(255, 255, 255));
        buscar2.setPlaceholder("No. VENTA");
        buscar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscar2MouseClicked(evt);
            }
        });
        buscar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscar2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscar2KeyTyped(evt);
            }
        });
        jPanel54.add(buscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 180, -1));

        codigoL9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        codigoL9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buscarL.png"))); // NOI18N
        jPanel54.add(codigoL9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 250, 52));

        eliminar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrar1.png"))); // NOI18N
        eliminar1.setText("Eliminar");
        eliminar1.setBorderPainted(false);
        eliminar1.setContentAreaFilled(false);
        eliminar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        eliminar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eliminar1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrar2.png"))); // NOI18N
        eliminar1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrar2.png"))); // NOI18N
        eliminar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        eliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar1ActionPerformed(evt);
            }
        });
        jPanel54.add(eliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        eliminarT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eliminarT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrarT1.png"))); // NOI18N
        eliminarT.setText("Eliminar Todo");
        eliminarT.setBorderPainted(false);
        eliminarT.setContentAreaFilled(false);
        eliminarT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        eliminarT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eliminarT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrarT2.png"))); // NOI18N
        eliminarT.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/borrarT2.png"))); // NOI18N
        eliminarT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        eliminarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarTActionPerformed(evt);
            }
        });
        jPanel54.add(eliminarT, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, -1, -1));

        limpiar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        limpiar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/limpiar1.png"))); // NOI18N
        limpiar1.setText("Limpiar Campos");
        limpiar1.setBorderPainted(false);
        limpiar1.setContentAreaFilled(false);
        limpiar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        limpiar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        limpiar1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/limpiar2.png"))); // NOI18N
        limpiar1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/limpiar2.png"))); // NOI18N
        limpiar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        limpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar1ActionPerformed(evt);
            }
        });
        jPanel54.add(limpiar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, -1, -1));

        buscF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buscF.setToolTipText("Buscar");
        buscF.setBorderPainted(false);
        buscF.setContentAreaFilled(false);
        buscF.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buscF.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buscF.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buscF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscFActionPerformed(evt);
            }
        });
        jPanel54.add(buscF, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Fecha");
        jPanel54.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        ventasH.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ventasH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buscaF1.png"))); // NOI18N
        ventasH.setToolTipText("Buscar");
        ventasH.setBorderPainted(false);
        ventasH.setContentAreaFilled(false);
        ventasH.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ventasH.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ventasH.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buscaF2.png"))); // NOI18N
        ventasH.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ventasH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventasHActionPerformed(evt);
            }
        });
        jPanel54.add(ventasH, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        ventasH1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ventasH1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ventasH2.png"))); // NOI18N
        ventasH1.setToolTipText("Buscar");
        ventasH1.setBorderPainted(false);
        ventasH1.setContentAreaFilled(false);
        ventasH1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ventasH1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ventasH1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ventasH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventasH1ActionPerformed(evt);
            }
        });
        jPanel54.add(ventasH1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        fecha.setDateFormatString("dd/MM/yyyy");
        fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel54.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 150, 30));

        btnGenerarReporteSuministrosPDF2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGenerarReporteSuministrosPDF2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pdf1.png"))); // NOI18N
        btnGenerarReporteSuministrosPDF2.setText("PDF");
        btnGenerarReporteSuministrosPDF2.setBorderPainted(false);
        btnGenerarReporteSuministrosPDF2.setContentAreaFilled(false);
        btnGenerarReporteSuministrosPDF2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerarReporteSuministrosPDF2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGenerarReporteSuministrosPDF2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pdf.png"))); // NOI18N
        btnGenerarReporteSuministrosPDF2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGenerarReporteSuministrosPDF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteSuministrosPDF2ActionPerformed(evt);
            }
        });
        jPanel54.add(btnGenerarReporteSuministrosPDF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));
        jPanel54.add(txtIdVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 80, 40));

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No. Venta", "Nombre", "Apellido", "Total", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaVentas.setColorBackgoundHead(new java.awt.Color(0, 112, 192));
        tablaVentas.setColorFilasForeground1(new java.awt.Color(0, 112, 192));
        tablaVentas.setColorSelBackgound(new java.awt.Color(0, 112, 192));
        tablaVentas.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tablaVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVentasMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tablaVentas);

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(180, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Información de ventas", jPanel51);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );

        TabbedPanePrincipal.addTab("Administración financiera", jPanel20);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel15.setBackground(new java.awt.Color(34, 102, 145));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ventas");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(354, 354, 354)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSLabelFecha1.setForeground(new java.awt.Color(255, 255, 255));
        rSLabelFecha1.setToolTipText("");
        rSLabelFecha1.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 24)); // NOI18N
        jPanel37.add(rSLabelFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 180, 33));

        codigoL5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/fecha.png"))); // NOI18N
        jPanel37.add(codigoL5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 250, 50));

        recibi.setBackground(new java.awt.Color(34, 102, 145));
        recibi.setForeground(new java.awt.Color(255, 255, 255));
        recibi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        recibi.setOpaque(false);
        recibi.setPhColor(new java.awt.Color(255, 255, 255));
        recibi.setPlaceholder("RECIBI");
        jPanel37.add(recibi, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 130, -1));

        codigoL6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/recibi.png"))); // NOI18N
        codigoL6.setToolTipText("RECIBI");
        jPanel37.add(codigoL6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 195, 52));

        cambio.setEditable(false);
        cambio.setBackground(new java.awt.Color(34, 102, 145));
        cambio.setForeground(new java.awt.Color(255, 255, 255));
        cambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cambio.setOpaque(false);
        cambio.setPhColor(new java.awt.Color(255, 255, 255));
        cambio.setPlaceholder("CAMBIO");
        jPanel37.add(cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 130, -1));

        codigoL7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cambio.png"))); // NOI18N
        codigoL7.setToolTipText("CAMBIO");
        jPanel37.add(codigoL7, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 195, 52));

        rSMaterialButtonRectangle12.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle12.setText("Buscar Cliente");
        rSMaterialButtonRectangle12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle12ActionPerformed(evt);
            }
        });
        jPanel37.add(rSMaterialButtonRectangle12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 169, 50));

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("NÚMERO DE VENTA");
        jPanel38.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, -1));

        numFac.setEditable(false);
        numFac.setBackground(new java.awt.Color(34, 102, 145));
        numFac.setForeground(new java.awt.Color(255, 255, 255));
        numFac.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numFac.setOpaque(false);
        numFac.setPhColor(new java.awt.Color(255, 255, 255));
        numFac.setPlaceholder("FACTURA");
        numFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numFacActionPerformed(evt);
            }
        });
        jPanel38.add(numFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 130, 30));

        codigoL4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/numFac.png"))); // NOI18N
        jPanel38.add(codigoL4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, 50));

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "OPCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel39.setToolTipText("");
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        calculo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        calculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/calculo2.png"))); // NOI18N
        calculo.setContentAreaFilled(false);
        calculo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        calculo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        calculo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        calculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculoActionPerformed(evt);
            }
        });
        jPanel39.add(calculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, 50));

        vender.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/venta2.png"))); // NOI18N
        vender.setContentAreaFilled(false);
        vender.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        vender.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vender.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        vender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venderActionPerformed(evt);
            }
        });
        jPanel39.add(vender, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 200, 50));

        borrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elimina2.png"))); // NOI18N
        borrar.setContentAreaFilled(false);
        borrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        borrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        borrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        jPanel39.add(borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 190, 60));

        cancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cancela2.png"))); // NOI18N
        cancelar.setContentAreaFilled(false);
        cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel39.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 190, 50));

        ComboBoxMesas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONAR MESA", "MESA 1", "MESA 2", "MESA 3", "MESA 4", "MESA 5", "MESA 6", "MESA 7", "MESA 8", "MESA 9", "MESA 10" }));
        ComboBoxMesas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ComboBoxMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxMesasActionPerformed(evt);
            }
        });
        jPanel39.add(ComboBoxMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 177, 43));

        rSMaterialButtonRectangle30.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle30.setText("Nueva venta");
        rSMaterialButtonRectangle30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle30ActionPerformed(evt);
            }
        });
        jPanel39.add(rSMaterialButtonRectangle30, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 180, 50));

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaPedidosVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número de  Pedido", "Total"
            }
        ));
        tablaPedidosVenta.setRowHeight(30);
        jScrollPane6.setViewportView(tablaPedidosVenta);

        jPanel40.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 870, 280));

        total.setEditable(false);
        total.setBackground(new java.awt.Color(34, 102, 145));
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        total.setOpaque(false);
        total.setPhColor(new java.awt.Color(255, 255, 255));
        total.setPlaceholder("TOTAL");
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });
        jPanel40.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 300, 80, 30));

        codigoL3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/total.png"))); // NOI18N
        jPanel40.add(codigoL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 290, -1, 50));

        rSMaterialButtonRectangle24.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle24.setText("ver pedido");
        rSMaterialButtonRectangle24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle24ActionPerformed(evt);
            }
        });
        jPanel40.add(rSMaterialButtonRectangle24, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 169, 43));

        rSMaterialButtonRectangle31.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle31.setText("historial");
        rSMaterialButtonRectangle31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle31ActionPerformed(evt);
            }
        });
        jPanel40.add(rSMaterialButtonRectangle31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 169, 43));

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));
        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("GENERAR PEDIDO");

        rSMaterialButtonRectangle13.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle13.setText("OBTENER PEDIDOS");
        rSMaterialButtonRectangle13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle13ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle29.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle29.setText("NUEVO PEDIDO");
        rSMaterialButtonRectangle29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle29ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(rSMaterialButtonRectangle29, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rSMaterialButtonRectangle13, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMaterialButtonRectangle13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(rSMaterialButtonRectangle29, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel38.getAccessibleContext().setAccessibleName("NÚMERO DE VENTA");

        TabbedPanePrincipal.addTab("Ventas", jPanel3);

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));

        PanelNombre1.setBackground(new java.awt.Color(34, 102, 145));
        PanelNombre1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Pedidos");

        javax.swing.GroupLayout PanelNombre1Layout = new javax.swing.GroupLayout(PanelNombre1);
        PanelNombre1.setLayout(PanelNombre1Layout);
        PanelNombre1Layout.setHorizontalGroup(
            PanelNombre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNombre1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelNombre1Layout.setVerticalGroup(
            PanelNombre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNombre1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                jTabbedPane3AncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTabbedPane3AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel46.setBackground(new java.awt.Color(255, 255, 255));

        jPanel55.setBackground(new java.awt.Color(255, 255, 255));
        jPanel55.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "REGISTRO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        registrarPedido.setBackground(new java.awt.Color(34, 102, 145));
        registrarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Cancelar.png"))); // NOI18N
        registrarPedido.setText("Registrar Pedido");
        registrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarPedidoActionPerformed(evt);
            }
        });

        borrar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        borrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elimina2.png"))); // NOI18N
        borrar1.setContentAreaFilled(false);
        borrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        borrar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        borrar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        borrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar1ActionPerformed(evt);
            }
        });

        cancelar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cancela2.png"))); // NOI18N
        cancelar1.setContentAreaFilled(false);
        cancelar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cancelar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar1ActionPerformed(evt);
            }
        });

        nuevoPedido.setBackground(new java.awt.Color(34, 102, 145));
        nuevoPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Cancelar.png"))); // NOI18N
        nuevoPedido.setText("Nuevo Pedido");
        nuevoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoPedidoActionPerformed(evt);
            }
        });

        ComboBoxSuministro1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONAR MESA", "MESA 1", "MESA 2", "MESA 3", "MESA 4", "MESA 5", "MESA 6", "MESA 7", "MESA 8", "MESA 9", "MESA 10" }));
        ComboBoxSuministro1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ComboBoxSuministro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxSuministro1ActionPerformed(evt);
            }
        });

        jPanel70.setBackground(new java.awt.Color(255, 255, 255));
        jPanel70.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSLabelFecha2.setForeground(new java.awt.Color(255, 255, 255));
        rSLabelFecha2.setToolTipText("");
        rSLabelFecha2.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 24)); // NOI18N
        jPanel70.add(rSLabelFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 180, 33));

        codigoL12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/fecha.png"))); // NOI18N
        jPanel70.add(codigoL12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 250, 50));

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelInventario_platillosPrecio1)
                            .addComponent(jLabelInventario_platillosNombre1)
                            .addComponent(jLabelInventario_platillosCodigo1)
                            .addComponent(jLabelInventario_platillosTipo1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel70, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel55Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(registrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ComboBoxSuministro1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nuevoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel55Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(borrar1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelInventario_platillosPrecio1)
                    .addComponent(jLabelInventario_platillosNombre1)
                    .addComponent(jLabelInventario_platillosCodigo1)
                    .addComponent(jLabelInventario_platillosTipo1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nuevoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ComboBoxSuministro1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(borrar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelar1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel61.setBackground(new java.awt.Color(255, 255, 255));
        jPanel61.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "TIPO ALIMENTO", "DESCRIPCION", "PRECIO $", "CANTIDAD", "IMPORTE $"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(tablePedidos);

        jPanel63.setBackground(new java.awt.Color(255, 255, 255));
        jPanel63.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        busca1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        busca1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/alimento2.png"))); // NOI18N
        busca1.setContentAreaFilled(false);
        busca1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        busca1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        busca1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        busca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busca1ActionPerformed(evt);
            }
        });

        registrar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        registrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/restaurante.png"))); // NOI18N
        registrar1.setToolTipText("Estado de Mesa");
        registrar1.setBorderPainted(false);
        registrar1.setContentAreaFilled(false);
        registrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        registrar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registrar1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/restaurante1.png"))); // NOI18N
        registrar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        registrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrar1ActionPerformed(evt);
            }
        });

        TotalPedidos.setBackground(new java.awt.Color(34, 102, 145));
        TotalPedidos.setForeground(new java.awt.Color(255, 255, 255));
        TotalPedidos.setEnabled(false);
        TotalPedidos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TotalPedidos.setOpaque(false);
        TotalPedidos.setPhColor(new java.awt.Color(255, 255, 255));
        TotalPedidos.setPlaceholder("TOTAL");
        TotalPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalPedidosActionPerformed(evt);
            }
        });

        codigoL11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/total.png"))); // NOI18N

        numFac1.setEditable(false);
        numFac1.setBackground(new java.awt.Color(34, 102, 145));
        numFac1.setForeground(new java.awt.Color(255, 255, 255));
        numFac1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numFac1.setOpaque(false);
        numFac1.setPhColor(new java.awt.Color(255, 255, 255));
        numFac1.setPlaceholder("PEDIDO");

        codigoL10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/numFac.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("NÚMERO DE PEDIDO");

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel63Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel63Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(numFac1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(codigoL10)))
                    .addGroup(jPanel63Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel17)))
                .addGap(6, 6, 6)
                .addComponent(busca1)
                .addGap(18, 18, 18)
                .addComponent(registrar1)
                .addGap(75, 75, 75)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel63Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(TotalPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(codigoL11))
                .addContainerGap())
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel63Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(TotalPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(codigoL11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(registrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel63Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel63Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(numFac1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(codigoL10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(busca1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9)
                    .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane3.addTab("Registra Pedido", jPanel46);

        jPanel56.setBackground(new java.awt.Color(255, 255, 255));

        tableMostrarPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NÚMERO DE PEDIDO", "ESTADO", "NÚMERO DE MESA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(tableMostrarPedidos);

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("NÚMERO DE PEDIDOS");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/orden.png"))); // NOI18N

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel56Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
                    .addGroup(jPanel56Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane3.addTab("Pedidos", jPanel56);

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setForeground(new java.awt.Color(255, 255, 255));

        jPanel57.setBackground(new java.awt.Color(255, 255, 255));

        jPanel58.setBackground(new java.awt.Color(255, 255, 255));

        mesa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mesa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mesaDisponible.png"))); // NOI18N

        rSMaterialButtonRectangle14.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle14.setText("Mesa 1");
        rSMaterialButtonRectangle14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesa1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel58Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSMaterialButtonRectangle14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesa1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rSMaterialButtonRectangle14, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel59.setBackground(new java.awt.Color(255, 255, 255));

        mesa6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mesa6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mesaDisponible.png"))); // NOI18N

        rSMaterialButtonRectangle19.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle19.setText("mesa 6");
        rSMaterialButtonRectangle19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesa6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(rSMaterialButtonRectangle19, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesa6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rSMaterialButtonRectangle19, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel60.setBackground(new java.awt.Color(255, 255, 255));

        mesa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mesa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mesaCobrada.png"))); // NOI18N

        rSMaterialButtonRectangle15.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle15.setText("mesa 2");
        rSMaterialButtonRectangle15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel60Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(rSMaterialButtonRectangle15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesa2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rSMaterialButtonRectangle15, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel62.setBackground(new java.awt.Color(255, 255, 255));

        mesa7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mesa7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mesaDisponible.png"))); // NOI18N

        rSMaterialButtonRectangle20.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle20.setText("mesa 7");
        rSMaterialButtonRectangle20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesa7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(rSMaterialButtonRectangle20, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesa7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rSMaterialButtonRectangle20, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel64.setBackground(new java.awt.Color(255, 255, 255));

        mesa3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mesa3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mesaDisponible.png"))); // NOI18N

        rSMaterialButtonRectangle16.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle16.setText("mesa 3");
        rSMaterialButtonRectangle16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel64Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(rSMaterialButtonRectangle16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesa3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rSMaterialButtonRectangle16, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel66.setBackground(new java.awt.Color(255, 255, 255));

        mesa8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mesa8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mesaCobrada.png"))); // NOI18N

        rSMaterialButtonRectangle21.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle21.setText("mesa 8");
        rSMaterialButtonRectangle21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel66Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesa8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel66Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSMaterialButtonRectangle21, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesa8, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rSMaterialButtonRectangle21, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel65.setBackground(new java.awt.Color(255, 255, 255));

        mesa4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mesa4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mesaDisponible.png"))); // NOI18N

        rSMaterialButtonRectangle17.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle17.setText("Mesa 4");
        rSMaterialButtonRectangle17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesa4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel65Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSMaterialButtonRectangle17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesa4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rSMaterialButtonRectangle17, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel67.setBackground(new java.awt.Color(255, 255, 255));

        mesa9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mesa9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mesaOcupado.png"))); // NOI18N

        rSMaterialButtonRectangle22.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle22.setText("mesa 9");
        rSMaterialButtonRectangle22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesa9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel67Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(rSMaterialButtonRectangle22, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesa9, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rSMaterialButtonRectangle22, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel68.setBackground(new java.awt.Color(255, 255, 255));

        mesa5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mesa5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mesaDisponible.png"))); // NOI18N

        rSMaterialButtonRectangle18.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle18.setText("mesa 5");
        rSMaterialButtonRectangle18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel68Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mesa5, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel68Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(rSMaterialButtonRectangle18, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesa5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rSMaterialButtonRectangle18, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel69.setBackground(new java.awt.Color(255, 255, 255));

        mesa10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mesa10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/mesaOcupado.png"))); // NOI18N

        rSMaterialButtonRectangle23.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle23.setText("mesa 10");
        rSMaterialButtonRectangle23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel69Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mesa10, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel69Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(rSMaterialButtonRectangle23, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mesa10, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rSMaterialButtonRectangle23, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel57Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel57Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel69, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Mesas", jPanel32);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane3)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(PanelNombre1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        TabbedPanePrincipal.addTab("Pedido", jPanel31);

        jPanel49.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane12.setBackground(new java.awt.Color(102, 102, 255));
        jScrollPane12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel19.setBackground(new java.awt.Color(34, 102, 145));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelImage_Usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelImage_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/lbl-user.png"))); // NOI18N
        jPanel19.add(LabelImage_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 6, 110, 110));

        jLabelNombreUsuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombreUsuario.setText("Usuario");
        jPanel19.add(jLabelNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 113, 238, 38));

        rSButtonMaterialIconUno2.setBackground(new java.awt.Color(34, 102, 145));
        rSButtonMaterialIconUno2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Inventario.png"))); // NOI18N
        rSButtonMaterialIconUno2.setText("     CERRAR SESIÓN");
        rSButtonMaterialIconUno2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rSButtonMaterialIconUno2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.POWER_SETTINGS_NEW);
        rSButtonMaterialIconUno2.setInheritsPopupMenu(true);
        rSButtonMaterialIconUno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialIconUno2ActionPerformed(evt);
            }
        });
        jPanel19.add(rSButtonMaterialIconUno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 250, 40));

        btnDasboard.setBackground(new java.awt.Color(34, 102, 145));
        btnDasboard.setText("     DASBOARD");
        btnDasboard.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DASHBOARD);
        btnDasboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDasboardActionPerformed(evt);
            }
        });
        jPanel19.add(btnDasboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 250, 40));

        btnVentas.setBackground(new java.awt.Color(34, 102, 145));
        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Inventario.png"))); // NOI18N
        btnVentas.setText("     VENTAS");
        btnVentas.setEffectButton(rsmaterialcomponents.RSButtonMaterialIconUno.EFFECTBUTTON.RAISED);
        btnVentas.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ASSESSMENT);
        btnVentas.setInheritsPopupMenu(true);
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        jPanel19.add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 250, 40));

        btnPedidos.setBackground(new java.awt.Color(34, 102, 145));
        btnPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Inventario.png"))); // NOI18N
        btnPedidos.setText("     PEDIDOS");
        btnPedidos.setEffectButton(rsmaterialcomponents.RSButtonMaterialIconUno.EFFECTBUTTON.RAISED);
        btnPedidos.setInheritsPopupMenu(true);
        btnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosActionPerformed(evt);
            }
        });
        jPanel19.add(btnPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 250, 40));

        btnContizaciones.setBackground(new java.awt.Color(34, 102, 145));
        btnContizaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Inventario.png"))); // NOI18N
        btnContizaciones.setText("     COTIZACIONES");
        btnContizaciones.setEffectButton(rsmaterialcomponents.RSButtonMaterialIconUno.EFFECTBUTTON.RAISED);
        btnContizaciones.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnContizaciones.setInheritsPopupMenu(true);
        jPanel19.add(btnContizaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 250, 40));

        btnInventario.setBackground(new java.awt.Color(34, 102, 145));
        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Inventario.png"))); // NOI18N
        btnInventario.setText("     INVENTARIO");
        btnInventario.setEffectButton(rsmaterialcomponents.RSButtonMaterialIconUno.EFFECTBUTTON.RAISED);
        btnInventario.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK);
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });
        jPanel19.add(btnInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 250, 40));

        btnUsuarios.setBackground(new java.awt.Color(34, 102, 145));
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Inventario.png"))); // NOI18N
        btnUsuarios.setText("     USUARIOS");
        btnUsuarios.setEffectButton(rsmaterialcomponents.RSButtonMaterialIconUno.EFFECTBUTTON.RAISED);
        btnUsuarios.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PERM_CONTACT_CALENDAR);
        btnUsuarios.setInheritsPopupMenu(true);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        jPanel19.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 250, 40));

        btnConfiguracion.setBackground(new java.awt.Color(34, 102, 145));
        btnConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Inventario.png"))); // NOI18N
        btnConfiguracion.setText("     CONFIGURACIÓN");
        btnConfiguracion.setEffectButton(rsmaterialcomponents.RSButtonMaterialIconUno.EFFECTBUTTON.RAISED);
        btnConfiguracion.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SETTINGS);
        btnConfiguracion.setInheritsPopupMenu(true);
        btnConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracionActionPerformed(evt);
            }
        });
        jPanel19.add(btnConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 250, 40));

        btnAbout.setBackground(new java.awt.Color(34, 102, 145));
        btnAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Inventario.png"))); // NOI18N
        btnAbout.setText("     ACERCA DE");
        btnAbout.setEffectButton(rsmaterialcomponents.RSButtonMaterialIconUno.EFFECTBUTTON.RAISED);
        btnAbout.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
        btnAbout.setInheritsPopupMenu(true);
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });
        jPanel19.add(btnAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 250, 40));
        btnAbout.getAccessibleContext().setAccessibleName("ACERCA DE");

        jPanel19.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 250, 10));
        jPanel19.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 148, 250, -1));

        jScrollPane12.setViewportView(jPanel19);

        pnlDasboard.setName("pnlDasboard"); // NOI18N

        jPanel78.setBackground(new java.awt.Color(255, 255, 255));

        rSLabelImage1.setBackground(new java.awt.Color(34, 102, 145));
        rSLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/a.png"))); // NOI18N

        rSPanelGradiente1.setBackground(new java.awt.Color(34, 102, 145));
        rSPanelGradiente1.setColorPrimario(new java.awt.Color(34, 102, 145));

        jLabel12.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Panel de Administración");

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE)
                .addContainerGap())
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addContainerGap())
        );

        rSLabelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Group 2.png"))); // NOI18N

        rSLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/calendario.png"))); // NOI18N
        rSLabelImage2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSLabelImage2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel78Layout.createSequentialGroup()
                        .addComponent(rSLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rSLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel78Layout.createSequentialGroup()
                        .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSLabelImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSLabelImage1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelImage2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlDasboardLayout = new javax.swing.GroupLayout(pnlDasboard);
        pnlDasboard.setLayout(pnlDasboardLayout);
        pnlDasboardLayout.setHorizontalGroup(
            pnlDasboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1035, Short.MAX_VALUE)
            .addGroup(pnlDasboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDasboardLayout.setVerticalGroup(
            pnlDasboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
            .addGroup(pnlDasboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(pnlDasboard, "card3");

        pnlInicio.setBackground(new java.awt.Color(255, 255, 255));
        pnlInicio.setName("panelInicio"); // NOI18N

        jLabel25.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(35, 114, 194));
        jLabel25.setText("INICIO");

        rSCalendar1.setAltoFilas(70);
        rSCalendar1.setAltoHead(90);
        rSCalendar1.setFuenteFilas(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        rSCalendar1.setFuenteHead(new java.awt.Font("Roboto", 1, 36)); // NOI18N

        javax.swing.GroupLayout pnlInicioLayout = new javax.swing.GroupLayout(pnlInicio);
        pnlInicio.setLayout(pnlInicioLayout);
        pnlInicioLayout.setHorizontalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
            .addGroup(pnlInicioLayout.createSequentialGroup()
                .addComponent(rSCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlInicioLayout.setVerticalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInicioLayout.createSequentialGroup()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addContainerGap())
        );

        rSPanelsSlider1.add(pnlInicio, "card2");

        pnlConf.setBackground(new java.awt.Color(255, 255, 255));
        pnlConf.setName("pnlConf"); // NOI18N

        jLabel36.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(35, 114, 194));
        jLabel36.setText("CONFIGURACIÓN");

        jPanel48.setBackground(new java.awt.Color(255, 255, 255));

        rSButtonMetro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/configuracion/btnUser.png"))); // NOI18N
        rSButtonMetro1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rSButtonMetro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 112, 192));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("CAMBIAR NOMBRE DE");

        jLabel37.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 112, 192));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("USUARIO");

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rSButtonMetro1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSButtonMetro1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel50.setBackground(new java.awt.Color(255, 255, 255));

        rSButtonMetro3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/configuracion/btnPass.png"))); // NOI18N
        rSButtonMetro3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rSButtonMetro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro3ActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 112, 192));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("CAMBIAR");

        jLabel41.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 112, 192));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("CONTRASEÑA");

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rSButtonMetro3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSButtonMetro3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));

        btnBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/configuracion/btnCrear.png"))); // NOI18N
        btnBackup.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackupActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 112, 192));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("CREAR RESPALDO");

        jLabel43.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 112, 192));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("BASE DE DATOS(BD)");

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBackup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel43)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel74.setBackground(new java.awt.Color(255, 255, 255));

        rSButtonMetro5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/configuracion/btnRestore.png"))); // NOI18N
        rSButtonMetro5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rSButtonMetro5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro5ActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 112, 192));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("RESTAURAR");

        jLabel45.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 112, 192));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("BASE DE DATOS(BD)");

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rSButtonMetro5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSButtonMetro5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel45)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlConfLayout = new javax.swing.GroupLayout(pnlConf);
        pnlConf.setLayout(pnlConfLayout);
        pnlConfLayout.setHorizontalGroup(
            pnlConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConfLayout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
        );
        pnlConfLayout.setVerticalGroup(
            pnlConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfLayout.createSequentialGroup()
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                .addGroup(pnlConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(257, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(pnlConf, "card2");

        pnlUsuarios.setName("pnlUsuarios"); // NOI18N

        jPanel76.setBackground(new java.awt.Color(255, 255, 255));

        jLabel30.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(35, 114, 194));
        jLabel30.setText("USUARIOS");

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane13.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel77.setBackground(new java.awt.Color(255, 255, 255));
        jPanel77.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "DATOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 1, 12), new java.awt.Color(0, 112, 192))); // NOI18N

        TextFieldUsuario_Nombre.setForeground(new java.awt.Color(34, 102, 145));
        TextFieldUsuario_Nombre.setMayusculas(true);
        TextFieldUsuario_Nombre.setPlaceholder("NOMBRES");
        TextFieldUsuario_Nombre.setSoloLetras(true);
        TextFieldUsuario_Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldUsuario_NombreKeyReleased(evt);
            }
        });

        TextFieldUsuario_Email.setForeground(new java.awt.Color(34, 102, 145));
        TextFieldUsuario_Email.setPlaceholder("CORREO ELÉCTRONICO");

        TextFieldUsuario_Password.setForeground(new java.awt.Color(34, 102, 145));
        TextFieldUsuario_Password.setPlaceholder("CONTRASEÑA");

        btnRegistrar.setBackground(new java.awt.Color(34, 102, 145));
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(34, 102, 145));
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        TextFieldUsuario_Apellido.setForeground(new java.awt.Color(34, 102, 145));
        TextFieldUsuario_Apellido.setPlaceholder("APELLIDOS");
        TextFieldUsuario_Apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldUsuario_ApellidoKeyReleased(evt);
            }
        });

        TextFieldUsuario_Nid.setForeground(new java.awt.Color(34, 102, 145));
        TextFieldUsuario_Nid.setPlaceholder("NID");
        TextFieldUsuario_Nid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldUsuario_NidActionPerformed(evt);
            }
        });
        TextFieldUsuario_Nid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldUsuario_NidKeyReleased(evt);
            }
        });

        TextFieldUsuario_Telefono.setForeground(new java.awt.Color(34, 102, 145));
        TextFieldUsuario_Telefono.setPlaceholder("TELÉFONO");
        TextFieldUsuario_Telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldUsuario_TelefonoKeyReleased(evt);
            }
        });

        TextFieldUsuario_Usuario.setForeground(new java.awt.Color(34, 102, 145));
        TextFieldUsuario_Usuario.setPlaceholder("USUARIO");
        TextFieldUsuario_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldUsuario_UsuarioActionPerformed(evt);
            }
        });

        TextFieldUsuario_Direccion.setForeground(new java.awt.Color(34, 102, 145));
        TextFieldUsuario_Direccion.setPlaceholder("DIRECCIÓN");
        TextFieldUsuario_Direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldUsuario_DireccionActionPerformed(evt);
            }
        });

        CheckBoxUsuario_State.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CheckBoxUsuario_State.setText("Estado");

        ComboBoxUsuario_Role.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TIPO DE USUARIO", "ADMINISTRADOR", "USUARIO" }));
        ComboBoxUsuario_Role.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel77Layout = new javax.swing.GroupLayout(jPanel77);
        jPanel77.setLayout(jPanel77Layout);
        jPanel77Layout.setHorizontalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CheckBoxUsuario_State, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextFieldUsuario_Password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(TextFieldUsuario_Usuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextFieldUsuario_Direccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextFieldUsuario_Telefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextFieldUsuario_Email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextFieldUsuario_Apellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextFieldUsuario_Nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextFieldUsuario_Nid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBoxUsuario_Role, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel77Layout.setVerticalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addComponent(TextFieldUsuario_Nid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFieldUsuario_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFieldUsuario_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFieldUsuario_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFieldUsuario_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFieldUsuario_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFieldUsuario_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFieldUsuario_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComboBoxUsuario_Role, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CheckBoxUsuario_State)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane13.setViewportView(jPanel77);

        jTabbedPane1.addTab("Registro", jScrollPane13);

        jPanel75.setBackground(new java.awt.Color(255, 255, 255));

        jPanel79.setBackground(new java.awt.Color(255, 255, 255));
        jPanel79.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        rSFotoSquare1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rSFotoSquare1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSFotoSquare1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel79Layout = new javax.swing.GroupLayout(jPanel79);
        jPanel79.setLayout(jPanel79Layout);
        jPanel79Layout.setHorizontalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel79Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(rSFotoSquare1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel79Layout.setVerticalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSFotoSquare1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel75Layout = new javax.swing.GroupLayout(jPanel75);
        jPanel75.setLayout(jPanel75Layout);
        jPanel75Layout.setHorizontalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel75Layout.setVerticalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addComponent(jPanel79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 379, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Foto", jPanel75);

        TextField_BuscarUsuario.setMayusculas(true);
        TextField_BuscarUsuario.setPlaceholder("BUSCAR USUARIO");
        TextField_BuscarUsuario.setSoloLetras(true);
        TextField_BuscarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextField_BuscarUsuarioKeyReleased(evt);
            }
        });

        jTabbedPane5.setBackground(new java.awt.Color(255, 255, 255));

        scrollUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        scrollUsuarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 192), 3));

        Table_Usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "APELLIDO", "TELEFONO", "EMAIL", "USUARIO", "ROLE", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table_Usuarios.setColorBackgoundHead(new java.awt.Color(34, 102, 145));
        Table_Usuarios.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Table_Usuarios.setFuenteFilas(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        Table_Usuarios.setFuenteFilasSelect(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        Table_Usuarios.setFuenteHead(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        Table_Usuarios.setGrosorBordeFilas(0);
        Table_Usuarios.setGrosorBordeHead(0);
        Table_Usuarios.setMultipleSeleccion(false);
        Table_Usuarios.getTableHeader().setReorderingAllowed(false);
        Table_Usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_UsuariosMouseClicked(evt);
            }
        });
        Table_Usuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Table_UsuariosKeyReleased(evt);
            }
        });
        scrollUsuarios.setViewportView(Table_Usuarios);

        jTabbedPane5.addTab("Lista de Usuarios", scrollUsuarios);

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane5))
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextField_BuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel76Layout.createSequentialGroup()
                        .addComponent(TextField_BuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))
                    .addGroup(jPanel76Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                    .addComponent(jTabbedPane5)))
        );

        javax.swing.GroupLayout pnlUsuariosLayout = new javax.swing.GroupLayout(pnlUsuarios);
        pnlUsuarios.setLayout(pnlUsuariosLayout);
        pnlUsuariosLayout.setHorizontalGroup(
            pnlUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1035, Short.MAX_VALUE)
            .addGroup(pnlUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlUsuariosLayout.setVerticalGroup(
            pnlUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
            .addGroup(pnlUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(pnlUsuarios, "card4");

        pnlUsuarioDenegado.setBackground(new java.awt.Color(255, 255, 255));
        pnlUsuarioDenegado.setName("pnlUsuarioDenegado"); // NOI18N

        jLabel38.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(35, 114, 194));
        jLabel38.setText("USUARIOS");

        jLabel39.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(200, 0, 0));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("SIN ACCESO");

        jLabel46.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(200, 0, 0));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/denegado.png"))); // NOI18N

        javax.swing.GroupLayout pnlUsuarioDenegadoLayout = new javax.swing.GroupLayout(pnlUsuarioDenegado);
        pnlUsuarioDenegado.setLayout(pnlUsuarioDenegadoLayout);
        pnlUsuarioDenegadoLayout.setHorizontalGroup(
            pnlUsuarioDenegadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUsuarioDenegadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlUsuarioDenegadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlUsuarioDenegadoLayout.setVerticalGroup(
            pnlUsuarioDenegadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuarioDenegadoLayout.createSequentialGroup()
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        rSPanelsSlider1.add(pnlUsuarioDenegado, "card8");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabbedPanePrincipal.addTab("tab7", jPanel49);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ButtonCliente.setBackground(new java.awt.Color(51, 51, 51));
        ButtonCliente.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/people.png"))); // NOI18N
        ButtonCliente.setText("Clientes");
        ButtonCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonClienteActionPerformed(evt);
            }
        });

        ButtonInventario.setBackground(new java.awt.Color(51, 51, 51));
        ButtonInventario.setForeground(new java.awt.Color(255, 255, 255));
        ButtonInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Inventario.png"))); // NOI18N
        ButtonInventario.setText("Inventario");
        ButtonInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonInventarioActionPerformed(evt);
            }
        });

        ButtonCotizacion.setBackground(new java.awt.Color(51, 51, 51));
        ButtonCotizacion.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCotizacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/search.png"))); // NOI18N
        ButtonCotizacion.setText("Cotizaciones");
        ButtonCotizacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonCotizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCotizacionActionPerformed(evt);
            }
        });

        ButtonClienteConfig.setBackground(new java.awt.Color(51, 51, 51));
        ButtonClienteConfig.setForeground(new java.awt.Color(255, 255, 255));
        ButtonClienteConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pedidos.png"))); // NOI18N
        ButtonClienteConfig.setText("Pedido");
        ButtonClienteConfig.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonClienteConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonClienteConfigActionPerformed(evt);
            }
        });

        rSLabelHora1.setForeground(new java.awt.Color(0, 52, 102));
        rSLabelHora1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N

        ButtonClienteConfig2.setBackground(new java.awt.Color(51, 51, 51));
        ButtonClienteConfig2.setForeground(new java.awt.Color(255, 255, 255));
        ButtonClienteConfig2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about.png"))); // NOI18N
        ButtonClienteConfig2.setText("Dashboard");
        ButtonClienteConfig2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonClienteConfig2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonClienteConfig2ActionPerformed(evt);
            }
        });

        BtnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/shopping_cart.png"))); // NOI18N
        BtnVentas.setText("Ventas");
        BtnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(ButtonCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(ButtonClienteConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonClienteConfig2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ButtonClienteConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ButtonClienteConfig2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ButtonInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(ButtonCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ButtonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(BtnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TabbedPanePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1Principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TabbedPanePrincipal)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonInventarioActionPerformed
        TabbedPanePrincipal.setSelectedIndex(1);
        BtnVentas.setEnabled(true);
        // rSButtonRound6.setEnabled(true);
        ButtonInventario.setEnabled(false);
        ButtonCotizacion.setEnabled(true);
        // ButtonAdministracion.setEnabled(true);
        ButtonClienteConfig.setEnabled(true);
        //  aqui van a ir todos los datos del inventario registro de suministro
        ArrayList<JLabel> label = new ArrayList();
        label.add(LabelInventario_codigo);
        label.add(LabelInventario_nombre);
        label.add(TextFieldInventario_nombreg);
        label.add(LabelInventario_precio);
        label.add(LabelInventarioSuministro_Paginas2);
        ArrayList<JTextField> textField = new ArrayList();
        textField.add(TextFieldInventario_codigo);
        textField.add(TextFieldInventario_nombreg1);
        textField.add(TextFieldInventario_stock);
        textField.add(TextFieldInventario_precio);
        Object[] objects1 = {
            xd,
            rSTableMetro3,
            SpinnerPaginasInventario_suministro2,
            ComboBoxSuministro
        };
        suministro.Componentes(objects1, label, textField);

        // datos de la categoria
        ArrayList<JLabel> label2 = new ArrayList();
        label2.add(LabelInventario_CategoriaNombre);
        label2.add(LabelInventario_CategoriaDescrip);
        label2.add(LabelInventarioSuministro_Paginas2);
        ArrayList<JTextField> textField2 = new ArrayList();
        textField2.add(TextFieldInventario_CategoriaNombre);
        textField2.add(TextFieldInventario_categoriaDescrip);
        Object[] objects2 = {
            TableInventario_categoria,
            SpinnerPaginasInventario_suministro2,
            ComboBoxSuministro
        };
        categoria.Componentes(objects2, label2, textField2);

        // datos de platillos
        ArrayList<JLabel> label3 = new ArrayList();
        label3.add(jLabelInventario_platillosCodigo);
        label3.add(jLabelInventario_platillosNombre);
        // label.add(jLabelInventario_platillosTipo);
        label3.add(jLabelInventario_platillosPrecio);
        label3.add(LabelInventarioSuministro_Paginas2);
        ArrayList<JCTextField> JCtextField = new ArrayList();
        JCtextField.add(codigo);
        JCtextField.add(nombre);
        JCtextField.add(precio);
        Object[] objects3 = {
            TableInventario_platillos,
            SpinnerPaginasInventario_suministro2,
            tipoAl,};
        alimento.Componentes(objects3, label3, JCtextField);
    }//GEN-LAST:event_ButtonInventarioActionPerformed

    private void ButtonCotizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCotizacionActionPerformed

        if (_dataUsuario.getRole().equals("Admin")) {
            TabbedPanePrincipal.setSelectedIndex(2);
            BtnVentas.setEnabled(true);
            // rSButtonRound6.setEnabled(true);
            ButtonInventario.setEnabled(true);
            ButtonCotizacion.setEnabled(false);
            //   ButtonAdministracion.setEnabled(true);
            ButtonClienteConfig.setEnabled(true);
        } else {
            AlertError error = new AlertError(this, true);
            error.Texto("Acceso Denegado");
            error.setVisible(true);
        }


    }//GEN-LAST:event_ButtonCotizacionActionPerformed

    private void ButtonClienteConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonClienteConfigActionPerformed
        BtnVentas.setEnabled(true);
        //rSButtonRound6.setEnabled(true);
        ButtonInventario.setEnabled(true);
        ButtonCotizacion.setEnabled(true);
        //   ButtonAdministracion.setEnabled(true);
        ButtonClienteConfig.setEnabled(false);
        TabbedPanePrincipal.setSelectedIndex(5);

        this.repaint();

    }//GEN-LAST:event_ButtonClienteConfigActionPerformed

    private void ButtonCliente_Paginas4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCliente_Paginas4ActionPerformed
        cliente.Paginador("Ultimo");
    }//GEN-LAST:event_ButtonCliente_Paginas4ActionPerformed

    private void ButtonCliente_Paginas3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCliente_Paginas3ActionPerformed
        cliente.Paginador("Siguiente");
    }//GEN-LAST:event_ButtonCliente_Paginas3ActionPerformed

    private void ButtonCliente_Paginas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCliente_Paginas1ActionPerformed
        cliente.Paginador("Primero");
    }//GEN-LAST:event_ButtonCliente_Paginas1ActionPerformed

    private void ButtonCliente_Paginas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCliente_Paginas2ActionPerformed
        cliente.Paginador("Anterior");
    }//GEN-LAST:event_ButtonCliente_Paginas2ActionPerformed

    private void SpinnerPaginas_ClientesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinnerPaginas_ClientesStateChanged
        cliente.Registro_Paginas();
    }//GEN-LAST:event_SpinnerPaginas_ClientesStateChanged

    private void TabbedPaneCliente2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TabbedPaneCliente2StateChanged
        switch (TabbedPaneCliente2.getSelectedIndex()) {
            case 0:
                if (TabbedPaneCliente1.getSelectedIndex() > 0) {
                    TabbedPaneCliente1.setSelectedIndex(0);
//                    cliente.seccion = 1;
//                    cliente.Registro_Paginas();
                }
                break;
            case 1:
//                cliente.seccion = 2;
//                TabbedPaneCliente1.setSelectedIndex(1);
//                cliente.Registro_Paginas();
                break;
        }
    }//GEN-LAST:event_TabbedPaneCliente2StateChanged

    private void TableCliente_ReportKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableCliente_ReportKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TableCliente_ReportKeyReleased

    private void TableCliente_ReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableCliente_ReportMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TableCliente_ReportMouseClicked

    private void TabbedPaneCliente1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TabbedPaneCliente1StateChanged
        switch (TabbedPaneCliente1.getSelectedIndex()) {
            case 0:
                if (TabbedPaneCliente2.getSelectedIndex() > 0) {
                    TabbedPaneCliente2.setSelectedIndex(0);
                    cliente.seccion = 1;
                    cliente.Registro_Paginas();
                }
                break;
            case 1:
                cliente.seccion = 2;
                TabbedPaneCliente2.setSelectedIndex(1);
                cliente.Registro_Paginas();
                break;
        }
    }//GEN-LAST:event_TabbedPaneCliente1StateChanged

    private void TextFieldCliente_DireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldCliente_DireccionKeyReleased
        if (TextFieldCliente_Direccion.getText().equals("")) {
            LabelCliente_Direccion.setForeground(new Color(102, 102, 102));
        } else {
            LabelCliente_Direccion.setText("Direccion");
            LabelCliente_Direccion.setForeground(new Color(0, 153, 51));
        }
    }//GEN-LAST:event_TextFieldCliente_DireccionKeyReleased

    private void TextFieldCliente_TelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldCliente_TelefonoKeyTyped
        Objectos.eventos.numberKeyPres(evt);
    }//GEN-LAST:event_TextFieldCliente_TelefonoKeyTyped

    private void TextFieldCliente_TelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldCliente_TelefonoKeyReleased
        if (TextFieldCliente_Telefono.getText().equals("")) {
            LabelCliente_Telefono.setForeground(new Color(102, 102, 102));
        } else {
            LabelCliente_Telefono.setText("Telefono");
            LabelCliente_Telefono.setForeground(new Color(0, 153, 51));
        }
    }//GEN-LAST:event_TextFieldCliente_TelefonoKeyReleased

    private void TextFieldCliente_EmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldCliente_EmailKeyReleased
        if (TextFieldCliente_Email.getText().equals("")) {
            LabelCliente_Email.setForeground(new Color(102, 102, 102));
        } else {
            LabelCliente_Email.setText("Email");
            LabelCliente_Email.setForeground(new Color(0, 153, 51));
        }
    }//GEN-LAST:event_TextFieldCliente_EmailKeyReleased

    private void TextFieldCliente_ApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldCliente_ApellidoKeyTyped
        Objectos.eventos.textKeyPress(evt);
    }//GEN-LAST:event_TextFieldCliente_ApellidoKeyTyped

    private void TextFieldCliente_ApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldCliente_ApellidoKeyReleased
        if (TextFieldCliente_Apellido.getText().equals("")) {
            LabelCliente_Apellido.setForeground(new Color(102, 102, 102));
        } else {
            LabelCliente_Apellido.setText("Apellido");
            LabelCliente_Apellido.setForeground(new Color(0, 153, 51));
        }
    }//GEN-LAST:event_TextFieldCliente_ApellidoKeyReleased

    private void TextFieldCliente_NombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldCliente_NombreKeyTyped
        Objectos.eventos.textKeyPress(evt);
    }//GEN-LAST:event_TextFieldCliente_NombreKeyTyped

    private void TextFieldCliente_NombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldCliente_NombreKeyReleased
        if (TextFieldCliente_Nombre.getText().equals("")) {
            LabelCliente_Nombre.setForeground(new Color(102, 102, 102));
        } else {
            LabelCliente_Nombre.setText("Nombre");
            LabelCliente_Nombre.setForeground(new Color(0, 153, 51));
        }
    }//GEN-LAST:event_TextFieldCliente_NombreKeyReleased

    private void TextFieldCliente_NidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldCliente_NidKeyTyped
        Objectos.eventos.numberKeyPres(evt);
    }//GEN-LAST:event_TextFieldCliente_NidKeyTyped

    private void TextFieldCliente_NidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldCliente_NidKeyReleased
        if (TextFieldCliente_Nid.getText().equals("")) {
            LabelCliente_Nid.setForeground(new Color(102, 102, 102));
        } else {
            LabelCliente_Nid.setText("Nid");
            LabelCliente_Nid.setForeground(new Color(0, 153, 51));
        }
    }//GEN-LAST:event_TextFieldCliente_NidKeyReleased

    private void LabelImage_ClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelImage_ClienteMouseClicked
        Objectos.uploadimage.CargarImagen(LabelImage_Cliente);
    }//GEN-LAST:event_LabelImage_ClienteMouseClicked

    private void ButtonCliente_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCliente_AgregarActionPerformed
        cliente.RegistrarCliente();
        if (cliente.getInsert()) {
//            alertas.AlertSuccess alerta = new alertas.AlertSuccess(this, true);
//            alerta.Texto("Se ha registrado Correctamente");
//            alerta.setVisible(true);
            cliente.setInsert(false);
            new rojerusan.RSNotifyFade("Registro", "Registrado Correctamente", 6, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.SUCCESS).setVisible(true);
        }
        if (cliente.getUpdate()) {
            alertas.AlertSuccess alerta = new alertas.AlertSuccess(this, true);
            alerta.Texto("Se ha Modificado Correctamente");
            alerta.setVisible(true);
            cliente.setUpdate(false);
        }
    }//GEN-LAST:event_ButtonCliente_AgregarActionPerformed

    private void ButtonCliente_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCliente_CancelarActionPerformed
        alertas.AlertWarning alerta = new alertas.AlertWarning(this, true);
        alerta.AgregarTexto("Seguro quieres cancelar", "Si", "No");
        alerta.setVisible(true);
        if (alerta.bandera) {
            cliente.restablecer();
        }
    }//GEN-LAST:event_ButtonCliente_CancelarActionPerformed

    private void Table_ClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table_ClientesKeyReleased
        if (Table_Clientes.getSelectedRows().length > 0) {
            cliente.GetCliente();
        }
    }//GEN-LAST:event_Table_ClientesKeyReleased

    private void Table_ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_ClientesMouseClicked
        if (Table_Clientes.getSelectedRows().length > 0) {
            cliente.GetCliente();
        }
    }//GEN-LAST:event_Table_ClientesMouseClicked

    private void rSMaterialButtonRectangle8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle8ActionPerformed
        suministro.RegistrarSuministro();

        if (suministro.getInsert()) {
            alertas.AlertSuccess alerta = new alertas.AlertSuccess(this, true);
            alerta.Texto("Se ha registrado Correctamente");
            alerta.setVisible(true);
            suministro.setInsert(false);
        }
        if (suministro.getUpdate()) {
            alertas.AlertSuccess alerta = new alertas.AlertSuccess(this, true);
            alerta.Texto("Se ha Modificado Correctamente");
            alerta.setVisible(true);
            suministro.setUpdate(false);
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle8ActionPerformed

    private void rSMaterialButtonRectangle9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle9ActionPerformed
        alertas.AlertWarning alerta = new alertas.AlertWarning(this, true);
        alerta.AgregarTexto("Seguro quieres cancelar", "Si", "No");
        alerta.setVisible(true);

        if (alerta.bandera) {
            suministro.restablecerSuministro();
        }    }//GEN-LAST:event_rSMaterialButtonRectangle9ActionPerformed

    private void jTabbedPaneInventario1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabbedPaneInventario1KeyPressed

        TextField_BuscarInventario.setEnabled(false);
        TextField_BuscarInventario.setEditable(false);

    }//GEN-LAST:event_jTabbedPaneInventario1KeyPressed

    private void jTabbedPaneInventario1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPaneInventario1StateChanged
        switch (jTabbedPaneInventario1.getSelectedIndex()) {
            case 0:
                if (jTabbedPaneInventario2.getSelectedIndex() > 0) {
                    jTabbedPaneInventario2.setSelectedIndex(0);
                    suministro.seccion = 1;
                    suministro.Registro_PaginasInventario();
                    ComboBoxSuministro.setSelectedIndex(0);
                }
                break;
            case 1:
                suministro.seccion = 1;
                jTabbedPaneInventario2.setSelectedIndex(1);
                suministro.Registro_PaginasInventario();
                break;
            case 2:
                suministro.seccion = 1;
                jTabbedPaneInventario2.setSelectedIndex(2);
                suministro.Registro_PaginasInventario();

                break;

            case 3:
                //categoria.seccion = 1;
                jTabbedPaneInventario2.setSelectedIndex(3);
                // categoria.Registro_PaginasInventario();
                break;
        }

    }//GEN-LAST:event_jTabbedPaneInventario1StateChanged

    private void rSMaterialButtonRectangle7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle7ActionPerformed

    private void xdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xdKeyReleased
        if (xd.getSelectedRows().length > 0) {
            suministro.GetCliente();
        }
    }//GEN-LAST:event_xdKeyReleased

    private void xdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xdMouseClicked
        if (xd.getSelectedRows().length > 0) {
            suministro.GetCliente();
        }
    }//GEN-LAST:event_xdMouseClicked

    private void TextFieldInventario_categoriaDescripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldInventario_categoriaDescripActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldInventario_categoriaDescripActionPerformed

    private void TextFieldInventario_categoriaDescripKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldInventario_categoriaDescripKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldInventario_categoriaDescripKeyReleased

    private void TextFieldInventario_categoriaDescripKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldInventario_categoriaDescripKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldInventario_categoriaDescripKeyTyped

    private void TextFieldInventario_CategoriaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldInventario_CategoriaNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldInventario_CategoriaNombreActionPerformed

    private void TextFieldInventario_CategoriaNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldInventario_CategoriaNombreKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldInventario_CategoriaNombreKeyReleased

    private void TextFieldInventario_CategoriaNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldInventario_CategoriaNombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldInventario_CategoriaNombreKeyTyped

    private void rSMaterialButtonRectangle10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle10ActionPerformed
        categoria.RegistrarSuministro();

        if (categoria.getInsert()) {
            alertas.AlertSuccess alerta = new alertas.AlertSuccess(this, true);
            alerta.Texto("Se ha registrado Correctamente");
            alerta.setVisible(true);
            categoria.setInsert(false);
        }
        if (categoria.getUpdate()) {
            alertas.AlertSuccess alerta = new alertas.AlertSuccess(this, true);
            alerta.Texto("Se ha Modificado Correctamente");
            alerta.setVisible(true);
            categoria.setUpdate(false);
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle10ActionPerformed

    private void rSMaterialButtonRectangle11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle11ActionPerformed
        alertas.AlertWarning alerta = new alertas.AlertWarning(this, true);
        alerta.AgregarTexto("Seguro quieres cancelar", "Si", "No");
        alerta.setVisible(true);
        if (alerta.bandera) {
            categoria.restablecer();
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle11ActionPerformed

    private void TableInventario_categoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableInventario_categoriaMouseClicked
        if (TableInventario_categoria.getSelectedRows().length > 0) {
            categoria.GetCategoria();
        }
    }//GEN-LAST:event_TableInventario_categoriaMouseClicked

    private void TableInventario_categoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableInventario_categoriaKeyReleased
        if (TableInventario_categoria.getSelectedRows().length > 0) {
            categoria.GetCategoria();
        }
    }//GEN-LAST:event_TableInventario_categoriaKeyReleased

    private void nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyReleased
        nombre.setText(nombre.getText().toUpperCase());
    }//GEN-LAST:event_nombreKeyReleased

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        char letras = evt.getKeyChar();
        if ((letras < 'a' || letras > 'z') && (letras < 'A' | letras > 'Z')) {
            if ((letras != 'ñ') && (letras != 'Ñ') && (letras != 'á') && (letras != 'Á') && (letras != 'é') && (letras != 'É') && (letras != 'í')
                    && (letras != 'Í') && (letras != 'ó') && (letras != 'Ó') && (letras != 'ú') && (letras != 'Ú') && (letras != ' ')) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_nombreKeyTyped

    private void precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioKeyTyped
        char num = evt.getKeyChar();
        if ((num < '0' || num > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_precioKeyTyped

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed

        alimento.extraerID();

        if (tipoAl.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione Tipo Alimento", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            alimento.RegistrarSuministro();
        }

        if (alimento.getInsert()) {
            alertas.AlertSuccess alerta = new alertas.AlertSuccess(this, true);
            alerta.Texto("Se ha registrado Correctamente");
            alerta.setVisible(true);
            alimento.setInsert(false);
        }
        if (alimento.getUpdate()) {
            alertas.AlertSuccess alerta = new alertas.AlertSuccess(this, true);
            alerta.Texto("Se ha Modificado Correctamente");
            alerta.setVisible(true);
            alimento.setUpdate(false);
        }

    }//GEN-LAST:event_registrarActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        alimento.RegistrarSuministro();
        if (alimento.getInsert()) {
            alertas.AlertSuccess alerta = new alertas.AlertSuccess(this, true);
            alerta.Texto("Se ha registrado Correctamente");
            alerta.setVisible(true);
            alimento.setInsert(false);
        }
        if (alimento.getUpdate()) {
            alertas.AlertSuccess alerta = new alertas.AlertSuccess(this, true);
            alerta.Texto("Se ha Modificado Correctamente");
            alerta.setVisible(true);
            alimento.setUpdate(false);
        }
    }//GEN-LAST:event_actualizarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if (idCliente == 0) {
            alertas.AlertError alerta = new alertas.AlertError(this, true);
            alerta.Texto("Seleccione un alimento para eliminar");
            alerta.setVisible(true);
        } else {
            alertas.AlertWarning alerta = new alertas.AlertWarning(this, true);
            alerta.AgregarTexto("Seguro quieres eliminar este alimento", "Si", "No");
            alerta.setVisible(true);
            if (alerta.bandera) {
                alimento.deleteCliente();
                alimento.restablecer();
                idCliente = 0;
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        alimento.restablecer();
        idCliente = 0;
        buscar.setText("");
    }//GEN-LAST:event_limpiarActionPerformed

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked
        // alimento.restablecer();
    }//GEN-LAST:event_buscarMouseClicked

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
        buscar.setText(buscar.getText().toUpperCase());
        alimento.SearchClientes(buscar.getText());

    }//GEN-LAST:event_buscarKeyReleased

    private void tipoAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoAlActionPerformed

    }//GEN-LAST:event_tipoAlActionPerformed

    private void TableInventario_platillosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableInventario_platillosMouseClicked
        if (TableInventario_platillos.getSelectedRows().length > 0) {
            alimento.GetCliente();
            idCliente = 1;
        }
    }//GEN-LAST:event_TableInventario_platillosMouseClicked

    private void TableInventario_platillosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableInventario_platillosKeyReleased
        if (TableInventario_platillos.getSelectedRows().length > 0) {
            alimento.GetCliente();
            idCliente = 1;
        }
    }//GEN-LAST:event_TableInventario_platillosKeyReleased

    private void buscar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buscar1MouseClicked

    private void buscar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscar1KeyReleased
        cliente.SearchClientes(buscar1.getText());
    }//GEN-LAST:event_buscar1KeyReleased

    private void TextFieldInventario_nombreg1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldInventario_nombreg1KeyReleased
        TextFieldInventario_nombreg1.setText(TextFieldInventario_nombreg1.getText().toUpperCase());
    }//GEN-LAST:event_TextFieldInventario_nombreg1KeyReleased

    private void TextFieldInventario_nombreg1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldInventario_nombreg1KeyTyped
        char letras = evt.getKeyChar();
        if ((letras < 'a' || letras > 'z') && (letras < 'A' | letras > 'Z')) {
            if ((letras != 'ñ') && (letras != 'Ñ') && (letras != 'á') && (letras != 'Á') && (letras != 'é') && (letras != 'É') && (letras != 'í')
                    && (letras != 'Í') && (letras != 'ó') && (letras != 'Ó') && (letras != 'ú') && (letras != 'Ú') && (letras != ' ')) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_TextFieldInventario_nombreg1KeyTyped

    private void TextFieldInventario_nombreg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldInventario_nombreg1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldInventario_nombreg1ActionPerformed

    private void TextFieldInventario_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldInventario_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldInventario_precioActionPerformed

    private void TextFieldInventario_precioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldInventario_precioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldInventario_precioKeyReleased

    private void TextFieldInventario_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldInventario_precioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldInventario_precioKeyTyped

    private void ComboBoxSuministroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxSuministroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxSuministroActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        TstVentNvoPres = false;
        venta.limpiaCampos(tablaPedidosVenta);
    }//GEN-LAST:event_cancelarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed

        int index = tablaPedidosVenta.getSelectedRow();
        System.out.println("INDEX " + index);
        int id = Integer.parseInt(tablaPedidosVenta.getValueAt(index, 0).toString());
        System.out.println(id);
        pedidos.EliminarPedido(id);
        float calculoTotal = 0;
        Venta venta = new Venta();
        venta.eliminar();
        for (int a = 0; a < tablaPedidosVenta.getRowCount(); a++) {
            calculoTotal = calculoTotal + Float.parseFloat(tablaPedidosVenta.getValueAt(a, 1).toString());
        }
        total.setText(String.valueOf(calculoTotal));
        this.repaint();
    }//GEN-LAST:event_borrarActionPerformed

    public static boolean TstVentNvoPres = false;
    private void venderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderActionPerformed

        if (tablaPedidosVenta.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No existen datos!!!");
        } else {
            if (TstVentNvoPres == false) {
                if ("".equals(nidCliente)) {
                    JOptionPane.showMessageDialog(null, "Seleccion Un Cliente.", "Registro Venta", 0,
                            new ImageIcon(getClass().getResource("/Resources/info.png")));
                } else {
                    ListaVenta ventana = new ListaVenta(pedidos.ObtenerDetallePedidoVenta());

                    
                    //this.repaint();
                    ventana.setVisible(true);
                    int id = 0;
                    int idMesa = ComboBoxMesas.getSelectedIndex();
                    for (int a = 0; a < tablaPedidosVenta.getRowCount(); a++) {
                        id = Integer.parseInt(tablaPedidosVenta.getValueAt(a, 0).toString());
                        pedidos.CambiarEstadoPedido(id);
                    }
                    ImageIcon imagen = mesas.cambiarEstadoCobrado(idMesa);
                    switch (idMesa) {
                        case 1:
                            mesa1.setIcon(imagen);
                            System.out.println("ENTRO MESA 1");
                            mesa1.show();
                            break;
                        case 2:
                            mesa2.setIcon(imagen);
                            System.out.println("ENTRO MESA 2");
                            mesa2.show();
                            break;
                        case 3:
                            mesa3.setIcon(imagen);
                            System.out.println("ENTRO MESA 3");
                            mesa3.show();
                            break;
                        case 4:
                            mesa4.setIcon(imagen);
                            System.out.println("ENTRO MESA 4");
                            mesa4.show();
                            break;
                        case 5:
                            mesa5.setIcon(imagen);
                            System.out.println("ENTRO MESA 5");
                            mesa5.show();
                            break;
                        case 6:
                            mesa6.setIcon(imagen);
                            System.out.println("ENTRO MESA 6");
                            mesa6.show();
                            break;
                        case 7:
                            mesa7.setIcon(imagen);
                            System.out.println("ENTRO MESA 7");
                            mesa7.show();
                            break;
                        case 8:
                            mesa8.setIcon(imagen);
                            System.out.println("ENTRO MESA 8");
                            mesa8.show();
                            break;
                        case 9:
                            mesa9.setIcon(imagen);
                            System.out.println("ENTRO MESA 9");
                            mesa9.show();
                            break;
                        case 10:
                            mesa10.setIcon(imagen);
                            System.out.println("ENTRO MESA 10");
                            break;
                    }
                    this.repaint();

                    TVentas venta = new TVentas();
                    venta.setId(numFac.getText());
                    venta.setNombre(nombreClienteVenta);
                    venta.setApellido(apellidoCliente);
                    venta.setTotal(total.getText());
                    venta.setFecha(rSLabelFecha1.getFecha());

                    ventaSQL registro = new ventaSQL();
                    registro.registrar(venta);

                    PedidoSQL actualizarPedido = new PedidoSQL();
                    actualizarPedido.listar("");

                    registro.listar("");

                    numFac.setText(String.valueOf(fac));
                    
                    
                    JreportJaper jasper = new JreportJaper();
                    jasper.jasper(Integer.parseInt(numFac.getText()) -1);
                    
                    
                    
                    rSMaterialButtonRectangle13.setEnabled(false);
                    ComboBoxMesas.setEnabled(false);
                    ComboBoxMesas.setSelectedIndex(0);
                    rSMaterialButtonRectangle24.setEnabled(false);
                    calculo.setEnabled(false);
                    vender.setEnabled(false);
                    borrar.setEnabled(false);
                    cancelar.setEnabled(false);
                    rSMaterialButtonRectangle12.setEnabled(true);

                }
                TstVentNvoPres = true;
                venta.limpiaCampos(tablaPedidosVenta);
            } else {
                JOptionPane.showMessageDialog(null, "La ventana Detalle venta ya esta abierta!!!");
            }

        }
    }//GEN-LAST:event_venderActionPerformed

    private void calculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculoActionPerformed
        if (recibi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese un valor.", "Caja de cobro", 0);
        } else {
            double recibe = Double.parseDouble(recibi.getText());
            double tota = Double.parseDouble(total.getText());

            if (recibe < tota) {
                JOptionPane.showMessageDialog(this, "Ingrese un valor valido.", "Caja de cobro", 0);
            } else {
                this.cambio.setText(String.valueOf(recibe - tota));
            }
        }
    }//GEN-LAST:event_calculoActionPerformed

    private void rSMaterialButtonRectangle12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle12ActionPerformed

        ListarClientes listarCliente = new ListarClientes();
        listarCliente.toFront();
        listarCliente.setIdentificador(false);
        listarCliente.setVisible(true);


    }//GEN-LAST:event_rSMaterialButtonRectangle12ActionPerformed

    private void btnGenerarReportePlatillosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReportePlatillosActionPerformed
        String[] cabecera = new String[]{"Código", "Nombre", "Precio", "Tipo Alimento"};
        String TituloReporte = "Reporte de Alimentos";
        String ConsultaSql = "SELECT Codigo_al, Nombre_al, Precio_al, Tipo_al FROM alimentos";
        String FileName = "alimentos";
        Excel.reporte(cabecera, TituloReporte, ConsultaSql, FileName);
        alertas.AlertSuccess alerta = new alertas.AlertSuccess(this, true);
        alerta.Texto("Reporte Generado Correctamente");
        alerta.setVisible(true);
    }//GEN-LAST:event_btnGenerarReportePlatillosActionPerformed

    private void btnGenerarReporteSuministrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteSuministrosActionPerformed
        String[] cabecera = new String[]{"Código", "Nombre", "Stock", "Precio", "Categoria"};
        String TituloReporte = "Reporte de Suministros";
        String ConsultaSql = "SELECT Codigo, Nombre, Stock, Precio, Categoria FROM suministros";
        String FileName = "suministros";
        Excel.reporte(cabecera, TituloReporte, ConsultaSql, FileName);
        alertas.AlertSuccess alerta = new alertas.AlertSuccess(this, true);
        alerta.Texto("Reporte Generado Correctamente");
        alerta.setVisible(true);
    }//GEN-LAST:event_btnGenerarReporteSuministrosActionPerformed

    private void btnGenerarReporteSuministrosPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteSuministrosPDFActionPerformed
        Pdf reporte = new Pdf();
        reporte.pdf();
    }//GEN-LAST:event_btnGenerarReporteSuministrosPDFActionPerformed

    private void ButtonCliente_Agregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCliente_Agregar1ActionPerformed

    }//GEN-LAST:event_ButtonCliente_Agregar1ActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void jTabbedPane3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTabbedPane3AncestorAdded

    }//GEN-LAST:event_jTabbedPane3AncestorAdded

    private void registrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarPedidoActionPerformed
        ComboBoxSuministro1.setEnabled(true);
        if (tablePedidos.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No Existen Datos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            if (ComboBoxSuministro1.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "No ha Seleccionado la Mesa", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                int mesa = ComboBoxSuministro1.getSelectedIndex();
                System.out.println(mesa);

                if (mesa == 1) {
                    System.out.println("entro");
                    mesa1.setIcon(new ImageIcon(getClass().getResource("/Resources/mesaOcupado.png")));

                }
                if (mesa == 2) {
                    mesa2.setIcon(new ImageIcon(getClass().getResource("/Resources/mesaOcupado.png")));

                }
                if (mesa == 3) {
                    mesa3.setIcon(new ImageIcon(getClass().getResource("/Resources/mesaOcupado.png")));

                }
                if (mesa == 4) {
                    mesa4.setIcon(new ImageIcon(getClass().getResource("/Resources/mesaOcupado.png")));

                }
                if (mesa == 5) {
                    mesa5.setIcon(new ImageIcon(getClass().getResource("/Resources/mesaOcupado.png")));

                }
                if (mesa == 6) {
                    mesa6.setIcon(new ImageIcon(getClass().getResource("/Resources/mesaOcupado.png")));

                }
                if (mesa == 7) {
                    mesa7.setIcon(new ImageIcon(getClass().getResource("/Resources/mesaOcupado.png")));

                }
                if (mesa == 8) {
                    mesa8.setIcon(new ImageIcon(getClass().getResource("/Resources/mesaOcupado.png")));

                }
                if (mesa == 9) {
                    mesa9.setIcon(new ImageIcon(getClass().getResource("/Resources/mesaOcupado.png")));

                }
                if (mesa == 10) {
                    mesa10.setIcon(new ImageIcon(getClass().getResource("/Resources/mesaOcupado.png")));

                }

                pedidos.GuardarPedido(mesa, tablePedidos);
                PedidoSQL actualizarPedido = new PedidoSQL();
                actualizarPedido.listar("");

                nuevoPedido.setEnabled(true);
                numFac1.setText("PEDIDO");
                registrarPedido.setEnabled(false);
                busca1.setEnabled(false);
                ComboBoxSuministro1.setSelectedIndex(0);
                pedido.limpiaCampos();
            }
        }

    }//GEN-LAST:event_registrarPedidoActionPerformed

    private void rSMaterialButtonRectangle14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle14ActionPerformed
        mesa1.setIcon(mesas.cambiarEstado(1));
        mesas = new controlMesa();
    }//GEN-LAST:event_rSMaterialButtonRectangle14ActionPerformed

    private void rSMaterialButtonRectangle15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle15ActionPerformed
        mesa2.setIcon(mesas.cambiarEstado(2));
        mesas = new controlMesa();
    }//GEN-LAST:event_rSMaterialButtonRectangle15ActionPerformed

    private void rSMaterialButtonRectangle16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle16ActionPerformed
        mesa3.setIcon(mesas.cambiarEstado(3));
        mesas = new controlMesa();
    }//GEN-LAST:event_rSMaterialButtonRectangle16ActionPerformed

    private void rSMaterialButtonRectangle17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle17ActionPerformed
        mesa4.setIcon(mesas.cambiarEstado(4));
        mesas = new controlMesa();
    }//GEN-LAST:event_rSMaterialButtonRectangle17ActionPerformed

    private void rSMaterialButtonRectangle18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle18ActionPerformed
        mesa5.setIcon(mesas.cambiarEstado(5));
        mesas = new controlMesa();
    }//GEN-LAST:event_rSMaterialButtonRectangle18ActionPerformed

    private void rSMaterialButtonRectangle19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle19ActionPerformed
        mesa6.setIcon(mesas.cambiarEstado(6));
        mesas = new controlMesa();
    }//GEN-LAST:event_rSMaterialButtonRectangle19ActionPerformed

    private void rSMaterialButtonRectangle20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle20ActionPerformed
        mesa7.setIcon(mesas.cambiarEstado(7));
        mesas = new controlMesa();
    }//GEN-LAST:event_rSMaterialButtonRectangle20ActionPerformed

    private void rSMaterialButtonRectangle21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle21ActionPerformed
        mesa8.setIcon(mesas.cambiarEstado(8));
        mesas = new controlMesa();
    }//GEN-LAST:event_rSMaterialButtonRectangle21ActionPerformed

    private void rSMaterialButtonRectangle22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle22ActionPerformed
        mesa9.setIcon(mesas.cambiarEstado(9));
        mesas = new controlMesa();
    }//GEN-LAST:event_rSMaterialButtonRectangle22ActionPerformed

    private void rSMaterialButtonRectangle23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle23ActionPerformed
        mesa10.setIcon(mesas.cambiarEstado(10));
        mesas = new controlMesa();
    }//GEN-LAST:event_rSMaterialButtonRectangle23ActionPerformed

    ListaAlimentos la = new ListaAlimentos();
    private void busca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busca1ActionPerformed

        ListaAlimentos listaAlimentosPedidos = new ListaAlimentos();
        listaAlimentosPedidos.setIdentificador(true);
        listaAlimentosPedidos.toFront();
        listaAlimentosPedidos.setVisible(true);

    }//GEN-LAST:event_busca1ActionPerformed

    private void TotalPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalPedidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalPedidosActionPerformed

    private void TextFieldInventario_stockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldInventario_stockKeyTyped
        char num = evt.getKeyChar();
        if ((num < '0' || num > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_TextFieldInventario_stockKeyTyped

    private void registrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrar1ActionPerformed
        jTabbedPane3.setSelectedIndex(2);
    }//GEN-LAST:event_registrar1ActionPerformed

    private void jTabbedPane2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane2StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane2StateChanged

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed

    private void btnGenerarReporteSuministrosPDF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteSuministrosPDF1ActionPerformed

        Pdf reporte = new Pdf();
        reporte.pdfAlimentos();
    }//GEN-LAST:event_btnGenerarReporteSuministrosPDF1ActionPerformed

    private void ButtonCliente_Paginas8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCliente_Paginas8ActionPerformed
        suministro.Paginador("Ultimo");
    }//GEN-LAST:event_ButtonCliente_Paginas8ActionPerformed

    private void ButtonCliente_Paginas7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCliente_Paginas7ActionPerformed
        suministro.Paginador("Siguiente");
    }//GEN-LAST:event_ButtonCliente_Paginas7ActionPerformed

    private void ButtonCliente_Paginas6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCliente_Paginas6ActionPerformed
        suministro.Paginador("Anterior");
    }//GEN-LAST:event_ButtonCliente_Paginas6ActionPerformed

    private void ButtonCliente_Paginas5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCliente_Paginas5ActionPerformed
        suministro.Paginador("Primero");
    }//GEN-LAST:event_ButtonCliente_Paginas5ActionPerformed

    private void SpinnerPaginasInventario_suministro2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinnerPaginasInventario_suministro2StateChanged
        suministro.Registro_PaginasInventario();

    }//GEN-LAST:event_SpinnerPaginasInventario_suministro2StateChanged

    private void borrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar1ActionPerformed
        pedido.Eliminar();

    }//GEN-LAST:event_borrar1ActionPerformed
    PedidoVM pedido = new PedidoVM();
    private void cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar1ActionPerformed
        pedido.limpiaCampos();
        nuevoPedido.setEnabled(true);
        busca1.setEnabled(false);
        registrarPedido.setEnabled(false);
    }//GEN-LAST:event_cancelar1ActionPerformed

    private void nuevoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoPedidoActionPerformed
        nuevoPedido.setEnabled(false);
        registrarPedido.setEnabled(true);
        busca1.setEnabled(true);
        borrar1.setEnabled(true);
        cancelar1.setEnabled(true);
        ComboBoxSuministro1.setEnabled(true);
        pedidos = new controlPedido();
        numFac1.setText(String.valueOf(pedidos.ObtenerIDPedido()));
    }//GEN-LAST:event_nuevoPedidoActionPerformed

    private void ComboBoxSuministro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxSuministro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxSuministro1ActionPerformed

    private void rSMaterialButtonRectangle25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle25ActionPerformed

        if (tablaCotizaciones.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No Existen Datos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(nidCotizacion.getText())) {
            JOptionPane.showMessageDialog(null, "No existe Cliente", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            reportePdf.pdfCotizacion();
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle25ActionPerformed

    private CotizacionesMV cotizacion = new CotizacionesMV();
    private void borrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar2ActionPerformed
        cotizacion.Eliminar();
    }//GEN-LAST:event_borrar2ActionPerformed

    private void cancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar2ActionPerformed
        cotizacion.limpiaCampos();
        porcentaje.setText("");
        descuento.setText("");
        TotalCotizacion.setText("");
        nidCotizacion.setText("");
        nombreCotizacion.setText("");
        apellidoCotizacion.setText("");
        dirCotizacion.setText("");
    }//GEN-LAST:event_cancelar2ActionPerformed

    private void rSMaterialButtonRectangle26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle26ActionPerformed

    private void busca2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busca2ActionPerformed
        ListaAlimentos laa = new ListaAlimentos();
        laa.setIdentificador(false);
        laa.toFront();
        laa.setVisible(true);
    }//GEN-LAST:event_busca2ActionPerformed

    private void TotalCotizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalCotizacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalCotizacionActionPerformed

    private void rSMaterialButtonRectangle27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle27ActionPerformed
        ListarClientes listarCliente = new ListarClientes();
        listarCliente.toFront();
        listarCliente.setIdentificador(true);
        listarCliente.setVisible(true);
    }//GEN-LAST:event_rSMaterialButtonRectangle27ActionPerformed

    private void rSMaterialButtonRectangle28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle28ActionPerformed
        TabbedPanePrincipal.setSelectedIndex(0);
        ArrayList<JLabel> label = new ArrayList();
        label.add(LabelCliente_Nid);
        label.add(LabelCliente_Nombre);
        label.add(LabelCliente_Apellido);
        label.add(LabelCliente_Email);
        label.add(LabelCliente_Telefono);
        label.add(LabelCliente_Direccion);
        label.add(LabelImage_Cliente);
        label.add(LabelCliente_Paginas);
        ArrayList<JTextField> textField = new ArrayList();
        textField.add(TextFieldCliente_Nid);
        textField.add(TextFieldCliente_Nombre);
        textField.add(TextFieldCliente_Apellido);
        textField.add(TextFieldCliente_Email);
        textField.add(TextFieldCliente_Telefono);
        textField.add(TextFieldCliente_Direccion);
        Object[] objects = {
            CheckBoxCliente_Credito,
            Table_Clientes,
            SpinnerPaginas_Clientes,
            TableCliente_Report,};
        cliente.componente(objects, label, textField);

    }//GEN-LAST:event_rSMaterialButtonRectangle28ActionPerformed

    private void jTabbedPane3AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTabbedPane3AncestorMoved
        mesas = new controlMesa();
        mesa1.setIcon(mesas.obtenerEstado(1));
        mesa2.setIcon(mesas.obtenerEstado(2));
        mesa3.setIcon(mesas.obtenerEstado(3));
        mesa4.setIcon(mesas.obtenerEstado(4));
        mesa5.setIcon(mesas.obtenerEstado(5));
        mesa6.setIcon(mesas.obtenerEstado(6));
        mesa7.setIcon(mesas.obtenerEstado(7));
        mesa8.setIcon(mesas.obtenerEstado(8));
        mesa9.setIcon(mesas.obtenerEstado(9));
        mesa10.setIcon(mesas.obtenerEstado(10));
        this.repaint();
    }//GEN-LAST:event_jTabbedPane3AncestorMoved

    private void porcentajeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_porcentajeKeyReleased
        ArrayList<JTextField> textField = new ArrayList();
        if ("".equals(Subtotal.getText())) {
            alertas.AlertError alerta = new alertas.AlertError(this, true);
            alerta.Texto("Error");
            alerta.setVisible(true);
            porcentaje.setText("");
        } else {
            textField.add(Subtotal);
            textField.add(porcentaje);
            textField.add(descuento);
            textField.add(TotalCotizacion);

            cotizacion.Componentes(textField);

        }


    }//GEN-LAST:event_porcentajeKeyReleased

    private void SubtotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SubtotalKeyReleased


    }//GEN-LAST:event_SubtotalKeyReleased

    private void ComboBoxMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxMesasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxMesasActionPerformed

    private void rSMaterialButtonRectangle13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle13ActionPerformed
        if (ComboBoxMesas.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una Mesa.");
        } else {
            tablaPedidosVenta.setModel(pedidos.ObtenerPedidosMesa(ComboBoxMesas.getSelectedIndex()));
            if (tablaPedidosVenta.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No existen pedidos.");
            }
            float calculoTotal = 0;
            for (int a = 0; a < tablaPedidosVenta.getRowCount(); a++) {
                calculoTotal = calculoTotal + Float.parseFloat(tablaPedidosVenta.getValueAt(a, 1).toString());
            }
            total.setText(String.valueOf(calculoTotal));
            this.repaint();
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle13ActionPerformed

    private void rSMaterialButtonRectangle24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle24ActionPerformed
        int fila = tablaPedidosVenta.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro.");
        } else {
            int id = Integer.parseInt(tablaPedidosVenta.getValueAt(fila, 0).toString());
            Pedidos ventana = new Pedidos(pedidos.ObtenerDetallePedido(id), id);
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle24ActionPerformed

    private void rSMaterialButtonRectangle29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle29ActionPerformed
        TabbedPanePrincipal.setSelectedIndex(5);
    }//GEN-LAST:event_rSMaterialButtonRectangle29ActionPerformed

    private void rSMaterialButtonRectangle30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle30ActionPerformed
        fac = pedidos.ObtenerNumeroFactura();

        TstVentNvoPres = false;
        numFac.setText(String.valueOf(fac));
        rSMaterialButtonRectangle13.setEnabled(true);
        ComboBoxMesas.setEnabled(true);
        rSMaterialButtonRectangle24.setEnabled(true);
        calculo.setEnabled(true);
        vender.setEnabled(true);
        borrar.setEnabled(true);
        cancelar.setEnabled(true);
        rSMaterialButtonRectangle12.setEnabled(true);
    }//GEN-LAST:event_rSMaterialButtonRectangle30ActionPerformed

    private void CheckBoxCliente_CreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxCliente_CreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckBoxCliente_CreditoActionPerformed

    private void rSMaterialButtonRectangle31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle31ActionPerformed

        TabbedPanePrincipal.setSelectedIndex(3);
        jTabbedPane4.setSelectedIndex(0);
    }//GEN-LAST:event_rSMaterialButtonRectangle31ActionPerformed

    private void ventasH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventasH1ActionPerformed

        Date sistemaFech = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fecH = formato.format(sistemaFech);
        registro1.listar(fecH);
        fecha.setDate(null);
    }//GEN-LAST:event_ventasH1ActionPerformed

    private void ventasHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventasHActionPerformed

        if (fecha.getDate() == null) {
            registro1.listar("");
        } else {
            String formato = fecha.getDateFormatString();
            Date date = fecha.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            registro1.listar(String.valueOf(sdf.format(date)));
        }
    }//GEN-LAST:event_ventasHActionPerformed

    private void buscFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscFActionPerformed

    }//GEN-LAST:event_buscFActionPerformed

    private void limpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar1ActionPerformed
        limpiarCamposRegistroVenta();

    }//GEN-LAST:event_limpiar1ActionPerformed

    public void limpiarCamposRegistroVenta() {
        if (tablaVentas.getSelectedRow() > -1) {
            tablaVentas.removeRowSelectionInterval(tablaVentas.getSelectedRow(), tablaVentas.getSelectedRow());
        }
        fecha.setDate(null);
        buscar2.setText("");
        registro1.listar("");
        txtIdVenta.setText("");
    }
    private void eliminarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarTActionPerformed

        if (tablaVentas.getRowCount() > 0) {
            if (JOptionPane.showConfirmDialog(this, "Esta a punto de elimnar\ntodos los registros.\n¿Desea continuar?", "Registro Ventas", JOptionPane.YES_NO_OPTION, 0,
                    new ImageIcon(getClass().getResource("/Resources/seguro.png"))) == JOptionPane.YES_OPTION) {
                int eliminaT = registro1.eliminaTodos();
                if (eliminaT != 0) {
                    limpiarCamposRegistroVenta();
                    JOptionPane.showMessageDialog(this, "Registros eliminados.", "Registro Ventas", 0,
                            new ImageIcon(getClass().getResource("/Resources/borrado.png")));
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay registros\npara eliminar.", "Registro Ventas", 0,
                    new ImageIcon(getClass().getResource("/Resources/info.png")));
        }

    }//GEN-LAST:event_eliminarTActionPerformed

    private void eliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar1ActionPerformed

        if (tablaVentas.getRowCount() > 0) {
            if (tablaVentas.getSelectedRowCount() > 0) {
                if (JOptionPane.showConfirmDialog(this, "Esta a punto de eliminar\nun registro.\n¿Desea continuar?", "Registro Ventas", JOptionPane.YES_NO_OPTION, 0,
                        new ImageIcon(getClass().getResource("/Resources/seguro.png"))) == JOptionPane.YES_OPTION) {
                    int fila = tablaVentas.getSelectedRow();
                    String id = tablaVentas.getValueAt(fila, 0).toString();
                    int elimina = registro1.eliminar(id);
                    if (elimina != 0) {
                        limpiarCamposRegistroVenta();
                        JOptionPane.showMessageDialog(this, "Registro eliminado.", "Registro Ventas", 0,
                                new ImageIcon(getClass().getResource("/Resources/borrado1.png")));
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un registro.", "Registro Ventas", 0,
                        new ImageIcon(getClass().getResource("/Resources/info.png")));
            }

        } else {
            JOptionPane.showMessageDialog(this, "No hay registros\npara eliminar.", "Registro Ventas", 0,
                    new ImageIcon(getClass().getResource("/Resources/info.png")));
        }
    }//GEN-LAST:event_eliminar1ActionPerformed

    private void buscar2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscar2KeyTyped
        char num = evt.getKeyChar();
        if ((num < '0' || num > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_buscar2KeyTyped

    private void buscar2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscar2KeyReleased

        registro1.listar(buscar2.getText());

    }//GEN-LAST:event_buscar2KeyReleased

    private void buscar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscar2MouseClicked

    }//GEN-LAST:event_buscar2MouseClicked

    private void btnGenerarReporteSuministrosPDF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteSuministrosPDF2ActionPerformed

        if (txtIdVenta.getText() == "") {
            JOptionPane.showMessageDialog(null, "selecciones un pedido we");
        } else {
            try {
                int id = Integer.parseInt(txtIdVenta.getText());
                File file = new File("src/pdf/venta" + id + ".pdf");

                if (file.exists()) {
                    Desktop.getDesktop().open(file);
                } else {
                    alertas.AlertError alerta = new alertas.AlertError(this, true);
                    alerta.Texto("No existe el archivo");
                    alerta.setVisible(true);
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "selecciones un pedido we");
            }
        }

    }//GEN-LAST:event_btnGenerarReporteSuministrosPDF2ActionPerformed

    private void tablaVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVentasMouseClicked

        // TODO add your handling code here:
        int fila = tablaVentas.rowAtPoint(evt.getPoint());
        txtIdVenta.setText(tablaVentas.getValueAt(fila, 0).toString());
    }//GEN-LAST:event_tablaVentasMouseClicked

    private void ButtonClienteConfig2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonClienteConfig2ActionPerformed
        jLabel1.setText("Panel Administrativo");
        TabbedPanePrincipal.setSelectedIndex(6);
        InicializarClientes();

    }//GEN-LAST:event_ButtonClienteConfig2ActionPerformed

    private void InicializarClientes() {
        BtnVentas.setEnabled(true);
        ButtonCliente.setEnabled(false);
        ButtonInventario.setEnabled(true);
        ButtonCotizacion.setEnabled(true);
        //ButtonAdministracion.setEnabled(true);
        ButtonClienteConfig.setEnabled(true);
        ArrayList<JLabel> label = new ArrayList();
        label.add(LabelCliente_Nid);
        label.add(LabelCliente_Nombre);
        label.add(LabelCliente_Apellido);
        label.add(LabelCliente_Email);
        label.add(LabelCliente_Telefono);
        label.add(LabelCliente_Direccion);
        label.add(LabelImage_Cliente);
        label.add(LabelCliente_Paginas);
        ArrayList<JTextField> textField = new ArrayList();
        textField.add(TextFieldCliente_Nid);
        textField.add(TextFieldCliente_Nombre);
        textField.add(TextFieldCliente_Apellido);
        textField.add(TextFieldCliente_Email);
        textField.add(TextFieldCliente_Telefono);
        textField.add(TextFieldCliente_Direccion);
        Object[] objects = {
            CheckBoxCliente_Credito,
            Table_Clientes,
            SpinnerPaginas_Clientes,
            TableCliente_Report,};
        cliente.componente(objects, label, textField);
    }

    private void BtnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVentasActionPerformed
        TabbedPanePrincipal.setSelectedIndex(4);
        TabbedPanePrincipal.setSelectedIndex(4);
        ButtonCliente.setEnabled(true);
        ButtonInventario.setEnabled(true);
        ButtonCotizacion.setEnabled(true);
        //ButtonAdministracion.setEnabled(true);
        ButtonClienteConfig.setEnabled(true);
    }//GEN-LAST:event_BtnVentasActionPerformed

    // <editor-fold defaultstate="collapsed" desc="CODIGO DE CLIENTE">
    // private ClientesVM cliente;
    private void ButtonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonClienteActionPerformed
        TabbedPanePrincipal.setSelectedIndex(0);

    }//GEN-LAST:event_ButtonClienteActionPerformed

    private void btnDasboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDasboardActionPerformed

        this.rSPanelsSlider1.slidPanel(5, pnlDasboard, RSPanelsSlider.direct.Right);
    }//GEN-LAST:event_btnDasboardActionPerformed

    private void rSButtonMaterialIconUno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialIconUno2ActionPerformed
        dispose();
        try {
            login.Close();
        } catch (SQLException ex) {
        }
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_rSButtonMaterialIconUno2ActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        TabbedPanePrincipal.setSelectedIndex(1);
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutActionPerformed
        new about.About(this, "", true).setVisible(true);
    }//GEN-LAST:event_btnAboutActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed

    }//GEN-LAST:event_btnVentasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (JOptionPane.YES_NO_OPTION == JOptionPane.showConfirmDialog(null,
                "Estas seguro de salir del sistema ? ", "Cerrar sesión ",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
            try {
                login.Close();
            } catch (SQLException ex) {
            }

        }
    }//GEN-LAST:event_formWindowClosing

    private void btnConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracionActionPerformed
//        if (_dataUsuario.getRole().equals("Admin")) {
//
//        } else {
//            AlertError error = new AlertError(this, true);
//            error.Texto("Acceso Denegado");
//            error.setVisible(true);
//        }

        this.rSPanelsSlider1.slidPanel(5, pnlConf, RSPanelsSlider.direct.Right);
    }//GEN-LAST:event_btnConfiguracionActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed

        if (_dataUsuario.getRole().equals("Admin")) {
            this.rSPanelsSlider1.slidPanel(5, pnlUsuarios, RSPanelsSlider.direct.Right);

            // TabbedPanePrincipal.setSelectedIndex(2);
            // label.add(LabelUsuario_Nid);
//          label.add(LabelUsuario_Nid);
//          label.add(LabelUsuario_Nombre);
            //label.add(LabelUsuario_Email);
//        label.add(LabelUsuario_Apellido);
//        label.add(LabelUsuario_Telefono);
//        label.add(LabelUsuario_Direccion);
//        label.add(LabelUsuario_Usuario);
//        label.add(LabelUsuario_Password);
//        
            //label.add(LabelImage_Usuario);
//        label.add(LabelUsuario_Paginas);
//        
            ArrayList<JTextField> textField = new ArrayList();
            textField.add(TextFieldUsuario_Nid);
            textField.add(TextFieldUsuario_Nombre);
            textField.add(TextFieldUsuario_Email);
            textField.add(TextFieldUsuario_Apellido);
            textField.add(TextFieldUsuario_Telefono);
            textField.add(TextFieldUsuario_Direccion);
            textField.add(TextFieldUsuario_Usuario);
            textField.add(TextFieldUsuario_Password);

            Object[] objects = {
                rSFotoSquare1,
                CheckBoxUsuario_State,
                Table_Usuarios,
                ComboBoxUsuario_Role,};
            usuario = new UsuariosVM(objects, textField);
//        EnabledButton(ButtonUsuario);

        } else {
            this.rSPanelsSlider1.slidPanel(5, pnlUsuarioDenegado, RSPanelsSlider.direct.Right);
        }


    }//GEN-LAST:event_btnUsuariosActionPerformed

    private CambiarUsuario cambiarUsuario;
    private void rSButtonMetro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro1ActionPerformed
        cambiarUsuario = new CambiarUsuario();
        cambiarUsuario.setVisible(true);

    }//GEN-LAST:event_rSButtonMetro1ActionPerformed

    private CambiarContraseña cambiarConstraseña;
    private void rSButtonMetro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro3ActionPerformed
        // new CambiarPassword(this, true).setVisible(true);
        cambiarConstraseña = new CambiarContraseña();
        cambiarConstraseña.setVisible(true);
    }//GEN-LAST:event_rSButtonMetro3ActionPerformed

    private void btnBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackupActionPerformed

        if (_dataUsuario.getRole().equals("Admin")) {
            GeneraBackup();
        } else {
            AlertError error = new AlertError(this, true);
            error.Texto("Acceso Denegado");
            error.setVisible(true);
        }
    }//GEN-LAST:event_btnBackupActionPerformed

    private void rSButtonMetro5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro5ActionPerformed
        if (this._dataUsuario.getRole().equals("Admin")) {
            RestoreBackup();
        } else {
            AlertError error = new AlertError(this, true);
            error.Texto("Sin Acceso");
            error.setVisible(true);
        }
    }//GEN-LAST:event_rSButtonMetro5ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        //        if (this.txtNombre.getText().length() == 0 || this.txtUser.getText().length() == 0
        //            || this.txtPass.getText().length() == 0 || this.comboTipo.getSelectedIndex() == 0) {
        //            ErrorAlert a = new ErrorAlert(null, true);
        //            a.msj1.setText("Todos los campos son requeridos.");
        //            a.msj2.setVisible(false);
        //            a.msj3.setVisible(false);
        //            a.setVisible(true);
        //        } else {
        //
        //            if (this.btnRegistrar.getText().equals("REGISTRAR")) {
        //                registraUser();
        //            }
        //            if (this.btnRegistrar.getText().equals("GUARDAR")) {
        //                guardarUser();
        //            }
        //        }
        usuario.RegistrarUsuario();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //        limpiarCampos();
        usuario.Restablecer();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void Table_UsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_UsuariosMouseClicked
        //        int row = tablaUsuarios.rowAtPoint(evt.getPoint());
        //        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
        //            this.tablaUsuarios.setRowSelectionInterval(row, row);
        //            PosicionMouse = evt.getY() / 16;
        //            menuUser.show(evt.getComponent(), evt.getX(), evt.getY());
        //        } else {
        //            this.tablaUsuarios.setRowSelectionInterval(row, row);
        //        }
        if (Table_Usuarios.getSelectedRows().length > 0) {
            usuario.GetUsuario();
        }
    }//GEN-LAST:event_Table_UsuariosMouseClicked

    private void TextFieldUsuario_NidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldUsuario_NidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldUsuario_NidActionPerformed

    private void TextFieldUsuario_DireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldUsuario_DireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldUsuario_DireccionActionPerformed

    private void TextFieldUsuario_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldUsuario_UsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldUsuario_UsuarioActionPerformed

    private void TextFieldUsuario_NombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldUsuario_NombreKeyReleased
        Objectos.eventos.textKeyPress(evt);
    }//GEN-LAST:event_TextFieldUsuario_NombreKeyReleased

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        AlertWarningSalir a = new AlertWarningSalir(this, false);
        a.setTitle("¿Deseas salir del sistema?");
        a.setVisible(true);

    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnCerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrar1ActionPerformed
        this.setExtendedState(ICONIFIED);
        if (!minimiza) {
            minimiza = false;
            this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        } else {
            minimiza = true;
        }
    }//GEN-LAST:event_btnCerrar1ActionPerformed

    private void TextFieldUsuario_NidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldUsuario_NidKeyReleased
        Objectos.eventos.numberKeyPres(evt);
    }//GEN-LAST:event_TextFieldUsuario_NidKeyReleased

    private void TextFieldUsuario_ApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldUsuario_ApellidoKeyReleased
        Objectos.eventos.textKeyPress(evt);
    }//GEN-LAST:event_TextFieldUsuario_ApellidoKeyReleased

    private void TextFieldUsuario_TelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldUsuario_TelefonoKeyReleased
        Objectos.eventos.numberKeyPres(evt);
    }//GEN-LAST:event_TextFieldUsuario_TelefonoKeyReleased

    private void rSFotoSquare1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSFotoSquare1MouseClicked
        Objectos.uploadimage.CargarImagen(rSFotoSquare1);
    }//GEN-LAST:event_rSFotoSquare1MouseClicked

    private void TextField_BuscarUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_BuscarUsuarioKeyReleased
        usuario.SearchUsuarios(TextField_BuscarUsuario.getText());
    }//GEN-LAST:event_TextField_BuscarUsuarioKeyReleased

    private void Table_UsuariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table_UsuariosKeyReleased
        if (Table_Usuarios.getSelectedRows().length > 0) {
            usuario.GetUsuario();
        }
    }//GEN-LAST:event_Table_UsuariosKeyReleased

    private void rSLabelImage2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSLabelImage2MouseClicked
        this.rSPanelsSlider1.slidPanel(5, pnlInicio, RSPanelsSlider.direct.Right);
    }//GEN-LAST:event_rSLabelImage2MouseClicked

    private void numFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numFacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numFacActionPerformed

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
        JreportJaper jasper = new JreportJaper();
        jasper.jasperAlimento();
    }//GEN-LAST:event_btnPedidosActionPerformed

    // </editor-fold>
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Sistema(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonRound BtnVentas;
    private javax.swing.JButton ButtonCliente;
    private javax.swing.JButton ButtonClienteConfig;
    private javax.swing.JButton ButtonClienteConfig2;
    private rojerusan.RSMaterialButtonRectangle ButtonCliente_Agregar;
    private rojerusan.RSMaterialButtonRectangle ButtonCliente_Agregar1;
    private rojerusan.RSMaterialButtonRectangle ButtonCliente_Cancelar;
    private javax.swing.JButton ButtonCliente_Paginas1;
    private javax.swing.JButton ButtonCliente_Paginas2;
    private javax.swing.JButton ButtonCliente_Paginas3;
    private javax.swing.JButton ButtonCliente_Paginas4;
    private javax.swing.JButton ButtonCliente_Paginas5;
    private javax.swing.JButton ButtonCliente_Paginas6;
    private javax.swing.JButton ButtonCliente_Paginas7;
    private javax.swing.JButton ButtonCliente_Paginas8;
    private javax.swing.JButton ButtonCotizacion;
    private javax.swing.JButton ButtonInventario;
    private javax.swing.JCheckBox CheckBoxCliente_Credito;
    private javax.swing.JCheckBox CheckBoxUsuario_State;
    private org.bolivia.combo.SComboBoxBlue ComboBoxMesas;
    private org.bolivia.combo.SComboBoxBlue ComboBoxSuministro;
    private org.bolivia.combo.SComboBoxBlue ComboBoxSuministro1;
    public static rojerusan.RSComboMetro ComboBoxUsuario_Role;
    private javax.swing.JLabel LabelCliente_Apellido;
    private javax.swing.JLabel LabelCliente_Direccion;
    private javax.swing.JLabel LabelCliente_Email;
    private javax.swing.JLabel LabelCliente_Nid;
    private javax.swing.JLabel LabelCliente_Nombre;
    private javax.swing.JLabel LabelCliente_Nombre1;
    private javax.swing.JLabel LabelCliente_Nombre2;
    private javax.swing.JLabel LabelCliente_Nombre3;
    private javax.swing.JLabel LabelCliente_Nombre4;
    private javax.swing.JLabel LabelCliente_Nombre5;
    private javax.swing.JLabel LabelCliente_Nombre6;
    private javax.swing.JLabel LabelCliente_Nombre7;
    private javax.swing.JLabel LabelCliente_Paginas;
    private javax.swing.JLabel LabelCliente_Telefono;
    private javax.swing.JLabel LabelImage_Cliente;
    private rojerusan.RSLabelCircleImage LabelImage_Usuario;
    private javax.swing.JLabel LabelInventarioSuministro_Paginas2;
    private javax.swing.JLabel LabelInventario_CategoriaDescrip;
    private javax.swing.JLabel LabelInventario_CategoriaNombre;
    private javax.swing.JLabel LabelInventario_codigo;
    private javax.swing.JLabel LabelInventario_nombre;
    private javax.swing.JLabel LabelInventario_precio;
    private javax.swing.JLabel LabelInventario_precio1;
    private javax.swing.JPanel PanelCotizaciones;
    private javax.swing.JPanel PanelNombre;
    private javax.swing.JPanel PanelNombre1;
    private javax.swing.JSpinner SpinnerPaginasInventario_suministro2;
    private javax.swing.JSpinner SpinnerPaginas_Clientes;
    public static javax.swing.JTextField Subtotal;
    private javax.swing.JTabbedPane TabbedPaneCliente1;
    private javax.swing.JTabbedPane TabbedPaneCliente2;
    private javax.swing.JTabbedPane TabbedPanePrincipal;
    private javax.swing.JTable TableCliente_Report;
    private rojerusan.RSTableMetro TableInventario_categoria;
    private rojerusan.RSTableMetro TableInventario_platillos;
    private javax.swing.JTable Table_Clientes;
    public static rojerusan.RSTableMetro Table_Usuarios;
    private javax.swing.JTextField TextFieldCliente_Apellido;
    private javax.swing.JTextField TextFieldCliente_Direccion;
    private javax.swing.JTextField TextFieldCliente_Email;
    private javax.swing.JTextField TextFieldCliente_Nid;
    private javax.swing.JTextField TextFieldCliente_Nombre;
    private javax.swing.JTextField TextFieldCliente_Telefono;
    private javax.swing.JTextField TextFieldClientes_Pagos;
    private javax.swing.JTextField TextFieldInventario_CategoriaNombre;
    private javax.swing.JTextField TextFieldInventario_categoriaDescrip;
    public static app.bolivia.swing.JCTextField TextFieldInventario_codigo;
    public static app.bolivia.swing.JCTextField TextFieldInventario_codigo1;
    private javax.swing.JLabel TextFieldInventario_nombreg;
    private app.bolivia.swing.JCTextField TextFieldInventario_nombreg1;
    private app.bolivia.swing.JCTextField TextFieldInventario_precio;
    private app.bolivia.swing.JCTextField TextFieldInventario_stock;
    public static rojerusan.RSMetroTextFullPlaceHolder TextFieldUsuario_Apellido;
    public static rojerusan.RSMetroTextFullPlaceHolder TextFieldUsuario_Direccion;
    public static rojerusan.RSMetroTextFullPlaceHolder TextFieldUsuario_Email;
    public static rojerusan.RSMetroTextFullPlaceHolder TextFieldUsuario_Nid;
    public static rojerusan.RSMetroTextFullPlaceHolder TextFieldUsuario_Nombre;
    public static rojerusan.RSMetroTextPassPlaceHolderView TextFieldUsuario_Password;
    public static rojerusan.RSMetroTextFullPlaceHolder TextFieldUsuario_Telefono;
    public static rojerusan.RSMetroTextFullPlaceHolder TextFieldUsuario_Usuario;
    private javax.swing.JTextField TextField_BuscarInventario;
    public static rojerusan.RSMetroTextFullPlaceHolder TextField_BuscarUsuario;
    public static app.bolivia.swing.JCTextField TotalCotizacion;
    public static app.bolivia.swing.JCTextField TotalPedidos;
    private javax.swing.JButton actualizar;
    public static javax.swing.JTextField apellidoCotizacion;
    private javax.swing.JButton borrar;
    private javax.swing.JButton borrar1;
    private javax.swing.JButton borrar2;
    private rsmaterialcomponents.RSButtonMaterialIconUno btnAbout;
    private rojerusan.RSButtonMetro btnBackup;
    public static rojerusan.RSButtonHover btnCancelar;
    private rojerusan.RSButtonMetro btnCerrar;
    private rojerusan.RSButtonMetro btnCerrar1;
    private rsmaterialcomponents.RSButtonMaterialIconUno btnConfiguracion;
    private rsmaterialcomponents.RSButtonMaterialIconUno btnContizaciones;
    private rsmaterialcomponents.RSButtonMaterialIconUno btnDasboard;
    private javax.swing.JButton btnGenerarReportePlatillos;
    private javax.swing.JButton btnGenerarReporteSuministros;
    private javax.swing.JButton btnGenerarReporteSuministrosPDF;
    private javax.swing.JButton btnGenerarReporteSuministrosPDF1;
    private javax.swing.JButton btnGenerarReporteSuministrosPDF2;
    private rsmaterialcomponents.RSButtonMaterialIconUno btnInventario;
    private rsmaterialcomponents.RSButtonMaterialIconUno btnPedidos;
    public static rojerusan.RSButtonHover btnRegistrar;
    private rsmaterialcomponents.RSButtonMaterialIconUno btnUsuarios;
    private rsmaterialcomponents.RSButtonMaterialIconUno btnVentas;
    private javax.swing.JButton buscF;
    private javax.swing.JButton busca1;
    private javax.swing.JButton busca2;
    private app.bolivia.swing.JCTextField buscar;
    private app.bolivia.swing.JCTextField buscar1;
    private app.bolivia.swing.JCTextField buscar2;
    private javax.swing.JButton calculo;
    public static app.bolivia.swing.JCTextField cambio;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton cancelar1;
    private javax.swing.JButton cancelar2;
    public static app.bolivia.swing.JCTextField codigo;
    private javax.swing.JLabel codigoL;
    private javax.swing.JLabel codigoL1;
    private javax.swing.JLabel codigoL10;
    private javax.swing.JLabel codigoL11;
    private javax.swing.JLabel codigoL12;
    private javax.swing.JLabel codigoL14;
    private javax.swing.JLabel codigoL16;
    private javax.swing.JLabel codigoL2;
    private javax.swing.JLabel codigoL3;
    private javax.swing.JLabel codigoL4;
    private javax.swing.JLabel codigoL5;
    private javax.swing.JLabel codigoL6;
    private javax.swing.JLabel codigoL7;
    private javax.swing.JLabel codigoL8;
    private javax.swing.JLabel codigoL9;
    public static javax.swing.JTextField descuento;
    public static javax.swing.JTextField dirCotizacion;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton eliminar1;
    private javax.swing.JButton eliminarT;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelInventario_platillosCodigo;
    private javax.swing.JLabel jLabelInventario_platillosCodigo1;
    private javax.swing.JLabel jLabelInventario_platillosCodigo2;
    private javax.swing.JLabel jLabelInventario_platillosNombre;
    private javax.swing.JLabel jLabelInventario_platillosNombre1;
    private javax.swing.JLabel jLabelInventario_platillosNombre2;
    private javax.swing.JLabel jLabelInventario_platillosPrecio;
    private javax.swing.JLabel jLabelInventario_platillosPrecio1;
    private javax.swing.JLabel jLabelInventario_platillosPrecio2;
    private javax.swing.JLabel jLabelInventario_platillosTipo;
    private javax.swing.JLabel jLabelInventario_platillosTipo1;
    private javax.swing.JLabel jLabelInventario_platillosTipo2;
    private javax.swing.JLabel jLabelNombreUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    public static javax.swing.JPanel jPanel19;
    public static javax.swing.JPanel jPanel1Principal;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPaneInventario1;
    private javax.swing.JTabbedPane jTabbedPaneInventario2;
    private javax.swing.JLabel labelCliente_Deuda;
    private javax.swing.JLabel labelCliente_Deuda1;
    private javax.swing.JLabel labelCliente_FechaPago;
    private javax.swing.JLabel labelCliente_Pago;
    private javax.swing.JLabel labelCliente_Pago1;
    private javax.swing.JLabel labelCliente_Ticket;
    private javax.swing.JLabel labelReport_Nombre;
    private javax.swing.JLabel labelReport_Nombre1;
    private javax.swing.JLabel labelReport_Nombre2;
    private javax.swing.JLabel labelReport_Pagos;
    private javax.swing.JButton limpiar;
    private javax.swing.JButton limpiar1;
    private javax.swing.JLabel mesa1;
    private javax.swing.JLabel mesa10;
    private javax.swing.JLabel mesa2;
    private javax.swing.JLabel mesa3;
    private javax.swing.JLabel mesa4;
    private javax.swing.JLabel mesa5;
    private javax.swing.JLabel mesa6;
    private javax.swing.JLabel mesa7;
    private javax.swing.JLabel mesa8;
    private javax.swing.JLabel mesa9;
    public static javax.swing.JTextField nidCotizacion;
    private app.bolivia.swing.JCTextField nombre;
    public static javax.swing.JTextField nombreCotizacion;
    private javax.swing.JLabel nombreL;
    private javax.swing.JLabel nombreL1;
    private javax.swing.JLabel nombreL2;
    private javax.swing.JLabel nombreL3;
    private rojerusan.RSMaterialButtonRectangle nuevoPedido;
    public static app.bolivia.swing.JCTextField numFac;
    public static app.bolivia.swing.JCTextField numFac1;
    private javax.swing.JPanel pnlConf;
    private javax.swing.JPanel pnlDasboard;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPanel pnlUsuarioDenegado;
    private javax.swing.JPanel pnlUsuarios;
    public static javax.swing.JTextField porcentaje;
    private app.bolivia.swing.JCTextField precio;
    private rsmaterialcomponents.RSButtonMaterialIconUno rSButtonMaterialIconUno2;
    private rojerusan.RSButtonMetro rSButtonMetro1;
    private rojerusan.RSButtonMetro rSButtonMetro3;
    private rojerusan.RSButtonMetro rSButtonMetro5;
    private rojerusan.RSCalendar rSCalendar1;
    private javax.swing.JLabel rSFotoSquare1;
    private rojeru_san.RSLabelFecha rSLabelFecha1;
    private rojeru_san.RSLabelFecha rSLabelFecha2;
    private rojeru_san.RSLabelFecha rSLabelFecha3;
    public static rojeru_san.RSLabelHora rSLabelHora1;
    private rojerusan.RSLabelImage rSLabelImage1;
    private rojerusan.RSLabelImage rSLabelImage2;
    private rojerusan.RSLabelImage rSLabelImage4;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle10;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle11;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle12;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle13;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle14;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle15;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle16;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle17;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle18;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle19;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle20;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle21;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle22;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle23;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle24;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle25;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle26;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle27;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle28;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle29;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle30;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle31;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle6;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle7;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle8;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle9;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    private rojerusan.RSPanelsSlider rSPanelsSlider1;
    private rojerusan.RSTableMetro rSTableMetro3;
    public static app.bolivia.swing.JCTextField recibi;
    private javax.swing.JButton registrar;
    private javax.swing.JButton registrar1;
    private rojerusan.RSMaterialButtonRectangle registrarPedido;
    public static javax.swing.JScrollPane scrollUsuarios;
    public static rojerusan.RSTableMetro tablaCotizaciones;
    public static rojerusan.RSTableMetro tablaPedidosVenta;
    public static rojeru_san.complementos.TableMetro tablaVentas;
    public static rojerusan.RSTableMetro tableMostrarPedidos;
    public static rojerusan.RSTableMetro tablePedidos;
    private org.bolivia.combo.SComboBoxBlue tipoAl;
    private javax.swing.JLabel tipoL;
    public static app.bolivia.swing.JCTextField total;
    private javax.swing.JLabel txtIdVenta;
    private javax.swing.JButton vender;
    private javax.swing.JButton ventasH;
    private javax.swing.JButton ventasH1;
    private rojerusan.RSTableMetro xd;
    // End of variables declaration//GEN-END:variables

    private void GeneraBackup() {
        WarningBackup a = new WarningBackup(this, true);
        a.setVisible(true);

        if (a.txtNombre.getText().length() != 0) {
            new BackupMySQL().exportDB(a.txtNombre.getText());
        }

    }

    public static File existe = null;
    private Conexion conexion = Conexion.createInstance();

    private void RestoreBackup() {
        RSFileChooser fileChooser = new RSFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("Respaldos/"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos SQL (*.sql)", "sql");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("SELECCIONAR RESPALDO");
        if (fileChooser.showOpenDialog(this) == RSFileChooser.APPROVE_OPTION) {
            existe = fileChooser.getSelectedFile();
            if (existe.exists()) {

                WarningRestore a = new WarningRestore(this, true);
                a.msj1.setText("Has seleccionado un respaldo y la aplicación");
                a.msj2.setText("se reiniciara al terminar de restaurar la");
                a.msj3.setText("Base de Datos. Se recomienda que haga");
                a.msj4.setText("un respaldo antes de continuar.");
                a.lblTipo.setText("Restaurar");
                a.lblTipo.setVisible(false);
                a.setVisible(true);

                if (a.continuar) {
                    // new CargandoRestore(this, true).setVisible(true);
                    this.dispose();
                    Splash splash = new Splash();
                    splash.setVisible(true);
                }

            } else {
                AlertError a = new AlertError(this, true);
                a.Texto("Archivo no encontrado.");
                a.setVisible(true);
            }
        }
//        new conexion.getConnection();
    }

}
