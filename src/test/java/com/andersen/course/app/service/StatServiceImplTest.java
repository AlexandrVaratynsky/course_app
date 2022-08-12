package com.andersen.course.app.service;

import com.andersen.course.app.dao.StatRepository;
import com.andersen.course.app.entity.Meeting;
import com.andersen.course.app.entity.Participant;
import com.andersen.course.app.entity.Stat;
import com.andersen.course.app.quiz.DataGatherer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class StatServiceImplTest {
    public static final int ID = 1;

    @Mock
    private StatRepository statRepository;
    @Mock
    private MeetingService meetingService;
    @Mock
    private ParticipantService participantService;
    @InjectMocks
    private StatServiceImpl statService;

    @Test
    public void getAllStat_ShouldCallRepository() {
        List<Stat> stats = Mockito.mock(List.class);
        Mockito.when(statRepository.findAll()).thenReturn(stats);

        List<Stat> actual = statService.getAllStat();

        assertNotNull(actual);
        assertEquals(stats, actual);
        Mockito.verify(statRepository).findAll();
    }

    @Test
    public void saveStat_ShouldCallRepository() {
        Stat stat = Mockito.mock(Stat.class);

        statService.saveStat(stat);

        Mockito.verify(statRepository).save(stat);
    }

    @Test
    public void getStat_ShouldCallRepository() {
        Stat stat = Mockito.mock(Stat.class);
        Mockito.when(statRepository.findById(ID)).thenReturn(Optional.ofNullable(stat));

        Stat actual = statService.getStat(ID);

        assertNotNull(actual);
        assertEquals(stat, actual);
        Mockito.verify(statRepository).findById(ID);
    }

    @Test
    public void deleteStat_ShouldCallRepository() {
        statService.deleteStat(ID);

        Mockito.verify(statRepository).deleteById(ID);
    }

    @Test
    public void saveStatByGathererData_ShouldCallRepository() {
        final int SIZE = 3;
        Stat stat = Mockito.mock(Stat.class);
        Meeting meeting = Mockito.mock(Meeting.class);
        Participant participant = Mockito.mock(Participant.class);
        Map<String, String[]> outData = new HashMap();
        for (int i = 1; i < SIZE+1; i++){
            outData.put(String.valueOf(i), new String[]{"1", "1", "1", "true"});
        }
        DataGatherer gatherer = Mockito.mock(DataGatherer.class);
        Mockito.when(gatherer.getOutData()).thenReturn(outData);
        Mockito.when(meetingService.getMeeting(Mockito.anyInt())).thenReturn(meeting);
        Mockito.when(participantService.getParticipant(Mockito.anyInt())).thenReturn(participant);

        statService.saveStatByGathererData(gatherer);

        Mockito.verify(statRepository, Mockito.times(SIZE)).save(Mockito.any(Stat.class));
    }

    @Test
    public void getAllByCourse_ShouldCallRepository() {
        ArrayList<Stat> stats = Mockito.mock(ArrayList.class);
        Mockito.when(statRepository.findAllByMeeting_CourseCourseID(ID)).thenReturn(stats);

        ArrayList<Stat> actual = statService.getAllByCourse(ID);

        assertNotNull(actual);
        assertEquals(stats, actual);
        Mockito.verify(statRepository).findAllByMeeting_CourseCourseID(ID);
    }

    @Test
    public void getStatByMeeting_ShouldCallRepository() {
        Meeting meeting = Mockito.mock(Meeting.class);
        Stat stat = Mockito.mock(Stat.class);
        Mockito.when(statRepository.getStatByMeeting(meeting)).thenReturn(stat);

        Stat actual = statService.getStatByMeeting(meeting);

        assertNotNull(stat);
        assertEquals(stat, actual);
        Mockito.verify(statRepository).getStatByMeeting(meeting);
    }
}