package programmers;

import java.util.ArrayList;
import java.util.List;

public class PG_Carpet {
    public static void main(String[] args) {

    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        List<Integer> measures = new ArrayList<>();
        for (int j = 1; j <= yellow; j++) {
            if (yellow % j == 0) measures.add(j);
        }

        for (Integer measure : measures) {
            int width = yellow / measure + 2;
            int height = measure + 2;
            if (brown == (2 * width + 2 * height - 4)) {
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }
        return answer;
    }
}
