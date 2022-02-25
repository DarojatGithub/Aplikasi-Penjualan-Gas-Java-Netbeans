
package aplikasipenjualangas;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;


public class barang extends javax.swing.JInternalFrame {
    Connection conn;
    Statement st;
    ResultSet rs;

    /**
     * Creates new form barang
     */
    public barang() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)getUI()).setNorthPane(null);
       
        
        jTable1.getTableHeader().setFont(new Font("Tohome",Font.BOLD,12));
        jTable1.getTableHeader().setOpaque(false);
          jTable1.getTableHeader().setBackground(new Color(32,136,203));
        jTable1.getTableHeader().setForeground(new Color(225,255,255));
        jTable1.setRowHeight(25);
        
        siapIsi(false);
        tombolNormal();
        tampil();
        otomatis();
    }
private void bersih(){
        kodeTF.setText("");
        
        namaCB.setSelectedItem("");
         ukurCB.setSelectedItem("");
         beliTF.setText("");
         jualTF.setText("");
        stokTF.setText("");
       
       
    }

    private void siapIsi(boolean a){
        kodeTF.setEnabled(a);
        
        namaCB.setEnabled(a);
        ukurCB.setEnabled(a);
        beliTF.setEnabled(a);
         jualTF.setEnabled(a);
         stokTF.setEnabled(a);
       
       
    }
    
    
    
    private void tombolNormal(){
        tambahBT.setEnabled(true);
        simpanBT.setEnabled(false);
        hapusBT.setEnabled(false);
        editBT.setEnabled(false);
       
        cariBT.setEnabled(true);
    }
    
    private void otomatis(){
        try {
            setKoneksi();
            String sql="select right (kodebarang,2)+1 from barang";
            ResultSet rs=st.executeQuery(sql);
            
           
           
            if(rs.next()){
                rs.last();
                String no=rs.getString(1);
                while (no.length()<3){
                    no="0"+no;
                    kodeTF.setText("B"+no);}
                }
            else
            {
                kodeTF.setText("B001"); 
            }
            } catch (Exception e) 
            {
        }
    }
    
   private void simpan(){
        try{
            setKoneksi();
            String sql="insert into barang values('"+ kodeTF.getText() +"','" + namaCB.getSelectedItem()
                   +"','" + ukurCB.getSelectedItem()+ "','" + beliTF.getText()+"','" + jualTF.getText() + "','" + stokTF.getText()+"')";
            st.executeUpdate(sql); 
            JOptionPane.showMessageDialog(null,"Simpan data berhasil");
            }
            catch (Exception e) {
        }
        tampil();
    }
    
    private void perbarui(){
        try{
            setKoneksi();
            String sql="update barang set namabarang='"+namaCB.getSelectedItem()+"',ukuran='"+ukurCB.getSelectedItem()+
                   "',hargabeli='"+beliTF.getText()+"',hargajual='"+jualTF.getText()+ "',stok='"+stokTF.getText()+"' where kodebarang='"+kodeTF.getText()+"'";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Edit data berhasil","CV MASTER ABADI",JOptionPane.INFORMATION_MESSAGE);
        } 
        catch(Exception e){
        }
        tampil();
    }
    
   public void tampil(){
        Object header[]={"kodebarang","namabarang","ukuran","hargabeli","hargajual","stok"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        jTable1.setModel(data);
        setKoneksi();
        String sql="select*from barang";
        try {
            ResultSet rs=st.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                String kolom5=rs.getString(5);
                  String kolom6=rs.getString(6);
               
                
                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5,kolom6};
                data.addRow(kolom);
            }
        } catch (Exception e) {
        }
    }
    
    private void hapus(){
        try{
            String sql="delete from barang where kodebarang='"+ kodeTF.getText() +"'";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Hapus data sukses");
            }
            catch (Exception e) {
            }
        tampil();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jualTF = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        kodeTF = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        ukurCB = new javax.swing.JComboBox<>();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        stokTF = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        beliTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        namaCB = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cariTF = new javax.swing.JTextField();
        cariBT = new javax.swing.JButton();
        tambahBT = new javax.swing.JButton();
        simpanBT = new javax.swing.JButton();
        hapusBT = new javax.swing.JButton();
        editBT = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1160, 570));
        setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1160, 570));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data Master Barang");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 390, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 410, 10));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1160, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255)), "Silakan Input Data", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(102, 204, 255))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Stok                :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Kode Barang   :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nama Barang  :");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Ukuran            :");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Harga Jual       :");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jualTF.setBorder(null);
        jPanel3.add(jualTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 240, 30));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 340, 10));

        kodeTF.setBorder(null);
        kodeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeTFActionPerformed(evt);
            }
        });
        jPanel3.add(kodeTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 240, 30));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 340, 10));

        ukurCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----Pilih Ukuran-----", "1 Meter", "2 Meter", "3 Meter" }));
        ukurCB.setActionCommand("1 Meter\n2 Meter\n3 Meter");
        jPanel3.add(ukurCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 240, 30));
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 340, -1));
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 340, 10));

        stokTF.setBorder(null);
        jPanel3.add(stokTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 240, 30));
        jPanel3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 340, 10));

        beliTF.setBorder(null);
        beliTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beliTFActionPerformed(evt);
            }
        });
        jPanel3.add(beliTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 240, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Harga Beli        :");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));
        jPanel3.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 340, 10));

        namaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Pilih Barang----", "Tabung Gas $Alkses", "Medical /Industri Gas Insallation", "Crygenonic Medical/Industri Equipmens", "Oxygen Gas/Liquid(02)", "Nitrogen Gas /Liquid(N2)", "Argon Gas /Liquid(Ar)", "Carbon Dioxide Gas/Liquid(C02)", "Acetylene(C2H2)", "Nirous", "Helium(He)", "Carbon Monoxide(CO)", "Compressed Air", "Special Gases", "Mixed Gases", "Welding And Cutting Equipment", " ", " " }));
        namaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaCBActionPerformed(evt);
            }
        });
        jPanel3.add(namaCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 390, 290));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255)), "Table Data Barang", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(102, 204, 255)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(102, 102, 255));
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleName("");

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 80, 668, 190));
        jPanel4.add(cariTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 220, 30));

        cariBT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cariBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Cari2.png"))); // NOI18N
        cariBT.setText("CARI");
        cariBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cariBTMouseEntered(evt);
            }
        });
        cariBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariBTActionPerformed(evt);
            }
        });
        jPanel4.add(cariBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, -1, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 680, 290));

        tambahBT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tambahBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Tambah.png"))); // NOI18N
        tambahBT.setText("TAMBAH");
        tambahBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tambahBTMouseEntered(evt);
            }
        });
        tambahBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBTActionPerformed(evt);
            }
        });
        jPanel1.add(tambahBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, 110, 40));

        simpanBT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        simpanBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Simpan.png"))); // NOI18N
        simpanBT.setText("SIMPAN");
        simpanBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                simpanBTMouseEntered(evt);
            }
        });
        simpanBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanBTActionPerformed(evt);
            }
        });
        jPanel1.add(simpanBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 110, 40));

        hapusBT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hapusBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/trash.png"))); // NOI18N
        hapusBT.setText("HAPUS");
        hapusBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hapusBTMouseEntered(evt);
            }
        });
        hapusBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusBTActionPerformed(evt);
            }
        });
        jPanel1.add(hapusBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 390, 110, 40));

        editBT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        editBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Edit.png"))); // NOI18N
        editBT.setText("EDIT");
        editBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editBTMouseEntered(evt);
            }
        });
        editBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBTActionPerformed(evt);
            }
        });
        jPanel1.add(editBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, 110, 40));

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

    private void kodeTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodeTFActionPerformed

    private void tambahBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBTActionPerformed
        // TODO add your handling code here:
        if(tambahBT.getText().equalsIgnoreCase("tambah")){
            tambahBT.setText("Batal");
            //bersih();
            siapIsi(true);
            otomatis();
            
            kodeTF.setEnabled(false);
            tambahBT.setEnabled(true);
            simpanBT.setEnabled(true);
            hapusBT.setEnabled(false);
            editBT.setEnabled(false);
           
            cariBT.setEnabled(true);
        } else{
            tambahBT.setText("Tambah");
            bersih();
            siapIsi(false);
            tombolNormal();
        
    }                     
    }//GEN-LAST:event_tambahBTActionPerformed

    private void simpanBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBTActionPerformed
        // TODO add your handling code here:
        if(kodeTF.getText().isEmpty() ||namaCB.getSelectedItem().equals("")||ukurCB.getSelectedItem().equals("")||beliTF.getText().isEmpty()||jualTF.getText().isEmpty()||stokTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Lengkapi inputan data","CV MASTER ABDI",JOptionPane.INFORMATION_MESSAGE);
        } else{

            if(tambahBT.getText().equalsIgnoreCase("batal")){
                if(tambahBT.getText().equalsIgnoreCase("batal")){
                    simpan();
                } else{
                    JOptionPane.showMessageDialog(null, "Simpan data gagal, periksa kembali","CV MASTER ABDI",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if(editBT.getText().equalsIgnoreCase("batal")){
                if(editBT.getText().equalsIgnoreCase("batal")){
                    perbarui();
                } else{
                    JOptionPane.showMessageDialog(null, "Edit data gagal, periksa kembali","CV MASTER ABDI",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            bersih();
            siapIsi(false);
            tambahBT.setText("Tambah");
            editBT.setText("Edit");
            
            tombolNormal();
            
        }
    }//GEN-LAST:event_simpanBTActionPerformed

    private void editBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBTActionPerformed
        // TODO add your handling code here:
        if(editBT.getText().equalsIgnoreCase("edit")){
            editBT.setText("Batal");
            siapIsi(true);
            kodeTF.setEnabled(false);
            stokTF.setEnabled(true);
            
            tambahBT.setEnabled(false);
            simpanBT.setEnabled(true);
            hapusBT.setEnabled(false);
            editBT.setEnabled(true);
           
            cariBT.setEnabled(false);
        } else{
            editBT.setText("Edit");
            bersih();
            siapIsi(false);
            tombolNormal();
        }
    }//GEN-LAST:event_editBTActionPerformed

    private void hapusBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusBTActionPerformed
        // TODO add your handling code here:
         int pesan=JOptionPane.showConfirmDialog(null, "Yakin data akan dihapus ?","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(pesan==JOptionPane.YES_OPTION){
            if(pesan==JOptionPane.YES_OPTION){
                hapus();
                bersih();
                siapIsi(false);
                tombolNormal();
            } else{
                JOptionPane.showMessageDialog(null, "Hapus data gagal");
            }
            tampil();
        }
    }//GEN-LAST:event_hapusBTActionPerformed

    private void cariBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariBTActionPerformed
        // TODO add your handling code here:
          Object header[]={"kodebarang","namabarang","ukuran","hargabeli","hargajual","stok"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        jTable1.setModel(data);
        setKoneksi();
        String sql="Select * from barang where kodebarang like '%" + cariTF.getText() + "%'" + "or namabarang like '%" + cariTF.getText()+ "%'";
        try {
            ResultSet rs=st.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                String kolom5=rs.getString(5);
                 String kolom6=rs.getString(6);
               
                 
                
                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5,kolom6};
                data.addRow(kolom);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cariBTActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         int baris = jTable1.getSelectedRow();
        kodeTF.setText(jTable1.getModel().getValueAt(baris, 0).toString());
       
        namaCB.setSelectedItem(jTable1.getModel().getValueAt(baris, 1).toString());
        ukurCB.setSelectedItem(jTable1.getModel().getValueAt(baris, 2).toString());
          beliTF.setText(jTable1.getModel().getValueAt(baris, 3).toString());
            jualTF.setText(jTable1.getModel().getValueAt(baris, 4).toString());
        
        stokTF.setText(jTable1.getModel().getValueAt(baris, 5).toString());
      
        hapusBT.setEnabled(true);
        editBT.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void beliTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_beliTFActionPerformed

    private void namaCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaCBActionPerformed
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_namaCBActionPerformed

    private void tambahBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahBTMouseEntered
        // TODO add your handling code here:
         tambahBT.setBackground(new Color(102,204,255));
        tambahBT.setForeground(Color.black);
    }//GEN-LAST:event_tambahBTMouseEntered

    private void simpanBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanBTMouseEntered
        // TODO add your handling code here:
         simpanBT.setBackground(new Color(102,204,255));
        simpanBT.setForeground(Color.black);
    }//GEN-LAST:event_simpanBTMouseEntered

    private void editBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBTMouseEntered
        // TODO add your handling code here:
         editBT.setBackground(new Color(102,204,255));
        editBT.setForeground(Color.black);
    }//GEN-LAST:event_editBTMouseEntered

    private void hapusBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusBTMouseEntered
        // TODO add your handling code here:
         hapusBT.setBackground(new Color(0,153,153));
        hapusBT.setForeground(Color.black);
    }//GEN-LAST:event_hapusBTMouseEntered

    private void cariBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cariBTMouseEntered
        // TODO add your handling code here:
         tambahBT.setBackground(new Color(102,204,255));
        tambahBT.setForeground(Color.black);
    }//GEN-LAST:event_cariBTMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField beliTF;
    private javax.swing.JButton cariBT;
    private javax.swing.JTextField cariTF;
    private javax.swing.JButton editBT;
    private javax.swing.JButton hapusBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jualTF;
    private javax.swing.JTextField kodeTF;
    private javax.swing.JComboBox<String> namaCB;
    private javax.swing.JButton simpanBT;
    private javax.swing.JTextField stokTF;
    private javax.swing.JButton tambahBT;
    private javax.swing.JComboBox<String> ukurCB;
    // End of variables declaration//GEN-END:variables
public Connection setKoneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/papantulis","root","");
            st=conn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Koneksi Gagal :" +e);
        }
       return conn; 
    }


}
