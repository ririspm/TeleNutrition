/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

/**
 *
 * @author HP
 */

import static dashboard.tampilan_choose_doctor.txt_iduser;
import static dashboard.tampilan_dashboard.id_detail;
import static dashboard.tampilan_dashboard.tampil_hasil_konsul;
import static dashboard.tampilan_dashboard.txt_iduser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.konek;

public class tampilan_biodata extends javax.swing.JFrame {

    /**
     * Creates new form tampilan_biodata
     */
    public tampilan_biodata() {
        initComponents();
        id_detail();
        
    }
    
    public void showdata(){
        try {
            String sql = "SELECT * from detail_user where id_user = '"+txt_iduser.getText()+"' ";
            java.sql.Connection conn = (Connection)koneksi.konek.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rst = pst.executeQuery();
            
            if(rst.next()){
                tampilan_biodata.txt_nik.setText(rst.getString("nik"));
                tampilan_biodata.txt_nama.setText(rst.getString("nama_lengkap"));
                tampilan_biodata.txt_tanggal.setText(rst.getString("tanggal_lahir"));
                tampilan_biodata.txt_umur.setText(rst.getString("umur"));
//                txt.setText(rst.getString("jenis_kelamin"));
                tampilan_biodata.txt_tb.setText(rst.getString("tb"));
                tampilan_biodata.txt_bb.setText(rst.getString("bb"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal");
        }
    
    }
    
    public void id_detail(){
        try{
        java.sql.Connection conn = koneksi.konek.configDB();
        Statement s = conn.createStatement();
        String sql = ("SELECT id_detail from detail_user ORDER BY id_detail DESC");
        ResultSet rs = s.executeQuery(sql);
        if(rs.next()){
            String no_antrian = rs.getString("id_detail").substring(2);
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
            
            this.txt_id.setText("DI" + Nol + NO);
        } else{
            txt_id.setText("DI0001");
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal");
        }
     }
     public static void tampil_konsul(){
        try {
            String sql = "select konsultasi.id_konsultasi,konsultasi.imt_bti,konsultasi.advice,konsultasi.id_detail,konsultasi.id_dokter,konsultasi.total, detail_user.nik from konsultasi join detail_user on konsultasi.id_detail = detail_user.id_detail where konsultasi.id_detail = '"+id_detail.getText()+"' order by id_detail desc";
            java.sql.Connection conn = (Connection)koneksi.konek.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rst = pst.executeQuery();
            if(rst.next()){
                tampilan_konsultasi.txt_imt.setText(rst.getString("imt_bti"));
                tampilan_konsultasi.txt_total.setText(rst.getString("total"));
                tampilan_konsultasi.txt_advice.setText(rst.getString("advice"));
                tampilan_konsultasi.nik.setText(rst.getString("nik"));
            }
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

        }
    }
      public static void tampil_hasil_konsul(){
        try {
            String sql = "select hasil_konsultasi.id_rm,hasil_konsultasi.hasil,hasil_konsultasi.id_detail,hasil_konsultasi.id_dokter, dokter.nama_dokter,dokter.jam_operasi_mulai,dokter.jam_operasi_selesai from hasil_konsultasi join dokter on hasil_konsultasi.id_dokter = dokter.id_dokter where id_detail = '"+id_detail.getText()+"'";
            java.sql.Connection conn = (Connection)koneksi.konek.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rst = pst.executeQuery();
            if(rst.next()){
                tampilan_report.no_rm.setText(rst.getString("id_rm"));
                tampilan_report.hasil.setText(rst.getString("hasil"));
                tampilan_report.nama_dokter.setText(rst.getString("nama_dokter"));
                tampilan_report.jam_mulai.setText(rst.getString("jam_operasi_mulai"));
                tampilan_report.jam_selesai.setText(rst.getString("jam_operasi_selesai"));
            }
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);

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

        txt_iduser = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        txt_nik = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        txt_tanggal = new javax.swing.JTextField();
        txt_umur = new javax.swing.JTextField();
        txt_bb = new javax.swing.JTextField();
        txt_tb = new javax.swing.JTextField();
        txt_id = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        id_detail = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setUndecorated(true);
        getContentPane().setLayout(null);
        getContentPane().add(txt_iduser);
        txt_iduser.setBounds(720, 70, 170, 40);

        jButton9.setContentAreaFilled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(0, 340, 480, 110);

        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(0, 469, 480, 100);

        jButton6.setContentAreaFilled(false);
        jButton6.setInheritsPopupMenu(true);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(0, 579, 480, 110);

        jButton7.setContentAreaFilled(false);
        jButton7.setInheritsPopupMenu(true);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(0, 730, 480, 100);

        jButton10.setContentAreaFilled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10);
        jButton10.setBounds(0, 220, 480, 110);

        txt_nik.setBorder(null);
        txt_nik.setOpaque(false);
        txt_nik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nikActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nik);
        txt_nik.setBounds(920, 366, 640, 40);

        txt_nama.setBorder(null);
        txt_nama.setOpaque(false);
        getContentPane().add(txt_nama);
        txt_nama.setBounds(920, 456, 640, 40);

        txt_tanggal.setBorder(null);
        txt_tanggal.setOpaque(false);
        getContentPane().add(txt_tanggal);
        txt_tanggal.setBounds(920, 546, 640, 40);

        txt_umur.setBorder(null);
        txt_umur.setOpaque(false);
        getContentPane().add(txt_umur);
        txt_umur.setBounds(920, 646, 640, 40);

        txt_bb.setBorder(null);
        txt_bb.setOpaque(false);
        getContentPane().add(txt_bb);
        txt_bb.setBounds(920, 826, 640, 40);

        txt_tb.setBorder(null);
        txt_tb.setOpaque(false);
        getContentPane().add(txt_tb);
        txt_tb.setBounds(920, 916, 640, 40);
        getContentPane().add(txt_id);
        txt_id.setBounds(710, 240, 120, 30);

        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1353, 1000, 260, 40);

        id_detail.setText("jLabel2");
        getContentPane().add(id_detail);
        id_detail.setBounds(910, 60, 51, 20);

        jButton8.setContentAreaFilled(false);
        jButton8.setInheritsPopupMenu(true);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(0, 850, 480, 100);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Halaman Biodata (3).png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1920, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        new tampilan_biodata().setVisible(true);
        String id = txt_iduser.getText();
        tampilan_biodata.txt_iduser.setText(id);
           String id_details = id_detail.getText();
        tampilan_biodata.id_detail.setText(id_details);
        dispose();
        showdata();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new tampilan_choose_doctor().setVisible(true);
        dispose();
        String id = txt_iduser.getText();
        String id_details = id_detail.getText();
        tampilan_choose_doctor.id_detail.setText(id_details);
        tampilan_choose_doctor.txt_iduser.setText(id);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         new tampilan_konsul_user().setVisible(true);
        dispose();
        String id = txt_iduser.getText();
        tampilan_konsul_user.txt_id_user.setText(id);
           String id_details = id_detail.getText();
        tampilan_konsul_user.id_detail.setText(id_details);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new tampilan_konsultasi().setVisible(true);
        tampil_konsul();
        String id_details = id_detail.getText();
        tampilan_konsultasi.id_detail.setText(id_details);
         String id = txt_iduser.getText();
        tampilan_konsultasi.txt_iduser.setText(id);
        
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        new tampilan_dashboard().setVisible(true);
        dispose();
         String id = txt_iduser.getText();
        tampilan_dashboard.txt_iduser.setText(id);
           String id_details = id_detail.getText();
        tampilan_dashboard.id_detail.setText(id_details);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String iduser = txt_iduser.getText();
        String iddetail = txt_id.getText();
        String nik = txt_nik.getText();
        String name = txt_nama.getText();
        String birth = txt_tanggal.getText();
        String age = txt_umur.getText();
//        String jenis_kelamin = .getText();
        String bb = txt_bb.getText();
        String tb = txt_tb.getText();
        
        
        String id = txt_iduser.getText();
        
        try {
            String sql = "SELECT * from detail_user where id_user = '"+id+"';";
            java.sql.Connection conn = (Connection)koneksi.konek.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rst = pst.executeQuery();
            
            if(rst.next()){
                txt_nik.setText(rst.getString("nik"));
                txt_nama.setText(rst.getString("nama_lengkap"));
                txt_tanggal.setText(rst.getString("tanggal_lahir"));
                txt_umur.setText(rst.getString("umur"));
//                txt.setText(rst.getString("jenis_kelamin"));
                txt_tb.setText(rst.getString("tb"));
                txt_bb.setText(rst.getString("bb"));
                
                // Update User
                try {
            String sqlupdate = "UPDATE detail_user SET "
                    + "nik = '"+nik+"',"
                    + "nama_lengkap = '"+name+"',"
                    + "tanggal_lahir = '"+birth+"',"
                    + "umur = '"+age+"',"
                    + "tb = '"+tb+"',"
                    + "bb = '"+bb+"'"
                    + "where id_user = '"+iduser+"'";
            java.sql.Connection conn2 = (Connection)koneksi.konek.configDB();
            java.sql.PreparedStatement pst2 = conn2.prepareStatement(sqlupdate);
            pst2.executeUpdate();
            
             new tampilan_choose_doctor().setVisible(true);
            dispose();
        tampilan_choose_doctor.txt_iduser.setText(id);
                        
        } catch (Exception e) {
             System.out.println("Gagal Update "+ e.getMessage());
        }
              // insert data  
            }else{
                try {
            String sql3 = "INSERT INTO detail_user (id_detail,nik,nama_lengkap,tanggal_lahir,umur,jenis_kelamin,tb,bb,id_user) VALUES ('"+iddetail+"','"+nik+"','"+name+"','"+birth+"','"+age+"','','"+tb+"','"+bb+"','"+iduser+"')";
            java.sql.Connection conn3 = (Connection)koneksi.konek.configDB();
            java.sql.PreparedStatement pst2 = conn3.prepareStatement(sql3);
            pst2.executeUpdate();
            JOptionPane.showMessageDialog(this, "User Berhasil Ditambahkan");
            
            new tampilan_choose_doctor().setVisible(true);
            dispose();
            tampilan_choose_doctor.txt_iduser.setText(id);
            
        } catch (Exception e) {
             System.out.println("Gagal Le"+ e.getMessage());
        }
            }
        } catch (Exception e) {
        }

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_nikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nikActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        new tampilan_report().setVisible(true);
               tampil_hasil_konsul();

        String id = txt_iduser.getText();
        String id_details = id_detail.getText();
        tampilan_report.txt_iduser.setText(id);
        tampilan_report.id_detail.setText(id_details);
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line  arguments
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
            java.util.logging.Logger.getLogger(tampilan_biodata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tampilan_biodata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tampilan_biodata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tampilan_biodata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tampilan_biodata().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel id_detail;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JTextField txt_bb;
    private javax.swing.JLabel txt_id;
    public static javax.swing.JLabel txt_iduser;
    public static javax.swing.JTextField txt_nama;
    public static javax.swing.JTextField txt_nik;
    public static javax.swing.JTextField txt_tanggal;
    public static javax.swing.JTextField txt_tb;
    public static javax.swing.JTextField txt_umur;
    // End of variables declaration//GEN-END:variables
}
