// 언어 : JAVA , 메모리 : 24964 KB , 시간 : 232 ms

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 1012 유기농 배추
// DFS, BFS 로 둘 다 풀 수 있다.
// 이경우 어떤 FS로 접근을 해야 되는 지 모르겠다.
// 그냥 BFS로 풀어야 할 것 같아서 BFS로 해결

public class BJ_1012 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, K;
    static int[][] field;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            field = new int[N][M];
            int x, y;
            List<Point> cabbage = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                field[x][y] = 1;
                cabbage.add(new Point(x, y));
            }

            int sum = 0;

            boolean[][] visited = new boolean[N][M];
            for (Point point : cabbage) {
                sum += bfs(visited, point);
            }

            System.out.println(sum);
        }
    }

    static int[][] DIR = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static int bfs(boolean[][] visited, Point target) {
        Queue<Point> worms = new LinkedList<>();
        worms.offer(target);

        int count = 0;
        while(!worms.isEmpty()) {
            Point temp = worms.poll();
            int x = temp.x, y = temp.y;

            if(!visited[x][y]) {
                count = 1;
                visited[x][y] = true;

                for (int i = 0; i < 4; i++) {
                    int nextX = x + DIR[i][0];
                    int nextY = y + DIR[i][1];

                    while(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M
                            && !visited[nextX][nextY] && field[nextX][nextY] == 1) {
                        worms.add(new Point(nextX, nextY));
                        nextX += DIR[i][0];
                        nextY += DIR[i][1];
                    }
                }
            }
         }

        return count;
    }
}
