package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ_15683 {
    static int[][] DIR = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N, M, min;
    static List<Point> cctv;
    static int[][] map;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        min = Integer.MAX_VALUE;
        cctv = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && map[i][j] <= 5) {
                    cctv.add(new Point(i, j));
                }
            }
        }

        combination(0, map);
        System.out.println(min);
    }

    public static void combination(int count, int[][] map) {
        if (count == cctv.size()) {
            int hashCount = 0;
            for (int[] ints : map) {
                for (int anInt : ints) {
                    if (anInt == 0) {
                        hashCount++;
                        if(hashCount > min) {
                            return;
                        }
                    }
                }
            }

            min = Math.min(min, hashCount);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int number = map[cctv.get(count).x][cctv.get(count).y];
            Point cur = cctv.get(count);
            int[][] mapClone = deepCopy(map);

            switch (number) {
                // for 문의 인자와 속도
                // 인자가 변수이면 상수 일 때보다 속도가 느림
                // ex (number 이 들어가면 느려지고 3이 들어가면 빨라짐)
                case 1:
                    markMap(cur, i, mapClone);
                    break;
                case 2:
                    if(i >= 2) break;
                    for (int j = 0; j < 2; j++)
                        markMap(cur, (i + 2 * j) % 4, mapClone);
                    break;
                case 3:
                    for (int j = 0; j < 2; j++)
                        markMap(cur, (i + j) % 4, mapClone);
                    break;
                case 4:
                    for (int j = 0; j < 3; j++)
                        markMap(cur, (i + j) % 4, mapClone);
                    break;
                case 5:
                    if(i >= 1) break;
                    for (int j = 0; j < 4; j++)
                        markMap(cur, j, mapClone);
                    break;
            }
            combination(count + 1, mapClone);
        }
    }

    public static void markMap(Point point, int direction, int[][] map) {
        int nx = point.x + DIR[direction][0];
        int ny = point.y + DIR[direction][1];

        // 이 조건에서 실수가 많이나옴
        // 해당 값이
        while (nx >= 0 && ny >= 0 && nx < N && ny < M
                && map[nx][ny] != 6) {
            if(map[nx][ny] != 0) {
                nx += DIR[direction][0];
                ny += DIR[direction][1];
                continue;
            }
            map[nx][ny] = '#';
            nx += DIR[direction][0];
            ny += DIR[direction][1];
        }
    }

    static int[][] deepCopy(int[][] origin) {
        if (origin == null) return null;
        int[][] result = new int[origin.length][origin[0].length];

        for (int i = 0; i < origin.length; i++) {
            System.arraycopy(origin[i], 0, result[i], 0, origin[0].length);
        }

        return result;
    }
}