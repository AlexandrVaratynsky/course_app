package com.andersen.course.app.controller;

import com.andersen.course.app.entity.Course;
import com.andersen.course.app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/delete")
    public String deleteCourse(@RequestParam("courseID") int id) {
        courseService.deleteCourse(id);
        return "show-courses";
    }

    @RequestMapping("/save")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course);
        return "redirect:/show-courses";
    }

    @RequestMapping("/add-course")
    public String addCourse(Model model) {
        Course course = new Course();
        course.setActive(true);
        course.setStartDate(new Date());
        model.addAttribute(course);
        return "add-course";
    }

    @GetMapping("/show-courses")
    public String showCourses(Model model) {
        List<Course> allCourse = courseService.getAllCourse();
        model.addAttribute("all", allCourse);
        return "courses";
    }

}