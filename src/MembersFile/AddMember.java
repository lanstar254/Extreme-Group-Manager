/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MembersFile;

import DbConnection.DbConnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
/**
 *
 * @author Wanjiru Silvester
 */
public class AddMember {
    
    private Connection con;
    private Members member;

    public Members getMember() {
        return member;
    }

    public void setMember(Members member) {
        this.member = member;
    }
    
    public AddMember(Members member){
        setMember(member);
        con = DbConnect.createConnection();
        //if(getMember().getMember().getPhoto().equals(null)){
            addWithoutPhoto(getMember());
        //}else{
            //addWithPhoto(getMember());
       // }
        DbConnect.closeConnection();
    }
    
    
    public boolean addWithPhoto(Members members){
        PreparedStatement st = null;
        try{
            String insertWithPhoto = "INSERT INTO memberstable(idnumber,surname,fname,lname,dob,photo,gender,phon1,phon2,address,code,location,email)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            st = con.prepareStatement(insertWithPhoto);
            st.setInt(1,members.getMember().getIdNo());
            st.setString(2,members.getMember().getSurname());
            st.setString(3,members.getMember().getfName());
            st.setString(4,members.getMember().getlName());
            st.setString(5, members.getMember().getDob().toString());
            st.setBlob(6, members.getMember().getPhoto());
            st.setString(7,members.getMember().getGender());
            st.setString(8,members.getContDetails().getPhone1());
            st.setString(9,members.getContDetails().getPhone2());
            st.setString(10,members.getContDetails().getAddress());
            st.setInt(11,members.getContDetails().getCode());
            st.setString(12,members.getContDetails().getLocation());
            st.setString(13,members.getContDetails().getEmail());
            
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
    
    public boolean addWithoutPhoto(Members members){
        PreparedStatement st = null;
        try{
            String insertWithoutPhoto = "INSERT INTO memberstable(idnumber,surname,fname,lname,dob,gender,phon1,phon2,address,code,location,email)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            st = con.prepareStatement(insertWithoutPhoto);
            st.setInt(1,members.getMember().getIdNo());
            st.setString(2,members.getMember().getSurname());
            st.setString(3,members.getMember().getfName());
            st.setString(4,members.getMember().getlName());
            st.setString(5,members.getMember().getDob().toString());
            //st.setBlob(6, members.getMember().getPhoto());
            st.setString(6,members.getMember().getGender());
            st.setString(7,members.getContDetails().getPhone1());
            st.setString(8,members.getContDetails().getPhone2());
            st.setString(9,members.getContDetails().getAddress());
            st.setInt(10,members.getContDetails().getCode());
            st.setString(11,members.getContDetails().getLocation());
            st.setString(12,members.getContDetails().getEmail());
          
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
    
    /*public boolean addKins(NextOfKin kin){
        PreparedStatement st = null;
        try{
            String insertKins = "INSERT INTO kins(IdNumber,surname,fname,lname,dob,rship,gender,notes)"
                    + "VALUES(?,?,?,?,?,?,?,?)";
            st = con.prepareStatement(insertKins);
            st.setInt(1,member.getMemberId());
            st.setString(2,kin.getSurname());
            st.setString(3,kin.getfName());
            st.setString(4,kin.getlName());
            st.setDate(5,(Date) kin.getDob());
            st.setString(6,kin.getRship());
            st.setString(7,kin.getGender());
            st.setString(8,kin.getNotes());
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
        try{
        }catch(Exception e){
            e.printStackTrace();
        }
        }
    }*/
}
