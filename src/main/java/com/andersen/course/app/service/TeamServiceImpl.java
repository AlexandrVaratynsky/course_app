package com.andersen.course.app.service;

import com.andersen.course.app.dao.TeamRepository;
import com.andersen.course.app.entity.Course;
import com.andersen.course.app.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public TeamServiceImpl() {
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public void saveTeam(Team team) {
        teamRepository.save(team);
    }

    @Override
    public Team getTeam(int id) {
        Team team = null;
        Optional<Team> crs = teamRepository.findById(id);
        if (crs.isPresent()) {
            team = crs.get();
        }
        return team;
    }

    @Override
    public void deleteTeam(int id) {
        teamRepository.deleteById(id);
    }

    @Override
    public Team getOrAddNewTeamByTeamNumber(int TeamNumber) {
        Team team = teamRepository.getTeamByTeamNumber(TeamNumber);
        if (team == null) {
            team = new Team();
            team.setTeamNumber(TeamNumber);
        }
        //teamRepository.save(team);
        return team;
    }


}
