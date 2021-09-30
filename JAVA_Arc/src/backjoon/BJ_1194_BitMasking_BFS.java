package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 1194 달이 차오른다, 가자
// 비트마스킹을 이용해 3차원 배열을 사용해야함
//
public class BJ_1194_BitMasking_BFS {
    static class Point {
        int x;
        int y;
        int count;
        int key;

        public Point(int x, int y, int count, int key) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.key = key;
        }
    }

    static int N, M;
    static char[][] maze;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new char[N][M];
        Point start = null;
        for (int i = 0; i < N; i++) {
            maze[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if(maze[i][j] == '0') {
                    start = new Point(i, j, 0, 0);
                    break;
                }
            }
        }

        visited = new boolean[N][M][64];
        bfs(start);
    }

    static int[][] DIR = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public static void bfs(Point start) {
        Queue<Point> pq = new LinkedList<>();
        pq.add(start);
        visited[start.x][start.y][0] = true;

        while (!pq.isEmpty()) {
            Point temp = pq.poll();

            if(maze[temp.x][temp.y] == '1') { // BFS 탐색이기 때문에 찾으면 그냥 바로 탈출출                System.out.println(temp.count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + DIR[i][0];
                int ny = temp.y + DIR[i][1];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M &&
                !visited[nx][ny][temp.key] && maze[nx][ny] != '#') {
                    char tempV = maze[nx][ny];

                    if (tempV >= 'a' && tempV <= 'f') { // 키일 경우
                        int tempKey = (1 << (tempV - 'a')) | temp.key;

                        visited[nx][ny][temp.key] = true;
                        pq.add(new Point(nx, ny, temp.count + 1, tempKey));
                    } else if (tempV >= 'A' && tempV <= 'F'){ // 문일 경우
                        int compareKey = (1 << (tempV - 'A')) & temp.key;

                        if(compareKey > 0) {
                            visited[nx][ny][temp.key] = true;
                            pq.add(new Point(nx, ny, temp.count + 1, temp.key));
                        }
                    } else { // 키, 문 둘 다 아닐 경우
                        pq.add(new Point(nx, ny, temp.count + 1, temp.key));
                        visited[nx][ny][temp.key] = true;
                    }
                }
            }
        }

        System.out.println(-1);
    }
}
