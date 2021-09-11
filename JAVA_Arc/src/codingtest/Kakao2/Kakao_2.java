package codingtest.Kakao2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Kakao_2 {
    @Test
    public void test() {
        Assertions.assertEquals(2, solution(110011, 10));
    }

    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        String converted;

        if(k != 10) {
            while (n > 0) {
                int value = n % k;
                n /= k;
                sb.insert(0, value);
            }
            converted = sb.toString();
        } else {
            converted = String.valueOf(n);
        }

        int size = converted.length();

        loop:
        for (int i = 0; i < size; i++) {
            sb.setLength(0);
            while (i < size && converted.charAt(i) != '0') {
                sb.append(converted.charAt(i));
                i++;
            }

            if(sb.length() == 0) {
                continue;
            }

            long isPrime = Long.parseLong(sb.toString());

            if(isPrime == 1) {
                continue;
            }

            for (int j = 2; (long) j *j <= isPrime; j++) {
                if (isPrime % j == 0) {
                    continue loop;
                }
            }

            answer++;
        }

        return answer;
    }

}
