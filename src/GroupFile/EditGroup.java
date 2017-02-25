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
public class EditGroup {
    
    private Group edit;
    private Connection con;

    public Group getEdit() {
        return edit;
    }

    public void setEdit(Group edit) {
        this.edit = edit;
    }

    
    public EditGroup(Group edit){
        DbConnect.createConnection();
        setEdit(edit);
        if(edit(getEdit())){
             JOptionPane.showMessageDialog(null,"Group edit successfully.","Groups.",JOptionPane.OK_OPTION);
        }else{
             JOptionPane.showMessageDialog(null,"Group edit not done.","Groups.",JOptionPane.OK_OPTION);
        }
        DbConnect.closeConnection();
    }
    
     public boolean edit(Group group){
        PreparedStatement st = null;
        try{
            st = con.prepareStatement("UPDATE groups SET name='"+group.getName()+"' WHERE groupid=?");
            st.setInt(1,group.getGroupId());
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
