package com.andersen.course.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "stat")
public class Stat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "statid")
    private int statID;

    @Column(name = "participantid")
    private int ParticipantID;

    @ManyToOne
    @JoinColumn(name = "meetingID")
    private Meeting meetingID;

    @Column(name = "attendance")
    private boolean Attendance;

    @Column(name = "score")
    private double score;

    public Stat() {
    }

    public int getStatID() {
        return statID;
    }

    public void setStatID(int statID) {
        this.statID = statID;
    }

    public int getParticipantID() {
        return ParticipantID;
    }

    public void setParticipantID(int participantID) {
        ParticipantID = participantID;
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
