package programmers;

import java.util.ArrayList;
import java.util.List;

public class PG_2017Tips_RemovePairs {
    public static void main(String[] args) {
        int temp = solution("baabaa");
        System.out.println(temp);
    }

    public static int solution(String s) {
        int answer = 1;

        char[] chrs = s.toCharArray();
        int minJ = 0;
        int minI = 0;

        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] != '0') {
                for (int j = i + 1; j < chrs.length; j++) {
                    if (chrs[j] != '0') {
                        if (chrs[i] == chrs[j]) {
                            chrs[i] = '0';
                            chrs[j] = '0';
                            i = -1;
                        } else {
                            i = j - 1;
                        }
                        break;
                    }
                }
            }
        }

        for (char chr : chrs) {
            if(chr != '0') {
                answer = 0;
                break;
            }
        }

        return answer;
    }
}
