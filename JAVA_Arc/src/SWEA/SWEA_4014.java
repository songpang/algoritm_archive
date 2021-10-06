package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014 {
    static int[][] map;
    static int[] minRow;
    static int N, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

//        int T = Integer.parseInt(br.readLine());
//        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            minRow = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    min = Math.min(min, map[i][j]);
                }
                minRow[i] = min;
            }

            int count = 0;

            loop:
            for (int i = 0; i < N; i++) {
                if (isFlatRow(map[i])) { // 1 다 똑같은 숫자
                    count++;
                } else {
                    int min = map[i][0];
                    int flatCount = 1;
                    int before = min;
                    for (int j = 1; j < N; j++) {
                        if (min == map[i][j]) {
                            flatCount++;
                        } else if (min == map[i][j] - 1) { // 다음 경사가 높으면
                            if (flatCount < X) {
                                continue loop;
                            }
                            before = min;
                            min = map[i][j];
                            flatCount = 1;
                        } else if (min == map[i][j] + 1) {
                            if (before != map[i][j]) {
                                if (flatCount == j) {
                                } else if (flatCount < X) {
                                    continue loop;
                                }
                            }
                            before = min;
                            min = map[i][j];
                            flatCount = 1;
                        } else {
                            continue loop;
                        }
                    }

                    if (min < before && flatCount < X) {
                        continue;
                    }
                    count++;
                }
            }

            loop:
            for (int i = 0; i < N; i++) {
                if (isFlatColumn(i)) { // 1 다 똑같은 숫자
                    count++;
                } else {
                    int min = map[0][i];
                    int flatCount = 1;
                    int before = min;
                    for (int j = 1; j < N; j++) {
                        if (min == map[j][i]) {
                            flatCount++;
                        } else if (min == map[j][i] - 1) { // 다음 경사가 높으면
                            if (flatCount < X) {
                                continue loop;
                            }
                            before = min;
                            min = map[j][i];
                            flatCount = 1;
                        } else if (min == map[j][i] + 1) {
                            if (before != map[j][i]) {
                                if (flatCount == j) {
                                } else if (flatCount < X) {
                                    continue loop;
                                }
                            }
                            before = min;
                            min = map[j][i];
                            flatCount = 1;
                        } else {
                            continue loop;
                        }
                    }

                    if (min < before && flatCount < X) {
                        continue;
                    }
                    count++;
                }
            }


            // 될 수 있는 유형

            // 2 높은 숫자 유지되다가 1 낮은 숫자로 유지됨
            // 3 낮은 숫자 있다가 높은 숫자 있다가 낮은 숫자

//            System.out.printf("#%d %d\n", t, count);
            System.out.printf("%d\n", count);
//        }
    }

    private static boolean isFlatRow(int[] row) {
        int value = row[0];
        for (int i : row) {
            if (i != value) return false;
        }

        return true;
    }

    private static boolean isFlatColumn(int col) {
        int value = map[0][col];
        for (int i = 1; i < N; i++) {
            if(map[i][col] != value) return false;
        }

        return true;
    }
}
