package algoForBank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS {
    static int[][] adjacent;

    static int N, M, V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adjacent = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjacent[start][to] = 1;
            adjacent[to][start] = 1;
        }

        boolean[] dfsBool = new boolean[N + 1];
        dfsBool[V] = true;
        dfs(dfsBool, V);
        System.out.println();
    }


    public static void dfs(boolean[] visited, int start) {
        System.out.print(start + " ");

        for (int i = 1; i <= N; i++) {
            if(!visited[i] && adjacent[start][i] == 1) {
                visited[i] = true;
                dfs(visited, i);
            }
        }
    }
}

