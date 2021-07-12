/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controller.ListarClientesMV;
import static Views.ListaAlimentos.isNumber;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elmer
 */
public class ListarClientes extends javax.swing.JFrame {

    /**
     * Creates new form ListarClientes
     */
    private boolean identificador;

    public boolean getIdentificador() {
        return identificador;
    }

    public void setIdentificador(boolean identificador) {
        this.identificador = identificador;
    }
    public static String telefono;

    public ListarClientes() {
        initComponents();
        mostrar();
    }

    private ListarClientesMV clientes;

    public void mostrar() {
        clientes = new ListarClientesMV(TablaListadoClientes);
    }

    private void IngresarClienteCotizaciones() {
        if (TablaListadoClientes.getRowCount() > 0) {
            try {

                DefaultTableModel tabladet = (DefaultTableModel) Views.Sistema.tablePedidos.getModel();

                String[] dato = new String[6];

                int fila = TablaListadoClientes.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione un registro.");
                } else {
                    String nid = TablaListadoClientes.getValueAt(fila, 1).toString();
                    String nombre = TablaListadoClientes.getValueAt(fila, 2).toString();
                    String apellido = TablaListadoClientes.getValueAt(fila, 3).toString();
                    String email = TablaListadoClientes.getValueAt(fila, 4).toString();
                    String direccion = TablaListadoClientes.getValueAt(fila, 5).toString();
                    telefono = TablaListadoClientes.getValueAt(fila, 6).toString();

                    Views.Sistema.nidCotizacion.setText(nid);
                    Views.Sistema.nombreCotizacion.setText(nombre);
                    Views.Sistema.apellidoCotizacion.setText(apellido);
                    Views.Sistema.dirCotizacion.setText(direccion);
                }
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay registros.", "Alimentos", 0,
                    new ImageIcon(getClass().getResource("/Resources/info.png")));
        }
    }

    public static String nidCliente = "";
    public static String nombreClienteVenta;
    public static String apellidoCliente;
    public static String emailCliente;
    public static String direccionCliente;
    public static String telefonoCliente;

    private void IngresarClienteVenta() {
        if (TablaListadoClientes.getRowCount() > 0) {
            try {

                DefaultTableModel tabladet = (DefaultTableModel) Views.Sistema.tablePedidos.getModel();

                String[] dato = new String[6];

                int fila = TablaListadoClientes.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione un registro.");
                } else {
                    nidCliente = TablaListadoClientes.getValueAt(fila, 1).toString();
                    nombreClienteVenta = TablaListadoClientes.getValueAt(fila, 2).toString();
                    apellidoCliente = TablaListadoClientes.getValueAt(fila, 3).toString();
                    emailCliente = TablaListadoClientes.getValueAt(fila, 4).toString();
                    direccionCliente = TablaListadoClientes.getValueAt(fila, 5).toString();
                    telefonoCliente = TablaListadoClientes.getValueAt(fila, 6).toString();
                }
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay registros.", "Alimentos", 0,
                    new ImageIcon(getClass().getResource("/Resources/info.png")));
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaListadoClientes = TablaListadoClientes = new rojerusan.RSTableMetro(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jPanel4 = new javax.swing.JPanel();
        JtextBuscar = new app.bolivia.swing.JCTextField();
        codigoL1 = new javax.swing.JLabel();
        enviar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TablaListadoClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(TablaListadoClientes);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "OPCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JtextBuscar.setBackground(new java.awt.Color(34, 102, 145));
        JtextBuscar.setBorder(null);
        JtextBuscar.setForeground(new java.awt.Color(255, 255, 255));
        JtextBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JtextBuscar.setOpaque(false);
        JtextBuscar.setPhColor(new java.awt.Color(255, 255, 255));
        JtextBuscar.setPlaceholder("CÓDIGO/NOMBRE");
        JtextBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtextBuscarMouseClicked(evt);
            }
        });
        JtextBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtextBuscarKeyReleased(evt);
            }
        });
        jPanel4.add(JtextBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 180, -1));

        codigoL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        codigoL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buscarL.png"))); // NOI18N
        jPanel4.add(codigoL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 250, 52));

        enviar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        enviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/registro1.png"))); // NOI18N
        enviar.setText("Agregar Cliente");
        enviar.setToolTipText("");
        enviar.setBorder(null);
        enviar.setBorderPainted(false);
        enviar.setContentAreaFilled(false);
        enviar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        enviar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        enviar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/registro2.png"))); // NOI18N
        enviar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });
        jPanel4.add(enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 120, 100));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("LISTADO DE CLIENTES");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 200, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JtextBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtextBuscarMouseClicked

    }//GEN-LAST:event_JtextBuscarMouseClicked

    private void JtextBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextBuscarKeyReleased

    }//GEN-LAST:event_JtextBuscarKeyReleased

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        if (identificador == true) {
            IngresarClienteCotizaciones();
        } else {
            IngresarClienteVenta();
        }


    }//GEN-LAST:event_enviarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.bolivia.swing.JCTextField JtextBuscar;
    public static rojerusan.RSTableMetro TablaListadoClientes;
    private javax.swing.JLabel codigoL1;
    private javax.swing.JButton enviar;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
