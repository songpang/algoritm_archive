package algoForBank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS {
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
        System.out.println();
        bfs(new boolean[N + 1], V);
    }

    public static void bfs(boolean[] visited, int start) {
        Queue<Integer> nodeQ = new LinkedList<>();
        nodeQ.offer(start);
        visited[start] = true;

        while (!nodeQ.isEmpty()) {
            int temp = nodeQ.poll();
            System.out.print(temp + " ");

            for (int i = 1; i < adjacent.length; i++) {
                if (!visited[i] && adjacent[temp][i] == 1) {
                    visited[i] = true;
                    nodeQ.offer(i);
                }
            }
        }
    }
}

