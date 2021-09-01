package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 2178 미로 탈출

// (개선 전 코드는) class 에 weight 변수를 추가해서 처리했기 때문에 좀 더 느림.
// 아예 Q에 찬 값들을 다 소비해버리고 count++하는 방식으로 바꾸니 15% 빨라짐.
// visited 배열 없애고 그냥 원본 배열 값을 0으로 바꿔버리니 5%정도 더 개선.

public class BJ_2178 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] maze = new char[N][M];

        for (int i = 0; i < N; i++) {
            maze[i] = br.readLine().toCharArray();
        }

        int result = bfs(N, M, maze);

        System.out.println(result);

    }

    static int[][] DIR = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static int bfs(int n, int m, char[][] maze) {
        Queue<Point> pQ = new LinkedList<>();

        pQ.offer(new Point(0, 0));
        maze[0][0] = '0';

        int count = 1;
        while (!pQ.isEmpty()) {

            int size = pQ.size();
            for (int t = 0; t < size; t++) {
                Point temp = pQ.poll();

                if (temp.x == n - 1 && temp.y == m - 1) {
                    return count;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = temp.x + DIR[i][0];
                    int ny = temp.y + DIR[i][1];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M && maze[nx][ny] == '1') {
                        maze[nx][ny] = '0';
                        pQ.offer(new Point(nx, ny));
                    }
                }
            }
            count++;
        }

        return -1;
    }

    // 개선 전 코드


//    public static int bfs(int n, int m, char[][] maze, boolean[][] visited) {
//        Queue<Point> pQ = new LinkedList<>();
//
//        pQ.offer(new Point(0, 0, 1));
//        visited[0][0] = true;
//
//        while (!pQ.isEmpty()) {
//            Point temp = pQ.poll();
//
//            if(temp.x == n - 1 && temp.y == m - 1) {
//                return temp.weight;
//            }
//
//            for (int i = 0; i < 4; i++) {
//                int nx = temp.x + DIR[i][0];
//                int ny = temp.y + DIR[i][1];
//
//                if(nx >= 0 && ny >= 0 && nx < N && ny < M && maze[nx][ny] == '1' && !visited[nx][ny]) {
//                    visited[nx][ny] = true;
//                    pQ.offer(new Point(nx, ny, temp.weight + 1));
//                }
//            }
//        }
//
//        return -1;
//    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
