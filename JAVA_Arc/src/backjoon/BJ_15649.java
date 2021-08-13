package backjoon;

import java.util.Scanner;

//N과 M ( Permutation 문제 )
public class BJ_15649 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        permutation(M, 0, new boolean[N], new int[M]);
    }

    private static void permutation(int m, int cnt, boolean[] visited, int[] output) {
        if(cnt == m) {
            for (int i : output) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[cnt] = i + 1;
                permutation(m, cnt + 1, visited, output);
                visited[i] = false;
            }
        }
    }
}
