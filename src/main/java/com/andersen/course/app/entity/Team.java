package com.andersen.course.app.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teamid")
    private int teamID;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "team")
    private List<Participant> participants;

    @ManyToOne
    @JoinColumn(name = "courseid")
    private Course course;


    @ManyToOne
    @JoinColumn(name = "captainid")
    private Participant captain;

    @Column(name = "teamnumber")
    private int teamNumber;

    @Column(name = "teammatecount")
    private int teammateCount;

    public void setCaptain(Participant captain) {
        this.captain = captain;
    }

    public Participant getCaptain() {
        return captain;
    }

    public Team() {
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Team(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int timeNumber) {
        this.teamNumber = timeNumber;
    }

    public int getTeammateCount() {
        return teammateCount;
    }

    public void setTeammateCount(int teammateCount) {
        this.teammateCount = teammateCount;
    }
}
