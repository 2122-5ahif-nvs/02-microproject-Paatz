package at.htl.entities;

import javax.persistence.*;

@Entity
@Table(name="DANCECLASS")
public class DanceClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "TIME")
    private String time;

    @ManyToOne
    private DanceGroup danceGroup;

    public DanceClass(String time) {
        this.time = time;
    }

    public DanceClass() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
