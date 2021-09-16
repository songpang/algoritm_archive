package algoForBank;

import java.util.Scanner;

// 앞에서 부터 채우면 2차원 배열 이용해야함

public class Knapsack_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();

        int[] weights = new int[N+1];
        int[] profits = new int[N+1];

        for (int i = 1; i <= N; i++) {
            weights[i] = sc.nextInt();
            profits[i] = sc.nextInt();
        }

        int[][] D = new int[N+1][W+1];

        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <=W ; w++) {
                if(weights[i] <= w) { // 해당 물건을 가방에 넣을수 있다.
                    D[i][w] = Math.max(D[i-1][w], profits[i]+D[i-1][w-weights[i]]);
                }else {// 해당 물건을 가방에 넣을수 없다.
                    D[i][w] = D[i-1][w];
                }
            }
        }

        System.out.println(D[N][W]);
    }
}











