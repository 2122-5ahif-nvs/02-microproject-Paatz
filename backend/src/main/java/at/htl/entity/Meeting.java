package at.htl.entity;

public class Meeting {
    private String day;

    public Meeting (String day){
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "day: " + this.day;
    }
}
