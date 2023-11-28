/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dokter;

import dashboard.tampilan_awal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class tampilan_input_hasil extends javax.swing.JFrame {

    /**
     * Creates new form tampilan_input_hasil
     */
    public tampilan_input_hasil() {
        initComponents();
        nohasilkonsul();
    }
    
    public void nohasilkonsul(){
        try{
        java.sql.Connection conn = koneksi.konek.configDB();
        Statement s = conn.createStatement();
        String sql = ("SELECT id_konsultasi from konsultasi ORDER BY id_konsultasi DESC");
        ResultSet rs = s.executeQuery(sql);
        if(rs.next()){
            String no_antrian = rs.getString("id_konsultasi").substring(2);
            String NO = ""+(Integer.parseInt(no_antrian)+1);
            String Nol = "";
            
            if (NO.length()==1) 
            {Nol = "000";}
            else if(NO.length()==2)
            {Nol = "00";}
            else if(NO.length()==3)
            {Nol = "0";}
            else if(NO.length()==4)
            {Nol = "";}
            
            this.id_hasil_konsul.setText("IK" + Nol + NO);
        } else{
            id_hasil_konsul.setText("IK0001");
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal");
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

        id_hasil_konsul = new javax.swing.JLabel();
        id_user = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        id_konsul = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        txt_advice = new javax.swing.JTextField();
        txt_nik = new javax.swing.JLabel();
        txt_imt = new javax.swing.JTextField();
        txt_id_detaill = new javax.swing.JLabel();
        txt_id_dokter = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(null);

        id_hasil_konsul.setText("jLabel2");
        getContentPane().add(id_hasil_konsul);
        id_hasil_konsul.setBounds(1180, 80, 51, 20);

        id_user.setText("jLabel2");
        getContentPane().add(id_user);
        id_user.setBounds(660, 80, 51, 20);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1330, 960, 300, 70);

        id_konsul.setText("jLabel2");
        getContentPane().add(id_konsul);
        id_konsul.setBounds(1000, 50, 80, 20);
        getContentPane().add(txt_total);
        txt_total.setBounds(1390, 876, 230, 30);
        getContentPane().add(txt_advice);
        txt_advice.setBounds(740, 850, 470, 150);

        txt_nik.setText("jLabel2");
        getContentPane().add(txt_nik);
        txt_nik.setBounds(940, 370, 470, 40);
        getContentPane().add(txt_imt);
        txt_imt.setBounds(740, 560, 470, 150);

        txt_id_detaill.setText("jLabel2");
        getContentPane().add(txt_id_detaill);
        txt_id_detaill.setBounds(820, 90, 51, 20);

        txt_id_dokter.setText("jLabel2");
        getContentPane().add(txt_id_dokter);
        txt_id_dokter.setBounds(1050, 100, 51, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/input Hasil.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1920, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String imt = txt_imt.getText();
        String advice = txt_advice.getText();
        String total = txt_total.getText();
        String id_detail = txt_id_detaill.getText();
        String id_dokter = txt_id_dokter.getText();
        
        try {
            String sql = "INSERT INTO konsultasi VALUES ('"+id_hasil_konsul.getText()+"','"+imt+"','"+advice+"','"+id_detail+"','"+id_dokter+"','"+total+"')";
            java.sql.Connection conn = (Connection)koneksi.konek.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Berhasil Terkirim");
            
            new tampilan_diet_plan().setVisible(true);
            tampilan_diet_plan.id_detail.setText(id_detail);
            tampilan_diet_plan.id_dokter.setText(id_dokter);
            dispose();
            
        } catch (Exception e) {
             System.out.println("Gagal Le"+ e.getMessage());
        }
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
            java.util.logging.Logger.getLogger(tampilan_input_hasil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tampilan_input_hasil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tampilan_input_hasil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tampilan_input_hasil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tampilan_input_hasil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel id_hasil_konsul;
    public static javax.swing.JLabel id_konsul;
    public static javax.swing.JLabel id_user;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txt_advice;
    public static javax.swing.JLabel txt_id_detaill;
    public static javax.swing.JLabel txt_id_dokter;
    private javax.swing.JTextField txt_imt;
    public static javax.swing.JLabel txt_nik;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
