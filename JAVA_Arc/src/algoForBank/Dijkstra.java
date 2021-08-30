package algoForBank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijkstra {
    public static void main(String[] args) throws IOException {
        int V, start, end;
        final int INFINITY;
        int[][] matrix;
        int[] distance;
        boolean[] visited;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(in.readLine().trim());
            //정점 갯수
            V = Integer.parseInt(st.nextToken());
            start = 0;
            //도착점 인덱스
            end = V - 1;
            INFINITY = Integer.MAX_VALUE;

            matrix = new int[V][V];
            distance = new int[V];
            visited = new boolean[V];

            for (int i = 0; i < V; ++i) {
                st = new StringTokenizer(in.readLine().trim(), " ");
                for (int j = 0; j < V; ++j) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        Arrays.fill(distance, INFINITY);
        distance[start] = 0;

        int min = 0, current = 0;
        for (int i = 0; i < V; ++i) {
            //a단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
            min = INFINITY;
            for (int j = 0; j < V; ++j) {
                if (!visited[j] && distance[j] < min) {
                    min = distance[j];
                    current = j;
                }
            }
            visited[current] = true; // 선택 정점 방문 처리
            if (current == end) { // 선택 정점이 도착정점이면 탈출.
                break;
            }

            //b단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
            for (int c = 0; c < V; ++c) {
                if (!visited[c] && matrix[current][c] != 0
                        && distance[c] > min + matrix[current][c]) {
                    distance[c] = min + matrix[current][c];
                }
            }
        }
        System.out.println(distance[end]);

    }
}
