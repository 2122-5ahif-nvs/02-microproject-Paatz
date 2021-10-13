package at.htl.entities;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.*;

@Schema(description = "Dancegroup for Dancers")
@Entity
@Table(name="DANCE_GROUP")
public class DanceGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(required = true)
    @JsonbProperty("name")
    @Column(name = "NAME")
    private String name;

    @Schema(required = true)
    @JsonbProperty("age_limit")
    @Column(name = "AGE_LIMIT")
    private int ageLimit;

    @Schema(required = true)
    @JsonbProperty("dancer_limit")
    @Column(name = "DANCER_LIMIT")
    private int dancerLimit;

    public DanceGroup(String name, int ageLimit, int dancerLimit) {
        this.name = name;
        this.ageLimit = ageLimit;
        this.dancerLimit = dancerLimit;
    }

    public DanceGroup(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public int getDancerLimit() {
        return dancerLimit;
    }

    public void setDancerLimit(int dancerLimit) {
        this.dancerLimit = dancerLimit;
    }
}
