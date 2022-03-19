package com.andersen.course.app.controller;

import com.andersen.course.app.entity.Participant;
import com.andersen.course.app.entity.Team;
import com.andersen.course.app.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class MeetingController {

//    @Autowired
//    private ParticipantService participantService;
//
//    @RequestMapping("/teamconfig")
//    public String teamConfig(
//            @RequestParam("courseID") int courseID,
//            Model model) {
//        List<Team> teams = teamService.getAllTeams();
//        if (teams.isEmpty()) {
//            Team newTeam = new Team(0);
//            newTeam.setCourse(courseService.getCourse(courseID));
//            teams.add(newTeam);
//            teamService.saveTeam(newTeam);
//        }
//        List<Participant> participants = participantService.findAllByCourse(courseID);
//        model.addAttribute("Participants", participants);
//        model.addAttribute("Teams", teams);
//
//        return "team-config";
//    }
//
//    @RequestMapping(value = "/save-config")
//    public String saveTeamsConfig(
//            HttpServletRequest request,
//            Model model
//    ) {
//        String courseID = request.getParameter("courseID");
//        Map<String, String[]> reqMap = request.getParameterMap();
//
//        for (String key : reqMap.keySet()) {
//            String[] keySplitted = key.split("\\-");
//            int viewParticipantID = Integer.parseInt(keySplitted[1]);
//            String viewValue = reqMap.get(key)[0];
//            int intViewValue = Integer.parseInt(viewValue);
//            Participant participant = participantService
//                    .getParticipant(viewParticipantID);
//
//            if (keySplitted[0].equals("team")) {
//                Team team = teamService.getOrAddNewTeamByTeamNumber(intViewValue);
//                participant.setTeam(team);
//                team.setCourse(courseService.getCourse(participant.getCourse().getCourseID()));
//                teamService.saveTeam(team);
//                participantService.save(participant);
//            }
//            if (keySplitted[0].equals("active")) {
//
//                if (viewValue.equals("1")) participant.setActive(true);
//                else participant.setActive(false);
//                participant.setActive(viewValue.equals("1"));
//                participantService.save(participant);
//            }
//
//
//        }
//        //            if (keySplitted[0].equals("captain")) {
////                if (intViewValue == 1){
////                    teamService.getTeam(intViewValue).setCaptain(participant);
////                    teamService.saveTeam(participant.getTeam());
////                }
////            }
//
//        return "redirect:open?courseID=1";
//    }
}
