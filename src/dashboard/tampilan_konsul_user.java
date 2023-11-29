/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import static dashboard.tampilan_biodata.id_detail;
import static dashboard.tampilan_biodata.txt_bb;
import static dashboard.tampilan_biodata.txt_iduser;
import static dashboard.tampilan_biodata.txt_nama;
import static dashboard.tampilan_biodata.txt_nik;
import static dashboard.tampilan_biodata.txt_tanggal;
import static dashboard.tampilan_biodata.txt_tb;
import static dashboard.tampilan_biodata.txt_umur;
import static dashboard.tampilan_choose_doctor.txt_iduser;
import static dashboard.tampilan_dashboard.id_detail;
import static dashboard.tampilan_dashboard.tampil_hasil_konsul;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class tampilan_konsul_user extends javax.swing.JFrame {

    /**
     * Creates new form tampilan_konsul_user
     */
    public tampilan_konsul_user() {
        initComponents();
        id_detail();
    }
    
    public void showdata(){
        try {
            String sql = "SELECT * from detail_user where id_user = '"+txt_id_user.getText()+"' ";
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
        String sql = ("SELECT id_konsultasi_user from konsultasi_user ORDER BY id_konsultasi_user DESC");
        ResultSet rs = s.executeQuery(sql);
        if(rs.next()){
            String no_antrian = rs.getString("id_konsultasi_user").substring(2);
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
            
            this.txt_id_konsultasi_user.setText("KU" + Nol + NO);
        } else{
            txt_id_konsultasi_user.setText("KU0001");
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal");
        }
     }
    public static void tampil_konsul(){
        try {
            String sql = "select konsultasi.id_konsultasi,konsultasi.imt_bti,konsultasi.advice,konsultasi.id_detail,konsultasi.id_dokter,konsultasi.total, detail_user.nik from konsultasi join detail_user on konsultasi.id_detail = detail_user.id_detail where konsultasi.id_detail = '"+id_detail.getText()+"' order by id_konsultasi desc limit 1";
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

        jButton10 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txt_id_user = new javax.swing.JLabel();
        id_detail = new javax.swing.JLabel();
        kirim = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        txt_id_konsultasi_user = new javax.swing.JLabel();
        txt_id_dokter = new javax.swing.JLabel();
        txt_nama_dokter = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_hasil_konsul = new javax.swing.JTextArea();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jButton10.setContentAreaFilled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10);
        jButton10.setBounds(0, 220, 480, 110);

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
        getContentPane().add(txt_id_user);
        txt_id_user.setBounds(1030, 80, 190, 30);

        id_detail.setText("jLabel2");
        getContentPane().add(id_detail);
        id_detail.setBounds(910, 60, 51, 20);

        kirim.setContentAreaFilled(false);
        kirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kirimActionPerformed(evt);
            }
        });
        getContentPane().add(kirim);
        kirim.setBounds(1293, 929, 310, 80);

        jButton7.setContentAreaFilled(false);
        jButton7.setInheritsPopupMenu(true);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(0, 730, 480, 100);
        getContentPane().add(txt_id_konsultasi_user);
        txt_id_konsultasi_user.setBounds(760, 80, 200, 30);
        getContentPane().add(txt_id_dokter);
        txt_id_dokter.setBounds(1100, 70, 180, 40);
        getContentPane().add(txt_nama_dokter);
        txt_nama_dokter.setBounds(1050, 370, 360, 40);

        txt_hasil_konsul.setColumns(20);
        txt_hasil_konsul.setRows(5);
        jScrollPane1.setViewportView(txt_hasil_konsul);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(760, 480, 820, 370);

        jButton8.setContentAreaFilled(false);
        jButton8.setInheritsPopupMenu(true);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(0, 840, 480, 100);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Halaman konsul (2).png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1920, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kirimActionPerformed
