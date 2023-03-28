package Vista;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class Ingresar extends javax.swing.JFrame{

    public Ingresar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grupoespecies = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Textoingresar = new javax.swing.JLabel();
        Bttonguardar = new javax.swing.JButton();
        Textonombre = new javax.swing.JLabel();
        Textocolor = new javax.swing.JLabel();
        Campocolor = new javax.swing.JTextField();
        Campopais = new javax.swing.JTextField();
        Textopais = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BttonSfrutescens = new javax.swing.JRadioButton();
        BttonSannuum = new javax.swing.JRadioButton();
        BttonSeximiun = new javax.swing.JRadioButton();
        BttonSpubescens = new javax.swing.JRadioButton();
        BttonSrhomboideum = new javax.swing.JRadioButton();
        BttonSbaccatum = new javax.swing.JRadioButton();
        BttonSchinense = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        Campominimoshu = new javax.swing.JTextField();
        Campomaximoshu = new javax.swing.JTextField();
        Textorango = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Slider = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Camponombre = new javax.swing.JTextField();
        Textoclasificacion = new javax.swing.JLabel();
        Textoespecie = new javax.swing.JLabel();
        Bttonsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(8, 18, 18, 8, new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Textoingresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/Ingresar/Titulo Ingresar.png"))); // NOI18N
        jPanel2.add(Textoingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        Bttonguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/Ingresar/Boton Guardar.png"))); // NOI18N
        Bttonguardar.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel2.add(Bttonguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 300, 90));

        Textonombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Textonombre.setForeground(new java.awt.Color(255, 255, 255));
        Textonombre.setText("Nombre");
        jPanel2.add(Textonombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));

        Textocolor.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Textocolor.setForeground(new java.awt.Color(255, 255, 255));
        Textocolor.setText("Color");
        jPanel2.add(Textocolor, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, -1, -1));

        Campocolor.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel2.add(Campocolor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 370, 60));

        Campopais.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        Campopais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampopaisActionPerformed(evt);
            }
        });
        jPanel2.add(Campopais, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 370, 60));

        Textopais.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Textopais.setForeground(new java.awt.Color(255, 255, 255));
        Textopais.setText("Pais");
        jPanel2.add(Textopais, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Grupoespecies.add(BttonSfrutescens);
        BttonSfrutescens.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        BttonSfrutescens.setText("Capsicum Frutescens ");
        jPanel3.add(BttonSfrutescens, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 30));

        Grupoespecies.add(BttonSannuum);
        BttonSannuum.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        BttonSannuum.setText("Capsicum Annuum ");
        jPanel3.add(BttonSannuum, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        Grupoespecies.add(BttonSeximiun);
        BttonSeximiun.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        BttonSeximiun.setText("Capsicum Eximium ");
        jPanel3.add(BttonSeximiun, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 220, 26));

        Grupoespecies.add(BttonSpubescens);
        BttonSpubescens.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        BttonSpubescens.setText("Capsicum Pubescens ");
        jPanel3.add(BttonSpubescens, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        Grupoespecies.add(BttonSrhomboideum);
        BttonSrhomboideum.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        BttonSrhomboideum.setText("Capsicum Rhomboideum");
        jPanel3.add(BttonSrhomboideum, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        Grupoespecies.add(BttonSbaccatum);
        BttonSbaccatum.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        BttonSbaccatum.setText("Capsicum Baccatum ");
        jPanel3.add(BttonSbaccatum, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        Grupoespecies.add(BttonSchinense);
        BttonSchinense.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        BttonSchinense.setText("Capsicum Chinense ");
        jPanel3.add(BttonSchinense, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 200, 290, 280));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Campominimoshu.setBackground(new java.awt.Color(102, 255, 102));
        Campominimoshu.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel4.add(Campominimoshu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 180, 52));

        Campomaximoshu.setBackground(new java.awt.Color(255, 51, 51));
        Campomaximoshu.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel4.add(Campomaximoshu, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 170, 52));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 510, 450, 90));

        Textorango.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Textorango.setForeground(new java.awt.Color(255, 255, 255));
        Textorango.setText("Rango");
        jPanel2.add(Textorango, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 540, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Slider.setBackground(new java.awt.Color(0, 0, 0));
        Slider.setMajorTickSpacing(1);
        Slider.setMaximum(7);
        Slider.setOrientation(javax.swing.JSlider.VERTICAL);
        Slider.setPaintLabels(true);
        Slider.setPaintTicks(true);
        Slider.setSnapToTicks(true);
        Slider.setValue(0);
        jPanel5.add(Slider, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 240));

        jLabel5.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel5.setText("Extreme Hot");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, 30));

        jLabel8.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel8.setText("Fiery Hot");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, 50));

        jLabel10.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel10.setText("Really Hot");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, 30));

        jLabel11.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel11.setText("Very Hot");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, 30));

        jLabel12.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel12.setText("Spicy Hot");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, 30));

        jLabel13.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel13.setText("Hot");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, 50));

        jLabel14.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel14.setText("Mild Hot");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, 50));

        jLabel15.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel15.setText("Mild");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, 40));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 230, 280));

        Camponombre.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        Camponombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CamponombreActionPerformed(evt);
            }
        });
        Camponombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CamponombreKeyTyped(evt);
            }
        });
        jPanel2.add(Camponombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 370, 60));

        Textoclasificacion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Textoclasificacion.setForeground(new java.awt.Color(255, 255, 255));
        Textoclasificacion.setText("Clasificacion");
        jPanel2.add(Textoclasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, -1, -1));

        Textoespecie.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Textoespecie.setForeground(new java.awt.Color(255, 255, 255));
        Textoespecie.setText("Especie");
        jPanel2.add(Textoespecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 160, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1070, 640));

        Bttonsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/Ingresar/Boton Salir.png"))); // NOI18N
        Bttonsalir.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 10, 10, 5, new java.awt.Color(0, 0, 0)));
        jPanel1.add(Bttonsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 670, 350, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1108, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    public void Mensajes(String mensaje){
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(null, mensaje);
        });
    }
    

    public void BlanquearCampos(){
        this.Camponombre.setText("");
        this.Campocolor.setText("");
        this.Campopais.setText("");
        this.Campominimoshu.setText("");
        this.Campomaximoshu.setText("");
    }
    private void CampopaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampopaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampopaisActionPerformed

    private void CamponombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CamponombreKeyTyped
        
    }//GEN-LAST:event_CamponombreKeyTyped

    private void CamponombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CamponombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CamponombreActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JRadioButton BttonSannuum;
    public javax.swing.JRadioButton BttonSbaccatum;
    public javax.swing.JRadioButton BttonSchinense;
    public javax.swing.JRadioButton BttonSeximiun;
    public javax.swing.JRadioButton BttonSfrutescens;
    public javax.swing.JRadioButton BttonSpubescens;
    public javax.swing.JRadioButton BttonSrhomboideum;
    public javax.swing.JButton Bttonguardar;
    public javax.swing.JButton Bttonsalir;
    public javax.swing.JTextField Campocolor;
    public javax.swing.JTextField Campomaximoshu;
    public javax.swing.JTextField Campominimoshu;
    public javax.swing.JTextField Camponombre;
    public javax.swing.JTextField Campopais;
    public javax.swing.ButtonGroup Grupoespecies;
    public javax.swing.JSlider Slider;
    private javax.swing.JLabel Textoclasificacion;
    private javax.swing.JLabel Textocolor;
    private javax.swing.JLabel Textoespecie;
    private javax.swing.JLabel Textoingresar;
    private javax.swing.JLabel Textonombre;
    private javax.swing.JLabel Textopais;
    private javax.swing.JLabel Textorango;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
