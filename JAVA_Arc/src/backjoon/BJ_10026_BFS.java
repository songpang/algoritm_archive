package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 백준 10026 적록 색약
public class BJ_10026_BFS {

    static int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N;
    static char[][] paint, blindPaint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        paint = new char[N][N];
        blindPaint = new char[N][N];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            paint[i] = temp.toCharArray();
            blindPaint[i] = temp.replaceAll("G", "R").toCharArray();
        }

        boolean[][] visited = new boolean[N][N];
        boolean[][] visited2 = new boolean[N][N];

        int count = 0;
        int count2 = 0;
        count = getCount(visited, count, paint);
        count2 = getCount(visited2, count2, blindPaint);

        System.out.print(count + " ");
        System.out.println(count2);
    }

    private static int getCount(boolean[][] visited, int count, char[][] paint) {
        char color;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    color = paint[i][j];
                    bfs(i, j, color, visited, paint);
                    count++;
                }
            }
        }
        return count;
    }

    public static void bfs(int x, int y, char color, boolean[][] visited, char[][] paint) {
        Queue<Point> colorQ = new LinkedList<>();
        int nextX = x;
        int nextY = y;

        colorQ.add(new Point(nextX, nextY, color));

        while(!colorQ.isEmpty()) {
            Point temp = colorQ.poll();

            for (int i = 0; i < 4; i++) {
                nextX = temp.x + DIR[i][0];
                nextY = temp.y + DIR[i][1];

                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && !visited[nextX][nextY]) {
                    if(paint[nextX][nextY] == color) {
                        visited[nextX][nextY] = true;
                        colorQ.add(new Point(nextX, nextY, color));
                    }
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        char color;

        public Point(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
