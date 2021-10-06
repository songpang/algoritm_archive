package codingtest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PracNotes {
    @Test
    public void test() {
//        Assertions.assertEquals(2, solution(41));
//        Assertions.assertEquals(2, solution(40));
//        Assertions.assertEquals(2, solution(39));
        Assertions.assertEquals(4, solution(244));
        // 25 25 1
        //
//        Assertions.assertEquals(2, solution(37));

    }

    public int solution(int n) {
        int answer = 0;

        int high = 1;
        int pow = high * high;
        while(pow <= n) {
            high++;
            pow = high * high;
        }

        high--;
        int min = Integer.MAX_VALUE;

        for (int i = high; i >= 1 ; i--) {
            int rest = n;
            int temp = i;
            answer = 0;
            while (rest != 0) {
                pow = temp * temp;
                if (rest - pow > 0) {
                    rest -= pow;
                    answer++;
                } else if (rest == pow) {
                    answer++;
                    break;
                } else {
                    temp--;
                }
            }

            min = Math.min(min, answer);
        }

        return min;
    }
}