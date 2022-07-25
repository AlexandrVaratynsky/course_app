package com.andersen.course.app.dao;

import com.andersen.course.app.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
    public List<Participant> findAllByCourse_CourseID(int id);

    public List<Participant> findAllByCourse_CourseIDAndActiveIsTrue(int id);




}
