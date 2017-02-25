/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupFile;

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import DbConnection.DbConnect;

/**
 *
 * @author Wanjiru Silvester
 */
public class AddGroup {
    
    private Connection con;
    private Group group;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    
    
    public AddGroup(Group group){
        con = DbConnect.createConnection();
        setGroup(group);
        if(add(getGroup())){
            JOptionPane.showMessageDialog(null,"Group added successfully.","Groups.",JOptionPane.OK_OPTION);
        }else{
            JOptionPane.showMessageDialog(null,"Group not added.","Groups.",JOptionPane.ERROR_MESSAGE);
        }
        DbConnect.closeConnection();
    }
    
    public boolean add(Group group){
        PreparedStatement st = null;
        try{
            st = con.prepareStatement("INSERT INTO groups(name)VALUES(?)");
            st.setString(1,group.getName());
            st.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
         try{
             st.close();
         }catch(Exception e){
          e.printStackTrace();
         } 
        }
    }
}
