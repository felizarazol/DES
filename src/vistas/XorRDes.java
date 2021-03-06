/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

/**
 *
 * @author estma_000
 */

import controladores.Descifrar;
import controladores.CrearLlaves;

public class XorRDes extends javax.swing.JDialog {

    /**
     * Creates new form XorRDes
     */
    
    private String Ri;
    private String fi;
    private String Ri1;
    
    public XorRDes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        elegirStrings();
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        atras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Se recibe el R = " + Ri);

        jLabel2.setText("Con la llave k = " + fi + " se aplica la función Inner");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Xor.PNG"))); // NOI18N

        jLabel4.setText("Genera la Ri+1 = " + Ri1);

        atras.setText("Atras");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(atras)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_atrasActionPerformed

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
            java.util.logging.Logger.getLogger(XorRDes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XorRDes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XorRDes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XorRDes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                XorRDes dialog = new XorRDes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

     private void elegirStrings(){
        switch(VistaDescifrar.numeroR){
            case 1:
                Ri = Descifrar.R0.toString();
                fi = CrearLlaves.k1.toString();
                Ri1 = Descifrar.R1.toString();
            break;
            case 2:
                Ri = Descifrar.R1.toString();
                fi = CrearLlaves.k2.toString();
                Ri1 = Descifrar.R2.toString();
            break;
            case 3:
                Ri = Descifrar.R2.toString();
                fi = CrearLlaves.k3.toString();
                Ri1 = Descifrar.R3.toString();
            break;
            case 4:
                Ri = Descifrar.R3.toString();
                fi = CrearLlaves.k4.toString();
                Ri1 = Descifrar.R4.toString();
            break;
            case 5:
                Ri = Descifrar.R4.toString();
                fi = CrearLlaves.k5.toString();
                Ri1 = Descifrar.R5.toString();
            break;
            case 6:
                Ri = Descifrar.R5.toString();
                fi = CrearLlaves.k6.toString();
                Ri1 = Descifrar.R6.toString();
            break;
            case 7:
                Ri = Descifrar.R6.toString();
                fi = CrearLlaves.k7.toString();
                Ri1 = Descifrar.R7.toString();
            break;
            case 8:
                Ri = Descifrar.R7.toString();
                fi = CrearLlaves.k8.toString();
                Ri1 = Descifrar.R8.toString();
            break;
            case 9:
                Ri = Descifrar.R8.toString();
                fi = CrearLlaves.k9.toString();
                Ri1 = Descifrar.R9.toString();
            break;
            case 10:
                Ri = Descifrar.R9.toString();
                fi = CrearLlaves.k10.toString();
                Ri1 = Descifrar.R10.toString();
            break;
            case 11:
                Ri = Descifrar.R10.toString();
                fi = CrearLlaves.k11.toString();
                Ri1 = Descifrar.R11.toString();
            break;
            case 12:
                Ri = Descifrar.R11.toString();
                fi = CrearLlaves.k12.toString();
                Ri1 = Descifrar.R12.toString();
            break;
            case 13:
                Ri = Descifrar.R12.toString();
                fi = CrearLlaves.k13.toString();
                Ri1 = Descifrar.R13.toString();
            break;
            case 14:
                Ri = Descifrar.R13.toString();
                fi = CrearLlaves.k14.toString();
                Ri1 = Descifrar.R14.toString();
            break;
            case 15:
                Ri = Descifrar.R14.toString();
                fi = CrearLlaves.k15.toString();
                Ri1 = Descifrar.R15.toString();
            break;
            case 16:
                Ri = Descifrar.R15.toString();
                fi = CrearLlaves.k16.toString();
                Ri1 = Descifrar.R16.toString();
            break;
                
        }
     }
}
