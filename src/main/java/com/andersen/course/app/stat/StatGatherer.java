package com.andersen.course.app.stat;

import com.andersen.course.app.entity.Meeting;
import com.andersen.course.app.entity.Participant;
import com.andersen.course.app.entity.Stat;
import com.andersen.course.app.service.MeetingService;
import com.andersen.course.app.service.ParticipantService;
import com.andersen.course.app.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class StatGatherer {

    @Autowired
    ParticipantService participantService;
    @Autowired
    StatService statService;
    @Autowired
    MeetingService meetingService;
    ArrayList<ArrayList<String>> outputStatData;
    public ArrayList<String> meetingDates;

    public StatGatherer() {
    }

    public ArrayList<ArrayList<String>> getOutputStatData() {
        return outputStatData;
    }

    public ArrayList<String> getMeetingDates() {
        return meetingDates;
    }

    @Override
    public String toString() {
        String result = "";
        if (outputStatData == null) {
            result = "output data is empty";
        } else {
            for (ArrayList<String> s : outputStatData) {
                for (String cell : s) {
                    result += cell;
                }
                result += System.lineSeparator();
            }
        }
        return result;
    }

    public void loadMeetingDates(int courseID) {
        ArrayList<Meeting> meetings = meetingService.getMeetingsByCourseID(courseID);
        SimpleDateFormat sm = new SimpleDateFormat("dd.MM.yyyy");
        ArrayList<String> meetingDates = new ArrayList();
        for (Meeting m : meetings) {
            meetingDates.add(sm.format(m.getDate()));
        }
        this.meetingDates = meetingDates;
    }

    public void outputStatDataPrepare(int courseID) {
        loadStatData(courseID);
        loadMeetingDates(courseID);
    }

    public void loadStatData(int courseID) {
        ArrayList<Meeting> meetings = meetingService.getMeetingsByCourseID(courseID);
        List<Participant> participants = participantService.findAllByCourse(courseID);
        ArrayList<Stat> stats = statService.getAllByCourse(courseID);

        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        NumberFormat formatter = new DecimalFormat("#0.0");

        for (Participant p : participants) {
            ArrayList<String> line = new ArrayList<String>(Arrays.asList(new String[]{p.getFirstName(), p.getLastName()}));
            double statSum = 0;
            for (Meeting m : meetings) {
                line.add("");
                for (Stat s : stats) {
                    if ((s.getMeeting().getMeetingID() == m.getMeetingID()) &&
                            (p.getParticipantID() == s.getParticipant().getParticipantID())) {
                        line.set(line.size() - 1, formatter.format(s.getScore()));
                        statSum += s.getScore();
                    }
                }
            }
            line.add(formatter.format(statSum));
            lists.add(line);
        }
        this.outputStatData = lists;
    }
}