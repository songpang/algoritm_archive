package JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1681 {
    static int[][] adjacent;
    static int N, min;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine().trim());

        adjacent = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adjacent[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];
        min = Integer.MAX_VALUE;
        dfs(0, 0, 0);
        System.out.println(min);
    }

    static void dfs(int idx, int cnt, int distance) {
        if (distance >= min) return;

        if (cnt == N - 1) {
            if (adjacent[idx][0] != 0) {
                int temp = distance + adjacent[idx][0];
                min = Math.min(min, temp);
            }
            return;
        }

        for (int i = 1; i < N; i++) {
            if (!visited[i] && adjacent[idx][i] != 0) {
                visited[i] = true;
                dfs(i, cnt + 1, distance + adjacent[idx][i]);
                visited[i] = false;
            }
        }
    }
}
