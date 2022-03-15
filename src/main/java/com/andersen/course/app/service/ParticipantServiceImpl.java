package com.andersen.course.app.service;

import com.andersen.course.app.dao.ParticipantRepository;
import com.andersen.course.app.entity.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ParticipantServiceImpl implements ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;

    public ParticipantServiceImpl() {
    }

    @Override
    public List<Participant> getAllParticipant() {
        return participantRepository.findAll();
    }

    @Override
    public void save(Participant participant) {
        participantRepository.save(participant);
    }

    @Override
    public Participant getParticipant(int id) {
        Participant participant = null;
        Optional<Participant> p = participantRepository.findById(id);
        if (p.isPresent()) {
            participant = p.get();
        }

        return participant;
    }

    @Override
    public void deleteParticipant(int id) {
        participantRepository.deleteById(id);
    }

    @Override
    public List<Participant> findAllByCourse(int courseID) {
        return participantRepository.findAllByCourse_CourseID(courseID);
    }



}
