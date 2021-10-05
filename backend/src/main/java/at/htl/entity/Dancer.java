package at.htl.entity;

public class Dancer {
    private String name;
    private String address;
    private int age;

    public Dancer(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAlter(){return age;}

    @Override
    public String toString() {
        return "dancer: " + this.name + " address: " + this.address + " age: " + this.age;
    }
}
