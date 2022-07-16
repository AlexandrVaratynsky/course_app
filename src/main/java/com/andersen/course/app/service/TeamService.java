package com.andersen.course.app.service;


import com.andersen.course.app.entity.Team;

import java.util.List;

public interface TeamService {
    public List<Team> getAllTeams();
    public List<Team> getAllTeamsInCourse(int courseID);
    public void saveTeam(Team team);
    public Team getTeam(int id);
    public void deleteTeam(int id);
    public Team getOrAddNewTeamByTeamNumber(int TeamNumber);
    public Team getOrAddNewTeamInCourseByTeamNumber(int courseID, int teamNumber);

}
