package com.andersen.course.app.controller;

import com.andersen.course.app.entity.Meeting;
import com.andersen.course.app.entity.Participant;
import com.andersen.course.app.entity.Stat;
import com.andersen.course.app.entity.Team;
import com.andersen.course.app.quiz.QuizMeetingData;
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
import java.util.LinkedList;
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
        QuizMeetingData quizMeetingData = new QuizMeetingData(participants);
        quizMeetingData.setCourseID(courseID);
        quizMeetingData.setIsActive("false");
        model.addAttribute("meetingData", quizMeetingData);
        random = new Random();
        random.setParticipants(participants);
        System.out.println(random.toString());
        return "/meeting-tab";
    }

    @RequestMapping("/quiz")
    public String meetingQuest(@RequestParam("courseID") int courseID,
                               HttpServletRequest request,
                               Model model) {
        List<Participant> participants = participantService.findAllByCourse(courseID);
        Map<String, String[]> attendMap = request.getParameterMap();
        Meeting meeting = meetingService.AddMeetting(courseService.getCourse(courseID));
        Stat stat = new Stat();
        meetingService.saveMeeting(meeting);
        statService.saveStat(stat);
        String quizIsActive = "true";
        model.addAttribute("participants", participants);
        model.mergeAttributes(attendMap);
        model.mergeAttributes(random.getMapAskAnswer());
        model.addAttribute("quizIsActive", quizIsActive);

        return "quiz-tab";
    }
}
