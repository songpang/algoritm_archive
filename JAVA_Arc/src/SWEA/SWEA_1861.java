package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1861 {
    static int max;
    static final int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] room;
    static int location;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int M = Integer.parseInt(br.readLine());

            max = 1;
            location = 1001;
            room = new int[M][M];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
//                room[i] = Arrays.stream(br.readLine().split(" "))
//                        .mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < M; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    dfs(i, j, room[i][j], 1);
                }
            }

            System.out.printf("#%d %d %d\n", t, location, max);
        }
    }

    private static void dfs(int x, int y, int curL, int count) {
        for (int i = 0; i < 4; i++) {
            int newX = x + DIRECTION[i][0];
            int newY = y + DIRECTION[i][1];

            if (newX < 0 || newY < 0 || newX >= room.length || newY >= room.length) {
                continue;
            }

            if (room[newX][newY] == room[x][y] + 1) {
                dfs(newX, newY, curL, count + 1);
                break;
            }
        }

        if (count >= max) {
            location = count == max ? Math.min(curL, location) : curL;
            max = count;
        }
    }
}
