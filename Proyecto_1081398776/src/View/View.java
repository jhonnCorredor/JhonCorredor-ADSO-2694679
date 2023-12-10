/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.EstudiantesC;
import Controller.MateriaC;
import Controller.MatriculaC;
import Model.entity.Estudiantes;
import Model.entity.Materia;
import Model.entity.Matricula;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author srhad
 */
public class View extends javax.swing.JFrame {

    /**
     * Creates new form View
     */
    public View() {
        initComponents();
        this.Selection();
        this.ComboBoxEliminar();
        Seleccion.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Selection();
                    ComboBoxEliminar();
                }
            }
        });
    }

    private void ComboBoxEliminar() {
        String valorSeleccionado = (String) Seleccion.getSelectedItem();
        System.out.println("View.Registrar.jToggleButton1ActionPerformed()" + valorSeleccionado);

        try {

            // Captura de datos de entrada
            switch (valorSeleccionado) {
                case "Estudiantes":
                    EstudiantesC controlador = new EstudiantesC();
                    ArrayList<Estudiantes> listaDeProductos = controlador.ConsultarRegistro();

                    jComboBox3.removeAllItems();

                    for (int i = 0; i < listaDeProductos.size(); i++) {
                        jComboBox3.addItem(String.valueOf(listaDeProductos.get(i).getDocumento()));
                    }
                    break;
                case "Materia":
                    MateriaC controladorM = new MateriaC();
                    ArrayList<Materia> listaDeProductosM = controladorM.ConsultarRegistro();

                    jComboBox3.removeAllItems();

                    for (int i = 0; i < listaDeProductosM.size(); i++) {
                        jComboBox3.addItem(String.valueOf(listaDeProductosM.get(i).getDescripcion()));
                    }
                    break;
                case "Matricula":
                    MatriculaC controladorMA = new MatriculaC();
                    ArrayList<Matricula> listaDeProductosMA = controladorMA.ConsultarRegistro();

                    jComboBox3.removeAllItems();

                    for (int i = 0; i < listaDeProductosMA.size(); i++) {
                        jComboBox3.addItem(String.valueOf(listaDeProductosMA.get(i).getCodigo()));
                    }
                    break;
                default:
                    // No se hace nada
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ComboBoxEstudiante() {
        EstudiantesC controlador = new EstudiantesC();
        ArrayList<Estudiantes> listaDeProductos = controlador.ConsultarRegistro();

        jComboBox1.removeAllItems();

        for (int i = 0; i < listaDeProductos.size(); i++) {
            jComboBox1.addItem(String.valueOf(listaDeProductos.get(i).getDocumento()));
        }
    }

    private void ComboBoxMateria() {
        MateriaC controlador = new MateriaC();
        ArrayList<Materia> listaDeProductos = controlador.ConsultarRegistro();

        jComboBox2.removeAllItems();

        for (int i = 0; i < listaDeProductos.size(); i++) {
            jComboBox2.addItem(String.valueOf(listaDeProductos.get(i).getDescripcion()));
        }
    }

    public void Selection() {
        String valorSeleccionado = (String) Seleccion.getSelectedItem();
        System.out.println("View.Registrar.jToggleButton1ActionPerformed()" + valorSeleccionado);

        try {

            // Captura de datos de entrada
            switch (valorSeleccionado) {
                case "Estudiantes":
                    Estudiante();
                    break;
                case "Materia":
                    Materia();
                    break;
                case "Matricula":
                    Matricula();
                    break;
                default:
                    // No se hace nada
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Estudiante() {

        try {
            EstudiantesC controlador = new EstudiantesC();
            ArrayList<Estudiantes> listaDeProductos = controlador.ConsultarRegistro();

            DefaultTableModel model = (DefaultTableModel) Tabla.getModel();

            // Limpiar la tabla antes de agregar nuevos datos
            model.setRowCount(0);

            model.setColumnIdentifiers(new String[]{"Nombre", "edad", "documento", "telefono", "correo"});

            for (Estudiantes ciudad : listaDeProductos) {
                Object[] fila = new Object[5]; // Asumo que tu tabla tiene 6 columnas

                //fila[0] = producto.getId(); // Reemplaza con el método adecuado para obtener el ID
                fila[0] = ciudad.getNombre();
                fila[1] = ciudad.getEdad();
                fila[2] = ciudad.getDocumento();
                fila[3] = ciudad.getTelefono();
                fila[4] = ciudad.getCorreo();

                model.addRow(fila);
            }

            Tabla.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Label1.setText("Nombre:");
        label2.setText("edad:");
        label3.setText("documento:");
        label4.setText("telefono:");
        label5.setText("correo:");
        labelCombobox1.setText("");
        labelComboBox2.setText("");
    }

    public void Materia() {

        try {
            MateriaC controlador = new MateriaC();
            ArrayList<Materia> listaDeProductos = controlador.ConsultarRegistro();

            DefaultTableModel model = (DefaultTableModel) Tabla.getModel();

            // Limpiar la tabla antes de agregar nuevos datos
            model.setRowCount(0);

            model.setColumnIdentifiers(new String[]{"Descripcion", "Aula", "horas duracion"});

            for (Materia ciudad : listaDeProductos) {
                Object[] fila = new Object[3]; // Asumo que tu tabla tiene 6 columnas

                //fila[0] = producto.getId(); // Reemplaza con el método adecuado para obtener el ID
                fila[0] = ciudad.getDescripcion();
                fila[1] = ciudad.getAula();
                fila[2] = ciudad.getHoras_duracion();;

                model.addRow(fila);
            }

            Tabla.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Label1.setText("Descripcion:");
        label2.setText("Aula:");
        label3.setText("horas duracion:");
        label4.setText("");
        label5.setText("");
        labelCombobox1.setText("");
        labelComboBox2.setText("");
    }

    public void Matricula() {

        try {
            MatriculaC controlador = new MatriculaC();
            ArrayList<Matricula> listaDeProductos = controlador.ConsultarRegistro();

            DefaultTableModel model = (DefaultTableModel) Tabla.getModel();

            // Limpiar la tabla antes de agregar nuevos datos
            model.setRowCount(0);

            model.setColumnIdentifiers(new String[]{"codigo", "estudiante", "materia", "nota"});

            for (Matricula ciudad : listaDeProductos) {
                Object[] fila = new Object[4]; // Asumo que tu tabla tiene 6 columnas

                //fila[0] = producto.getId(); // Reemplaza con el método adecuado para obtener el ID
                fila[0] = ciudad.getCodigo();
                fila[1] = ciudad.getDocumento_estudiante();
                fila[2] = ciudad.getMateria_descripcion();
                fila[3] = ciudad.getNota();

                model.addRow(fila);
            }

            Tabla.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Label1.setText("codigo:");
        label2.setText("nota");
        label3.setText(":");
        label4.setText("");
        label5.setText("");
        labelCombobox1.setText("Estudiante:");
        labelComboBox2.setText("Materia");
        ComboBoxEstudiante();
        ComboBoxMateria();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Seleccion = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelComboBox2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        Label1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        label4 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        labelCombobox1 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        Agregar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Seleccione");

        Seleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudiantes", "Materia", "Matricula" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(Seleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Seleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        labelComboBox2.setText("jLabel3");

        label3.setText("jLabel2");

        label5.setText("jLabel2");

        Label1.setText("jLabel2");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion" }));

        label4.setText("jLabel2");

        label2.setText("jLabel2");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion" }));

        labelCombobox1.setText("jLabel3");

        jLabel3.setText("Seleccion modificar o eliminar");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label1)
                            .addComponent(label3)
                            .addComponent(label4))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(label2)
                        .addGap(28, 28, 28)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(116, 116, 116)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(label5)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(labelCombobox1)
                            .addGap(18, 18, 18)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(labelComboBox2)
                            .addGap(18, 18, 18)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCombobox1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label4)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelComboBox2)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jScrollPane1.setEnabled(false);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Tabla);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addContainerGap())
        );

        Agregar.setText("Agregar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Agregar)
                .addGap(18, 18, 18)
                .addComponent(Eliminar)
                .addGap(18, 18, 18)
                .addComponent(Modificar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(687, 687, 687)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel2)
                .addGap(50, 50, 50)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        // TODO add your handling code here:

        String valorSeleccionado = (String) Seleccion.getSelectedItem();
        System.out.println("View.Registrar.jToggleButton1ActionPerformed()" + valorSeleccionado);

        try {

            // Captura de datos de entrada
            switch (valorSeleccionado) {
                case "Estudiantes":
                    String nombre = jTextField1.getText();
                    String edad = jTextField2.getText();
                    String documento = jTextField3.getText();
                    String telefono = jTextField4.getText();
                    String correo = jTextField5.getText();
                    EstudiantesC controlador = new EstudiantesC();
                    controlador.Guardar(nombre, edad, documento, telefono, correo);
                    break;
                case "Materia":
                    MateriaC controladorM = new MateriaC();
                    String descripcion = jTextField1.getText();
                    String aula = jTextField2.getText();
                    String hora = jTextField3.getText();
                    controladorM.Guardar(descripcion, aula, descripcion);
                    break;
                case "Matricula":
                    MatriculaC controladorMA = new MatriculaC();
                    String codigo = jTextField1.getText();
                    String estudiante = (String) jComboBox1.getSelectedItem();
                    String materia = (String) jComboBox2.getSelectedItem();
                    controladorMA.Guardar(codigo, estudiante, materia);
                    break;
                default:
                    // No se hace nada
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_AgregarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // TODO add your handling code here:
        String valorSeleccionado = (String) Seleccion.getSelectedItem();
        System.out.println("View.Registrar.jToggleButton1ActionPerformed()" + valorSeleccionado);

        String valorSeleccionadoEliminar = (String) jComboBox3.getSelectedItem();

        try {

            // Captura de datos de entrada
            switch (valorSeleccionado) {
                case "Estudiantes":
                    EstudiantesC controlador = new EstudiantesC();
                    String nombre = jTextField1.getText();
                    String edad = jTextField2.getText();
                    String documento = jTextField3.getText();
                    String telefono = jTextField4.getText();
                    String correo = jTextField5.getText();
                    controlador.Modificar(valorSeleccionadoEliminar, nombre, edad, documento, telefono, correo);
                    break;
                case "Materia":
                    MateriaC controladorM = new MateriaC();
                    String descripcion = jTextField1.getText();
                    String aula = jTextField2.getText();
                    String hora = jTextField3.getText();
                    controladorM.Modificar(valorSeleccionadoEliminar, descripcion, aula, hora);
                    break;
                case "Matricula":
                    MatriculaC controladorMA = new MatriculaC();
                    String codigo = jTextField1.getText();
                    String estudiante = (String) jComboBox1.getSelectedItem();
                    String materia = (String) jComboBox2.getSelectedItem();
                    int nota= Integer.parseInt(jTextField2.getText());
                    controladorMA.Modificar(valorSeleccionadoEliminar, codigo, estudiante, materia);
                    break;
                default:
                    // No se hace nada
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        // TODO add your handling code here:
        String valorSeleccionado = (String) Seleccion.getSelectedItem();
        System.out.println("View.Registrar.jToggleButton1ActionPerformed()" + valorSeleccionado);

        String valorSeleccionadoEliminar = (String) jComboBox3.getSelectedItem();

        try {

            // Captura de datos de entrada
            switch (valorSeleccionado) {
                case "Estudiantes":
                    EstudiantesC controlador = new EstudiantesC();
                    controlador.EliminarLogico(valorSeleccionadoEliminar);
                    break;
                case "Materia":
                    MateriaC controladorM = new MateriaC();
                    controladorM.EliminarLogico(valorSeleccionadoEliminar);
                    break;
                case "Matricula":
                    MatriculaC controladorMA = new MatriculaC();
                    controladorMA.EliminarLogico(valorSeleccionado);
                    break;
                default:
                    // No se hace nada
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ModificarActionPerformed

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JLabel Label1;
    private javax.swing.JButton Modificar;
    private javax.swing.JComboBox<String> Seleccion;
    private javax.swing.JTable Tabla;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel labelComboBox2;
    private javax.swing.JLabel labelCombobox1;
    // End of variables declaration//GEN-END:variables
}
