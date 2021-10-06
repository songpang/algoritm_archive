package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9251_LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int N = s1.length();
        int M = s2.length();
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                if (s1.charAt(i-1) != s2.charAt(j-1)) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }

        System.out.println(dp[N][M]);
    }
}
