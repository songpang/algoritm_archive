package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[1] = 9;
        dp[2] = 17;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + (dp[i - 2] - i +1) * 2;
        }

        System.out.println(dp[N]);
        // 1 2 3 4 5 6 7 8 9

        // 898 989 987 789
        // 12 23 34 45 56 67 78 89= 7 x 2
        // 21 32 43 54 65 76 87 98 = 8 x 2
        // 10 = 1 ? 89
        // 101 1

        // 1010 1012 2
        // 10101 1011 1013 3
        // 101010 101012 ... 4개 6

        // 121 123
    }
}
