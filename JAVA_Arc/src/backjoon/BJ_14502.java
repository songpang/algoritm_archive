package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ_14502 {
    static int N, M, max;
    static int[][] map;
    static List<Point> zeroLocation = new ArrayList<>();
    static List<Point> virusLocation = new ArrayList<>();
    static int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    zeroLocation.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    virusLocation.add(new Point(i, j));
                }
            }
        }

        max = 0;
        combination(0, 0, new Point[3], zeroLocation.size());

        System.out.println(max);
    }

    public static void combination(int count, int start, Point[] points, int size) {
        if (count == 3) {
            int[][] mapClone = deepCopy(map);

            // 벽 쌓기
            for (Point point : points) {
                mapClone[point.x][point.y] = 1;
            }

            for (Point point : virusLocation) {
                spreadVirus(point, mapClone);
            }

            int zeroCount = 0;
            for (int[] ints : mapClone) {
                for (int anInt : ints) {
                    if (anInt == 0) {
                        zeroCount++;
                    }
                }
            }

            max = Math.max(max, zeroCount);
            return;
        }

        for (int i = start; i < size; i++) {
            points[count] = zeroLocation.get(i);
            combination(count + 1, i + 1, points, size);
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void spreadVirus(Point virus, int[][] map) {
        if (!(virus.x >= 0 && virus.y >= 0 && virus.x < N && virus.y < M && map[virus.x][virus.y] != 1)) {
            return;
        }

        map[virus.x][virus.y] = 2;

        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = virus.x + DIR[i][0];
            ny = virus.y + DIR[i][1];
            if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 2) {
                nx = virus.x + DIR[i][0];
                ny = virus.y + DIR[i][1];
                spreadVirus(new Point(nx, ny), map);
                return;
            }

            spreadVirus(new Point(nx, ny), map);
        }
        // 첫 바이러스에서 사방향으로 감
        // 그 사뱡향에서 또 사방향으로 감
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
