import ru.geekbrains.gui.CalculatorFrame;
import ru.geekbrains.interfaces.Actions;
import ru.geekbrains.obstacles.Treadmill;
import ru.geekbrains.obstacles.Wall;
import ru.geekbrains.participants.AbstractParticipant;
import ru.geekbrains.participants.Cat;
import ru.geekbrains.participants.Man;
import ru.geekbrains.participants.Robot;
import ru.geekbrains.teams.Course;
import ru.geekbrains.teams.Team;

public class Main {

    public static void main(String[] args) {
        new CalculatorFrame();
        Course course = new Course(new Actions[]{new Treadmill(350), new Wall(2)});
        Team team = new Team("'Bones of fate'",
                new AbstractParticipant[] {
                        new Cat("Barsik", 100, 1),
                        new Man("Siarhei", 300, 2),
                        new Robot("Jon", 500, 3),
                        new Man("Maksim", 350, 2)
                });

        course.overcomingObstacles(team);

        System.out.println();
        team.infoParticipants();

        System.out.println("\nResults:");
        team.showResult();
    }
}