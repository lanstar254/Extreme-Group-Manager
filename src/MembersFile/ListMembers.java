/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MembersFile;

import DbConnection.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.LinkedList;

/**
 *
 * @author Wanjiru Silvester
 */
public class ListMembers {
    
    private Connection con;
    private LinkedList<Members> membersList;

    public LinkedList<Members> getMembersList() {
        return membersList;
    }

    public void setMembersList(LinkedList<Members> membersList) {
        this.membersList = membersList;
    }
    
    
    
    public ListMembers(){
        con = DbConnect.createConnection();
        membersList = new LinkedList<Members>();
        DbConnect.createConnection();
        getAllMembers();
        DbConnect.closeConnection();
    }
    
    public void getAllMembers(){
        PreparedStatement st = null;
        ResultSet rs= null;
        LinkedList<Members> list = new LinkedList<Members>();
        try{
            st = con.prepareStatement("SELECT * FROM memberstable");
            rs = st.executeQuery();
            while(rs.next()){
                //int memberId, Person member, ContactDetails contDetails, EmploymentDetails empDetails, ArrayList<NextOfKin> kins
                //int idNo, String surname, String fName, String lName, Date dob, Blob photo, String gender
                Person person = new Person(rs.getInt("memberstable.Memberid"),rs.getString("memberstable.surname"),rs.getString("memberstable.fname"),
                rs.getString("memberstable.lname"),rs.getDate("memberstable.dob"),rs.getString("memberstable.gender"));
                //String phone1, String phone2, String address, int code, String location, String email
                ContactDetails details = new ContactDetails(rs.getString("memberstable.phon1"),rs.getString("memberstable.phon2"),rs.getString("memberstable.address"),
                        rs.getInt("memberstable.code"),rs.getString("memberstable.location"),rs.getString("memberstable.email"));
                //boolean isEmployed, Employer employer, Categories department--->>Employement details class;
                //int catId, Employer employer, String catName---->>Categories
                //int empId, String empName, String address, int code, String town, int retireAge, String contact, String email---->>Employment class
                //int memberId, Person member, ContactDetails contDetails, EmploymentDetails empDetails, ArrayList<NextOfKin> kins--->>Members
              
                list.add(new Members(rs.getInt("memberstable.memberId"),person,details));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                st.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static Members search(int membersId){
         PreparedStatement st = null;
        ResultSet rs= null;
        Connection con = DbConnect.createConnection();
        try{
            st = con.prepareStatement("SELECT * FROM memberstable WHERE memberstable.membersId=?");
            rs = st.executeQuery();
            while(rs.next()){
                //int memberId, Person member, ContactDetails contDetails, EmploymentDetails empDetails, ArrayList<NextOfKin> kins
                //int idNo, String surname, String fName, String lName, Date dob, Blob photo, String gender
                Person person = new Person(rs.getInt("memberstable.id"),rs.getString("memberstable.surname"),rs.getString("memberstable.fname"),
                rs.getString("memberstable.lname"),rs.getDate("memberstable.dob"),rs.getString("memberstable.gender"));
                //String phone1, String phone2, String address, int code, String location, String email
                ContactDetails details = new ContactDetails(rs.getString("memberstable.phon1"),rs.getString("memberstable.phon2"),rs.getString("memberstable.address"),
                        rs.getInt("memberstable.code"),rs.getString("memberstable.location"),rs.getString("memberstable.email"));
                //boolean isEmployed, Employer employer, Categories department--->>Employement details class;
                //int catId, Employer employer, String catName---->>Categories
                //int empId, String empName, String address, int code, String town, int retireAge, String contact, String email---->>Employment class
                //int memberId, Person member, ContactDetails contDetails, EmploymentDetails empDetails, ArrayList<NextOfKin> kins--->>Members
                return new Members(rs.getInt("memberstable.memberId"),person,details);
            }
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            try{
                st.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
