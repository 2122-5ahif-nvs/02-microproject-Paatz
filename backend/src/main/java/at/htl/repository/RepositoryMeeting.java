package at.htl.repository;

import at.htl.entity.Meeting;

import javax.enterprise.context.ApplicationScoped;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class RepositoryMeeting {
    private static RepositoryMeeting instance;
    private List<Meeting> meetings;

    private RepositoryMeeting(){
        meetings = createMeetings();
    }

    private List<Meeting> createMeetings() {
        List<Meeting> meetingList = new LinkedList<>();
        meetingList.add(new Meeting("Montag"));
        meetingList.add(new Meeting("Dienstag"));
        meetingList.add(new Meeting("Mittwoch"));
        meetingList.add(new Meeting("Donnerstag"));
        meetingList.add(new Meeting("Friday"));

        return meetingList;
    }

   public static RepositoryMeeting getInstance(){
        if(instance == null){
            instance = new RepositoryMeeting();
        }
        return instance;
    }

    public List<Meeting> getMeetings(){
        return this.meetings;
    }

    public Meeting removeMeeting(String name) {
        Meeting deleteMeeting = new Meeting("null");
        for (Meeting currentMeeting : meetings) {
            if (currentMeeting.getDay().equals(name)) {
                deleteMeeting = currentMeeting;
                meetings.remove(currentMeeting);
            }
        }
        return deleteMeeting;
    }

    public Meeting addMeeting(String name){
        Meeting addMeeting = new Meeting(name);
        meetings.add(addMeeting);
        return addMeeting;
    }

    public Meeting UpdateMeeting(Meeting findMeetingToUpdate, String day) {
        Meeting updatedMeeting = new Meeting("null");
        for (Meeting currentMeeting : meetings){
            if(currentMeeting.getDay().equals(findMeetingToUpdate.getDay())){
                currentMeeting.setDay(day);
                updatedMeeting = currentMeeting;
            }
        }
        return updatedMeeting;
    }
}
