package codingtest.Toss;

import java.util.ArrayList;
import java.util.List;

public class Toss6 {

    public static void main(String[] args) {
        solution(3);
    }

    static int stairCount = 0;
    public static long solution(int numOfStairs) {
        long answer = 0;
//        perm(0, numOfStairs);

        for (int i = 0; i < numOfStairs; i++) {
            for (int j = 0; j < numOfStairs; j++) {
                for (int k = 0; k < numOfStairs; k++) {
                    if(i != k && j != k) {
                        stairCount++;
                    }
                }
            }
        }
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
