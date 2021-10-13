package at.htl.entities;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlSchema;

@Schema(description = "Danceclass(es) for Dancegroups")
@Entity
@Table(name="DANCECLASS")
public class DanceClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(required = true)
    @JsonbProperty("time")
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
