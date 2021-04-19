package programmers;

import java.util.Arrays;

public class PG_TGDTraffic {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"}));
    }

    public static int solution(String[] lines) {
        int max = 1;
        double underBound;
        double upperBound;

        int i = 0;
        for (String line : lines) {
            String[] temp = line.split(" ");
            double parseDate = parseDate(temp[1]);
            underBound = parseDate - Double.parseDouble(temp[2].replace("s", ""));
            upperBound = parseDate + 1;
            i++;

            int count = 1;
            for (String line2 : lines) {
                String[] temp2 = line2.split(" ");
                double parseDate2 = parseDate(temp2[1]);
                double underBound2 = parseDate2 - Double.parseDouble(temp2[2].replace("s", "")) + 0.001;
                double upperBound2 = parseDate2 + 1;

                //if 어퍼바운드 에서 1초 내에 들어온 애
                // 언더 바운드에서 1초 내에 들어온 애
                // 중에 큰애
//                if () {
//                    count++;
//                }
                if(underBound2 >= upperBound + 3) break;
            }
            if (count > max) max = count;
        }
        return max;
    }

    public static double parseDate(String date) {
        String[] result = date.split(":");
        double dateToInt = Double.parseDouble(result[2])
                + 60 * Double.parseDouble(result[1])
                + 60 * 60 * Double.parseDouble(result[0]);
        return dateToInt;
    }
}
