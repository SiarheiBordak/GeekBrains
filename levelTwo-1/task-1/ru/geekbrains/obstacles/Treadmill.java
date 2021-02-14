package ru.geekbrains.obstacles;

import ru.geekbrains.interfaces.Actions;
import ru.geekbrains.participants.AbstractParticipant;

public class Treadmill implements Actions {
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean overcomingObstacles(AbstractParticipant participant) {
        participant.run();

        if(participant.getMaximumDistance() >= length) {
            System.out.println(participant.getName() + " ran successfully.");
            return true;
        }

        System.out.println(participant.getName() + " could not run.");

        return false;
    }
}
