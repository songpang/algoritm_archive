package leetcode;

import java.util.Arrays;

public class LC_1300_SumOfMutatedArrayColosestToTarget {
    public int findBestValue(int[] A, int target) {
        Arrays.sort(A);
        int n = A.length, i = 0;

        while (i < n && target > A[i] * (n - i)) {
            target -= A[i++];
        }

        if (i == n)
            return A[n - 1];

        int res = target / (n - i);
        if (target - res * (n - i) > (res + 1) * (n - i) - target)
            res++;

        return res;
    }
}
