package com.andersen.course.app.controller;

import com.andersen.course.app.entity.Participant;
import com.andersen.course.app.entity.Team;
import com.andersen.course.app.service.CourseService;
import com.andersen.course.app.service.ParticipantService;
import com.andersen.course.app.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class TeamController {

    @Autowired
    TeamService teamService;
    @Autowired
    CourseService courseService;
    @Autowired
    ParticipantService participantService;

    @RequestMapping("/teamconfig")
    public String teamConfig(
            @RequestParam("courseID") int courseID,
            HttpServletRequest request,
            Model model) {
        List<Team> teams = teamService.getAllTeamsInCourse(courseID);
        if (teams.isEmpty()) {
            Team newTeam = new Team(0);
            newTeam.setCourse(courseService.getCourse(courseID));
            teams.add(newTeam);
            teamService.saveTeam(newTeam);
        }
        String teamsConfigStep = "";
        if (request.getAttribute("TeamsConfigStep") == null) {
            teamsConfigStep = "teams";
        } else {
            teamsConfigStep = (String) request.getAttribute("TeamsConfigStep");
        }

        List<Participant> participants = participantService.findAllByCourse(courseID);
        model.addAttribute("Participants", participants);
        model.addAttribute("Teams", teams);
        model.addAttribute("TeamsConfigStep", teamsConfigStep);
        return "team-config";
    }

    @RequestMapping(value = "/save-config")
    public String saveTeamsConfig(
            HttpServletRequest request
    ) {
        Integer courseID = Integer.parseInt(request.getParameter("courseID"));
        Map<String, String[]> reqMap = request.getParameterMap();
//       parameters looks like: key -"active-1" value - "{1[,0]}"
//       "active" - parameter name, "-1" - participant ID, first of value array - chosen input value
//        for "captain": "-1" is number of team where current member chosen as captain
        for (String key : reqMap.keySet()) {
            if ((key.equals("courseID")) || (key.equals("TeamsConfigStep"))) {
                continue;
            }
            String[] keySplitted = key.split("\\-");
            int viewParticipantID = Integer.parseInt(keySplitted[1]);
            String viewValue = reqMap.get(key)[0];
            int intViewValue = Integer.parseInt(viewValue);
            Participant participant = participantService
                    .getParticipant(viewParticipantID);

            if (keySplitted[0].equals("team")) {
                Team team = teamService.getOrAddNewTeamInCourseByTeamNumber(courseID, intViewValue);
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
            if (keySplitted[0].equals("captain")) {
                Participant captain = participantService.getParticipant(Integer.parseInt(viewValue));
                Team team = captain.getTeam();
                team.setCaptain(captain);
                teamService.saveTeam(team);
            }

        }
        String nextURL = "";
        if (!reqMap.containsKey("TeamsConfigStep")) {
            nextURL = "forward:/teamconfig";

            request.setAttribute("TeamsConfigStep", "captains");
        } else {
            nextURL = "forward:/open";
        }
        return nextURL;
    }
}
