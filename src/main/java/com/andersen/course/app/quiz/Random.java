package com.andersen.course.app.quiz;

import com.andersen.course.app.entity.Participant;


import java.util.*;

public class Random {
    List<Participant> participants;
    Participant firstStartParticipant;
    Participant whoAsks;

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
//        System.out.print(whoAsks.getParticipantID() + " - ");
        return whoAsks;
    }

    Participant getWhoAnswersID() {
        if (participants.iterator().hasNext()) {
            for (int i = 0; i < participants.size(); i++) {
                if (participants.get(i).getTeam().getTeamID() != whoAsks.getTeam().getTeamID()) {
                    System.out.print(whoAsks.getParticipantID()+ " - "+ participants.get(i).getParticipantID()+" ("+whoAsks.getTeam().getTeamID() +"-"+participants.get(i).getTeam().getTeamID()+") "+ System.lineSeparator());
//                    participants.remove(whoAsks);
                    whoAsks = participants.get(i);

                    //System.out.println(whoAsks.getParticipantID());
                    return whoAsks;
                }else{
                    participants.add(participants.remove(i));
                    i--;
//                    participants.remove(i);

                }


            }
            whoAsks = participants.remove(0);
            System.out.println(whoAsks.getParticipantID());

        }

        System.out.println(firstStartParticipant.getParticipantID());
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