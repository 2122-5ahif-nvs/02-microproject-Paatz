package at.htl.repository;

import at.htl.entity.Group;

import javax.enterprise.context.ApplicationScoped;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class RepositoryGroup {

    private static RepositoryGroup instance;
    private List<Group> groups;

    private RepositoryGroup(){
        groups = createGroups();
    }

    private List<Group> createGroups() {
        List<Group> groupList = new LinkedList<>();

        groupList.add(new Group("SwingAndSing"));
        groupList.add(new Group("HipHopEnergy"));
        groupList.add(new Group("MoveAndShake"));
        return groupList;
    }

   public static RepositoryGroup getInstance(){
        if(instance == null){
            instance = new RepositoryGroup();
        }
        return instance;
    }

    public List<Group> getGroups(){
        return this.groups;
    }

    public Group removeGroup(String name) {
        Group deletedGroup = new Group("null");
        for (Group g : groups) {
            if (g.getGroupName().equals(name)) {
                deletedGroup = g;
                groups.remove(g);
            }
        }
        return deletedGroup;
    }

    public Group addGroup(String name){
        Group addGroup = new Group(name);
        groups.add(addGroup);
        return addGroup;
    }

    public Group UpdateGroup(Group findGroupToUpdate, String name) {
        Group updatedGroup = new Group("null");
        for (Group currentGroup : groups){
            if(currentGroup.getGroupName().equals(findGroupToUpdate.getGroupName())){
                currentGroup.setGroupName(name);
                updatedGroup = currentGroup;
            }
        }
        return updatedGroup;
    }
}
