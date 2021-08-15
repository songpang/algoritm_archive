package leetcode;

public class LC_45_JumpGameII {
    static int minimum;

    public static void main(String[] args) {
        jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(minimum);
    }

    public static int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    // 현재
}
