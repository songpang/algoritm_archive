package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_15657 {
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

        permutation(0, output, inputArr, new boolean[N]);
        System.out.print(sb.toString());
    }

    private static void permutation(int count, int[] output, int[] input, boolean[] visited) {
        if (count == M) {
            for (int i : output) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        //1 7 9 9
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (output[count] == input[i]) {
                    visited[i] = false;
                    continue;
                }
                output[count] = input[i];
                int idx = count + 1;
                while(idx < M) {
                    output[idx++] = 0;
                }
                permutation(count + 1, output, input, visited);
                visited[i] = false;
            }
        }
    }
}
