package com.andersen.course.app.service;

import com.andersen.course.app.dao.TeamRepository;
import com.andersen.course.app.entity.Team;
import org.junit.Test;
import org.junit.jupiter.engine.JupiterTestEngine;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TeamServiceImplTest {
    public static final int ID = 1;
    @Mock
    private TeamRepository teamRepository;
    @InjectMocks
    TeamServiceImpl teamService;

    @Test
    public void getAllTeams_ShouldCallRepository() {
        List<Team> teams = Mockito.mock(List.class);
        Mockito.when(teamRepository.findAll()).thenReturn(teams);

        List<Team> actual = teamService.getAllTeams();

        assertNotNull(actual);
        assertEquals(teams, actual);
        Mockito.verify(teamRepository).findAll();
    }

    @Test
    public void getAllTeamsInCourse_ShouldCallRepository() {
        List<Team> teams = Mockito.mock(List.class);
        Mockito.when(teamRepository.getAllByCourseCourseID(ID)).thenReturn(teams);

        List<Team> actual = teamService.getAllTeamsInCourse(ID);

        assertNotNull(actual);
        assertEquals(teams, actual);
        Mockito.verify(teamRepository).getAllByCourseCourseID(ID);
    }

    @Test
    public void saveTeam_ShouldCallRepository() {
        Team team = Mockito.mock(Team.class);

        teamService.saveTeam(team);

        Mockito.verify(teamRepository).save(team);
    }

    @Test
    public void getTeam_ShouldCallRepository() {
        Team team = Mockito.mock(Team.class);
        Mockito.when(teamRepository.findById(ID)).thenReturn(Optional.ofNullable(team));

        Team actual = teamService.getTeam(ID);

        assertNotNull(team);
        assertEquals(team, actual);
        Mockito.verify(teamRepository).findById(ID);
    }

    @Test
    public void deleteTeam_ShouldCallRepository() {
        teamService.deleteTeam(ID);

        Mockito.verify(teamRepository).deleteById(ID);
    }

    @Test
    public void getOrAddNewTeamByTeamNumber_ShouldCallRepository() {
        Team team = Mockito.mock(Team.class);
        Mockito.when(teamRepository.getTeamByTeamNumber(ID)).thenReturn(team);

        Team actual = teamService.getOrAddNewTeamByTeamNumber(ID);

        assertNotNull(team);
        assertEquals(team, actual);
        Mockito.verify(teamRepository).getTeamByTeamNumber(ID);
    }

    @Test
    public void getOrAddNewTeamInCourseByTeamNumber_ShouldCallRepository() {
        int courseID = 1;
        Team team = Mockito.mock(Team.class);
        Mockito.when(teamRepository.getTeamByCourseCourseIDAndTeamNumber(courseID, ID)).thenReturn(team);

        Team actual = teamService.getOrAddNewTeamInCourseByTeamNumber(courseID, ID);

        assertNotNull(team);
        assertEquals(team, actual);
        Mockito.verify(teamRepository).getTeamByCourseCourseIDAndTeamNumber(courseID, ID);

    }
}