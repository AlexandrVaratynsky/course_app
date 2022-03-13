package com.andersen.course.app.service;

import com.andersen.course.app.entity.Participant;

import java.util.List;

public interface ParticipantService {
    public List<Participant> getAllParticipant();
    public void save(Participant participant);
    public Participant getParticipant(int id);
    public void deleteParticipant(int id);
    public List<Participant> findAllByCourse(int courseID);
}
