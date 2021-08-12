package backjoon;

import java.util.Scanner;

public class BJ_15649 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        permutation(M, 0, new boolean[N], new int[N]);

    }

    private static void permutation(int m, int count, boolean[] visited, int[] output) {
        if(count == m) {
            for (int i = 0; i < visited.length; i++) {
                if(visited[i]) {
                    System.out.print(output[i] + " ");
                }
            }
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[count] = i + 1;
                permutation(m, count + 1, visited, output);
                visited[i] = false;

            }
        }
    }
}
