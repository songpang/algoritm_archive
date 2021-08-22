package programmers;

import java.math.BigDecimal;
import java.util.Arrays;

public class PG_TGDTraffic {

    public static void main(String[] args) {
        int result = solution(new String[]{"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"});

        System.out.println(result);
    }

    public static int solution(String[] lines) {
        int lLength = lines.length;
        String[][] times = new String[lLength][3];

        for (int i = 0; i < lLength; i++) {
            times[i] = lines[i].split(" ");
        }

        double[][] timeRange = new double[lLength][2];

        String[] temp;
        BigDecimal a;
        for (int i = 0; i < lLength; i++) {
            double toSecond = 0;
            temp = times[i][1].split(":");
            toSecond += Integer.parseInt(temp[0]) * 60 * 60 + Integer.parseInt(temp[1]) * 60 +
                    Double.parseDouble(temp[2]);

            double usedTime = Double.parseDouble(times[i][2].substring(0, times[i][2].length() - 1));

            timeRange[i][0] = toSecond * 1000 - usedTime * 1000 + 1;
            timeRange[i][1] = toSecond * 1000;
        }

        int tLength = timeRange.length;
        int maxCount = 0;

        System.out.println(Arrays.deepToString(timeRange));
        for (int i = 0; i < tLength; i++) {
            double endTime = timeRange[i][1] + 1000;

            int count = 1;
            for (int j = i + 1; j < tLength; j++) {
                if (endTime > timeRange[j][0]) {
                    count++;
                }
            }
            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }
}
