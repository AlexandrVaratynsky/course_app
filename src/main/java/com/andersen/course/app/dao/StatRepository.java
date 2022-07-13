package com.andersen.course.app.dao;

import com.andersen.course.app.entity.Meeting;
import com.andersen.course.app.entity.Participant;
import com.andersen.course.app.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface StatRepository extends JpaRepository<Stat, Integer> {

    public ArrayList<Stat> findAllByMeeting_CourseCourseID(int courseID);
    public Stat getStatByMeeting(Meeting m);


    }
