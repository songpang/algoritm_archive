package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PG_KAKAO_Tuple {
    public static int[] solution(String s) {
        String[] input = s.split("},\\{");
        int ipLength = input.length;

        input[0] = input[0].substring(2);
        input[ipLength - 1] = input[ipLength - 1].substring(0, input[ipLength - 1].length() - 2);

        Arrays.sort(input, Comparator.comparing(o -> o.length()));

        List<Integer> result = new ArrayList<>();
        result.add(Integer.parseInt(input[0]));

        for (int i = 1; i < ipLength; i++) {
            int[] temp = Arrays.stream(input[i].split(",")).mapToInt(Integer::parseInt).toArray();
            for (int i1 : temp) {
                if(!result.contains(i1)) {
                    result.add(i1);
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
