package backjoon;

import java.util.Scanner;

public class BJ_15652 {
    static StringBuilder sb = new StringBuilder();
    static int[] output;
    static int N, M;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        output = new int[M];

        permutation(0, 1);
        System.out.print(sb.toString());
    }

    public static void permutation(int count, int start) {
        if (M == count) {
            for (int i : output) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            output[count] = i;
            permutation(count + 1, i);
        }
    }
}
