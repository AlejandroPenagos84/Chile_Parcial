/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Control.Logica.ChileLogica;
import java.io.File;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author VICTUS
 */
public class Consultar extends javax.swing.JFrame{
    private ChileLogica c;
    /**
     * Creates new form Ingresar
     */
    public Consultar() {
        initComponents();
    }
    
    public void Mensajes(String mensaje){
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(null, mensaje);
        });
    }
    
     public void AgregarElementosJBox(ChileLogica ch){
        this.c = ch;
        jcNombres.setModel(new DefaultComboBoxModel<>(c.NombresInsertar().toArray(new String[0])));
    }
    
    public void BlanquearCampos(){
        jcNombres.setSelectedIndex(-1);
        Campomostrarcolor.setText("");
        Campomostrarpais.setText("");
        Campomostrarclasificacion.setText("");
        Campomostrarminimoshu.setText("");
        Campomostrarmaximoshu.setText("");
        Campomostrarespecie.setText("");    
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Bttonconsulta = new javax.swing.JButton();
        Bttonlimpiar = new javax.swing.JButton();
        jcNombres = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        Bttonmodificar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Campomostrarpais = new javax.swing.JTextField();
        Campomostrarcolor = new javax.swing.JTextField();
        Campomostrarminimoshu = new javax.swing.JTextField();
        Campomostrarclasificacion = new javax.swing.JTextField();
        Campomostrarespecie = new javax.swing.JTextField();
        Campomostrarmaximoshu = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/Consulta/Titulo Consulta.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/Consulta/Boton Salir.png"))); // NOI18N
        btnSalir.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 10, 10, 5, new java.awt.Color(0, 0, 0)));
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 740, 320, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/Consulta/Chile PvZ.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-110, 40, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 10, 10, 5, new java.awt.Color(0, 0, 0)));

        Bttonconsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/Consulta/Boton Consultar.png"))); // NOI18N
        Bttonconsulta.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));

        Bttonlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/Consulta/Boton Limpiar.png"))); // NOI18N
        Bttonlimpiar.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jcNombres, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Bttonconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Bttonlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jcNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Bttonconsulta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bttonlimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 440, 200));

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 10, 10, 5, new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Bttonmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/Consulta/Boton Modificar.png"))); // NOI18N
        Bttonmodificar.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel3.add(Bttonmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 230, 60));

        jLabel3.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        jLabel3.setText("Color");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 60, 30));

        jLabel4.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        jLabel4.setText("Pais");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        jLabel5.setText("Claificacion");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        jLabel6.setText("MinimoSHU");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        jLabel7.setText("MaximoSHU");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jLabel8.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        jLabel8.setText("Especie");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, 50));

        Campomostrarpais.setEditable(false);
        Campomostrarpais.setBackground(new java.awt.Color(255, 255, 255));
        Campomostrarpais.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel3.add(Campomostrarpais, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 270, 40));

        Campomostrarcolor.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        Campomostrarcolor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampomostrarcolorActionPerformed(evt);
            }
        });
        jPanel3.add(Campomostrarcolor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 270, 40));

        Campomostrarminimoshu.setEditable(false);
        Campomostrarminimoshu.setBackground(new java.awt.Color(255, 255, 255));
        Campomostrarminimoshu.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel3.add(Campomostrarminimoshu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 270, 40));

        Campomostrarclasificacion.setEditable(false);
        Campomostrarclasificacion.setBackground(new java.awt.Color(255, 255, 255));
        Campomostrarclasificacion.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel3.add(Campomostrarclasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 270, 40));

        Campomostrarespecie.setEditable(false);
        Campomostrarespecie.setBackground(new java.awt.Color(255, 255, 255));
        Campomostrarespecie.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel3.add(Campomostrarespecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 270, 40));

        Campomostrarmaximoshu.setEditable(false);
        Campomostrarmaximoshu.setBackground(new java.awt.Color(255, 255, 255));
        Campomostrarmaximoshu.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel3.add(Campomostrarmaximoshu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 270, 40));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/Consulta/Eliminar.jpg"))); // NOI18N
        btnEliminar.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel3.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 70, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 440, 410));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CampomostrarcolorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampomostrarcolorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampomostrarcolorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Bttonconsulta;
    public javax.swing.JButton Bttonlimpiar;
    public javax.swing.JButton Bttonmodificar;
    public javax.swing.JTextField Campomostrarclasificacion;
    public javax.swing.JTextField Campomostrarcolor;
    public javax.swing.JTextField Campomostrarespecie;
    public javax.swing.JTextField Campomostrarmaximoshu;
    public javax.swing.JTextField Campomostrarminimoshu;
    public javax.swing.JTextField Campomostrarpais;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JComboBox<String> jcNombres;
    // End of variables declaration//GEN-END:variables
}
