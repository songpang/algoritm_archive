package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_7576 {
    static class Point {
        int x;
        int y;
        int day;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] box;
    static List<Point> goodTomato;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        goodTomato = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            box[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < M; j++) {
                if (box[i][j] == 1) {
                    goodTomato.add(new Point(i, j));
                }
            }
        }


    }

    static int[][] DIR = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static void bfs(Point tomato) {
        Queue<Point> gTomato = new LinkedList<>();
        gTomato.offer(tomato);

        int day = 0;
        while (!gTomato.isEmpty()) {
            Point temp = gTomato.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = temp.x + DIR[i][0];
                int nextY = temp.y + DIR[i][1];

                while (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && box[nextX][nextY] == 0) {
                    Point nTomato = new Point(nextX, nextY);
                    nTomato.day = day + 1;
                    gTomato.offer(nTomato);
                    box[nextX][nextY] = day;
                    nextX += DIR[i][0];
                    nextY += DIR[i][0];
                }
            }

        }
    }
}
