package com.andersen.course.app.service;

import com.andersen.course.app.dao.MeetingRepository;
import com.andersen.course.app.entity.Course;
import com.andersen.course.app.entity.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MeetingServiceImpl implements MeetingService{

    @Autowired
    private MeetingRepository meetingRepository;

    public MeetingServiceImpl() {
    }

    @Override
    public List<Meeting> getAllMeeting() {
        return meetingRepository.findAll();
    }

    @Override
    public void saveMeeting(Meeting meeting) {
        meetingRepository.save(meeting);
    }

    @Override
    public Meeting getMeeting(int id) {
        Meeting meeting = null;
        Optional<Meeting> mtn = meetingRepository.findById(id);
        if (mtn.isPresent()) {
            meeting = mtn.get();
        }

        return meeting;
    }

    @Override
    public void deleteMeeting(int id) {
        meetingRepository.deleteById(id);
    }

    @Override
    public ArrayList<Meeting> getMeetingsByCourseID(int courseID) {
        return  meetingRepository.getMeetingByCourse_CourseID(courseID);
    }

    @Override
    public Meeting addMeeting(Course course) {
        Meeting meeting = new Meeting();
        meeting.setCourse(course);
        return meeting;
    }
}
