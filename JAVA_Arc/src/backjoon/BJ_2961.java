package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2961 {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] taste = new int[N][2];

        for (int i = 0; i < N; i++) {
            taste[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int S;
        int B;
        for (int t = 0; t < 1 << N; t++) {
            S = 1;
            B = 0;
            for (int i = 0; i < N; i++) {
                if((t & 1 << i) != 0) {
                    S *= taste[i][0];
                    B += taste[i][1];
                }
            }
            if (B != 0) {
                min = Math.min(min, Math.abs(S - B));
            }
        }

        System.out.println(min);
    }
}
