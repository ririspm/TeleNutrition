/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dokter;

import java.sql.Connection;

import static dokter.tampilan_konsul_pelanggan.id_konsul;

/**
 *
 * @author HP
 */
public class tampilan_konsul_pelanggan extends javax.swing.JFrame {

    /**
     * Creates new form tampilan_konsul_pelanggan
     */
    public tampilan_konsul_pelanggan() {
        initComponents();
    }
    void tampilnik(){
        try {
            String sql = "select detail_user.nik from detail_user where id_user = '"+id_user.getText()+"'";
            java.sql.Connection conn = (Connection)koneksi.konek.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rst = pst.executeQuery();
            if(rst.next()){
                tampilan_input_hasil.txt_nik.setText(rst.getString("nik"));
            }
        } catch (Exception e) {
        }
    }
    void tampiliddetail(){
        try {
            String sql = "select detail_user.id_detail from detail_user where id_user = '"+id_user.getText()+"'";
            java.sql.Connection conn = (Connection)koneksi.konek.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rst = pst.executeQuery();
            if(rst.next()){
                tampilan_input_hasil.txt_id_detaill.setText(rst.getString("id_detail"));
            }
        } catch (Exception e) {
        }
    }
    void tampiliddokter(){
        try {
            String sql = "select konsultasi_user.id_dokter from konsultasi_user where id_user = '"+id_user.getText()+"'";
            java.sql.Connection conn = (Connection)koneksi.konek.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rst = pst.executeQuery();
            if(rst.next()){
                tampilan_input_hasil.txt_id_dokter.setText(rst.getString("id_dokter"));
            }
        } catch (Exception e) {
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

        id_user = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        id_konsul = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        konsul_pelanggan = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(null);

        id_user.setText("jLabel2");
        getContentPane().add(id_user);
        id_user.setBounds(660, 80, 51, 20);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1300, 930, 300, 80);

        id_konsul.setText("jLabel2");
        getContentPane().add(id_konsul);
        id_konsul.setBounds(1000, 50, 51, 20);

        konsul_pelanggan.setEditable(false);
        konsul_pelanggan.setColumns(20);
        konsul_pelanggan.setRows(5);
        jScrollPane1.setViewportView(konsul_pelanggan);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(700, 340, 930, 510);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Konsul Pelanggan.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1920, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          new tampilan_input_hasil().setVisible(true);
         tampilan_input_hasil.id_konsul.setText(id_konsul.getText());
         tampilan_input_hasil.id_user.setText(id_user.getText());
         tampilnik();
         tampiliddetail();
         tampiliddokter();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(tampilan_konsul_pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tampilan_konsul_pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tampilan_konsul_pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tampilan_konsul_pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tampilan_konsul_pelanggan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel id_konsul;
    public static javax.swing.JLabel id_user;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea konsul_pelanggan;
    // End of variables declaration//GEN-END:variables
}
