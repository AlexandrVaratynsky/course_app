package com.andersen.course.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teamid")
    private int teamID;

    @ManyToOne
    @JoinColumn(name = "captanid")
    private Participant participant;

    @ManyToOne
    @JoinColumn(name = "courseid")
    private Course course;

    @Column(name = "timenumber")
    private int timeNumber;

    @Column(name = "teammatecount")
    private int teammateCount;

    public Team() {
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public int getTimeNumber() {
        return timeNumber;
    }

    public void setTimeNumber(int timeNumber) {
        this.timeNumber = timeNumber;
    }

    public int getTeammateCount() {
        return teammateCount;
    }

    public void setTeammateCount(int teammateCount) {
        this.teammateCount = teammateCount;
    }
}
