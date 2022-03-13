package com.andersen.course.app.entity;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "participant" //, uniqueConstraints = {
        //@UniqueConstraint(name = "uc_participant_courseid", columnNames = {"courseid"})
//}
)
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "participantid")
    private int participantID;

    @ManyToOne
    @JoinColumn(name = "teamid")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "courseid")
    private Course course;

    @Column(name = "teammateordernumber")
    private int teammateOrderNumber;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "active")
    private boolean active;

    public Participant() {
    }

    public int getParticipantID() {
        return participantID;
    }

    public void setParticipantID(int participantID) {
        this.participantID = participantID;
    }

    public int getTeammateOrderNumber() {
        return teammateOrderNumber;
    }

    public void setTeammateOrderNumber(int teammateOrderNumber) {
        this.teammateOrderNumber = teammateOrderNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
