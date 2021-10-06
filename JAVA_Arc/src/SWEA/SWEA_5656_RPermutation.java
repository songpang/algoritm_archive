package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5656_RPermutation {
    static int N, W, H;
    static int[][] map;
    static int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;
            repetitionPermutation(0, new int[N]);
            System.out.printf("#%d %d\n", t, min);
        }
    }

    private static void fill(int[][] map) {
        for (int i = 0; i < W; i++) {
            for (int j = H - 1; j >= 0; j--) {
                if (map[j][i] != 0) {
                    // 맨 아래로 내리기
                    int temp = map[j][i];
                    map[j][i] = 0;
                    int curHeight = j;
                    while (curHeight + 1 < H && map[curHeight + 1][i] == 0) {
                        curHeight++;
                    }
                    map[curHeight][i] = temp;
                }
            }
        }
    }


    public static void drop(int column, int[][] map) {
        for (int i = 0; i < H; i++) {
            if (map[i][column] != 0) {
                hit(i, column, map);
                break;
            }
        }
    }

    public static void hit(int x, int y, int[][] map) {
        int weight = map[x][y] - 1;
        map[x][y] = 0;

        for (int t = 1; t <= weight; t++) {
            for (int j = 0; j < 4; j++) {
                int nx = x + DIR[j][0] * t;
                int ny = y + DIR[j][1] * t;

                // 범위 안이고 0이 아니면
                if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] != 0) {
                    if (map[nx][ny] > 1) {
                        hit(nx, ny, map);
                    } else {
                        map[nx][ny] = 0;
                    }
                }
            }
        }
    }

    static int min;

    public static void repetitionPermutation(int count, int[] output) {
        if (count == N) {
            int[][] temp = new int[H][W];
            for (int i = 0; i < H; i++) {
                temp[i] = map[i].clone();
            }

            for (int i : output) {
                drop(i, temp);
                fill(temp);
            }

            int brickCount = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (temp[i][j] != 0) {
                        brickCount++;
                    }
                }
            }

            min = Math.min(min, brickCount);
            return;
        }

        for (int i = 0; i < W; i++) {
            output[count] = i;
            repetitionPermutation(count + 1, output);
        }
    }

}
