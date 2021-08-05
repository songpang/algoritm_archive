package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1954 {
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int size = sc.nextInt();

            int[][] output = new int[size][size];

            int count = 1;
            int i = 0;
            int j = 0;
            int dirSign = 0;

            while (count != size * size + 1) {
                output[i][j] = count++;
                i += direction[dirSign][0];
                j += direction[dirSign][1];
                //외곽이면
                if (i >= size || j >= size || i < 0
                        || j < 0 || output[i][j] != 0) {
                    i -= direction[dirSign][0];
                    j -= direction[dirSign][1];

                    dirSign = dirSign == 3 ? 0 : dirSign % 3 + 1;

                    i += direction[dirSign][0];
                    j += direction[dirSign][1];
                }
            }

            System.out.printf("#%d\n", test_case);
            for (int[] ints : output) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
        }
    }
}
