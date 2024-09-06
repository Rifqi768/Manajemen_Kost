/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import com.toedter.calendar.JDateChooser;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class Laporan extends javax.swing.JFrame {
    Connection con;
    ResultSet rs;
    PreparedStatement psht;
    Statement stm;

    /**
     * Creates new form Laporann
     */
    public Laporan() {
        initComponents();
        koneksimysql();
        Date tanggalMulai = new Date();
        Date tanggalSelesai = new Date();
        selectlaporan(tanggalMulai, tanggalSelesai);
    }
     public void koneksimysql(){
    try{
        String url="jdbc:mysql://localhost/koswijayanti";
        String user="root";
        String pass="";
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection(url, user, pass);
        stm = (Statement) con.createStatement();

    }catch (Exception e){
        System.err.println("koneksi Gagal"+e.getMessage());
    }
    }
    
    public void selectlaporan (Date tanggalMulai, Date tanggalSelesai) {
    koneksimysql();
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String strTanggalMulai = formatter.format(tanggalMulai);
    String strTanggalSelesai = formatter.format(tanggalSelesai);
   
   
    try {
        String pemasukan = "SELECT SUM(Total_Harga) AS total FROM pemasukan WHERE Tanggal_Pembayaran BETWEEN '" + strTanggalMulai + "' AND '" + strTanggalSelesai + "'";
        psht = con.prepareStatement(pemasukan);
        rs = psht.executeQuery();
        while (rs.next()) {
            txtpemasukan.setText("Rp. " + rs.getString("total"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

    
    try {
        String pengeluaran = "SELECT SUM(Tagihan_Listrik) + SUM(Tagihan_Air) + SUM(Kebutuhan_Fasilitas) AS total FROM pengeluaran WHERE Tanggal_Pengeluaran BETWEEN '" + strTanggalMulai + "' AND '" + strTanggalSelesai + "'";
        psht = con.prepareStatement(pengeluaran);
        rs = psht.executeQuery();
        while (rs.next()) {
            txtpengeluaran.setText("Rp. " + rs.getString("total"));
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtpemasukan = new javax.swing.JTextField();
        txtpengeluaran = new javax.swing.JTextField();
        tanggalMulai = new com.toedter.calendar.JDateChooser();
        tanggalSelesai = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/zzzz.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -100, -1, 300));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("-Penyewa-");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("-Kamar");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/ooo.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("-Transaksi-");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, -1, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/yyy.png"))); // NOI18N
        jLabel7.setText("Login");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1177, 10, 150, 60));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 51, 0));
        jLabel8.setText("LAPORAN");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 51, 0));
        jLabel9.setText("Total Pemasukan ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 340, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 51, 0));
        jLabel10.setText("Total Pengeluaran ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 340, -1, -1));

        jButton1.setBackground(new java.awt.Color(153, 51, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Data Pemasukan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 590, 200, 60));

        jButton2.setBackground(new java.awt.Color(153, 51, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Data Pengeluaran");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 590, 210, 60));

        txtpemasukan.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        txtpemasukan.setText(" ");
        txtpemasukan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpemasukanActionPerformed(evt);
            }
        });
        txtpemasukan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpemasukanKeyReleased(evt);
            }
        });
        getContentPane().add(txtpemasukan, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 370, 100));

        txtpengeluaran.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        txtpengeluaran.setText(" ");
        txtpengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpengeluaranActionPerformed(evt);
            }
        });
        getContentPane().add(txtpengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 430, 370, 100));
        getContentPane().add(tanggalMulai, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 240, 30));
        getContentPane().add(tanggalSelesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 270, 230, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Dari :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Sampai :");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 270, -1, 30));

        jLabel1.setBackground(new java.awt.Color(153, 51, 0));
        jLabel1.setForeground(new java.awt.Color(153, 51, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Template 2 (fix).png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.setVisible(false);
       new Data_Pemasukan().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtpengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpengeluaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpengeluaranActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new DataPengeluaran().setVisible(true);
    }//GEN-LAST:event_jButton2MouseClicked

    private void txtpemasukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpemasukanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpemasukanActionPerformed

    private void txtpemasukanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpemasukanKeyReleased
        // TODO add your handling code here:
      
    }//GEN-LAST:event_txtpemasukanKeyReleased

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
    this.setVisible(false);
    new Beranda().setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
    this.setVisible(false);
    new Penyewa().setVisible(true);    
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
    this.setVisible(false);
    new Data_Transaksi().setVisible(true);    
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JDateChooser tanggalMulai;
    private com.toedter.calendar.JDateChooser tanggalSelesai;
    private javax.swing.JTextField txtpemasukan;
    private javax.swing.JTextField txtpengeluaran;
    // End of variables declaration//GEN-END:variables
}
