package com.andersen.course.app.dao;

import com.andersen.course.app.entity.Course;
import com.andersen.course.app.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    public Team getTeamByTeamNumber(int TeamNumber);
    public Team getTeamByCourseCourseIDAndTeamNumber(int courseID, int teamNumber);
    public List<Team> getAllByCourseCourseID(int courseID);
}
