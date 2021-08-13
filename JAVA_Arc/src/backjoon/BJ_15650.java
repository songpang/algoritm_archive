package backjoon;

import java.util.Scanner;

public class BJ_15650 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        combination(M, 0, new boolean[N]);
    }

    private static void combination(int r, int start, boolean[] visited) {
        if(r == 0) {
            for (int i = 0; i < visited.length; i++) {
                if(visited[i]) {
                    System.out.print(i + 1 + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = start; i < visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination(r - 1, i + 1, visited);
                visited[i] = false;
            }
        }
    }
}
