package com.white_wolf.threeeyedcrows.reportsender;

public class Statistics {
    private final double averageWaterConsumptiondouble;
    private final double averageCalories;
    private final double averageSteps;
    private final double goalsCompleted;

    public Statistics(double averageWaterConsumptiondouble, double averageCalories, double averageSteps, double goalsCompleted) {
        this.averageWaterConsumptiondouble = averageWaterConsumptiondouble;
        this.averageCalories = averageCalories;
        this.averageSteps = averageSteps;
        this.goalsCompleted = goalsCompleted;
    }

    public double getAverageWaterConsumptiondouble() {
        return averageWaterConsumptiondouble;
    }

    public double getAverageCalories() {
        return averageCalories;
    }

    public double getAverageSteps() {
        return averageSteps;
    }

    public double getGoalsCompleted() {
        return goalsCompleted;
    }
}