//        
 try {
            String sql = "select * from konsultasi_user where id_user = '"+txt_id_user.getText()+"' and status = 'Belum Diperiksa' order by id_user desc";
            java.sql.Connection conn = (Connection)koneksi.konek.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rst = pst.executeQuery();
            
            if(rst.next()){
                JOptionPane.showMessageDialog(this, "Anda Sudah Konsultasi, Harap Tunggu Hasil konsultasi Dari Dokter");
              // insert data  
            }else{
                try {
            String sql3 = "INSERT INTO konsultasi_user (id_konsultasi_user,isi_konsultasi,id_user,id_dokter,status) VALUES ('"+txt_id_konsultasi_user.getText()+"','"+txt_hasil_konsul.getText()+"','"+txt_id_user.getText()+"','"+txt_id_dokter.getText()+"','Belum Diperiksa')";
            java.sql.Connection conn3 = (Connection)koneksi.konek.configDB();
            java.sql.PreparedStatement pst2 = conn3.prepareStatement(sql3);
            pst2.executeUpdate();
            JOptionPane.showMessageDialog(this, "User Berhasil Ditambahkan");
            
            new tampilan_dashboard().setVisible(true);
            dispose();
            String id = txt_id_user.getText();
        tampilan_dashboard.txt_iduser.setText(id);
                   String id_details = id_detail.getText();
        tampilan_dashboard.id_detail.setText(id_details);
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Pilih Dokter Terlebih Dahulu");
        }
            }
        } catch (Exception e) {
        }

//try {
//            String sql3 = "INSERT INTO konsultasi_user (id_konsultasi_user,isi_konsultasi,id_user,id_dokter,status) VALUES ('"+txt_id_konsultasi_user.getText()+"','"+txt_hasil_konsul.getText()+"','"+txt_id_user.getText()+"','"+txt_id_dokter.getText()+"','Belum Diperiksa')";
//            java.sql.Connection conn3 = (Connection)koneksi.konek.configDB();
//            java.sql.PreparedStatement pst2 = conn3.prepareStatement(sql3);
//            pst2.executeUpdate();
//            JOptionPane.showMessageDialog(this, "Berhasil Terkirim");
//            
//            new tampilan_dashboard().setVisible(true);
//            dispose();
//            String id = txt_id_user.getText();
//        tampilan_dashboard.txt_iduser.setText(id);
//                   String id_details = id_detail.getText();
//        tampilan_dashboard.id_detail.setText(id_details);
//            
//        } catch (Exception e) {
//             JOptionPane.showMessageDialog(this, "Pilih Dokter Terlebih Dahulu");
//        }
    }//GEN-LAST:event_kirimActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        new tampilan_dashboard().setVisible(true);
        dispose();
        String id = txt_id_user.getText();
        tampilan_dashboard.txt_iduser.setText(id);
                   String id_details = id_detail.getText();
        tampilan_dashboard.id_detail.setText(id_details);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        new tampilan_biodata().setVisible(true);
        dispose();
        String id = txt_id_user.getText();
        tampilan_biodata.txt_iduser.setText(id);
                   String id_details = id_detail.getText();
        tampilan_biodata.id_detail.setText(id_details);
        showdata();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new tampilan_choose_doctor().setVisible(true);
        dispose();
        String id = txt_id_user.getText();
        tampilan_choose_doctor.txt_iduser.setText(id);
                   String id_details = id_detail.getText();
        tampilan_choose_doctor.id_detail.setText(id_details);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new tampilan_konsultasi().setVisible(true);
        tampil_konsul();
        String id = txt_id_user.getText();
        String id_details = id_detail.getText();
        tampilan_konsultasi.txt_iduser.setText(id);
        tampilan_konsultasi.id_detail.setText(id_details);
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        new tampilan_report().setVisible(true);
               tampil_hasil_konsul();

        String id = txt_id_user.getText();
        String id_details = id_detail.getText();
        tampilan_report.txt_iduser.setText(id);
        tampilan_report.id_detail.setText(id_details);
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(tampilan_konsul_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tampilan_konsul_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tampilan_konsul_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tampilan_konsul_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tampilan_konsul_user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel id_detail;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kirim;
    private javax.swing.JTextArea txt_hasil_konsul;
    public static javax.swing.JLabel txt_id_dokter;
    private javax.swing.JLabel txt_id_konsultasi_user;
    public static javax.swing.JLabel txt_id_user;
    public static javax.swing.JLabel txt_nama_dokter;
    // End of variables declaration//GEN-END:variables
}
