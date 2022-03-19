package com.andersen.course.app.controller;

import com.andersen.course.app.entity.Course;
import com.andersen.course.app.entity.Participant;
import com.andersen.course.app.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

public class CourseController {

//    @Autowired
//    private CourseService courseService;
//
//    @RequestMapping("/delete")
//    public String deleteCourse(@RequestParam("courseID") int id) {
//        courseService.deleteCourse(id);
//        return "redirect:/show-courses";
//    }
//
//    @RequestMapping("/save")
//    public String saveCourse(@ModelAttribute("course") Course course) {
//        courseService.saveCourse(course);
//        return "redirect:/show-courses";
//    }
//
//    @RequestMapping("/add-course")
//    public String addCourse(Model model) {
//        Course course = new Course();
//        course.setActive(true);
//        course.setStartDate(new Date());
//        model.addAttribute(course);
//        return "add-course";
//    }
//
//    @RequestMapping("/show-courses")
//    public String showCourses(Model model) {
//        List<Course> allCourse = courseService.getAllCourse();
//        model.addAttribute("all", allCourse);
//        return "courses";
//    }
}
