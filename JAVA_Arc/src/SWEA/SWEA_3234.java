package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_3234 {
    static int N, sum;
    static int[] weight;
    static int correctCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            weight = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            correctCount = 0;
            sum = Arrays.stream(weight).sum() / 2 + 1;

            permutation(0, 0, 0, 0);

            System.out.printf("#%d %d\n", t, correctCount);
        }
    }

    public static void permutation(int count, int visited, int left, int right) {
        if (count == N) {
            correctCount++;
            return;
        }

        if (left >= sum) {
            correctCount += Math.pow(2, N - count) * factorial(N - count);
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((visited & 1 << i) != 0) continue;
            permutation(count + 1, visited | 1 << i, left + weight[i], right);
            if (right + weight[i] <= left) {
                permutation(count + 1, visited | 1 << i, left, right + weight[i]);
            }
        }
    }

    private static int factorial(int num) {
        if (num == 0) return 1;
        return num * factorial(num - 1);
    }
}
