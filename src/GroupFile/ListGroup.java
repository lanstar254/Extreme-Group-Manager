/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupFile;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DbConnection.DbConnect;

/**
 *
 * @author Wanjiru Silvester
 */
public class ListGroup {
    
    private Connection con;
    private ArrayList<Group> grpList;

    public ArrayList<Group> getGrpList() {
        return grpList;
    }

    public void setGrpList(ArrayList<Group> grpList) {
        this.grpList = grpList;
    }
    
    public ListGroup(){
        con = DbConnect.createConnection();
        groupsList();
        DbConnect.closeConnection();
    }
    
    public void groupsList(){
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Group> list = new ArrayList<Group>();
        try{
            String sqlQuery="SELECT * FROM groups";
            st = con.prepareStatement(sqlQuery);
            rs= st.executeQuery();
            while(rs.next()){
                list.add(new Group(rs.getInt("groupId"),rs.getString("name")));
            }
            setGrpList(list);
        }catch(Exception e){
        }finally{
            try{
                rs.close();
                st.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static Group search(String name){
         PreparedStatement st = null;
        ResultSet rs = null;
        Connection con = DbConnect.createConnection();
        try{
            String sqlQuery="SELECT * FROM groups WHERE name=?";
            st = con.prepareStatement(sqlQuery);
            st.setString(1,name);
            rs= st.executeQuery();
            while(rs.next()){
                return new Group(rs.getInt("groupId"),rs.getString("name"));
            }
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            try{
                rs.close();
                st.close();
                DbConnect.closeConnection();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
     public static Group search(int groupId){
         PreparedStatement st = null;
        ResultSet rs = null;
        Connection con = DbConnect.createConnection();
        try{
            String sqlQuery="SELECT * FROM groups WHERE groupId=?";
            st = con.prepareStatement(sqlQuery);
            st.setInt(1,groupId);
            rs= st.executeQuery();
            while(rs.next()){
                return new Group(rs.getInt("groupId"),rs.getString("name"));
            }
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            try{
                rs.close();
                st.close();
                DbConnect.closeConnection();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
