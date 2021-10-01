package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4013 {
    static int[][] magnet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int K = Integer.parseInt(br.readLine());

            magnet = new int[4][8];
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    magnet[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int gear = Integer.parseInt(st.nextToken()) - 1;
                int dir = Integer.parseInt(st.nextToken());

                if (gear % 3 != 0) { // 2, 3번 기어
                    if (isMatch(gear - 1, gear)) {
                        if (gear == 2 && isMatch(0, 1)) {
                            rotate(-dir, 0);
                        }
                        rotate(dir, gear - 1);
                    }

                    if (isMatch(gear, gear + 1)) {
                        // 돌리기
                        if (gear == 1 && isMatch(2, 3)) {
                            rotate(-dir, 3);
                        }
                        rotate(dir, gear + 1);
                    }
                } else {
                    int start = (gear + 1) / 2; // 0 2
                    int pl = gear == 0 ? 1 : -1;
                    if (isMatch(start, start + 1)) {
                        if (isMatch(start + pl, start + pl + 1)) {
                            if (isMatch(start + 2 * pl, start + 2 * pl + 1)) {
                                rotate(dir, gear + 3 * pl);
                            }
                            rotate(-dir, gear + 2 * pl);
                        }
                        rotate(dir, gear + pl);
                    }
                }
                rotate(-dir, gear);
            }

            int result = 0;
            for (int i = 0; i < 4; i++) {
                if (magnet[i][0] == 1) {
                    result += Math.pow(2, i);
                }
            }
            System.out.printf("#%d %d\n", t, result);
        }
    }

    private static boolean isMatch(int prev, int next) {
        return magnet[prev][2] != magnet[next][6];
    }

    private static void rotate(int dir, int gear) {
        if (dir > 0) {
            // 시계방향으로 돌아갔으니 반시계 방향으로 돌려야 함
            int temp = magnet[gear][0];
            for (int i = 0; i <= 6; i++) {
                magnet[gear][i] = magnet[gear][i + 1];
            }
            magnet[gear][7] = temp;
        } else {
            int temp = magnet[gear][7];
            for (int i = 7; i > 0; i--) {
                magnet[gear][i] = magnet[gear][i - 1];
            }
            magnet[gear][0] = temp;
        }
    }
}





















