/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts_tchr;

/**
 *
 * @author Ekam
 */
public interface cred {
    String path= "jdbc:mysql://timetabledb.cxbjxadaowmd.us-east-2.rds.amazonaws.com/";
    String place="ttdb";
    String uname= "TTSDB";
    String pass= "ttsdb12345";
    
}


//mysql -h timetabledb.cxbjxadaowmd.us-east-2.rds.amazonaws.com -P 3306 -u TTSDB -p