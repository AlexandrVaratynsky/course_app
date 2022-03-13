package com.andersen.course.app.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "courseid")
    private int courseID;

    @Column(name = "name")
    private String name;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "active")
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Participant> participants;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Meeting> meetings;

    public Course() {
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
