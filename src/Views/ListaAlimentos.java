/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controller.ListarAlimentosVM;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elmer
 */
public class ListaAlimentos extends javax.swing.JFrame {

    /**
     * Creates new form ListaAlimentosAd
     */
    private boolean identificador;

    public boolean getIdentificador() {
        return identificador;
    }

    public void setIdentificador(boolean identificador) {
        this.identificador = identificador;
    }

    public ListaAlimentos() {
        initComponents();
        mostrar();

        tipoAl2.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (tipoAl2.getSelectedIndex() == 0) {
                    tipoL2.setIcon(new ImageIcon(getClass().getResource("/Resources/tipoAlL.png")));
                    alimentos.SearchClientes("");
                }
                if (tipoAl2.getSelectedIndex() == 1) {
                    System.out.println("entro");
                    tipoL2.setIcon(new ImageIcon(getClass().getResource("/Resources/bebida.png")));
                    alimentos.SearchClientes((String) tipoAl2.getSelectedItem());
                }
                if (tipoAl2.getSelectedIndex() == 2) {
                    tipoL2.setIcon(new ImageIcon(getClass().getResource("/Resources/botana.png")));
                    alimentos.SearchClientes((String) tipoAl2.getSelectedItem());
                }
                if (tipoAl2.getSelectedIndex() == 3) {
                    tipoL2.setIcon(new ImageIcon(getClass().getResource("/Resources/caldo.png")));
                    alimentos.SearchClientes((String) tipoAl2.getSelectedItem());
                }
                if (tipoAl2.getSelectedIndex() == 4) {
                    tipoL2.setIcon(new ImageIcon(getClass().getResource("/Resources/camaron.png")));
                    alimentos.SearchClientes((String) tipoAl2.getSelectedItem());
                }
                if (tipoAl2.getSelectedIndex() == 5) {
                    tipoL2.setIcon(new ImageIcon(getClass().getResource("/Resources/coctel.png")));
                    alimentos.SearchClientes((String) tipoAl2.getSelectedItem());
                }
                if (tipoAl2.getSelectedIndex() == 6) {
                    tipoL2.setIcon(new ImageIcon(getClass().getResource("/Resources/desayuno.png")));
                    alimentos.SearchClientes((String) tipoAl2.getSelectedItem());
                }
                if (tipoAl2.getSelectedIndex() == 7) {
                    tipoL2.setIcon(new ImageIcon(getClass().getResource("/Resources/filete.png")));
                    alimentos.SearchClientes((String) tipoAl2.getSelectedItem());
                }
                if (tipoAl2.getSelectedIndex() == 8) {
                    tipoL2.setIcon(new ImageIcon(getClass().getResource("/Resources/langosta.png")));
                    alimentos.SearchClientes((String) tipoAl2.getSelectedItem());
                }
                if (tipoAl2.getSelectedIndex() == 9) {
                    tipoL2.setIcon(new ImageIcon(getClass().getResource("/Resources/langostino.png")));
                    alimentos.SearchClientes((String) tipoAl2.getSelectedItem());
                }
                if (tipoAl2.getSelectedIndex() == 10) {
                    tipoL2.setIcon(new ImageIcon(getClass().getResource("/Resources/pescado.png")));
                    alimentos.SearchClientes((String) tipoAl2.getSelectedItem());
                }
                if (tipoAl2.getSelectedIndex() == 11) {
                    tipoL2.setIcon(new ImageIcon(getClass().getResource("/Resources/pulpo.png")));
                    alimentos.SearchClientes((String) tipoAl2.getSelectedItem());
                }
            }
        });
    }

    public void calcular() {
        String pre;
        String can;
        double total = 0;
        double precio;
        int cantidad;
        double imp = 0.00;

        for (int i = 0; i < Views.Sistema.tablePedidos.getRowCount(); i++) {
            pre = Views.Sistema.tablePedidos.getValueAt(i, 3).toString();
            can = Views.Sistema.tablePedidos.getValueAt(i, 4).toString();
            precio = Double.parseDouble(pre);
            cantidad = Integer.parseInt(can);
            imp = precio * cantidad;
            total = total + imp;
            Views.Sistema.tablePedidos.setValueAt(Math.rint(imp * 100) / 100, i, 5);

        }
        Views.Sistema.TotalPedidos.setText("" + Math.rint(total * 100) / 100);

    }
    
    public void calcular2() {
        String pre;
        String can;
        double total = 0;
        double precio;
        int cantidad;
        double imp = 0.00;

        for (int i = 0; i < Views.Sistema.tablaCotizaciones.getRowCount(); i++) {
            pre = Views.Sistema.tablaCotizaciones.getValueAt(i, 2).toString();
            can = Views.Sistema.tablaCotizaciones.getValueAt(i, 3).toString();
            precio = Double.parseDouble(pre);
            cantidad = Integer.parseInt(can);
            imp = precio * cantidad;
            total = total + imp;
            Views.Sistema.tablaCotizaciones.setValueAt(Math.rint(imp * 100) / 100, i, 4);

        }
        Views.Sistema.TotalPedidos.setText("" + Math.rint(total * 100) / 100);

    }

    private ListarAlimentosVM alimentos;

    public void mostrar() {
        alimentos = new ListarAlimentosVM(TablePedidos_RegistroPedido);
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
        jPanel4 = new javax.swing.JPanel();
        JtextBuscar = new app.bolivia.swing.JCTextField();
        codigoL1 = new javax.swing.JLabel();
        tipoAl2 = new org.bolivia.combo.SComboBoxBlue();
        tipoL2 = new javax.swing.JLabel();
        enviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePedidos_RegistroPedido = TablePedidos_RegistroPedido = new rojerusan.RSTableMetro(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
        jPanel4.add(JtextBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 180, -1));

        codigoL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        codigoL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buscarL.png"))); // NOI18N
        jPanel4.add(codigoL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 250, 52));

        tipoAl2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TIPO ALIMENTO", "BEBIDAS", "BOTANAS", "CALDOS", "CAMARONES", "COCTELES", "DESAYUNOS", "FILETE", "LANGOSTA", "LANGOSTINO", "PESCADO", "PULPO" }));
        tipoAl2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tipoAl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoAl2ActionPerformed(evt);
            }
        });
        jPanel4.add(tipoAl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 183, -1));

        tipoL2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tipoAlL.png"))); // NOI18N
        jPanel4.add(tipoL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 32, 50, 50));

        enviar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        enviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/regis1.png"))); // NOI18N
        enviar.setText("Enviar a Pedidos");
        enviar.setToolTipText("");
        enviar.setBorder(null);
        enviar.setBorderPainted(false);
        enviar.setContentAreaFilled(false);
        enviar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        enviar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        enviar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });
        jPanel4.add(enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 120, 100));

        TablePedidos_RegistroPedido.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablePedidos_RegistroPedido);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JtextBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextBuscarKeyReleased
        JtextBuscar.setText(JtextBuscar.getText().toUpperCase());
        alimentos.SearchClientes(JtextBuscar.getText());
    }//GEN-LAST:event_JtextBuscarKeyReleased

    private void tipoAl2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoAl2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoAl2ActionPerformed

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed

        if (identificador == true){
             IngresarPedidos();
        }else {
            IngresarCotizaciones();
        }
        
       
    }//GEN-LAST:event_enviarActionPerformed

    private void IngresarPedidos() {
        if (TablePedidos_RegistroPedido.getRowCount() > 0) {
            try {
                String cant = null;
                DefaultTableModel tabladet = (DefaultTableModel) Views.Sistema.tablePedidos.getModel();

                String[] dato = new String[6];

                int fila = TablePedidos_RegistroPedido.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione un registro.");
                } else {
                    String cod = TablePedidos_RegistroPedido.getValueAt(fila, 1).toString();
                    String tipo = TablePedidos_RegistroPedido.getValueAt(fila, 4).toString();
                    String nom = TablePedidos_RegistroPedido.getValueAt(fila, 2).toString();
                    String precio = TablePedidos_RegistroPedido.getValueAt(fila, 3).toString();
                    int c = 0;
                    int j = 0;
                    cant = JOptionPane.showInputDialog(this, "Cantidad:", "Alimentos", JOptionPane.INFORMATION_MESSAGE);
                    while (!isNumber(cant) && cant != null) {
                        cant = JOptionPane.showInputDialog(this, "Debe ingresar valores numéricos\ny que sean mayor a 0:",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        for (int i = 0; i < Views.Sistema.tablePedidos.getRowCount(); i++) {
                            Object com = Views.Sistema.tablePedidos.getValueAt(i, 0);
                            Object cant1 = Views.Sistema.tablePedidos.getValueAt(i, 4);
                            if (cod.equals(com)) {
                                j = i;
                                int cantT = Integer.parseInt(cant) + Integer.parseInt((String) cant1);
                                Views.Sistema.tablePedidos.setValueAt(String.valueOf(cantT), i, 4);
                                c++;
                                calcular();
//                                CajaAd.recibi.setText("");
//                                CajaAd.cambio.setText("");
                            }
                        }
                        if (c == 0) {

                            dato[0] = cod;
                            dato[1] = tipo;
                            dato[2] = nom;
                            dato[3] = precio;
                            dato[4] = cant;

                            tabladet.addRow(dato);

                            Views.Sistema.tablePedidos.setModel(tabladet);
                            calcular();

//                            CajaAd.recibi.setText("");
//                            CajaAd.cambio.setText("");
                        }
                    }
                }
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay registros.", "Alimentos", 0,
                    new ImageIcon(getClass().getResource("/Resources/info.png")));
        }
    }
    
    
    
    
    
    
    public void IngresarCotizaciones() {
        if (TablePedidos_RegistroPedido.getRowCount() > 0) {
            try {
                String cant = null;
                DefaultTableModel tabladet = (DefaultTableModel) Views.Sistema.tablaCotizaciones.getModel();

                String[] dato = new String[6];

                int fila = TablePedidos_RegistroPedido.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione un registro.");
                } else {
                    String cod = TablePedidos_RegistroPedido.getValueAt(fila, 1).toString();
                    String tipo = TablePedidos_RegistroPedido.getValueAt(fila, 4).toString();
                    String nom = TablePedidos_RegistroPedido.getValueAt(fila, 2).toString();
                    String precio = TablePedidos_RegistroPedido.getValueAt(fila, 3).toString();
                    int c = 0;
                    int j = 0;
                    cant = JOptionPane.showInputDialog(this, "Cantidad:", "Alimentos", JOptionPane.INFORMATION_MESSAGE);
                    while (!isNumber(cant) && cant != null) {
                        cant = JOptionPane.showInputDialog(this, "Debe ingresar valores numéricos\ny que sean mayor a 0:",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    if ((cant.equals("")) || (cant.equals("0"))) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                    } else {
                        for (int i = 0; i < Views.Sistema.tablaCotizaciones.getRowCount(); i++) {
                            Object com = Views.Sistema.tablaCotizaciones.getValueAt(i, 0);
                            Object cant1 = Views.Sistema.tablaCotizaciones.getValueAt(i, 4);
                            if (cod.equals(com)) {
                                j = i;
                                int cantT = Integer.parseInt(cant) + Integer.parseInt((String) cant1);
                                Views.Sistema.tablaCotizaciones.setValueAt(String.valueOf(cantT), i, 4);
                                c++;
                                calcular();
//                                CajaAd.recibi.setText("");
//                                CajaAd.cambio.setText("");
                            }
                        }
                        if (c == 0) {

                            dato[0] = cod;
                          //  dato[1] = tipo;
                            dato[1] = nom;
                            dato[2] = precio;
                            dato[3] = cant;

                            tabladet.addRow(dato);

                            Views.Sistema.tablaCotizaciones.setModel(tabladet);
                            calcular2();

//                            CajaAd.recibi.setText("");
//                            CajaAd.cambio.setText("");
                        }
                    }
                }
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay registros.", "Alimentos", 0,
                    new ImageIcon(getClass().getResource("/Resources/info.png")));
        }
    }


    private void JtextBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtextBuscarMouseClicked
        alimentos.SearchClientes("");
    }//GEN-LAST:event_JtextBuscarMouseClicked

    public static boolean isNumber(String n) {
        try {
            if (Integer.parseInt(n) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaAlimentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.bolivia.swing.JCTextField JtextBuscar;
    public rojerusan.RSTableMetro TablePedidos_RegistroPedido;
    private javax.swing.JLabel codigoL1;
    private javax.swing.JButton enviar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private org.bolivia.combo.SComboBoxBlue tipoAl2;
    private javax.swing.JLabel tipoL2;
    // End of variables declaration//GEN-END:variables
}
