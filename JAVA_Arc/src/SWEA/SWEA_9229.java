package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_9229 {
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int M, N, limit;
        int left, right;
        int[] snacks;

        M = Integer.parseInt(br.readLine());
        for (int t = 1; t <= M; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());

            snacks = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                snacks[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(snacks);

            max = -1;
            left = 0;
            right = N - 1;
            while (left < right) {
                int curWeight = snacks[left] + snacks[right];
                if (curWeight <= limit) {
                    max = Math.max(max, curWeight);
                    left++;
                } else {
                    right--;
                }
            }
            System.out.printf("#%d %d\n", t, max);
        }
    }
}
