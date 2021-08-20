package backjoon;

import java.util.Scanner;

public class BJ_2581 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        for (int i = N; i <= M; i++) {
            for (int j = 1; j < i / 2; j++) {
                if(i % j == 0) {
                    break;
                }
            }


        }

    }
}
