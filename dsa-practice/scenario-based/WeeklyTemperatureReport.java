public class WeeklyTemperatureReport {

    public static void main(String[] args) {

        float[][] weeklyReadings = loadTemperatureData();

        float[] dailyAverages = new float[weeklyReadings.length];

        float maxAverage = Float.NEGATIVE_INFINITY;
        float minAverage = Float.POSITIVE_INFINITY;

        System.out.println("Daily Average Temperatures:");

        for (int day = 0; day < weeklyReadings.length; day++) {
            float avg = calculateAverage(weeklyReadings[day]);
            dailyAverages[day] = avg;

            System.out.printf("Day %d : %.2f%n", day + 1, avg);

            if (avg > maxAverage) {
                maxAverage = avg;
            }

            if (avg < minAverage) {
                minAverage = avg;
            }
        }

        System.out.println("\nHottest Day Average: " + maxAverage);
        System.out.println("Coldest Day Average: " + minAverage);
    }

    private static float calculateAverage(float[] hourlyTemps) {
        float sum = 0.0f;
        for (float value : hourlyTemps) {
            sum += value;
        }
        return sum / hourlyTemps.length;
    }

    private static float[][] loadTemperatureData() {
        return new float[][] {

                {18.2f,17.9f,17.5f,17.1f,16.8f,16.5f,17.0f,18.4f,20.1f,22.3f,24.0f,25.5f,26.8f,27.3f,27.0f,26.2f,25.1f,23.8f,22.4f,21.0f,20.1f,19.4f,18.9f,18.5f},

                {18.0f,17.6f,17.3f,16.9f,16.6f,16.4f,16.9f,18.2f,20.0f,22.0f,23.8f,25.2f,26.5f,27.0f,26.7f,26.0f,24.8f,23.5f,22.0f,20.8f,19.9f,19.1f,18.7f,18.3f},

                {17.8f,17.5f,17.2f,16.8f,16.5f,16.3f,16.8f,18.1f,19.9f,22.1f,24.1f,25.7f,27.0f,27.5f,27.2f,26.4f,25.3f,24.0f,22.6f,21.3f,20.4f,19.6f,19.0f,18.6f},

                {18.4f,18.0f,17.6f,17.2f,16.9f,16.7f,17.2f,18.6f,20.4f,22.7f,24.6f,26.0f,27.4f,27.9f,27.6f,26.8f,25.7f,24.4f,23.0f,21.7f,20.8f,20.0f,19.4f,19.0f},

                {18.6f,18.2f,17.8f,17.4f,17.1f,16.9f,17.5f,18.9f,20.8f,23.0f,25.0f,26.5f,27.9f,28.4f,28.1f,27.2f,26.0f,24.6f,23.2f,21.9f,21.0f,20.2f,19.6f,19.2f},

                {19.0f,18.6f,18.2f,17.8f,17.4f,17.2f,17.8f,19.2f,21.0f,23.4f,25.4f,27.0f,28.5f,29.0f,28.7f,27.8f,26.6f,25.2f,23.8f,22.4f,21.4f,20.6f,20.0f,19.6f},

                {18.8f,18.4f,18.0f,17.6f,17.3f,17.0f,17.6f,19.0f,20.7f,22.9f,24.8f,26.2f,27.6f,28.1f,27.8f,26.9f,25.8f,24.5f,23.1f,21.8f,20.9f,20.1f,19.5f,19.1f}
        };
    }
}
