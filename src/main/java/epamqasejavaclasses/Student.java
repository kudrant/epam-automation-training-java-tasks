package epamqasejavaclasses;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Student {
    private int id;
    private String lastName;
    private String name;
    private String secondName;
    private Date birthDate;
    private String address;
    private String phoneNo;
    private Faculty faculty;
    private int course;
    private int group;

    public Student(int id, String lastName, String name) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
    }

    public Student(int id, String lastName, String name, Date birthDate) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Student(int id, String lastName, String name, String secondName, Date birthDate, String address, String phoneNo, Faculty faculty, int course, int group) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNo = phoneNo;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        return "Student " + lastName + " " + name +
                ", Date of birth = " + format.format(birthDate) +
                ", Faculty = " + faculty;
    }
}
