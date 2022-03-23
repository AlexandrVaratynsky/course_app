package com.andersen.course.app.controller;

import com.andersen.course.app.entity.Meeting;
import com.andersen.course.app.entity.Participant;
import com.andersen.course.app.entity.Stat;
import com.andersen.course.app.quiz.DataGatherer;
import com.andersen.course.app.quiz.Random;
import com.andersen.course.app.service.CourseService;
import com.andersen.course.app.service.MeetingService;
import com.andersen.course.app.service.ParticipantService;
import com.andersen.course.app.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class MeetingController {

    @Autowired
    MeetingService meetingService;
    @Autowired
    ParticipantService participantService;
    @Autowired
    CourseService courseService;
    @Autowired
    StatService statService;

    Random random;


    @RequestMapping("/meeting")
    public String meetingQuest(@RequestParam("courseID") int courseID,
                               Model model) {

        List<Participant> participants = participantService.findAllByCourse(courseID);
        Meeting meeting = meetingService.AddMeetting(courseService.getCourse(courseID));
        meetingService.saveMeeting(meeting);
        model.addAttribute("participants", participants);
        model.addAttribute("meetingID", meeting.getMeetingID());
        random = new Random();
        random.setParticipants(participants);
        return "/meeting-tab";
    }

    @RequestMapping("/quiz")
    public String meetingQuest(@RequestParam("courseID") int courseID,
                               @RequestParam("meetingID") int meetingID,
                               HttpServletRequest request,
                               Model model) {
        List<Participant> participants = participantService.findAllByCourse(courseID);
        Map<String, String[]> attendMap = request.getParameterMap();

        String quizIsActive;
        if (request.getParameterMap().containsKey("end")) {
            quizIsActive = "false";
            DataGatherer gatherer = new DataGatherer(attendMap);
            statService.saveStatByGathererData(gatherer);
        } else {
            quizIsActive = "true";
        }

        model.addAttribute("participants", participants);
        model.mergeAttributes(attendMap);
        model.mergeAttributes(random.getMapAskAnswer());
        model.addAttribute("quizIsActive", quizIsActive);

        return "quiz-tab";
    }
}
