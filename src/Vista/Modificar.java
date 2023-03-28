/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;
 
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author VICTUS
 */
public class Modificar extends javax.swing.JFrame {

    public Modificar() {
        initComponents();
    }
    
    public void Mensajes(String mensaje){
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(null, mensaje);
        });
    }
    
    public void BlanquearCampos(){
        this.Campomostrarnombre.setText("");
        this.Camponombrenuevo.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        Bttonmodificar = new javax.swing.JButton();
        Campomostrarnombre = new javax.swing.JTextField();
        Camponombrenuevo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Bttonmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/Consulta/Boton Modificar.png"))); // NOI18N
        Bttonmodificar.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 10, 10, 5, new java.awt.Color(0, 0, 0)));
        jPanel1.add(Bttonmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 240, 80));

        Campomostrarnombre.setEditable(false);
        Campomostrarnombre.setBackground(new java.awt.Color(255, 255, 255));
        Campomostrarnombre.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        jPanel1.add(Campomostrarnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 228, 58));

        Camponombrenuevo.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        Camponombrenuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CamponombrenuevoActionPerformed(evt);
            }
        });
        jPanel1.add(Camponombrenuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 228, 58));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/Modicar/Texto Actual.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/Modicar/Texto Nuevo.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/Modicar/Imagen Salsa Picante.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CamponombrenuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CamponombrenuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CamponombrenuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Bttonmodificar;
    public javax.swing.JTextField Campomostrarnombre;
    public javax.swing.JTextField Camponombrenuevo;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
