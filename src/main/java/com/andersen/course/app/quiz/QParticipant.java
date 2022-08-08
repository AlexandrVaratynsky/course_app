package com.andersen.course.app.quiz;

import com.andersen.course.app.entity.Participant;

import java.util.Date;

public class QParticipant {
    Date date;
    Participant participant;
    double bonusScore;
    double questionScore;
    double answerScore;
    String attendance;
    String finished;
    String asks;
    String answer;

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }

    public String getAsks() {
        return asks;
    }

    public void setAsks(String asks) {
        this.asks = asks;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QParticipant() {
    }

    public QParticipant(Participant participant) {
        this.participant = participant;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public double getBonusScore() {
        return bonusScore;
    }

    public void setBonusScore(double bonusScore) {
        this.bonusScore = bonusScore;
    }

    public double getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(double questionScore) {
        this.questionScore = questionScore;
    }

    public double getAnswerScore() {
        return answerScore;
    }

    public void setAnswerScore(double answerScore) {
        this.answerScore = answerScore;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
