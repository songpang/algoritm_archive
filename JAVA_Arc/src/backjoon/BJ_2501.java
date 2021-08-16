package backjoon;

import java.util.Scanner;

public class BJ_2501 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, K;
        N = scanner.nextInt();
        K = scanner.nextInt();

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if(N % i == 0) {
                K--;
                if(K == 0) {
                    result = i;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
