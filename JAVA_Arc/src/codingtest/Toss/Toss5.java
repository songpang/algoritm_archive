package codingtest.Toss;

import java.util.*;

public class Toss5 {
    public static void main(String[] args) {
        int[] temp = solution(new int[]{30, 40, 10, 20, 30}, 3);
        System.out.println(Arrays.toString(temp));
    }

    public static int[] solution(int[] fruitWeights, int k) {
        long sum = 0;
        int max = 0;
        Set<Integer> maxList = new HashSet<>();

        for (int i = 0; i < k; i++) {
            max = Math.max(max, fruitWeights[i]);
            sum += fruitWeights[i];
        }
        maxList.add(max);

        for (int i = 0; i < fruitWeights.length - k; i++) {
            sum = sum - fruitWeights[i] + fruitWeights[i + k];

            if (fruitWeights[i] != max) {
                max = Math.max(max, fruitWeights[i + k]);
            } else {
                max = 0;
                for (int j = 1; j <= k; j++) {
                    max = Math.max(max, fruitWeights[i + j]);
                }
            }
            maxList.add(max);
        }

        Integer[] answer = new Integer[maxList.size()];

        int idx = 0;
        for (Integer integer : maxList) {
            answer[idx++] = integer;
        }

        Arrays.sort(answer, Collections.reverseOrder());
        int[] realAnswer = Arrays.stream(answer).mapToInt(Integer::intValue).toArray();
        return realAnswer;
    }
}
