package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 7576 토마토
// 전형적인 BFS + 조건 1개.
// 퍼지는 바이러스 유형.

public class BJ_7576_BFS {
    static class Point {
        int x;
        int y;
        int day;

        public Point(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static int[][] box;
    static Queue<Point> goodTomato;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        goodTomato = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    goodTomato.add(new Point(i, j, 1));
                    box[i][j] = -2;
                }
            }
        }

        // 여기서 런타임 에러.
        if(goodTomato.size() > 0) {
            bfs(new boolean[N][M]);
        }

        int max = 0;
        loop:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(box[i][j] == 0) {
                    max = -1;
                    break loop;
                }
                max = Math.max(max, box[i][j]);
            }
        }

        System.out.println(max);
    }

    static int[][] DIR = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static void bfs(boolean[][] visited) {
        Point tomato = goodTomato.peek();
        visited[tomato.x][tomato.y] = true;

        while (!goodTomato.isEmpty()) {
            Point temp = goodTomato.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = temp.x + DIR[i][0];
                int nextY = temp.y + DIR[i][1];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M
                        && !visited[nextX][nextY]) {
                    int tomatoDay = box[nextX][nextY];
                    if (tomatoDay != -1 && tomatoDay != -2) {
                        if (tomatoDay > 0 && tomatoDay < temp.day) {
                            continue;
                        }

                        visited[nextX][nextY] = true;
                        Point newDay = new Point(nextX, nextY, temp.day + 1);

                        goodTomato.offer(newDay);
                        box[nextX][nextY] = temp.day;
                    }
                }
            }
        }
    }
}
