package com.andersen.course.app.service;

import com.andersen.course.app.dao.MeetingRepository;
import com.andersen.course.app.dao.ParticipantRepository;
import com.andersen.course.app.entity.Meeting;
import com.andersen.course.app.entity.Participant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class ParticipantServiceImplTest {
    public static final int ID = 1;
    @Mock
    private ParticipantRepository participantRepository;
    @InjectMocks
    ParticipantServiceImpl participantService;
    @Mock
    Participant participant;

    @Test
    public void getAllParticipant_ShouldCallRepository() {
        List<Participant> participants = Mockito.mock(List.class);
        Mockito.when(participantRepository.findAll()).thenReturn(participants);

        List<Participant> actual = participantService.getAllParticipant();

        assertNotNull(actual);
        assertEquals(participants, actual);
        Mockito.verify(participantRepository).findAll();
    }

    @Test
    public void save_ShouldCallRepository() {
        participantService.save(participant);

        Mockito.verify(participantRepository).save(participant);
    }

    @Test
    public void getParticipant_ShouldCallRepository() {
        Mockito.when(participantRepository.findById(ID)).thenReturn(Optional.ofNullable(participant));

        Participant actual = participantService.getParticipant(ID);

        assertNotNull(actual);
        assertEquals(participant, actual);
        Mockito.verify(participantRepository).findById(ID);
    }

    @Test
    public void deleteParticipant_ShouldCallRepository() {
        participantService.deleteParticipant(ID);

        Mockito.verify(participantRepository).deleteById(ID);
    }

    @Test
    public void findAllByCourse_ShouldCallRepository() {
        List<Participant> participants = Mockito.mock(List.class);
        Mockito.when(participantRepository.findAllByCourse_CourseID(ID)).thenReturn(participants);

        List<Participant> actual = participantService.findAllByCourse(ID);

        assertNotNull(actual);
        assertEquals(participants, actual);
        Mockito.verify(participantRepository).findAllByCourse_CourseID(ID);
    }

    @Test
    public void findAllActiveByCourse_ShouldCallRepository() {
        List<Participant> participants = Mockito.mock(List.class);
        Mockito.when(participantRepository.findAllByCourse_CourseIDAndActiveIsTrue(ID)).thenReturn(participants);

        List<Participant> actual = participantService.findAllActiveByCourse(ID);

        assertNotNull(actual);
        assertEquals(participants, actual);
        Mockito.verify(participantRepository).findAllByCourse_CourseIDAndActiveIsTrue(ID);
    }
}