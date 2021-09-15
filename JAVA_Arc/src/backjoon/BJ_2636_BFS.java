package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 2636 치즈
// BFS 문제, 풀고나면 쉬운 문제지만
// 풀이를 생각해내기까지 고민이 좀 필요했던 문제.

public class BJ_2636_BFS {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] plate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        plate = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                plate[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0;
        int last = 0;
        for (int i = 0; i < N; i++) {
            int temp = bfs(new boolean[N][M]);
            if (temp == 0) break;
            last = temp;
            sum++;
        }

        System.out.println(sum);
        System.out.println(last);
    }

    static int[][] DIR = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static int bfs(boolean[][] visited) {
        Queue<Point> pq = new LinkedList<>();
        pq.add(new Point(0, 0));
        visited[0][0] = true;

        int count = 0;

        while (!pq.isEmpty()) {
            Point temp = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + DIR[i][0];
                int ny = temp.y + DIR[i][1];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                    if (plate[nx][ny] == 0) {
                        pq.offer(new Point(nx, ny));
                    } else {
                        count++;
                        plate[nx][ny] = 0;
                    }
                    visited[nx][ny] = true;
                }
            }
        }

        return count;
    }
}
