package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 17143 낚시왕
// 낚시왕이 서있는 열에있는 상어 잡는 문제
// 정렬 2번 -> 시간초과 -> 1번으로 바꾸니 통과

public class BJ_17143_Simulation_Moving {
    static class Shark {
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static int[][] DIR = {{}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Shark> sharks = new ArrayList<>();
        Shark[][] sea = new Shark[R + 1][C + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            Shark baby = new Shark(r, c, s, d, z);
            sharks.add(baby);
            sea[r][c] = baby;
        }

        int fisher = 0;
        int fishAmount = 0;
        // 마지막 칸에 이동하면 멈춤
        while (fisher < C) {
            // 오른쪽으로 한 칸 이동
            fisher++;
            for (int j = 0; j < R + 1; j++) {
                if (sea[j][fisher] != null && sea[j][fisher].z != 0) {
                    fishAmount += sea[j][fisher].z;
                    sea[j][fisher].z = 0;
                    break;
                }
            }

            // 상어 이동
            for (Shark shark : sharks) {
                if (shark.z == 0) continue;
                int move, pl;
                if (shark.d > 2) { // 우 좌
                    move = (shark.s % (2 * (C - 1)));
                    pl = DIR[shark.d][1];
                    if (move == 0 && shark.s / (2 * (C - 1)) > 0) {
                        shark.d += pl;
                    }

                    while (move > 0) {
                        shark.c += pl;
                        if (shark.c < 1 || shark.c > C) {
                            shark.d += pl;
                            pl *= -1;
                            move++;
                            continue;
                        }
                        move--;
                    }
                } else { // 상 하
                    move = (shark.s % (2 * (R - 1)));
                    pl = DIR[shark.d][0];
                    if (move == 0 && shark.s / (2 * (R - 1)) > 0) {
                        shark.d += -pl;
                    }

                    while (move > 0) {
                        // 상어가 격자 밖으로 나가면 반대로 이동
                        shark.r += pl;
                        if (shark.r < 1 || shark.r > R) {
                            pl *= -1;
                            shark.d += pl;
                            move++;
                            continue;
                        }
                        move--;
                    }
                }
            }

            // 상어가 이동한 후 2마리 이상이면 가장 큰 상어만 남음
            sea = new Shark[R + 1][C + 1];
            sharks.sort(Comparator.comparingInt(o -> -o.z));
            for (Shark shark : sharks) {
                if (sea[shark.r][shark.c] == null) {
                    sea[shark.r][shark.c] = shark;
                } else {
                    shark.z = 0;
                }
            }
        }

        System.out.println(fishAmount);
    }
}
