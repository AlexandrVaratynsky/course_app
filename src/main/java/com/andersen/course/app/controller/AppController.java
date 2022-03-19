package com.andersen.course.app.controller;

import com.andersen.course.app.entity.*;
import com.andersen.course.app.quiz.QuizMeetingData;
import com.andersen.course.app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class AppController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private ParticipantService participantService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private MeetingService meetingService;
    @Autowired
    private StatService statService;

    @RequestMapping("/open")
    public String showAllParticipant(
            @RequestParam("courseID") int id,
            Model model) {

        List<Participant> courseParticipant = participantService.findAllByCourse(id);
        model.addAttribute("Participants", courseParticipant);
        model.addAttribute("currentCourseID", id);
        return "show-all";
    }

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
        System.out.println("--------------" + courseID + "------------");
        return "forward:/open";
    }

    @RequestMapping("/teamconfig")
    public String teamConfig(
            @RequestParam("courseID") int courseID,
            Model model) {
        List<Team> teams = teamService.getAllTeams();
        if (teams.isEmpty()) {
            Team newTeam = new Team(0);
            newTeam.setCourse(courseService.getCourse(courseID));
            teams.add(newTeam);
            teamService.saveTeam(newTeam);
        }
        List<Participant> participants = participantService.findAllByCourse(courseID);
        model.addAttribute("Participants", participants);
        model.addAttribute("Teams", teams);

        return "team-config";
    }

    @RequestMapping(value = "/save-config")
    public String saveTeamsConfig(
            //@RequestParam("courseID") int courseID,
            HttpServletRequest request,
            Model model
    ) {
        String courseID = request.getParameter("courseID");
        Map<String, String[]> reqMap = request.getParameterMap();

        for (String key : reqMap.keySet()) {
            if (key.equals("courseID")) {
                continue;
            }
            String[] keySplitted = key.split("\\-");
            int viewParticipantID = Integer.parseInt(keySplitted[1]);
            String viewValue = reqMap.get(key)[0];
            int intViewValue = Integer.parseInt(viewValue);
            Participant participant = participantService
                    .getParticipant(viewParticipantID);

            if (keySplitted[0].equals("team")) {
                Team team = teamService.getOrAddNewTeamByTeamNumber(intViewValue);
                participant.setTeam(team);
                team.setCourse(courseService.getCourse(participant.getCourse().getCourseID()));
                teamService.saveTeam(team);
                participantService.save(participant);
            }
            if (keySplitted[0].equals("active")) {

                if (viewValue.equals("1")) {
                    participant.setActive(true);
                } else {
                    participant.setActive(false);
                }
                participant.setActive(viewValue.equals("1"));
                participantService.save(participant);
            }

//            if (keySplitted[0].equals("captain")) {
//                if (intViewValue == 1){
//                    Team team = participant.getTeam();
//                    team.setCaptain(participant);
//                    teamService.saveTeam(team);
//
//                }
//            }

        }


        return "forward:/open";
    }

    @RequestMapping("/meeting")
    public String meetingQuest(@RequestParam("courseID") int courseID,
                               Model model) {

        List<Participant> participants = participantService.findAllByCourse(courseID);
        QuizMeetingData quizMeetingData = new QuizMeetingData(participants);
        quizMeetingData.setCourseID(courseID);
        quizMeetingData.setIsActive("false");
        model.addAttribute("meetingData", quizMeetingData);
//        String attend;
//        String id;
//        String active;


        System.out.println("-------------" + quizMeetingData.getIsActive() + "------------");
        return "/meeting-tab";
    }

    @RequestMapping("/quiz")
    public String meetingQuest(@RequestParam("courseID") int courseID,
                               HttpServletRequest request,
                               Model model) {
        List<Participant> participants = participantService.findAllByCourse(courseID);
        QuizMeetingData quizMeetingData = new QuizMeetingData(participants);
        Map<String, String[]> attendMap = request.getParameterMap();
        Meeting meeting = meetingService.AddMeetting(courseService.getCourse(courseID));

        Stat stat = new Stat();
        meetingService.saveMeeting(meeting);
        statService.saveStat(stat);
        String quizIsActive = "true";
        model.addAttribute("data", quizMeetingData);
        model.addAttribute("meeting", meeting);
        model.addAttribute("stat", stat);
        model.addAttribute("participants", participants);
        model.addAllAttributes(attendMap);
        model.addAttribute("quizIsActive", quizIsActive);

        System.out.println("----------------");
        for (Map.Entry<String, String[]> s: attendMap.entrySet()
             ) {

            System.out.println(s.getKey() +" --- "+ s.getValue()[0]);
        }

        return "quiz-tab";
    }
}
