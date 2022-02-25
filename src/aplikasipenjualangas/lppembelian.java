
package aplikasipenjualangas;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author TOSHIBA DC
 */
public class lppembelian extends javax.swing.JInternalFrame {

    /**
     * Creates new form barang
     */
    public lppembelian() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)getUI()).setNorthPane(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        tgl2TF = new com.toedter.calendar.JDateChooser();
        tgl1TF = new com.toedter.calendar.JDateChooser();
        jSeparator3 = new javax.swing.JSeparator();
        cetak1BT = new javax.swing.JButton();
        cetakBT = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1160, 570));
        setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1160, 570));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Laporan Pembelian");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 370, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 410, 10));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1160, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255)), "FIlter Laporan Penjualan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(102, 204, 255))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Sampai Tanggal  :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 310, 10));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Dari Tanggal       :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));
        jPanel3.add(tgl2TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 190, 30));
        jPanel3.add(tgl1TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 190, 30));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 310, 10));

        cetak1BT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cetak1BT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Print.png"))); // NOI18N
        cetak1BT.setText("CETAK SEMUA");
        cetak1BT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cetak1BTMouseEntered(evt);
            }
        });
        cetak1BT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetak1BTActionPerformed(evt);
            }
        });
        jPanel3.add(cetak1BT, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, 40));

        cetakBT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cetakBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Print.png"))); // NOI18N
        cetakBT.setText("CETAK");
        cetakBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cetakBTMouseEntered(evt);
            }
        });
        cetakBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakBTActionPerformed(evt);
            }
        });
        jPanel3.add(cetakBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 140, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 360, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cetak1BTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetak1BTActionPerformed
        // TODO add your handling code here:
           // TODO add your handling code here:
        try {
            String NamaFile = "src/Laporan/pembelian1.jasper";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/papantulis","root","");
            HashMap param = new HashMap();
            JasperPrint JPrint = JasperFillManager.fillReport(NamaFile, param, koneksi);
            JasperViewer.viewReport(JPrint, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak dapat dicetak!","Cetak Data",JOptionPane.ERROR_MESSAGE);
        
    }
    }//GEN-LAST:event_cetak1BTActionPerformed

    private void cetakBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakBTActionPerformed
        // TODO add your handling code here:
        
        try {
            String NamaFile = "src/Laporan/pembelian.jasper";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/papantulis","root","");
            HashMap param = new HashMap(2);
            //Mengambil parameter
            param.put("tgl1",tgl1TF.getDate());
            param.put("tgl2",tgl2TF.getDate());

            JasperPrint JPrint = JasperFillManager.fillReport(NamaFile, param, koneksi);
            JasperViewer.viewReport(JPrint, false);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Data tidak dapat dicetak!","Cetak Data",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cetakBTActionPerformed

    private void cetakBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cetakBTMouseEntered
        // TODO add your handling code here:
         cetakBT.setBackground(new Color(102,204,255));
        cetakBT.setForeground(Color.black);
    }//GEN-LAST:event_cetakBTMouseEntered

    private void cetak1BTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cetak1BTMouseEntered
        // TODO add your handling code here:
         cetak1BT.setBackground(new Color(102,204,255));
        cetak1BT.setForeground(Color.black);
    }//GEN-LAST:event_cetak1BTMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cetak1BT;
    private javax.swing.JButton cetakBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private com.toedter.calendar.JDateChooser tgl1TF;
    private com.toedter.calendar.JDateChooser tgl2TF;
    // End of variables declaration//GEN-END:variables
}
