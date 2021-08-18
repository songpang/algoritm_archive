package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SWEA_4012 {
    static int N, T;
    static int[][] synergy = new int[16][16];
    static List<int[]> halfComb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                synergy[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
            }

            halfComb = new ArrayList<>();
            combination(0, 0, new int[N / 2]);

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N / 2; i++) {
                for (int j = halfComb.size() - 1; j > i; j--, i++) {
                    int tempMin = Math.abs(getSynergy(halfComb.get(i)) - getSynergy(halfComb.get(j)));
                    min = Math.min(min, tempMin);
                }
            }
            // 8
            // 0 1 2 3
            // i + 1

            // length - 1
            // 4 5 6 7

            System.out.printf("#%d %d\n", t, min);
        }
    }

    public static void combination(int count, int start, int[] output) {
        if (count == N / 2) {
            halfComb.add(output.clone());
            return;
        }

        for (int i = start; i < N; i++) {
            output[count] = i;
            combination(count + 1, i + 1, output);
        }
    }

    public static int getSynergy(int[] halfCombArr) {
        int result = 0;

        for (int j : halfCombArr) {
            for (int k : halfCombArr) {
                result += synergy[j][k];
            }
        }

        return result;
    }
}
