package com.andersen.course.app.quiz;

import com.andersen.course.app.entity.Participant;


import java.util.*;

public class Random {
    List<Participant> participants;
    Participant firstStartParticipant;
    Participant whoAsks;
    ArrayList<String> excludedID;

    public void setExcludedID(ArrayList<String> excludedID) {
        this.excludedID = excludedID;
        if ((excludedID != null) && (!excludedID.isEmpty())) {
            Iterator iterator = participants.iterator();
            while(iterator.hasNext()) {
                Participant participant = (Participant) iterator.next();
                if (excludedID.contains(String.valueOf(participant.getParticipantID()))){
                    iterator.remove();
                }
            }

        }
        if (excludedID.contains(String.valueOf(firstStartParticipant.getParticipantID()))){
            saveFirst();
        }
    }

    public void setParticipants(List<Participant> participants) {
        List<Participant> tmp = new ArrayList<>(participants);
        Collections.shuffle(tmp);
        this.participants = tmp;
        saveFirst();
    }

    @Override
    public String toString() {
        String result = " ID     Team " + System.lineSeparator();
        for (Participant p : participants) {
            result += " " + p.getParticipantID() + " " + p.getTeam().getTeamID() + System.lineSeparator();
        }
        result += "-------------";
        return result;
    }

    void saveFirst() {
        firstStartParticipant = participants.get(0);
        whoAsks = firstStartParticipant;
    }

    Participant getWhoAsks() {
        whoAsks = participants.remove(0);
        return whoAsks;
    }

    Participant getWhoAnswersID() {
        if (participants.size() > 0) {
            for (int i = 0; i < participants.size(); i++) {
                if (participants.get(i).getTeam().getTeamID() != whoAsks.getTeam().getTeamID()) {
                    whoAsks = participants.get(i);
                    return whoAsks;
                } else {
                    participants.add(participants.remove(i));
                }
            }
            whoAsks = participants.get(0);
            return whoAsks;
        }
        return firstStartParticipant;
    }

    public Map<String, String> getMapAskAnswer() {
        Map<String, String> map = new HashMap<>();
        if (participants.isEmpty()) {
            map.put("end", "end");
        } else {
            map.put("whoAsksID", String.valueOf(getWhoAsks().getParticipantID()));
            map.put("whoAnswersID", String.valueOf(getWhoAnswersID().getParticipantID()));
        }
        return map;
    }

}