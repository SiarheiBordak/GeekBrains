package ru.geekbrains.teams;

import ru.geekbrains.participants.AbstractParticipant;

public class Team {
    private String nameTeam;
    private AbstractParticipant[] participants;

    public Team(String nameTeam, AbstractParticipant[] participants) {
        this.nameTeam = nameTeam;
        this.participants = participants;
    }

    public AbstractParticipant[] getParticipants() {
        return participants;
    }

    public void showResult() {
        for (int i = 0; i < participants.length; i++) {
            if (participants[i].isResult()) {
                System.out.println(participants[i].getName() + " walked the distance.");
            } else {
                System.out.println(participants[i].getName() + " did not go the distance.");
            }
        }
    }

    public void infoParticipants() {
        System.out.println("Participants who completed the distance: ");
        for (int i = 0; i < participants.length; i++) {
            if (participants[i].isResult()) {
                System.out.println(participants[i].getName());
            }
        }
    }
}
