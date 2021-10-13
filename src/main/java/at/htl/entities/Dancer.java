package at.htl.entities;

import org.graalvm.nativeimage.c.struct.CField;

import javax.persistence.*;
import javax.ws.rs.Consumes;

@Entity
@Table(name="DANCER")
public class Dancer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="FIRSTNAME")
    private String firstname;

    @Column(name="LASTNAME")
    private String lastName;

    @Column(name="ADDRESS")
    private String address;

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
