package com.andersen.course.app.service;

import com.andersen.course.app.dao.MeetingRepository;
import com.andersen.course.app.dao.ParticipantRepository;
import com.andersen.course.app.dao.StatRepository;
import com.andersen.course.app.entity.Meeting;
import com.andersen.course.app.entity.Participant;
import com.andersen.course.app.entity.Stat;
import com.andersen.course.app.quiz.DataGatherer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Part;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class StatServiceImpl implements StatService {

    @Autowired
    private StatRepository statRepository;
    @Autowired
    private MeetingService meetingService;
    @Autowired
    private ParticipantService participantService;

    @Override
    public List<Stat> getAllStat() {
        return statRepository.findAll();
    }

    public StatServiceImpl() {
    }

    @Override
    public void saveStat(Stat stat) {
        statRepository.save(stat);
    }

    @Override
    public Stat getStat(int id) {
        Stat stat = null;
        Optional<Stat> crs = statRepository.findById(id);
        if (crs.isPresent()) {
            stat = crs.get();
        }

        return stat;
    }

    @Override
    public void deleteStat(int id) {
        statRepository.deleteById(id);
    }

    @Override
    public void saveStatByGathererData(DataGatherer gatherer) {
        Meeting meeting = meetingService.getMeeting(gatherer.getMeetingID());

        for (String key : gatherer.getOutData().keySet()) {
            Participant participant = participantService.getParticipant(Integer.valueOf(key));
            Stat stat = new Stat();
            stat.setMeeting(meeting);
            stat.setParticipant(participant);
            double score = Double.valueOf(gatherer.getOutData().get(key)[0])
                    + Double.valueOf(gatherer.getOutData().get(key)[1])
                    + Double.valueOf(gatherer.getOutData().get(key)[2]);
            stat.setScore(score);
            stat.setAttendance(Boolean.parseBoolean(gatherer.getOutData().get(key)[3]));
            statRepository.save(stat);
        }

    }

    @Override
    public ArrayList<Stat> getAllByCourse(int courceID) {
        return statRepository.findAllByMeeting_CourseCourseID(courceID);
    }

    @Override
    public Stat getStatByMeeting(Meeting m) {
        return statRepository.getStatByMeeting(m);
    }


}
