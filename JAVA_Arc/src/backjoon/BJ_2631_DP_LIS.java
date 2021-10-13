// 언어 : JAVA , 메모리 : 14160 KB , 시간 : 128 ms

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 2631 줄세우기 LIS를 이용한 DP문제.
// 참고 https://velog.io/@kjihye0340/%EB%B0%B1%EC%A4%80-2631%EC%A4%84%EC%84%B8%EC%9A%B0%EA%B8%B0Java
public class BJ_2631_DP_LIS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] child = new int[N];
        for (int i = 0; i < N; i++) {
            child[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N];
        dp[0] = 1;

        int result = 0;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (child[i] > child[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                result = Math.max(result, dp[i]);
            }
        }
        System.out.println(N - result);

    }
}
