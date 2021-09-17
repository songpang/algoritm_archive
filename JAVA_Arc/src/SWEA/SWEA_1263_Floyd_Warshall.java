package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1263_Floyd_Warshall {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] D = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    D[i][j] = Integer.parseInt(st.nextToken());
                    if (i != j && D[i][j] == 0) D[i][j] = Integer.MAX_VALUE / 2;
                }
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    if (i == k) continue;
                    for (int j = 0; j < N; j++) {
                        if (j == k || j == i) continue;
                        D[i][j] = Math.min(D[i][k] + D[k][j], D[i][j]);
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            for (int[] ints : D) {
                min = Math.min(Arrays.stream(ints).sum(), min);
            }

            System.out.printf("#%d %d\n", t, min);
        }
    }
}
