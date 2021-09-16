package algoForBank;

import java.util.Scanner;

// 뒤에서 부터 채우면 1차원배열로 가능
// 하지만 어떤 것을 넣었는지는 체크 불가(?)
public class Knapsack_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();

        int[] weights = new int[N + 1];
        int[] profits = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            weights[i] = sc.nextInt();
            profits[i] = sc.nextInt();
        }

        int[] D = new int[W + 1];

        for (int i = 1; i <= N; i++) {
            for (int w = W; w >= weights[i]; w--) {
                D[w] = Math.max(D[w], profits[i] + D[w - weights[i]]);
            }
        }

        System.out.println(D[W]);
    }
}











