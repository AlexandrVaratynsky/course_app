package com.andersen.course.app.controller;

import com.andersen.course.app.entity.Meeting;
import com.andersen.course.app.entity.Participant;
import com.andersen.course.app.entity.Stat;
import com.andersen.course.app.service.MeetingService;
import com.andersen.course.app.service.ParticipantService;
import com.andersen.course.app.service.StatService;
import com.andersen.course.app.stat.StatGatherer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StatController {

    @Autowired
    StatGatherer statGatherer;

    @RequestMapping("/stat")
    public String teamConfig(@RequestParam("courseID") int courseID, Model model){
        statGatherer.outputStatDataPrepare(courseID);
        model.addAttribute("outputData",statGatherer.getOutputStatData());
        return "stat-tab";
    }
}
