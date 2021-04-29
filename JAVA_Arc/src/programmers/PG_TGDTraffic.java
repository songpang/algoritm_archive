package programmers;

import java.util.ArrayList;
import java.util.List;

public class PG_TGDTraffic {

    public static void main(String[] args) {

    }

    public int solution(String[] lines) {
        int answer = 0;
        List<String> times = new ArrayList<>();
        List<String> processingTime = new ArrayList<>();

        int max = 0;
        double underBound = 0;
        double upperBound = 0;
        for (String line : lines) {
            String[] temp = line.split(" ");
            double parseDate = parseDate(temp[1]);

//            underBound = parseDate - temp[2];
            upperBound = parseDate + 60;
        }

        // 1. int형 배열을 0.001초 단위로 1일치를 만들어서 비교?
        // 2. count = 0;
        /*
            count = 0;
            for()
            times.끝시간 - pcT  = times.첫시간
            count += 첫시간 + pcT.
            if(count > 0) max += 1;

            3. 2000개의 배열을 만들고
            57.421 0.351
            58.420 까지 포함

            57. 071 ~ 58.420
            2000개를 돌면서
            2중 루프를 한 번 더도는데

         */
        // 3.
        return answer;
    }

    public static double parseDate(String date) {
        String[] result = date.split(":");
        double dateToInt = Double.parseDouble(result[2])
                + 60 * Double.parseDouble(result[1])
                + 24 * 60 * Double.parseDouble(result[0]);
        return dateToInt;
    }
}
