/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controller.AlimentosVM;
import Controller.CategoriaVM;
import Library.Objectos;
import Controller.ClientesVM;
import Controller.SuministroVM;
import Reportes.Excel;
import app.bolivia.swing.JCTextField;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import rojerusan.RSNotifyFade;

/**
 *
 * @author Gustavo
 */
public class Sistema extends javax.swing.JFrame {

    /**
     * Creates new form Sistema
     */
    private int idCliente = 0;

    public Sistema() {

        initComponents();
        JTextField categoria = new JTextField();
        categoria.setText("");
        TabbedPanePrincipal.setSelectedIndex(4);
        //rsscalelabel.RSScaleLabel.setScaleLabel(jLabel2, "src/Resources/logo.png");
        //rsscalelabel.RSScaleLabel.setScaleLabel(jLabel6, "src/Resources/logo.png");
        //   TextField_BuscarVentas.setEditable(false);

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

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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
        rSTableMetro3 = new rojerusan.RSTableMetro();
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanelNuevaCotizacion = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        LabelImage_Cliente1 = new javax.swing.JLabel();
        Label_Anticipo = new javax.swing.JLabel();
        AnticipoCotizacion = new javax.swing.JTextField();
        Label_Cliente_Nombre = new javax.swing.JLabel();
        NombreClienteCotizacion = new javax.swing.JTextField();
        Label_fechaEntrega = new javax.swing.JLabel();
        FechaEntregaCotizacion = new javax.swing.JTextField();
        Lable_Telefono = new javax.swing.JLabel();
        TelefonoClienteCotizaciones = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        PanelModificarCotizacion = new javax.swing.JPanel();
        PanelBuscarCotizacion = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TextField_BuscarCliente4 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        busca = new javax.swing.JButton();
        rSLabelFecha1 = new rojeru_san.RSLabelFecha();
        codigoL5 = new javax.swing.JLabel();
        recibi = new app.bolivia.swing.JCTextField();
        codigoL6 = new javax.swing.JLabel();
        cambio = new app.bolivia.swing.JCTextField();
        codigoL7 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        numFac = new app.bolivia.swing.JCTextField();
        codigoL4 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        calculo = new javax.swing.JButton();
        vender = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        rSTableMetro1 = new rojerusan.RSTableMetro();
        total = new app.bolivia.swing.JCTextField();
        codigoL3 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        rSMaterialButtonRectangle12 = new rojerusan.RSMaterialButtonRectangle();
        jPanel31 = new javax.swing.JPanel();
        PanelNombre1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel32 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        BtnVentas = new javax.swing.JButton();
        ButtonCliente = new javax.swing.JButton();
        ButtonInventario = new javax.swing.JButton();
        ButtonCotizacion = new javax.swing.JButton();
        ButtonAdministracion = new javax.swing.JButton();
        ButtonClienteConfig = new javax.swing.JButton();
        ButtonClienteConfig1 = new javax.swing.JButton();
        rSLabelHora1 = new rojeru_san.RSLabelHora();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(34, 102, 145));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Cooper Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema punto de ventas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabbedPanePrincipal.setBackground(new java.awt.Color(255, 255, 255));
        TabbedPanePrincipal.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

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
        buscar1.setBorder(null);
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

