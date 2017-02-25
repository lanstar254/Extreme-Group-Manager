package MembersFile;




import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Members {
    
    private int memberId;
    private Person member;
    private ContactDetails contDetails;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Person getMember() {
        return member;
    }

    public void setMember(Person member) {
        this.member = member;
    }

    public ContactDetails getContDetails() {
        return contDetails;
    }

    public void setContDetails(ContactDetails contDetails) {
        this.contDetails = contDetails;
    }


    public Members(int memberId, Person member, ContactDetails contDetails) {
        this.memberId = memberId;
        this.member = member;
        this.contDetails = contDetails;
       
    }    
}
