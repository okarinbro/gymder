package com.white_wolf.threeeyedcrows.reportsender;

import com.white_wolf.threeeyedcrows.model.User;

import java.util.Calendar;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Advisor {
    private static double WATER_LITRES = 2.5;
    private static double STEPS_PER_DAY = 10000;
    private static double KCALS_PER_DAY = 3000;
    private final static String GOOD = "That's pretty impressive outcome";
    private final static String BAD = "You have to try harder! You are the best! Crossed fingers!";

    //todo -> refactor :<
    private static void setParams(int age) {
        if (age <= 20) {
            KCALS_PER_DAY = 1800;
            STEPS_PER_DAY = 6000;
        } else if (age > 20) {
            KCALS_PER_DAY = 1800;
            STEPS_PER_DAY = 6000;
        } else if (age > 35) {
            KCALS_PER_DAY = 2400;
            STEPS_PER_DAY = 3000;
        } else {
            KCALS_PER_DAY = 2000;
            STEPS_PER_DAY = 3000;
        }
    }

    public static String getAdvice(Statistics statistics, User user) {
        setParams(Calendar.getInstance().get(Calendar.YEAR) - user.getYear());
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
        stringBuilder.append("/n/n").append("You collected: ").append(getPoints(statistics, user)).append(" points.");
        stringBuilder.append("/n/n").append(String.format("At your age you should do about %s, consume %s kcals and drink %s litres of water",
                STEPS_PER_DAY, KCALS_PER_DAY, WATER_LITRES));
        return stringBuilder.toString();
    }

    public static double getPoints(Statistics statistics, User user) {
        setParams(Calendar.getInstance().get(Calendar.YEAR) - user.getYear());
        return max(0, statistics.getAverageSteps() - STEPS_PER_DAY) +
                (-1) * abs(statistics.getAverageCalories() - KCALS_PER_DAY) +
                max(0, statistics.getAverageWaterConsumptiondouble() - WATER_LITRES) + 2000 * statistics.getGoalsCompleted();
    }

    private static String advise(double averageKcalConsumption, double expectedValue) {
        return averageKcalConsumption < expectedValue ? GOOD : BAD;
    }
}
