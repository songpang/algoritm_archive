package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_5644 {
    static int M, A;
    static int[][] user;
    static int[][] batteries;
    static int[][] DIR = new int[][]{{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] MA = br.readLine().split(" ");
            M = Integer.parseInt(MA[0]);
            A = Integer.parseInt(MA[1]);

            user = new int[2][];
            for (int i = 0; i < 2; i++) {
                user[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
            }

            batteries = new int[A][];
            for (int i = 0; i < A; i++) {
                batteries[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
            }

            String[][] map = new String[10][10];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    // 각 위치 별로 가까운 배터리 거리 구하기.
                    map[i][j] = "";
                    for (int k = 0, bLength = batteries.length; k < bLength; k++) {
                        if (batteries[k][2] >= getDistance(i, j, batteries[k][1] - 1, batteries[k][0] - 1)) {
                            map[i][j] += k;
                        }
                    }
                }
            }

            int capacity = 0;

            int[] curA = new int[]{0, 0};
            int[] curB = new int[]{9, 9};

            int location = 0, location2 = 0;
            for (int i = 0; i <= M; i++) {
                // 배터리 위치가 가까우면
                int size, maxCapacity = 0;
                int maxLocation1 = 100, maxLocation2 = 100;
                if (!map[curA[0]][curA[1]].equals("")) {
                    size = map[curA[0]][curA[1]].length();
                    maxCapacity = 0;
                    maxLocation1 = 0;

                    while (size != 0) {
                        location = map[curA[0]][curA[1]].charAt(--size) - '0';
                        if (maxCapacity < batteries[location][3]) {
                            maxCapacity = batteries[location][3];
                            maxLocation1 = location;
                        }
                    }

                    capacity += maxCapacity;
                }

                if (!map[curB[0]][curB[1]].equals("")) {
                    size = map[curB[0]][curB[1]].length();
                    maxCapacity = 0;
                    maxLocation2 = 0;

                    while (size != 0) {
                        location = map[curB[0]][curB[1]].charAt(--size) - '0';
                        if (maxCapacity < batteries[location][3]) {
                            maxCapacity = batteries[location][3];
                            maxLocation2 = location;
                        }
                    }

                    capacity += maxCapacity;
                }

                if (maxLocation1 != 100 && maxLocation1 == maxLocation2) {
                    // A의 위치에 2개 이상인지
                    if (map[curA[0]][curA[1]].length() == 1 &&
                            map[curB[0]][curB[1]].length() == 1) {
                        capacity -= maxCapacity;
                    } else {
                        capacity -= maxCapacity * 2;
                        int temp = 2 * maxCapacity;
                        maxCapacity = 0;
                        int size1 = map[curA[0]][curA[1]].length();
                        int size2 = map[curB[0]][curB[1]].length();

                        for (int j = 0; j < size1; j++) {
                            for (int k = 0; k < size2; k++) {
                                maxLocation1 = map[curA[0]][curA[1]].charAt(j) - '0';
                                maxLocation2 = map[curB[0]][curB[1]].charAt(k) - '0';
                                int tempMax = batteries[maxLocation1][3] + batteries[maxLocation2][3];
                                if (tempMax != temp) {
                                    maxCapacity = Math.max(maxCapacity, tempMax);
                                }
                            }
                        }

                        capacity += maxCapacity;
                    }
                }
                // 사용자 위치 업데이트
                if (i == M) break;
                curA[0] += DIR[user[0][i]][0];
                curA[1] += DIR[user[0][i]][1];
                curB[0] += DIR[user[1][i]][0];
                curB[1] += DIR[user[1][i]][1];
            }

            System.out.printf("#%d %d\n", t, capacity);
        }
    }

    public static double getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}