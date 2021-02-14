package ru.geekbrains.teams;

import ru.geekbrains.interfaces.Actions;

public class Course {
    private Actions[] obstacles;

    public Course(Actions[] obstacles) {
        this.obstacles = obstacles;
    }

    public void overcomingObstacles(Team team) {
        for (int i = 0; i < team.getParticipants().length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if(obstacles[j].overcomingObstacles(team.getParticipants()[i])) {
                    team.getParticipants()[i].setResult(true);
                } else {
                    team.getParticipants()[i].setResult(false);
                    break;
                }
            }
        }
    }
}
