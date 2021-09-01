package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1303_BFS {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] army;
    static int N, M;
    static int[] score = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        army = new char[N][M];
        for (int i = 0; i < N; i++) {
            army[i] = br.readLine().toCharArray();
        }

        bfs(new boolean[N][M]);

        System.out.println(score[0] + " " + score[1]);
    }

    static int[][] DIR = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static void bfs(boolean[][] visited) {
        Queue<Point> aQ = new LinkedList<>();

        aQ.add(new Point(0, 0));
        visited[0][0] = true;
        int count = 1;

        while (!aQ.isEmpty()) {
            Point temp = aQ.poll();
            char friendlyOrHostile = army[temp.x][temp.y];

            for (int i = 0; i < 4; i++) {
                int nX = temp.x + DIR[i][0];
                int nY = temp.y + DIR[i][1];

                if (nX >= 0 && nY >= 0 && nX < N && nY < M
                        && !visited[nX][nY] && army[nX][nY] == friendlyOrHostile) {
                    visited[nX][nY] = true;
                    aQ.offer(new Point(nX, nY));
                    count++;
                }
            }

            if (aQ.isEmpty()) {
                if (friendlyOrHostile == 'W') {
                    score[0] += count * count;
                } else {
                    score[1] += count * count;
                }
                count = 1;

                loop:
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (!visited[i][j]) {
                            aQ.offer(new Point(i, j));
                            visited[i][j] = true;
                            break loop;
                        }
                    }
                }
            }
        }
    }
}















