// 언어 : JAVA , 메모리 : 14220 KB , 시간 : 124 ms

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] work = new int[N + 2][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            work[i][0] = Integer.parseInt(st.nextToken());
            work[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 2];

        // 뒤부터 계산
        for (int i = N; i > 0; i--) {
            int next = i + work[i][0];
            // N 일을 넘어간다면 일을 할 수 없음
            if (next > N + 1) {
                dp[i] = dp[i + 1];
            } else { // 안넘어간다면 뒤랑 비교.
                dp[i] = Math.max(dp[i + 1], dp[next] + work[i][1]);
            }
        }

        System.out.println(dp[1]);
    }
}
