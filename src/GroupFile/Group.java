/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupFile;

/**
 *
 * @author Wanjiru Silvester
 */
public class Group {
    
    private int groupId;
    private String name;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public Group(int groupId, String name){
        setGroupId(groupId);
        setName(name);
    }
    
}
