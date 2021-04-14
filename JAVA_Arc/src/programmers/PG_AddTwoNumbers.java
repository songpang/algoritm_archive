package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PG_AddTwoNumbers {
    public static void main(String[] args) {

    }

    public static int[] solution(int[] numbers) {
        int arrSize = numbers.length;
        List<Integer> answerCheck = new ArrayList<>();

        int top = 0;

        for (int i = 0; i < arrSize-1; i++) {
            top = numbers[i];
            for (int j = i+1; j < arrSize; j++) {
                int addResult = top + numbers[j];
                if(!answerCheck.contains(addResult)) {
                    answerCheck.add(addResult);
                }
            }
        }

        int size = answerCheck.size();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = answerCheck.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
}
