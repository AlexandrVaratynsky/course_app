package com.andersen.course.app.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stat")
public class Stat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "statid")
    private int statID;

    @ManyToOne
    @JoinColumn(name = "participantID")
    private Participant participant;

    @ManyToOne
    @JoinColumn(name = "meetingID")
    private Meeting meeting;

    @Column(name = "attendance")
    private boolean Attendance;

    @Column(name = "score")
    private double score;

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public Stat() {
    }

    public int getStatID() {
        return statID;
    }

    public void setStatID(int statID) {
        this.statID = statID;
    }

    public boolean isAttendance() {
        return Attendance;
    }

    public void setAttendance(boolean attendance) {
        Attendance = attendance;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
