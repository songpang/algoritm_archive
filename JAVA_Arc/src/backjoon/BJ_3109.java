package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3109 {
    static int R, C;
    static int pipeCount = 0;
    static char[][] map;
    static boolean[][] visited;
    static int[][] DIR = {{-1, 1}, {0, 1}, {1, 1}};
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        map = new char[R + 1][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
//            flag = false;
//            visited[i][0] = true;
            dfs(i, 0, visited);
        }

        System.out.println(pipeCount);
    }

//     Mine
    public static boolean dfs(int row, int col, boolean[][] visited) {
        if (col == C - 1 && !visited[row][col]) {
            pipeCount++;
            visited[row][col] = true;
            return true;
        }

        if (map[row][col] == 'x' || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;
        if (row - 1 >= 0 && col + 1 < C && dfs(row - 1, col + 1, visited)) {
            return true;
        } else if (col + 1 < C && dfs(row, col + 1, visited)) {
            return true;
        } else if (col + 1 < C && row + 1 < R && dfs(row + 1, col + 1, visited)) {
            return true;
        }

        return false;
    }

//    public static void dfs (int row, int col) {
//        if(col == C - 1) {
//            visited[row][col] = true;
//            pipeCount++;
//            flag = true;
//            return;
//        }
//
//        for (int i = 0; i < 3; i++) {
//            int nx = row + DIR[i][0];
//            int ny = col + DIR[i][1];
//
//            if(nx >= 0 && ny >= 0 && nx < R && ny < C
//            && !visited[nx][ny] && map[nx][ny] == '.' && !flag) {
//                visited[nx][ny] = true;
//                dfs(nx, ny);
//            }
//        }
//    }
}



/*
static void find(int cnt, int x, int y, int index, int[][] map) {
        if (cnt == M) {
            flag = false;
            max++;
            return;
        }
        for (int h = 0; h < 3; h++) {
            int nx = x + dx[h];
            int ny = y + dy[h];
            if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1)
                continue;
            if (map[nx][ny] != 0)
                continue;
            if (flag) {
                find(cnt + 1, nx, ny, index, map);
            } else
                return;
        }
    }
 */