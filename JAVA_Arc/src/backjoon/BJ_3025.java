package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3025 {
    static int R, C, N;
    static char[][] map;
    static Point[][] memo = new Point[33][30003];
    static int idx[] = new int[33];

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp2 = br.readLine().split(" ");
        R = Integer.parseInt(temp2[0]);
        C = Integer.parseInt(temp2[1]);

        // Map 입력
        map = new char[R + 1][C + 1];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        N = Integer.parseInt(br.readLine());
        // 화산탄의 횟수 N을 입력받고 반복 시작.
        int x, y, col;
        for (int i = 0; i < N; i++) {
            col = Integer.parseInt(br.readLine()) - 1;
            x = 0;
            y = col;

            while (idx[col] > 0) { // col열에서 떨어뜨린 돌의 체크포인트 개수
                x = memo[col][idx[col]-1].x;
                y = memo[col][idx[col]-1].y;
                if (map[x][y] != '.')
                    --idx[col];
                else break;
            }

            if(idx[col] == 0) {
                x = 0;
                y = col;
            }

            while (true) {
                // 아래가 장애물이거나 가장 아랫줄이면 그자리에 O
                if (x + 1 == R || map[x + 1][y] == 'X') {
                    map[x][y] = 'O';
                    break;
                } else if (x + 1 < R && map[x + 1][y] == 'O') {
                    // 아래가 굳은 화산탄이면 왼쪽 오른쪽 체크
                    // 빈곳 있으면 그자리로 가기 위해 각 변수에 --, ++
                    if (y - 1 >= 0 && map[x + 1][y - 1] == '.' && map[x][y - 1] == '.') {
                        memo[col][idx[col]] = new Point(x, y);
                        idx[col]++;
                        y--;
                        continue;
                    } else if (y + 1 < C && map[x + 1][y + 1] == '.' && map[x][y + 1] == '.') {
                        memo[col][idx[col]] = new Point(x, y);
                        idx[col]++;
                        y++;
                        continue;
                    } else {
                        // 셋다 화산탄이면 그냥 그자리에 O
                        map[x][y] = 'O';
                        break;
                    }
                }
                while (x + 1 < R && map[x + 1][y] == '.') {
                    x++;
                }
            }
        }
        // 완성된 배열 출력하는 부분.
        StringBuilder sb = new StringBuilder();
        for (char[] m : map) {
            for (char m1 : m) {
                sb.append(m1);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}