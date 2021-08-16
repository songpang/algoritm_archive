package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_15655 {
    static StringBuilder sb = new StringBuilder();
    static int[] output;
    static int N, M;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine();

        int[] inputArr = new int[N];
        int idx = 0;
        for (String s : scanner.nextLine().split(" ")) {
            inputArr[idx++] = Integer.parseInt(s);
        }
        Arrays.sort(inputArr);

        output = new int[M];

        permutation(0, inputArr, 0, new boolean[N]);
        System.out.print(sb.toString());
    }

    public static void permutation(int count, int[] arr, int start, boolean[] visited) {
        if (M == count) {
            for (int i : output) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[count] = arr[i];
                permutation(count + 1, arr, i + 1, visited);
                visited[i] = false;
            }
        }
    }
}