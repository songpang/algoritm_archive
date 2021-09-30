package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_1953_BFS {
    static int N, M, R, C, L;
    static int[][] tunnel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        tunnel = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tunnel[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs(new Point(R, C, 1), new boolean[N][M]);
            System.out.printf("#%d %d\n", t, result);
        }
    }

    static final int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int bfs(Point start, boolean[][] visited) {
        Queue<Point> pq = new LinkedList<>();
        pq.offer(start);
        visited[start.x][start.y] = true;

        int result = 0;
        while (!pq.isEmpty()) {
            Point current = pq.poll();

            if (current.count <= L) {
                result++;
            }

            List<int[]> dirs = new ArrayList<>();
            int direction = tunnel[current.x][current.y];
            switch (direction) {
                case 1:
                    dirs = Arrays.asList(DIR);
                    break;
                case 2:
                    dirs.add(DIR[0]);
                    dirs.add(DIR[1]);
                    break;
                case 3:
                    dirs.add(DIR[2]);
                    dirs.add(DIR[3]);
                    break;
                case 4:
                    dirs.add(DIR[1]);
                    dirs.add(DIR[2]);
                    break;
                case 5:
                    dirs.add(DIR[0]);
                    dirs.add(DIR[2]);
                    break;
                case 6:
                    dirs.add(DIR[0]);
                    dirs.add(DIR[3]);
                    break;
                case 7:
                    dirs.add(DIR[1]);
                    dirs.add(DIR[3]);
                    break;
            }

            for (int[] dir : dirs) {
                int nx = current.x + dir[0];
                int ny = current.y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M
                        && tunnel[nx][ny] != 0 && !visited[nx][ny]) {
                    int location = tunnel[nx][ny];

                    switch (location) {
                        case 2:
                            if (nx == current.x && (ny == current.y + 1 || ny == current.y - 1)) {
                                continue;
                            }
                            break;
                        case 3:
                            if ((nx == current.x + 1 || nx == current.x - 1) && ny == current.y) {
                                continue;
                            }
                            break;
                        case 4:
                            if ((nx == current.x - 1 && ny == current.y) || (nx == current.x && ny == current.y + 1)) {
                                continue;
                            }
                            break;
                        case 5:
                            if ((nx == current.x + 1 && ny == current.y) || (nx == current.x && ny == current.y + 1)) {
                                continue;
                            }
                            break;
                        case 6:
                            if ((nx == current.x + 1 && ny == current.y) || (nx == current.x && ny == current.y - 1)) {
                                continue;
                            }
                            break;
                        case 7:
                            if ((nx == current.x - 1 && ny == current.y) || (nx == current.x && ny == current.y - 1)) {
                                continue;
                            }
                            break;
                    }

                    visited[nx][ny] = true;
                    pq.offer(new Point(nx, ny, current.count + 1));
                }
            }
        }

        return result;
    }

    static class Point {
        int x, y, count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
