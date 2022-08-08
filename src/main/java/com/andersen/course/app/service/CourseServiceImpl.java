package com.andersen.course.app.service;

import com.andersen.course.app.dao.CourseRepository;
import com.andersen.course.app.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseServiceImpl() {
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);

    }

    @Override
    public Course getCourse(int id) {
        Course course = null;
        Optional<Course> crs = courseRepository.findById(id);
        if (crs.isPresent()) {
            course = crs.get();
        }

        return course;
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }


}
