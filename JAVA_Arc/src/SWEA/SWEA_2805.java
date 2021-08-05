package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int y = 1; y <= TC; y++) {
            int size = Integer.parseInt(br.readLine());
            int[][] farm = new int[size][size];
            for (int i = 0; i < size; i++) {
                int j = 0;
                for (char s : br.readLine().toCharArray()) {
                    farm[i][j++] = s - '0';
                }
            }

            int left = size / 2 - 1;
            int right = size / 2 + 1;
            int sum = farm[0][size / 2];
            int pl = 1;

            for (int i = 1; i < size; i++) {
                if (left == 0) {
                    pl *= -1;
                }
                for (int k = left; k <= right; k++) {
                    sum += farm[i][k];
                }
                left -= pl;
                right += pl;
            }

            System.out.printf("#%d %d\n", y, sum);
        }
    }
}