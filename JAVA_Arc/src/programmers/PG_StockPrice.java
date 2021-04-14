package programmers;

import java.util.Arrays;

public class PG_StockPrice {
    public static void main(String[] args) {
        int[] result;
    }

    public static int[] solution(int[] prices) {
        int lengthA = prices.length;
        int[] answer = new int[lengthA];

        for (int j = 0; j < lengthA-1; j++) {
            for (int i = j; i < lengthA-1; i++) {
                if (prices[j] <= prices[i]) {
                    answer[j]++;
                } else {
                    break;
                }
            }
        }
        return answer;
    }
}
