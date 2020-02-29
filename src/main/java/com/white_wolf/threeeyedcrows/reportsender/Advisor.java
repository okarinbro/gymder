package com.white_wolf.threeeyedcrows.reportsender;

class Advisor {
    private final static double WATER_LITRES = 2.5;
    private final static double STEPS_PER_DAY = 10000;
    private final static double KCALS_PER_DAY = 3000;
    private final static String GOOD = "That's pretty impressive outcome";
    private final static String BAD = "You have to try harder! You are the best! Crossed fingers!";

    static String getAdvice(double averageWaterConsumption, double averageSteps, double averageKcalConsumption, double goalsPercent) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Average kcals consumption: ")
                .append(averageKcalConsumption)
                .append("\n\n")
                .append(advise(averageKcalConsumption, KCALS_PER_DAY))
                .append("\n\n");
        stringBuilder.append("Average steps per day: ")
                .append(averageSteps)
                .append("\n\n")
                .append(advise(averageSteps, STEPS_PER_DAY))
                .append("\n\n");
        stringBuilder.append("Average water consumption: ")
                .append(averageWaterConsumption)
                .append("\n\n")
                .append(advise(averageWaterConsumption, WATER_LITRES))
                .append("\n\n");
        stringBuilder.append("You have done: ").append(100 * goalsPercent).append(" %");
        return stringBuilder.toString();
    }

    private static String advise(double averageKcalConsumption, double expectedValue) {
        return averageKcalConsumption < expectedValue ? GOOD : BAD;
    }
}
