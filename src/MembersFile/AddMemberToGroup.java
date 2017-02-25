/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MembersFile;

import DbConnection.DbConnect;
import GroupFile.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Wanjiru Silvester
 */
public class AddMemberToGroup {
    
    private Connection con;
    private Members member;
    private Group group;

    public Members getMember() {
        return member;
    }

    public void setMember(Members member) {
        this.member = member;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    
    
    public AddMemberToGroup(Members member,Group group){
        con = DbConnect.createConnection();
        if(add(group,member)){
            JOptionPane.showMessageDialog(null,"Members added successfully.","Member Add.", JOptionPane.OK_OPTION);
        }else{
             JOptionPane.showMessageDialog(null,"Member not added.","Member Adds.", JOptionPane.OK_OPTION);
        }
        DbConnect.closeConnection();
    }
    
    public boolean add(Group group,Members member){
         PreparedStatement st = null;
        try{
            st = con.prepareStatement("INSERT INTO groupMembers(name)VALUES(?,?)");
            st.setInt(1,group.getGroupId());
            st.setInt(2,member.getMemberId());
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
