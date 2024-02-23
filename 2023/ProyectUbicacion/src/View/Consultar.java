/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.CiudadC;
import Controller.ContinenteC;
import Controller.EstadoC;
import Controller.PaisC;
import Model.Entity.Ciudad;
import Model.Entity.Continente;
import Model.Entity.Estado;
import Model.Entity.Pais;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juan
 */
public class Consultar extends javax.swing.JFrame {

    /**
     * Creates new form Consultar
     */
    public Consultar() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.SelectComboBox();
        jComboBox1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    SelectComboBox();
                }
            }
        });
    }

    private void SelectComboBox() {
        String valorSeleccionado = (String) jComboBox1.getSelectedItem();
        System.out.println("View.Registrar.jToggleButton1ActionPerformed()" + valorSeleccionado);

        try {

            // Captura de datos de entrada
            switch (valorSeleccionado) {
                case "Pais":
                    this.ConsultaPais();
                    break;
                case "Estado":
                    this.ConsultaEstado();
                    break;
                case "Ciudad":
                    this.ConsultaCiudad();
                    break;
                case "Continente":
                    this.ConsultaContinente();
                    break;
                default:
                    // No se hace nada
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ConsultaContinente() {

        try {
            ContinenteC controlador = new ContinenteC();
            ArrayList<Continente> listaDeProductos = controlador.ConsultarRegistro();

            DefaultTableModel model = (DefaultTableModel) TablaConsultar.getModel();

            // Limpiar la tabla antes de agregar nuevos datos
            model.setRowCount(0);

            model.setColumnIdentifiers(new String[]{"Codigo Postal", "Descripcion"});

            for (Continente continente : listaDeProductos) {
                Object[] fila = new Object[2]; // Asumo que tu tabla tiene 6 columnas

                //fila[0] = producto.getId(); // Reemplaza con el método adecuado para obtener el ID
                fila[0] = continente.getCodigo_postal();
                fila[1] = continente.getDescripcion();

                model.addRow(fila);
            }

            TablaConsultar.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ConsultaPais() {

        try {
            PaisC controlador = new PaisC();
            ArrayList<Pais> listaDeProductos = controlador.ConsultarRegistro();
            String conWhereA;
            DefaultTableModel model = (DefaultTableModel) TablaConsultar.getModel();

            // Limpiar la tabla antes de agregar nuevos datos
            model.setRowCount(0);

            // Limpiar las columnas existentes y establecer nuevas columnas
            model.setColumnIdentifiers(new String[]{"Codigo Postal", "Descripcion", "Continente"});
            //if(conAndWher){
            
            
            
            //}else{};
            for (Pais pais : listaDeProductos) {
                Object[] fila = new Object[3];

                fila[0] = pais.getCodigo_postal();
                fila[1] = pais.getDescripcion();
                fila[2] = pais.getDescripcion_continente();

                model.addRow(fila);
            }

            TablaConsultar.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void ConsultaEstado() {

        try {
            EstadoC controlador = new EstadoC();
            ArrayList<Estado> listaDeProductos = controlador.ConsultarRegistro();

            DefaultTableModel model = (DefaultTableModel) TablaConsultar.getModel();

            // Limpiar la tabla antes de agregar nuevos datos
            model.setRowCount(0);

            model.setColumnIdentifiers(new String[]{"Codigo Postal", "Descripcion", "Pais"});

            for (Estado estado : listaDeProductos) {
                Object[] fila = new Object[3]; // Asumo que tu tabla tiene 6 columnas

                //fila[0] = producto.getId(); // Reemplaza con el método adecuado para obtener el ID
                fila[0] = estado.getCodigo_postal();
                fila[1] = estado.getDescripcion();
                fila[2] = estado.getDescripcion_pais();

                model.addRow(fila);
            }

            TablaConsultar.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ConsultaCiudad() {

        try {
            CiudadC controlador = new CiudadC();
            ArrayList<Ciudad> listaDeProductos = controlador.ConsultarRegistro();

            DefaultTableModel model = (DefaultTableModel) TablaConsultar.getModel();

            // Limpiar la tabla antes de agregar nuevos datos
            model.setRowCount(0);

            model.setColumnIdentifiers(new String[]{"Codigo Postal", "Descripcion", "Estado"});

            for (Ciudad ciudad : listaDeProductos) {
                Object[] fila = new Object[3]; // Asumo que tu tabla tiene 6 columnas

                //fila[0] = producto.getId(); // Reemplaza con el método adecuado para obtener el ID
                fila[0] = ciudad.getCodigo_postal();
                fila[1] = ciudad.getDescripcion();
                fila[2] = ciudad.getDescripcion_estado();

                model.addRow(fila);
            }

            TablaConsultar.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaConsultar = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Continente", "Pais", "Estado", "Ciudad" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 115, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Qué desea Consultar?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        TablaConsultar.setForeground(new java.awt.Color(255, 255, 255));
        TablaConsultar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codico Postal", "Descripcion"
            }
        ));
        TablaConsultar.setEnabled(false);
        jScrollPane1.setViewportView(TablaConsultar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Consultar");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("< Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/f219c8f84503eee32016a115be66a4f4.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LugaresV jframe = new LugaresV();
        jframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consultar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaConsultar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
