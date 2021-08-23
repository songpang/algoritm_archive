package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PG_StringCompression {
    // 다시 풀어보기
    public static int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            String convert = "", temp;

            int count = 1;
            temp = s.substring(0, i);

            for (int j = i; j < s.length(); j += i) {
                String sSub = s.substring(j, j + i);

                if (temp.equals(sSub)) count++;
                else {
                    if (count > 1) convert += String.valueOf(count);
                    convert += temp;
                    temp = sSub;
                    if(j + 2 * i > s.length()) {
                        temp = s.substring(j);
                        count = 1;
                        break;
                    }
                    count = 1;
                }
            }

            if (count > 1) convert += String.valueOf(count);
            convert += temp;
            answer = Math.min(answer, convert.length());
        }
        return answer;
    }

    @Test
    public void 정답() {
        Assertions.assertEquals(7, solution("aabbaccc"));
        Assertions.assertEquals(9, solution("ababcdcdababcdcd"));
        Assertions.assertEquals(8, solution("abcabcdede"));
        Assertions.assertEquals(14, solution("abcabcabcabcdededededede"));
        Assertions.assertEquals(17, solution("xababcdcdababcdcd"));
    }
}
