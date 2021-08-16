package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_15665 {
    static int N, M;
    static int[] output;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine();

        output = new int[M];

        int[] inputArr = new int[N];
        int idx = 0;
        for (String s : scanner.nextLine().split(" ")) {
            inputArr[idx++] = Integer.parseInt(s);
        }
        Arrays.sort(inputArr);

        permutation(0, 0, output, inputArr);
        System.out.print(sb.toString());
    }

    private static void permutation(int count, int start, int[] output, int[] input) {
        if (count == M) {
            for (int i : output) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            if(output[count] == input[i]) {
                continue;
            }
            output[count] = input[i];
            int idx = count + 1;
            while(idx < M) {
                output[idx++] = 0;
            }
            permutation(count + 1, i, output, input);
        }
    }
}
