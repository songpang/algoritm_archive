package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1260 {
    static Node[][] adjacent;

    static class Node {
        int vertex;
        Node link;

        public Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }
    }

    static int N, M, V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adjacent = new Node[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());


        }

        dfs(new boolean[N + 1], V);
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
//                if (!visited[i] && adjacent[temp][i] == 1) {
//                    visited[i] = true;
//                    nodeQ.offer(i);
//                }
            }
        }
    }

    public static void dfs(boolean[] visited, int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 1; i <= N; i++) {
//            if(!visited[i] && adjacent[start][i] == 1) {
//                dfs(visited, i);
//            }
        }
    }
}
