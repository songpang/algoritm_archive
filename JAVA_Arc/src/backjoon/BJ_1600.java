package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1600 {
    static class Point {
        int x;
        int y;
        int depth;
        int K;

        public Point(int x, int y, int depth, int k) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            K = k;
        }
    }

    static int K, W, H;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[W][H];
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < H; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(new boolean[W][H][K + 1]);
        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);
    }

    static int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {-2, 1}, {-2, -1}, {1, 2}, {1, -2},
            {2, 1}, {2, -1}, {-1, 2}, {-1, -2}};
    static int min = Integer.MAX_VALUE;

    public static void bfs(boolean[][][] visited) {
        Queue<Point> pq = new LinkedList<>();
        pq.offer(new Point(0, 0, 0, K));
        visited[0][0][K] = true;

        while (!pq.isEmpty()) {
            Point temp = pq.poll();
            if (temp.x == W - 1 && temp.y == H - 1) {
                min = temp.depth;
                return;
            }

            for (int i = 0; i < 12; i++) {
                int nx = temp.x + DIR[i][0];
                int ny = temp.y + DIR[i][1];

                if (nx >= 0 && ny >= 0 && nx < W && ny < H && map[nx][ny] != 1) {

                    if (i <= 3 && !visited[nx][ny][temp.K]) {
                        visited[nx][ny][temp.K] = true;
                        pq.offer(new Point(nx, ny, temp.depth + 1, temp.K));
                    } else if (temp.K > 0) {
                        if (!visited[nx][ny][temp.K - 1]) {
                            visited[nx][ny][temp.K - 1] = true;
                            pq.offer(new Point(nx, ny, temp.depth + 1, temp.K - 1));
                        }
                    }
                }
            }
        }
    }
}
/*
1
3 4
0 0 0
1 1 0
1 1 1
1 0 0
 */