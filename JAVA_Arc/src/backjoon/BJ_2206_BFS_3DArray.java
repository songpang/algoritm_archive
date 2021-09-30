// 언어 : JAVA , 메모리 : 134524 KB , 시간 : 624 ms

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2206_BFS_3DArray {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j] - '0';
            }
        }

        bfs(new boolean[N][M][2]);
    }


    static final int[][] DIR = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static void bfs(boolean[][][] visited) {
        Queue<Point> pq = new LinkedList<>();
        pq.offer(new Point(0, 0, 0, 1));
        visited[0][0][0] = true;

        while (!pq.isEmpty()) {
            Point temp = pq.poll();

            if(temp.x == N -1 && temp.y == M -1) {
                System.out.println(temp.count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + DIR[i][0];
                int ny = temp.y + DIR[i][1];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny][temp.wall]) {
                    if (map[nx][ny] == 1) {
                        if (temp.wall == 0) {
                            visited[nx][ny][temp.wall] = true;
                            pq.offer(new Point(nx, ny, 1, temp.count + 1));
                        }
                    } else {
                        visited[nx][ny][temp.wall] = true;
                        pq.offer(new Point(nx, ny, temp.wall, temp.count + 1));
                    }
                }
            }
        }

        System.out.println(-1);

    }

    static class Point {
        int x;
        int y;
        int wall;
        int count;

        public Point(int x, int y, int wall, int count) {
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.count = count;
        }
    }
}
