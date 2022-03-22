package com.andersen.course.app.controller;

import com.andersen.course.app.entity.Participant;
import com.andersen.course.app.service.CourseService;
import com.andersen.course.app.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
public class ParticipantController {

    @Autowired
    CourseService courseService;
    @Autowired
    ParticipantService participantService;

    @RequestMapping("/open")
    public String showAllParticipant(
            @RequestParam("courseID") int id,
            Model model) {

        List<Participant> courseParticipant = participantService.findAllByCourse(id);
        model.addAttribute("Participants", courseParticipant);
        model.addAttribute("currentCourseID", id);
        return "show-all";
    }

    @PostMapping("/delete-participant")
    public String deletePapticipant(
            @RequestParam("participantID") int id,
            @RequestParam("courseID") int courseID
    ) {
        participantService.deleteParticipant(id);
        return "forward:/open";
    }

    @RequestMapping("/add-participant")
    public String addParticipant(
            @RequestParam("courseID") int courseID,
            @RequestParam("participantID") int participantID,
            HttpServletResponse response,
            Model model
    ) {
        Participant participant = participantService.getParticipant(participantID);
        model.addAttribute(participant);
        model.addAttribute("courseID", courseID);

        return "/add-p";
    }

    @RequestMapping("/add-new-participant")
    public String addNewParticipant(
            @RequestParam("courseID") int courseID,
            Model model
    ) {
        Participant participant = new Participant();
        participant.setTeam(null);
        participant.setActive(true);
        participant.setCourse(courseService.getCourse(courseID));
        model.addAttribute(participant);
        return "/add-p";
    }

    @PostMapping("/save-p")
    public String saveParticipant(
            @ModelAttribute("participant") Participant participant,
            @RequestParam("courseID") int courseID,
            Model model) {
        participantService.save(participant);
        model.addAttribute("courseID", courseID);
        return "forward:/open";
    }
}
