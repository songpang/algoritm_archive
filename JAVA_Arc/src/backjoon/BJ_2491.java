package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 백준 2491 수열
// 단순 구현.
public class BJ_2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int firstB = numbers[0];
        int firstS = numbers[0];
        int countB = 1;
        int countS = 1;
        int max = 1;
        for (int i = 1; i < N; i++) {
            if(firstB <= numbers[i]) {
                firstB = numbers[i];
                countB++;
            } else {
                max = Math.max(max, countB);
                firstB = numbers[i];
                countB = 1;
            }

            if(firstS >= numbers[i]) {
                firstS = numbers[i];
                countS++;
            } else {
                max = Math.max(max, countS);
                firstS = numbers[i];
                countS = 1;
            }
        }
        max = Math.max(max, countB);
        max = Math.max(max, countS);

        System.out.println(max);

    }
}
