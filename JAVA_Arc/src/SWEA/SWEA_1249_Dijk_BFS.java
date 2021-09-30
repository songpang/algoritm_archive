package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1249_Dijk_BFS {
    static final int INF = Integer.MAX_VALUE;
    static final int[][] DIR = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] road = new int[N][N];
            int[][] edge = new int[N][N];

            for (int i = 0; i < N; i++) {
                char[] recovery = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    road[i][j] = recovery[j] - '0';
                    edge[i][j] = INF;
                }
            }

            edge[0][0] = 0;

            // bfs로 탐색하면서 최단거리 탐색?
            Queue<Point> pq = new LinkedList<>();
            pq.offer(new Point(0, 0));
            while (!pq.isEmpty()) {
                Point temp = pq.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = temp.x + DIR[i][0];
                    int ny = temp.y + DIR[i][1];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        if (edge[nx][ny] > edge[temp.x][temp.y] + road[nx][ny]) {
                            edge[nx][ny] = edge[temp.x][temp.y] + road[nx][ny];
                            pq.offer(new Point(nx, ny));
                        }
                    }
                }
            }

            System.out.printf("#%d %d\n", t, edge[N - 1][N - 1]);
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
