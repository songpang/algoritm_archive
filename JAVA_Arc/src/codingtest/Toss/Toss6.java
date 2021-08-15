package codingtest.Toss;

import java.util.ArrayList;
import java.util.List;

public class Toss6 {

    // target = 4일 경우
    // [1,1,1,1] [1, 1, 2] [1, 2, 1] ...
    // 총 7개, 모든 경우의 수를 찾아야함. (효율성 체크 있음)
    public static void main(String[] args) {
        solution(8);
    }

    static int stairCount = 0;
    public static long solution(int numOfStairs) {
        long answer = 0;
        perm(0, numOfStairs);
        int[] DP = new int[numOfStairs + 1];
        DP[0] = 1;
        DP[1] = 1;
        DP[2] = 2;

        for (int i = 3; i <= numOfStairs; i++) {
            DP[i] = DP[i - 1] + DP[i - 2] + DP[i - 3];
        }

        System.out.println(DP[numOfStairs]);
        System.out.println(stairCount);
        return stairCount;
    }


    public static void perm(int count, int amount) {
        if(amount == count) {
            stairCount++;
            return;
        }

        if(count > amount) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            perm(count + i, amount);
        }
    }
}
