/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Wanjiru Silvester
 */
public class DbConnect {
    
    private static Connection con;
    
    public static Connection createConnection(){
		String url="jdbc:mysql://127.0.0.1/egm_db";
		String username="root";
		String password = "WANJIRU";
		try{
			con = DriverManager.getConnection(url,username,password);
			//JOptionPane.showMessageDialog(null,"Connection successful");
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"No connection"+e.getMessage());
		}
		return con;
	}
    
    
    public static void closeConnection(){
        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String [] args){
        DbConnect.createConnection();
    }
    
}
