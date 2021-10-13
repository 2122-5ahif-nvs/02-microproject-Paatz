package at.htl.entities;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.graalvm.nativeimage.c.struct.CField;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.*;
import javax.ws.rs.Consumes;

@Schema(description = "Dancers for Dancegroup")
@Entity
@Table(name="DANCER")
public class Dancer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(required = true)
    @JsonbProperty("firstname")
    @Column(name="FIRSTNAME")
    private String firstname;

    @Schema(required = true)
    @JsonbProperty("lastname")
    @Column(name="LASTNAME")
    private String lastName;

    @Schema(required = true)
    @JsonbProperty("address")
    @Column(name="ADDRESS")
    private String address;

    @Schema(required = true)
    @JsonbProperty("age")
    @Column(name="AGE")
    private int age;

    @ManyToOne
    private DanceGroup danceGroup;

    public Dancer(String firstname, String lastName, String address, int age) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
    }

    public Dancer(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
