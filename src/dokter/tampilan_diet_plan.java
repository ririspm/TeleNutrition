/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dokter;

import static dokter.tampilan_input_hasil.txt_id_detaill;
import static dokter.tampilan_input_hasil.txt_id_dokter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class tampilan_diet_plan extends javax.swing.JFrame {

    /**
     * Creates new form tampilan_diet_plan
     */
    public tampilan_diet_plan() {
        initComponents();
        id_rm();
    }
     public void id_rm(){
        try{
        java.sql.Connection conn = koneksi.konek.configDB();
        Statement s = conn.createStatement();
        String sql = ("SELECT id_rm from hasil_konsultasi ORDER BY id_rm DESC");
        ResultSet rs = s.executeQuery(sql);
        if(rs.next()){
            String no_antrian = rs.getString("id_rm").substring(2);
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
            
            this.id_rm.setText("RM" + Nol + NO);
        } else{
            id_rm.setText("RM0001");
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

        jButton1 = new javax.swing.JButton();
        id_dokter = new javax.swing.JLabel();
        id_detail = new javax.swing.JLabel();
        id_rm = new javax.swing.JLabel();
        id_user = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_hasil = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(null);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1270, 960, 330, 80);

        id_dokter.setText("jLabel2");
        getContentPane().add(id_dokter);
        id_dokter.setBounds(950, 40, 51, 20);

        id_detail.setText("jLabel2");
        getContentPane().add(id_detail);
        id_detail.setBounds(850, 50, 51, 20);

        id_rm.setText("jLabel2");
        getContentPane().add(id_rm);
        id_rm.setBounds(940, 360, 51, 20);

        id_user.setText("jLabel2");
        getContentPane().add(id_user);
        id_user.setBounds(660, 80, 51, 20);

        txt_hasil.setColumns(20);
        txt_hasil.setRows(5);
        jScrollPane1.setViewportView(txt_hasil);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(700, 410, 940, 530);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Halamn Diet Plan.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1920, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        String id_detail = txt_id_detaill.getText();
        String id_dokter = txt_id_dokter.getText();
        
        try {
            String sql = "INSERT INTO hasil_konsultasi VALUES ('"+id_rm.getText()+"','"+txt_hasil.getText()+"','"+id_detail+"','"+id_dokter+"')";
            java.sql.Connection conn = (Connection)koneksi.konek.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Berhasil Terkirim");
            
            new tampilan_list_konsul().setVisible(true);
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
            java.util.logging.Logger.getLogger(tampilan_diet_plan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tampilan_diet_plan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tampilan_diet_plan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tampilan_diet_plan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tampilan_diet_plan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel id_detail;
    public static javax.swing.JLabel id_dokter;
    public static javax.swing.JLabel id_rm;
    public static javax.swing.JLabel id_user;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_hasil;
    // End of variables declaration//GEN-END:variables
}
