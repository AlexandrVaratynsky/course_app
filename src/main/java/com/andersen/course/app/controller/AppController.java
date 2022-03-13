package com.andersen.course.app.controller;

import com.andersen.course.app.entity.Course;
import com.andersen.course.app.entity.Participant;
import com.andersen.course.app.service.CourseService;
import com.andersen.course.app.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private ParticipantService participantService;

    @RequestMapping("/open")
    public String showAllParticipant(@RequestParam("courseID") int id, Model model) {
        List<Participant> allParticipant = participantService.findAllByCourse(id);
        model.addAttribute("Participants", allParticipant);
        model.addAttribute("currentCourseID", new Integer(id));
        return "show-all";
    }

    @RequestMapping("/delete")
    public String deleteCourse(@RequestParam("courseID") int id) {
        courseService.deleteCourse(id);
        return "redirect:/show-courses";
    }

    @RequestMapping("/save")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course);
        return "redirect:/show-courses";
    }

    @RequestMapping("/add-course")
    public String addCourse(Model model){
        Course course = new Course();
        course.setActive(true);
        course.setStartDate(new Date());
        model.addAttribute(course);
        return "add-course";
    }

    @RequestMapping("/show-courses")
    public String showCourses(Model model){
        List<Course> allCourse = courseService.getAllCourse();
        model.addAttribute("all", allCourse);
        return "courses";
    }

    @RequestMapping("/delete-participant")
    public String deletePapticipant(@RequestParam("participantID") int id) {
        int courseID = participantService.getParticipant(id).getCourse().getCourseID();
        participantService.deleteParticipant(id);
        return "redirect:/open"+"?courseID="+courseID;
    }

    @RequestMapping("/add-participant")
    public String addParticipant(
            @RequestParam("courseID") int courseID,
            @RequestParam("participantID") int participantID,
            Model model
            ){
        Participant participant = participantService.getParticipant(participantID);
        model.addAttribute(participant);
        return "add-p";
    }

    @RequestMapping("/add-new-participant")
    public String addNewParticipant(
            @RequestParam("courseID") int courseID,
            Model model
    ){
        Participant participant = new Participant();
        participant.setTeam(null);
        participant.setActive(true);
        participant.setCourse(courseService.getCourse(courseID));
        model.addAttribute(participant);
        return "add-p";
    }

    @RequestMapping("/save-p")
    public String saveParticipant(@ModelAttribute("participant") Participant participant, Model model) {
        participantService.save(participant);
        return "redirect:/open"+"?courseID="+participant.getCourse().getCourseID();
    }
}
