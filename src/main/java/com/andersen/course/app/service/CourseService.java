package com.andersen.course.app.service;

import com.andersen.course.app.entity.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getAllCourse();
    public void saveCourse(Course course);
    public Course getCourse(int id);
    public void deleteCourse(int id);
}
