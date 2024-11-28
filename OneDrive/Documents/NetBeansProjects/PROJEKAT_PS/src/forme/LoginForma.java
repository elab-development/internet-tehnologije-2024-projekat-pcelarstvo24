/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import javax.swing.JOptionPane;
import controller.Controller;
import java.util.List;
import model.Bibliotekar;

/**
 *
 * @author Aleksandra
 */
public class LoginForma extends javax.swing.JFrame {

    private int brojPokusaja = 1;

    /**
     * Creates new form LoginForma
     */
    public LoginForma() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonPrijaviSe = new javax.swing.JButton();
        jPasswordFieldLozinka = new javax.swing.JPasswordField();
        jTextFieldKorisnickoIme = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jCheckBoxPrikaziLozinku = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonPrijaviSe.setText("PRIJAVI SE");
        jButtonPrijaviSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrijaviSeActionPerformed(evt);
            }
        });

        jTextFieldKorisnickoIme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldKorisnickoImeActionPerformed(evt);
            }
        });

        jLabel2.setText("Korisnicko ime:");

        jLabel3.setText("Lozinka: ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Dobrodošli, molimo Vas da se prijavite.");

        jCheckBoxPrikaziLozinku.setText("Prikazi lozinku");
        jCheckBoxPrikaziLozinku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPrikaziLozinkuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldKorisnickoIme, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(jButtonPrijaviSe, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordFieldLozinka))
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxPrikaziLozinku, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCheckBoxPrikaziLozinku)
                    .addComponent(jPasswordFieldLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButtonPrijaviSe, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPrijaviSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrijaviSeActionPerformed
        String korisnickoIme = jTextFieldKorisnickoIme.getText();
        String lozinka = String.valueOf(jPasswordFieldLozinka.getPassword());
        Bibliotekar log = new Bibliotekar(-1, "", "", -10, korisnickoIme, lozinka);
        if (korisnickoIme == null || lozinka == null || korisnickoIme.isEmpty() || lozinka.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Morate uneti oba parametra");
        } else {
            List<Bibliotekar> sviBibliotekari = Controller.getinstance().vratiSveBibliotekare();
            for (Bibliotekar bibliotekar : sviBibliotekari) {
                if (bibliotekar.equals(log)) {
                    new MainForma().setVisible(true);
                    this.dispose();
                    return;
                }
            }
            if (brojPokusaja >= 3) {
                JOptionPane.showMessageDialog(this, "Nema vise pokusaja, pokrenite ponovo");
               this.dispose();
               return;
            }
            JOptionPane.showMessageDialog(this, "Ne postoji u bazi, ostalo Vam je jos " + (3 - brojPokusaja) + " pokusaja");
            brojPokusaja++;
        }

    }//GEN-LAST:event_jButtonPrijaviSeActionPerformed

    private void jTextFieldKorisnickoImeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldKorisnickoImeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldKorisnickoImeActionPerformed

    private void jCheckBoxPrikaziLozinkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPrikaziLozinkuActionPerformed
        //ako je checkBox cekiran korisnik ce moci da vidi svoju lozinku u suprotnom mu se prikazuju zvezdice
        if (jCheckBoxPrikaziLozinku.isSelected()) {
            jPasswordFieldLozinka.setEchoChar((char) 0); // Prikaži lozinku
        } else {
            jPasswordFieldLozinka.setEchoChar('*'); // Sakrij lozinku
        }
    }//GEN-LAST:event_jCheckBoxPrikaziLozinkuActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPrijaviSe;
    private javax.swing.JCheckBox jCheckBoxPrikaziLozinku;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordFieldLozinka;
    private javax.swing.JTextField jTextFieldKorisnickoIme;
    // End of variables declaration//GEN-END:variables
}
