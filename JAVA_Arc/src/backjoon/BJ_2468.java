package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2468 {
    static int N;
    static int[][] place;
    static int resultMax = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        place = new int[N][N];

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                place[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, place[i][j]);
            }
        }

        boolean[][] visited;

        int count;
        while(true) {
            count = 0;
            visited = new boolean[N][N];
            // 매번 Arr 생성하지 않고 루프 돈 이후
            // false 초기화하면 메모리 줄고 시간 늘어남.
            for (int i = 0; i < N ; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j] && place[i][j] > min) {
                        count++;
                        bfs(visited, min, i, j);
                    }
                }
            }
            min++;
            resultMax = Math.max(resultMax, count);
            if(count == 0) break;
        }

        if(resultMax == 0) resultMax = 1;
        System.out.println(resultMax);
    }

    static int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void bfs(boolean[][] visited, int limit, int x, int y) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nX = temp[0] + DIR[i][0];
                int nY = temp[1] + DIR[i][1];

                if(nX >= 0 && nY >= 0 && nX < N  && nY < N
                        && !visited[nX][nY] && place[nX][nY] > limit) {
                    queue.add(new int[]{nX, nY});
                    visited[nX][nY] = true;
                }
            }
        }
    }
}
