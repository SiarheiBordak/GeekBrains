package ru.geekbrains.obstacles;

import ru.geekbrains.interfaces.Actions;
import ru.geekbrains.participants.AbstractParticipant;

public class Wall implements Actions {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean overcomingObstacles(AbstractParticipant participant) {
        participant.jump();

        if(participant.getMaximumJumping() >= height) {
            System.out.println(participant.getName() + " jump successfully.");
            return true;
        }

        System.out.println(participant.getName() + " could not jump.");

        return false;
    }
}
