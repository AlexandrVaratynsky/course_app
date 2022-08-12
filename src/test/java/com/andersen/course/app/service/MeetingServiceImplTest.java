package com.andersen.course.app.service;

import com.andersen.course.app.dao.MeetingRepository;
import com.andersen.course.app.entity.Course;
import com.andersen.course.app.entity.Meeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class MeetingServiceImplTest {
    public static final int ID = 1;
    @Mock
    private MeetingRepository meetingRepository;
    @InjectMocks
    MeetingServiceImpl meetingService;
    @Mock
    Meeting meeting;

    @Test
    public void getAllMeeting_ShouldCallRepository() {
        List<Meeting> meetings = Mockito.mock(List.class);
        Mockito.when(meetingRepository.findAll()).thenReturn(meetings);

        List<Meeting> actual = meetingService.getAllMeeting();

        assertNotNull(actual);
        assertEquals(meetings, actual);
        Mockito.verify(meetingRepository).findAll();
    }

    @Test
    public void saveMeeting_ShouldCallRepository() {
        meetingService.saveMeeting(meeting);

        Mockito.verify(meetingRepository).save(meeting);
    }

    @Test
    public void getMeeting_ShouldCallRepository() {
        Mockito.when(meetingRepository.findById(ID)).thenReturn(Optional.ofNullable(meeting));

        Meeting actual = meetingService.getMeeting(ID);

        assertNotNull(actual);
        assertEquals(meeting, actual);
        Mockito.verify(meetingRepository).findById(ID);
    }

    @Test
    public void deleteMeeting_ShouldCallRepository() {
        meetingService.deleteMeeting(ID);

        Mockito.verify(meetingRepository).deleteById(ID);
    }

    @Test
    public void getMeetingsByCourseID_ShouldCallRepository() {
        ArrayList<Meeting> meetings = Mockito.mock(ArrayList.class);
        Mockito.when(meetingRepository.getMeetingByCourse_CourseID(ID)).thenReturn(meetings);

        ArrayList<Meeting> actual = meetingService.getMeetingsByCourseID(ID);

        assertNotNull(actual);
        assertEquals(meetings, actual);
        Mockito.verify(meetingRepository).getMeetingByCourse_CourseID(ID);

    }

    @Test
    public void addMeeting_ShouldReturnNewMeeting() {
        Course course = Mockito.mock(Course.class);

        Meeting actual = meetingService.addMeeting(course);

        assertNotNull(meeting);
        assertEquals(actual.getCourse(), course);
    }
}