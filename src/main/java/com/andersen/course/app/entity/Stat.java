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

    public Stat() {

    }

    public Participant getParticipantID() {
        return participant;
    }

    public void setParticipant(Participant participantID) {
        this.participant = participant;
    }

    @Column(name = "attendance")
    private boolean Attendance;

    @Column(name = "score")
    private double score;

    public double getBonusScore() {
        return BonusScore;
    }

    public void setBonusScore(double bonusScore) {
        BonusScore = bonusScore;
    }

    public double getAnswerScore() {
        return AnswerScore;
    }

    public void setAnswerScore(double answerScore) {
        AnswerScore = answerScore;
    }

    public double getQuestionScore() {
        return QuestionScore;
    }

    public void setQuestionScore(double questionScore) {
        QuestionScore = questionScore;
    }

    @Transient
    private double BonusScore;
    @Transient
    private double AnswerScore;
    @Transient
    private double QuestionScore;

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
