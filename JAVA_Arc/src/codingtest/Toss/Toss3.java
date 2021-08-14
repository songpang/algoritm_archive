package codingtest.Toss;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Toss3 {
    public static void main(String[] args) {
        solution("3000,900");
    }

    public static boolean solution(String amountText) {
        boolean answer = true;
        int textLength = amountText.length() - 1;
        String pattern = "^[0-9,]*$";

        if (!Pattern.matches(pattern, amountText)) {
            answer = false;
        } else if (!amountText.equals("0") && amountText.charAt(0) == '0') {
            answer = false;
        } else if (amountText.charAt(0) == ',' || amountText.charAt(textLength) == ',') {
            answer = false;
        }

        if(amountText.length() > 3) {
            String[] test = amountText.split(",");
            if(test.length > 1 && test[0].length() >= 4) {
                answer = false;
                return answer;
            }
            for (int i = 1; i < test.length; i++) {
                if(test[i].length() != 3) {
                    answer = false;
                }
            }
        }
        return answer;
    }
}

