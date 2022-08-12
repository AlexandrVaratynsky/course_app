package com.andersen.course.app.service;

import com.andersen.course.app.dao.CourseRepository;
import com.andersen.course.app.entity.Course;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceImplTest {
    public static final int ID = 1;
    @Mock
    private CourseRepository courseRepository;
    @InjectMocks CourseServiceImpl courseService;

    @Mock
    Course course;

    @Test
    public void getAllCourse_ShouldCallRepository() {
        List<Course> courses = Mockito.mock(List.class);
        Mockito.when(courseRepository.findAll()).thenReturn(courses);

        List<Course> actual = courseService.getAllCourse();

        assertNotNull(actual);
        assertEquals(courses, actual);
        Mockito.verify(courseRepository).findAll();
    }

    @Test
    public void saveCourse_ShouldCallRepository() {
        courseService.saveCourse(course);

        Mockito.verify(courseRepository).save(course);
    }

    @Test
    public void getCourse_ShouldCallRepository() {
        Mockito.when(courseRepository.findById(ID)).thenReturn(Optional.ofNullable(course));

        Course actual = courseService.getCourse(ID);

        assertNotNull(actual);
        assertEquals(course, actual);
        Mockito.verify(courseRepository).findById(ID);
    }

    @Test
    public void deleteCourse_ShouldCallRepository() {
        courseService.deleteCourse(ID);

        Mockito.verify(courseRepository).deleteById(ID);
    }
}