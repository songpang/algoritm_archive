package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1767 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, mexiCount;
    static int[][] maxinos;
    static int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int max;
    static List<Point> points;
    static boolean[][] visited;
    static int wholeCore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            points = new ArrayList<>();
            visited = new boolean[N][N];
            max = 0;
            maxinos = new int[N][N];
            mexiCount = 0;
            maxSuccess = 0;
            wholeCore = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    maxinos[i][j] = Integer.parseInt(st.nextToken());
                    if (maxinos[i][j] == 1) {
                        wholeCore++;
                        if (!(i == 0 || j == 0 || i == N - 1 || j == N - 1)) {
                            points.add(new Point(i, j));
                            mexiCount++;
                        }
                        visited[i][j] = true;
                    }
                }
            }

            find(0, 0, 0, visited);
            System.out.printf("#%d %d\n", t, max);
        }
    }

    static int maxSuccess;
    public static void find(int sum, int count, int success, boolean[][] visited) {
        if (count == mexiCount) {
            if(maxSuccess < success) {
                maxSuccess = success;
                max = sum;
            } else if (maxSuccess == success) {
                max = max == 0 ? sum : Math.min(max, sum);
            }
            return;
        }

        if(wholeCore - count + success < maxSuccess) {
            return;
        }

        Point temp = points.get(count);
        for (int i = 0; i < 4; i++) {
            int nx = temp.x + DIR[i][0];
            int ny = temp.y + DIR[i][1];

            int localCount = 0;
            // 4방탐색 하는데 끝까지 해서 벽을 만나야됨
            while (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                nx += DIR[i][0];
                ny += DIR[i][1];
                localCount++;
            }

            boolean[][] visitedTemp = deepCopy(visited);
            if (nx >= N || ny >= N || nx < 0 || ny < 0) {
                nx -= DIR[i][0];
                ny -= DIR[i][1];

                while (!visitedTemp[nx][ny]) {
                    visitedTemp[nx][ny] = true;
                    nx -= DIR[i][0];
                    ny -= DIR[i][1];
                }
                success++;
                find(sum + localCount, count + 1, success, visitedTemp);
                success--;
                continue;
            }
            find(sum + localCount, count + 1, success, visitedTemp);
        }
    }

    static boolean[][] deepCopy(boolean[][] origin) {
        if (origin == null) return null;
        boolean[][] result = new boolean[origin.length][origin[0].length];

        for (int i = 0; i < origin.length; i++) {
            System.arraycopy(origin[i], 0, result[i], 0, origin[0].length);
        }

        return result;
    }
}