        CheckBoxCliente_Credito.setText("Credito");

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1700, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1680, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
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
                                .addComponent(SpinnerPaginas_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(246, 246, 246)
                                .addComponent(ButtonCliente_Paginas1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonCliente_Paginas2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonCliente_Paginas3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonCliente_Paginas4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(LabelCliente_Nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(272, 272, 272)
                                .addComponent(LabelCliente_Paginas, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabbedPaneCliente2, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(LabelCliente_Nombre1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SpinnerPaginas_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(LabelCliente_Paginas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonCliente_Paginas2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonCliente_Paginas1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonCliente_Paginas3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonCliente_Paginas4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
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
        btnGenerarReporteSuministros.setBorder(null);
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
        btnGenerarReporteSuministrosPDF.setBorder(null);
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

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(btnGenerarReporteSuministros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(btnGenerarReporteSuministrosPDF)
                .addGap(63, 63, 63))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(240, Short.MAX_VALUE)
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
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(rSMaterialButtonRectangle6, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rSMaterialButtonRectangle7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        TextFieldInventario_codigo.setBorder(null);
        TextFieldInventario_codigo.setForeground(new java.awt.Color(255, 255, 255));
        TextFieldInventario_codigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextFieldInventario_codigo.setOpaque(false);
        TextFieldInventario_codigo.setPhColor(new java.awt.Color(255, 255, 255));
        TextFieldInventario_codigo.setPlaceholder("CÓDIGO");
        jPanel30.add(TextFieldInventario_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 180, -1));

        codigoL8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/codigoL.png"))); // NOI18N
        jPanel30.add(codigoL8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 250, 60));

        TextFieldInventario_precio.setBackground(new java.awt.Color(34, 102, 145));
        TextFieldInventario_precio.setBorder(null);
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
        TextFieldInventario_nombreg1.setBorder(null);
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
        jPanel30.add(TextFieldInventario_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 162, 240, 40));

        nombreL3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/precioL.png"))); // NOI18N
        jPanel30.add(nombreL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 243, 52));

        ComboBoxSuministro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CATEGORIA", "PERECEDEROS", "NO PERECEDEROS" }));
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
                .addGap(37, 37, 37)
                .addComponent(rSMaterialButtonRectangle8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSMaterialButtonRectangle9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
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
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(labelReport_Nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LabelInventario_CategoriaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LabelInventario_CategoriaDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TextFieldInventario_CategoriaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rSMaterialButtonRectangle10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextFieldInventario_categoriaDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(rSMaterialButtonRectangle11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelReport_Nombre2)
                .addGap(28, 28, 28)
                .addComponent(LabelInventario_CategoriaNombre)
                .addGap(29, 29, 29)
                .addComponent(TextFieldInventario_CategoriaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabelInventario_CategoriaDescrip)
                .addGap(18, 18, 18)
                .addComponent(TextFieldInventario_categoriaDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMaterialButtonRectangle10, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
        );

        jTabbedPaneInventario1.addTab("Categoria", jPanel23);

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "REGISTRO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        codigo.setEditable(false);
        codigo.setBackground(new java.awt.Color(34, 102, 145));
        codigo.setBorder(null);
        codigo.setForeground(new java.awt.Color(255, 255, 255));
        codigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        codigo.setOpaque(false);
        codigo.setPhColor(new java.awt.Color(255, 255, 255));
        codigo.setPlaceholder("CÓDIGO");
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
        nombre.setBorder(null);
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
        precio.setBorder(null);
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
        jPanel41.add(jLabelInventario_platillosCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 80, 40));
        jPanel41.add(jLabelInventario_platillosNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 90, 40));
        jPanel41.add(jLabelInventario_platillosPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 90, 50));
        jPanel41.add(jLabelInventario_platillosTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 80, 50));

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));
        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "OPCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        registrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/regis1.png"))); // NOI18N
        registrar.setText("Registrar");
        registrar.setBorder(null);
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
        actualizar.setBorder(null);
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
        eliminar.setBorder(null);
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
        limpiar.setText("Limpiar Campos");
        limpiar.setBorder(null);
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
                .addContainerGap()
                .addComponent(registrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(actualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(limpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(limpiar)
                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(registrar)
                        .addComponent(actualizar)))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel35Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addContainerGap(311, Short.MAX_VALUE)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel35Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(132, Short.MAX_VALUE)))
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1662, Short.MAX_VALUE)
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1662, Short.MAX_VALUE)
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
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1662, Short.MAX_VALUE)
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
        buscar.setBorder(null);
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
        btnGenerarReportePlatillos.setBorder(null);
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1662, Short.MAX_VALUE))
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
                        .addGap(11, 11, 11)
                        .addComponent(btnGenerarReportePlatillos, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(jTabbedPaneInventario1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPaneInventario2)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(LabelCliente_Nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(272, 272, 272)
                                        .addComponent(LabelInventarioSuministro_Paginas2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(SpinnerPaginasInventario_suministro2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(243, 243, 243)
                                        .addComponent(ButtonCliente_Paginas5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ButtonCliente_Paginas6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ButtonCliente_Paginas7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ButtonCliente_Paginas8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
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

        javax.swing.GroupLayout PanelNombreLayout = new javax.swing.GroupLayout(PanelNombre);
        PanelNombre.setLayout(PanelNombreLayout);
        PanelNombreLayout.setHorizontalGroup(
            PanelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNombreLayout.createSequentialGroup()
                .addGap(437, 437, 437)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelNombreLayout.setVerticalGroup(
            PanelNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNombreLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        jPanel47.setBackground(new java.awt.Color(255, 255, 255));
        jPanel47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel48.setBackground(new java.awt.Color(255, 255, 255));
        jPanel48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelImage_Cliente1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelImage_Cliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/login.png"))); // NOI18N
        LabelImage_Cliente1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LabelImage_Cliente1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LabelImage_Cliente1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelImage_Cliente1MouseClicked(evt);
            }
        });
        jPanel48.add(LabelImage_Cliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, 114));

        Label_Anticipo.setBackground(new java.awt.Color(70, 106, 124));
        Label_Anticipo.setText("Anticipo");

        AnticipoCotizacion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        AnticipoCotizacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AnticipoCotizacionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AnticipoCotizacionKeyTyped(evt);
            }
        });

        Label_Cliente_Nombre.setBackground(new java.awt.Color(70, 106, 124));
        Label_Cliente_Nombre.setText("Nombre");

        NombreClienteCotizacion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        NombreClienteCotizacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NombreClienteCotizacionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NombreClienteCotizacionKeyTyped(evt);
            }
        });

        Label_fechaEntrega.setBackground(new java.awt.Color(70, 106, 124));
        Label_fechaEntrega.setText("Fecha de Entrega");

        FechaEntregaCotizacion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        FechaEntregaCotizacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FechaEntregaCotizacionKeyReleased(evt);
            }
        });

        Lable_Telefono.setBackground(new java.awt.Color(70, 106, 124));
        Lable_Telefono.setText("Telefono");

        TelefonoClienteCotizaciones.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        TelefonoClienteCotizaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TelefonoClienteCotizacionesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TelefonoClienteCotizacionesKeyTyped(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel47Layout.createSequentialGroup()
                                .addComponent(NombreClienteCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TelefonoClienteCotizaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel47Layout.createSequentialGroup()
                                .addComponent(Label_Cliente_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Lable_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 32, Short.MAX_VALUE))
                            .addGroup(jPanel47Layout.createSequentialGroup()
                                .addComponent(Label_fechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Label_Anticipo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(FechaEntregaCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AnticipoCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Cliente_Nombre)
                    .addComponent(Lable_Telefono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreClienteCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TelefonoClienteCotizaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_fechaEntrega)
                    .addComponent(Label_Anticipo))
                .addGap(1, 1, 1)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FechaEntregaCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnticipoCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelNuevaCotizacionLayout = new javax.swing.GroupLayout(PanelNuevaCotizacion);
        PanelNuevaCotizacion.setLayout(PanelNuevaCotizacionLayout);
        PanelNuevaCotizacionLayout.setHorizontalGroup(
            PanelNuevaCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelNuevaCotizacionLayout.setVerticalGroup(
            PanelNuevaCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNuevaCotizacionLayout.createSequentialGroup()
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nueva cotizacion ", PanelNuevaCotizacion);

        javax.swing.GroupLayout PanelModificarCotizacionLayout = new javax.swing.GroupLayout(PanelModificarCotizacion);
        PanelModificarCotizacion.setLayout(PanelModificarCotizacionLayout);
        PanelModificarCotizacionLayout.setHorizontalGroup(
            PanelModificarCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        PanelModificarCotizacionLayout.setVerticalGroup(
            PanelModificarCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Modificar Cotizacion ", PanelModificarCotizacion);

        javax.swing.GroupLayout PanelBuscarCotizacionLayout = new javax.swing.GroupLayout(PanelBuscarCotizacion);
        PanelBuscarCotizacion.setLayout(PanelBuscarCotizacionLayout);
        PanelBuscarCotizacionLayout.setHorizontalGroup(
            PanelBuscarCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        PanelBuscarCotizacionLayout.setVerticalGroup(
            PanelBuscarCotizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Buscar Cotizacion ", PanelBuscarCotizacion);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1681, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Nueva cotizacion ", jPanel18);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1681, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Modificar Cotizacion ", jPanel19);

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1681, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
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
                    .addGroup(PanelCotizacionesLayout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane2)))
                .addContainerGap())
        );
        PanelCotizacionesLayout.setVerticalGroup(
            PanelCotizacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCotizacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCotizacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );

        TabbedPanePrincipal.addTab("Cotizaciones", PanelCotizaciones);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel21.setBackground(new java.awt.Color(34, 102, 145));
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Administración Financiera");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Buscar");

        TextField_BuscarCliente4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(289, 289, 289)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextField_BuscarCliente4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1205, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(TextField_BuscarCliente4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(493, Short.MAX_VALUE))
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
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        busca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        busca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/alimento2.png"))); // NOI18N
        busca.setBorder(null);
        busca.setContentAreaFilled(false);
        busca.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        busca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        busca.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        busca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaActionPerformed(evt);
            }
        });
        jPanel37.add(busca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, -1));

        rSLabelFecha1.setForeground(new java.awt.Color(255, 255, 255));
        rSLabelFecha1.setToolTipText("");
        rSLabelFecha1.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 24)); // NOI18N
        jPanel37.add(rSLabelFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 180, 33));

        codigoL5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/fecha.png"))); // NOI18N
        jPanel37.add(codigoL5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 250, 50));

        recibi.setBackground(new java.awt.Color(34, 102, 145));
        recibi.setBorder(null);
        recibi.setForeground(new java.awt.Color(255, 255, 255));
        recibi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        recibi.setOpaque(false);
        recibi.setPhColor(new java.awt.Color(255, 255, 255));
        recibi.setPlaceholder("RECIBI");
        jPanel37.add(recibi, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 130, -1));

        codigoL6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/recibi.png"))); // NOI18N
        codigoL6.setToolTipText("RECIBI");
        jPanel37.add(codigoL6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 195, 52));

        cambio.setEditable(false);
        cambio.setBackground(new java.awt.Color(34, 102, 145));
        cambio.setBorder(null);
        cambio.setForeground(new java.awt.Color(255, 255, 255));
        cambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cambio.setOpaque(false);
        cambio.setPhColor(new java.awt.Color(255, 255, 255));
        cambio.setPlaceholder("CAMBIO");
        jPanel37.add(cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 130, -1));

        codigoL7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cambio.png"))); // NOI18N
        codigoL7.setToolTipText("CAMBIO");
        jPanel37.add(codigoL7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 195, 52));

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("NÚMERO DE VENTA");
        jPanel38.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, -1));

        numFac.setEditable(false);
        numFac.setBackground(new java.awt.Color(34, 102, 145));
        numFac.setBorder(null);
        numFac.setForeground(new java.awt.Color(255, 255, 255));
        numFac.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numFac.setOpaque(false);
        numFac.setPhColor(new java.awt.Color(255, 255, 255));
        numFac.setPlaceholder("FACTURA");
        jPanel38.add(numFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 130, 30));

        codigoL4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/numFac.png"))); // NOI18N
        jPanel38.add(codigoL4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, 50));

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "OPCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel39.setToolTipText("");
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        calculo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        calculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/calculo2.png"))); // NOI18N
        calculo.setBorder(null);
        calculo.setContentAreaFilled(false);
        calculo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        calculo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        calculo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        calculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculoActionPerformed(evt);
            }
        });
        jPanel39.add(calculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, 50));

        vender.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/venta2.png"))); // NOI18N
        vender.setBorder(null);
        vender.setContentAreaFilled(false);
        vender.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        vender.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vender.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        vender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venderActionPerformed(evt);
            }
        });
        jPanel39.add(vender, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 200, 50));

        borrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/elimina2.png"))); // NOI18N
        borrar.setBorder(null);
        borrar.setContentAreaFilled(false);
        borrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        borrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        borrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        jPanel39.add(borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 190, 60));

        cancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/cancela2.png"))); // NOI18N
        cancelar.setBorder(null);
        cancelar.setContentAreaFilled(false);
        cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel39.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 190, 50));

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(rSTableMetro1);

        jPanel40.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 870, 280));

        total.setBackground(new java.awt.Color(34, 102, 145));
        total.setBorder(null);
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
        jPanel40.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 310, 80, 30));

        codigoL3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/total.png"))); // NOI18N
        jPanel40.add(codigoL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, -1, 50));

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));
        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("GENERAR PEDIDO");

        rSMaterialButtonRectangle12.setBackground(new java.awt.Color(34, 102, 145));
        rSMaterialButtonRectangle12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Agregar.png"))); // NOI18N
        rSMaterialButtonRectangle12.setText("INGRESAR PEDIDO");
        rSMaterialButtonRectangle12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel16))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(rSMaterialButtonRectangle12, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSMaterialButtonRectangle12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
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
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, 1198, Short.MAX_VALUE)
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
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(700, 700, 700)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelNombre1Layout.setVerticalGroup(
            PanelNombre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNombre1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2093, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Mesas", jPanel32);

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2121, Short.MAX_VALUE)
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Pedidos", jPanel46);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelNombre1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane3))
                .addContainerGap())
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

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BtnVentas.setBackground(new java.awt.Color(51, 51, 51));
        BtnVentas.setForeground(new java.awt.Color(255, 255, 255));
        BtnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/shopping_cart.png"))); // NOI18N
        BtnVentas.setText("Ventas");
        BtnVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVentasActionPerformed(evt);
            }
        });

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

        ButtonAdministracion.setBackground(new java.awt.Color(51, 51, 51));
        ButtonAdministracion.setForeground(new java.awt.Color(255, 255, 255));
        ButtonAdministracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Reporte.png"))); // NOI18N
        ButtonAdministracion.setText("Administracion Financiera");
        ButtonAdministracion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonAdministracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAdministracionActionPerformed(evt);
            }
        });

        ButtonClienteConfig.setBackground(new java.awt.Color(51, 51, 51));
        ButtonClienteConfig.setForeground(new java.awt.Color(255, 255, 255));
        ButtonClienteConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Settings.png"))); // NOI18N
        ButtonClienteConfig.setText("Pedido");
        ButtonClienteConfig.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonClienteConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonClienteConfigActionPerformed(evt);
            }
        });

        ButtonClienteConfig1.setBackground(new java.awt.Color(51, 51, 51));
        ButtonClienteConfig1.setForeground(new java.awt.Color(255, 255, 255));
        ButtonClienteConfig1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/about.png"))); // NOI18N
        ButtonClienteConfig1.setText("About");
        ButtonClienteConfig1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonClienteConfig1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonClienteConfig1ActionPerformed(evt);
            }
        });

        rSLabelHora1.setForeground(new java.awt.Color(0, 52, 102));
        rSLabelHora1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonAdministracion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonClienteConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonClienteConfig1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnVentas)
                        .addComponent(ButtonCliente)
                        .addComponent(ButtonInventario)
                        .addComponent(ButtonCotizacion)
                        .addComponent(ButtonAdministracion)
                        .addComponent(ButtonClienteConfig)
                        .addComponent(ButtonClienteConfig1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TabbedPanePrincipal)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabbedPanePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="CODIGO DE CLIENTE">
    private ClientesVM cliente;
    private void ButtonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonClienteActionPerformed
        TabbedPanePrincipal.setSelectedIndex(0);
        BtnVentas.setEnabled(true);
        ButtonCliente.setEnabled(false);
        ButtonInventario.setEnabled(true);
        ButtonCotizacion.setEnabled(true);
        ButtonAdministracion.setEnabled(true);
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
            TableCliente_Report
        };
        cliente = new ClientesVM(objects, label, textField);

    }//GEN-LAST:event_ButtonClienteActionPerformed

    private void BtnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVentasActionPerformed
        TabbedPanePrincipal.setSelectedIndex(4);
        BtnVentas.setEnabled(false);
        ButtonCliente.setEnabled(true);
        ButtonInventario.setEnabled(true);
        ButtonCotizacion.setEnabled(true);
        ButtonAdministracion.setEnabled(true);
        ButtonClienteConfig.setEnabled(true);

    }//GEN-LAST:event_BtnVentasActionPerformed
    private SuministroVM suministro;
    private CategoriaVM categoria;
    private AlimentosVM alimento;

    private void ButtonInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonInventarioActionPerformed

        TabbedPanePrincipal.setSelectedIndex(1);
        BtnVentas.setEnabled(true);
        ButtonCliente.setEnabled(true);
        ButtonInventario.setEnabled(false);
        ButtonCotizacion.setEnabled(true);
        ButtonAdministracion.setEnabled(true);
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
        suministro = new SuministroVM(objects1, label, textField);

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
            SpinnerPaginasInventario_suministro2
        };
        categoria = new CategoriaVM(objects2, label2, textField2);

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
            tipoAl
        };
        alimento = new AlimentosVM(objects3, label3, JCtextField);
    }//GEN-LAST:event_ButtonInventarioActionPerformed

    private void ButtonCotizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCotizacionActionPerformed
        TabbedPanePrincipal.setSelectedIndex(2);
        BtnVentas.setEnabled(true);
        ButtonCliente.setEnabled(true);
        ButtonInventario.setEnabled(true);
        ButtonCotizacion.setEnabled(false);
        ButtonAdministracion.setEnabled(true);
        ButtonClienteConfig.setEnabled(true);
    }//GEN-LAST:event_ButtonCotizacionActionPerformed

    private void ButtonAdministracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAdministracionActionPerformed
        TabbedPanePrincipal.setSelectedIndex(3);
        BtnVentas.setEnabled(true);
        ButtonCliente.setEnabled(true);
        ButtonInventario.setEnabled(true);
        ButtonCotizacion.setEnabled(true);
        ButtonAdministracion.setEnabled(false);
        ButtonClienteConfig.setEnabled(true);
    }//GEN-LAST:event_ButtonAdministracionActionPerformed

    private void ButtonClienteConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonClienteConfigActionPerformed
        BtnVentas.setEnabled(true);
        ButtonCliente.setEnabled(true);
        ButtonInventario.setEnabled(true);
        ButtonCotizacion.setEnabled(true);
        ButtonAdministracion.setEnabled(true);
        ButtonClienteConfig.setEnabled(false);
        TabbedPanePrincipal.setSelectedIndex(5);
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
                    System.out.println("xd");
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

    private void ButtonClienteConfig1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonClienteConfig1ActionPerformed
        new about.About(this, "", true).setVisible(true);
    }//GEN-LAST:event_ButtonClienteConfig1ActionPerformed

    private void ButtonCliente_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCliente_AgregarActionPerformed
        cliente.RegistrarCliente();

        if (cliente.getInsert()) {
            alertas.AlertSuccess alerta = new alertas.AlertSuccess(this, true);
            alerta.Texto("Se ha registrado Correctamente");
            alerta.setVisible(true);
            cliente.setInsert(false);
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
            suministro.restablecer();
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

    private void SpinnerPaginasInventario_suministro2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinnerPaginasInventario_suministro2StateChanged
        suministro.Registro_PaginasInventario();


    }//GEN-LAST:event_SpinnerPaginasInventario_suministro2StateChanged

    private void ButtonCliente_Paginas5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCliente_Paginas5ActionPerformed
        suministro.Paginador("Primero");

    }//GEN-LAST:event_ButtonCliente_Paginas5ActionPerformed

    private void ButtonCliente_Paginas6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCliente_Paginas6ActionPerformed
        suministro.Paginador("Anterior");
    }//GEN-LAST:event_ButtonCliente_Paginas6ActionPerformed

    private void ButtonCliente_Paginas7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCliente_Paginas7ActionPerformed
        suministro.Paginador("Siguiente");
    }//GEN-LAST:event_ButtonCliente_Paginas7ActionPerformed

    private void ButtonCliente_Paginas8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCliente_Paginas8ActionPerformed
        suministro.Paginador("Ultimo");
    }//GEN-LAST:event_ButtonCliente_Paginas8ActionPerformed

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
    ListaAlimentosAd la;
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
        alimento.RegistrarSuministro();
        alimento.extraerID();

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
        alimento.extraerID();
        idCliente = 0;
        buscar.setText("");
    }//GEN-LAST:event_limpiarActionPerformed

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked
        // alimento.restablecer();
    }//GEN-LAST:event_buscarMouseClicked

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
        buscar.setText(buscar.getText().toUpperCase());
        alimento.SearchClientes(buscar.getText());
        System.out.println("entro buscar");
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

    private void LabelImage_Cliente1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelImage_Cliente1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LabelImage_Cliente1MouseClicked

    private void AnticipoCotizacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AnticipoCotizacionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_AnticipoCotizacionKeyReleased

    private void AnticipoCotizacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AnticipoCotizacionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_AnticipoCotizacionKeyTyped

    private void NombreClienteCotizacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreClienteCotizacionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreClienteCotizacionKeyReleased

    private void NombreClienteCotizacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreClienteCotizacionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreClienteCotizacionKeyTyped

    private void FechaEntregaCotizacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FechaEntregaCotizacionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaEntregaCotizacionKeyReleased

    private void TelefonoClienteCotizacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelefonoClienteCotizacionesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TelefonoClienteCotizacionesKeyReleased

    private void TelefonoClienteCotizacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelefonoClienteCotizacionesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TelefonoClienteCotizacionesKeyTyped

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void TextFieldInventario_nombreg1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldInventario_nombreg1KeyReleased
        nombre.setText(nombre.getText().toUpperCase());
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

    }//GEN-LAST:event_cancelarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed

    }//GEN-LAST:event_borrarActionPerformed

    private void venderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderActionPerformed

    }//GEN-LAST:event_venderActionPerformed

    private void calculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculoActionPerformed
     if (recibi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese un valor.", "Caja de cobro", 0);
        } else {
            double recibe = Double.parseDouble(recibi.getText());
            double tota = Double.parseDouble(total.getText());

            if (recibe < tota) {
                JOptionPane.showMessageDialog(this, "Ingrese un valor valido.", "Caja de cobro",0);
            } else {
                this.cambio.setText(String.valueOf(recibe - tota));
            }
        }
    }//GEN-LAST:event_calculoActionPerformed

    private void buscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaActionPerformed
        la = new ListaAlimentosAd();

        la.toFront();
        la.setVisible(true);
    }//GEN-LAST:event_buscaActionPerformed

    private void rSMaterialButtonRectangle12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle12ActionPerformed

        TabbedPanePrincipal.setSelectedIndex(5);
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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarReporteSuministrosPDFActionPerformed

    private void ButtonCliente_Agregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCliente_Agregar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonCliente_Agregar1ActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

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
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Sistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AnticipoCotizacion;
    private javax.swing.JButton BtnVentas;
    private javax.swing.JButton ButtonAdministracion;
    private javax.swing.JButton ButtonCliente;
    private javax.swing.JButton ButtonClienteConfig;
    private javax.swing.JButton ButtonClienteConfig1;
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
    private org.bolivia.combo.SComboBoxBlue ComboBoxSuministro;
    private javax.swing.JTextField FechaEntregaCotizacion;
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
    private javax.swing.JLabel LabelImage_Cliente1;
    private javax.swing.JLabel LabelInventarioSuministro_Paginas2;
    private javax.swing.JLabel LabelInventario_CategoriaDescrip;
    private javax.swing.JLabel LabelInventario_CategoriaNombre;
    private javax.swing.JLabel LabelInventario_codigo;
    private javax.swing.JLabel LabelInventario_nombre;
    private javax.swing.JLabel LabelInventario_precio;
    private javax.swing.JLabel LabelInventario_precio1;
    private javax.swing.JLabel Label_Anticipo;
    private javax.swing.JLabel Label_Cliente_Nombre;
    private javax.swing.JLabel Label_fechaEntrega;
    private javax.swing.JLabel Lable_Telefono;
    private javax.swing.JTextField NombreClienteCotizacion;
    private javax.swing.JPanel PanelBuscarCotizacion;
    private javax.swing.JPanel PanelCotizaciones;
    private javax.swing.JPanel PanelModificarCotizacion;
    private javax.swing.JPanel PanelNombre;
    private javax.swing.JPanel PanelNombre1;
    private javax.swing.JPanel PanelNuevaCotizacion;
    private javax.swing.JSpinner SpinnerPaginasInventario_suministro2;
    private javax.swing.JSpinner SpinnerPaginas_Clientes;
    private javax.swing.JTabbedPane TabbedPaneCliente1;
    private javax.swing.JTabbedPane TabbedPaneCliente2;
    private javax.swing.JTabbedPane TabbedPanePrincipal;
    private javax.swing.JTable TableCliente_Report;
    private rojerusan.RSTableMetro TableInventario_categoria;
    private rojerusan.RSTableMetro TableInventario_platillos;
    private javax.swing.JTable Table_Clientes;
    private javax.swing.JTextField TelefonoClienteCotizaciones;
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
    private javax.swing.JLabel TextFieldInventario_nombreg;
    private app.bolivia.swing.JCTextField TextFieldInventario_nombreg1;
    private app.bolivia.swing.JCTextField TextFieldInventario_precio;
    private app.bolivia.swing.JCTextField TextFieldInventario_stock;
    private javax.swing.JTextField TextField_BuscarCliente4;
    private javax.swing.JTextField TextField_BuscarInventario;
    private javax.swing.JButton actualizar;
    private javax.swing.JButton borrar;
    private javax.swing.JButton btnGenerarReportePlatillos;
    private javax.swing.JButton btnGenerarReporteSuministros;
    private javax.swing.JButton btnGenerarReporteSuministrosPDF;
    private javax.swing.JButton busca;
    private app.bolivia.swing.JCTextField buscar;
    private app.bolivia.swing.JCTextField buscar1;
    private javax.swing.JButton calculo;
    public static app.bolivia.swing.JCTextField cambio;
    private javax.swing.JButton cancelar;
    public static app.bolivia.swing.JCTextField codigo;
    private javax.swing.JLabel codigoL;
    private javax.swing.JLabel codigoL1;
    private javax.swing.JLabel codigoL2;
    private javax.swing.JLabel codigoL3;
    private javax.swing.JLabel codigoL4;
    private javax.swing.JLabel codigoL5;
    private javax.swing.JLabel codigoL6;
    private javax.swing.JLabel codigoL7;
    private javax.swing.JLabel codigoL8;
    private javax.swing.JButton eliminar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelInventario_platillosCodigo;
    private javax.swing.JLabel jLabelInventario_platillosNombre;
    private javax.swing.JLabel jLabelInventario_platillosPrecio;
    private javax.swing.JLabel jLabelInventario_platillosTipo;
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
    private javax.swing.JPanel jPanel19;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
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
    private app.bolivia.swing.JCTextField nombre;
    private javax.swing.JLabel nombreL;
    private javax.swing.JLabel nombreL1;
    private javax.swing.JLabel nombreL2;
    private javax.swing.JLabel nombreL3;
    public static app.bolivia.swing.JCTextField numFac;
    private app.bolivia.swing.JCTextField precio;
    private rojeru_san.RSLabelFecha rSLabelFecha1;
    private rojeru_san.RSLabelHora rSLabelHora1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle10;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle11;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle12;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle6;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle7;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle8;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle9;
    private rojerusan.RSTableMetro rSTableMetro1;
    private rojerusan.RSTableMetro rSTableMetro3;
    public static app.bolivia.swing.JCTextField recibi;
    private javax.swing.JButton registrar;
    private org.bolivia.combo.SComboBoxBlue tipoAl;
    private javax.swing.JLabel tipoL;
    public static app.bolivia.swing.JCTextField total;
    private javax.swing.JButton vender;
    private rojerusan.RSTableMetro xd;
    // End of variables declaration//GEN-END:variables
}
