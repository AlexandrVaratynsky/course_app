package com.andersen.course.app.service;

import com.andersen.course.app.entity.Course;
import com.andersen.course.app.entity.Meeting;

import java.util.ArrayList;
import java.util.List;

public interface MeetingService {
    public List<Meeting> getAllMeeting();
    public void saveMeeting(Meeting meeting);
    public Meeting getMeeting(int id);
    public void deleteMeeting(int id);
    public ArrayList<Meeting> getMeetingsByCourseID(int courseID);
    public Meeting addMeetting(Course course);
}
