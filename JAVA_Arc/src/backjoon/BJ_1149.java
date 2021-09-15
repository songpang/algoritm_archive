package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149 {
    static int N;
    static int[][] paint;
    static int min = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        paint = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            paint[i][0] = Integer.parseInt(st.nextToken());
            paint[i][1] = Integer.parseInt(st.nextToken());
            paint[i][2] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
//        dp[1] =
        int prevColor = 0;
        dp[1] = paint[0][0];
        dp[2] = dp[1] + paint[1][1];

        // 빨 초 파
        // 빨 초 / 초 파 / 빨 파 3가지 경우로 시작하는 경우?
    }

    public static void dfs(int idx, int sum, int prevColor, int pPrevColor) {
        if(idx == N) {
            min = Math.min(min, sum);
        }

        for (int i = 0; i < 3; i++) {
            if(i == prevColor) continue;
            dfs(idx + 1, sum + paint[idx][i], prevColor, pPrevColor);
        }
    }
}