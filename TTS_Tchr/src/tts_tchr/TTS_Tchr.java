/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts_tchr;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Ekam
 */
public class TTS_Tchr implements cred{

    /**
     * @param args the command line arguments
     */
    public static String uname = "";
    public static String ucode = "";
    public static String udept = "";
//    public static Connection con ;//= DriverManager.getConnection(path+place, uname, pass);
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        Login obj = new Login();
        obj.setVisible(true);
        
//        try{
//            Connection con = DriverManager.getConnection(path+place, uname, pass);
//        }catch(Exception e){
//            System.out.println("Unable to connect to AWS");
//            e.printStackTrace();
////            JOptionPane.showMessageDialog(rootpane, e.);
//        }
//        
    }
    
}
