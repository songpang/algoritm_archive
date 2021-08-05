package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1210 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int k = 0; k < 10; k++) {
            br.readLine();
            int[][] ladder = new int[100][100];
            int[] watOut = new int[2];

            for (int i = 0; i < 100; i++) {
                String[] input = br.readLine().split(" ");

                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = Integer.parseInt(input[j]);
                    if (ladder[i][j] == 2) {
                        watOut[0] = i - 1;
                        watOut[1] = j;
                    }
                }
            }

            while (watOut[0] > 0) {
                if (watOut[1] != 0 && ladder[watOut[0]][watOut[1] - 1] == 1) {
                    while (watOut[1] != 0 && ladder[watOut[0]][watOut[1] - 1] == 1) {
                        watOut[1]--;
                    }
                } else if (watOut[1] != 99 && ladder[watOut[0]][watOut[1] + 1] == 1) {
                    while (watOut[1] != 99 && ladder[watOut[0]][watOut[1] + 1] == 1) {
                        watOut[1]++;
                    }
                }
                watOut[0]--;
            }

            System.out.printf("#%d %d\n", k + 1, watOut[1]);
        }
    }
}
