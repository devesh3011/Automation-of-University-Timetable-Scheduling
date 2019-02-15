/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts_tchr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import static tts_tchr.cred.path;
import static tts_tchr.cred.place;
import static tts_tchr.cred.uname;

/**
 *
 * @author Ekam
 */
public class EnterSubPref extends javax.swing.JInternalFrame implements cred{

    /**
     * Creates new form EnterSubPref
     */
    private int count =0;
    boolean disp = false; // flag to dispose of frame if there is No subject.
    public EnterSubPref() {
        initComponents();
        try{
//            Connection con = DriverManager.getConnection(path+place, uname, pass);
            if(TchrMain.con == null){
                TchrMain.con = DriverManager.getConnection(path+place, uname, pass);       
            }
            try{
                String str = "select * from SUBJECT where DEPARTMENT = ? ";
                PreparedStatement mystate = TchrMain.con.prepareStatement(str);
//                mystate.setString(1,"CSE");
                mystate.setString(1,TTS_Tchr.udept);
                ResultSet myres = mystate.executeQuery();
//                int count = 0;
                if(myres.next())
                {
                    do{
                        String code = myres.getString("CODE");
                        String name = myres.getString("NAME");
                        jComboBox1.addItem(code+","+name);
                        jComboBox2.addItem(code+","+name);
                        jComboBox3.addItem(code+","+name);
                        jComboBox4.addItem(code+","+name);
                        jComboBox5.addItem(code+","+name);
                        count++;
                    }
                    while(myres.next());
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "No Subject of your Dept Found");
                    this.setVisible(false);
                    disp = true;
//                    this.dispose();

//                    return;
                }
                
                hideExtraComboBox();
                
            }catch(Exception ex){
//                JOptionPane.showMessageDialog(rootPane,ex.getMessage());
//                System.out.println(ex.getStackTrace());
                disp=true;
                throw ex;
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane,"Error Connection "+ex.getMessage());
//            System.out.println(ex.getStackTrace());
            ex.printStackTrace();
            disp=true;
        }        
        
        jComboBox2.setEnabled(false);
        jComboBox3.setEnabled(false);
        jComboBox4.setEnabled(false);
        jComboBox5.setEnabled(false);
        jButton1.setEnabled(false);
//        this.setBounds(TchrMain.jDesktopPane1.getX(),TchrMain.jDesktopPane1.getY(),jDesktopPane1.getWidth(),jDesktopPane1.getHeight());
//        System.out.println(jDesktopPane1.getWidth());
    }
    private void hideExtraComboBox(){
        if(count == 1){
                    jComboBox2.setVisible(false);
                    jComboBox3.setVisible(false);
                    jComboBox4.setVisible(false);
                    jComboBox5.setVisible(false);

                    jLabel2.setVisible(false);
                    jLabel3.setVisible(false);
                    jLabel4.setVisible(false);
                    jLabel5.setVisible(false);
                }
                else if(count ==2){
                    jComboBox3.setVisible(false);
                    jComboBox4.setVisible(false);
                    jComboBox5.setVisible(false);

                    jLabel3.setVisible(false);
                    jLabel4.setVisible(false);
                    jLabel5.setVisible(false);
                }else if(count ==3){
                    jComboBox4.setVisible(false);
                    jComboBox5.setVisible(false);

                    jLabel4.setVisible(false);
                    jLabel5.setVisible(false);
                }
                else if(count ==4){
                    jComboBox5.setVisible(false);
                    
                    jLabel5.setVisible(false);
                }
    }
    
    private String getCode(String item){
        return item.substring(0, item.indexOf(","));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Enter/Edit Preference");
        setRequestFocusEnabled(false);
        setVisible(true);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Subject" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Preference 2");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Subject" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Preference 3");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Subject" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Preference 4");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Subject" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel5.setText("Preference 5");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Subject" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jButton1.setText("FINISH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Preference 1");

        jDesktopPane1.setLayer(jComboBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jComboBox2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jComboBox3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jComboBox4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jComboBox5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(73, 73, 73))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jButton1)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jDesktopPane1)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String pref = "";
        pref = getCode(jComboBox1.getSelectedItem().toString());
        if(count>1){
            pref = pref +","+ getCode(jComboBox2.getSelectedItem().toString());
        }
        if(count>2){
            pref = pref +","+ getCode(jComboBox3.getSelectedItem().toString());
        }
        if(count>3){
            pref = pref +","+ getCode(jComboBox4.getSelectedItem().toString());
        }
        if(count>4){
            pref = pref +","+ getCode(jComboBox5.getSelectedItem().toString());
        }

        try{
//            Connection con = DriverManager.getConnection(path+place, uname, pass);
            try{
                if(TchrMain.con == null){
                    TchrMain.con = DriverManager.getConnection(path+place, uname, pass);       
                }
                String str = "UPDATE TEACHER SET SUBPREF = ? WHERE CODE = ? ";
                PreparedStatement mystate = TchrMain.con.prepareStatement(str);
                mystate.setString(1,pref);
                mystate.setString(2,TTS_Tchr.ucode);
//                mystate.setString(1,TTS_Tchr.udept);
                mystate.executeUpdate();
//                int count = 0;
                JOptionPane.showMessageDialog(rootPane,"ADDED SUCCESSFULLY");
                
                this.dispose();
                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane,"Error Updating Query "+ex.getMessage());
//                System.out.println(ex.getStackTrace());
                ex.printStackTrace();
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane,"Error Connection "+ex.getMessage());
//            System.out.println(ex.getStackTrace());
            ex.printStackTrace();
        }        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if(jComboBox1.getSelectedIndex()==0)
            return ;
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(true);
        jComboBox2.removeItem(jComboBox1.getSelectedItem());
        jComboBox3.removeItem(jComboBox1.getSelectedItem());
        jComboBox4.removeItem(jComboBox1.getSelectedItem());
        jComboBox5.removeItem(jComboBox1.getSelectedItem());
        if(count ==1){
            jButton1.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        if(jComboBox2.getSelectedIndex()==0)
            return ;
        jComboBox2.setEnabled(false);
        jComboBox3.setEnabled(true);

        jComboBox3.removeItem(jComboBox2.getSelectedItem());
        jComboBox4.removeItem(jComboBox2.getSelectedItem());
        jComboBox5.removeItem(jComboBox2.getSelectedItem());
        if(count ==2){
            jButton1.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        
        if(jComboBox3.getSelectedIndex()==0)
            return ;
        jComboBox3.setEnabled(false);
        jComboBox4.setEnabled(true);
        
        jComboBox4.removeItem(jComboBox3.getSelectedItem());
        jComboBox5.removeItem(jComboBox3.getSelectedItem());
        if(count ==3){
            jButton1.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
        if(jComboBox4.getSelectedIndex()==0)
            return ;
        jComboBox4.setEnabled(false);
        jComboBox5.setEnabled(true);
        
        jComboBox5.removeItem(jComboBox4.getSelectedItem());
        if(count ==4){
            jButton1.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox4ActionPerformed

    
    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
        if(jComboBox5.getSelectedIndex()==0)
            return ;
        jComboBox5.setEnabled(false);
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jComboBox5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}