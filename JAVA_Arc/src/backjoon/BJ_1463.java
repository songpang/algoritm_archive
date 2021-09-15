package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            }
        }

        System.out.println(dp[N]);
    }
    /*
    private static int dpf(int N) {
        if(N == 0) return -1;
        if(N == 1) return 0;
        int i2 = 0,i3 = 0;
        return (i2 = dpf(N/2) + N%2 + 1) > (i3 = dpf(N/3) + N%3 + 1) ? i3 : i2;
    }
     */
}
