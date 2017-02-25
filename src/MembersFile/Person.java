/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MembersFile;

import java.sql.Blob;
import java.util.Date;

/**
 *
 * @author Wanjiru Silvester
 */
public class Person {
    
    private int idNo;
    private String surname;
    private String fName;
    private String lName;
    private Date dob;
    private Blob photo;
    private String gender;
    
    
    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getName(){
        return String.format("%s %s %s", getSurname(),getfName(),getlName());
    }

    public Person(int idNo, String surname, String fName, String lName, Date dob, Blob photo, String gender) {
        this.idNo = idNo;
        this.surname = surname;
        this.fName = fName;
        this.lName = lName;
        this.dob = dob;
        this.photo = photo;
        this.gender = gender;
    }

    public Person(int idNo, String surname, String fName, String lName, Date dob, String gender) {
        this.idNo = idNo;
        this.surname = surname;
        this.fName = fName;
        this.lName = lName;
        this.dob = dob;
        this.gender = gender;
    }
    
    
    
}
