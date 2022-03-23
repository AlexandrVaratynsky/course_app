package com.andersen.course.app.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "meeting")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "meetingid")
    private int meetingID;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "courseID")
    private Course course;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meeting")
    private List<Stat> stats;

    public Meeting() {
        date = new Date();
    }

    public int getMeetingID() {
        return meetingID;
    }

    public void setMeetingID(int meetingID) {
        this.meetingID = meetingID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
