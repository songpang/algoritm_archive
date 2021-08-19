package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] DP = new int[N + 1];
        DP[0] = 0;

        if(N >= 1) {
            DP[1] = 1;
        }
        if(N >= 2) {
            for (int i = 2; i < N + 1; i++) {
                DP[i] = DP[i - 1] + DP[i - 2];
            }
        }

        System.out.println(DP[N]);
    }
}
