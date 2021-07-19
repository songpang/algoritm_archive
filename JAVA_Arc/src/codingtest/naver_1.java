package codingtest;

import java.util.*;

public class naver_1 {

    public static void main(String[] args) {
        for (int s : solution(new int[]{3, 2, 1, 5, 6, 80})) {
            System.out.println(s);
        }
    }

    public static int[] solution(int[] numbers) {
        String[] numToEng = new String[]{"zero", "one", "two", "three",
                "four", "five", "six", "seven",
                "eight", "nine"};
        Map<String, Integer> engToNums = new HashMap<>();
        String[] afterConversion = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String[] temp = String.valueOf(numbers[i]).split("");
            StringBuilder tempEng = new StringBuilder();

            int tempIndex = 0;
            while(tempIndex != temp.length) {
                int tempNumber = Integer.parseInt(temp[tempIndex++]);
                tempEng.append(numToEng[tempNumber]);
            }
            afterConversion[i] = tempEng.toString();
            engToNums.put(tempEng.toString(), numbers[i]);
        }

        Arrays.sort(afterConversion);

        int[] answer = new int[numbers.length];
        int i = 0;
        for (String s : afterConversion) {
            answer[i++] = engToNums.get(s);
        }

        return answer;
    }
}











