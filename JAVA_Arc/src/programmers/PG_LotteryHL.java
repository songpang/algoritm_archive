package programmers;

import java.util.ArrayList;
import java.util.List;

public class PG_LotteryHL {
    public static void main(String[] args) {

    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;
        int matchingResult = 0;
        int[] answer = new int[2];

        for(int lotto : lottos) {
            if(lotto == 0) {
                zeroCount++;
            }

            for (int win_num : win_nums) {
                if (lotto == win_num) {
                    matchingResult++;
                    break;
                }
            }
        }

        answer[0] = zeroCount + matchingResult < 2 ? 6 : Math.abs(zeroCount + matchingResult - 6) + 1;
        answer[1] = matchingResult < 2 ? 6 : Math.abs(matchingResult - 6) + 1;

        return answer;
    }
}
