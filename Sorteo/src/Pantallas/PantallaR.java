/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas;

import Entity.Boleto;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import Entity.Canciones;
import Entity.Encuesta;
import Entity.Oyente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;

/**
 *
 * @author srhad
 */
public class PantallaR extends javax.swing.JFrame {
    
    Map<String, List<Canciones>> cancionesPorArtista;
    int a = 0;
    boolean valido = false;
    Boleto boleto;
    List<Canciones> cancion;

    /**
     * Creates new form PantallaR
     */
    public PantallaR() {

        this.setLocationRelativeTo(null);
        this.setLocation(this.getX() - 200, this.getY() - 400);
        this.setResizable(false);
        initComponents();
        cancionesPorArtista = Encuesta.getCancionesPorArtista();
        Canciones();
        Confirmar.setEnabled(false);
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Canciones();
            }
        });

        ((AbstractDocument) textD.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (esNumero(string)) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (esNumero(text)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            private boolean esNumero(String text) {
                return text.matches("\\d*"); // Permite solo dígitos
            }
        });
        ((AbstractDocument) textE.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (esNumero(string)) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (esNumero(text)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            private boolean esNumero(String text) {
                return text.matches("\\d*"); // Permite solo dígitos
            }
        });
        ((AbstractDocument) textT.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (esNumero(string)) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (esNumero(text)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            private boolean esNumero(String text) {
                return text.matches("\\d*"); // Permite solo dígitos
            }

        });

    }

    public Canciones BuscarCancion(String a) {
        Canciones cancionI = null;
        String seleccion = (String) jComboBox1.getSelectedItem();
        for (int i = 0; i < cancionesPorArtista.get(seleccion).size(); i++) {
            if (cancionesPorArtista.get(seleccion).get(i).getTitulo() == a) {
                cancionI = cancionesPorArtista.get(seleccion).get(i);
                System.out.println(cancionesPorArtista.get(seleccion).get(i).getVoto());
                cancionI.addVoto();
            }
        }
        System.out.println(cancionI.getVoto());
        return cancionI;
    }

    public List<Canciones> SeleccionCancion() {
        cancion = new ArrayList<>();
        if (cancion1.isSelected()) {
            Canciones can = BuscarCancion(cancion1.getText());
            cancion.add(can);
        }
        System.out.println(cancion);
        if (cancion2.isSelected()) {
            Canciones can = BuscarCancion(cancion2.getText());
            cancion.add(can);
        }
        System.out.println(cancion);
        if (cancion3.isSelected()) {
            Canciones can = BuscarCancion(cancion3.getText());
            cancion.add(can);
        }
        System.out.println(cancion);
        if (cancion4.isSelected()) {
            Canciones can = BuscarCancion(cancion4.getText());
            cancion.add(can);
        }
        System.out.println(cancion);
        if (cancion5.isSelected()) {
            Canciones can = BuscarCancion(cancion5.getText());
            cancion.add(can);
        }
        return cancion;
    }

    public Oyente CreacionOyente() {
        String seleccion = (String) Gener.getSelectedItem();
        Oyente oyente = new Oyente(textD.getText(), textNombre.getText(), seleccion, Integer.valueOf(textE.getText()), textT.getText());
        oyente.setCanciones(SeleccionCancion());
        return oyente;
    }

    public void Registar() {
        int a = (int) (Math.random() * (5 - 1)) + 1;
        boleto = new Boleto((PantallaS.boleto.size() + 1), a, CreacionOyente());
        PantallaS.boleto.add(boleto);
    }

    public void Canciones() {
        String seleccion = (String) jComboBox1.getSelectedItem();
        List<Canciones> canciones = cancionesPorArtista.get(seleccion);
        cancion1.setText(canciones.get(0).getTitulo());
        cancion2.setText(canciones.get(1).getTitulo());
        cancion3.setText(canciones.get(2).getTitulo());
        cancion4.setText(canciones.get(3).getTitulo());
        cancion5.setText(canciones.get(4).getTitulo());

    }

    public void ErrorHiden() {
        Erromsg.setText("");
    }

    public void ErrorShow() {
        Erromsg.setText("Error: Seleccione solo tres canciones.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textE = new javax.swing.JTextField();
        textT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cancion1 = new javax.swing.JCheckBox();
        cancion2 = new javax.swing.JCheckBox();
        cancion3 = new javax.swing.JCheckBox();
        cancion4 = new javax.swing.JCheckBox();
        cancion5 = new javax.swing.JCheckBox();
        Erromsg = new javax.swing.JLabel();
        Confirmar = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Gener = new javax.swing.JComboBox<>();
        Verificar = new javax.swing.JCheckBox();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        textNombre.setForeground(new java.awt.Color(255, 255, 255));
        textNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textNombreKeyReleased(evt);
            }
        });
        jPanel1.add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 226, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Documento:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        textD.setForeground(new java.awt.Color(255, 255, 255));
        textD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textDKeyReleased(evt);
            }
        });
        jPanel1.add(textD, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 226, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Edad:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Número de telefono:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        textE.setForeground(new java.awt.Color(255, 255, 255));
        textE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textEKeyReleased(evt);
            }
        });
        jPanel1.add(textE, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 226, -1));

        textT.setForeground(new java.awt.Color(255, 255, 255));
        textT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTActionPerformed(evt);
            }
        });
        textT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textTKeyReleased(evt);
            }
        });
        jPanel1.add(textT, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 226, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Artista:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Michael Joseph Jackson", "Van Gogh", "Pablo Picasso", "Andy Warhol", "Salvador Dalí", "Frida Kahlo", "Andy Warhol", "Claude Monet", "Georgia O'Keeffe", "Jackson Pollock" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 230, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Canciones:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        cancion1.setForeground(new java.awt.Color(255, 255, 255));
        cancion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancion1ActionPerformed(evt);
            }
        });
        jPanel1.add(cancion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, -1, -1));

        cancion2.setForeground(new java.awt.Color(255, 255, 255));
        cancion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancion2ActionPerformed(evt);
            }
        });
        jPanel1.add(cancion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, -1, -1));

        cancion3.setForeground(new java.awt.Color(255, 255, 255));
        cancion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancion3ActionPerformed(evt);
            }
        });
        jPanel1.add(cancion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, -1, -1));

        cancion4.setForeground(new java.awt.Color(255, 255, 255));
        cancion4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancion4ActionPerformed(evt);
            }
        });
        jPanel1.add(cancion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, -1, -1));

        cancion5.setForeground(new java.awt.Color(255, 255, 255));
        cancion5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancion5ActionPerformed(evt);
            }
        });
        jPanel1.add(cancion5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 490, -1, -1));

        Erromsg.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Erromsg.setForeground(new java.awt.Color(255, 0, 0));
        Erromsg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(Erromsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 420, 30));

        Confirmar.setForeground(new java.awt.Color(255, 255, 255));
        Confirmar.setText("Registrar");
        Confirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ConfirmarMousePressed(evt);
            }
        });
        Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(Confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 620, 110, 30));

        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("< Anterior");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 620, 110, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Music Survey");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ingrese datos:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Género:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        Gener.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        jPanel1.add(Gener, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 230, -1));

        Verificar.setText("Confirmar");
        Verificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerificarActionPerformed(evt);
            }
        });
        jPanel1.add(Verificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, -1, -1));

        fondo.setForeground(new java.awt.Color(255, 255, 255));
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/background2.jpeg"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancion1ActionPerformed
        if (a < 3 && cancion1.isSelected()) {
            a++;

        } else if (a <= 3 && !cancion1.isSelected()) {
            a--;
            this.ErrorHiden();
        } else {
            this.ErrorShow();
            cancion1.setSelected(false);
        }
    }//GEN-LAST:event_cancion1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed

        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    private void cancion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancion2ActionPerformed
        if (a < 3 && cancion2.isSelected()) {
            a++;
        } else if (a <= 3 && !cancion2.isSelected()) {
            a--;
            this.ErrorHiden();
        } else {
            this.ErrorShow();
            cancion2.setSelected(false);
        }
    }//GEN-LAST:event_cancion2ActionPerformed

    private void cancion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancion3ActionPerformed
        if (a < 3 && cancion3.isSelected()) {
            a++;
        } else if (a <= 3 && !cancion3.isSelected()) {
            a--;
            this.ErrorHiden();
        } else {
            this.ErrorShow();
            cancion3.setSelected(false);
        }
    }//GEN-LAST:event_cancion3ActionPerformed

    private void cancion4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancion4ActionPerformed
        if (a < 3 && cancion4.isSelected()) {
            a++;
        } else if (a <= 3 && !cancion4.isSelected()) {
            a--;
            this.ErrorHiden();
        } else {
            this.ErrorShow();
            cancion4.setSelected(false);
        }
    }//GEN-LAST:event_cancion4ActionPerformed

    private void cancion5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancion5ActionPerformed
        if (a < 3 && cancion5.isSelected()) {
            a++;
        } else if (a <= 3 && !cancion5.isSelected()) {
            a--;
            this.ErrorHiden();
        } else {
            this.ErrorShow();
            cancion5.setSelected(false);
        }
    }//GEN-LAST:event_cancion5ActionPerformed

    private void ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarActionPerformed
        this.Registar();
        this.dispose();

    }//GEN-LAST:event_ConfirmarActionPerformed

    private void textTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTActionPerformed

    }//GEN-LAST:event_textTActionPerformed

    private void ConfirmarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmarMousePressed

    private void textNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNombreKeyReleased
        if (!textNombre.getText().isEmpty()) {
            valido = true;
        } else {
            valido = false;
        }
    }//GEN-LAST:event_textNombreKeyReleased

    private void textDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textDKeyReleased
        if (!textD.getText().isEmpty()) {
            valido = true;
        } else {
            valido = false;
        }
    }//GEN-LAST:event_textDKeyReleased

    private void textEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textEKeyReleased
        if (!textE.getText().isEmpty()) {
            valido = true;
        } else {
            valido = false;
        }
    }//GEN-LAST:event_textEKeyReleased

    private void textTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTKeyReleased
        if (!textT.getText().isEmpty()) {
            valido = true;
        } else {
            valido = false;
        }
    }//GEN-LAST:event_textTKeyReleased

    private void VerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerificarActionPerformed
        if (valido == true && a==3) {
            Confirmar.setEnabled(valido);
        } else {
            Erromsg.setText("Error: Campos vacios.");
            Confirmar.setEnabled(false);
            Verificar.setSelected(false);
        }
    }//GEN-LAST:event_VerificarActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Confirmar;
    private javax.swing.JLabel Erromsg;
    private javax.swing.JComboBox<String> Gener;
    private javax.swing.JCheckBox Verificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cancion1;
    private javax.swing.JCheckBox cancion2;
    private javax.swing.JCheckBox cancion3;
    private javax.swing.JCheckBox cancion4;
    private javax.swing.JCheckBox cancion5;
    private javax.swing.JButton exit;
    private javax.swing.JLabel fondo;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textD;
    private javax.swing.JTextField textE;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textT;
    // End of variables declaration//GEN-END:variables
}
