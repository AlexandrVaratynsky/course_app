package com.andersen.course.app.dao;

import com.andersen.course.app.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Integer> {

}
