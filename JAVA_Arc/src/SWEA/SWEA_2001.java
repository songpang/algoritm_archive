package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_2001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = new int[2];
        int count = 0;
        for (String s : br.readLine().split(" ")) {
            input[count++] = Integer.parseInt(s);
        }

        int[][] flies = new int[input[0]][input[0]];
        for (int i = 0; i < input[0]; i++) {
            count = 0;
            for (String s : br.readLine().split(" ")) {
                flies[i][count++] = Integer.parseInt(s);
            }
        }

        int max = 0;
        for (int i = 0; i <= input[0] - input[1]; i++) {
            for (int j = 0; j <= input[0] - input[1]; j++) {
                int temp = 0;
                for (int k = 0; k < input[1]; k++) {
                    for (int l = 0; l < input[1]; l++) {
                        temp += flies[i + k][j + l];
                    }
                }
                max = Math.max(max, temp);
            }
        }
        System.out.println(max);
    }
}
