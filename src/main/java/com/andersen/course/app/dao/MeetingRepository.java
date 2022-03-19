package com.andersen.course.app.dao;

import com.andersen.course.app.entity.Course;
import com.andersen.course.app.entity.Meeting;
import com.andersen.course.app.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Integer> {
    public Meeting getOrAddNewMeetingByCourse(Course course);

}
