package com.andersen.course.app.controller;

import com.andersen.course.app.dao.TeamRepository;
import com.andersen.course.app.entity.Course;
import com.andersen.course.app.entity.Meeting;
import com.andersen.course.app.entity.Participant;
import com.andersen.course.app.entity.Team;
import com.andersen.course.app.service.CourseService;
import com.andersen.course.app.service.ParticipantService;
import com.andersen.course.app.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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

//    @ModelAttribute
//    public int setGlobalconfig("courseID"){
//        return
//    }

    @RequestMapping("/open")
    public String showAllParticipant(@RequestParam("courseID") int id, Model model) {
        List<Participant> courseParticipant = participantService.findAllByCourse(id);
        model.addAttribute("Participants", courseParticipant);
        model.addAttribute("currentCourseID", id);
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
    public String addCourse(Model model) {
        Course course = new Course();
        course.setActive(true);
        course.setStartDate(new Date());
        model.addAttribute(course);
        return "add-course";
    }

    @RequestMapping("/show-courses")
    public String showCourses(Model model) {
        List<Course> allCourse = courseService.getAllCourse();
        model.addAttribute("all", allCourse);
        return "courses";
    }

    @RequestMapping("/delete-participant")
    public String deletePapticipant(@RequestParam("participantID") int id) {
        int courseID = participantService.getParticipant(id).getCourse().getCourseID();
        participantService.deleteParticipant(id);
        return "redirect:/open" + "?courseID=" + courseID;
    }

    @RequestMapping("/add-participant")
    public String addParticipant(
            @RequestParam("courseID") int courseID,
            @RequestParam("participantID") int participantID,
            Model model
    ) {
        Participant participant = participantService.getParticipant(participantID);
        model.addAttribute(participant);
        return "add-p";
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
        return "add-p";
    }

    @RequestMapping("/save-p")
    public String saveParticipant(@ModelAttribute("participant") Participant participant, Model model) {
        participantService.save(participant);
        return "redirect:/open" + "?courseID=" + participant.getCourse().getCourseID();
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

    @RequestMapping("/save-config")
    public String saveTeamsConfig(
            HttpServletRequest request,
//            @RequestParam("courseID") int courseID,
            Model model
    ) {
        String courseID = request.getParameter("courseID");
        Map<String, String[]> reqMap = request.getParameterMap();
//        for (String key : reqMap.keySet()
//        ) {
//            System.out.print(key + " --> ");
//            for (String val : reqMap.get(key)
//            ) {
//                System.out.print(" " + val + " ");
//            }
//            System.out.println();
//        }

        for (String key : reqMap.keySet()) {
            String[] keySplitted = key.split("\\-");
            int viewParticipantID = Integer.valueOf(keySplitted[1]);
            String viewValue = reqMap.get(key)[0];
            int intViewValue = Integer.valueOf(viewValue);
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

                if (viewValue.equals("1")) participant.setActive(true);
                else participant.setActive(false);
                participantService.save(participant);
            }


        }
        //            if (keySplitted[0].equals("captain")) {
//                if (intViewValue == 1){
//                    teamService.getTeam(intViewValue).setCaptain(participant);
//                    teamService.saveTeam(participant.getTeam());
//                }
//            }

        return "redirect:open?courseID=1";
    }
    @RequestMapping("/meeting")
    public String meeetengQuest(@RequestParam("courseID") int courseID,
    Model model){
        List<Participant> participants = participantService.findAllByCourse(courseID);
        model.addAttribute("Participants", participants);
        return "/meeting";
    }
}
