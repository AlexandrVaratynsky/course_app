package com.andersen.course.app.dao;

import com.andersen.course.app.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
    public List<Participant> findAllByCourse_CourseID(int id);

}
