/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MembersFile;

/**
 *
 * @author Wanjiru Silvester
 */
public class ContactDetails {
    
    private String phone1;
    private String phone2;
    private String address;
    private int code;
    private String location;
    private String email;

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ContactDetails(String phone1, String phone2, String address, int code, String location, String email) {
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.address = address;
        this.code = code;
        this.location = location;
        this.email = email;
    }

    public ContactDetails(String phone1, String address, int code, String location, String email) {
        this.phone1 = phone1;
        this.address = address;
        this.code = code;
        this.location = location;
        this.email = email;
    }
    
    
    
}
