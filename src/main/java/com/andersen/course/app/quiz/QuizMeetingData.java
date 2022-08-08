package com.andersen.course.app.quiz;

import com.andersen.course.app.entity.Participant;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class QuizMeetingData {
    List<QParticipant> qParticipants;
    int courseID;
    QParticipant whoAsks;
    QParticipant whoAnswer;
    String isActive;

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public QParticipant getWhoAsks() {
        return whoAsks;
    }

    public void setWhoAsks(QParticipant whoAsks) {
        this.whoAsks = whoAsks;
    }

    public QParticipant getWhoAnswer() {
        return whoAnswer;
    }

    public void setWhoAnswer(QParticipant whoAnswer) {
        this.whoAnswer = whoAnswer;
    }

    public List<QParticipant> getqParticipants() {
        return qParticipants;
    }

    public void setqParticipants(List<QParticipant> qParticipants) {
        this.qParticipants = qParticipants;
    }

    public QuizMeetingData(List<Participant> Participants) {
        this.qParticipants = new LinkedList();
        Participants.forEach(participant -> {qParticipants.add(new QParticipant(participant));});
    }

    public QuizMeetingData() {
        this.isActive = "****";
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}
