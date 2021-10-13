package at.htl.entities;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.*;

@Schema(description = "Rooms for Danceclasses")
@Entity
@Table(name="ROOM")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(required = true)
    @JsonbProperty("number")
    @Column(name="NUBMER")
    private int number;

    @Schema(required = true)
    @JsonbProperty("personlimit")
    @Column(name = "PERSONLIMIT")
    private int personLimit;

    @OneToOne
    private DanceClass danceClass;

    public Room(long id, int number, int personLimit) {
        this.id = id;
        this.number = number;
        this.personLimit = personLimit;
    }

    public Room(int number, int personLimit) {
        this.number = number;
        this.personLimit = personLimit;
    }

    public Room() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPersonLimit() {
        return personLimit;
    }

    public void setPersonLimit(int personLimit) {
        this.personLimit = personLimit;
    }
}
