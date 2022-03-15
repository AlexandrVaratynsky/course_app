package com.andersen.course.app.dao;

import com.andersen.course.app.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    public Team getTeamByTeamNumber(int TeamNumber);
}
