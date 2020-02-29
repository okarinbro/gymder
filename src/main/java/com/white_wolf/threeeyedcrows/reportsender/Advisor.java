package com.white_wolf.threeeyedcrows.reportsender;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Advisor {
    private final static double WATER_LITRES = 2.5;
    private final static double STEPS_PER_DAY = 10000;
    private final static double KCALS_PER_DAY = 3000;
    private final static String GOOD = "That's pretty impressive outcome";
    private final static String BAD = "You have to try harder! You are the best! Crossed fingers!";

    public static String getAdvice(Statistics statistics) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Average kcals consumption: ")
                .append(statistics.getAverageCalories())
                .append(advise(statistics.getAverageCalories(), KCALS_PER_DAY))
                .append("\n\n");
        stringBuilder.append("Average steps per day: ")
                .append(statistics.getAverageSteps())
                .append(advise(statistics.getAverageSteps(), STEPS_PER_DAY))
                .append("\n\n");
        stringBuilder.append("Average water consumption: ")
                .append(statistics.getAverageWaterConsumptiondouble())
                .append(advise(statistics.getAverageWaterConsumptiondouble(), WATER_LITRES))
                .append("\n\n");
        stringBuilder.append("You have done: ").append(100 * statistics.getGoalsCompleted()).append(" %");
        stringBuilder.append("/n/n").append("You collected: ").append(getPoints(statistics)).append(" points.");
        return stringBuilder.toString();
    }

    public static double getPoints(Statistics statistics) {
        return max(0, statistics.getAverageSteps() - STEPS_PER_DAY) +
                (-1) * abs(statistics.getAverageCalories() - KCALS_PER_DAY) +
                max(0, statistics.getAverageWaterConsumptiondouble() - WATER_LITRES) + 2000 * statistics.getGoalsCompleted();
    }

    private static String advise(double averageKcalConsumption, double expectedValue) {
        return averageKcalConsumption < expectedValue ? GOOD : BAD;
    }
}
