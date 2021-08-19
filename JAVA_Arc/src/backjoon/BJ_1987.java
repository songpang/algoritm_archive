package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1987 {
    static String[][] map;
    static boolean[][] visited;
    static int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int R, C, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new String[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().split("");
        }

        max = 0;
        visited = new boolean[R][C];
        visited[0][0] = true;

        dfs(0, 0, "" + map[0][0], visited, 1);
        System.out.println(max);
    }

    public static void dfs(int row, int col, String alphabets, boolean[][] visited, int count) {
        for (int i = 0; i < 4; i++) {
            int nx = row + DIR[i][0];
            int ny = col + DIR[i][1];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if (!visited[nx][ny] && !alphabets.contains(map[nx][ny])) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, alphabets + map[nx][ny], visited, count + 1);
                    visited[nx][ny] = false;
                } else {
                    max = Math.max(max, count);
                }
            }
        }
    }
}

/*
    비트 연산자를 이용해서 중복을 검사한 코드. (백준 JAVA 속도 1등)
    다음에 중복 검사를 할 경우에 비트 연산을 이용해보자 !!!
    static void dfs(int x, int y, int bit, int cnt) {
        if (visit[x][y] == bit) return;
        visit[x][y] = bit;
        ans = Math.max(ans, cnt);
        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx == R || ny == C) continue;
            if ((bit & (1 << board[nx][ny] - 'A')) != 0) continue;
            dfs(nx, ny, bit | (1 << board[nx][ny] - 'A'), cnt + 1);
        }
    }
 */
