package ru.geekbrains.participants;

import ru.geekbrains.interfaces.Motion;

public abstract class AbstractParticipant implements Motion {
    private String name;
    private int maximumDistance;
    private int maximumJumping;
    private boolean result;

    public AbstractParticipant(String name, int maximumDistance, int maximumJumping) {
        this.name = name;
        this.maximumDistance = maximumDistance;
        this.maximumJumping = maximumJumping;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public int getMaximumDistance() {
        return maximumDistance;
    }

    public int getMaximumJumping() {
        return maximumJumping;
    }

    public boolean isResult() {
        return result;
    }

    @Override
    public void run() {
        System.out.println(name + " run.");
    }

    @Override
    public void jump() {
        System.out.println(name + " jump.");
    }
}
