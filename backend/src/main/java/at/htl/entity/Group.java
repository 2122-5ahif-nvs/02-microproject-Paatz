package at.htl.entity;

public class Group {
    private int id;
    private String groupName;
    private static int counter = 0;

    public Group(String groupName){
        this.id = counter++;
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id: " + this.id + " groupName: " + this.groupName;
    }
}
